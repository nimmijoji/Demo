@SD
Feature:  Remove request a quote feature from the PDP across all Newark sites.

  @sprint57 @SD-2346 @pavithra
  Scenario: Verifying if request quote feature is removed for 4 Random Products in PDP page.
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user
    And I navigate to "browse-for-products" page
    And I wait for "3" seconds
    And I click on random product link and verify if request a quote feature link is removed
    And I wait for "5" seconds
    And I take screenshot