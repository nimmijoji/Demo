package Common.UTILS;

import Common.CONSTANTS.Constants;
import Common.CONSTANTS.ConstantsAPAC;
import Common.CONSTANTS.ConstantsEUROPE;
import Common.CONSTANTS.ConstantsNEWARK;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverConfig implements BaseTest {

    /** handle to the webdriver */
    protected static WebDriver driver = null;

    public static Properties runConfig = null;
    public static Properties envConfig = null;
    public static Properties ibuyConfig = null;
    public static Properties ibuyPfsaAdminConfig = null;
    public static Properties contractConfig = null;
    public static Properties loginConfig = null;
    public static Properties forgotPwdConfig = null;
    public static Properties xcomregConfig = null;
    public static Properties applicationConfig = null;
    public static FileInputStream input = null;
    public static FileInputStream fis;
    public static Properties prop;
    public static String runEnv;
    public static String headless;
    public static String browserName;
    public static String appName;
    public static String siteUrl;
    public static String width;
    public static String height;
    public static String firefoxProfile;
    public static String incognito;
    public static String baseURI;
    public static String region;
    public static String store;
    public List<String> chromeOptionsArgs;

    // Wait for AJAX if needed
    protected int secondsToWait = 1000;

    private static final Logger logger = LogManager.getLogger(WebDriverManager.class);

    /**
     * Get the driver with devices
     *
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    public WebDriver getDriver() {
        if (null != driver && ((RemoteWebDriver) driver).getSessionId() != null) {
            return driver;
        }

        logger.info(
            "*** Reading values in order: 1. MVN Command Line 2. RunConfig File 3. Default ***"
        );

        runEnv =
            (String) System.getProperty("runEnv", prop.getProperty("runEnv", "local"));
        browserName =
            (String) System.getProperty(
                "browserName",
                prop.getProperty("browserName", "chrome")
            );
        appName =
            (String) System.getProperty("appName", prop.getProperty("appName", "web"));
        headless =
            (String) System.getProperty(
                "Headless",
                prop.getProperty("Headless", "false")
            );
        firefoxProfile =
            (String) System.getProperty(
                "firefoxProfile",
                prop.getProperty("firefoxProfile", "default")
            );
        siteUrl = (String) System.getProperty("siteUrl", prop.getProperty("siteUrl"));
        incognito =
            (String) System.getProperty(
                "incognito",
                prop.getProperty("incognito", "false")
            );
        setWidth();
        setHeigth();
        setCustomChromeOptionsIfAny();
        initEnvironment();

        // This directory is not in use(can be removed)
        String driverDirectory = System.getProperty("user.dir") + "\\drivers\\";

        switch (browserName.toLowerCase()) {
            case "chrome":
                if (runEnv.equalsIgnoreCase("server")) {
                    WebDriverManager.chromiumdriver().setup();
                }
                if (runEnv.equalsIgnoreCase("local")) {
                    WebDriverManager.chromedriver().setup();
                }

                // to delete once serenity is not in use
                if (runEnv.equalsIgnoreCase("remote")) {
                    System.setProperty(
                        "webdriver.chrome.driver",
                        System.getProperty("webdriver.chrome.driver")
                    );
                }

                // Default Chrome Options
                ChromeOptions options = new ChromeOptions();

                // headless config
                if (headless.equalsIgnoreCase("true")) {
                    options.setHeadless(true);
                }

                // incognito mode
                if (incognito.equalsIgnoreCase("true")) {
                    options.addArguments("--incognito");
                }

                options.addArguments("--start-maximized");
                options.addArguments("--disable-dev-shm-usage", "--no-sandbox");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--ignore-certificate-errors");

                // appName config
                if (appName.equalsIgnoreCase("mobile")) {
                    options.addArguments(
                        "--user-agent=Mozilla/5.0 (Linux; Android 6.0.1; SM-G920V Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36"
                    );
                }

                // set additional chrome options through cli
                if (chromeOptionsArgs != null) {
                    options.addArguments(chromeOptionsArgs);
                }

                driver = new ChromeDriver(options);

                break;
            case "firefox":
                // firefox setup
                if (runEnv.equalsIgnoreCase("local")) {
                    WebDriverManager.firefoxdriver().setup();
                }

                // to delete once serenity is not in use
                if (runEnv.equalsIgnoreCase("remote")) {
                    System.setProperty(
                        "webdriver.gecko.driver",
                        System.getProperty("webdriver.gecko.driver")
                    );
                }

                // default firefox options
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--allow-running-insecure-content");
                firefoxOptions.addArguments("--ignore-certificate-errors");

                // headless config
                if (headless.equalsIgnoreCase("true")) {
                    firefoxOptions.addArguments("--headless");
                }

                // appName config + firefox profile
                if (
                    appName.equalsIgnoreCase("mobile") &&
                    firefoxProfile.equalsIgnoreCase("default")
                ) {
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference(
                        "general.useragent.override",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0_1 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A402 Safari/604.1"
                    );

                    if (incognito.equalsIgnoreCase("true")) {
                        profile.setPreference("browser.privatebrowsing.autostart", true);
                    }
                    firefoxOptions.setProfile(profile);
                    driver = new FirefoxDriver(firefoxOptions);
                } else if (
                    appName.equalsIgnoreCase("mobile") &&
                    !firefoxProfile.equalsIgnoreCase("default")
                ) {
                    FirefoxProfile myprofile = new FirefoxProfile(
                        new File(firefoxProfile)
                    );
                    myprofile.setPreference(
                        "general.useragent.override",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0_1 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A402 Safari/604.1"
                    );

                    if (incognito.equalsIgnoreCase("true")) {
                        myprofile.setPreference(
                            "browser.privatebrowsing.autostart",
                            true
                        );
                    }
                    firefoxOptions.setProfile(myprofile);
                    driver = new FirefoxDriver(firefoxOptions);
                } else if (!firefoxProfile.equalsIgnoreCase("default")) {
                    FirefoxProfile myprofile = new FirefoxProfile(
                        new File(firefoxProfile)
                    );
                    if (incognito.equalsIgnoreCase("true")) {
                        myprofile.setPreference(
                            "browser.privatebrowsing.autostart",
                            true
                        );
                    }
                    firefoxOptions.setProfile(myprofile);
                    driver = new FirefoxDriver(firefoxOptions);
                } else {
                    driver = new FirefoxDriver();
                }
                break;
            case "ie":
                // ie setup
                if (runEnv.equalsIgnoreCase("local")) {
                    WebDriverManager.iedriver().setup();
                }
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                // edge setup
                if (runEnv.equalsIgnoreCase("local")) {
                    WebDriverManager.edgedriver().setup();
                }

                if (headless.equalsIgnoreCase("true")) {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");
                    driver = new org.openqa.selenium.edge.EdgeDriver(edgeOptions);
                } else {
                    driver = new org.openqa.selenium.edge.EdgeDriver();
                }
                break;
        }

        try {
            // http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp#implicit-waits
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {}
        return driver;
    }

    public void setCustomChromeOptionsIfAny() {
        String chromeOptions = System.getProperty(
            "chromeOptions",
            prop.getProperty("chromeOptions", "none")
        );
        if (!chromeOptions.equalsIgnoreCase("none")) {
            chromeOptionsArgs = Arrays.asList(chromeOptions.split(","));
        }
    }

    /**
     * Get Site Url from command line -DsiteUrl or runconfig file
     */
    public String getSiteBaseUrl() {
        return System.getProperty("siteUrl", prop.getProperty("siteUrl"));
    }

    /**
     * Set Environment value from properties or command line -Denv
     *
     * @throws IOException
     */
    public void setEnv() {
        if (System.getProperty("env") == null) {
            System.setProperty("env", prop.getProperty("env", "live"));
        }
    }

    /**
     * Get Environment value from properties or command line -Denv
     *
     * @throws IOException
     */
    public String getEnv() {
        String envValue = (String) System.getProperty(
            "env",
            prop.getProperty("env", "live")
        );
        return (envValue.trim());
    }

    /**
     * Get Region name
     *
     * @throws IOException
     */
    public String getRegionFromCurrentUrl() {
        String getCurrentURL = getDriver().getCurrentUrl();

        if (getCurrentURL.contains("farnell")) {
            region = "EUROPE";
        } else if (getCurrentURL.contains("element14")) {
            region = "APAC";
        } else if (getCurrentURL.contains("newark")) {
            region = "NEWARK";
        }

        return (region.trim());
    }

    /**
     * Get App name- mobile or web
     */
    public String getAppType() {
        return System.getProperty("appName", prop.getProperty("appName", "web"));
    }

    /**
     * Get browser name
     */
    public String getBrowserType() {
        return System.getProperty(
            "browserName",
            prop.getProperty("browserName", "chrome")
        );
    }

    /**
     * Get usertype name
     */
    public String getUserType() {
        String userType = (String) System.getProperty(
            "userType",
            prop.getProperty("userType", "guest")
        );
        return (userType.trim());
    }

    /**
     * Get Store name from current url
     *
     * @throws IOException
     */
    public String getStoreFromCurrentUrl() {
        String StoreValue = "";
        String environmentValue = getEnv();
        String getCurrentURL = getDriver().getCurrentUrl();
        String RegionName = getRegionFromCurrentUrl();

        if (environmentValue.equalsIgnoreCase("live")) {
            if (RegionName.equalsIgnoreCase("newark")) {
                if (
                    getCurrentURL.contains("mexico") || getCurrentURL.contains("canada")
                ) {
                    StoreValue =
                        (getCurrentURL.split("://")[1]).split(".newark")[0].trim();
                } else {
                    StoreValue = "us";
                }
            } else if (RegionName.equalsIgnoreCase("europe")) {
                StoreValue = (getCurrentURL.split("://")[1]).split(".farnell")[0].trim();
            } else if (RegionName.equalsIgnoreCase("apac")) {
                StoreValue =
                    (getCurrentURL.split("://")[1]).split(".element14")[0].trim();
            }
        } else {
            if (RegionName.equalsIgnoreCase("newark")) {
                if (
                    getCurrentURL.contains("mexico") || getCurrentURL.contains("canada")
                ) {
                    StoreValue = (getCurrentURL.split("-", 2)[1]).split("-")[0].trim();
                } else {
                    StoreValue = "us";
                }
            } else if (
                RegionName.equalsIgnoreCase("apac") ||
                (RegionName.equalsIgnoreCase("europe"))
            ) {
                StoreValue = (getCurrentURL.split("-", 2)[1]).split("-")[0].trim();
            }
        }

        // logger.info("Value of store obtained: " + StoreValue);
        store = StoreValue;
        return (StoreValue.trim());
    }

    /**
     * Close Driver: delete all cookies for new session, tearDownClass() will
     * handle closing the driver
     */
    public static void closeDriver() {
        if (null != driver) {
            driver.manage().deleteAllCookies();
            driver.close();
        }
    }

    /**
     * Quit Driver: tearDownClass() will handle closing the driver
     */
    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    /**
     * set width of the window
     */
    public void setWidth() {
        if (getAppType().equalsIgnoreCase("web")) {
            width =
                (String) System.getProperty("width", prop.getProperty("width", "1920"));
        } else if (getAppType().equalsIgnoreCase("mobile")) {
            width =
                (String) System.getProperty("width", prop.getProperty("width", "414"));
        }
        logger.info("Width of the Browser is set to: " + width);
    }

    /**
     * Get browser width
     *
     * @return
     */
    public int getWidth() {
        return (Integer.parseInt(width));
    }

    /**
     * set browser Height
     */
    public void setHeigth() {
        if (getAppType().equalsIgnoreCase("web")) {
            height =
                (String) System.getProperty("height", prop.getProperty("height", "1080"));
        } else if (getAppType().equalsIgnoreCase("mobile")) {
            height =
                (String) System.getProperty("height", prop.getProperty("height", "864"));
        }
        logger.info("Height of the Browser is set to: " + height);
    }

    /**
     * Get browser height
     *
     * @return
     */
    public int getHeight() {
        return (Integer.parseInt(height));
    }

    /**
     * @description: This will find locator value for string from any of object
     *               file
     */
    public WebElement getLocator(String locator) throws Exception {
        WebElement elementObj;

        if (locator.contains("@")) {
            String type = locator.split("[@]")[0];
            String access_name = locator.split("[@]")[1];
            By locatorValue = selectElementByType.getelementbytype(type, access_name);
            elementObj = driver.findElement(locatorValue);
        } else {
            String locatorValue = getLocatorString(locator);
            elementObj = driver.findElement(By.xpath(locatorValue));
        }

        return elementObj;
    }

    // Get locator string value from hashmaps
    public String getLocatorString(String key) throws Exception {
        Class<?> cls = null;
        String siteView = getAppType();
        String className = key.split("[.]")[0];
        String elementName = key.split("[.]")[1];
        if (siteView.equalsIgnoreCase("web")) {
            cls = Class.forName("Repository_WEB_Objs." + className + "_Objs");
        } else if (siteView.equalsIgnoreCase("mobile")) {
            cls = Class.forName("Repository_MOBILE_Objs." + className + "_Objs");
        }
        Method findLocator = cls.getMethod("findLocator", String.class);

        String value = (String) findLocator.invoke(
            cls.getDeclaredConstructor().newInstance(),
            elementName
        );
        return value;
    }

    /**
     * @description: This will find locator value for string from any of object
     *               file
     */
    public List<WebElement> getMutipleLocators(String locator) throws Exception {
        List<WebElement> elementObj;
        Class<?> cls = null;

        String siteView = getAppType();

        if (locator.contains("@")) {
            String type = locator.split("[@]")[0];
            String access_name = locator.split("[@]")[1];
            By locatorValue = selectElementByType.getelementbytype(type, access_name);
            elementObj = driver.findElements(locatorValue);
        } else {
            String className = locator.split("[.]")[0];
            String elementName = locator.split("[.]")[1];
            if (siteView.equalsIgnoreCase("web")) {
                cls = Class.forName("Repository_WEB_Objs." + className + "_Objs");
            } else if (siteView.equalsIgnoreCase("mobile")) {
                cls = Class.forName("Repository_MOBILE_Objs." + className + "_Objs");
            }
            Method findLocator = cls.getMethod("findLocator", String.class);

            String locatorValue = (String) findLocator.invoke(
                cls.getDeclaredConstructor().newInstance(),
                elementName
            );

            elementObj = driver.findElements(By.xpath(locatorValue));
        }

        return elementObj;
    }

    public Constants getConstantTypeObject() {
        if (region.equalsIgnoreCase("apac")) {
            return new ConstantsAPAC();
        } else if (region.equalsIgnoreCase("europe")) {
            return new ConstantsEUROPE();
        } else {
            return new ConstantsNEWARK();
        }
    }

    public WebElement findElement(By byElement) {
        WebElement element = null;
        try {
            element = driver.findElement(byElement);
        } catch (NoSuchElementException e) {
            logger.error("No such element is found");
        }
        return element;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String store) {
        baseURI = envConfig.getProperty(store);
        // Set the system variable with url value
        siteUrl = baseURI;
        System.setProperty("siteUrl", baseURI);
    }

    public void setStore(String siteUrl) {
        String StoreValue = "";
        String environmentValue = getEnv();

        if (environmentValue.equalsIgnoreCase("live")) {
            if (region.equalsIgnoreCase("newark")) {
                if (siteUrl.contains("mexico") || siteUrl.contains("canada")) {
                    StoreValue = (siteUrl.split("://")[1]).split(".newark")[0].trim();
                } else {
                    StoreValue = "us";
                }
            } else if (region.equalsIgnoreCase("europe")) {
                StoreValue = (siteUrl.split("://")[1]).split(".farnell")[0].trim();
            } else if (region.equalsIgnoreCase("apac")) {
                StoreValue = (siteUrl.split("://")[1]).split(".element14")[0].trim();
            }
        } else {
            if (region.equalsIgnoreCase("newark")) {
                if (siteUrl.contains("mexico") || siteUrl.contains("canada")) {
                    StoreValue = (siteUrl.split("-", 2)[1]).split("-")[0].trim();
                } else {
                    StoreValue = "us";
                }
            } else if (
                region.equalsIgnoreCase("apac") || (region.equalsIgnoreCase("europe"))
            ) {
                StoreValue = (siteUrl.split("-", 2)[1]).split("-")[0].trim();
            }
        }

        // logger.info("Value of store obtained: " + StoreValue);
        System.setProperty("store", StoreValue);
        store = StoreValue;
    }

    public String getStore() {
        return store;
    }

    public String setRegionName(String siteUrl) {
        if (siteUrl.contains("farnell")) {
            region = "EUROPE";
        } else if (siteUrl.contains("element14")) {
            region = "APAC";
        } else if (siteUrl.contains("newark")) {
            region = "NEWARK";
        }

        return (region.trim());
    }

    public String getRegionName() {
        return region;
    }

    public String getProxyHost() {
        return (String) System.getProperty("proxyHost");
    }

    public int getProxyPort() {
        return Integer.parseInt(System.getProperty("proxyPort"));
    }

    public String getCurrentUrl() {
        String getCurrentURL = getDriver().getCurrentUrl();
        return getCurrentURL;
    }

    public void initEnvironment() {
        setEnv();
        setRegionName(siteUrl);
        setStore(siteUrl);
    }
}