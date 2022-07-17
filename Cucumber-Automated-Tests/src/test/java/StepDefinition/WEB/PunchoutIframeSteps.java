package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class PunchoutIframeSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public PunchoutIframeSteps(ContextStore context) {
        this.context = context;
    }

    @Given("^verify user \"([^\"]*)\" is logged in$")
    public void user_logged_In(String firstNameLocator) throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            firstNameLocator
        );

        String value = actionMethods.getValue(firstNameLocator);
        context.scenario.log("User is logged in to its account:" + value);
        Assert.assertTrue(!value.equalsIgnoreCase(""));
    }

    @And("^switch to \"([^\"]*)\" iframe")
    public void switch_To_Frame(String iframeIdName) {
        driver.switchTo().frame(iframeIdName);
    }
}
