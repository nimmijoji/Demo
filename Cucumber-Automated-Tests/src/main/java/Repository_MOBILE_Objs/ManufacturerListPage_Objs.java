package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class ManufacturerListPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> ManufacturerListPage;

    static {
        ManufacturerListPage = new HashMap<String, String>();
        //ManufacturerListPage.put("ManufacturerList_text", "//*[@id='pageTop']/h1");

        ManufacturerListPage.put(
            "ManufacturerList_text",
            "//*[@class='manufacturer section']/h1"
        );
    }

    public String findLocator(String elementName) {
        if (ManufacturerListPage.containsKey(elementName)) {
            return (ManufacturerListPage.get(elementName.trim()));
        }

        return null;
    }
}
