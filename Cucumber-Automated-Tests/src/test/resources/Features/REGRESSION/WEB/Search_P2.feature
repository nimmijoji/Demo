@validationTests
Feature: Search priority 2 validation tests

  @viewROHSCertificateRegression @Priority2 @eu @apac @nwk @live
  Scenario: Search - View ROHS certificate and displays users name
		    Given web site is launched successfully and user "does" accept the cookies
				And I wait for "2" seconds
		    And customer accesses the website as "register" user
		    And I save the newly registered "regular" user details
		  	And I verify element "Header.searchBox_textbox" is present on page
			  And I enter the value "bav99" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
				And I wait for "2" seconds
				And I verify PLP table element "PLP.PLP_element" is present on page
		    And I verify element "PLP.rohsCertificateOfCompliance_icons" is present on page
		    And I wait for "3" seconds
		    And I take screenshot
		    And click "PLP.rohsCertificateOfCompliance_link" using js
		    Then I wait for "3" seconds
		    And I take screenshot
		    And I click HTMLCertificate in product compliance certificate popup "PLP.htmlCertificate_link"
		    And I wait for "5" seconds
		    Then I switched on Rohs window and verify customer name in application and Rohs Certificate
		    And I wait for "3" seconds
		    And I take screenshot
		    Then I switch to parent window
		    And I wait for "3" seconds
		    And I click "PLP.firstAdd_button" using js
		    And I click on shopping basket icon on header bar "Header.miniBasket_link"
		    And I wait for "3" seconds
		    And I scroll till "ShoppingCart.rohsCertificateOfCompliance_icons"
		    And I wait for "3" seconds
		    And I take screenshot
		    Then I verify element "ShoppingCart.rohsCertificateOfCompliance_icons" is present on page
		    And I click My Account dropdown "Header.myAccount_dropdown"
		    Then I click on logout option "Header.logout_button"

  @MPNSearch @Priority2 @Search @eu @apac @nwk @live
  Scenario Outline: Manufacturer Part Number Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<ManufacturerPartNumber>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I verify element "PDP.manufPartNo_text" is present on page
		    And I take screenshot of search results page
		    Then I verify PDP page contains MNP "<ManufacturerPartNumber>" in "PDP.manufPartNo_text"
		
		    Examples: 
		      | ManufacturerPartNumber |
		      | ZBVB45                 |
		      | 22.22.8.230.4000       |
		      | ST5918M3008-A      |

  @DescriptiveSearch @Priority2 @Search @eu @apac @nwk @live
  Scenario Outline: Descriptive Keyword Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<ProductDescription>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I take screenshot of the search results page
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    Then I verify element "Search.productsHeader_text" is present on page
		    And I verify search results product header contains "<ProductDescription>" in "Search.productsHeader_text"
		
		    Examples: 
		      | ProductDescription                        |
		      | chip resistor 10 kohm thick film          |
		      | trimpot, multi turn, cermet, top adjust   |
		      | shift register, 8 bit, serial to parallel |

  @ManufacturerSearch @Priority2 @Search @eu @apac @nwk @live
  Scenario Outline: Manufacturer Name Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    When user enter the value "<ManufacturerName>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "5" seconds
		    And I take screenshot of the Manufacturer details page.
		    Then I verify current url contains "/b/"
		    Then I verify element "ManufacturerDetailsPage.ManufacturerName_imgText" is present on page
		    Then I verify element "ManufacturerDetailsPage.ManufacturerDescription_element" is present on page
		    Then I verify text "<ManufacturerName>" in page "ManufacturerDetailsPage.ManufacturerName_imgText" with attribute "alt"
		    And I verify element "ManufacturerDetailsPage.ManufacturerDescription_element" is present on page

		    Examples: 
		      | ManufacturerName |
		      | renesas          |
		      | Kemet            |
		      | 3M               |

  @StemmingSearch @Search @Priority2 @eu @apac @nwk @live
  Scenario Outline: Stemming Keyword Search
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    And I take screenshot to verify the correct search page is loaded
		    And I get the products found count for keyword search
		    And I clears text from textbox "Header.searchBox_textbox"
		    And user enter the value "<StemmingKeyword>" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "3" seconds
		    Then I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
		    And I take screenshot to verify the correct search page is loaded
		    And I get the products found count for stemming keyword search
		    Then I verify the product count equal or not for stemming search
		
		    Examples: 
		      | keyword  | StemmingKeyword |
		      | resistor | resistors       |
		      | register | registers       |

  @QuickOrder @Priority2 @Search @eu @apac @nwk @live
  Scenario: Add items to the basket using quick order
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Home.tools_link" is present on page
		    And I click on "Home.tools_link"
		    And I wait for "2" seconds
		    And I click on QuickBuy link from tools list "Home.quickBuy_link"
		    And I wait for "2" seconds
		    And I verify element "QuickBuy.quickBuy_text" is present on page
		    And I fill quickbuy order details on QuickBuy Page by using given file "QuickBuyOrderDeatils.xlsx"
		    And I click on Add To Basket button on quickbuy page "QuickBuy.addToBasket_button"
		    And I wait for "5" seconds
		    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		    And I scroll till "ShoppingCart.shoppingBasket_text"
		    And I take screenshot of shopping cart page
		    And I verify items added to Shopping BasketPage by using quickbuy from file "QuickBuyOrderDeatils.xlsx"

  @QuickPaste @Priority2 @Search @eu @apac @nwk @live
  Scenario: Add items to the basket using quick paste
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Home.tools_link" is present on page
		    And I click on "Home.tools_link"
		    And I wait for "2" seconds
		    And I click on QuickBuy link from tools list "Home.quickBuy_link"
		    And I wait for "2" seconds
		    And I verify element "QuickBuy.quickBuy_text" is present on page
		    And I click quick Paste button on quick buy page "QuickBuy.quickPaste_button"
		    And I verify element "QuickBuy.quickPasteArea_textbox" is present on page
		    And I enter quick paste order details information by using given file "QuickBuyOrderDeatils.xlsx"
		    And I take screenshot of page
		    And I click on Add To Basket button "QuickBuy.addToCart_button"
		    And I wait for "5" seconds
		    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		    And I scroll till "ShoppingCart.shoppingBasket_text"
		    And I take screenshot of shopping cart page
		    And I verify items added to Shopping BasketPage by using quickbuy from file "QuickBuyOrderDeatils.xlsx"

  @CompareProducts @Priority2 @eu @apac @nwk @live
  Scenario: Compare Products
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I verify element "Header.searchIcon_button" is present on page
		    And I enter the value "bav99" in textbox "Header.searchBox_textbox"
		    And I click the "Header.searchIcon_button"
		    And I wait for "2" seconds
		    And I verify PLP table element "PLP.PLP_element" is present on page
		    And I save the details of "5" product from PLP table
		    And I select first "5" checkbox from PLP table
		    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
		    And I wait for "2" seconds
		    And I verify element "CompareProducts.CompareProducts_text" is present on page
		    And I take screenshot
		    And I compare the saved details of "5" products from PLP table with compare product page
		    And I scroll till "CompareProducts.addToCart_button"
		    And I click on Add To cart icon "CompareProducts.addToCart_button"
		    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		    And I click on delete all link "CompareProducts.deleteAll_link"

    @NullResultPage @Priority2 @aditya @agileRegression @eu @apac @nwk
    Scenario Outline: Null search Results Page
            Given web site is launched successfully and user "does" accept the cookies
            Then customer accesses the website as "userType" user
            Given I verify element "Header.searchBox_textbox" is visible in DOM
            When user enter the value "<SearchTerm>" in textbox "Header.searchBox_textbox"
            Then I click  "Header.searchIcon_button" using js
            And I verify null result page is displayed
            And  I verify error message contains search term
            And I verify if the enter "<SearchTerm>" is part of the string that u see on the top of the page
            And I verify the espot image is available on null result page
            Then I scroll down the page by pixels "500"
            And I verify text "Search Tips" in page "NullResultPage.searchtips_label"
            Then I verify text of"Search Tips" is Not Bold "NullResultPage.searchtips_label"
            And I verify text "Can We Help?" in page "NullResultPage.searchPagehelp_label"
            Then I verify text of "Can We Help?" is Not Bold "NullResultPage.searchPagehelp_label"
            And I verify text "Popular Product Categories" in page "NullResultPage.ProductCategories_label"
            And user take screenshot of the page
            And user clears text from textbox "Header.searchBox_textbox"

            Examples:
                  | SearchTerm |
                  | shshshhs   |
                  | sdsadsad   |
                  | vdsdsahh   |