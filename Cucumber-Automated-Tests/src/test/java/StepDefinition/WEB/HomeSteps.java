package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.HELPERS.UIVerificationMethods;
import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(HomeSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public HomeSteps(ContextStore context) {
        this.context = context;
    }

    @And("^User navigate to community URL using file \"([^\"]*)\"$")
    public void navigate_Community_URL(String FileName) throws Throwable, IOException {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getRegionName());

        String sku1 = testData.get(0).get("firstSku");
        String q1 = testData.get(0).get("firstSkuQuantity");
        String sku2 = testData.get(0).get("secondSku");
        String q2 = testData.get(0).get("secondSkuQuantity");

        String baseURL = getSiteBaseUrl();

        String communityURL = baseURL.concat(
            "jsp/extlink.jsp?action=buy&product=" +
            sku1 +
            "~" +
            q1 +
            "~" +
            sku2 +
            "~" +
            q2 +
            "&COM=superwidget-link"
        );
        logger.info("Community URL: " + communityURL);
        driver.get(communityURL);
    }

    @And("^I enter ordercode in Searchbox to navigate to PDP page$")
    public void enter_order_code() throws Exception {
        String expectedOrderCode = this.context.constants.getOrderCode();
        actionMethods.enterText(expectedOrderCode, "Header.searchBox_textbox");
    }

    @Given("^.*enter \"([^\"]*)\".* from file \"([^\"]*)\" in searchbox$")
    public void enter_order_code_from_file(String key, String filename) throws Exception {
        String path = FilePath + filename;
        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
        String searchterm = testData.get(0).get(key);
        if (searchterm == null || searchterm.equalsIgnoreCase("")) {
            assumeTrue("Data missing.NA for this store. product Type:" + key, false);
        } else {
            actionMethods.enterText(searchterm, "Header.searchBox_textbox");
            this.context.scenario.log("searchterm :" + searchterm);
        }
    }
}
