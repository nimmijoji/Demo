package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class PLPSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(PLPSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public PLPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I save the value of First Order code from PLP table$")
    public void save_first_order_code() throws Exception {
        this.context.PLP_FIRST_ORDER_CODE =
            actionMethods.getValue("PLP.firstPurchasableOrderCode_text");
        this.context.scenario.log(
                "Value of purchasable Ordercode/SKU obtained: " +
                this.context.PLP_FIRST_ORDER_CODE
            );
    }

    @Then(
        "^I switched on Rohs window and verify customer name in application and Rohs Certificate$"
    )
    public void switche_on_rohs_Window_and_verify_customer_name() throws Exception {
        //uiMethods.scrollToAnyWhere("Header.userFirstName_text");
        String Firstname = actionMethods
            .getValue("Header.userFirstName_text")
            .toLowerCase();
        logger.info("User Name from Header: " + Firstname);
        actionMethods.switchToWindow();
        uiMethods.scrollToAnyWhere("PLP.rohsCustomerName_text");
        String customernameOnCertificate = actionMethods
            .getValue("PLP.rohsCustomerName_text")
            .toLowerCase();
        logger.info("Customer Name from RoHSCertificate: " + customernameOnCertificate);
        Assert.assertTrue(customernameOnCertificate.contains(Firstname));
    }

    @Given("^.*verify \"([^\"]*)\" products are listed in products table \"([^\"]*)\"$")
    public void verify_number_of_product_display(int size, String locators)
        throws Exception {
        List<WebElement> checkBoxes = actionMethods.getMutipleLocators(locators);
        int countCheckbox = checkBoxes.size();
        Assert.assertEquals(
            size + " Items are not available on page",
            size,
            countCheckbox
        );
    }

    @And("^.* select instock sub radio button \"([^\"]*)\" if available")
    public void click_instock_sub_radio_button(String locator) throws Exception {
        if (!getStore().equalsIgnoreCase("uk")) {
            actionMethods.waitForElemenToGetRefreshed(
                this.context.constants.getShortWaitSeconds(),
                locator
            );
            actionMethods.click(locator);
        }
    }

    @And("^.* save the details of \"([^\"]*)\" product from PLP table")
    public void save_product_details(int numOfProducts) throws Exception {
        List<String> productDetails_list = new ArrayList<>();

        for (int i = 1; i <= numOfProducts; i++) {
            String orderCode_Xpath =
                actionMethods.getLocatorString("PLP.productRowPartial_element") +
                "[" +
                i +
                "]" +
                "/td[3]/p";
            productDetails_list.add(
                actionMethods.getDriver().findElement(By.xpath(orderCode_Xpath)).getText()
            );

            String manuName_xpath =
                actionMethods.getLocatorString("PLP.manufacturerName_text") +
                "[" +
                i +
                "]";
            productDetails_list.add(
                actionMethods.getDriver().findElement(By.xpath(manuName_xpath)).getText()
            );

            String manuPartNo_xpath =
                actionMethods.getLocatorString("PLP.allManufacturerPartNo_link") +
                "[" +
                i +
                "]";
            productDetails_list.add(
                actionMethods
                    .getDriver()
                    .findElement(By.xpath(manuPartNo_xpath))
                    .getText()
            );
        }
        this.context.productDetails.put("ProductDetails", productDetails_list);
        this.context.scenario.log(
                "Product details  obtained: " +
                this.context.productDetails.get("ProductDetails")
            );
    }

    @And("^.* select first \"([^\"]*)\" checkbox from PLP table")
    public void select_checkbox(int numOfCheckbox) throws Exception {
        for (int i = 1; i <= numOfCheckbox; i++) {
            String orderCoder_Xpath =
                actionMethods.getLocatorString("PLP.allCompareCheck_checkbox") +
                "[" +
                i +
                "]";
            actionMethods.getDriver().findElement(By.xpath(orderCoder_Xpath)).click();
        }
    }
}
