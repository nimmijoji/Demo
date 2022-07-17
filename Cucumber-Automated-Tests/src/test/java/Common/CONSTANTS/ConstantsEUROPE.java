package Common.CONSTANTS;

import java.util.Arrays;

public class ConstantsEUROPE extends Constants {

    public ConstantsEUROPE() {
        // OrderCode which will Search for Instock PDP across all env/stores
        orderCode = "9338152";
        nullResultsMessage = "We couldn’t find any products matching";

        // Store specific variables
        switch (getStore().toLowerCase()) {
            case "uk":
                lhsCategories = Arrays.asList("uk1", "uk2");
                myAccountlistItems =
                    Arrays.asList(
                        "Order History & Tracking",
                        "Order Preferences",
                        "Quotes",
                        "BOM Upload",
                        "Saved Basket",
                        "Favourites",
                        "Account Summary",
                        "Profile Information",
                        "Apply for a Trade Account"
                    );

                break;
            case "fr":
                lhsCategories = Arrays.asList("fr11", "fr2", "fr3");
                break;
        }
    }
}
