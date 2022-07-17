@agileRegression
Feature: Home page tests

  Background: Launch homepage for regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @homepageheader @nacn @nacpc @eu @apac @nwk
  Scenario: Verify header section in home page
    And I verify element "Header.companylogo_element" is present on page
    And I verify element "Header.offer_link" is present on page
    And I click on offertab "Header.offer_link"
    And verify url parameter value as "special-offers"
    And I wait for "3" seconds
    And user navigates back in the browser
    And I verify element "Header.contactus_link" is present on page
    And I click on contactus "Header.contactus_link"
    And I wait for "3" seconds
    And verify url parameter value as "contact-us"
    And user navigates back in the browser
    And I verify element "Header.help_link" is present on page
    And I click on helptab "Header.help_link"
    And verify url parameter value as "help"
    And I wait for "3" seconds
    And user navigates back in the browser
    And I verify element "Header.trackOrders_link" is present on page
    And I click on trackordertab "Header.trackOrders_link"
    And I verify element "Header.trackorderheader_text" is present on page
    And I wait for "3" seconds
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
    And I verify element "Header.all_list" is present on page
    And I click on all button "Header.all_list"
    And I click on "Header.category_dropdown"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I take screenshot
    And I verify Results header element "Search.productsHeader_text" is present on page
    And I take screenshot to verify the correct search page is loaded
    And user navigates back in the browser
    And I verify presence of login and register links for guest users
    And I verify element "Header.myAccount_dropdown" is present on page
    And I click the "Header.myAccount_dropdown"
    Then I verify below are displayed in "Header.myAccountHeaders_text" table
      | My Orders    |
      | Buying Tools |
      | My Profile   |
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
    And I click the "Home.allProducts_link"
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
      | Quick Buy            |
      | BOM Upload           |
      | Request a Quote      |
      | Calculators & Charts |
      | Browser Search Tools |

  @homepagecentre  @nacn @nacpc @eu @apac @nwk
  Scenario: Verify center section in home page
    And I scroll till "Home.subCategory_element"
    And I take screenshot
    And I wait for "3" seconds
    Then I verify below are displayed in "Home.subCategory_list" table
      | Automation & Process Control |
      | Passives                     |
      | Interconnect                 |
      | Semiconductors               |
      | Optoelectronics              |
      | Electromechanical            |
      | Embedded Systems             |
      | Power                        |
      | Test                         |
      | Tools                        |
    And I hover on element "Home.subCategoryAutomation_element"
    And I wait for "3" seconds
    And I take screenshot
    And I click the "Home.automationCategory_link"
    And verify text "Automation & Process Control" in page "CategoryPage.categoryHeader_label"
    And user navigates back in the browser
    And I wait for "5" seconds
    And I verify element "Home.sameDayShipSection_element" is present on page and display in report
    And I verify element "Home.sameDayShipProducts_element" is present on page and display in report
    And I verify element "Home.unParalleledCustomerService_element" is present on page and display in report
    And I verify element "Home.unParallelCustomerServiceSubtitle_element" is present on page and display in report
    And I verify element "Home.serviceTitle_element" is present on page and display in report
    And I verify element "Home.serviceSubtitle_element" is present on page and display in report
    And I verify element "Home.marketLeadingTitle_element" is present on page
    And I verify element "Home.marketLeadingTitle_element" is present on page and display in report
    And I verify element "Home.marketLeadingSubtitle_element" is present on page and display in report
    And I scroll till "Home.newProducts_label"
    And verify text "New Products" in page "Home.newProducts_label"
    And I verify element "Home.newProductCaroselBack_button" is present on page
    And I verify element "Home.newProductsForwardCarosel_button" is present on page
    And I click the "Home.newProductCaroselBack_button"
    And I click the "Home.newProductsForwardCarosel_button"
    And verify values in the "Home.newProductsValues_list" table are not empty
    And I scroll till "Home.greatDeal_label"
    And verify text "Great Deals" in page "Home.greatDeal_label"
    And I verify element "Home.greatDealCaroselBack_button" is present on page
    And I verify element "Home.greatDealForwardCarosel_button" is present on page
    And I click the "Home.greatDealCaroselBack_button"
    And I click the "Home.greatDealForwardCarosel_button"
    And verify values in the "Home.greatDealValues_list" table are not empty
    And I scroll till "Home.featuredProduct_label"
    And verify text "Featured Products" in page "Home.featuredProduct_label"
    And I verify element "Home.featuredProductCaroselBack_button" is present on page
    And I verify element "Home.featuredProductForwardCarosel_button" is present on page
    And I click the "Home.featuredProductCaroselBack_button"
    And I click the "Home.featuredProductForwardCarosel_button"
    And verify values in the "Home.featuredProductValues_list" table are not empty
    And I scroll till "Home.manufactureHeader_label"
    And verify contains "leading manufacturers" in "Home.manufactureHeader_label"
    And I verify element "Home.manufacturerList_image" is present on page

  @homepagefooter  @nacn @nacpc @eu @apac @nwk
  Scenario: Verify footer section in home page
    And I scroll till "Home.customerSerive_label"
    And I take screenshot
    And verify text "Customer Service" in page "Home.customerSerive_label"
    And verify text "Quick Links" in page "Home.quickLinks_label"
    And verify text "About Us" in page "Home.aboutUs_label"
    And I verify element "Home.signUp_button" is present on page
    Then I verify element "Home.visa_image" is present on "[EU,APAC,NEWARK]" region/store.
    Then I verify element "Home.masterCard_image" is present on "[EU,APAC,NEWARK]" region/store.
    Then I verify element "Home.americanExpress_image" is present on "[EU,APAC,NEWARK]" region/store.
    Then I verify element "Home.tradeAccount_image" is present on "[EU,APAC,NEWARK]" region/store.
    Then I verify element "Home.youtube_icon" is present except in "[EU]" region/store.
    Then I verify element "Home.facebook_icon" is present on "[EU,APAC,NEWARK]" region/store.
    Then I verify element "Home.twitter_icon" is present on "[EU,APAC,NEWARK]" region/store.
    Then I verify element "Home.linkedin_icon" is present except in "[NEWARK]" region/store.
    Then I verify element "Home.privacy_link" is present except in "[APAC]" region/store.
    Then I verify element "Home.termsOfAccess_link" is present except in "[APAC]" region/store.
    Then I verify element "Home.legalCopyRight_link" is present except in "[APAC]" region/store.
    Then I verify element "Home.termsOfPurchase_link" is present except in "[APAC]" region/store.
    Then I verify element "Home.cookieSettings_link" is present except in "[APAC,NEWARK]" region/store.