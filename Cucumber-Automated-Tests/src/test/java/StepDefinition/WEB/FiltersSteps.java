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
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class FiltersSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public FiltersSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*get the Products found count before applying filters$")
    public void preFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.PRE_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
    }

    @And("^.*verify the Products found count after applying filters$")
    public void postFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.POST_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
        Assert.assertTrue(
            "Filter is not selected",
            Integer.parseInt(this.context.POST_FILTER_COUNT) <
            Integer.parseInt(this.context.PRE_FILTER_COUNT)
        );
    }

    @And("^.*verify the Products found count after clearing all the filters$")
    public void matchFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.POST_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
        Assert.assertTrue(
            "Clear all filters is not giving right product count",
            this.context.POST_FILTER_COUNT.equalsIgnoreCase(this.context.PRE_FILTER_COUNT)
        );
    }

    // Below 2 methods will moved to generic methods prior discussions -- Divya
    @And("^.*get the products found count.*$")
    public void getProductCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.ProductCount =
            actionMethods.getValue("Search.productsHeader_text").replaceAll("[,'. ]", "");
    }

    @And("^.*verify the product count equal.*$")
    public void verfiyProductCountIsEqual() throws Exception {
        this.context.ProductCountInitial = this.context.ProductCount;
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.ProductCountLater =
            actionMethods.getValue("Search.productsHeader_text").replaceAll("[,'. ]", "");
        this.context.scenario.log(
                "Initial Product Count :" + this.context.ProductCountInitial
            );
        this.context.scenario.log(
                "Final Product Count :" + this.context.ProductCountLater
            );

        Assert.assertTrue(
            "Product count is not matched",
            this.context.ProductCountLater.equals(this.context.ProductCountInitial)
        );
    }
}
