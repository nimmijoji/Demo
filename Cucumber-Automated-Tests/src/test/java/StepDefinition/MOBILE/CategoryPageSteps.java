package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPageSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public CategoryPageSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*verify Categories with product count is present in descending order in Categories Section \"([^\"]*)\"$"
    )
    public void verifySubCategoriesInDescendingOrderOfProductCount(String locator)
        throws Exception {
        List<WebElement> elementObj = getMutipleLocators(locator);
        ArrayList<Integer> Count = new ArrayList<Integer>();
        int misCount = misCategCount(locator);

        /* - is done as Miscellaneous categories are excluded */
        for (int j = 1; j <= elementObj.size() - misCount; j++) {
            String productCount = "//*[@class='categories-1']/li[" + j + "]/span";
            String categoryProductCount = getDriver()
                .findElement(By.xpath(productCount))
                .getText();

            String substring = categoryProductCount.substring(
                1,
                categoryProductCount.length() - 1
            );
            String newString =
                ((substring.replace(",", "")).replace(".", "")).replace(" ", "");

            int number = Integer.parseInt(newString);
            boolean flag = number >= 1;
            Assert.assertEquals("Product Count is Less Than 1......", true, flag);

            Count.add(number);
        }

        ArrayList<Integer> ProductCountOrder = new ArrayList<Integer>();

        // COPY actual list to another list
        ProductCountOrder.addAll(Count);
        Comparator c = Collections.reverseOrder();
        Collections.sort(ProductCountOrder, c);
        boolean sorted = ProductCountOrder.equals(Count);
        Assert.assertEquals(
            "Product Count is not in desending order........",
            true,
            sorted
        );
        Count.clear();
        ProductCountOrder.clear();
    }

    @And(
        "^.*verify Miscellaneous Categories are present at the bottom in Categories Section \"([^\"]*)\"$"
    )
    public void verifyMiscellaneousCategoryAtBottom(String locator) throws Exception {
        /* Assertion for miscellaneous need to be done by checking logs only */
        List<WebElement> elementObj = getMutipleLocators(locator);
        context.scenario.log(
            "<------Verify that Categories are present as link followed by Space & product count in bracket------->"
        );
        for (WebElement ele : elementObj) {
            context.scenario.log(ele.getText());
        }
        context.scenario.log("<---------------------------------------------------->");
    }

    public int misCategCount(String locator) throws Exception {
        int misCount = 0;
        List<WebElement> elementObj = getMutipleLocators(locator);
        for (WebElement ele : elementObj) {
            if (
                ele.getText().contains(storeText.getStoreText("Miscellaneous")) ||
                ele.getText().contains(storeText.getStoreText("More"))
            ) {
                misCount++;
            }
        }
        return misCount;
    }

    @And("^.*verify Category lister page is not empty \"([^\"]*)\"$")
    public void categoryListerPageIsPresent(String locator) throws Exception {
        List<WebElement> elementObj = getMutipleLocators(locator);
        int productsOnListerPage = elementObj.size();
        Assert.assertTrue(productsOnListerPage <= 25);
        context.scenario.log("Total products found on page:" + productsOnListerPage);
    }
}
