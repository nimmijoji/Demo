package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class ForgotPassword_Objs {

    private static final Map<String, String> ForgotPassword;

    static {
        ForgotPassword = new HashMap<String, String>();
        ForgotPassword.put("forgotYourPassword_text", "//*[@class='pf_row']/h1[1]");
        ForgotPassword.put("email_textbox", "//input[@id='email1']");
        ForgotPassword.put("sendResetLink_button", "//button[@id='resetpwd']");
        ForgotPassword.put(
            "greenTickMarkResetMail_icon",
            "//*[@class='loginSuccessIcn']"
        );
        ForgotPassword.put("resetEmailSent_text", "//*[@id='successHeader']");
    }

    public String findLocator(String elementName) {
        if (ForgotPassword.containsKey(elementName)) {
            return (ForgotPassword.get(elementName.trim()));
        }

        return null;
    }
}
