package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MCLPSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(MCLPSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public MCLPSteps(ContextStore context) {
        this.context = context;
    }

    @And("User verify presence of categories section$")
    public void verifyPresenceOfCategoriesSection() throws Exception {
        actionMethods.getValue("CategoryPage.categorySection_label");
        uiMethods.verifyTextExistence("Categories", "CategoryPage.categorySection_label");
        uiMethods.verifySentenceIsBold("CategoryPage.categorySection_label");
    }

    @Then("Verify list of categories in category section$")
    public void VerifyListOFCategory() throws Exception {
        List<WebElement> loc = actionMethods.getMutipleLocators(
            "CategoryPage.categoryList_label"
        );
        int countList = loc.size();

        for (int i = 0; i <= countList; i++) {
            String categories =
                actionMethods.getValue("CategoryPage.categoryList_label") +
                "[" +
                i +
                "]" +
                "/a";
        }
    }

    @Then("Verify the static header inside Category section$")
    public void VerifyStaticHeaderInsideCategorysection() throws Exception {
        uiMethods.isElementDisplayed("CategoryPage.categoryHeaderSection_label");
        actionMethods.getValue("CategoryPage.categoryHeaderSection_label");
    }

    @Then("I Click on any link in category section$")
    public void VerifyClickCategorylink() throws Exception {
        String Actualcategoryname = actionMethods.getValue(
            "CategoryPage.categoery_label"
        );
        String Actualcount = actionMethods
            .getValue("CategoryPage.catgoeryPageCount_label")
            .replaceAll("[(,'.)]", "");
        int ActualCount = Integer.parseInt(Actualcount);
        actionMethods.clickUsingJSExecutor("CategoryPage.categorySection_link");
        String Expectedcategoryname = actionMethods.getValue(
            "CategoryPage.categoryPLP_label"
        );
        String Expectedcount = actionMethods
            .getValue("CategoryPage.categoryPLPcount_label")
            .replaceAll("([,'. ])", "");
        int ExpectedCount = Integer.parseInt(Expectedcount);
        Assert.assertEquals(
            "CLP and PLP product count is not matched",
            ExpectedCount,
            ActualCount
        );
        Assert.assertEquals(Expectedcategoryname, Actualcategoryname);
    }

    @Then("Verify the category images on category page$")
    public void VerifyCategoryImages() throws Exception {
        uiMethods.isElementDisplayed("CategoryPage.category_Images");
        actionMethods.getValue("CategoryPage.category_Images");
    }
}
