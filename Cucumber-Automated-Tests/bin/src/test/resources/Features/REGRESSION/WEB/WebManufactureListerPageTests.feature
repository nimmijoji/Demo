@1
Feature: Manufacture page tests


  @ManufacturePageregression
  Scenario: Move Hash Manufacturers To Bottom and remove Download Link Of Manufacturer Page
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user
	  When I navigate to "manufacturers" page
    And I wait for "4" seconds
    Then I verify manufacture page display in Ascending order
    And user take screenshot of the page
    Then I scroll down the page by pixels "15000"
    Then I verify '#' is moved to Bottom Of Page
    And user take screenshot of the page
    And I wait for "4" seconds
    Then I Verify current  Url  is contain brand name after clicking on any brand from manufacturer page
    Then I click "ManufacturePage.showAllProduct_button"
    Then element "ManufacturePage.manufacture_checkbox" is selected on page
    And user take screenshot of the page
 
     