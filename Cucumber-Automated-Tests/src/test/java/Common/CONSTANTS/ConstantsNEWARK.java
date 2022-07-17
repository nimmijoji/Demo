package Common.CONSTANTS;

import java.util.Arrays;
import java.util.List;

public class ConstantsNEWARK extends Constants {

    public ConstantsNEWARK() {
        // OrderCode which will Search for Instock PDP across all env/stores
        orderCode = "50B5163";
        nullResultsMessage = "No exact product matches found for";

        // Store specific variables
        switch (getStore().toLowerCase()) {
            case "us":
                lhsCategories = Arrays.asList("us1", "us2");
                break;
            case "canada":
                lhsCategories = Arrays.asList("cn1", "cn2", ",cn3");
                break;
            case "mexico":
                lhsCategories = Arrays.asList("MX1", "MX2", ",MX3");
                break;
        }
    }

    @Override
    public List<String> getLhsCategories() {
        return lhsCategories;
    }
}
