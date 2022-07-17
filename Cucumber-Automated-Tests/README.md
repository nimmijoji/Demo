# Cucumber Automated Test for Premier Farnell

### Framework Design Approach

Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. Framework
has been built using Page Object Model and Page Factory. Page Object Model is a design pattern which has become popular
in test automation for enhancing test maintenance and reducing code duplication. Page Factory is an inbuilt Page Object
Model concept for Selenium WebDriver, but it is very optimized. With the help of PageFactory class, we use Repository_obj 
class file store to find WebElement and use initElements method to initialize web elements. WebDriverManager library is used,
which allows to automate the management of the binary drivers (e.g. chromedriver, geckodriver, etc.) required by
Selenium WebDriver.

### Tools And Environment

1. Any IDE( Eclipse, IntelliJ, VStudio)
2. Java-8
3. Maven
4. Install Cucumber plugin in the respective IDE
5. Gitlab

If using Windows OS, Configure JAVA_HOME and MAVEN_HOME in the Environmental Variables : Follow the setup instructions
specified in here https://www.mkyong.com/maven/how-to-install-maven-in-windows/

### The project directory structure

The project has build scripts for Maven and below is describes the directory structure of the project

~~~~
src
  + main
    + Translation Files             To capture Non-English text in kep-value pair
    + Object Repository             To Store all the Web Elements
    + Properties File               To store valued for Environment and different users
    + Constants                     To store resuable values in step file
  + test
    + java   
      + Common Utils, helper        Test runners and supporting code
      + Step Definitions            Steps defintion code
      + Pages                      
    + resources
      + features                    Feature files for Regression, BAU Projects and Agile
      + Test Data                   Test data across all the regions EU, APAC, NEWARK in excel sheet 
          All featurefiles.feature
      runconfig.properties          This will help in running the test  
      
~~~~

### **Executing the tests**

Please make sure to have all the tools and libraries mentioned in the "Tools And Environment" section.

**Step-1**: Clone the repository from  https://gitlab.com/premier-farnell/commerce.git

**Step-2**: Use the following maven commands to run the tests.

Run all tests (default: chrome and web)

~~~~

mvn clean test -Denv={envValue} -Dcucumber.filter.tags={scenario or feature to be executed} -Dtest={runner file to be executed} -DsiteUrl={website you want to launch} -DuserType={user you want to run} -DappName={application type (web/mobile)}

e.g
mvn clean test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DuserType=Guest -DappName=web
~~~~

Run all tests (default: chrome and web) by passing url and usertype from Examples of feature file

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DappName=web
~~~~

Run all UI tests with firefox

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DbrowserName=firefox -DuserType=Guest -DappName=web
~~~~

Run all UI tests with Edge

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DbrowserName=edge -DuserType=Guest
~~~~

Run all UI tests with Chrome or any browser as Headless

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DHeadless=true -DuserType=Guest
~~~~

Run all UI tests with Chrome or any browser with runner file to take Screenshot after everystep

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@websmoketest and @verifySEOTitle" -Dtest=Screenshot_After_Each_Step.java -DsiteUrl=https://uk.farnell.com/ -DuserType=Guest
~~~~

Run all tests (default: chrome and mobile)

~~~~
mvn test -Denv=live -Dcucumber.filter.tags="@mobsmoketest and @SearchLookAhead" -Dtest=TestRunner.java -DsiteUrl=https://uk.farnell.com/ -DappName=mobile -DuserType=Guest
~~~~

### Cucumber Test Reports

A Spark Dashboard HTML report is generated in `target/test-output/Spark` directory

Screenshots are captured in `target/test-output/screenshots` directory

~~~~
overview-features.html - The graphs show passing and failing statistics for features in web format
overview-steps.html    - The graph shows step statistics for this build
~~~~

Link to Download the Chrome Driver matching to your browser version:
https://chromedriver.chromium.org/downloads
