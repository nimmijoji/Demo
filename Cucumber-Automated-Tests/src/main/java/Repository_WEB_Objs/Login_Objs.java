package Repository_WEB_Objs;

import java.util.*;

public class Login_Objs {

    // Creation of HashMap
    private static final Map<String, String> Login;

    static {
        Login = new HashMap<String, String>();
        Login.put("username_textbox", "//*[@id='logonId']");
        Login.put("password_textbox", "//*[@id='logonPassword']");
        Login.put("login_button", "//input[@type='submit']");
        Login.put("forgotUsername_link", "//*[contains(@href,'PFUserNameRetrieveView')]");
        Login.put(
            "forgotPassword_link",
            "//*[contains(@href,'ResetPasswordGuestErrorView?')]"
        );
        Login.put("login_element", ".//*[@class='pf_row loginHeading']/h1");
    }

    public String findLocator(String elementName) {
        if (Login.containsKey(elementName)) {
            return (Login.get(elementName.trim()));
        }

        return null;
    }
}
