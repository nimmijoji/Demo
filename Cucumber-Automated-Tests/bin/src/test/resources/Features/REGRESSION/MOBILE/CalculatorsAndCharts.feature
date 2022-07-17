Feature: Calculators & Conversion Charts page regression-verify products listed in calculators page 


@Calculators
Scenario: Calculators & Conversion Charts page and their listed product page verification
Given web site is launched successfully and user "does" accept the cookies
Then customer accesses the website as "userType" user
And I verify the "Home.geoLocationNo_button" functionality if exists on page
And user click on navigation bar "Home.navbarToggle_button"
And I scroll till "Home.resources_link"
Then I click on Resources "Home.resources_link"
And I click on CalculatorsAndCharts "Home.calculators_link"
And I verify CalculatorsAndCharts Header element "CalcuatorsAndCharts.header_element" is present on page
And I take screenshot
And I get number of products present in page CalculatorsAndCharts "CalcuatorsAndCharts.products_element"  .*
And I scroll down the page by pixels "4000"
And I verify CalculatorsAndCharts page products from file "CalculatorsAndChartsPdts"
And I click on logo button "Home.logo_link"
And I take screenshot
And I click CalculatorsAndCharts on footer "CalcuatorsAndCharts.calFooter_button"
And I take screenshot
And I verify CalculatorsAndCharts Header element "CalcuatorsAndCharts.header_element" is present on page
