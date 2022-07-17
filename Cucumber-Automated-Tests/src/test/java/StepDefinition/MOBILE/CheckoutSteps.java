package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.java.en.And;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class CheckoutSteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public CheckoutSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*fill mobile checkout your details in address section using given file \"([^\"]*)\"$"
    )
    public void enter_your_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String emailAddress = testData.get(0).get("billEmail");

        logger.info("File values :" + firstName + "," + lastName + "," + emailAddress);

        actionMethods.enterText(firstName, "Checkout.firstName_textbox");
        context.scenario.log("First Name : " + firstName);
        actionMethods.enterText(lastName, "Checkout.lastName_textbox");
        context.scenario.log("Last Name : " + lastName);
        actionMethods.enterText(emailAddress, "Checkout.email_textbox");
        context.scenario.log("Email : " + emailAddress);
        ContextStore.ORDER_TRACKING_EMAIL = emailAddress;

        actionMethods.selectValueByIndex(3, "Checkout.primaryRole_dropdown");
        actionMethods.selectValueByIndex(3, "Checkout.primaryUse_dropdown");
    }

    @And(
        "^.*fill mobile checkout Invoice or billing address manually using given file \"([^\"]*)\"$"
    )
    public void enter_Invoice_address(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String companyName = testData.get(0).get("billCompanyName");
        String officeName = testData.get(0).get("billOfficeName");
        String officePhone = testData.get(0).get("billOfficePhone");
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String province = testData.get(0).get("billProvince");
        String zipCode = testData.get(0).get("billPostCode");
        String email = testData.get(0).get("accountsEmailBuisness");

        if (uiMethods.verifyElementExistence("Checkout.firstName_textbox")) {
            actionMethods.enterText(firstName, "Checkout.firstName_textbox");
            context.scenario.log("FirstName :" + firstName);
        }

        if (uiMethods.verifyElementExistence("Checkout.lastName_textbox")) {
            actionMethods.enterText(lastName, "Checkout.lastName_textbox");
            context.scenario.log("LastName :" + lastName);
        }

        if (uiMethods.verifyElementExistence("Checkout.companyName_textbox")) {
            actionMethods.enterText(companyName, "Checkout.companyName_textbox");
            context.scenario.log("CompanyName :" + companyName);
        }

        // for china condition
        if (officeName == null || officeName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(officeName, "Checkout.officeName_textbox");
            actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
        }
        actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
        context.scenario.log("AddressLine1 :" + addressLine1);
        actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
        context.scenario.log("AddressLine2 :" + addressLine2);
        actionMethods.enterText(city, "Checkout.townCity_textbox");
        context.scenario.log("City :" + city);

        if (province == null || province.equalsIgnoreCase("skip")) {} else {
            if (context.constants.getStateDropdownStores().contains(getStore())) {
                actionMethods.selectValueByText(
                    province.trim(),
                    "Checkout.state_dropdown"
                );
            } else {
                actionMethods.enterText(province, "Checkout.countryProvince_textbox");
            }
            context.scenario.log("Province :" + province);
        }
        actionMethods.enterText(zipCode, "Checkout.zipCode_textbox");
        context.scenario.log("Zipcode :" + zipCode);
        ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

        if (uiMethods.verifyElementExistence("Checkout.email_textbox")) {
            actionMethods.enterText(email, "Checkout.email_textbox");
            context.scenario.log("Email :" + email);
        }
    }

    @And("^.*fill Credit Card Details in mobile using given file \"([^\"]*)\"$")
    public void enter_CreditCard_Details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String creditCardNum = testData.get(0).get("billCardNumber");
        String expiryMonth = testData.get(0).get("billCardExpiryMonth");
        String expiryYear = testData.get(0).get("billCardExpiryYear");
        String securityNum = testData.get(0).get("billCardSecurityNumber");
        String nameOnCard = testData.get(0).get("billNameOnCard");
        String cardHolderPhone = testData.get(0).get("billCardHolderPhone");

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(creditCardNum, "Checkout.creditCardNum_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-card-1");
            actionMethods.enterText(
                creditCardNum,
                "Checkout.creditCardNumWebtokenize_textbox"
            );
            driver.switchTo().parentFrame();
        }
        context.scenario.log("CreditCardNum :" + creditCardNum);

        actionMethods.enterText(expiryMonth, "Checkout.expiryMonth_dropdown");
        context.scenario.log("expiryMonth :" + expiryMonth);
        actionMethods.enterText(expiryYear, "Checkout.expiryYear_dropdown");
        context.scenario.log("expiryYear :" + expiryYear);

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframe");
            actionMethods.enterText(securityNum, "Checkout.cvvWebtokenize_textbox");
            driver.switchTo().parentFrame();
        }
        context.scenario.log("securityNum :" + securityNum);

        actionMethods.enterText(nameOnCard, "Checkout.nameOnCard_textbox");
        context.scenario.log("nameOnCard :" + nameOnCard);
        actionMethods.enterText(cardHolderPhone, "Checkout.cardHolderPhone_textbox");
        context.scenario.log("cardHolderPhone :" + cardHolderPhone);
        Thread.sleep(3000);
    }

    @And(
        ".*selects special instructions \"([^\"]*)\" from dropdown and enter instructions if any$"
    )
    public void select_special_instructions(String value) throws Exception {
        if (!getRegionName().equalsIgnoreCase("newark")) {
            actionMethods.selectValueByValue(
                value,
                "Checkout.specialInstruction_dropdown"
            );
            if (value.equalsIgnoreCase("other")) {
                actionMethods.enterText(
                    this.context.constants.getSpecialInstructions(),
                    "Checkout.specialDeliveryInstructions_textbox"
                );
            }
        }
    }
}
