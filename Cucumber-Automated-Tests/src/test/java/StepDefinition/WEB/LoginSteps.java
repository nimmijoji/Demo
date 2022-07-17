package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.Given;

public class LoginSteps extends WebDriverConfig {

    private ContextStore context;

    public LoginSteps(ContextStore context) {
        this.context = context;
    }

    @Given("^last registered \"([^\"]*)\" user login.*$")
    public void login_lastRegistereduser(String loginUser) throws Exception {
        String username;
        String password = context.constants.getPassword();

        if (loginUser.contains("sync")) {
            username = ContextStore.SYNCH_USER_NAME;
        } else {
            username = ContextStore.USER_NAME;
        }

        actionMethods.click("Header.login_link");
        Thread.sleep(5000);
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Login.username_textbox"
        );
        actionMethods.enterText(username, "Login.username_textbox");
        context.scenario.log("Username: " + username);
        actionMethods.enterText(password, "Login.password_textbox");
        context.scenario.log("Password:" + password);
        Thread.sleep(5000);
        actionMethods.click("Login.login_button");
        Thread.sleep(9000);
    }
}
