package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class ChangeCountrySteps extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(ChangeCountrySteps.class);
    private ContextStore context;
    String store = getStore();

    public ChangeCountrySteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify Expected URL matches with Current URL$")
    public void verifyURL() throws Exception {
        String expectedStore;
        if (!store.equalsIgnoreCase("au")) {
            expectedStore = "au";
        } else {
            expectedStore = "hk";
        }

        String actualStore = getStore();
        logger.info("Current store: " + actualStore);
        Assert.assertEquals(
            "Current country URL is not displayed",
            expectedStore,
            actualStore
        );
    }

    @And("^.*select Country from dropdown \"([^\"]*)\"$")
    public void enter_account_details(String locator) throws Exception {
        if (!actionMethods.getStore().equalsIgnoreCase("au")) {
            actionMethods.selectValueByIndex(0, locator);
        } else actionMethods.selectValueByIndex(13, locator);
        context.scenario.log("Selected Country Name " + getStore());
    }

    @Then(
        "^customer open \"([^\"]*)\" and verify if that is converted to \"([^\"]*)\" for \"([^\"]*)\" in \"([^\"]*)\" store$"
    )
    public void validate_url_redirection_config(
        String url,
        String expectedURL,
        String page,
        String store
    ) throws InterruptedException {
        context.scenario.log("Entered URL: " + url);
        //    	driver.navigate().to(url);
        //    	Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        context.scenario.log("Current URL: " + actualURL);
        Assert.assertEquals(
            "Page is not navigated to correct URL, CurrentURL: " +
            actualURL +
            " but its should convert to: " +
            expectedURL +
            " for " +
            store +
            " in " +
            page,
            expectedURL,
            actualURL
        );
        context.scenario.log(
            "Page is successfully navigated to " +
            actualURL +
            " for " +
            store +
            " in " +
            page
        );
    }
}
