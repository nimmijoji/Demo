package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorsAndChartsSteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(
        CalculatorsAndChartsSteps.class
    );
    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public CalculatorsAndChartsSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify CalculatorsAndCharts page products from file \"([^\"]*)\"$")
    public void validate_CalProducts(String FileName) throws Exception {
        String path = FilePath + FileName + ".xlsx";
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        List<WebElement> elementObj = getMutipleLocators(
            "CalcuatorsAndCharts.products_element"
        );
        List<String> pdtMissing = new ArrayList<String>();
        int missingCount = 0;
        System.out.println(testData.size() - 1);
        System.out.println(elementObj.size());

        for (int i = 1; i <= elementObj.size(); i++) {
            Boolean flag = false;
            String heading_Xpath =
                actionMethods.getLocatorString("CalcuatorsAndCharts.products_element") +
                "[" +
                i +
                "]" +
                "/h3";
            WebElement heading_elementObj = actionMethods
                .getDriver()
                .findElement(By.xpath(heading_Xpath));
            String actual_pdtHeading = heading_elementObj.getText().trim();
            System.out.println("actual_pdtHeading: " + actual_pdtHeading);

            for (int j = 0; j < testData.size(); j++) {
                if (testData.get(j).get("Heading").equals(actual_pdtHeading)) {
                    String exp_pdtHeading = testData.get(j).get("Heading");
                    String exp_Desc = testData.get(j).get("Description").trim();
                    String exp_button = testData.get(j).get("Button").trim();
                    String exp_MenuHeading = testData.get(j).get("MenuHeading").trim();
                    String exp_URLText = testData.get(j).get("URL").trim();
                    String exp_MenuButtonType = testData.get(j).get("ButtonType").trim();
                    logger.info("Product found in file: " + actual_pdtHeading);

                    // to verify product image is displayed
                    verifyPdtImg(i, actual_pdtHeading);
                    // to verify product description
                    verifyPdtDescription(i, exp_Desc, actual_pdtHeading);
                    // to verify product button
                    verifyPdtButton(i, exp_button, actual_pdtHeading);
                    // to verify product page heading
                    verifyPdtPageHeading(i, exp_MenuHeading, actual_pdtHeading);
                    // to verify product page URL
                    verifyPdtPageURL(exp_URLText);
                    // to click On back to Calculators page
                    clickBackToMainMenuButton(exp_MenuButtonType);

                    this.context.scenario.log(
                            "Product-" +
                            i +
                            ":" +
                            actual_pdtHeading +
                            " image,description,menuButton,pdtPageHeading,pdtPageURL verified"
                        );
                    flag = true;
                    break;
                }
            }
            //if product not found in file then adds to list
            if (flag == false) {
                pdtMissing.add(actual_pdtHeading);
                missingCount++;
                this.context.scenario.log(
                        "Product-" + i + ":" + actual_pdtHeading + " not found in file"
                    );
                //				Assert.assertTrue(actual_pdtHeading+" heading not found in file", flag.equals(true));
            }
        }
        //prints the list of products not found in file, if any
        if (missingCount > 0) {
            this.context.scenario.log("Products not found in file: " + pdtMissing);
            Assert.assertTrue(" Product heading not found in file", missingCount == (0));
        }
    }

    private void verifyPdtImg(int i, String actual_pdtHeading) throws Exception {
        String img_Xpath =
            actionMethods.getLocatorString("CalcuatorsAndCharts.products_element") +
            "[" +
            i +
            "]" +
            "/a[1]";
        WebElement img_elementObj = actionMethods
            .getDriver()
            .findElement(By.xpath(img_Xpath));
        Assert.assertTrue(
            actual_pdtHeading + " product image not present",
            img_elementObj.isDisplayed()
        );
    }

    private void verifyPdtDescription(int i, String exp_Desc, String actual_pdtHeading)
        throws Exception {
        String description_Xpath =
            actionMethods.getLocatorString("CalcuatorsAndCharts.products_element") +
            "[" +
            i +
            "]" +
            "/p";
        WebElement description_elementObj = actionMethods
            .getDriver()
            .findElement(By.xpath(description_Xpath));
        String desc = description_elementObj.getText();
        Assert.assertTrue(
            actual_pdtHeading + " product heading not present",
            exp_Desc.equals(desc)
        );
    }

    private void verifyPdtButton(int i, String exp_button, String actual_pdtHeading)
        throws Exception {
        String calMenu_button =
            actionMethods.getLocatorString("CalcuatorsAndCharts.products_element") +
            "[" +
            i +
            "]" +
            "//a[contains(@class,'btn btn-tertiary')]";
        WebElement calMenuButton_elementObj = actionMethods
            .getDriver()
            .findElement(By.xpath(calMenu_button));
        String btn = calMenuButton_elementObj.getText();
        Assert.assertTrue(
            actual_pdtHeading + " product button not present",
            exp_button.equals(btn)
        );
        calMenuButton_elementObj.click();
    }

    private void verifyPdtPageHeading(
        int i,
        String exp_MenuHeading,
        String actual_pdtHeading
    ) throws Exception {
        Assert.assertTrue(
            "Product heading not present",
            uiMethods.isElementDisplayed("CalcuatorsAndCharts.menuHeader_element")
        );
        String menuHeader = actionMethods.getValue(
            "CalcuatorsAndCharts.menuHeader_element"
        );
        Assert.assertTrue(
            actual_pdtHeading + " product page heading not as expected",
            exp_MenuHeading.equals(menuHeader)
        );
    }

    private void verifyPdtPageURL(String exp_URLText) {
        String act_Url = driver.getCurrentUrl();
        String baseUrl = getSiteBaseUrl();
        String exp_Url = baseUrl.concat(exp_URLText);
        System.out.println("exp_Url:" + exp_Url);
        System.out.println("actual_Url:" + act_Url);
        Assert.assertTrue(
            act_Url + " string is not present in the URL",
            exp_Url.equals(act_Url)
        );
    }

    private void clickBackToMainMenuButton(String exp_MenuButtonType) throws Exception {
        if (exp_MenuButtonType.equalsIgnoreCase("TypeOne")) actionMethods.click(
            "CalcuatorsAndCharts.calChartsMenu_button"
        ); else if (exp_MenuButtonType.equalsIgnoreCase("TypeTwo")) actionMethods.click(
            "CalcuatorsAndCharts.calMenuTool_button"
        ); else if (exp_MenuButtonType.equalsIgnoreCase("TypeThree")) actionMethods.click(
            "CalcuatorsAndCharts.mainMenu_button"
        ); else logger.info("ButtonType not clickable: " + exp_MenuButtonType);
        Assert.assertTrue(
            "CalcuatorsAndCharts header element not present",
            uiMethods.isElementDisplayed("CalcuatorsAndCharts.header_element")
        );
    }
}
