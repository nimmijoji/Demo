package Repository_MOBILE_Objs;

import java.util.*;

public class BrowseForProducts_Objs {

    // Creation of HashMap
    private static final Map<String, String> BrowseForProducts;

    static {
        BrowseForProducts = new HashMap<String, String>();
        BrowseForProducts.put(
            "firstCategory_link",
            "//*[@class='filterCategoryLevelOne']//a"
        );
        BrowseForProducts.put("firstCategory_image", "//*[@class='categoryImg']/img");
        BrowseForProducts.put("firstCategory_text", "(//*[@class='catHeader']/h2)[1]");
    }

    public String findLocator(String elementName) {
        if (BrowseForProducts.containsKey(elementName)) {
            return (BrowseForProducts.get(elementName.trim()));
        }

        return null;
    }
}
