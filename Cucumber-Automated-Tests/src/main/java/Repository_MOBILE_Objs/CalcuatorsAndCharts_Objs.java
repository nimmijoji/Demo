package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class CalcuatorsAndCharts_Objs {

    private static final Map<String, String> CalcuatorsAndCharts;

    static {
        CalcuatorsAndCharts = new HashMap<String, String>();
        CalcuatorsAndCharts.put(
            "header_element",
            "//div[contains(@class,'grey-very-dark')]//h1[contains(@class,'header-text-large')]"
        );
        CalcuatorsAndCharts.put(
            "products_element",
            "//div[@class='calcWrapper large-padding-bottom']"
        );
        CalcuatorsAndCharts.put(
            "mainMenu_button",
            "//div[contains(@class,'-12')]//a[@class='btn btn-secondary']"
        );
        CalcuatorsAndCharts.put(
            "mainMenutwo_button",
            "(//div[contains(@class,'-12')]//a[@class='btn btn-secondary'])[2]"
        );
        CalcuatorsAndCharts.put(
            "calMenuTool_button",
            "(//a[@class='btn btn-tertiary'])[2]"
        );
        CalcuatorsAndCharts.put(
            "menuHeader_element",
            "//div[contains(@class,'grey-dark2')]//h1[contains(@class,'header-text-large')]"
        );
        CalcuatorsAndCharts.put("calFooter_button", "(//footer//div//a//li)[5]");
        CalcuatorsAndCharts.put(
            "calChartsMenu_button",
            "//div[contains(@class,'col-sm-12')]//a[contains(@class,'btn btn-')]"
        );
    }

    public String findLocator(String elementName) {
        if (CalcuatorsAndCharts.containsKey(elementName)) {
            return (CalcuatorsAndCharts.get(elementName.trim()));
        }

        return null;
    }
}
