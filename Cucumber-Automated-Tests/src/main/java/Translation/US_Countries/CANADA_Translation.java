package Translation.US_Countries;

import java.util.HashMap;

public class CANADA_Translation {

    // ############CANADA############

    public String canadaTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");
        map.put("Add to Favourites List", "Add to Favorites List");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_CANADA=" + value);

        return (value);
    }
}
