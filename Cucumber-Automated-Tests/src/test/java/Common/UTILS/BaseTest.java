package Common.UTILS;

import Common.HELPERS.APIBaseMethods;
import Common.HELPERS.ActionMethods;
import Common.HELPERS.UIVerificationMethods;

public interface BaseTest {
    WebDriverConfig driver = new WebDriverConfig();
    SelectElementByType selectElementByType = new SelectElementByType();
    TranslationConfig storeText = new TranslationConfig();
    ScreenshotUtil screenshotUtil = new ScreenshotUtil();
    ActionMethods actionMethods = new ActionMethods();
    APIBaseMethods apiBaseMethods = new APIBaseMethods();
    ConfigUtil configUtil = new ConfigUtil();
    ExcelUtilities ExcelUtil = new ExcelUtilities();
    UIVerificationMethods uiMethods = new UIVerificationMethods();
    JsonUtilities JsonUtil = new JsonUtilities();
    FileOperations fileOperations = new FileOperations();
}
