package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NullResultsSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(HomeSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public NullResultsSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I verify null result page is displayed$")
    public void verifyNullSearchPageDisplayed() {
        Assert.assertTrue(
            "Null result Page is not Displayed",
            uiMethods.isElementDisplayed("NullResultPage.Nullresultpage")
        );
    }

    @And("^I verify error message contains search term$")
    public void SearchMessage() throws Exception {
        String region = getRegionName();
        String actualMessageElement = null;
        String actualText = null;
        if (region.equalsIgnoreCase("EUROPE")) {
            actualMessageElement =
                actionMethods.getLocatorString("NullResultPage.searchMessage_label");
        } else if ((region.equalsIgnoreCase("APAC"))) {
            actualMessageElement =
                actionMethods.getLocatorString("NullResultPage.SearchAPAC_label");
        } else if ((region.equalsIgnoreCase("Newark"))) {
            actualMessageElement =
                actionMethods.getLocatorString("NullResultPage.SearchUS_label");
        }
        actualText =
            actionMethods
                .getDriver()
                .findElement(By.xpath(actualMessageElement))
                .getText();
        System.out.println(actualText);
        String ExpectedText = this.context.constants.getNullResultsMessage();
        Assert.assertTrue(actualText.contains(ExpectedText));
    }

    @And("^I verify the espot image is available on null result page$")
    public void Enter_Text_searchBox() {
        Assert.assertTrue(
            "Espot image is unavailable",
            uiMethods.isElementDisplayed("NullResultPage.espot_Image")
        );
    }

    @And(
        "^I verify if the enter \"([^\\\"]*)\" is part of the string that u see on the top of the page$"
    )
    public void verifySearchedKeywordInSearchMessage(String value) throws Exception {
        String searchTerm_xpath = actionMethods.getLocatorString(
            "NullResultPage.searchTerm_label"
        );
        String searchTerm = actionMethods
            .getDriver()
            .findElement(By.xpath(searchTerm_xpath))
            .getText();
        Assert.assertEquals("String is not matched", value, searchTerm);
    }
}
