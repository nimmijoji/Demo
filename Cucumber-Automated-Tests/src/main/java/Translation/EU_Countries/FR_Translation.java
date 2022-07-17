package Translation.EU_Countries;

import java.util.HashMap;

public class FR_Translation {

    // ############FRANCE############

    public String frTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "";
        } else {
            map.put("£", "");
            map.put("Username has been sent", "Le nom d'utilisateur a été envoyé");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_France=" + value);
        }

        return (value);
    }
}
