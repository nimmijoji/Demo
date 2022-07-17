#Author: Soumen Maity
@Mobile @RoHS @Regression
Feature: Verify RoHS Certificate

  Background: Launch homepage for PDP regression check
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "userType" user
    And I enter "RoHSProductCode" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    Then I click on "Header.searchIcon_button"

  @nameAndImgAccordian
  Scenario: This scenario is to verify whether Product name and details are displaying as expected
    Given I wait "medium" duration for "CategoryPage.breadcrumb_link" element to "appear"
    And I verify text color of Product Heading as "dark charcoal,#333333,PDP.productHeading_text"
    And I verify text of Product Heading is Bold "PDP.productHeading_text"
    And I verify text color of Product Heading as "black,#000000,PDP.productCatName_text"
    And I verify text color of Product Heading as "sonic silver,#000000,PDP.productCatName_text"
    When I click on "PDP.imagesSection_element"
    And I verify element "PDP.productImage_image" is visible in DOM
    Then I verify element "PDP.underImagetext_text" is visible in DOM

  @PriceAccordian
  Scenario: This scenario is to verify price section and details of the product
    Given I scroll till "PDP.priceSection_element"
    And I wait for "3" seconds
    And I verify below are displayed in "PDP.priceTableAttribute_text" table on PDP
      | Price for               |
      | Minimum order quantity  |
      | Order multiple quantity |
      | Price                   |
    When I click on "PDP.yourPartNo_link"
    Then I verify element "PDP.yourPartNo_text" is visible in DOM
    And I verify element "PDP.yourPartNo_textbox" is visible in DOM
    And I verify element "PDP.lineNote_text" is visible in DOM
    And I verify element "PDP.lineNote_textbox" is visible in DOM
    When I click on "PDP.yourPartNo_link"
    When I enter value "123" in textbox "PDP.yourPartNo_textbox"
    And I wait for "3" seconds
    And I enter value "ABC" in textbox "PDP.lineNote_textbox"
    When user verify text "Quantity" is visible for "PDP.quantity_text"
    And I verify that element "PDP.quantity_textbox" is present on page
    And I verify background color of cart button as "green,#41c363,PDP.addToCart_button"
    Then user clears text from textbox "PDP.quantity_textbox"
    And I enter value "10" in textbox "PDP.quantity_textbox"
    When I click on "PDP.addToCart_button"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"

  @AvailabilityAccordian
  Scenario: This scenario is to check the availability of a product
    Given scroll till "PDPBuyBox.availabilitySection_element"
    And user verify text "Availability" is visible for "PDPBuyBox.availabilitySection_text"
    Then I verify element "PDPBuyBox.availableStock_text" is present on page and display its value in report
    And I verify element "PDPBuyBox.seeCutOffTime_link" is present on "EUROPE,NEWARK" region/store
    And I click on "PDPBuyBox.seeCutOffTime_link"
    Then I verify element "PDPBuyBox.seeCutOffTime_text" is present on page and display its value in report

  @ProductInfoAccordian
  Scenario: This scenario is to verify product information
    Given scroll till "PDP.productInfoSection_element"
    And user verify text "Product Information" is visible for "PDP.productInfoSection_text"
    And I verify element "PDP.manufacturerLogo_link" is present on page
    And I verify element "PDP.manufacturerName_text" is present on page
    And I verify that element "PDP.prodInfo_table" is present on page
    And I verify that element "PDP.orderCode_text" is present on page and display its value in report
    When I click on "PDP.manufacturerName_link"
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    Then user navigates back in the browser
    And I verify that element "PDP.technicalDataSheet_text" is present on page
    When I click on "PDP.viewAllTechDoc_link"
    Then user verify text "Technical Documents" is visible for "PDP.technicalDocSection_text"
    And I verify that element "PDP.technicalDocSection_element" is present on page
    And I click on "PDP.technicalDocSection_element"
    Then I verify number of technical documents matches with the header

  @ProductOverviewAccordian
  Scenario: This scenario is to verify product overview
    Given scroll till "PDP.productOverviewSection_element"
    And I verify text color of Product Heading as "dark charcoal,#333333,PDP.prodOverview_text"
    Then I verify that "PDP.viewAllCategory_link" is equal to "PDP.manufacturerName_link"

  @Legislation
  Scenario: This scenario is to verify Legistation Accordian
    Given scroll till "PDP.legislationAndEnvSection_element"
    When I click on "PDP.legislationAndEnvSection_element"
    And I wait for "3" seconds
    And I verify below are displayed in "PDP.legalContent_table" table on PDP
      | Country of Origin         |
      | Tariff No                 |
      | RoHS Compliant            |
      | RoHS Phthalates Compliant |
      | SVHC                      |
      | Weight (kg)               |
    And I verify element "PDP.roHSCompliantIcon_element" is present on page
    When I click on "PDP.prodComplianceCert_link"
    And I verify element "PDP.pDFCert_link" is present on page
    And I verify element "PDP.hTMLCert_link" is present on page
    Then I click on "PDP.closeProdCompCert_button"
    And I wait for "2" seconds
    When I click on "PDP.prodComplianceCert_link"
    And I click on "PDP.hTMLCert_link"
    And I wait for "2" seconds
    And I switch to new window
    #And I wait "3" seconds for displaying new window
    Then I verify current url contains "GenerateRoHSCertificate"
