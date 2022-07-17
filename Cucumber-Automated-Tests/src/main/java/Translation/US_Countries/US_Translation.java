package Translation.US_Countries;

import java.util.HashMap;

public class US_Translation {

    // ############US############

    public String usTranslations(String text) {
        String value = "";
        String matchingvalue = "";

        HashMap<String, String> map = new HashMap<>();
        map.put("£0.00", "$0.00");
        map.put("Order Code", "Newark Part No.");
        map.put("Credit / Debit Card", "Credit/Debit Card");
        map.put("Trade Account", "Newark Account");
        map.put("Price For (ex VAT)", "Price For");
        map.put("Forgotten your username?", "Forgot username?");
        map.put("Requested Delivery Date", "Requested Ship Date");
        map.put("Add to Favourites List", "Add to Favorites List");
        //map.put("8-20 Characters", "8 Characters");
        map.put("Include a lower case letter (a-z)", "One lowercase letter (a-z)");
        map.put("Include a uppercase character (A-Z)", "One uppercase letter (A-Z)");
        map.put("Include a number (0-9)", "One number (0-9)");
        map.put(
            "Include a special character (!&#@,..)",
            "One special character (!@#&...)"
        );
        map.put("Your information", "What we do with the information you provide");
        map.put(
            "We need this information from you to provide you with the products and services you order and to manage your account.",
            "We need this information to understand your needs and provide you with a better service."
        );
        map.put("Popular Product Categories", "Most popular product categories");
        map.put(
            "This item has been added to your basket",
            "This item has been added to your cart"
        );
        map.put("Forgotten your password?", "Forgot password?");
        map.put("* Email", "* Email Address");
        map.put(
            "Farnell has sent an email with a link to reset your password to:",
            "Newark has sent an email with a link to reset your password to:"
        );
        map.put(
            "Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.",
            "Did not receive the email? Please check that you have a Newark account, the spelling of the email address and your spam folder."
        );

        map.put("OrderCode:ascending", "NewarkPartNo.:ascending");
        map.put("OrderCode:descending", "NewarkPartNo.:descending");

        map.put("Order Code", "Newark Part No.");
        map.put("Price For", "Price for");
        map.put("Price (ex VAT)", "Price");

        // DO NOT TOUCH BELOW CODE
        try {
            matchingvalue = map.get(text.trim());
        } catch (Exception e) {}
        if (matchingvalue == null) {
            value = text.trim();
        } else {
            value = matchingvalue.trim();
        }

        System.out.println("Value of_" + text + "_in_US=" + value);

        return (value);
    }
}
