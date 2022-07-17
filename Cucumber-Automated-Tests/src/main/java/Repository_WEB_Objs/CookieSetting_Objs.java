package Repository_WEB_Objs;

import java.util.*;

public class CookieSetting_Objs {

    // Creation of HashMap
    private static final Map<String, String> CookieSetting;

    static {
        CookieSetting = new HashMap<String, String>();
        CookieSetting.put("cookiePolicy_dialogBox", "//*[@id='onetrust-policy']");
        CookieSetting.put(
            "oneTrustCookie_button",
            "//*[@id='onetrust-accept-btn-handler']"
        );
        CookieSetting.put(
            "cookieAcceptanceNonUK_button",
            "//*[@id='mktg_Cookie_button']"
        );
        CookieSetting.put("cookieSettings_link", "//*[@class='cookie-setting-link']");
        CookieSetting.put(
            "savePreferences_button",
            "//*[contains(@class,'save-preference')]"
        );

        //Paypal window element
        CookieSetting.put("paypalPage_button", "//button[@id='acceptAllButton']");
    }

    public String findLocator(String elementName) {
        if (CookieSetting.containsKey(elementName)) {
            return (CookieSetting.get(elementName.trim()));
        }

        return null;
    }
}
