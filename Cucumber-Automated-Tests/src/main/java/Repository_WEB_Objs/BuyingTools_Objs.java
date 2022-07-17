package Repository_WEB_Objs;

import java.util.*;

public class BuyingTools_Objs {

    // Creation of HashMap
    private static final Map<String, String> BuyingTools;

    static {
        BuyingTools = new HashMap<String, String>();
        BuyingTools.put("buyingListTools_link", "//a[contains(@href,'buying-tools')]");
    }

    public String findLocator(String elementName) {
        if (BuyingTools.containsKey(elementName)) {
            return (BuyingTools.get(elementName.trim()));
        }

        return null;
    }
}
