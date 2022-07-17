package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class PLP_Objs {

    // Creation of HashMap
    private static final Map<String, String> PLP;

    static {
        PLP = new HashMap<String, String>();

        // products table elements
        PLP.put("firstOrderCode_text", "//*[@id='sProdList']/tbody/tr[1]/td[3]/p");
        PLP.put(
            "firstPurchasableOrderCode_text",
            "(//*[contains(@id,'splAddToCart')])[1]/ancestor::td[@class='qty']/preceding-sibling::td[@class='productImage mftrPart']/following-sibling::td/p[@class='sku']"
        );
        PLP.put("firstAdd_button", "(//*[contains(@id,'splAddToCart')])[1]");
        PLP.put("PLP_element", "//table[@id='sProdList']");
        PLP.put("manufacturerFirst_link", "(//p[@class='productDecription'])[1]");
        PLP.put("secondAdd_button", "(//*[contains(@id,'splAddToCart')])[2]");
        PLP.put("quantity_text", "(//input[contains(@id,'pkQuantity')])[1]");
        PLP.put(
            "rohsCertificateOfCompliance_icons",
            "//div[starts-with(@class, 'pfIcon pfRohsCompliance')]"
        );
        PLP.put(
            "rohsCertificateOfCompliance_link",
            "(//div[starts-with(@class, 'pfIcon pfRohsCompliance')])[1]"
        );
        PLP.put("htmlCertificate_link", "//span[@class='pfIcon pfBrowser']");
        PLP.put(
            "rohsCustomerName_text",
            "//*[@id='article']/table[3]/tbody/tr[6]/td[2]/strong"
        );
        PLP.put("firstInStock_link", "(//td[@class='availability']//div)[1]");
        PLP.put(
            "firstManufacturerPartNo_link",
            "//*[@id='sProdList']/tbody/tr[1]/td[2]/a"
        );
        PLP.put("leadTime_popup", "//*[@id='sProdList']/tbody/tr[1]/td[2]/a");
        PLP.put(
            "leadTimePopup_text",
            "//div[@class='arrow_toolTip']//div[@class='bodyarea']"
        );
        PLP.put("manufacturerPartNo_link", "//*[@id='sProdList']/tbody/tr/td[2]/a");
        PLP.put("contractPrice_icon", "//*[@class='pfIcon pfPriceCONTRACT']");
        PLP.put("manufacturerFirst_link", "(//p[@class='productDecription'])[1]");
        PLP.put("secondAdd_button", "(//*[contains(@id,'splAddToCart')])[2]");
        PLP.put("quantity_text", "(//input[contains(@id,'pkQuantity')])[1]");
        PLP.put("compareCheck_checkbox", "//input[@class='compareCheck omTagEvt']");

        PLP.put("allManufacturerPartNo_link", "(.//*[@class='productImage mftrPart']/a)");
        PLP.put("manufacturerName_text", "(//p[@class='manufacturerName'])");
        PLP.put(
            "productRowPartial_element",
            "//*[@id='sProdList']/tbody/tr[contains(@class,'productRow')]"
        );
        PLP.put("allCompareCheck_checkbox", "(//input[@class='compareCheck omTagEvt'])");
        PLP.put("compareSlected_button", "//a[contains(@class,'btn btnQuaternary')]");
        PLP.put(
            "eleventhCompare_checkbox",
            "(//input[@class='compareCheck omTagEvt'])[11]"
        );
        PLP.put("miniBasketOverlay_element", "//div[@id='MiniShopCartProductAdded']");

        // LHS panel related elements
        PLP.put("minimum_dropdown", "(//*[@class='min optnList optnChange'])[1]");
        PLP.put("maximum_dropdown", "(//*[@class='max optnList optnChange'])[1]");
        PLP.put("withinSearch_textbox", "//*[@id='searchWithinTerm']");
        PLP.put("withinSearch_button", "//*[@id=\"searchWithin\"]");
        PLP.put("manufactureSearch_textbox", "//*[@id='staticFiltersmftr']/div[2]/input");
        PLP.put("search_element", "//*[@id='manufacturerHide']/option[2]");
        PLP.put(
            "remember_checkbox",
            "//*[@id='Filtershide']/div/label/input [@id='rememberStaticFilter']"
        );
        PLP.put("availability_text", "(.//div[@class='prodListMarked '])[1]");
        PLP.put("rememberInstock_radio", "(//*[@name='instockoption'])[2]");

        // products table elements
        PLP.put("header_text", "//*[@id='prodResultHeader']");
        PLP.put("tableHeader_text", "//table[@id='sProdList']/thead[1]/tr/th");
        PLP.put("firstOrderCode_text", "//*[@id='sProdList']/tbody/tr[1]/td[3]/p");

        // pagination elements
        PLP.put("pagination_element", "(//div[@class='quaternaryLook'])[1]");
        PLP.put("mySelectTop_dropdown", "//*[@id='mySelectTop']");
        PLP.put("paginThird_element", ".//span[@class='pages']/span[3]");
        PLP.put("paginPrewArrow_element", "//*[@class='paginPrevArrow']");
        PLP.put("PaginNextArrow_element", "(//*[@class='paginNextArrow'])[1]/a");

        // products table header elements
        PLP.put(
            "manfacPartNoAscending_button",
            "//tr[@class='sort-by']/td[2]/a[@class='pfIcon pfAsc']"
        );
        PLP.put(
            "manfacPartNoDescending_button",
            "//tr[@class='sort-by']/td[2]/a[@class='pfIcon pfDsc']"
        );
        PLP.put(
            "orderCodeAscending_button",
            "//tr[@class='sort-by']/td[3]/a[@class='pfIcon pfAsc']"
        );
        PLP.put(
            "orderCodeDescending_button",
            "//tr[@class='sort-by']/td[3]/a[@class='pfIcon pfDsc']"
        );
        PLP.put(
            "descriptionAscending_button",
            "//tr[@class='sort-by']/td[4]/a[@class='pfIcon pfAsc']"
        );
        PLP.put(
            "descriptionDescending_button",
            "//tr[@class='sort-by']/td[4]/a[@class='pfIcon pfDsc']"
        );
        PLP.put(
            "availabilityAscending_button",
            "//tr[@class='sort-by']/td[5]/a[@class='pfIcon pfAsc']"
        );
        PLP.put(
            "availabilityDescending_button",
            "//tr[@class='sort-by']/td[5]/a[@class='pfIcon pfDsc']"
        );
        PLP.put(
            "priceAscending_button",
            "//tr[@class='sort-by']/td[7]/a[@class='pfIcon pfAsc']"
        );
        PLP.put(
            "priceDescending_button",
            "//tr[@class='sort-by']/td[7]/a[@class='pfIcon pfDsc']"
        );

        // products table header elements
        PLP.put("sortDescending_button", "//thead/tr[2]/td[5]/a[@class='pfIcon pfDsc']");
    }

    public String findLocator(String elementName) {
        if (PLP.containsKey(elementName)) {
            return (PLP.get(elementName.trim()));
        }

        return null;
    }
}
