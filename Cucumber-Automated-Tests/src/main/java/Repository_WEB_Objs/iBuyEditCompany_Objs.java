package Repository_WEB_Objs;

import java.util.*;

public class iBuyEditCompany_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyEditCompany;

    static {
        iBuyEditCompany = new HashMap<String, String>();

        iBuyEditCompany.put("editCompany_text", "//h1[text()='Edit Company']");
        iBuyEditCompany.put("companyName_textbox", "//*[@id='companyName']");
        iBuyEditCompany.put("accountNumber_link", "//*[@id='editPFAccount']");
        iBuyEditCompany.put("save_button", "//input[@class='btn btnPrimary']");
        iBuyEditCompany.put("cancel_button", "//a[@id='cancelCustomisationBtn']");
    }

    public String findLocator(String elementName) {
        if (iBuyEditCompany.containsKey(elementName)) {
            return (iBuyEditCompany.get(elementName.trim()));
        }

        return null;
    }
}
