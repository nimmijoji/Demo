package Translation.EU_Countries;

import java.util.HashMap;

public class DE_Translation {

    // ############GERMANY############

    public String deTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();

        map.put("Checkout Now", "Jetzt zur Kasse gehen");
        map.put("My Account Summary", " Kontoübersicht");
        map.put("Order History & Tracking", "Bestellverlauf & -verfolgung");
        map.put("Manufacturer List", "Herstellerliste");
        map.put("Contact Us", "Kontakt");
        map.put("About Us", "Über uns");

        map.put("Add to Favourites List", "Zur Favoritenliste hinzufügen");
        map.put("Your email has been sent.", "Ihre E-Mail wurde gesendet.");
        map.put("Your changes have been saved.", "Ihre Änderungen wurden gespeichert.");
        map.put("Add Address", "Adresse hinzufügen");
        map.put("was successfully added.", "wurde erfolgreich hinzugefügt.");
        map.put("was successfully updated.", "wurde erfolgreich aktualisiert.");
        map.put("was successfully deleted.", "wurde erfolgreich gelöscht.");
        map.put("Order scheduled!", "Bestellung terminiert!");

        map.put("Thankyou for your Order", "Vielen Dank für Ihren Auftrag");
        map.put("Requested Delivery Date", "Wunschliefertermin");
        map.put("Thank You", "Vielen Dank");
        map.put(
            "Your new payment card details have been saved.",
            "Die Daten für die neue Kreditkarte wurden gespeichert."
        );
        map.put(
            "Your new order preferences have been saved.",
            "Die neuen Voreinstellungen für Bestellungen wurden gespeichert."
        );
        map.put("help", "hilfezentrum");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_Germany=" + value);

        return (value);
    }
}
