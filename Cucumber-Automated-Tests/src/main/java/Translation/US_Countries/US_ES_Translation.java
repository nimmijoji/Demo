package Translation.US_Countries;

import java.util.HashMap;

public class US_ES_Translation {

    // ############US ESPA ############

    public String esUSTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        map.put("Checkout Now", "Pagar ahora");
        map.put("My Account Summary", "Mi resumen de cuenta");
        map.put("Order History & Tracking", "Historial y seguimiento del pedido ");
        map.put("Manufacturer List", " Lista de fabricantes");
        map.put("Contact Us", "Contáctenos");
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

        System.out.println("Value of_" + text + "_in_US_ES=" + value);

        return (value);
    }
}
