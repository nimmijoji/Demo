@1
Feature: PLP page tests

  Background: Launch homepage for PLP regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @staticFiler @Priority1
  Scenario: Verify Static Filters on PLP Page
    When I navigate to "c/crystals-oscillators/crystals" page
    And I get the Products found count before applying filters
    And user enter the value "vishay" in textbox "PLP.withinSearch_textbox"
    And I click on "PLP.withinSearch_button"
    And I get the Products found count before applying filters
    And I navigates back in the browser
    And I scroll till "PLP.manufactureSearch_textbox"
    And user enter the value "ABB - THOMAS" in textbox "PLP.manufactureSearch_textbox"
    And I click on "PLP.search_element"
    And I get the Products found count before applying filters
    And user take screenshot of the page
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I verify Filter Applied section element "Filters.filterAppliedLeftView_section" is present on page
    And I click "Filters.clearAllFilters_link"
    And I wait for "5" seconds
    And I verify the Products found count after clearing all the filters
    And I click the toggle view from LEFT to TOP view "Filters.filterView_toggle"
    And user take screenshot of the page
    And I verify Filter Applied section element "Filters.filterView_toggle" is present on page
    When I select by index "1" from dropdown "Filters.filterManufacturer_section"
    And I click on "Filters.reset_link"
    And I get the Products found count before applying filters
    And user take screenshot of the page
    And user take screenshot of the page
    And I click on Show Result button "Filters.showResult_button" refreshed element
    When I select by index "3" from dropdown "Filters.filterManufacturer_section"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I verify Filter Applied section element "Filters.filterAppliedTopView_section" is present on page
    And I click "Filters.clearAllFilters_link"
    And I wait for "5" seconds
    And I verify the Products found count after clearing all the filters
    And user take screenshot of the page
    And I click on Min dropdown "PLP.minimum_dropdown"
    When I select by index "1" from dropdown "PLP.minimum_dropdown"
    And user verify element "Filters.reset_link" is present on page
    And I click on "Filters.reset_link"
    And I wait for "4" seconds
    And I click on Max dropdown "PLP.maximum_dropdown"
    When I select by index "2" from dropdown "PLP.maximum_dropdown"
    And user verify element "Filters.reset_link" is present on page
    And I click on "Filters.reset_link"
    And I click on Min dropdown "PLP.minimum_dropdown"
    When I select by index "1" from dropdown "PLP.minimum_dropdown"
    And I click on Max dropdown "PLP.maximum_dropdown"
    And I wait for "4" seconds
    When I select by index "2" from dropdown "PLP.maximum_dropdown"
    And I scroll till "Filters.showResult_button"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I click on "Filters.reset_link"
    And I wait for "5" seconds
    And I scroll till "PLP.remember_checkbox"
    And I wait for "3" seconds
    And I click on "PLP.remember_checkbox" using js
    And I wait for "4" seconds
    And user take screenshot of the page
    And I click on "Filters.instock_checkbox" using js
    And I select instock sub radio button "PLP.rememberInstock_radio" if available
    And I scroll till "Filters.showResult_button"
    And I wait for "5" seconds
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And user take screenshot of the page
