package Repository_WEB_Objs;

import java.util.*;

public class BrowseForProducts_Objs {

    // Creation of HashMap
    private static final Map<String, String> BrowseForProducts;

    static {
        BrowseForProducts = new HashMap<String, String>();
        BrowseForProducts.put("firstCategory_link", "(//div[@class='catHeader']//a)[1]");
        BrowseForProducts.put("secondCategory_link", "(//div[@class='catHeader']//a)[2]");
        BrowseForProducts.put(
            "allProducts_links",
            "(//div[@class='categoryContainer']//ul//li/a)"
        );
    }

    public String findLocator(String elementName) {
        if (BrowseForProducts.containsKey(elementName)) {
            return (BrowseForProducts.get(elementName.trim()));
        }

        return null;
    }
}
