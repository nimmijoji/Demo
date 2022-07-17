package Translation.EU_Countries;

import java.util.HashMap;

public class CH_FR_Translation {

    // ############SWITZERLAND############
    // Dedicated for switzerland-France

    public String chFRTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        if (text.contains("In stock")) {
            value = "En stock";
        } else {
            map.put("View All Products", "Afficher tous les produits");
            map.put("Shopping Cart", "Panier");
            map.put("My Account", "Mon compte");
            map.put("Order History & Tracking", "Historique et suivi des commandes");
            map.put("Calculators & Charts", "Historique et suivi des commandes");
            map.put("View all manufacturers", "Voir tous les fabricants");
            map.put("Contact Us", "Contactez-nous");
            map.put("About Us", "À propos de nous");

            // DO NOT TOUCH BELOW CODE
            try {
                matchingvalue = map.get(text.trim());
            } catch (Exception e) {}
            if (matchingvalue == null) {
                value = text.trim();
            } else {
                value = matchingvalue.trim();
            }

            System.out.println("Value of_" + text + "_in_switzerland_France=" + value);
        }

        return (value);
    }
}
