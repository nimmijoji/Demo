package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class QuickBuy_Objs {

    // Creation of HashMap
    private static final Map<String, String> QuickBuy;

    static {
        QuickBuy = new HashMap<String, String>();

        //quick Buy
        QuickBuy.put("quickBuy_text", "//*[@class='mk-width-60pc']");
        QuickBuy.put("orderCodePartial_element", "//*[@id='partNumber_");
        QuickBuy.put("quantityPartial_element", "//*[@id='quantity_");
        QuickBuy.put("linNotePartial_element", "//*[@id='comment_");
        QuickBuy.put("partNoPartial_elements", "//*[@id='customerPartNumber_");
        QuickBuy.put("addToBasket_button", "//td[@colspan='4']//input");

        //quick Paste
        QuickBuy.put("quickPaste_button", "//*[@rel='contentPaneTwo']");
        QuickBuy.put("quickPasteArea_textbox", ".//*[@id='quickPasteArea']");
        QuickBuy.put("addToCart_button", ".//*[@id='quickPasteSubmit']");
    }

    public String findLocator(String elementName) {
        if (QuickBuy.containsKey(elementName)) {
            return (QuickBuy.get(elementName.trim()));
        }

        return null;
    }
}
