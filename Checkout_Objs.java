package Repository_MOBILE_Objs;

import java.util.*;

public class Checkout_Objs

{

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
		Checkout.put("greenTickMarkSection1_icon", "(//div[@class='new-accordion-indicator'])[1]");
		Checkout.put("checkout_breadcrumbs", "//*[@id='checkout-breadcrumbs']");

		// Account Section
		Checkout.put("account_section", "//*[@id='PFAccountAddressDisplay']/div[1]/h2");
		Checkout.put("continueAccountSection_button", "(//*[@class='checkout-nextsteps']/a)[1]");

		// Invoice and Delivery address Section
		Checkout.put("invoiceAndDeliveryAddress_text", "//*[@id='area2Accordion']//*[@class='new-accordion-title ']");
		Checkout.put("editInvoiceAndDeliveryAddress_button", "//*[@id='area2Accordion']//*[@class='btn btnEdit']");
		Checkout.put("addAddressManually_link", "//a[@id='addAddressManually']");
		Checkout.put("companyName_textbox", "//input[@id='billingOrganizationName']");
		Checkout.put("attentionOf_textbox", "//*[@id='billingOfficeAddress']");
		Checkout.put("officeName_textbox", "//input[@id='billingOfficeName']");
		Checkout.put("officePhone_textbox", "//input[@id='billingOfficePhone1']");
		Checkout.put("addressLaneOne_textbox", "//input[@id='billingAddress1']");
		Checkout.put("addressLaneTwo_textbox", "//input[@id='billingAddress2']");
		Checkout.put("townCity_textbox", "//input[@id='billingCity']");
		Checkout.put("countryProvince_textbox", ".//input[@id='billingState']");
		Checkout.put("state_dropdown",".//select[@id='billingState']");
		Checkout.put("country_dropdown", "//select[@id='billingCountry']");
		Checkout.put("zipCode_textbox", "//input[@id='billingZipCode']");
		Checkout.put("addressSectionContinue_button", "(//*[@class='checkout-nextsteps']/a)[3]");
		Checkout.put("shippingAddressSectionContinue_button", "(//*[@class='checkout-nextsteps']/a)[2]");
		Checkout.put("paymentInformation_section", "//*[@id='paymentSection']/div[1]/h2");
		Checkout.put("shippingAddress_section", "//*[@id='pay-detail-sect']/div[1]/h2");
		Checkout.put("shippingMethod_section", "//*[@id='ship-methods-sect']/div[1]/h2");
		Checkout.put("invoiceAddressTitle_text", "//*[@id='paysect-content']/div[2]//h5");
		Checkout.put("addInvoiceAddressTitle_text", "//*[@id='BillingSecMainDivId']/ul/h2");
		Checkout.put("newAddressUpdationDetailsOfInv_text", "(//*[@class='addWarn'])[1]");
		Checkout.put("yourInformationTitle_text", "//*[@id='paysect-content']/h4");
		Checkout.put("yourInformationDetails_text", "//*[@id='paysect-content']/p");
		Checkout.put("privacyPolicy_link", "//*[@id='paysect-content']/p/a");
		Checkout.put("confirmContactDetails_text", "//*[@id='contactDetails']");
		Checkout.put("email_checkbox", "//*[@id='emailSignUpId']");
		Checkout.put("email_label", "//*[@id='contactDetails']/div/label");
		Checkout.put("deliveryAddressSectionTitle_text", "//*[@id='pay-detail-sect']/div/h2");
		Checkout.put("deliveryAddressHeading_text", "(//*[@class='ss-head-area']/h5)[2]");
		Checkout.put("invoiceAddressHeading_text", "(//*[@class='ss-head-area']/h5)[1]");
		Checkout.put("shippingAddress_checkbox", "//*[@id='delAdrSameAsInvAdr' and @class='pfCheckbox']");
		Checkout.put("shippingAddressCheckbox_label", "//*[@id='delAdrSameAsInvAdrDiv']");
		Checkout.put("setInvAddressAsPreferredAddress_label", "(//*[@id='prefAddresDivId']/label)[1]");
		Checkout.put("setInvAddressAsPreferredAddress_checkbox", "(//*[@class='pfCheckboxLabel checkoutCheckLabel']//input)[1]");
		Checkout.put("billingAddress_icon", "//*[@id='inlineAjaxFormToolTip_Billing']");
		Checkout.put("setInvAsPreferredAddressPopUp_text", "//*[@id='tt-inlineAjaxFormToolTip_Billing']//*[@class='popover-content']");
		Checkout.put("billingAddressFormLabels_list", "(//*[@class='spin_container'])[1]//*[contains(@id,'WC_ShoppingCartAddressEntryFormf')]/label");
		Checkout.put("billingAddressFormLabels_list", "(//*[@class='spin_container'])[3]//*[contains(@id,'WC_ShoppingCartAddressEntryFormf')]/label");
		Checkout.put("setDelAddressAsPreferredAddress_checkbox", "(//*[@id='prefAddresDivId']/label)[3]");
		Checkout.put("setDelAddressAsPreferredAddress_label", "(//*[@class='pfCheckboxLabel checkoutCheckLabel']//input)[3]");
        Checkout.put("newAddressUpdationDetailsOfDel_text", "(//*[@class='addWarn'])[4]");
        Checkout.put("setDelAddressSameAsInv_checkbox", "//*[@id='delAdrSameAsInvAdr']");
		Checkout.put("setDelAddressSameAsInv_label", "//*[@id='delAdrSameAsInvAdrDiv']/label");
		Checkout.put("deliveryAddress_icon", "//*[@id='inlineAjaxFormToolTip_Shipping']");
		Checkout.put("setDelAsPreferredAddressPopUp_text", "//*[@id='tt-inlineAjaxFormToolTip_Shipping']//*[@class='popover-content']");
        Checkout.put("useThisAddressThird_button", "(//*[contains(@id,'ShippingHdrDivId')])[3]");
        Checkout.put("addNewAddressInvoice_button", "//*[@id='BillingAddNewAddress']");
		Checkout.put("saveBillingAddressOnOverlay_button", "//*[@id='BillingSaveOverlayAddress']");
		Checkout.put("addNewAddressDelivery_button", "//*[@id='ShippingAddNewAddress']");
		Checkout.put("saveDeliveryAddressOnOverlay_button", "//*[@id='ShippingSaveOverlayAddress']");
		Checkout.put("setDelAddressAsPreferredAddressOnOverlay_checkbox", "//*[@id='prefShippingAddress']");
		Checkout.put("editInVoiceAddressInPaymentDetails_link", "(//*[@class='selAddBotttom'])[2]/a[1]");
		Checkout.put("deleteInvoiceAddressInPaymentDetails_link", "(//*[@class='selAddBotttom'])[2]/a[2]");
		Checkout.put("editDeliveryAddressInPaymentDetails_link", "(//*[@class='selAddBotttom'])[3]/a[1]");
		Checkout.put("deleteDeliveryAddressInPaymentDetails_link", "(//*[@class='selAddBotttom'])[3]/a[2]");
		Checkout.put("useThisAddressThirdInPaymentDetails_button", "(//*[contains(@id,'BillingHdrDivId')])[3]");
		Checkout.put("editDelAddressInDeliveryDetails_link", "(//*[@id='ShippingDataDivId_3']/div/a)[2]");
		Checkout.put("deleteDelAddressInDeliveryDetails_link", "(//*[@id='ShippingDataDivId_3']/div/a)[1]");
		Checkout.put("invoiceAddressEntered_list", "//*[contains(@id,'BillingDataDivId')][1]//*[contains(@class,'clr')]");
        Checkout.put("deliveryAddressEntered_list", "//*[contains(@id,'ShippingDataDivId')][1]//*[contains(@class,'clr')]");
		
		
		
        // Delivery method Section
		Checkout.put("deliveryOptions_text", "//*[@id='area3Accordion']//*[@class='new-accordion-title ']");
		Checkout.put("specialInstruction_dropdown", "//*[@id='specialInstructionsId']");
		Checkout.put("editInvoiceAddress_button", "//*[@id='editAddressSection']");
		Checkout.put("editDeliveryAddress_button", "//*[@id='editPaymentSection']");
		Checkout.put("editDeliverySelection_button", "//*[@id='editDeliveryDetails']");
		Checkout.put("deliveryInstructions_textbox",
				"//*[@id='deliveryInstructionsForCarrier' or @id='additionalDeliveryNotes']");
		Checkout.put("specialDeliveryInstructions_textbox", "//*[@id='additionalSpecialInstructions']");
		Checkout.put("deliverySectionContinue_button", "//*[@id='deliveryOptionContinue']");
		Checkout.put("deliveryAddressSection_greenTickMark", "//*[@id='pay-detail-sect']/div[1]/h2");
		Checkout.put("proceedToOrderReview_button", "//*[@id='checkoutProceedButt']");
		Checkout.put("deliveryMethodSectionTitle_text", "//*[@id='ship-methods-sect']/div/h2");
		Checkout.put("deliveryInstructionsTitle_text", "//*[contains(@class,'notesInstructions')]/h3");
		Checkout.put("deliveryInstructionsComment_text", "//*[contains(@class,'notesInstructions')]/p");
		Checkout.put("specialInstructionsComment_text", "//*[@class='halfWidth']/p");
		Checkout.put("specialInstructionsTitle_text", "//*[@class='halfWidth']/h3");
		Checkout.put("guideLinesToSelectSpecialInstructions_text", "//*[@class='halfWidth']/p[1]");
		Checkout.put("specialInstructionsWillBeFollowed_text", "//*[@class='halfWidth']/p[1]");
		Checkout.put("charLeftInDelInstructions_text", "(//*[contains(@class,'formFields charsLeft')]/div/p)[1]");
		Checkout.put("charLeftInSplInstructions_text", "(//*[contains(@class,'formFields charsLeft')]/div/p)[2]");


		// Trade Account method section
		Checkout.put("tradeAccountOption_checkbox", "//*[@id='newExistAccntId']");
		Checkout.put("existingTradeAccount_checkbox", "//*[@id='doUHvTrdAccID1']");
		Checkout.put("existingTradeAccount_link", "//*[@id='linkToAccntId']");
		Checkout.put("paymentMethod_dropdown", "//*[@id='billingMethodId']");
		Checkout.put("tradeAccno_textbox", "//*[@id='accountNumber']");
		Checkout.put("cid_textbox", "//*[@id='customerId']");
		Checkout.put("selectExistingTradeAccount_text","//*[@id='accountDisplayId']/label");
        Checkout.put("existingTradeAccount_radio", "(//*[contains(@id,'existingAccntSel')])[1]");
        Checkout.put("existingTradeAccountNumber_text", "(//*[@class='trade_select'])[1]/li/b");
        Checkout.put("existingTradeAccountDetails_text", "(//*[@class='trade_selaccount'])[1]");
        
        
		// Payment method Section-3
		Checkout.put("paymentMethod_text", "//*[@for='billingMethodId']");
		Checkout.put("editPaymentMethod_button", "//*[@id='editAccountSection']");
		Checkout.put("creditCardNum_textbox", "//*[@id='cardNumber']");
		Checkout.put("creditCardNumWebtokenize_textbox", "//*[@class='show']/*[@id='PAN']");
		Checkout.put("expiryMonth_dropdown", "//*[@id='validExpiryMonth']");
		Checkout.put("cardType_dropdown", "//*[@id='cardType']");
		Checkout.put("expiryYear_dropdown", "//*[@id='validExpiryYear']");
		Checkout.put("cvv_textbox", "//*[@id='paymentMethodCardIssueCv2']");
		Checkout.put("cvvWebtokenize_textbox", "//*[@class='show']/*[@id='CVV2']");
		Checkout.put("nameOnCard_textbox", "//*[@id='nameOnCard']");
		Checkout.put("cardHolderPhone_textbox", "//*[@id='cardHolderPhone']");
		Checkout.put("paymentDetailsSectionContinue_button", "(//*[@class='checkout-nextsteps']/a)[2]");

		// Payment details Section-4
		Checkout.put("paymentDetails_text", "//*[@id='paymentSection']/div/h2");
		Checkout.put("editPaymentDetails_button", "//*[@id='area4Accordion']//*[@class='btn btnEdit']");
		Checkout.put("tradeAccount_radio", "//span[@class='tradeAccHeading']");
		

		// Additional information for New Trade Account
		Checkout.put("averageMonthlySpend_textbox", "//*[@id='monthlySpend']");
		Checkout.put("editAdditionalInformation_button", "//*[@id='area5Accordion']//*[@class='btn btnEdit']");
		Checkout.put("companyTradingName_textbox", "//*[@id='fullCompanyNameBuisness']");
		Checkout.put("legalTradingEntry_list", "//*[@id='legalEntity']");
		Checkout.put("accountPayableEmail_textbox", "//*[@id='accountsEmailBuisness']");
		Checkout.put("additionalInformationContinue_button", "//*[@id='area5']/div[2]/div/button");

		// Order Review Section
		Checkout.put("poNumber_textbox", "//input[@name='poNumberId']");
		Checkout.put("poReleaseNumber_textbox", "//input[@name='poReleaseNumberId']");
		Checkout.put("termsAndConditions_checkbox", "//*[@id='topSub']");
		Checkout.put("submitOrder_button", "(//*[contains(@class,'submitOrder')])[1]");
		Checkout.put("reviewYourOrder_text", "//*[@id='article']/div[1]/div/h1");
		Checkout.put("pleaseReviewAndSubmitOrder_text","//*[@id='pf_ordersum_espot_01']//*[@class='mk-bottommargin-6']");
		Checkout.put("stdFreeDelivery_text", "//*[@id='ad_pf_ordersum_espot_01']/div/p[2]");
		Checkout.put("acceptTermsAndConditionsOnTop_checkbox", "(//*[@class='checkbox'])[1]/input");
		Checkout.put("termsAndConditionsToAcceptOrderonTop_link", "(//*[@class='checkbox'])[1]//a");
		Checkout.put("submitOrderInBottom_button", "(//*[contains(@class,'submitOrder')])[2]");
		
		//Payment Details in Order Review Section
		Checkout.put("paymentDetailsTitle_text", "//*[contains(@class,'payment-details')]/h2");
		Checkout.put("paymentDetailsEdit_button", "//*[contains(@class,'payment-details')]/h2/a");
		Checkout.put("paymentDetailsOfOrder_list", "//*[contains(@class,'payment-details')]/p[1]/strong");
		Checkout.put("poNumberInOrderReview_label", "//*[contains(@class,'payment-details')]/p[2]/strong");
		Checkout.put("poNumberInOrderReview_text", "//*[contains(@class,'payment-details')]/p[2]");
		Checkout.put("yourAccountBilledAccordingToTerms_text", "//*[contains(@class,'payment-details')]/p[3]");
		Checkout.put("termsAndConditionsForBilling_link", "//*[contains(@class,'payment-details')]/p[3]/a");
		
		//Invoice Address details in Order Review Section
		Checkout.put("invoiceAddressTitle_text", "//*[contains(@class,'billing-address')]/h3");
		Checkout.put("invoiceAddressEdit_button", "//*[contains(@class,'billing-address')]/h3/a");
		Checkout.put("invoiceAddressDetailsOfOrder_element", "(//*[@class='shipAddress'])[1]");
		Checkout.put("invoiceAndTaxDetailsSection_title", "//*[contains(@class,'invoice-details')]/h3");
		
		//Delivery Address details in Order Review Section
		Checkout.put("deliveryAddressSectionTitle_text", "//*[contains(@class,'shipping-addresses')]/h2");
		Checkout.put("deliveryAddressEdit_button", "//*[contains(@class,'shipping-addresses')]/h2/a");
		Checkout.put("deliveryAddress_text", "//*[contains(@class,'shipping-addresses')]/h3");
		Checkout.put("deliveryAddressDetailsOfOrder_element", "(//*[@class='shipAddress'])[2]");
		
		//Delivery Selection and Order Options in Order Review Section
		Checkout.put("deliverySelectionTitle_text", "//*[contains(@class,'shipping-selection')]/h2");
		Checkout.put("deliverySelectionEdit_button", "//*[contains(@class,'shipping-selection')]/h2/a");
		Checkout.put("deliveryMethod_label", "//*[contains(@class,'shipping-selection')]//strong");
		Checkout.put("deliveryMethod_element", "//*[contains(@class,'shipping-selection')]/div/p");
		
		//Delivery and Special Instructions in Order Review Section
		Checkout.put("deliveryInstructionTitle_text", "//*[contains(@class,'notesInstructions')]/h3");
		Checkout.put("specialInstructionsTitle_text", "//*[contains(@class,'notesInstructions')]/div/h3");
		
		//Items to be shipped in Order Review Section
		Checkout.put("itemToBeShippedTitle_text", "//*[contains(@class,'scheduleTable')]/h2");
		Checkout.put("editBasket_button", "//*[@class='reviewActions']//a");
		Checkout.put("orderSummaryTotal_element", "//*[@id='summaryTotals']");
		Checkout.put("allItemTotal_label", "//*[@id='allItemTotal']/td[1]");
		Checkout.put("allItemTotalValue_text", "//*[@id='allItemTotal']/td[2]");
		Checkout.put("delivery_label", "//*[@id='basicShippingCharge']/td[1]");
		Checkout.put("deliveryValue_text", "//*[@id='basicShippingCharge']/td[2]");
		Checkout.put("vat_label", "//*[@id='tax']/td[1]");
		Checkout.put("vatValue_text", "//*[@id='tax']/td[2]");
		Checkout.put("orderTotal_label", "//*[@id='Total']/td[1]");
		Checkout.put("orderTotalValue_text", "//*[@id='Total']/td[2]");
		Checkout.put("salesTaxCalcInfo_text", "//*[@class='salesTax']");
		Checkout.put("itemNumber_text", "//*[@class='badge']");
		Checkout.put("productDesc_link", "//*[@class='descript']/a");
		Checkout.put("orderCodeTableHeader_list", "//*[@class='outlined-section']/table/thead/tr/th");
		Checkout.put("orderCodeTableBody_list", "//*[@class='outlined-section']/table/tbody/tr/td");
		Checkout.put("additionalInformationCollapsable_element", "//*[contains(@class,'collapsable')]");
		Checkout.put("addtlInfoExpandedSection_element", "//*[@class='collapsable open']");
		Checkout.put("QtyAndLinePriceTableHeaders_list", "(//*[@class='table table-condensed table-no-borders'])[2]//tr/th");
		Checkout.put("orderSummaryTableValues_list", "//*[@id='summaryTotals']/tbody/tr/td[@class='rightAlign']");
		Checkout.put("QtyAndLinePriceTableValues_list", "(//*[@class='table table-condensed table-no-borders'])[2]//tr/td");
		
		
		
		//Additional Information collapse section details in Order Review Section
		Checkout.put("scheduledQty_textbox", "//*[@class='schQty']");
		Checkout.put("moreStockExpected_text", "//*[@class='more-stock-expected section']");
		Checkout.put("contactMeWhenBackInStock_link", "//*[@class='cmbisLink']");
		Checkout.put("roHSCompliant_label", "//*[@class='attrRestraint']");
		Checkout.put("roHSCIcon_icon", "//*[contains(@class,'pfIcon pfRohsCompliance')]");
		Checkout.put("roHSPlusIcon_icon", "//*[@class='plusIcon']");
		Checkout.put("roHSYes_label", "//*[@class='rohsLabel']");
		Checkout.put("addtlInfoCollapseElements_list", "//*[contains(@class,'collapsable')]//tbody/tr/th");

		// Order Confirmation Page
		Checkout.put("orderConfirmationTitle_text", "//*[@class='orderConfForm']/h1");
		Checkout.put("orbitOrderConfirmationText_text", "//*[contains(@class,'confirmationContainer')]//strong");
		Checkout.put("paypalFrame", "(//iframe[@title='PayPal'])[1]");
		Checkout.put("paypal_button", "//*[@id='buttons-container']/div/div/div/div[1]");
		Checkout.put("paypalLoginWindow_element", "//h1[@id='headerText']");
		Checkout.put("paymentDetails_section", "//*[@id='paysect-content']");
		Checkout.put("thankYou_text", "//*[@class='mk-col-100']/h1");
		Checkout.put("yourOrderReference_text", "//*[@class='messagesCheckout reviewConfSect']/p[2]");
		Checkout.put("emailSentConfirmation_text", "//*[@class='messagesCheckout reviewConfSect']/p[1]");
		Checkout.put("trackOrderStatus_text", "//*[@class='messagesCheckout reviewConfSect']/p[3]");
		Checkout.put("termsAndConditionsOfOrderTracking_link", "//*[@class='messagesCheckout reviewConfSect']/p[3]/a");
		Checkout.put("continueShoppingInTop_button", "(//*[@class='actionBox']/a)[1]");
		Checkout.put("continueShoppingInBottom_button", "(//*[@class='actionBox']/a)[2]");
		Checkout.put("shareYourOrder_button", "//*[@class='order-detail-btns']");

		Checkout.put("requiredField_text", "//*[@class='required-fields-message']");
		Checkout.put("accountSectionTitle_text", "//*[@id='PFAccountAddressDisplay']/div/h2");
		Checkout.put("selectTradeAccountNo_radio", "//*[@id='doUHvTrdAccID0']");
		Checkout.put("selectTradeAccountYes_radio", "//*[@id='doUHvTrdAccID1']");
		Checkout.put("doYouHaveTradeAcc_label", "//*[@class='trade_sel']/label");
		Checkout.put("openNewTradeAccount_label", "(//*[@class='checkbox'])[1]/label");
		Checkout.put("openNewTradeAccount_checkbox", "(//*[@class='checkbox'])[1]/label/input");
		Checkout.put("tradeAccountTooltip_icon", "//*[@id='xtradeAccntTooltipId']");
		Checkout.put("tradeTerms_text", "//*[@id='creditAccountDelivery']");
		Checkout.put("tradeAccountTermsAndConditions_text", "//*[@id='accountTerms']");
		Checkout.put("tradeAccountTermsAndConditions_link", "//*[@id='accountTerms']/a");
		Checkout.put("enterPONumber_text", "//*[contains(@class,'accountRightCont')]/p");
		Checkout.put("PONumber_label", "//*[contains(@class,'accountRightCont')]/div/label");
		Checkout.put("PONumber_textbox", "//*[@id='poNumberId']");
		Checkout.put("paymentSection_title", "//*[@id='paymentSection']/div/h2");

		
		//Account Section Label
		Checkout.put("accountNumber_label", "//*[@id='accNum']/label");
		Checkout.put("customerID_label", "//*[@id='cId']/label");
		
		Checkout.put("acceptTermsAndConditionsInBottom_checkbox", "(//*[@class='checkbox'])[2]/input");
		Checkout.put("termsAndConditionsToAcceptOrderInBottom_link", "(//*[@class='checkbox'])[2]//a");
		
		Checkout.put("useThisAddressFirstButton", "(//*[contains(@id,'BillingHdrDivId')])[1]");
		Checkout.put("useThisAddressSecondButton", "(//*[contains(@id,'BillingHdrDivId')])[2]");
		Checkout.put("deleteAddress_button", "//*[@id='delpopup']//*[@class='modal-footer']/a[1]");
		
		//Delete pop up
		Checkout.put("deleteAddress_element", "//*[@class='modal-content']");
		Checkout.put("deleteAddressTitleOnPopup_text", "//*[@class='modal-title']");
		Checkout.put("doYouWantToDeleteAddress_text", "//*[@class='modal-body']");
		Checkout.put("deleteAddressOnPopup_button", "//*[@class='modal-footer']/a");
		Checkout.put("cancelAdressDeletionOnPopup_button", "//*[@class='modal-footer']/button");
		
		
	}

	public String findLocator(String elementName) {

		if (Checkout.containsKey(elementName)) {
			return (Checkout.get(elementName.trim()));
		}

		return null;
	}

}
