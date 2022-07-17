package Common.CONSTANTS;

import java.util.Arrays;

public class ConstantsAPAC extends Constants {

    public ConstantsAPAC() {
        // Region level variables
        nullResultsMessage = "Sorry, we couldn’t find any products matching";
        // OrderCode which will Search for Instock PDP across all env/stores
        orderCode = "2329987";

        // store level variables
        switch (getStore().toLowerCase()) {
            case "sg":
                lhsCategories = Arrays.asList("sg11", "sg2");
                break;
            case "au":
                lhsCategories = Arrays.asList("au1", "au2", "au3");
                break;
            case "cn":
                searchLookaheadHeadingCount = 3;
                break;
        }
    }
}
