package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class HeaderSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public HeaderSteps(ContextStore context) {
        this.context = context;
    }

    @And("^I verify dropdown list items in \"([^\"]*)\".*$")
    public void verify_list_options(String key) throws Exception {
        List<String> expListItems = new ArrayList<>();
        List<String> expTranslatedListItems = new ArrayList<>();
        List<String> actListItems = new ArrayList<>();

        switch (key.toLowerCase()) {
            case "my account":
                expListItems = this.context.constants.getMyAccountlistItems();
                expListItems.forEach(d -> {
                    expTranslatedListItems.add(storeText.getStoreText(d));
                });
                List<WebElement> actWebElementsList = getMutipleLocators(
                    "Header.myAccount_list"
                );
                actWebElementsList.forEach(e -> {
                    actListItems.add(e.getText());
                    this.context.scenario.log(e.getText() + ", ");
                });
                this.context.scenario.log("Actual list:" + actListItems);
                this.context.scenario.log(
                        "Expected translated list:" + expTranslatedListItems
                    );
                Assert.assertEquals(
                    "List items does not match",
                    expTranslatedListItems,
                    actListItems
                );
                break;
            case "search categories list":
                break;
        }
    }

    @And("^I verify presence of login and register links for guest users$")
    public void verify_login_registerlink() throws Exception {
        if (getUserType().equalsIgnoreCase("guest")) {
            uiMethods.verifyLinkIsPresent("Register.register_link");
            uiMethods.verifyLinkIsPresent("Header.login_link");
        } else {
            this.context.scenario.log("NA for user type:" + getUserType());
        }
    }
}
