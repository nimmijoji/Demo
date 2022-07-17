Feature: Miscellanous store centric tests

	@chinaOnly @Priority3 @cashOnDelivery
	Scenario: China Website Checkout Using Cash on Delivery Option
		Given user navigate to "cn" store homepage and "does" accept the cookies
		#----User registers on the site----#
		And customer accesses the website as "register" user
		And I save the newly registered "regular" user details
		#----Find a product and add to basket----#
		When I click the "Header.searchIcon_button"
		And I wait for "3" seconds
		And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
		And I click "BrowseForProducts.secondCategory_link"
		And I scroll till "CategoryPage.showAllProducts_button"
		And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
		Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
		And I save the value of First Order code from PLP table
		#----Go to basket----#
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
		And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
		And I wait for "3" seconds
		When I enter the ordercode saved from PLP to update the basket to place order
		And I scroll till "ShoppingCart.updateBasket_button"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I wait for "3" seconds
		And I scroll till "Header.itemsInMiniBasket_text"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		#----Checkout----#
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
		And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
		And I click on Continue button on Payment Methods section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
		And I wait for "8" seconds
		Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		#---shipping method add special instructions & click go on
		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I wait for "3" seconds
		And I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait for "8" seconds
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		#----for payment details select Cash on Delivery COD----#
		And I verify cashOnDelivery radio button element "Checkout.cashOnDelivery_radio" is present on page
		And I click on cashOnDelivery radio button "Checkout.cashOnDelivery_radio"
		And I take screenshot of the page
		And I wait for "3" seconds
		And I scroll till "Checkout.invoiceTypeChina_radio"
		And I wait for "3" seconds
		And I take screenshot of the page
		And I click on freeTextInvoice radio button "Checkout.invoiceTypeChina_radio"
		And I enter value "COD Test" in textbox "Checkout.freeTextInvoice_text"
		And I enter value "Englishname" in textbox "Checkout.invoiceEnglishName_text"
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And I click on paymentDetailsSectionContinue button "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And I take screenshot of the page
		#----submit order----#
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		#----validate----#
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page

@chinaOnly @Priority3 @UnionPay
	Scenario Outline: China Website Checkout Using Unionpay 
		Given user navigate to "cn" store homepage and "does" accept the cookies
		#----User registers on the site----#
		And customer accesses the website as "register" user
		And I save the newly registered "regular" user details
		#----Find a product and add to basket----#
		When I click the "Header.searchIcon_button"
		And I wait for "3" seconds
		And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
		And I click "BrowseForProducts.secondCategory_link"
		And I scroll till "CategoryPage.showAllProducts_button"
		And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
		Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
		And I save the value of First Order code from PLP table
		#----Go to basket----#
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
		And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
		And I wait for "3" seconds
		When I enter the ordercode saved from PLP to update the basket to place order
		And I scroll till "ShoppingCart.updateBasket_button"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I wait for "3" seconds
		And I scroll till "Header.itemsInMiniBasket_text"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		#----Checkout----#
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
		And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
		And I click on Continue button on Payment Methods section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
		And I wait for "8" seconds
		Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		#---shipping method add special instructions & click go on
		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I wait for "3" seconds
		And I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait for "8" seconds
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		#----for payment details select Unionpay ----#
		And I verify unionPay radio button element "Checkout.unionPay_radio" is present on page
		And I click on unionPay radio button "Checkout.unionPay_radio"
		And I take screenshot of the page
		And I wait for "3" seconds
		And I scroll till "Checkout.invoiceTypeChina_radio"
		And I wait for "3" seconds
		And I take screenshot of the page
		And I click on freeTextInvoice radio button "Checkout.invoiceTypeChina_radio"
		And I enter value "Unionpay Test" in textbox "Checkout.freeTextInvoice_text"
		And I enter value "Englishname" in textbox "Checkout.invoiceEnglishName_text"
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And I click on paymentDetailsSectionContinue button "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And I take screenshot of the page
		#----submit order----#
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		#----unionpay new window----#
		And I wait "60" seconds for Unionpay new window
		And I switch to Unionpay window
		And I click on sendAnyway button "Checkout.sendAnyway_button"
		And I enter the "unionpay" card "cardnumber" in textbox "Checkout.creditCardNum_textbox" from json "creditCards.json"
		And I click on next button "Checkout.next_button" 
		And I enter the "unionpay" card "expirymonth" in textbox "Checkout.expireMonth_textbox" from json "creditCards.json"
		And I enter the "unionpay" card "expiryyear" in textbox "Checkout.expireYear_textbox" from json "creditCards.json"
		And I enter the "unionpay" card "cv2" in textbox "Checkout.cvn2_textbox" from json "creditCards.json"
		And I click on get code button "Checkout.getSMSCode_button"
		And I wait for "120" seconds
		And I enter the "unionpay" card "smscode" in textbox "Checkout.smsCode_textbox" from json "creditCards.json"
		And I wait for "20" seconds
		And I click on agreement checkbox button "Checkout.agreement_checkbox"
		And I click on complete payment button "Checkout.completeUnionPay_button"
		Then I wait for "20" seconds 
		And I verify element "Checkout.unionPaySuccess_element" is present on page
		And I click on return to merchant button "Checkout.returnToMerchant_button"
		Then I switch to parent window
		Then I wait for "60" seconds
		#----validate----#
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page

	@cpchomepageheader @cpcHomepage @gajanan
	Scenario: Verify header section in CPC homepage
		And I verify element "Header.companylogo_element" is present on page
		Then I verify element "Header.searchIcon_button" is present on page
		# Commented this part as All_list search bar has issue for automate
		#And I verify element "Header.all_list" is present on page
		#And I wait for "5" seconds
		#And I click on all button "Header.all_list" using js
		#And I wait for "5" seconds
		#And I click on "Header.category_dropdown" using js
		#And I click the "Header.searchIcon_button" using js
		#And I wait for "3" seconds
		#And I take screenshot
		#And I verify Results header element "Search.productsHeader_text" is present on page
		#And I take screenshot to verify the correct search page is loaded
		#And user navigates back in the browser
		And I verify presence of login and register links for guest users
		And I verify element "Home.allProducts_link" is present on page
		And I click the "Home.allProducts_link"
		And I wait for "5" seconds
		And verify values in the "Home.lhsSuperCategories_list" table are not empty
		And I wait for "3" seconds
		And I verify element "Home.featuredAccess_link" is present on page
		And I hover on element "Home.featuredAccess_link"
		And I click on "Home.FirstFeaturedAccess_link" using js
		And I wait for "5" seconds
		And I verify element "Home.FirstFeaturedAccess_text" is present on page
		And I verify element "Home.cpcTools_link" is present on page
		And I hover on element "Home.cpcTools_link"
		Then I verify below are displayed in "Home.cpcTools_list" table
			| Quick Buy             |
			| Quick Paste           |
			| Part Finder           |
			| Request a Quote       |
			| Remote Control Finder |
		And I click the "Home.cpcQuickBuy_link"
		And I wait for "3" seconds
		And verify url parameter value as "quick-order"
		And user navigates back in the browser
		And I verify element "Home.cpcResource_link" is present on page
		And I hover on element "Home.cpcResource_link"
		And I wait for "5" seconds
		And verify values in the "Home.cpcResource_list" table are not empty
		And I verify element "Home.deliveryInfo_link" is present on page
		And I click the "Home.deliveryInfo_link"
		And I verify current url contains "help-delivery-information"
		And user navigates back in the browser
		And I verify element "Home.collectInStore_link" is present on page
		And I click the "Home.collectInStore_link"
		And I verify current url contains "click-collect"
		And user navigates back in the browser
		And I verify presence of login and register links for guest users
		And I verify element "Header.myAccount_dropdown" is present on page
		And I click the "Header.myAccount_dropdown"
		Then I verify below are displayed in "Header.cpcMyAccount_list" table
			| Managing Your Account     |
			| Order History             |
			| Order Preferences         |
			| Apply for a Trade Account |
			| Profile Information       |
			| Addresses                 |
			| Quotes                    |
			| Saved Baskets             |
			| Change Password           |
			| Product Notifications     |
			| Marketing Preferences     |
		And I verify element "Header.cpcFlag_link" is present on page
		And I click on flag icon "Header.cpcFlag_link"
		And I wait for "3" seconds
		And I select by index "1" from dropdown "Header.country_dropdown"
		And I click on continue button "Header.continue_button"
		And I take screenshot
		And user navigates back in the browser
		And I verify element "ShoppingCart.shoppingCart_icon" is present on page
		And I verify mini shopping cart contains "0" items in "Header.itemsInMiniBasket_text"
		And I click the "ShoppingCart.shoppingCart_icon"
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And user navigates back in the browser
		And I wait for "5" seconds
		And I take screenshot

	@cpcpagecentre @cpcHomepage @gajanan  @cpcOnly
	Scenario: Verify center section in CPC home page
		And I scroll till "Home.cpcSubCategory_list"
		And I take screenshot
		And I wait for "3" seconds
		Then I verify below are displayed in "Home.cpcSubCategory_list" table
			| Audio Visual |
			| Cables       |
			| Computing    |
			| Maker        |
			| Electrical   |
			| Components   |
			| Leisure      |
			| Security     |
			| Test         |
			| Tools        |
		And I wait for "3" seconds
		And I click the "Home.cpcSubCategoryAudioVisual_link"
		And I verify current url contains "audio-visual" to check SubCategoryAudioVisual_link page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		And I scroll till "Home.cpcFreeUKDelivery_tab"
		And I verify element "Home.cpcFreeUKDelivery_tab" is present on page
		And I click the "Home.cpcFreeUKDelivery_tab"
		And I verify current url contains "help-delivery-information" to check delivery information page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "3" seconds
		And I verify element "Home.cpcCollectDelivery_tab" is present on page
		And I click the "Home.cpcCollectDelivery_tab"
		And I verify current url contains "click-collect" to check click and collect delivery page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		And I verify element "Home.cpcNeedSomehelp_tab" is present on page
		And I click the "Home.cpcNeedSomehelp_tab"
		And I verify current url contains "contact-us" to check need help contact us page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		And I scroll till "Home.trade_tab"
		And I take screenshot
		And I verify element "Home.trade_tab" is present on page
		And I verify element "Home.quote_tab" is present on page
		And I verify element "Home.delivery_tab" is present on page
		And I verify element "Home.contact_tab" is present on page
		And I verify element "Home.counter_tab" is present on page
		And I verify element "Home.catalogue_tab" is present on page
		And I verify element "Home.publication_tab" is present on page
		And I verify element "Home.emails_tab" is present on page
		And I verify element "Home.manufacturers_tab" is present on page

	@cpchomepagefooter @cpcHomepage @gajanan  @cpcOnly
	Scenario: Verify footer section in CPC home page
		Given user navigate to "cpc" store homepage and "does" accept the cookies
		And I scroll till "Home.visa_image"
		And I take screenshot
		Then I verify element "Home.visa_image" is present on page
		Then I verify element "Home.masterCard_image" is present on page
		Then I verify element "Home.americanExpress_image" is present on page
		Then I verify element "Home.tradeAccount_image" is present on page
		Then I verify element "Home.youtube_icon" is present on page
		Then I verify element "Home.facebook_icon" is present on page
		Then I verify element "Home.twitter_icon" is present on page
		Then I verify element "Home.linkedin_icon" is present on page
		Then I verify element "Home.cpcPrivacyStatement_link" is present on page
		And I click the "Home.cpcPrivacyStatement_link"
		And I verify current url contains "privacy-statement" to check Privacy Statement page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		Then I verify element "Home.cpcTermsOfAccess_link" is present on page
		And I click the "Home.cpcTermsOfAccess_link"
		And I verify current url contains "terms-of-access" to check Terms Of Access page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		Then I verify element "Home.cpcTermsOfPurchase_link" is present on page
		And I click the "Home.cpcTermsOfPurchase_link"
		And I verify current url contains "terms-of-purchase" to check Terms Of Purchase page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "5" seconds
		Then I verify element "Home.cpcCookieSettings_link" is present on page
		And I click the "Home.cpcCookieSettings_link"
		And I take screenshot
		And user navigates back in the browser

	@chinahomepageheader @chinaHomepage @gajanan @agileRegression  @chinaOnly
	Scenario: Verify header section in China home page
		Given user navigate to "cn" store homepage and "does" accept the cookies
		And I refresh browser
		And I verify element "Header.companylogo_element" is present on page
		And I verify element "Header.offer_link" is present on page
		And I click on offertab "Header.offer_link"
		And verify url parameter value as "special-offers"
		And I verify current url contains "special-offers"
		And I take screenshot
		And I wait for "3" seconds
		And user navigates back in the browser
		And I verify element "Header.contactus_link" is present on page
		And I click on contactus "Header.contactus_link"
		And I wait for "3" seconds
		And I take screenshot
		And I verify current url contains "contact-us"
		And user navigates back in the browser
		And I verify element "Header.help_link" is present on page
		And I click on helptab "Header.help_link"
		And I verify current url contains "help"
		And I take screenshot
		And I wait for "3" seconds
		And user navigates back in the browser
		And I verify element "Header.trackOrders_link" is present on page
		And I click on trackordertab "Header.trackOrders_link"
		And I verify element "Header.trackorderheader_text" is present on page
		And I wait for "3" seconds
		And I take screenshot
		And user navigates back in the browser
		And I verify element "Header.flag_link" is present on page
		And I click on flag icon "Header.flag_link"
		And I wait for "3" seconds
		Then I verify element "Header.country_text" is present on page
		And I select by index "4" from dropdown "Header.country_dropdown"
		And I click on continue button "Header.continue_button"
		And I wait for "10" seconds
		And I take screenshot
		And user navigates back in the browser
		Then I verify element "Header.searchIcon_button" is present on page
		# Commented this part as All_list search bar has issue for automate
		#And I verify element "Header.all_list" is present on page
		#And I click on all button "Header.all_list"
		#And I click on "Header.category_dropdown"
		#And I click the "Header.searchIcon_button"
		#And I wait for "3" seconds
		#And I take screenshot
		#And I verify Results header element "Search.productsHeader_text" is present on page
		#And I take screenshot to verify the correct search page is loaded
		#And user navigates back in the browser
		And I verify presence of login and register links for guest users
		And I verify element "Header.myAccount_dropdown" is present on page
		And I click the "Header.myAccount_dropdown"
		Then I verify below are displayed in "Header.myAccountHeaders_text" table
			| My Orders    |
			| Buying Tools |
			| My Profile   |
		And I take screenshot
		And I verify dropdown list items in "My Account" menu
		And I wait for "5" seconds
		And I verify element "ShoppingCart.shoppingCart_icon" is present on page
		And I verify mini shopping cart contains "0" items in "Header.itemsInMiniBasket_text"
		And I click the "ShoppingCart.shoppingCart_icon"
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And user navigates back in the browser
		And I wait for "5" seconds
		And I take screenshot
		And I verify element "Home.allProducts_link" is present on page
		And I wait for "3" seconds
		And I take screenshot
		And verify values in the "Home.lhsSuperCategories_list" table are not empty
		And I wait for "3" seconds
		And I verify element "Home.manufacturers_link" is present on page
		And I hover on element "Home.manufacturers_link"
		And verify text "Popular Manufacturers" in page "Home.popularmanufacturer_label"
		And I verify element "Home.resource_link" is present on page
		And I hover on element "Home.resource_link"
		And verify values in the "Home.resources_list" table are not empty
		And I verify element "Home.communities_link" is present on page
		And I hover on element "Home.communities_link"
		And I wait for "3" seconds
		And I verify element "Home.element14_image" is present on page
		And I verify element "Home.favorites_link" is present on page
		And I verify element "Home.tools_link" is present on page
		And I hover on element "Home.tools_link"
		And I wait for "5" seconds
		Then I verify below are displayed in "Home.tools_list" table
			| Quick Buy               |
			| Parts List (BOM) Upload |
			| Request a Quote         |
			| Browser Search Tools    |
			| All Buying Tools        |

	@chinahomepagefooter @chinaHomepage @gajanan @agileRegression @chinaOnly
	Scenario: Verify footer section in China home page
		Given user navigate to "cn" store homepage and "does" accept the cookies
		And I refresh browser
		And I scroll till "Home.weChat_image"
		And I take screenshot
		Then I verify element "Home.weChat_image" is present on page
		Then I verify element "Home.aliPay_image" is present on page
		Then I verify element "Home.cardOnDelivery_image" is present on page
		Then I verify element "Home.tradeAccount_image" is present on page
		Then I verify element "Home.cardbanktransfer_image" is present on page
		Then I verify element "Home.cardOnDelivery_image" is present on page
		Then I verify element "Home.privacy_link" is present on page
		And I click the "Home.privacy_link"
		And I verify current url contains "privacy-statement" to check Privacy Statement page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "8" seconds
		Then I verify element "Home.chinaLegalNotice_link" is present on page
		And I click the "Home.chinaLegalNotice_link" using js
		And I wait for "5" seconds
		And I verify current url contains "legal" to check legal notice page get open
		And I take screenshot
		And user navigates back in the browser
		And I wait for "7" seconds
		Then I verify element "Home.chinaTermAndCondition_link" is present on page
		And I click the "Home.chinaTermAndCondition_link"
		And I verify current url contains "terms-and-conditions" to check Terms Of Purchase page get open
		And I take screenshot
