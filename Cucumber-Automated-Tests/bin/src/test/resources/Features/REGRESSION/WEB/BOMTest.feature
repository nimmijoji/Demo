@WebRegression
Feature: BOM Test

  @BOMTest
  Scenario: As a customer user should be able to add products from BOM page.
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "register" user
    And I click My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "BOM_Test.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "10" seconds
    And I navigates back in the browser
    And I wait for "2" seconds
    And I wait "long" duration for "BOMUploadPage.dateCreated_text" element to "appear"
    And I verify element "BOMUploadPage.dateCreated_text" is present on page and display Date Created in report
    And I verify element "BOMUploadPage.lastModified_text" is present on page and display last modifed date in report
    And I verify element "BOMUploadPage.verfiedLines_text" is present on page and display verified line /total lines in report
    And I wait for "2" seconds
    And I click on delete element "BOMUploadPage.delete_icon" using js
    And I click on delete cancel button "BOMUploadPage.deleteCancel_button"
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "2" seconds
    And I rename the existing BOM file
    And I wait for "2" seconds
    And I click on "BOMUploadPage.addPart_link"
    And I enter an Order Code and Quantity and click Add a part button
    And I wait for "3" seconds
    Then I verify text total products "9" in page "BOMUploadPage.showAllitems_text"
    And I verify text total products "Direct" in page "BOMUploadPage.qualifier9_text"
    And I click on create Quote button "BOMUploadPage.CreateQuote_link"
    And I verify element "BOMUploadPage.pricingQuery_radio" is present on page
    And I verify element "BOMUploadPage.intendedOrder_radio" is present on page
    And I click on pricing query radio button "BOMUploadPage.pricingQuery_radio"
    And I click continue button on quote pop-up "BOMUploadPage.continue_button"
    And I wait for "2" seconds
    And I update quote name if pop-up displayed
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomQuote_link" is present on page
    And I click on select all checkbox "BOMUploadPage.selectAll_checkbox"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button" using js
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I verify element "ShoppingCart.bomReference_icon" is present on page
    And I verify text "Quoted items will not be saved." in page "ShoppingCart.quoteMessage_text"
    And I clear items from shopping cart if any present
    And I wait for "2" seconds
    And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
    And I click My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "5" seconds
    And User scroll down the page by pixels "1000"
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "2" seconds
    And I click on all select checkbox "BOMUploadPage.allSelect_checkbox"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait for "2" seconds
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I clear items from shopping cart if any present
    And I wait for "2" seconds
    And I click My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
