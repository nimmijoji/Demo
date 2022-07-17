package Repository_WEB_Objs;

import java.util.*;

public class Home_Objs {

    // Creation of HashMap
    private static final Map<String, String> Home;

    static {
        Home = new HashMap<String, String>();

        // Menu bar elements
        Home.put("allProducts_link", "(//*[@class='megaMenu']/ul/li[1]/a)[1]");
        Home.put("manufacturers_link", "//*[@id='ad_pf_megamenu_espot_01_defer']/a");
        Home.put("resource_link", "//*[@id='ad_pf_megamenu_espot_02_defer']/a");
        Home.put("communities_link", "//*[@id='ad_pf_megamenu_espot_03_defer']/a");
        Home.put("favorites_link", "//*[@id='ad_pf_megamenu_espot_05_defer']/a");
        Home.put("lhsSuperCategories_list", ".//*[@class='superCats subnav']/li/a");
        Home.put(
            "popularmanufacturer_label",
            "//*[@id='ad_pf_megamenu_espot_01_defer']/ul/li/h3"
        );
        Home.put(
            "resources_list",
            "//*[@id='ad_pf_megamenu_espot_02_defer']/ul/li/ul/li[@class='heading']"
        );
        Home.put(
            "element14_image",
            "//*[@id='ad_pf_megamenu_espot_03_defer']/ul/li[1]/a[1]/img"
        );

        // tools dropdown elements
        Home.put("tools_link", "//*[@id='ad_pf_megamenu_espot_04_defer']/a");
        Home.put("tools_list", "//*[@id='ad_pf_megamenu_espot_04_defer']/ul/li/a");
        Home.put("quickBuy_link", "(//*[@class='subnav simpleList']/li[1]/a)[1]");

        // Super categories section
        Home.put("subCategory_element", "//*[@id='pf_homepage_espot_03']/div/div/div[2]");
        Home.put("subCategory_list", "//*[@id='mkt-supercat-btns']/div/ul/li");
        Home.put(
            "subCategoryAutomation_element",
            "//*[@id='mkt-supercat-btns']/div/ul/li"
        );
        Home.put("automationCategory_link", "//*[@id='mkt-automation-menu']/ul/li/h4/a");

        // service proposition section
        Home.put(
            "sameDayShipSection_element",
            "//*[@class='services-block ser-icon-1 small-margin']/p[1]"
        );
        Home.put(
            "sameDayShipProducts_element",
            "//*[@class='services-block ser-icon-1 small-margin']/p[2]"
        );
        Home.put(
            "unParalleledCustomerService_element",
            "//*[@class='services-block ser-icon-3 small-margin']/p[1]"
        );
        Home.put(
            "unParallelCustomerServiceSubtitle_element",
            "//*[@class='services-block ser-icon-3 small-margin']/p[2]"
        );
        Home.put(
            "serviceTitle_element",
            "//*[@class='services-block ser-icon-2 small-margin']/p[1]"
        );
        Home.put(
            "serviceSubtitle_element",
            "//*[@class='services-block ser-icon-2 small-margin']/p[2]"
        );
        Home.put(
            "marketLeadingTitle_element",
            "//*[@class='services-block ser-icon-4 small-margin']/p[1]"
        );
        Home.put(
            "marketLeadingSubtitle_element",
            "//*[@class='services-block ser-icon-4 small-margin']/p[2]"
        );

        // New products section
        Home.put("newProducts_label", "//*[@class='prod-mod-header new-prod-header']");
        Home.put(
            "newProductCaroselBack_button",
            "(//*[@class='product-carousel-btn-back'])[2]"
        );
        Home.put(
            "newProductsForwardCarosel_button",
            "(//*[@class='product-carousel-btn-forward'])[2]"
        );
        Home.put(
            "newProductsValues_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[2]/ul/li"
        );

        // Great deal section
        Home.put("greatDeal_label", "//*[@class='prod-mod-header great-deal-header']");
        Home.put(
            "greatDealCaroselBack_button",
            "(//*[@class='product-carousel-btn-back'])[3]"
        );
        Home.put(
            "greatDealForwardCarosel_button",
            "(//*[@class='product-carousel-btn-forward'])[3]"
        );
        Home.put(
            "greatDealValues_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[3]/ul/li"
        );

        // featured products section
        Home.put(
            "featuredProduct_label",
            "//*[@class='prod-mod-header featured-prod-header']"
        );
        Home.put(
            "featuredProductCaroselBack_button",
            "(//*[@class='product-carousel-btn-back'])[4]"
        );
        Home.put(
            "featuredProductForwardCarosel_button",
            "(//*[@class='product-carousel-btn-forward'])[4]"
        );
        Home.put(
            "featuredProductValues_list",
            "(//*[@class='panel panel-default product-carousel-dev2 small-margin'])[4]/ul/li"
        );

        // Manufacturers section
        Home.put("manufactureHeader_label", "//*[@class='manu-header']");
        Home.put(
            "manufacturerList_image",
            "//*[@class='panel panel-default small-margin border-sm']/div[2]/div[contains(@class,'manf-logo')]/a"
        );
        Home.put(
            "customerSerive_label",
            "//*[@class='row small-margin-bottom']/div[1]/div/div"
        );
        Home.put(
            "quickLinks_label",
            "//*[@class='row small-margin-bottom']/div[2]/div/div"
        );
        Home.put("aboutUs_label", "//*[@class='row small-margin-bottom']/div[3]/div/div");
        Home.put("signUp_button", "//*[@class='row small-margin-bottom']/div[4]/div/p/a");
        Home.put("visa_image", "//*[@class='payment-card payment-card-visa']");
        Home.put(
            "masterCard_image",
            "//*[@class='payment-card payment-card-mastercard']"
        );
        Home.put("americanExpress_image", "//*[@class='payment-card payment-card-amex']");
        Home.put(
            "tradeAccount_image",
            "//*[contains(@class,'payment-card payment-card-trade-account')]"
        );
        Home.put("youtube_icon", "//*[@class='social-logos social-logos-youtube']");
        Home.put("facebook_icon", "//*[@class='social-logos social-logos-facebook']");
        Home.put("twitter_icon", "//*[@class='social-logos social-logos-twitter']");
        Home.put("linkedin_icon", "//*[@class='social-logos social-logos-linkedin']");
        Home.put("privacy_link", "//*[@class='footer-quick-links-small']/ul/li[1]/a");
        Home.put(
            "termsOfAccess_link",
            "//*[@class='footer-quick-links-small']/ul/li[2]/a"
        );
        Home.put(
            "legalCopyRight_link",
            "//*[@class='footer-quick-links-small']/ul/li[3]/a"
        );
        Home.put(
            "termsOfPurchase_link",
            "//*[@class='footer-quick-links-small']/ul/li[4]/a"
        );
        Home.put(
            "cookieSettings_link",
            "//*[@class='footer-quick-links-small']/ul/li[5]/a"
        );

        Home.put(
            "allBuyingtools_link",
            ".//*[contains(@data-dtm-eventinfo,'buying-tools')]"
        );
        Home.put(
            "allServices_link",
            "(.//*[@id='ad_pf_megamenu_espot_02_defer']//ul[1]/li[@class='viewAll']/a)[1]"
        );
        Home.put(
            "alltechnicalResources_link",
            ".//a[@data-dtm-eventinfo='technical-resources|Header Navigation']"
        );
        Home.put("help_link", ".//a[@data-dtm-eventinfo='help|Header Navigation']");
        //Home.put("viewAllProducts", ".//a[@data-dtm-eventinfo='All Products|Header Navigation']");
        Home.put("viewAllProducts", "(//div[@id='ad_pf_megamenu_supercats_espot_02']/a)");
        Home.put(
            "community_link",
            "(//*[@id='ad_pf_megamenu_espot_03_defer']//ul/li/a)[1]"
        );
        Home.put("community_tab", "//*[@id='ad_pf_megamenu_espot_03_defer']/a");

        //cpc elements
        Home.put("featuredAccess_link", "//*[@class='megaMenu']/ul/li[2]/div/div/a");
        Home.put(
            "powerTools_label",
            "//*[@class='col-xs-12 col-md-6 copy-box-wrap']/div/h1"
        );
        Home.put("cpcTools_link", "//*[@class='megaMenu']/ul/li[3]/div/div/a");
        Home.put("cpcTools_list", "//*[@class='megaMenu']/ul/li[3]/div/div/ul/li");
        Home.put("cpcQuickBuy_link", "//*[@class='megaMenu']/ul/li[3]/div/div/ul/li[1]");
        Home.put("cpcResource_link", "//*[@id='ad_pf_megamenu_espot_03']/a");
        Home.put("cpcResource_list", "//*[@class='subnav column3']/li/ul/li/a");
        //Home.put("deliveryInfo_link", "(//*[@class='marketing promo-head group']/following::a/h3)[1]");
        Home.put(
            "deliveryInfo_link",
            "(//*[@class='marketing promo-head group']/ul/li/a)[1]"
        );
        //Home.put("collectInStore_link", "(//*[@class='marketing promo-head group']/following::a/h3)[2]");
        Home.put(
            "collectInStore_link",
            "(//*[@class='marketing promo-head group']/ul/li/a)[2]"
        );
        Home.put(
            "FirstFeaturedAccess_link",
            "//*[@id='ad_pf_megamenu_espot_01']/ul/li/ul/li[1]/a"
        );
        Home.put(
            "FirstFeaturedAccess_text",
            "//*[@class='col-xs-12 col-md-6 copy-box-wrap']/div/h1"
        );
        Home.put("cpcSubCategory_list", "//*[@class='col-xs-1']/a");
        Home.put("cpcSubCategoryAudioVisual_link", "(//*[@class='col-xs-1']/a)[1]");
        Home.put(
            "cpcFreeUKDelivery_tab",
            "//*[@class='row home-service-tiles']/div[1]/a/h4"
        );
        Home.put(
            "cpcCollectDelivery_tab",
            "//*[@class='row home-service-tiles']/div[2]/a/h4"
        );
        Home.put(
            "cpcNeedSomehelp_tab",
            "//*[@class='row home-service-tiles']/div[3]/a/h4"
        );
        Home.put(
            "trade_tab",
            "//*[@class='container home-service-tiles']/div[1]/div[1]/a/h4"
        );
        Home.put(
            "quote_tab",
            "//*[@class='container home-service-tiles']/div[1]/div[2]/a/h4"
        );
        Home.put(
            "delivery_tab",
            "//*[@class='container home-service-tiles']/div[1]/div[3]/a/h4"
        );
        Home.put(
            "contact_tab",
            "//*[@class='container home-service-tiles']/div[2]/div[1]/a/h4"
        );
        Home.put(
            "counter_tab",
            "//*[@class='container home-service-tiles']/div[2]/div[2]/a/h4"
        );
        Home.put(
            "catalogue_tab",
            "//*[@class='container home-service-tiles']/div[2]/div[3]/a/h4"
        );
        Home.put(
            "publication_tab",
            "//*[@class='container home-service-tiles']/div[3]/div[1]/a/h4"
        );
        Home.put(
            "emails_tab",
            "//*[@class='container home-service-tiles']/div[3]/div[2]/a/h4"
        );
        Home.put(
            "manufacturers_tab",
            "//*[@class='container home-service-tiles']/div[3]/div[3]/a/h4"
        );
        Home.put(
            "cpcPrivacyStatement_link",
            "//*[@class='footer-quick-links-small']/ul/li[1]/a"
        );
        Home.put(
            "cpcTermsOfAccess_link",
            "//*[@class='footer-quick-links-small']/ul/li[2]/a"
        );
        Home.put(
            "cpcTermsOfPurchase_link",
            "//*[@class='footer-quick-links-small']/ul/li[3]/a"
        );
        Home.put(
            "cpcCookieSettings_link",
            "//*[@class='footer-quick-links-small']/ul/li[4]/a"
        );

        //china
        Home.put(
            "chinaLegalNotice_link",
            "//*[@class='footer-quick-links-small']/ul/li[2]/a"
        );
        Home.put(
            "chinaTermAndCondition_link",
            "//*[@class='footer-quick-links-small']/ul/li[3]/a"
        );
        Home.put("weChat_image", "//*[@class='payment-card-wechat']");
        Home.put("aliPay_image", "//*[@class='payment-card payment-card-alipay']");
        Home.put(
            "cardOnDelivery_image",
            "//*[@class='payment-card payment-card-on-delivery']"
        );
        Home.put(
            "cardbanktransfer_image",
            "//*[@class='payment-card payment-card-bank-transfer']"
        );
    }

    public String findLocator(String elementName) {
        if (Home.containsKey(elementName)) {
            return (Home.get(elementName.trim()));
        }

        return null;
    }
}
