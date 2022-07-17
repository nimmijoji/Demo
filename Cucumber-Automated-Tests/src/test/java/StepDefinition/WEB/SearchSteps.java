package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public SearchSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^.*verify the \"([^\"]*)\" listed for \"([^\"]*)\" has atleast \"([^\"]*)\" rows of data$"
    )
    public void verify_attributes(
        String titleOfCategory,
        String lookaheadList,
        int expectedCount
    ) throws Exception {
        // Title could be- Attributes, Manufactures, Categories and Products
        Assert.assertTrue(uiMethods.isElementDisplayed(titleOfCategory));
        this.context.scenario.log(
                "Text present in lookahead: " +
                actionMethods.getValue(titleOfCategory).trim()
            );
        List<WebElement> list_attributes = getMutipleLocators(lookaheadList);
        Assert.assertTrue(
            "Count of Search look ahead is not >= " + expectedCount,
            ((list_attributes.size()) >= expectedCount)
        );
    }

    @And("^.*verify searchlookahead header and data row count$")
    public void verify_attributes() throws Exception {
        // Title could be- Attributes, Manufactures, Categories and Products
        int expCOUNT = this.context.constants.getSearchLookaheadHeadingCount();
        List<WebElement> actSLHeaders = getMutipleLocators(
            "Search.searchLookAheadHeaders_list"
        );
        actSLHeaders.forEach(e -> {
            this.context.scenario.log(e.getText() + ", ");
        });
        Assert.assertEquals(
            "Search lookahead header count mismatch",
            expCOUNT,
            actSLHeaders.size()
        );
        for (int i = 1; i < expCOUNT; i++) {
            Assert.assertTrue(
                "Rows missing under lookahead header #" + i,
                driver
                    .findElements(
                        By.xpath(
                            "//*[@id='lookAheadResponse']/div/ul[" +
                            i +
                            "]/table/tbody/tr"
                        )
                    )
                    .size() >
                0
            );
        }
        Assert.assertTrue(
            "No Products displayed in searchlookahead",
            uiMethods.verifyElementExistence("Search.products_list")
        );
    }

    @And("^.*verify searchlookahead data matching for manufacturer$")
    public void verify_searchlookaheadData() throws Exception {
        List<WebElement> actSLHeaders = getMutipleLocators(
            "Search.searchLookAheadHeaders_list"
        );
        actSLHeaders.forEach(e -> {
            if (e.getText().equalsIgnoreCase("MANUFACTURERS")) {
                this.context.scenario.log(e.getText() + ", ");
                try {
                    List<WebElement> manufacturersList = getMutipleLocators(
                        "Search.manufacturers_list"
                    );
                    int countofManufacturers = manufacturersList.size();
                    for (int i = 0; i < countofManufacturers; i++) {
                        this.context.scenario.log(manufacturersList.get(i).getText());
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        Assert.assertTrue(
            "No Products displayed in searchlookahead",
            uiMethods.verifyElementExistence("Search.manufacturers_list")
        );
    }

    @And(
        "^.*User Enters SearchTerm from \"([^\"]*)\" and collects the ProductCount Results in Excel$"
    )
    public void ExcelOutput(String InputFileName) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYMMddHHmm");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        sdf1.format(timestamp);
        String s = sdf1.format(timestamp) + getStore().toUpperCase() + InputFileName;
        String OutputFileName = s;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(s);
        String OutputFilePath =
            System.getProperty("user.dir") + "//target//test-output//";
        String outputpath = OutputFilePath + OutputFileName;
        String path = FilePath + InputFileName;
        Map<String, String> ProductCount = new HashMap<String, String>();
        int count = ExcelUtil.getWorkbook(path).getSheet(getStore()).getLastRowNum();
        int i;
        int rowid = 0;

        for (i = 0; i < count; i++) {
            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
            String searchterm = testData.get(i).get("SearchTerm");
            String act_Value = "";
            if (searchterm == null || searchterm.equalsIgnoreCase("")) {
                assumeTrue(
                    "Data missing.NA for this store. product Type:" + "SearchTerm",
                    false
                );
            } else {
                context.scenario.log(searchterm);
                actionMethods.clearText("Header.searchBox_textbox");
                actionMethods.enterText(searchterm, "Header.searchBox_textbox");
                actionMethods.click("Header.searchIcon_button");
                Thread.sleep(2000);

                if (
                    actionMethods.uiMethods.isElementPresent("Search.productCount_text")
                ) {
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    act_Value =
                        actionMethods
                            .getValue("Search.productCount_text")
                            .replaceAll("[,'. ]", "");
                } else if (
                    actionMethods.uiMethods.isElementPresent(
                        "CategoryPage.showAllProducts_button"
                    )
                ) {
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    actionMethods.scrollDownPage(300);
                    uiMethods.scrollToAnyWhere("CategoryPage.showAllProducts_button");
                    actionMethods.click("CategoryPage.showAllProducts_button");
                    Thread.sleep(2000);
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    act_Value =
                        actionMethods
                            .getValue("Search.productCount_text")
                            .replaceAll("[,'. ]", "");
                } else if (
                    actionMethods.uiMethods.isElementPresent(
                        "PDP.legislationEnvironmentalTableLabels_element"
                    )
                ) {
                    act_Value = "1";
                    context.scenario.log("Only 1 Product is Found");
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                    int tableSize = getMutipleLocators(
                        "PDP.legislationEnvironmentalTableLabels_element"
                    )
                        .size();
                    Assert.assertTrue("Legislation Section has headers", tableSize > 0);
                } else if (
                    actionMethods.uiMethods.isElementPresent(
                        "ManufacturePage.manufacturerPageTitle"
                    )
                ) {
                    act_Value = "Manufacturer";
                    context.scenario.log("Only 1 Product is Found");
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                } else {
                    act_Value = "0";
                    context.scenario.log("No Product Found");
                    context.scenario.attach(
                        ScreenshotUtil.getByteScreenshot(),
                        "image/png",
                        "test"
                    );
                }
                Thread.sleep(2000);
                ProductCount.put(searchterm, act_Value);
            }

            XSSFRow row;
            row = spreadsheet.createRow(rowid++);
            row.createCell(0).setCellValue((String) searchterm);
            int cellid = 1;
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String) act_Value);

            FileOutputStream out = new FileOutputStream(new File(outputpath));
            workbook.write(out);
            out.close();
        }
    }

    @Given(
        "^User enters \"([^\"]*)\".* from file \"([^\"]*)\" in searchbox and I verify data matching for manufacturer in Searchahead$"
    )
    public void enter_Searchcode_from_file(String key, String filename) throws Exception {
        String path = FilePath + filename;
        int count = ExcelUtil.getWorkbook(path).getSheet(getStore()).getLastRowNum();
        int i;
        for (i = 0; i < count; i++) {
            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
            String searchterm1 = testData.get(i).get(key);
            String searchterm2 = testData.get(i).get("secondCharacter");
            String searchterm = searchterm1 + searchterm2;
            if (searchterm == null || searchterm.equalsIgnoreCase("")) {
                assumeTrue("Data missing.NA for this store. product Type:" + key, false);
            } else {
                actionMethods.clearText("Header.searchBox_textbox");
                actionMethods.enterText(searchterm1, "Header.searchBox_textbox");
                Thread.sleep(2000);
                actionMethods.enterText(searchterm2, "Header.searchBox_textbox");
                Thread.sleep(4000);
                this.context.scenario.log("searchterm :" + searchterm);
                context.scenario.attach(
                    ScreenshotUtil.getByteScreenshot(),
                    "image/png",
                    "test"
                );
                List<WebElement> actSLHeaders = getMutipleLocators(
                    "Search.searchLookAheadHeaders_list"
                );
                actSLHeaders.forEach(e -> {
                    if (e.getText().equalsIgnoreCase("MANUFACTURERS")) {
                        // this.context.scenario.log("Manufacturers for SearchTerm " + searchterm);
                        try {
                            List<WebElement> manufacturersList = getMutipleLocators(
                                "Search.manufacturers_list"
                            );
                            int countofManufacturers = manufacturersList.size();
                            this.context.scenario.log(
                                    "Manufacturers for SearchTerm " +
                                    searchterm +
                                    " is " +
                                    countofManufacturers
                                );
                            for (int x = 0; x < countofManufacturers; x++) {
                                this.context.scenario.log(
                                        manufacturersList.get(x).getText()
                                    );
                                Thread.sleep(4000);
                            }
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Given(
        "^User enters \"([^\"]*)\".* from file \"([^\"]*)\" in searchbox and I verify Searchahead Suggestions$"
    )
    public void Search_Suggestions(String key, String filename) throws Exception {
        String FilePath1 =
            System.getProperty("user.dir") +
            "//src//test//resources//TestData//" +
            getEnv().toUpperCase() +
            "//SearchKeywords" +
            "//";
        String path = FilePath1 + filename;
        int count = ExcelUtil.getWorkbook(path).getSheet(getStore()).getLastRowNum();
        int i;
        for (i = 0; i < count; i++) {
            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
            String searchterm = testData.get(i).get(key);
            if (searchterm == null || searchterm.equalsIgnoreCase("")) {
                assumeTrue("Data missing.NA for this store. product Type:" + key, false);
            } else {
                this.context.scenario.log("searchterm :" + searchterm);
                actionMethods.clearText("Header.searchBox_textbox");
                actionMethods.enterText(searchterm, "Header.searchBox_textbox");
                Thread.sleep(2000);
                context.scenario.attach(
                    ScreenshotUtil.getByteScreenshot(),
                    "image/png",
                    "test"
                );
                List<WebElement> SuggestionsList = getMutipleLocators(
                    "Search.response_search"
                );
                this.context.scenario.log(SuggestionsList.get(0).getText());
                Thread.sleep(2000);
            }
        }
    }
}
