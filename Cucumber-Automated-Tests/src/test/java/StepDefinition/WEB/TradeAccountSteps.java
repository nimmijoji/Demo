package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

public class TradeAccountSteps extends WebDriverConfig {

    private ContextStore context;

    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public TradeAccountSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*fill Customer details in Apply for Trade Account page$")
    public void enter_your_details() throws Exception {
        if (getStore().equalsIgnoreCase("uk")) {
            actionMethods.selectValueByIndex(3, "TradeAccount.jobRole_dropdown");
            context.scenario.log("primaryRole dropdown value index 3");
            actionMethods.selectValueByIndex(1, "TradeAccount.accountType_dropdown");
            context.scenario.log("primary use dropdown value index 3");
        } else {
            this.context.scenario.log("NA for this store");
        }
    }

    @And("^.*fill Invoice address in Trade Account page using given file \"([^\"]*)\"$")
    public void enter_Invoice_address(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String province = testData.get(0).get("billProvince");
        String zipCode = testData.get(0).get("billPostCode");
        actionMethods.enterText(addressLine1, "TradeAccount.address1_textbox");
        context.scenario.log("AddressLine1 :" + addressLine1);
        actionMethods.enterText(addressLine2, "TradeAccount.address2_textbox");
        context.scenario.log("AddressLine2 :" + addressLine2);
        actionMethods.enterText(city, "TradeAccount.townCity_textbox");
        context.scenario.log("City :" + city);
        actionMethods.enterText("9899888889", "TradeAccount.landlinePhoneNumber_textbox");
        context.scenario.log("officePhone : 9899888889");
        actionMethods.enterText(province, "TradeAccount.county_textbox");
        context.scenario.log("Province :" + province);
        actionMethods.enterText(zipCode, "TradeAccount.postcode_textbox");
        context.scenario.log("Zipcode :" + zipCode);
        //ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

    }

    @And("^.*fill Company Details for New Trade Account using given file \"([^\"]*)\"$")
    public void enter_additional_information_Details(String FileName) throws Exception {
        if (
            getRegionName().equalsIgnoreCase("europe") ||
            getStore().equalsIgnoreCase("hk")
        ) {
            String path = FilePath + FileName;

            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

            String monthlySpend = testData.get(0).get("monthlySpend");
            String fullCompanyNameBuisness = testData
                .get(0)
                .get("fullCompanyNameBuisness");
            String legalEntity = testData.get(0).get("legalEntity");
            String accountsEmailBuisness = testData.get(0).get("accountsEmailBuisness");
            actionMethods.enterText(
                monthlySpend,
                "TradeAccount.averageMonthlySpend_textbox"
            );
            context.scenario.log(
                "Anticipated average monthly spend in GBP(given currency) :" +
                monthlySpend
            );
            actionMethods.enterText(
                fullCompanyNameBuisness,
                "TradeAccount.companyTradingName_textbox"
            );
            context.scenario.log("Full Company Trading Name :" + fullCompanyNameBuisness);
            actionMethods.selectValueByIndex(1, "TradeAccount.legalTradingEntry_list");
            context.scenario.log("Legal Trading Entity :" + legalEntity);
            actionMethods.enterText(
                accountsEmailBuisness,
                "TradeAccount.accountPayableEmail_textbox"
            );
            context.scenario.log(
                "Finance/Accounts Payable Email Address :" + accountsEmailBuisness
            );
        }
    }
}
