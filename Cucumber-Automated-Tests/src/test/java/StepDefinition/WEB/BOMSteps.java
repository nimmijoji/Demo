package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

public class BOMSteps extends WebDriverConfig {

    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    private ContextStore context;

    public BOMSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*delete if any BOM file present on page.* \"([^\"]*)\"$")
    public void deleteIfFileExist(String locator) throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            locator
        );
        if (uiMethods.isElementDisplayed(locator)) {
            actionMethods.click(locator);
            actionMethods.click("BOMUploadPage.deleteYes_button");
        } else this.context.scenario.log("BOM file is not present ");
    }

    // By default, this will look for a file on the file system, at the location provided.
    @And("^.*upload the file \"([^\"]*)\" into the element \"([^\"]*)\"$")
    public void fileToUpload(String FileName, String loactor) throws Exception {
        String path = FilePath + FileName;
        actionMethods.enterText(path, loactor);
    }

    @And("^.*rename the existing BOM file$")
    public void renameBOMFile() throws Exception {
        String UpdatedName = actionMethods.generateRandomNumberString("BOM_");
        context.scenario.log("Updated Name : " + UpdatedName);
        actionMethods.click("BOMUploadPage.edit_icon");
        Thread.sleep(1000);
        actionMethods.clearText("BOMUploadPage.editFileName_text");
        actionMethods.enterText(UpdatedName, "BOMUploadPage.editFileName_text");
    }

    @And("^.*update quote name if pop-up displayed$")
    public void renameQuote() throws Exception {
        String UpdatedQuoteName = actionMethods.generateRandomNumberString("BOM_");
        context.scenario.log("Updated Quote Name : " + UpdatedQuoteName);
        actionMethods.waitForElementToAppear(
            this.context.constants.getMediumWaitSeconds(),
            "BOMUploadPage.editQuotename_text"
        );
        if (uiMethods.isElementDisplayed("BOMUploadPage.editQuotename_text")) {
            actionMethods.click("BOMUploadPage.editQuoteName_icon");
            Thread.sleep(1000);
            actionMethods.clearText("BOMUploadPage.editQuoteName_text");
            actionMethods.enterText(UpdatedQuoteName, "BOMUploadPage.editQuoteName_text");
            actionMethods.click("BOMUploadPage.saveQuoteName_button");
        }
    }

    @And("^.*enter an Order Code and Quantity and click Add a part button")
    public void AddProductToBOM() throws Exception {
        actionMethods.enterText(
            this.context.constants.getOrderCode(),
            "BOMUploadPage.ordercode_text"
        );
        actionMethods.enterText("1", "BOMUploadPage.quantity_text");
        Thread.sleep(10000);
        actionMethods.click("BOMUploadPage.addPart_button");
    }
}
