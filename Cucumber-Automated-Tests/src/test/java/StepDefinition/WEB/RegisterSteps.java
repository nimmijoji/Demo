package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.List;
import java.util.Map;

public class RegisterSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public RegisterSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*fill details in create account section on Order Confirmation form using given file \"([^\"]*)\"$"
    )
    public void create_account_for_guest(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String username = actionMethods.generateRandomNumberString(
            testData.get(0).get("username")
        );
        this.context.currentUser = username;
        String password = this.context.constants.getPassword();
        String phoneNumber = testData.get(0).get("phoneNumber");

        actionMethods.enterText(phoneNumber, "Checkout.phoneNumber_textbox");
        context.scenario.log("phoneNumber for new user: " + phoneNumber);

        actionMethods.enterText(username, "Checkout.username_textbox");
        context.scenario.log("Username for new user: " + username);

        actionMethods.enterText(password, "Checkout.password_textbox");
        context.scenario.log("Password for new user: " + password);
    }
}
