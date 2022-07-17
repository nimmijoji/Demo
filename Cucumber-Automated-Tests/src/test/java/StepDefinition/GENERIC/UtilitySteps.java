package StepDefinition.GENERIC;

import Common.UTILS.ContextStore;
import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.List;
import java.util.Set;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class UtilitySteps extends WebDriverConfig {

    WebDriver driver = getDriver();
    private static final Logger logger = LogManager.getLogger(UtilitySteps.class);

    private ContextStore context;

    public UtilitySteps(ContextStore context) {
        this.context = context;
    }

    @When("^I close browser$")
    public void closeBrowser() throws IOException {
        driver.close();
    }

    @When("^.*refresh browser.*$")
    public void refreshBrowser() throws IOException {
        driver.navigate().refresh();
    }

    @When("^I quit all browsers$")
    public void quitBrowser() throws IOException {
        driver.quit();
    }

    @When("^.*take screenshot.*$")
    public void takeScreenshot() throws IOException {
        context.scenario.attach(
            ScreenshotUtil.getByteScreenshot(),
            "image/png",
            "screenshot"
        );
    }

    @When("^.*navigate to \"(.*?)\" page$")
    public void navigateToPage(String valueToAppend) throws Throwable {
        String baseURL = driver.getCurrentUrl().split(".com")[0] + ".com";
        driver.get(baseURL + "/" + valueToAppend);
    }

    @Then("^.*wait for \"(.*?)\" seconds$")
    public void waitForSeconds(Long sec) throws Throwable {
        Thread.sleep(sec * 1000);
    }

    @And("^.*wait \"(.*?)\" duration for \"(.*?)\" element to .*\"(.*?)\"$")
    public void waitForSeconds(String waitType, String locator, String criteria)
        throws Throwable {
        long sec = 0;
        if (waitType.equalsIgnoreCase("long")) {
            sec = this.context.constants.getLongWaitSeconds();
        } else if (waitType.equalsIgnoreCase("medium")) {
            sec = this.context.constants.getMediumWaitSeconds();
        } else {
            sec = this.context.constants.getShortWaitSeconds();
        }

        switch (criteria.toLowerCase()) {
            case "appear":
                actionMethods.waitForElementToAppear(sec, locator);
                break;
            case "disappear":
                sec = this.context.constants.getShortWaitSeconds();
                actionMethods.waitForElementToDisappear(sec, locator);
                break;
        }
    }

    @And("^.*click.* \"([^\"]*)\" refreshed element$")
    public void clickOnRefreshedElement(String locator) throws Exception {
        actionMethods.waitForElemenToGetRefreshed(
            this.context.constants.getShortWaitSeconds(),
            locator
        );
        actionMethods.click(locator);
    }

    @And("^.*click.* \"([^\"]*)\"$")
    public void click(String locator) throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            locator
        );
        actionMethods.click(locator);
    }

    @And("^.*click.* \"([^\"]*)\" without wait$")
    public void clickWithoutWait(String locator) throws Exception {
        actionMethods.click(locator);
    }

    @And("^.*navigates to url \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @And("^.*navigates back in the browser$")
    public void navigateBack() {
        driver.navigate().back();
    }

    @And("^.*click.* \"([^\"]*)\" using js$")
    public void clickUsingJs(String locator) throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            locator
        );
        actionMethods.clickUsingJSExecutor(locator);
    }

    @And("^.*clears text from textbox \"([^\"]*)\"$")
    public void clearText(String locator) throws Exception {
        WebElement elementObj = getLocator(locator);
        elementObj.click();
        elementObj.clear();
    }

    // Method to enter single text in single text box
    @And("^.*enter.* value \"([^\"]*)\" in textbox \"([^\"]*)\"$")
    public void enterText(String value, String locator) throws Exception {
        actionMethods.enterText(value, locator);
    }

    // Method to enter two values in single step
    @And(
        "^.*enter.* values \"([^\"]*)\" and \"([^\"]*)\" in textbox \"([^\"]*)\" and \"([^\"]*)\" respectively.$"
    )
    public void enterTwoText(
        String value1,
        String value2,
        String locator1,
        String locator2
    ) throws Exception {
        actionMethods.enterText(value1, locator1);
        actionMethods.enterText(value2, locator2);
    }

    @And("^.*scroll till \"([^\"]*)\"$")
    public void scrollToAnyWhere(String locator) throws Exception {
        uiMethods.scrollToAnyWhere(locator);
    }

    @And("^.*scroll to \"([^\"]*)\" and verify text \"([^\"]*)\" is present$")
    public void scrollAndVerifyText(String locator, String text) throws Exception {
        Boolean ActualText = uiMethods.ScrollAndVerifyText(locator, text);
        Assert.assertTrue(ActualText.equals(true));
    }

    @And("^.*select by visible text.* \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void selectValueByText(String name, String locator) throws Exception {
        actionMethods.selectValueByText(name, locator);
    }

    @And("^.*select by option.* \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void selectValueByValue(String option, String locator) throws Exception {
        actionMethods.selectValueByValue(option, locator);
    }

    @And("^.*select by index.* \"([^\"]*)\" from dropdown \"([^\"]*)\"$")
    public void selectValueByIndex(int index, String locator) throws Exception {
        actionMethods.selectValueByIndex(index, locator);
    }

    @And("^I can see the log entry of the page$")
    public void log_entry() {
        // Mentioning type of Log
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        // Retrieving all log
        List<LogEntry> logs = entry.getAll();
        // Print one by one
        for (LogEntry e : logs) {
            logger.info(e);
        }

        // Printing details separately
        for (LogEntry e : logs) {
            logger.info("Message is: " + e.getMessage());
            context.scenario.log("Message is: " + e.getMessage());
            logger.info("Level is: " + e.getLevel());
            context.scenario.log("Level is: " + e.getLevel());
            context.scenario.log(
                "========================================================"
            );
        }
    }

    @And("^.*hover on element.* \"([^\"]*)\"$")
    public void clickAndHover(String locator) throws Exception {
        actionMethods.clickAndHover(locator);
    }

    @And("^.*scroll down the page by pixels \"([^\"]*)\"$")
    public void scrollDownPage(double value) throws Exception {
        actionMethods.scrollDownPage(value);
    }

    @And("^.*scroll up the page by pixels \"([^\"]*)\"$")
    public void scrollUpPage(double value) throws Exception {
        actionMethods.scrollUpPage(value);
    }

    @And("^.*switch to .*window$")
    public void switchToWindow() {
        actionMethods.switchToWindow();
    }

    @And("^.*wait \"([^\"]*)\" seconds for .*new window$")
    public void waitForNewWindow(int timeoutSeconds) {
        boolean flag = false;
        int counter = 0;
        while (!flag) {
            try {
                Set<String> winId = driver.getWindowHandles();
                if (winId.size() > 1) {
                    flag = true;
                    break;
                }
                Thread.sleep(1000);
                counter++;
                if (counter > timeoutSeconds) {
                    break;
                }
            } catch (Exception e) {
                logger.info("Timed out new window wait. " + e.getMessage());
                this.context.scenario.log("New window did not open");
            }
        }
    }

    @And("^.*switch to \"([^\"]*)\" frame$")
    public void switchToFrame(String locator) throws Exception {
        WebElement Frame = actionMethods.getLocator(locator);
        actionMethods.getDriver().switchTo().frame(Frame);
    }

    @And("^.*switch to default frame$")
    public void switchToDefault() throws Exception {
        actionMethods.getDriver().switchTo().defaultContent();
    }

    @And("^I press the tab key in \"([^\"]*)\"$")
    public void pressTabKey(String locator) throws Exception {
        actionMethods.pressTabKey(locator);
    }

    @And("^I press shift and tab in \"([^\"]*)\"$")
    public void pressShiftTabKey(String locator) throws Exception {
        actionMethods.pressShiftTabKey(locator);
    }

    @And("^I move to \"([^\"]*)\" OnOffset and click.$")
    public void click_On_cordinates(String Locator) throws Exception {
        Point point = getLocator(Locator).getLocation();
        int xcord = point.getX();
        System.out.println(
            "Position of the webelement from left side is " + xcord + " pixels"
        );
        int ycord = point.getY();
        actionMethods.clickOnOffset(xcord, ycord);
        System.out.println(
            "Position of the webelement from right side is " + ycord + " pixels"
        );
    }
}
