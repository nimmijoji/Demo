package Translation.US_Countries;

import java.util.HashMap;

public class MEXICO_Translation {

    // ############MEXICO############

    public String mexicoTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_MEXICO=" + value);

        return (value);
    }
}
