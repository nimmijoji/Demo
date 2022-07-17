package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import StepDefinition.GENERIC.UtilitySteps;
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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class OrderHistoryAndTrackingSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public OrderHistoryAndTrackingSteps(ContextStore context) {
        this.context = context;
    }

    @SuppressWarnings("static-access")
    @And("^.*order history table is displayed.*$")
    public void VerifyOrderHistoryTableInMyAccount() throws Exception {
        long initialSeconds = actionMethods.getEpochSeconds();
        long currentSeconds = 0;
        UtilitySteps utilitySteps = new UtilitySteps(context);
        do {
            currentSeconds = actionMethods.getEpochSeconds();
            utilitySteps.refreshBrowser();
        } while (
            !(uiMethods.isElementDisplayed("OrderHistory.orderHistory_table")) ||
            ((currentSeconds - initialSeconds) >= 120)
        );
    }
}
