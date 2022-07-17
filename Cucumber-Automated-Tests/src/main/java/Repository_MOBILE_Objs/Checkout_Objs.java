package Repository_MOBILE_Objs;

import java.util.*;

public class Checkout_Objs {

    // Creation of HashMap
    private static final Map<String, String> Checkout;

    static {
        Checkout = new HashMap<String, String>();

        // Your Details Section
        Checkout.put("yourDetails_form", "//form[@id= 'areo0']");
        Checkout.put("title_dropdown", "//*[@id = 'guestUserTitle']");
        Checkout.put("firstName_textbox", "//*[@id='billingfirstname']");
        Checkout.put("lastName_textbox", "//*[@id='billinglastname']");
        Checkout.put("email_textbox", "//*[@id='billEmail']");
        Checkout.put("primaryRole_dropdown", "//*[@id='primaryRole']");
        Checkout.put("primaryUse_dropdown", "//*[@id='primaryUse']");
        Checkout.put("yourDetailsSectionContinue_button", "//*[@id='area0Continue']");
        Checkout.put(
            "greenTickMarkSection1_icon",
            "(//div[@class='new-accordion-indicator'])[1]"
        );
        Checkout.put("checkout_breadcrumbs", "//*[@id='checkout-breadcrumbs']");

        // Account Section
        Checkout.put("account_section", "//*[@id='PFAccountAddressDisplay']/div[1]/h2");
        Checkout.put(
            "continueAccountSection_button",
            "(//*[@class='checkout-nextsteps']/a)[1]"
        );

        // Invoice and Delivery address Section
        Checkout.put(
            "invoiceAndDeliveryAddress_text",
            "//*[@id='area2Accordion']//*[@class='new-accordion-title ']"
        );
        Checkout.put(
            "editInvoiceAndDeliveryAddress_button",
            "//*[@id='area2Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("addAddressManually_link", "//a[@id='addAddressManually']");
        Checkout.put("companyName_textbox", "//input[@id='billingOrganizationName']");
        Checkout.put("attentionOf_textbox", "//*[@id='billingOfficeAddress']");
        Checkout.put("officeName_textbox", "//input[@id='billingOfficeName']");
        Checkout.put("officePhone_textbox", "//input[@id='billingOfficePhone1']");
        Checkout.put("addressLaneOne_textbox", "//input[@id='billingAddress1']");
        Checkout.put("addressLaneTwo_textbox", "//input[@id='billingAddress2']");
        Checkout.put("townCity_textbox", "//input[@id='billingCity']");
        Checkout.put("countryProvince_textbox", ".//input[@id='billingState']");
        Checkout.put("state_dropdown", ".//select[@id='billingState']");
        Checkout.put("country_dropdown", "//select[@id='billingCountry']");
        Checkout.put("zipCode_textbox", "//input[@id='billingZipCode']");
        Checkout.put(
            "addressSectionContinue_button",
            "(//*[@class='checkout-nextsteps']/a)[3]"
        );
        Checkout.put(
            "shippingAddressSectionContinue_button",
            "(//*[@class='checkout-nextsteps']/a)[2]"
        );
        Checkout.put("paymentInformation_section", "//*[@id='paymentSection']/div[1]/h2");
        Checkout.put("shippingAddress_section", "//*[@id='pay-detail-sect']/div[1]/h2");
        Checkout.put("shippingMethod_section", "//*[@id='ship-methods-sect']/div[1]/h2");

        // Delivery method Section
        Checkout.put(
            "deliveryOptions_text",
            "//*[@id='area3Accordion']//*[@class='new-accordion-title ']"
        );
        Checkout.put("specialInstruction_dropdown", "//*[@id='specialInstructionsId']");
        Checkout.put("editInvoiceAddress_button", "//*[@id='editAddressSection']");
        Checkout.put("editDeliveryAddress_button", "//*[@id='editPaymentSection']");
        Checkout.put("editDeliverySelection_button", "//*[@id='editDeliveryDetails']");
        Checkout.put(
            "deliveryInstructions_textbox",
            "//*[@id='deliveryInstructionsForCarrier' or @id='additionalDeliveryNotes']"
        );
        Checkout.put(
            "specialDeliveryInstructions_textbox",
            "//*[@id='additionalSpecialInstructions']"
        );
        Checkout.put(
            "deliverySectionContinue_button",
            "//*[@id='deliveryOptionContinue']"
        );
        Checkout.put(
            "deliveryAddressSection_greenTickMark",
            "//*[@id='pay-detail-sect']/div[1]/h2"
        );
        Checkout.put("proceedToOrderReview_button", "//*[@id='checkoutProceedButt']");

        // Trade Account method section
        Checkout.put("tradeAccountOption_checkbox", "//*[@id='newExistAccntId']");
        Checkout.put("existingTradeAccount_checkbox", "//*[@id='doUHvTrdAccID1']");
        Checkout.put("existingTradeAccount_link", "//*[@id='linkToAccntId']");
        Checkout.put("paymentMethod_dropdown", "//*[@id='billingMethodId']");
        Checkout.put("tradeAccno_textbox", "//*[@id='accountNumber']");
        Checkout.put("cid_textbox", "//*[@id='customerId']");

        // Payment method Section-3
        Checkout.put(
            "paymentMethod_text",
            "//*[@id='area1Accordion']//*[@class='new-accordion-title ']"
        );
        Checkout.put("editPaymentMethod_button", "//*[@id='editAccountSection']");
        Checkout.put("creditCardNum_textbox", "//*[@id='cardNumber']");
        Checkout.put(
            "creditCardNumWebtokenize_textbox",
            "//*[@class='show']/*[@id='PAN']"
        );
        Checkout.put("expiryMonth_dropdown", "//*[@id='validExpiryMonth']");
        Checkout.put("cardType_dropdown", "//*[@id='cardType']");
        Checkout.put("expiryYear_dropdown", "//*[@id='validExpiryYear']");
        Checkout.put("cvv_textbox", "//*[@id='paymentMethodCardIssueCv2']");
        Checkout.put("cvvWebtokenize_textbox", "//*[@class='show']/*[@id='CVV2']");
        Checkout.put("nameOnCard_textbox", "//*[@id='nameOnCard']");
        Checkout.put("cardHolderPhone_textbox", "//*[@id='cardHolderPhone']");
        Checkout.put(
            "paymentDetailsSectionContinue_button",
            "(//*[@class='checkout-nextsteps']/a)[2]"
        );

        // Payment details Section-4
        Checkout.put(
            "paymentDetails_text",
            "//*[@id='area4Accordion']//*[@class='new-accordion-title ']"
        );
        Checkout.put(
            "editPaymentDetails_button",
            "//*[@id='area4Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("tradeAccount_radio", "//span[@class='tradeAccHeading']");

        // Additional information for New Trade Account
        Checkout.put("averageMonthlySpend_textbox", "//*[@id='monthlySpend']");
        Checkout.put(
            "editAdditionalInformation_button",
            "//*[@id='area5Accordion']//*[@class='btn btnEdit']"
        );
        Checkout.put("companyTradingName_textbox", "//*[@id='fullCompanyNameBuisness']");
        Checkout.put("legalTradingEntry_list", "//*[@id='legalEntity']");
        Checkout.put("accountPayableEmail_textbox", "//*[@id='accountsEmailBuisness']");
        Checkout.put(
            "additionalInformationContinue_button",
            "//*[@id='area5']/div[2]/div/button"
        );

        // Order Review Section
        Checkout.put("poNumber_textbox", "//input[@name='poNumberId']");
        Checkout.put("poReleaseNumber_textbox", "//input[@name='poReleaseNumberId']");
        Checkout.put("termsAndConditions_checkbox", "//*[@id='topSub']");
        Checkout.put("submitOrder_button", "(//*[contains(@class,'submitOrder')])[1]");
        Checkout.put("reviewYourOrder_text", "//*[@id='article']/div[1]/div/h1");

        // Order Confirmation Page
        Checkout.put(
            "orderConfirmationTitle_text",
            "//*[@id='ad_pf_orderconf_espot_03']//h1"
        );
        Checkout.put(
            "orbitOrderConfirmationText_text",
            "//*[contains(@class,'confirmationContainer')]//strong"
        );
        Checkout.put("paypalFrame", "(//iframe[@title='PayPal'])[1]");
        Checkout.put("paypal_button", "//*[@id='buttons-container']/div/div/div/div[1]");
        Checkout.put("paypalLoginWindow_element", "//h1[@id='headerText']");
        Checkout.put("paymentDetails_section", "//*[@id='paysect-content']");
    }

    public String findLocator(String elementName) {
        if (Checkout.containsKey(elementName)) {
            return (Checkout.get(elementName.trim()));
        }

        return null;
    }
}
