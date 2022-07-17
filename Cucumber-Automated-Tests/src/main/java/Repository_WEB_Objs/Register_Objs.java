package Repository_WEB_Objs;

import java.util.*;

public class Register_Objs {

    // Creation of HashMap
    private static final Map<String, String> Register;

    static {
        Register = new HashMap<String, String>();
        Register.put("register_link", "//*[@id='loginRegister']//a[2]");
        Register.put("username_textbox", "//*[@id='logonId']");
        Register.put("password_textbox", "//*[@id='logonPassword']");
        Register.put("title_dropdown", "//*[@id='personTitle']");
        Register.put("firstName_textbox", "//input[@id='firstName']");
        Register.put("lastName_textbox", "//input[@id='lastName']");
        Register.put("fullName_textbox", "//input[@id='firstName']");
        Register.put("emailAddress_textbox", "//input[@id='email1']");
        Register.put("phoneNumber_textbox", "//input[@id='phone1']");
        Register.put("extensionNumber_textbox", "//input[@id='phone1Ext']");
        Register.put("vatNumber_textbox", "//*[@id='vatRegNum']");
        Register.put("postalCode_textbox", "//input[@id='zipCode']");
        Register.put("companyName_textbox", "//input[@id='organizationName']");
        Register.put("primaryRole_dropdown", "//select[@id='primaryRole']");
        Register.put("primaryUse_dropdown", "//select[@id='primaryUse']");
        Register.put("rememberMe_checkbox", "//*[@for='rememberMe']//span");
        Register.put("register_button", "//input[@id='registerValidate']");
        Register.put("mobileNumber_textbox", "//*[@id='mobilePhone1']");
        Register.put("marketingPrefrence_checkbox", "//*[@class='mkOptInedt']");
        Register.put("businessAccount_radio", "//*[@class='radio inlineRadios']/span");
        Register.put("registerTitle_text", ".//*[@id='Register']");

        // user data consent kr store
        Register.put("consent_checkbox", "//*[@for='userDataConsent']/span");
    }

    public String findLocator(String elementName) {
        if (Register.containsKey(elementName)) {
            return (Register.get(elementName.trim()));
        }

        return null;
    }
}
