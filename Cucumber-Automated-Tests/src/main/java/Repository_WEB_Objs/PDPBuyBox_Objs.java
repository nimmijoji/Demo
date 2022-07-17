package Repository_WEB_Objs;

import java.util.*;

public class PDPBuyBox_Objs {

    // Creation of HashMap
    private static final Map<String, String> PDPBuyBox;

    static {
        PDPBuyBox = new HashMap<String, String>();
        PDPBuyBox.put("requestaQuote_link", "//div[@class='quoteLink']/a");
        PDPBuyBox.put(
            "availabilityPriceContainer_element",
            "//div[@class='availabilityPriceContainer']"
        );
        PDPBuyBox.put(
            "availabilityHeading_text",
            "//*[@class='availabilityHeading available']"
        );
        PDPBuyBox.put("instock_icon", ".//*[contains(@class,'pdpInstockIcon')]");
        PDPBuyBox.put("cutOffTimeA_text", "//*[contains(@class,'pdpCutOffTimeTxtA')]/p");
        PDPBuyBox.put(
            "cutOffTimeB_text",
            "//*[contains(@class,'pdpCutOffTimeTxtB')]/p[1]"
        );
        PDPBuyBox.put("availabilityList_text", "//div[@class='availabilityList']");
        PDPBuyBox.put("cutOffTimeTooltip_icon", "//*[@class='pdpAwtInfolink']");
        PDPBuyBox.put(
            "tooltipContent_text",
            "//*[@class='pdpPopupInstock pdpToolTipPopup']"
        );
        PDPBuyBox.put(
            "exclVatPrice_text",
            "//*[contains(@class,'productPrice')]//span[contains(@class,'price')]"
        );
        PDPBuyBox.put("priceFor_text", "//div[@class='inventoryStatus']/dl/dt");
        PDPBuyBox.put("priceForValue_text", "//div[@class='inventoryStatus']/dl/dd");
        PDPBuyBox.put("multiple_text", "(//div[@class='multqty']/span)[1]");
        PDPBuyBox.put("minimum_text", "(//div[@class='multqty']/span)[2]");
        PDPBuyBox.put(
            "requestAQuoteTitle_text",
            ".//*[contains(@class,'request-a-quote')]/h1"
        );
        PDPBuyBox.put(
            "qtyLabel_text",
            ".//div[contains(@class,'qtyField')]/strong/label"
        );
        PDPBuyBox.put("qty_textbox", "(//*[contains(@id,'quantity')])[1]");
        PDPBuyBox.put("addToCart_button", "//*[@id='addToOrder']/a");
        PDPBuyBox.put("totalPriceLabelExcVAT_text", "//*[@id='excVatTotalPrice']");
        PDPBuyBox.put("totalPriceExcVAT_text", "//*[@id='_totalPriceEXCVat']");
        PDPBuyBox.put("totalPriceLabelIncVAT_text", "//*[@id='incVatTotalPrice']");
        PDPBuyBox.put("totalPriceIncVAT_text", "//*[@id='_totPriceincAndExcVat']");
        PDPBuyBox.put("addLineNote_link", ".//*[@id='Collapsable_0']");
        PDPBuyBox.put("addtoFavourites_link", ".//*[@id='requisitionList']");

        //Avnet section
        PDPBuyBox.put("avnetSection_element", ".//*[@class='partnerAvnetContainer']");
        PDPBuyBox.put(
            "viewPricingAvailability_link",
            ".//*[@id='avnetAvailabilityTooltipId']"
        );
        PDPBuyBox.put("avnetPopupTitle_text", ".//*[@class='titleHead']");
        PDPBuyBox.put("avnnetManufTitle_text", ".//*[@class='mfnTitle']");
        PDPBuyBox.put("avnetPopupTableHeader_list", ".//*[@class='avnetTable']//th");
        PDPBuyBox.put("viewAvnet_link", ".//*[@class='viewAvnetLink']/a");
        PDPBuyBox.put(
            "avnetPopupFooter_list",
            ".//*[@class='dijitDialogPaneContent']//*[@class='footer']/span"
        );

        // packaging elements
        PDPBuyBox.put("packagingType_text", "//*[@class='packagingType']/span/strong");
        PDPBuyBox.put(
            "packagingTypeValue_text",
            "//*[@class='productMainPackType']/strong"
        );
        PDPBuyBox.put(
            "additionalPackagingOptionsAvailable_link",
            "//*[@class='packageOption']"
        );
        PDPBuyBox.put(
            "packagingOptions_list",
            "//*[@class='productPackOptAvailArea']/span[@class='productPackType']"
        );
        PDPBuyBox.put("firstCheckStock_link", "//*[@class='priceTooltip']");
        PDPBuyBox.put(
            "firstSeeCutOffTimes_link",
            "(//*[contains(@id,'cutOffTimesTooltip') and (@class='clearBoth pdpToolTip')])[1]/a[1]"
        );
        PDPBuyBox.put("deliveryInformation_link", "//*[@class='deliveryInformation']");
        PDPBuyBox.put(
            "firstCheckStockAndLeadTimes_link",
            "//*[ @class='pdpCheckMoreStock']"
        );
        PDPBuyBox.put(
            "packCalculations_element",
            "(//*[@class='packCalFirst vatExcl']/span)[2]"
        );
        PDPBuyBox.put(
            "packTotalPrice_text",
            "(//*[@class='packPriceCalTotal vatExcl']/span)[2]"
        );
        PDPBuyBox.put("packagingPrefsRadio_list", "//*[@id='packageOptionsdiv']//input");
        PDPBuyBox.put("rereelingEAP1_text", "//*[@class='packaging']//strong");
        PDPBuyBox.put("rereelingEAP2_text", "//*[@class='packaging'][2]");
        PDPBuyBox.put("rereelMessage_text", "//*[@id='showReelMessage']");

        //Contract price
        PDPBuyBox.put("contractPrice_icon", "(//div[@class='yourPrice'])[1]");
    }

    public String findLocator(String elementName) {
        if (PDPBuyBox.containsKey(elementName)) {
            return (PDPBuyBox.get(elementName.trim()));
        }

        return null;
    }
}
