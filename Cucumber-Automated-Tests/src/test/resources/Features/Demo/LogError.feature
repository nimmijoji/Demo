Feature: Get console error in browser for any application

  @log
  Scenario: Getting console error for page
    Given web site is launched successfully
    And I wait for "10" seconds
    Then I can see the log entry of the page
