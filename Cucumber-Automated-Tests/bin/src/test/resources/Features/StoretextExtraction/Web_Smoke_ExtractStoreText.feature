@WebSmokeExtractStoreText
Feature: Basic functionality which check the health of website after every deployment


	@storetext
  Scenario: Register a user with known details for newark
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePage" page
    And user get the store text keys of "HeaderPart" page for element "StoreTextKeys.header_element"

  @storetext
  Scenario: Synch user Checkout with existing trade account
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePage" page
    And user get the store text keys of "HeaderPart" page for element "StoreTextKeys.header_element"
    And customer accesses the website as "register as synch" user storetext
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And user get all the store text keys of "PDPSearchPage" page
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And user get all the store text keys of "CartPage" page
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds

  @storetext
  Scenario: Blank search & Checkout requesting new Trade Account
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user storetext
    And I save the newly registered "regular" user details
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And user get all the store text keys of "CategoryL1Page" page
    And I click "BrowseForProducts.firstCategory_link"
    And I scroll till "CategoryPage.showAllProducts_button"
    And user get all the store text keys of "CategoryL2Page" page
    And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
    And user get all the store text keys of "CategoryL3Page" page
    And I save the value of First Order code from PLP table
    And user get all the store text keys of "PLPPage" page
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I wait for "3" seconds
    When I enter the ordercode saved from PLP to update the basket to place order
    And user get all the store text keys of "BasketPage" page
    And I scroll till "ShoppingCart.updateBasket_button"
    And I click "ShoppingCart.updateBasket_button"
    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
    And I wait for "3" seconds
    And I scroll till "Header.itemsInMiniBasket_text"
    And user get all the store text keys of "MiniBasketPage" page

  @storetext
  Scenario: A guest user adds products to cart directly using a community url then places order successfully using creditcard
    Given web site is launched successfully and user "does not" accept the cookies
    And User save cookie preferences
    When User navigate to community URL using file "CommunityURL.xlsx"
    And user get all the store text keys of "CartPage" page
    And User scroll till "ShoppingCart.firstProductOnCart_text"

  @storetext
  Scenario: Search Lookahead and Keyword search
    Given web site is launched successfully and user "does" accept the cookies
    And user enter the value "res" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And user get all the store text keys of "SearchLookaheadValuesSeaction" page
    And I clears text from textbox "Header.searchBox_textbox"
    When user enter the value "capacitor" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And user get all the store text keys of "SearchResultsPage" page

  @storetext
  Scenario: I want to verify the SEO title for PDP page
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePageWithoutCookiesAccepted" page
    When I enter ordercode in Searchbox to navigate to PDP page
    And user get all the store text keys of "PDPPage" page
    And I click on the first order result "Search.searchFirst_text"
    And I wait for "3" seconds
    And user get all the store text keys of "PDPPage" page

  @storetext
  Scenario: Validate the Left and Top filters functionality
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "c/crystals-oscillators/crystals" page
    And I wait for "4" seconds
    And user get all the store text keys of "PLPPageBeforeLeftViewFilter" page
    And I get the Products found count before applying filters
    When I click on Instock checkbox "Filters.instock_checkbox"
    And I click on Show Result Button "Filters.showResult_button" refreshed element
    And user get all the store text keys of "PLPPageAfterLeftViewFilter" page
    And I click "Filters.clearAllFilters_link"
    And I wait for "8" seconds
    And I click the toggle view from LEFT to TOP view "Filters.filterView_toggle"
    And user get all the store text keys of "PLPPageBeforeTopViewFilter" page
    When I select by index "1" from dropdown "Filters.filterManufacturer_section"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And user get all the store text keys of "PLPPageAfterTopViewFilter" page
    And I click on "Filters.reset_link"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And user get all the store text keys of "PLPPageAfterTopViewFilterReset" page
    And I click on Add button on PLP "PLP.firstAdd_button" using js
    And I wait for "6" seconds

  @storetext
  Scenario: Guest user track order by entering order confirmation number, email and zip code
    Given web site is launched successfully and user "does" accept the cookies
    When user click on Track Orders link On home page from the header "Header.trackOrders_link"
    Then user verifies Order Details element "OrderTracking.orderDetails_text" is present on page
    And user get all the store text keys of "TrackOrderPage" page
    And Guest user enters the Order tracking details
    And I wait for "3" seconds
    And user click on findorder button "OrderTracking.findorder_button"
    And user get all the store text keys of "FindOrderSectionPage" page
    And I wait for "4" seconds

  @storetext
  Scenario: Verify the order history for recent orders
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePageWithCookiesAccepted" page
    When customer accesses the website as "contract" user storetext
    And I assume environment stub is disabled in PP environment
    And I click My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And user get all the store text keys of "MyAccountDropdownSection" page
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "5" seconds
    And user get all the store text keys of "MyAccountSummaryPage" page
    And I scroll till "OrderHistory.viewAllOrders_button"
    When I click on View All Orders button "OrderHistory.viewAllOrders_button"
    And user get all the store text keys of "ViewAllOrdersPage" page
    And I click on link of recent order placed PO Number "OrderHistory.firstPONumber_element" using js
    And I wait for "8" seconds
    And I wait "medium" duration for "OrderHistory.txt_OrderHistory&Tracking" element to "appear"
    And user get all the store text keys of "OrderHistoryWithPOSearchResultsSection" page

  @storetext
  Scenario: Verify Back office Account number is synched in Account Summary
    Given I assume environment stub is disabled in PP environment
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePageWithCookiesAccepted" page
    When customer accesses the website as "contract" user storetext
    When I click My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "5" seconds
    And user get all the store text keys of "MyAccountSummaryPage" page

  @storetext
  Scenario: Extract store text from incorrect user credentials page and forgot username and password page
   Given web site is launched successfully and user "does" accept the cookies
   When user navigate to "login" page
   Then user get all the store text keys of "HomePage" page
   When User enters incorrect username "incorrect" and password "incorrect" to login to the application
   Then user get all the store text keys of "IncorrectPasswordErrorPage" page
   When user click on "Login.forgotUsername_link"
   Then user get all the store text keys of "ForgotUsernamePage" page
   When user navigate to "login" page
   Then user click on "Login.forgotPassword_link"
   And user get all the store text keys of "ForgotPasswordPage" page
