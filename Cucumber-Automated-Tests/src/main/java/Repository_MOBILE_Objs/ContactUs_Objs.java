package Repository_MOBILE_Objs;

import com.ctc.wstx.sw.BufferingXmlWriter;
import java.util.*;

public class ContactUs_Objs {

    // Creation of HashMap
    private static final Map<String, String> ContactUs;

    static {
        ContactUs = new HashMap<String, String>();
        ContactUs.put("breadcrumbContactUs_text", "//*[@id='breadcrumbs']//li[2]");
        ContactUs.put(
            "contctUsHeading_text",
            "//*[contains(@class,'new-contact-us')]/h1"
        );
    }

    public String findLocator(String elementName) {
        if (ContactUs.containsKey(elementName)) {
            return (ContactUs.get(elementName.trim()));
        }

        return null;
    }
}
