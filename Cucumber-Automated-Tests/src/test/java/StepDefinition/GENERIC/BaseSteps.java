package StepDefinition.GENERIC;

import static Common.CONSTANTS.APIConstants.*;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.*;

public class BaseSteps extends WebDriverConfig {

    WebDriver driver = null;
    private ContextStore context;
    private String companyID;

    String env;
    String region;
    String parametricUrl = "";
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    private static final Logger logger = LogManager.getLogger(BaseSteps.class);

    public BaseSteps(ContextStore context) {
        this.context = context;
    }

    public String storeWSCVerson(String baseURL) throws Exception {
        String ecommerceDeployedVersionValue = "";

        // System properties for constants.
        Properties props = System.getProperties();

        final String siteConfidenceUrlText =
            "/webapp/wcs/stores/servlet/SiteConfidenceCmd?storeId=0&catalogId=0";
        String siteConfidenceURL = null;

        // Get siteconfidence html content
        String siteConfidenceHtmlContent = "";
        if (baseURL != null) {
            siteConfidenceURL = baseURL.concat(siteConfidenceUrlText);
            // siteConfidenceHtmlContent =
            // getsiteConfidenceHtmlContent(siteConfidenceURL);

            driver.get(siteConfidenceURL);
            Thread.sleep(3000);
            siteConfidenceHtmlContent = driver.getPageSource();
            // driver.close(); // This causes SeleniumWatchdog to echo
            // Destroying forcefully (v2). FF >v30 bug
        }

        if (!siteConfidenceHtmlContent.isEmpty()) {
            final Pattern pattern = Pattern.compile(
                "[0-9]{1,}\\.[0-9]{1,}\\.[0-9]{2,}\\.[0-9]{1,}\\.?[0-9]{0,}\\.?[0-9]{0,}"
            );

            Matcher matcher = pattern.matcher(siteConfidenceHtmlContent);

            if (matcher.find()) {
                String ecommerceDeployedVersionKey = "ecommerceDeployedVersion";
                ecommerceDeployedVersionValue = matcher.group().toString().trim();
                // Store WSC version in session
                props.setProperty(
                    ecommerceDeployedVersionKey,
                    ecommerceDeployedVersionValue
                );
            } else {
                // throw new GeneralFrameworkException(
                Assert.fail("Match for deployed version is not found");
            }
        } else {
            // throw new GeneralFrameworkException(
            Assert.fail("Can not retrieve Ecommerce build version information");
        }

        return ecommerceDeployedVersionValue;
    }

    /**
     * Verify the deployed version
     */
    @Given("user is validating the correct deployed build version of the site$")
    public void storeWSCVersonInProperties() throws Throwable {
        if (ContextStore.DEPLOYMENT_VERSION == null) {
            ContextStore.DEPLOYMENT_VERSION = storeWSCVerson(getSiteBaseUrl());
            logger.info("WSC Version captured from site confidence");
        }
    }

    @And(
        "^user navigate to \"([^\"]*)\" store homepage and \"([^\"]*)\" accept the cookies$"
    )
    public void navigate_to_site_with_user(String store, String isCookieAccepted)
        throws Throwable {
        driver = getDriver();
        // load properties files
        configUtil.loadProperty();
        // Get the base url from properties file
        String baseUrl = envConfig.getProperty(store);
        // Set the system variable with url value
        System.setProperty("siteUrl", baseUrl);

        storeWSCVersonInProperties();

        // Setup the browser for execution
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(getWidth(), getHeight()));
        driver.manage().deleteAllCookies();

        // Launch the url & handle cookie banner if any
        driver.get(baseUrl);
        if (!isCookieAccepted.contains("not")) {
            this.acceptCookie();
        }
        Thread.sleep(2000);

        // Set the dynamic constants object based on region
        this.context.constants = getConstantTypeObject();

        printExecutionDetailsInReport();

        // Wait until homepage is loaded
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "Header.companylogo_element"
        );
    }

    /**
     * Common Step to Open the site with device
     *
     * @param isCookieAccepted
     *            For your project to define page type url / init page object
     * @throws Throwable
     */

    @Given("^web site is launched successfully and user \"([^\"]*)\" accept the cookies$")
    public void the_web_site_is_opened(String isCookieAccepted) throws Throwable {
        driver = getDriver();
        storeWSCVersonInProperties();
        // Setup the browser for execution
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(getWidth(), getHeight()));
        driver.manage().deleteAllCookies();

        driver.get(getSiteBaseUrl());

        if (!isCookieAccepted.contains("not")) {
            this.acceptCookie();
        }
        Thread.sleep(2000);

        // Add a cookie to avoid geo location pop-up
        driver.manage().addCookie(new Cookie("pf_siteRedirectOffered", "yes"));

        //Add a cookie to avoid Feedback pop-up in checkout page
        driver
            .manage()
            .addCookie(new Cookie("UZ_TI_S_2C0082D28598EC11AA778B512CC5224C", "yes"));

        //Add a cookie to avoid Feedback pop-up in checkout page in US PP
        driver
            .manage()
            .addCookie(new Cookie("UZ_TI_S_DF0C70785DEDEC11AA7B899E75EAE93B", "yes"));

        // load properties files
        configUtil.loadProperty();
        // Set the dynamic constants object based on region
        this.context.constants = getConstantTypeObject();

        printExecutionDetailsInReport();

        // Wait until homepage is loaded
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "Header.companylogo_element"
        );
    }

    public void printExecutionDetailsInReport() {
        context.scenario.log("WSC version: " + ContextStore.DEPLOYMENT_VERSION);
        context.scenario.log("Test URL: " + getSiteBaseUrl());
        context.scenario.log("Environment : " + getEnv());
        context.scenario.log("Region: " + getRegionName());
        context.scenario.log("Store: " + getStore());
        context.scenario.log("Browser: " + getBrowserType());
        context.scenario.log("Application: " + getAppType());
    }

    @And("^customer accesses the website as \"([^\"]*)\" user$")
    public void customer_accesses_website_as_usertype(String userType) throws Exception {
        if (userType.equalsIgnoreCase("userType")) {
            userType = getUserType();
            context.scenario.log("Test Executed for user: " + getUserType());
        }
        switch (userType.toLowerCase()) {
            case "guest":
                guest_user();
                break;
            case "contract":
                this.context.currentUserType = "contract";
                login_user("contract");
                break;
            case "ibuy":
                this.context.currentUserType = "ibuy";
                login_user("ibuy");
                break;
            case "ibuy pfsa admin":
                this.context.currentUserType = "ibuy pfsa admin";
                login_user("ibuy_pfsa_admin");
                break;
            case "login":
                this.context.currentUserType = "login";
                login_user("regular");
                break;
            case "punchout":
                this.context.currentUserType = "punchout";
                punchout_user();
                break;
            case "register":
                this.context.currentUserType = "register";
                register_user("register");
                break;
            case "register as synch":
                this.context.currentUserType = "register as synch";
                register_user("synch");
                break;
            default:
                throw new AssertionError("Given user is not found");
        }
    }

    public void guest_user() throws Exception {
        logger.info("Welcome as Guest user");
    }

    public void login_user(String loginUserType) throws Exception {
        context.scenario.log("Verify user is login with valid credentials");
        String username = "";
        String password = "";
        String store = getStore();
        region = getRegionName();
        String appName = getAppType();
        actionMethods.click("Header.login_link");
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            "Login.login_element"
        );

        switch (loginUserType.toLowerCase()) {
            case "regular":
                username = loginConfig.getProperty(store + "_username");
                password = loginConfig.getProperty(store + "_password");
                break;
            case "ibuy":
                username = ibuyConfig.getProperty(store + "_username");
                password = ibuyConfig.getProperty(store + "_password");
                break;
            case "ibuy_pfsa_admin":
                username = ibuyPfsaAdminConfig.getProperty(region + "_username");
                password = ibuyPfsaAdminConfig.getProperty(region + "_password");
                break;
            case "contract":
                username = contractConfig.getProperty(store + "_username");
                password = contractConfig.getProperty(store + "_password");
                break;
            default:
                throw new AssertionError("Given user is not found");
        }

        if (appName.equalsIgnoreCase("mobile")) {
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        Thread.sleep(5000);
        actionMethods.enterText(username, "Login.username_textbox");
        context.scenario.log("Username: " + username);
        actionMethods.enterText(password, "Login.password_textbox");
        context.scenario.log("Password: " + password);
        Thread.sleep(3000);
        actionMethods.click("Login.login_button");
        Thread.sleep(9000);
        userIsLoggedIn();
    }

    public void punchout_user() throws Exception {
        String appName = getAppType();
        String store = getStore();

        if (appName.equalsIgnoreCase("mobile")) {
            context.scenario.log("Punchout is not applicable for mobile view");
        } else {
            if (store.equalsIgnoreCase("us")) {
                driver
                    .navigate()
                    .to(
                        "http://www.admin.ftprdus.element14.com:8080/EprocTester/punchBuster.jsp"
                    );
                companyID = "7000000000000189472";
            }
            if (store.equalsIgnoreCase("uk")) {
                driver
                    .navigate()
                    .to(
                        "http://www.admin.ftprdeu.element14.com:8080/EprocTester/punchBuster.jsp"
                    );
                companyID = "170000636502";
            }

            if (store.equalsIgnoreCase("au")) {
                driver
                    .navigate()
                    .to(
                        "http://www.admin.ftprdap.element14.com:8080/EprocTester/punchBuster.jsp"
                    );
                companyID = "370000278001";
            }

            context.scenario.log("User selects Production environment.");
            actionMethods.click("Punchout.env_option_prod");

            context.scenario.log("User clicks on Submit button.");
            actionMethods.click("Punchout.submit_button");

            context.scenario.log("User selects the company by Id:" + companyID);
            selectCompanyById(companyID);

            context.scenario.log(
                "User clicks on Submit button to login as punchout user"
            );
            actionMethods.click("Punchout.submit_button");
        }
    }

    public void selectCompanyById(String companyId) {
        List<WebElement> companyList = getDriver().findElements(By.tagName("option"));
        for (WebElement option : companyList) {
            if (option.getText().contains(companyId)) {
                String companyInfo = option.getAttribute("value");
                driver
                    .findElement(By.xpath("//option[@value='" + companyInfo + "']"))
                    .click();
            }
        }
    }

    public void register_user(String user) throws Exception {
        String path = "";

        if (user.equalsIgnoreCase("register")) {
            if (appName.equalsIgnoreCase("mobile")) {
                path = FilePath + "MobileRegistration.xlsx";
            } else path = FilePath + "Registration.xlsx";
        } else if (user.contains("synch")) {
            path = FilePath + "SynchUserRegistration.xlsx";
        }

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        actionMethods.click("Register.register_link");

        if (appName.equalsIgnoreCase("mobile")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getMediumWaitSeconds(),
                "Login.login_element"
            );
            actionMethods.click("Register.registerNow_button");
        }
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "Register.registerTitle_text"
        );
        Thread.sleep(6000);
        String accountType = testData.get(0).get("accountType");
        String username = actionMethods.generateRandomNumberString(
            testData.get(0).get("username")
        );
        this.context.currentUser = username;

        String password = this.context.constants.getPassword();
        String fullName = testData.get(0).get("fullName");
        String personTitle = testData.get(0).get("personTitle");
        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String emailAddress = testData.get(0).get("emailAddress");
        String phoneNumber = testData.get(0).get("phoneNumber");
        String phoneExtNumber = testData.get(0).get("phoneExtNumber");
        String postCode = testData.get(0).get("postCode");
        String country = testData.get(0).get("country");
        String companyName = testData.get(0).get("companyName");
        String vatRegistrationNumber = testData.get(0).get("vatRegistrationNumber");
        String salesTax = testData.get(0).get("salesTax");
        String primaryJob = testData.get(0).get("primaryJob");
        String primaryUse = testData.get(0).get("primaryUse");
        String accountNumber = testData.get(0).get("accountNumber");
        String mobileNumber = testData.get(0).get("mobileNumber");
        String contactYou = testData.get(0).get("contactYou");

        if (accountType.equalsIgnoreCase("skip") || fullName == null) {} else {
            actionMethods.click("Register.businessAccount_radio");
        }

        actionMethods.enterText(username, "Register.username_textbox");
        context.scenario.log("Username for new user: " + username);

        actionMethods.enterText(password, "Register.password_textbox");
        context.scenario.log("Password for new user: " + password);

        if (fullName == null || fullName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(fullName, "Register.fullName_textbox");
        }
        if (personTitle == null || personTitle.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByIndex(1, "Register.title_dropdown");
        }
        if (firstName == null || firstName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(firstName, "Register.firstName_textbox");
        }
        if (lastName == null || lastName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(lastName, "Register.lastName_textbox");
        }
        if (emailAddress == null || emailAddress.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(emailAddress, "Register.emailAddress_textbox");
        }
        if (phoneNumber == null || phoneNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(phoneNumber, "Register.phoneNumber_textbox");
        }
        if (phoneExtNumber == null || phoneExtNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(phoneExtNumber, "Register.extensionNumber_textbox");
        }
        if (postCode == null || postCode.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(postCode, "Register.postalCode_textbox");
        }
        if (country == null || country.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(country, "Register.country_dropdown");
        }
        if (companyName == null || companyName.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(companyName, "Register.companyName_textbox");
        }
        if (
            vatRegistrationNumber == null ||
            vatRegistrationNumber.equalsIgnoreCase("skip")
        ) {} else {
            actionMethods.enterText(vatRegistrationNumber, "Register.vatNumber_textbox");
        }
        if (salesTax == null || salesTax.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(salesTax, "Register.salesTax_textbox");
        }
        if (primaryJob == null || primaryJob.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByValue(primaryJob, "Register.primaryRole_dropdown");
        }
        if (primaryUse == null || primaryUse.equalsIgnoreCase("skip")) {} else {
            actionMethods.selectValueByValue(primaryUse, "Register.primaryUse_dropdown");
        }
        if (accountNumber == null || accountNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(accountNumber, "Register.accountNumber_textbox");
        }
        if (mobileNumber == null || mobileNumber.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(mobileNumber, "Register.mobileNumber_textbox");
        }
        if (contactYou == null || contactYou.equalsIgnoreCase("skip")) {} else {
            actionMethods.enterText(contactYou, "Register.contactYou_textbox");
        }

        if (appName.equalsIgnoreCase("web")) {
            if (getStore().equalsIgnoreCase("kr")) {
                actionMethods.click("Register.consent_checkbox");
            }
            // use below method only to skip captcha
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('Register').submit();");
        } else if (appName.equalsIgnoreCase("mobile")) {
            actionMethods.click("Register.register_button");
        }

        userIsLoggedIn();
    }

    @Given(".*accept all cookies if asked$")
    public void acceptCookie() throws Exception {
        String region = getRegionName();
        if (region.equalsIgnoreCase("europe")) {
            actionMethods.click("CookieSetting.oneTrustCookie_button");
        } else {
            logger.info("Cookie banner is not applicable");
        }
    }

    @Given("^Verify user is logged in on Home page successfully$")
    public void userIsLoggedIn() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "Header.userFirstName_text"
        );
        String value = actionMethods.getValue("Header.userFirstName_text");
        context.scenario.log("User is logged in to its account:" + value);
        Assert.assertTrue(!value.equalsIgnoreCase(""));
    }

    @And("^.*save the newly registered \"([^\"]*)\" user details$")
    public void save_current_user(String userType) {
        if (userType.contains("sync")) {
            ContextStore.SYNCH_USER_NAME = context.currentUser;
        } else {
            ContextStore.USER_NAME = context.currentUser;
        }
    }

    @And("^.*assume environment stub is disabled in PP environment$")
    public void assume_PP_env_stub_disabled() {
        if (getEnv().equalsIgnoreCase("pp") && ContextStore.STUB_ENABLED) {
            Assume.assumeTrue("Environment is stubbed", false);
        }
    }

    @And("^.* enter ordercode .* in \"([^\"]*)\"$")
    public void enterOrdercode(String locator) throws Exception {
        String expectedOrderCode = this.context.constants.getOrderCode();
        actionMethods.enterText(expectedOrderCode, locator);
    }

    @Given(".*^\"([^\"]*)\" environment is setup$")
    public void prepare_environment(String store) throws Throwable {
        setEnv();
        // load properties files
        configUtil.loadProperty();
        // prepare environment
        setBaseURI(store);
        initEnvironment();

        // Set the dynamic constants object based on region
        this.context.constants = getConstantTypeObject();
        // Proxy settings to access URL
        RestAssured.proxy(getProxyHost(), getProxyPort());

        // rest assured global config
        this.context.config =
            RestAssuredConfig
                .config()
                .encoderConfig(
                    EncoderConfig
                        .encoderConfig()
                        .appendDefaultContentCharsetToContentTypeIfUndefined(false)
                );
        getDeploymentVersion();
        printExecutionDetailsInReport();
    }

    public void getDeploymentVersion() {
        HashMap<String, String> queryParams = new HashMap<String, String>();
        queryParams.put(STORE_ID_CONST, ZERO_CONST);
        queryParams.put(CATALOG_ID_CONST, ZERO_CONST);

        String resourcePath = applicationConfig.getProperty(
            PROP_KEY_PREFIX.concat(SITE_CONFIDENCE_NAME)
        );
        Response res = apiBaseMethods.getRequest(
            this.context.config,
            null,
            queryParams,
            resourcePath
        );
        if (res.statusCode() == 200) {
            Document doc = Jsoup.parse(res.body().asString());
            Elements elements = doc.getElementsByTag("p");
            for (Element e : elements) {
                if (e.html().contains("Deployed Version")) {
                    ContextStore.DEPLOYMENT_VERSION = e.html().split(":")[1];
                    break;
                }
            }
        } else {
            Assert.fail("Something went wrong, Website might be down");
        }
    }
}
