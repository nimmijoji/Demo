#Author: Sandhya Seelam

 @editcheckout @checkout @sandhya
Feature: Perform regression on Order Review and Order Confirmation sections in the Checkout page

    Background: Given web site is launched successfully and user "does" accept the cookies
  
  @editcheckout @checkout @sandhya
  Scenario: Place first order using tradeaccount
     Given customer accesses the website as "register" user
     And I save the newly registered "firsttimeorder" user details
     When I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
     And I click the "Header.searchIcon_button"
     And I wait for "3" seconds
     And I click on "PDP.addToCart_button"
     Then I wait "medium" duration for "PDP.addToCartPopup_text" element to "appear"
     And user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
     When I click on "PDP.checkout_button"
     #--------------------------Verification of Order Information page-----------------------------------------------#
     #----------------------------------Account Section ---------------------------------------------------#
     Then user verify if text contains "*Required Field" in "Checkout.requiredField_text"
     And user verify text "Account" in page "Checkout.accountSectionTitle_text"
     And user verify text is  "Do you have a Trade Account?" in page "Checkout.doYouHaveTradeAcc_label"
     And user verify element "Checkout.selectTradeAccountNo_radio" is present on page
     And user verify text is  "No" in page "Checkout.selectTradeAccountNo_radio"
     And user verify if element "Checkout.selectTradeAccountNo_radio" is selected on page
     And user verify element "Checkout.selectTradeAccountYes_radio" is present on page
     And user verify text is  "Yes" in page "Checkout.selectTradeAccountYes_radio"
     And user click to select Yes for Tradeaccount "Checkout.selectTradeAccountYes_radio"
     And user verify text over link as "+ Use an existing account not listed" in page "Checkout.existingTradeAccount_link"
     And user verify element "Checkout.openNewTradeAccount_checkbox" is present on page
     And user verify text is "I would like to open a new trade account" in page "Checkout.openNewTradeAccount_label"
     And user verify text is "Your account will be billed according to the" in page "Checkout.tradeTerms_text"
     And user verify if link "Checkout.tradeAccountTermsAndConditions_link" is present
     And user verify text is  "Terms & Conditions of Purchase, including Privacy Statement and Data Protection Policy" in page "Checkout.tradeAccountTermsAndConditions_link"
     And user verify text above PO Number textbox as  "You may enter a PO number for your reference. This field is optional." in page "Checkout.enterPONumber_text"
     When I click on link use an existing Trade account "Checkout.existingTradeAccount_link"
     And I enter Trade account Account number and CID details using given file "OrderInformation.xlsx"
     And I enter PO number value "NewTradeTestorder" in textbox "Checkout.poNumber_textbox"
     And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
     #----------------------------------Payment Details Section ----------------------------------------------------------#
     Then user verify text as  "Payment Details" in page "Checkout.paymentDetails_text"
     And user verify text as  "*Payment Method" in page "Checkout.paymentMethod_text"
     When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
     #----------------------------------Invoice/Billing Address Details Section ----------------------------------------------------------#
     And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddressTitle_text"
     And user verify text as  "Add Invoice Address" in page "Checkout.addInvoiceAddressTitle_text"
     And user verify text below section title as  "New address details will not be added to your addresses until you proceed to the next step." in page "Checkout.newAddressUpdationDetailsOfInv_text"
     And user fill mobile checkout Invoice or billing address "Invoice Address" specifically using given file "OrderInformationForCheckoutRegression.xlsx"
      #----------------------------------Add verification of labels using list and adding invoice address------------------------------------------------------------------#
     And user verify element "Checkout.setInvAddressAsPreferredAddress_checkbox" is present on page
     And user verify element "Checkout.setInvAddressAsPreferredAddress_checkbox" is selected on page
     And user verify text as  "Set this as my preferred invoice address for future orders" in page "Checkout.setInvAddressAsPreferredAddress_label"
     And user click to deselect the 'Set this as my preferred invoice address' checkbox "Checkout.setInvAddressAsPreferredAddress_checkbox"
     And user hover on element to verify its pop up "Checkbox.billingAddress_icon"
     And user verify text over pop-up as "Choose this checkbox to have this preference stored for future purchases" in page "Checkout.setInvAsPreferredAddressPopUp_text"
     When user click on Continue button "Checkout.paymentDetailsSectionContinue_button"
    
     #-----------------------------------Delivery Address Details Section ----------------------------------------------------------#
     Then user verify text Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text"
     And user verify text of Delivery Address form label on top as "Delivery Address" in page "Checkout.deliveryAddress_label"
     And user verify text below section title as  "New address details will not be added to your addresses until you proceed to the next step." in page "Checkout.newAddressUpdationDetailsOfDel_text"
     #----------------------------------Add verification of labels using list and adding delivery  address------------------------------------------------------------------#
     And user verify element "Checkout.setDelAddressAsPreferredAddress_checkbox" is present on page
     And user verify element "Checkout.setDelAddressAsPreferredAddress_checkbox" is selected on page
     And user click to deselect the 'Set this as my preferred delivery address' checkbox "Checkout.setDelAddressAsPreferredAddress_checkbox"
     And user fill mobile checkout Invoice or billing address "Delivery Address" specifically using given file "OrderInformationForCheckoutRegression.xlsx"
     And user verify text as  "My delivery address is the same as my invoice address" in page "Checkout.setDelAddressAsPreferredAddress_label"
     And user verify text over pop-up as "Choose this checkbox to have this preference stored for future purchases" in page "Checkout.setInvAsPreferredAddressPopUp_text"
     When user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
     
     #-------------------------------------Delivery Method-------------------------------------------------------------------------#
     Then user verify text of Delivery Method title as  "Delivery Method" in page "Checkout.deliveryMethodSectionTitle_text"
     And user verify text as  "Delivery Instructions" in page "Checkout.deliveryInstructionsTitle_text"
     And user verify text as  "Add any special instructions for the carrier (maximum 30 characters)." in page "Checkout.addAnySpecialInstructions_text"
     When user enter value "Test Order" in textbox "Checkout.deliveryInstructions_textbox"
     Then user verify text below the text box as  "Characters left: 30" in page "Checkout.charLeftInDelInstructions_text"
     And user verify text of Special Instructions section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text"
     And user verify text of guidelines to select Special Instructions from the dropdown below as "Please select from the list or select 'Other' to enter instructions to appear on your despatch note (maximum 160 characters)." in page "Checkout.guideLinesToSelectSpecialInstructions_text"
     And user verify text above the Special Instructions dropdown as "Special Instructions will be followed where possible." in page "Checkout.specialInstructionsWillBeFollowed_text"
     When user select by visible text in Special Instructions as  "other" from dropdown "Checkout.specialInstruction_dropdown"
     And user enter value "Test Order" in textbox "Checkout.specialDeliveryInstructions_textbox"
     Then user verify text below the textbox as  "Characters left: 160" in page "Checkout.charLeftInSplInstructions_text"
     When user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
     
     #-----------------------------------------Order Review Page----------------------------------------------------------------------------#
     Then user verify text stating to review the order before submitting as  "Please review your order and click the Submit Order button to continue." in page "Checkout.pleaseReviewAndSubmitOrder_text"
     And user verify text related to the 'Standard FREE delivery of products' as "FREE Standard next working day delivery on all UK online orders. Excludes offline  orders, Newark Direct Ship products and other non standard delivery methods. Next working day delivery cannot be guaranteed." in page "Checkout.stdFreeDelivery_text"
     And user verify text of 'Order Review' page heading as "Review Your Order Before Submitting" in page "Checkout.reviewYourOrder_text"
     And user verify if the 'Terms&Conditions' checkbox element "Checkout.acceptTermsAndConditionsOnTop_checkbox" is present on page
     And user verify if the link "Checkout.termsAndConditionsToAcceptOrderonTop_link" is present in the 'Term&Conditions' label
     And user verify text of the link is "terms and conditions" in page "Checkout.termsAndConditionsToAcceptOrderonTop_link"
     And user verify if 'Terms&Conditions' checkbox label contains text "I accept the" in "Checkbox.acceptTermsAndConditionsOnTop_checkbox"
     And user verify text over 'Submit Order' button is "Submit Order" in page "Checkout.submitOrder_button"
     And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
     #Payment Details-------------------------------------------------------------------------------------------------------------------------#
     And user verify text of Payment Details title as "Payment Details" in page "Checkout.paymentDetailsTitle_text"
     And user verify below are displayed in 'Payment Details' as labels "Checkout.paymentDetailsOfOrder_list" table
     |Order Date:				|
     |Account Number:		|
     |Customer ID (CID):|
     |Placed By:				|
     |Email Address:		|
     |Billing Method:		|
     And user verify text of 'PO Number' label as "PO Number:" in page "Checkout.poNumberInOrderReview_label"
     And user verify if text contains "Your account will be billed according to the" in "Checkout.yourAccountBilledAccordingToTerms_text"
     And user verify if the link "Checkout.termsAndConditionsForBilling_link" is present
     And user verify text over link is "Terms & Conditions of Purchase, including Privacy Statement and Data Protection Policy" in page "Checkout.termsAndConditionsForBilling_link"
     #Invoice Address-----------------------------------------------------------------------------------------------------------------------------#
     And user verify text of title as  "Invoice Address" in page "Checkout.invoiceAddressTitle_text"
     And user verify text of Invoice and Tax details heading as "Invoice and Tax Details" in page "Checkout.invoiceAndTaxDetailsSection_title"
     Then user verify if address entered "Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.invoiceAddressEntered_list"
     #Delivery Address----------------------------------------------------------------------------------------------------------------------------#
     And user verify text Delivery address section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text"
     And user verify text of Delivery address heading as "Delivery Address" in page "Checkout.deliveryAddress_text"
     Then user verify if address entered "Delivery Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.deliveryAddressEntered_list"
     #Delivery Selection---------------------------------------------------------------------------------------------------------------------------#
     And user verify text Delivery selection section title as  "Delivery Selection & Order Options" in page "Checkout.deliverySelectionTitle_text"
     And user verify text of label under Delivery Selection section is "Delivery Method:" in page "Checkout.deliveryMethod_label"
     #Delivery/Special Instructions----------------------------------------------------------------------------------------------------------------#
     And user verify text of section title as  "Delivery Instructions" in page "Checkout.deliveryInstructionTitle_text"
     And user verify text of section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text"
     #Items to be shipped---------------------------------------------------------------------------------------------------------------------------#
     And user verify text of section title as  "Items To Be Shipped" in page "Checkout.itemToBeShippedTitle_text"
     And user verify text of 'Item number in order' as "1" in page "Checkout.itemNumber_text"
     And user verify if the Product Description link "Checkout.productDesc_link" is present
     And user verify below are displayed in 'Order Details' as headers in "Checkout.orderCodeTableHeader_list" table
     |Order Code			|
     |Manufacturer Part Number		|
     #----------------------Add value verification-------------------------#
      And user verify text of collapsable section under order details table as "Additional Information" in page "Checkout.additionalInformationCollapsable_element"
      And user verify absence of element "Checkout.addtlInfoExpandedSection_element"
      And user click the collapsable section "Checkout.additionalInformationCollapsable_element"
      And user verify element "Checkout.addtlInfoExpandedSection_element" is present on page
      And user verify below are displayed in 'Additional Information' as labels "Checkout.addtlInfoCollapseElements_list" table
      |RoHS Compliant:			|
      |Manufacturer					|
      |Avail.								|
      |Scheduled Quantity		|
      |Delivery Date				|
      |Unit Price						|
      |Line Note						|
      |Your Part No					|
      |Availability					|
      And user verify below are displayed in 'Quantity And Line price' as labels in "Checkout.QtyAndLinePrice_list" table
      |Qty					|
      |Line Price		|
      And user verify values in the "Checkout.QtyAndLinePriceTableValues_list" table are not empty
      And user verify text over 'Edit Basket' button "Edit Basket" in page "Checkout.editBasket_button"
      And user verify text of label "All Items Total:" in page "Checkout.allItemTotal_label"
      And user verify text of label "Delivery:" in page "Checkout.delivery_label"
      And user verify text of label "VAT:" in page "Checkout.vat_label"
      And user verify text of label "Total:" in page "Checkout.orderTotal_label"
      And user verify values in the "Checkout.orderSummaryTableValues_list" table are not empty
      And user verify text of 'sales tax info added to order total' as "*Calculated based on your preferences or selected shipping" in page "Checkout.salesTaxCalcInfo_text"
      And user verify element "Checkout.acceptTermsAndConditionsInBottom_checkbox" is selected on page
      When user click 'Submit Order' button present in the bottom of the page "Checkout.submitOrderInBottom_button"
      #-------------------------------------Order Confirmation Page-----------------------------------------------#
      Then user verify text on successful order placement as "Order Confirmation" in page "Checkout.orderConfirmationTitle_text"
      And user verify text as "Thank you" in page "Checkout.thankYou_text"
      And user verify text of 'email sent confirmation' as "An email has been sent confirming the order you have just placed." in page "Checkout.emailSentConfirmation_text"
      And user verify if 'Order Reference' number displayed contains "Your order reference is" in "Checkout.yourOrderReference_text"
      And user verify text "Track the status of your order by accessing Order Status & Tracking in the My Account section." in page "Checkout.trackOrderStatus_text"
      And user verify link "Checkout.termsAndConditionsOfOrderTracking_link" is present
      And user verify text over the link as "Order Status & Tracking" in page "Checkout.termsAndConditionsOfOrderTracking_link"
      And user verify text as "Continue Shopping" in page "Checkout.continueShoppingInTop_button"
      And user verify text as "Share your order" in page "Checkout.shareYourOrder_button"
      And user verify below are displayed in 'Payment Details' as labels "Checkout.paymentDetailsOfOrder_list" table
     |Order Date:				|
     |Account Number:		|
     |Customer ID (CID):|
     |Placed By:				|
     |Email Address:		|
     |Billing Method:		|
     And user verify text of 'PO Number' label as "PO Number:" in page "Checkout.poNumberInOrderReview_label"
     And user verify if text contains "Your account will be billed according to the" in "Checkout.yourAccountBilledAccordingToTerms_text"
     And user verify if the link "Checkout.termsAndConditionsForBilling_link" is present
     And user verify text over link is "Terms & Conditions of Purchase, including Privacy Statement and Data Protection Policy" in page "Checkout.termsAndConditionsForBilling_link"
     #Invoice Address-----------------------------------------------------------------------------------------------------------------------------#
     And user verify text of title as  "Invoice Address" in page "Checkout.invoiceAddressTitle_text"
     And user verify text of Invoice and Tax details heading as "Invoice and Tax Details" in page "Checkout.invoiceAndTaxDetailsSection_title"
     Then user verify if address entered "Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.invoiceAddressEntered_list"
     #Delivery Address----------------------------------------------------------------------------------------------------------------------------#
     And user verify text Delivery address section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text"
     And user verify text of Delivery address heading as "Delivery Address" in page "Checkout.deliveryAddress_text"
      Then user verify if address entered "Delivery Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.deliveryAddressEntered_list"
     #Delivery Selection---------------------------------------------------------------------------------------------------------------------------#
     And user verify text Delivery selection section title as  "Delivery Selection & Order Options" in page "Checkout.deliverySelectionTitle_text"
     And user verify text of label under Delivery Selection section is "Delivery Method:" in page "Checkout.deliveryMethod_label"
     #Delivery/Special Instructions----------------------------------------------------------------------------------------------------------------#
     And user verify text of section title as  "Delivery Instructions" in page "Checkout.deliveryInstructionTitle_text"
     And user verify text of section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text"
     And user verify text of label "All Items Total:" in page "Checkout.allItemTotal_label"
     And user verify text of label "Delivery:" in page "Checkout.delivery_label"
     And user verify text of label "VAT:" in page "Checkout.vat_label"
     And user verify text of label "Total:" in page "Checkout.orderTotal_label"
     And user verify values in the "Checkout.orderSummaryTableValues_list" table are not empty
     And user verify text of 'sales tax info added to order total' as "*Calculated based on your preferences or selected shipping" in page "Checkout.salesTaxCalcInfo_text"
     And user verify text of button as "Continue Shopping" in page "Checkout.continueShoppingInBottom_button"
   
  Scenario: Edit Information on Order Review Page
     Given last registered "firsttimeorder" user login to website successfully
     Then user wait for "3" seconds
     When user click 'Shopping Basket' icon on the header "Checkout.miniBasket_link"
     Then user wait for "3" seconds
     When user enters the ordercode "instock" in the cart page "Checkout.firstOrderCode_textbox" from file "CheckoutRegressionOrderCodes.xlsx"
     And user click 'Update Basket' button to add the product to the cart "ShoppingCart.updateBasket_button"
     Then user wait for "3" seconds
     When user click 'Checkout' button to proceed towards order checkout "ShoppingCart.checkoutNow_button"
     Then user wait for "7" seconds
     When I click on link use an existing Trade account "Checkout.existingTradeAccount_link"
     And I enter Trade account Account number and CID details using given file "OrderInformation.xlsx"
     And I enter PO number value "Test Order" in textbox "Checkout.poNumber_textbox"
     And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
     When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
     #----------------------------------Payment Details Section ----------------------------------------------------------#
     Then user verify text as  "Payment Details" in page "Checkout.paymentDetails_text"
     And user verify text as  "*Payment Method" in page "Checkout.paymentMethod_text"
     When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
  
     #----------------------------------Invoice/Billing Address Details Section ----------------------------------------------------------#
      And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddressTitle_text"
      And user verify text as  "Add Invoice Address" in page "Checkout.addInvoiceAddressTitle_text"
      And user verify text below section title as  "New address details will not be added to your addresses until you proceed to the next step." in page "Checkout.newAddressUpdationDetailsOfInv_text"
      #----------------------------------Add verification of labels using list and adding invoice address------------------------------------------------------------------#
      And user verify element "Checkout.setInvAddressAsPreferredAddress_checkbox" is selected on page
      And user click to deselect the 'Set this as my preferred invoice address' checkbox "Checkout.setInvAddressAsPreferredAddress_checkbox"
      When user click on Continue Shopping button "Checkout.paymentDetailsSectionContinue_button"
      #-----------------------------------Delivery Address Details Section ----------------------------------------------------------#
      Then user verify text Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text"
      #----------------------------------Add verification of labels using list and adding delivery  address------------------------------------------------------------------#
      And user verify element "Checkout.setDelAddressAsPreferredAddress_checkbox" is selected on page
      And user click to deselect the 'Set this as my preferred delivery address' checkbox "Checkout.setDelAddressAsPreferredAddress_checkbox"
      When user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
      #-------------------------------------Delivery Method-------------------------------------------------------------------------#
      Then user verify text of Delivery Method title as  "Delivery Method" in page "Checkout.deliveryMethodSectionTitle_text"
      And user verify text as  "Delivery Instructions" in page "Checkout.deliveryInstructionsTitle_text"
      When user enter value "Test Order" in textbox "Checkout.deliveryInstructions_textbox"
      And user verify text of Special Instructions section title as  "Special Instructions" in page "Checkout.specialInstructionsTitle_text"
      And user verify text of guidelines to select Special Instructions from the dropdown below as "Please select from the list or select 'Other' to enter instructions to appear on your despatch note (maximum 160 characters)." in page "Checkout.guideLinesToSelectSpecialInstructions_text"
      When user select by visible text in Special Instructions as  "other" from dropdown "Checkout.specialInstruction_dropdown"
      And user enter value "Test Order" in textbox "Checkout.specialDeliveryInstructions_textbox"
      When user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
      #--------------------------------------Order Review-----------------------------------------------------------------------------#
      Then user verify text stating to review the order before submitting as  "Please review your order and click the Submit Order button to continue." in page "Checkout.pleaseReviewAndSubmitOrder_text"
      And user verify text over 'Submit Order' button is "Submit Order" in page "Checkout.submitOrder_button"
      And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
      And user click 'Edit' button to edit the Payment Details "Checkout.editPaymentMethod_button"
      And user verify if the Trade Account 'Yes' radio button element "Checkout.selectTradeAccountYes_radio" is selected on page
      And user verify element "Checkout.existingTradeAccountNumber_text" is present on page and display text value in report
      And user verify element "Checkout.existingTradeAccountDetails_text" is present on page and display text value in report
      When user clears text from textbox "Checkout.poNumber_textbox"
      And user enter value "PO Comment Amended" in textbox "Checkout.specialDeliveryInstructions_textbox"
      And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
      And user wait for "2" seconds
      And user click on Continue Shopping button "Checkout.paymentDetailsSectionContinue_button"
      And user wait for "2" seconds
      And user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
      And user wait for "2" seconds
      And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
      And user click 'Edit' button to edit the Invoice Address Details "Checkout.invoiceAddressEdit_button"  
      And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddressHeading_text"  
      And user click on Continue Shopping button "Checkout.paymentDetailsSectionContinue_button"
      And user wait for "2" seconds
      And user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
      And user wait for "2" seconds
      And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button" 
      And user click 'Edit' button to edit the Delivery Address Details "Checkout.editDeliveryAddress_button"
      And user verify text Delivery address section title as "Delivery Address" in page "Checkout.deliveryAddressHeading_text"
      And user click 'Use this Address' button of 'Invoice' address added "Checkout.useThisAddressThird_button"
      And user click on Continue Shopping button "Checkout.deliverySectionContinue_button"
      And user wait for "2" seconds
      And user click 'Edit' button to edit the Delivery Selection Details "Checkout.editDeliverySelection_button"  
      And user enter value "Added Delivery Instructions" in textbox "Checkout.deliveryInstructions_textbox"
      When user select by visible text in Special Instructions as  "other" from dropdown "Checkout.specialInstruction_dropdown"
      And user enter value "Special Instructions Amended" in textbox "Checkout.specialDeliveryInstructions_textbox"
      And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
      And user verify text added in the 'Delivery Instructions' textbox  "Added Delivery Instructions" in page "Checkout.deliveryInstructionsComment_text"
      And user verify text added in the 'Special Instructions' textbox as "Special Instructions Amended" in page "Checkout.specialInstructionsComment_text"
      
   
   Scenario: Edit Order Information details in the Checkout page
      Given last registered "firsttimeorder" user login to website successfully
      Then user wait for "3" seconds
      When user click 'Shopping Basket' icon on the header "Checkout.miniBasket_link"
      Then user wait for "3" seconds
      When user enters the ordercode "productImage360" in the cart page "Checkout.firstOrderCode_textbox" from file "CheckoutRegressionOrderCodes.xlsx"
      And user click 'Update Basket' button to add the product to the cart "ShoppingCart.updateBasket_button"
      Then user wait for "3" seconds
      When user click 'Checkout' button to proceed towards order checkout "ShoppingCart.checkoutNow_button"
      Then user wait for "7" seconds
      And user click to select Yes for Tradeaccount "Checkout.selectTradeAccountYes_radio"
      And user verify text over link as "+ Use an existing account not listed" in page "Checkout.existingTradeAccount_link"
      And user click 'I would like to open a new trade account' checkbox "Checkout.openNewTradeAccount_checkbox"
      And user verify absence of element "Checkout.existingTradeAccount_link"
      And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
      Then user verify text as  "Payment Details" in page "Checkout.paymentDetails_text"
      And user verify text as  "*Payment Method" in page "Checkout.paymentMethod_text"
      When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
      #Then user verify if address entered "Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "([^"]*)"
      And user verify text Invoice address section title as "Invoice Address" in page "Checkout.invoiceAddress"
      Then user verify if address entered "Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.invoiceAddressEntered_list"
      And user click 'Add new address' button to add the new Invoice address details "Checkout.addNewAddressInvoice_button"
      And user fill mobile checkout Invoice or billing address "New Invoice Address" specifically using given file "OrderInformationForCheckoutRegression.xlsx"
      And user click 'Save' on the new address overlay displayed "Checkout.saveBillingAddressOnOverlay_button"
      And user click to deselect the 'Set this as my preferred invoice address' checkbox "Checkout.setInvAddressAsPreferredAddress_checkbox"
      When user click on Continue button "Checkout.paymentDetailsSectionContinue_button"
      Then user verify text Delivery addresss Section title as  "Delivery Address" in page "Checkout.deliveryAddressSectionTitle_text"
      When user click to deselect the 'My delivery address is same as invoice address' checkbox "Checkout.setDelAddressSameAsInv_checkbox"
      Then user verify if address entered "Delivery Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.deliveryAddressEntered_list"
      And user click 'Add new address' button to add the new Delivery address details "Checkout.addNewAddressDelivery_button"
      And user fill mobile checkout Invoice or billing address "New Delivery Address" specifically using given file "OrderInformationForCheckoutRegression.xlsx"
      And user click 'Save' on the new address overlay displayed "Checkout.saveDeliveryAddressOnOverlay_button"
      And user click to deselect the 'Set this as my preferred delivery address for future orders' checkbox "Checkout.setDelAddressAsPreferredAddressOnOverlay_checkbox"
      When user click on Continue button "Checkout.deliverySectionContinue_button"
      Then user verify text of Delivery Method title as  "Delivery Method" in page "Checkout.deliveryMethodSectionTitle_text"
      And user verify text as  "Delivery Instructions" in page "Checkout.deliveryInstructionsTitle_text"
      When user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
      Then user verify text stating to review the order before submitting as  "Please review your order and click the Submit Order button to continue." in page "Checkout.pleaseReviewAndSubmitOrder_text"
      And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
      When user click 'Submit Order' button present in the bottom of the page "Checkout.submitOrderInBottom_button"
      #-------------------------------------Order Confirmation Page-----------------------------------------------#
      Then user verify text on successful order placement as "Order Confirmation" in page "Checkout.orderConfirmationTitle_text"
      When user enters the ordercode "backorder" in the cart page "Checkout.firstOrderCode_textbox" from file "CheckoutRegressionOrderCodes.xlsx"
      And user click 'Update Basket' button to add the product to the cart "ShoppingCart.updateBasket_button"
      Then user wait for "3" seconds
      When user click 'Checkout' button to proceed towards order checkout "ShoppingCart.checkoutNow_button"
      Then user wait for "7" seconds
      And user click to select Yes for Tradeaccount "Checkout.selectTradeAccountYes_radio"
      And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
      When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
      Then user verify if address entered "New Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.invoiceAddressEntered_list"
      When user click 'Edit' to amend the Invoice address details added "Checkout.editInVoiceAddressInPaymentDetails_link"
      And user fill mobile checkout Invoice or billing address "Amended Invoice Address" specifically using given file "OrderInformationForCheckoutRegression.xlsx"
      And user click 'Save' on the new address overlay displayed "Checkout.saveBillingAddressOnOverlay_button"
      And user click 'Use this Address' button "Checkout.useThisAddressThirdInPaymentDetails_button"
      When user click on Continue button "Checkout.paymentDetailsSectionContinue_button"
      When user click to deselect the 'My delivery address is same as invoice address' checkbox "Checkout.setDelAddressSameAsInv_checkbox"
      Then user verify if address entered "New Delivery Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.deliveryAddressEntered_list"
      And user click 'Edit' to amend the Delivery address details added "Checkout.editDelAddressInDeliveryDetails_link"
      And user fill mobile checkout Invoice or billing address "Amended Delivery Address" specifically using given file "OrderInformationForCheckoutRegression.xlsx"
      And user click 'Save' on the new address overlay displayed "Checkout.saveDeliveryAddressOnOverlay_button"
      And user click 'Use this Address' button "Checkout.useThisAddressThird_button"
      When user click on Continue button "Checkout.deliverySectionContinue_button"
      And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
      Then user verify text stating to review the order before submitting as  "Please review your order and click the Submit Order button to continue." in page "Checkout.pleaseReviewAndSubmitOrder_text"
      And user verify if address entered "Amended Invoice Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.invoiceAddressEntered_list"
      And user verify if address entered "Amended Delivery Address" from "OrderInformationForCheckoutRegression.xlsx" file is displayed correct "Checkout.deliveryAddressEntered_list"
      And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
      When user click 'Submit Order' button present in the bottom of the page "Checkout.submitOrderInBottom_button"
      When user enters the ordercode "noalternativeproducts" in the cart page "Checkout.firstOrderCode_textbox" from file "CheckoutRegressionOrderCodes.xlsx"
      And user click 'Update Basket' button to add the product to the cart "ShoppingCart.updateBasket_button"
      Then user wait for "3" seconds
      When user click 'Checkout' button to proceed towards order checkout "ShoppingCart.checkoutNow_button"
      Then user wait for "7" seconds
      And user click to select Yes for Tradeaccount "Checkout.selectTradeAccountYes_radio"
      And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
      When user select by visible text in Payment Method type as  "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
      And user click 'Delete' link below the Invoice address to delete the address details added "Checkout.deleteInvoiceAddressInPaymentDetails_link"
      ####switch to pop up##########
      And user click 'Delete' button to delete the Invoice address "Checkout.deleteAddress_button"
      When user click on Continue button "Checkout.paymentDetailsSectionContinue_button"
      When user click to deselect the 'My delivery address is same as invoice address' checkbox "Checkout.setDelAddressSameAsInv_checkbox"
      And user click 'Delete' link below the Delivery address to delete the address details added "Checkout.deleteDelAddressInDeliveryDetails_link"
      ####switch to pop up##########
      And user click 'Delete' button to delete the Invoice address "Checkout.deleteAddress_button"
      When user click on Continue button "Checkout.deliverySectionContinue_button"
      And user click proceed to 'Order Review' section "Checkout.proceedToOrderReview_button"
      Then user verify text stating to review the order before submitting as  "Please review your order and click the Submit Order button to continue." in page "Checkout.pleaseReviewAndSubmitOrder_text"
      And user click checkbox to 'Accept' the 'Terms & Conditons' to submit order "Checkout.acceptTermsAndConditionsOnTop_checkbox"
      When user click 'Submit Order' button present in the bottom of the page "Checkout.submitOrderInBottom_button"
      