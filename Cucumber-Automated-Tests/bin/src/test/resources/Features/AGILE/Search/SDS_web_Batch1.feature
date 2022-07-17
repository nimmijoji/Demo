@Agile_Search
Feature: Search and SOLR - Search Refinements

  Background: 
    Given web site is launched successfully and user "does" accept the cookies
      And customer accesses the website as "usertype" user
      And I verify element "Header.searchBox_textbox" is present on page

  @SDS-209 @Sprint_59
  Scenario Outline: Enlarge clickable target in the Typeahead
     And user enter the value "<keyword>" in textbox "Header.searchBox_textbox"
     And I wait for "3" seconds
     And I take screenshot to view the search look ahead is dispalyed properly
     And I move to "Search.productsList_link" OnOffset and click.
     And I take screenshot of the page
     And I Check if link navigated to PDP so I verify Legislation And Environmental section table is not empty in PDP page
    Then I verify element "PDP.productTitle_text" is present on page
     And I wait for "5" seconds
     And I take screenshot of the page

    Examples: 
      | keyword |
      | sem     |
      | Dis     |
      | res     |
      | Sen     |

  @SDS-154 @Sprint_59
  Scenario: Search Lookahead and Keyword search
    And User enters "Manufacturer" keyword from file "SearchKeywords.xlsx" in searchbox and I verify data matching for manufacturer in Searchahead
    And I wait for "3" seconds

  @SDS-158 @Sprint_59
  Scenario: SDS-158 Campaign code search retrieving exact matched records in Search Results.
    When I enter "campaign-code" from file "SearchKeywords.xlsx" in searchbox
     And I click the "Header.searchIcon_button"
     And I wait for "3" seconds
     And I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
     And I take screenshot to verify the correct search page is loaded
    Then I verify element "Search.productsHeader_text" is present on page and display 'Total Products found for search term' in report
     And I verify text "ProductsCount" in page "Search.productCount_text" from file "SearchKeywords.xlsx"
     And I wait for "5" seconds
     And I take screenshot of the page

  @SDS-241 @Sprint_60
  Scenario Outline: SDS-241 Keyword Search- To collect number of products retrieved
    Given User Enters SearchTerm from "<ExcelFile>" and collects the ProductCount Results in Excel
      And I wait for "5" seconds
      And I take screenshot of the page

    Examples: 
      | ExcelFile           |
      | SearchKeywords.xlsx |

  #|SearchTerm_Batch1_100.xlsx|
  #|SearchTerm_Batch1_300.xlsx|
  #|SearchTerm_Batch1_200.xlsx|
  #|SearchTerm_Batch1_400.xlsx|
  #|SearchTerm_Batch2.xlsx|
  #|SearchTerm_Batch3.xlsx|
  #|SearchTerm_Batch3.xlsx|
  #|SearchTerm_AllKeywords.xlsx|
  
  @SDS-235 @Sprint_60
  Scenario: SDS-235 Keyword with space search retrieving exact matched records in Search Results.
    Given User enters "SearchTerm" from file "SDS- 235_Keywords.xlsx" in searchbox and I verify Searchahead Suggestions
      And I wait for "5" seconds
      And I take screenshot of the page
