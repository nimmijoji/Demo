package Translation.EU_Countries;

import java.util.HashMap;

public class CH_DE_Translation {

    // ############SWITZERLAND############
    // Dedicated for switzerland-germany

    public String chDETranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        map.put("Checkout Now", "Jetzt zur Kasse gehen");
        map.put("My Account Summary", " Kontoübersicht");
        map.put("Order History & Tracking", "Bestellverlauf & -verfolgung");
        map.put("Manufacturer List", "Herstellerliste");
        map.put("Contact Us", "Kontakt");
        map.put("About Us", "Über uns");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_switzerland_Germany=" + value);

        return (value);
    }
}
