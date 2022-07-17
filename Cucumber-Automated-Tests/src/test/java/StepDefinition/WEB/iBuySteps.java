package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class iBuySteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(iBuySteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    String tradeAccountNumber;

    public iBuySteps(ContextStore context) {
        this.context = context;
    }

    @And("^.* enter new Company name.*$")
    public void enterNewCompanyName() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "iBuyAddCompany.addCompanyName_textbox"
        );

        String companyName = actionMethods.generateRandomNumberString("Cmp");
        this.context.iBuyCompanyName = companyName;
        actionMethods.enterText(companyName, "iBuyAddCompany.addCompanyName_textbox");
        context.scenario.log("iBuy Organisation : " + companyName);
    }

    @And("^.*enter Trade account Account number using given file \"([^\"]*)\"$")
    public void enter_account_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);
        tradeAccountNumber = testData.get(0).get("billIBuyAccountNumber");
        actionMethods.enterText(
            tradeAccountNumber,
            "iBuyRetrieveAccount.accountNumber_textbox"
        );
        context.scenario.log("trade account number: " + tradeAccountNumber);
    }

    @SuppressWarnings("deprecation")
    @Then("^.* company name .* element \"([^\"]*)\".*$")
    public void verify_companyName(String locator) throws Throwable {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            locator
        );
        //actionMethods.waitForAttributeToContain(this.context.constants.getShortWaitSeconds(), locator, "value", context.iBuyCompanyName);

        String act_Value = actionMethods.getValueUsingAttribute(locator, "innerText");
        if (act_Value.isEmpty()) {
            act_Value = actionMethods.getValueUsingAttribute(locator, "value");
        }
        logger.info("Actual Company name: " + act_Value);
        context.scenario.log("iBuy Company name : " + act_Value);
        Assert.assertTrue(
            "Company name is not as expected",
            act_Value.contains(context.iBuyCompanyName)
        );
    }

    @Then("^.* account number .* element \"([^\"]*)\".*$")
    public void verify_accountNumber(String locator) throws Throwable {
        String value = actionMethods.getValueUsingAttribute(locator, "innerText");
        context.scenario.log("iBuy Company Account number : " + value);
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            locator
        );
        actionMethods.waitForAttributeToContain(
            this.context.constants.getShortWaitSeconds(),
            locator,
            "innerText",
            tradeAccountNumber
        );
    }
}
