package Repository_MOBILE_Objs;

import com.ctc.wstx.sw.BufferingXmlWriter;
import java.util.*;

public class BurgerNavigation_Objs {

    // Creation of HashMap
    private static final Map<String, String> BurgerNavigation;

    static {
        BurgerNavigation = new HashMap<String, String>();
        BurgerNavigation.put("firstCategory_link", "//a[@data-select-category='1']");
        BurgerNavigation.put("subFirstCategory_link", "//*[@id='category-1']/ul[1]/li/a");
        BurgerNavigation.put(
            "finalSubFirstCategory_link",
            "(//*[@data-om='Product Navigation Selection(L1)'])[1]"
        );

        BurgerNavigation.put(
            "category1Menu_list",
            "//*[@class='category level-1-category panel panel-primary']/ul/li"
        );
        BurgerNavigation.put(
            "backLeftArrowLevel1_button",
            "//*[@class='btn btn-default backLeftArrow']"
        );
        BurgerNavigation.put("viewAllProducts_link", "(//*[@class='greyMenuList'])[1]/a");

        BurgerNavigation.put("manufacturer_link", "(//*[@class='greyMenuList'])[2]/a");
        BurgerNavigation.put("manufacturer_list", "//*[@class='collapsable-outlined']");
        BurgerNavigation.put(
            "manufacturerHeading_element",
            "//*[@class='manufacturer section']/h1"
        );
        BurgerNavigation.put("manufacturer_element", "//*[@id='man_A']");
        BurgerNavigation.put("manufacturer1_list", "//*[@id='manA-content']/ul");

        BurgerNavigation.put(
            "resources_link",
            "(//*[@class='greyMenuList whiteBorderBotton'])/section/div/a"
        );
        BurgerNavigation.put("resourcesMenu_list", "//*[@id='category-Resources']/ul/li");
        BurgerNavigation.put(
            "resourcesMenuBack_button",
            "//*[@id='category-Resources']/div/button"
        );
        BurgerNavigation.put(
            "resourcesPanelTitle_element",
            "//*[@id='category-Resources']/div/h2"
        );
        BurgerNavigation.put(
            "resourcesPanelTitleBckGrnd_element",
            "//*[@id='category-Resources']/div"
        );

        BurgerNavigation.put(
            "newProducts_link",
            "(//*[@class='dtmTrack greyMenuList '])/a"
        );
        BurgerNavigation.put(
            "newProductsBack_button",
            "//*[@id='category-newproducts']/div/button"
        );
        BurgerNavigation.put(
            "newProductsPanelTitle_element",
            "//*[@id='category-newproducts']/div"
        );
        BurgerNavigation.put(
            "newProductsMenu_list",
            "//*[@id='category-newproducts']/ul/li"
        );

        BurgerNavigation.put("firstCategory_link", "//*[@data-level='1']/ul[1]/li[1]/a");
        BurgerNavigation.put(
            "subFirstCategory_link",
            "//*[@id='category-1']/ul[1]/li[1]/a"
        );
        BurgerNavigation.put("subCategoryMenu_list", "//*[@id='category-1']/ul");
        BurgerNavigation.put(
            "finalSubFirstCategory_link",
            "//*[@class='category level-3-category panel panel-default dtmTrack']/ul[1]/li[1]/a"
        );
        BurgerNavigation.put(
            "finalSubCategoryMenu_list",
            "//*[@class='category level-3-category panel panel-default dtmTrack']/ul"
        );
    }

    public String findLocator(String elementName) {
        if (BurgerNavigation.containsKey(elementName)) {
            return (BurgerNavigation.get(elementName.trim()));
        }

        return null;
    }
}
