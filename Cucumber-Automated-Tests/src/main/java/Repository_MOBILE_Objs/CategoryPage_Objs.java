package Repository_MOBILE_Objs;

import java.util.*;

public class CategoryPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> CategoryPage;

    static {
        CategoryPage = new HashMap<String, String>();
        CategoryPage.put("section_category", "//*[@class='categories outlined-section']");
        CategoryPage.put(
            "firstCategoryInCategories_link",
            "(//ul[@class='categories-0']//li//a)[1]"
        );
        CategoryPage.put("breadcrumb_link", "(//*[@id='page-container']/a)[1]");
        CategoryPage.put("category_heading", "//*[@class='productName']");
        CategoryPage.put("titleProductCount_value", "//*[@id='titleProdCount']");
        CategoryPage.put(
            "categoryFirstParagraph_text",
            "(//*[@class='searchParagraph'])[1]"
        );
        CategoryPage.put(
            "categorySubParagraph_text",
            "(//*[@class='searchParagraph'])[4]"
        );
        CategoryPage.put(
            "categorySubParagraph_link",
            "(//*[@class='searchParagraph'])[4]/a"
        );
        CategoryPage.put("cateogoryMainDescription_text", "//*[@class='clearfix']//p");
        CategoryPage.put(
            "refineResults_button",
            "//*[contains(@class,'filter-products')]"
        );
        CategoryPage.put("categories_text", "//*[@class='cat_title']/h2");
        CategoryPage.put("categoriesSection_list", "//ul[@class='categories-1']/li");
        CategoryPage.put(
            "categoriesSectionFirst_link",
            "//ul[@class='categories-1']/li[1]/a"
        );
        CategoryPage.put("sortBy_dropdown", "//*[@id='sort-by']");
        CategoryPage.put(
            "topPagination_text",
            "(//*[contains(@class,'pfPagination')])[1]"
        );
        CategoryPage.put("categorylisterProducts_section", "//*[@id='product-list']/li");
        CategoryPage.put(
            "bottomPagination_text",
            "(//*[contains(@class,'pfPagination')])[2]"
        );
        CategoryPage.put("currentPageSelected_text", "//*[@class='current']");
    }

    public String findLocator(String elementName) {
        if (CategoryPage.containsKey(elementName)) {
            return (CategoryPage.get(elementName.trim()));
        }

        return null;
    }
}
