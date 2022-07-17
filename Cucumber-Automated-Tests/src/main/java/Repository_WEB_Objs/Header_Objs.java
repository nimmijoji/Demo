package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class Header_Objs {

    // Creation of HashMap
    private static final Map<String, String> Header;

    static {
        Header = new HashMap<String, String>();

        // Search box in Header
        Header.put("all_list", "//*[@id='lookAhead']/div[1]/div[1]");
        Header.put("all_text", "//*[@id='demo']");
        Header.put("anyCategory_dropdown", "//select[@id='categoryIdBox']");
        Header.put("searchBox_textbox", "//*[@id='SimpleSearchForm_SearchTerm']");
        Header.put("searchIcon_button", "//*[@id='searchMain']");
        Header.put("companylogo_element", ".//*[@id='ad_storeLogoESpot']");

        Header.put("category_dropdown", "//*[@id='categoryIdBox']/option[6]");
        Header.put(
            "searchProductList_link",
            "//*[@id='LookAheadProdIdContainer']//tr[1]"
        );

        // Header components common across all page
        Header.put("login_link", "//*[@id='guestPar']/a[1]");
        Header.put("userFirstName_text", "//*[@id='loggedInPar']/span[1]");
        Header.put("amtBlankCart_text", "//*[@class='price-total']");
        Header.put("trackOrders_link", "//a[@href='/order-status']");
        Header.put("miniBasket_link", "//*[@class='shopcart-white']");
        Header.put("itemsInMiniBasket_text", "//*[@class='items-qty']");
        Header.put("itemAddedPopUp_element", "//*[@class='orderItemAdded']");
        Header.put(
            "miniShopcartProductAdded_element",
            "//*[@id='MiniShopCartProductAdded']"
        );
        Header.put("wholeHeader_element", "//*[@id='head']");

        // Header Top right tabs
        Header.put(
            "offer_link",
            "//*[contains(@data-dtm-eventinfo,'Special Offers')][1]"
        );
        Header.put(
            "contactus_link",
            "//*[contains(@data-dtm-eventinfo,'Contact Us')][1]"
        );
        Header.put("help_link", "//*[contains(@data-dtm-eventinfo,'Help')][1]");
        Header.put(
            "Specialoffer_text",
            "//*[@class='page-header-inner inner-header-so']/div/h1"
        );
        Header.put(
            "Contactusheader_text",
            "//*[@class='new-page-header-inner new-contact-us-img']/h1"
        );
        Header.put(
            "helpheader_text",
            "//*[@class='panel-heading small-padding-top small-padding-bottom']/h2[contains(@class,'text-center')]"
        );
        Header.put("trackorderheader_text", "//*[@id='article']/h1");

        // Country dropdown
        Header.put("flag_link", "//div[@data-widget='countryselector']");
        Header.put("country_text", "//*[@id='countrySelector']/div[2]/div[2]/div/div/h2");
        Header.put("country_dropdown", "//*[@class='bsselect']/select");
        Header.put("continue_button", "//*[@class='mini-action']/a");

        //Myaccount Summary dropdown
        Header.put("myAccount_dropdown", "//*[@class='collection-title']/a");
        Header.put(
            "accountSummary_link",
            ".//*[contains(@data-dtm-eventinfo,'User Account')]"
        ); //"//*[@class='list15']/a");
        Header.put("orderHistory_list", "//*[@class='list2']/a");
        Header.put("logout_button", ".//*[contains(@data-dtm-eventinfo,'Log Out')]");
        Header.put(
            "myAccountHeaders_text",
            "(//*[@id='ad_pf_header_espot_myacc']/ul/li[@class='headerList'])"
        );
        Header.put(
            "myaccount_text",
            "//*[@id='ad_pf_header_espot_myacc']/ul/li[contains(@class, 'list')]/a"
        );
        Header.put(
            "myAccount_list",
            "//*[@id='ad_pf_header_espot_myacc']//li[contains(@class,'list')]"
        );
        Header.put(
            "profileInfo_link",
            "//a[contains(@href,'UserRegistrationForm?editRegistration')]"
        );
        Header.put("logout_button", "//a[contains(@href,'LOGOUT')]");
        Header.put(
            "savedBasket_button",
            "//a[contains(@data-dtm-eventinfo,'Saved Basket')]"
        );
        Header.put("bomUpload_link", "//a[contains(@href,'BOM-UPLOAD')]");
        Header.put("cpcMyAccount_list", "//*[@id='ad_pf_header_espot_myacc']/ul/li/a");
        Header.put("cpcFlag_link", "//*[@class='home-flag flags en_UK']");
    }

    public String findLocator(String elementName) {
        if (Header.containsKey(elementName)) {
            return (Header.get(elementName.trim()));
        }

        return null;
    }
    // ******************************************************

}
