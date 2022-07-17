package Repository_WEB_Objs;

import java.util.*;

public class Filters_Objs {

    // Creation of HashMap
    private static final Map<String, String> Filters;

    static {
        Filters = new HashMap<String, String>();
        Filters.put("staticFilterAvailability_section", "//*[@id='allStaticFilters']");
        Filters.put("instock_checkbox", "(//div[contains(@id,'fv_')]/label)[1]");
        Filters.put("filterResistance_section", "//*[@id='checkboxlist_1000194']");
        Filters.put("showResult_button", "//*[@id='showFilterApplied']");
        Filters.put("filtersCount_text", "//*[@id='titleProdCount']");
        Filters.put(
            "filterAppliedLeftView_section",
            "//*[@id='paraSearch']/section[2]/div"
        );
        Filters.put(
            "filterAppliedTopView_section",
            "(//*[contains(@class,'filterResultContainer')])[1]"
        );
        Filters.put(
            "clearAllFilters_link",
            "//*[contains(@class,'clear_filter_link')]/a"
        );
        Filters.put("reset_link", "//*[@class='clearLink  hideInMobile']");
        Filters.put(
            "filterView_toggle",
            "//*[@id='filterLayout']//div[@class='toggleButton']"
        );
        Filters.put("filterManufacturer_section", "//*[@id='manufacturerHide']");

        //filter Tool elements
        Filters.put("filtersCountFilterTab_text", "//span[@class='filter-data']");
        Filters.put(
            "filterToolInStock_checkbox",
            "(//div[@class='ov_filterList']//input[@type='checkbox'])[1]"
        );
        Filters.put(
            "applyFiltersinTooltab_button",
            "(//div[@class='filter-footer'])[2]//a"
        );
        Filters.put(
            "clearAllFiltersinTooltab_button",
            "//a[contains(@class,'btnClear')]"
        );
        Filters.put(
            "filterFirstproperty_checkbox",
            "((//div[@class='ov_filterList'])[3]//input[@type='checkbox'])[1]"
        );
        Filters.put("sideMenuThirdCategory_link", "//div[@class='sidemenu']//a[3]");
        Filters.put(
            "filtersAppliedArrow_button",
            "//*[contains(@class,'overlayfil_icon')]"
        );
        Filters.put("removeFilter_icon", "//*[contains(@class,'iconCloseCross')]");
    }

    public String findLocator(String elementName) {
        if (Filters.containsKey(elementName)) {
            return (Filters.get(elementName.trim()));
        }

        return null;
    }
}
