package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class PLPSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";
    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public PLPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I verify dropdown list items in mobile \"([^\"]*)\" PLP page$")
    public void verify_list_options_PLP(String key) throws Exception {
        List<String> expListItems = new ArrayList<>();
        List<String> expTranslatedListItems = new ArrayList<>();
        List<String> actListItems = new ArrayList<>();
        String StoreValue = getStore().toLowerCase();
        switch (key.toLowerCase()) {
            case "plp sortby":
                // Mobile PLP
                expListItems = this.context.constants.getPLPSortListItems();
                System.out.println("ExpTransalatedList:");
                expListItems.forEach(d -> {
                    expTranslatedListItems.add(storeText.getStoreText(d));
                    System.out.println(storeText.getStoreText(d) + ",");
                });
                List<WebElement> actWebElementList = getMutipleLocators(
                    "PLP.sortByOptions_list"
                );
                System.out.println("ActualPLPList:");
                actWebElementList.forEach(e -> {
                    System.out.println("ActualTextDisplayed:" + e.getText() + ",");
                    String temp = e.getText().trim();
                    String actText = temp.replaceAll("\\s", "");
                    actListItems.add(actText);
                    System.out.println(actText + ",");
                });
                this.context.scenario.log(
                        "Actual list:" +
                        actListItems +
                        "Expected translated list:" +
                        expTranslatedListItems
                    );
                Assert.assertEquals(
                    "List items does not match",
                    expTranslatedListItems,
                    actListItems
                );
                break;
            default:
                this.context.scenario.log(key + "case not found");
        }
    }

    @And("^.*get the PLP Products found count before applying filters$")
    public void preFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.PRE_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
    }

    @And("^.*verify the PLP Products found count after applying filters$")
    public void postFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Search.productsHeader_text"
        );
        this.context.scenario.log(actionMethods.getValue("Search.productsHeader_text"));
        this.context.POST_FILTER_COUNT =
            actionMethods.getValue("Filters.filtersCount_text").replaceAll("[,'. ]", "");
        if (store != "us") {
            Assert.assertTrue(
                "Filter is not selected",
                Integer.parseInt(this.context.POST_FILTER_COUNT) <
                Integer.parseInt(this.context.PRE_FILTER_COUNT)
            );
        }
    }

    @And("^I save the value of First Order code from PLP Page$")
    public void save_first_order_code() throws Exception {
        this.context.PLP_FIRST_ORDER_CODE =
            actionMethods.getValue("PLP.firstPurchasableOrderCode_text");
        this.context.scenario.log(
                "Value of purchasable Ordercode/SKU obtained: " +
                this.context.PLP_FIRST_ORDER_CODE
            );
    }
}
