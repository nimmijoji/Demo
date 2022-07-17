package Repository_WEB_Objs;

import java.util.*;

public class CategoryPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> CategoryPage;

    static {
        CategoryPage = new HashMap<String, String>();
        CategoryPage.put(
            "showAllProducts_button",
            "//*[contains(@class,'showAllProductsBottom')]"
        );
        CategoryPage.put("section_category", "//*[@class='lhs_categories']");
        CategoryPage.put(
            "firstCategoryInCategories_link",
            "//*[@class='categoryList']//ul/li[1]/a"
        );
        CategoryPage.put(
            "categoryHeader_label",
            "//*[contains(@id,'ad_pf_cnode_espot_01')]/div/div/h1"
        );

        CategoryPage.put("categorySection_label", "//*[@class='lhs_categories']/div");
        CategoryPage.put("categorySection_background", "//*[@class='lhs_categories']");
        CategoryPage.put("categoryList_label", "//*[@class='categoryList']/li/nav/ul");
        CategoryPage.put(
            "categoryHeaderSection_label",
            "//*[@class='categoryList']/li/h2/span"
        );
        CategoryPage.put(
            "categorySection_link",
            "//*[@class='categoryList']/li/nav/ul/li[1]/a"
        );
        CategoryPage.put(
            "catgoeryPageCount_label",
            "//ul[@class='categoryList']//ul//li[1]/span"
        );
        CategoryPage.put("categoryPLPcount_label", "//*[@id='titleProdCount']");
        CategoryPage.put(
            "categoery_label",
            "//*[@id=\"catRefine\"]/ul/li/nav/ul/li[1]/a"
        );
        CategoryPage.put("categoryPLP_label", "//*[@id='prodResultHeader']/h1");
        CategoryPage.put("category_Images", "//*[@id='paraSearch']//ul");
    }

    public String findLocator(String elementName) {
        if (CategoryPage.containsKey(elementName)) {
            return (CategoryPage.get(elementName.trim()));
        }

        return null;
    }
}
