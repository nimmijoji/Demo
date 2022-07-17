Feature: To compare products on PLP page

  @SearchCompareProductsPLP @Priority2 @Shilpa
  Scenario: Search Compare Products on PLP
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    And I wait for "3" seconds
    And user navigate to "w/c/passive-components/resistors-fixed-value/through-hole-resistors/prl/results?sort=P_INVENTORY|1&a=y" page
    And I wait for "3" seconds
    And I take screenshot
    And I verify PLP table element "PLP.PLP_element" is present on page
    And I scroll down the page by pixels "1000"
    And I save the details of "10" product from PLP table
    And I scroll up the page by pixels "3500"
    And I select first "10" checkbox from PLP table
    And I scroll up the page by pixels "3500"
    And I take screenshot
    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I take screenshot
    And I compare the saved details of "10" products from PLP table with compare product page
    And I click on "CompareProducts.backToPreviousPage_link"
    And I scroll down the page by pixels "1000"
    And I click on the next checkbox to compare "PLP.eleventhCompare_checkbox"
    And I scroll up the page by pixels "3500"
    And I take screenshot
    And I click on compare selected button on PLP Page "PLP.compareSlected_button"
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I take screenshot
    Then I verify the text displayed contains  "You've selected 11 products. You can compare up to 10 products at a time. The most recent 10 products will be shown." in "CompareProducts.CompareMessage_text"
    And I verify element "CompareProducts.rohsCertificateOfCompliance_icons" is present on page
    And click "CompareProducts.rohsCertificateOfCompliance_link" using js
    Then I wait for "3" seconds
    And I take screenshot
    And I click HTMLCertificate in product compliance certificate popup "CompareProducts.htmlCertificate_link"
    And I wait for "2" seconds
    Then I switched on Rohs window and verify customer name in application and Rohs Certificate
    And I wait for "2" seconds
    And I take screenshot
    Then I switch to parent window
    And I wait for "2" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I verify count of elements present as "10" in page "CompareProducts.orderCodeItem_text"
    And I click on "CompareProducts.firstDelete_link"
    And I wait for "3" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I click on "CompareProducts.firstDelete_link"
    And I wait for "3" seconds
    And I verify element "CompareProducts.CompareProducts_text" is present on page
    And I verify count of elements present as "9" in page "CompareProducts.orderCodeItem_text"
    And I take screenshot
    And I click "PLP.firstAdd_button" using js
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I take screenshot
		And I click on delete all link "CompareProducts.deleteAll_link"
		Then I verify absence of element "CompareProducts.orderCodeItem_text"