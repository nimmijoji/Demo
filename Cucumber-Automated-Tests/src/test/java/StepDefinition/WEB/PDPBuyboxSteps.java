package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import org.junit.Assert;

public class PDPBuyboxSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public PDPBuyboxSteps(ContextStore context) {
        this.context = context;
    }

    @Then("^.*verify cutoff time tooltip is present on \"([^\"]*)\" region website.*$")
    public void verify_cutoff_time_tooltip_specific(String regions) throws Exception {
        String[] regionarray = regions.split(",");
        String region = getRegionName();
        if (Arrays.asList(regionarray).contains(region)) {
            actionMethods.click("PDPBuyBox.cutOffTimeTooltip_icon");
            Assert.assertTrue(
                uiMethods.isElementDisplayed("PDPBuyBox.tooltipContent_text")
            );
            Assert.assertTrue(
                "Cut off time tooltip text is missing",
                !actionMethods.getValue("PDPBuyBox.tooltipContent_text").isEmpty()
            );
        } else {
            context.scenario.log("Not applicable for this region:" + region);
        }
    }

    @Then("^.*verify total price for entered quantity$")
    public void verify_total_price_in_buy_box() throws Exception {
        String actualTotalPriceLabel;
        String actualTotalPriceValue;

        if (
            getRegionName().equalsIgnoreCase("APAC") && !getStore().equalsIgnoreCase("cn")
        ) {
            Assert.assertTrue(
                "Total price text missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceLabelIncVAT_text")
            );
            Assert.assertTrue(
                "Total price value missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceIncVAT_text")
            );
            actualTotalPriceLabel =
                actionMethods.getValue("PDPBuyBox.totalPriceLabelIncVAT_text");
            actualTotalPriceValue =
                actionMethods.getValue("PDPBuyBox.totalPriceIncVAT_text");
        } else {
            Assert.assertTrue(
                "Total price text missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceLabelExcVAT_text")
            );
            Assert.assertTrue(
                "Total price value missing",
                uiMethods.isElementDisplayed("PDPBuyBox.totalPriceExcVAT_text")
            );
            actualTotalPriceLabel =
                actionMethods.getValue("PDPBuyBox.totalPriceLabelExcVAT_text");
            actualTotalPriceValue =
                actionMethods.getValue("PDPBuyBox.totalPriceExcVAT_text");
        }
        this.context.scenario.log("Actual total price label " + actualTotalPriceLabel);
        this.context.scenario.log("actualTotalPriceValue:" + actualTotalPriceValue);
    }
}
