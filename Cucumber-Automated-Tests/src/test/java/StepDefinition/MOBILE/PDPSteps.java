package StepDefinition.MOBILE;

import static org.junit.Assert.assertEquals;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

public class PDPSteps extends WebDriverConfig {

    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public PDPSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*verify number of technical documents matches with the header$")
    public void verifyCountforTechnicalDocumentsSection() throws Exception {
        int countBody1 = getMutipleLocators("PDP.techDocSheetList_list").size();
        int countBody2 = getMutipleLocators("PDP.techDocCadInfoDoc_list").size();
        int totalCount = countBody1 + countBody2;

        String countHeader = actionMethods
            .getValue("PDP.techDocsCountInHeader_text")
            .replace("(", "")
            .replace(")", "");
        this.context.scenario.log("No. of technical documents in body:" + totalCount);
        assertEquals(
            "No. of Tech docs:" +
            totalCount +
            "failed to match with the count provided in the tech docs heading: " +
            countHeader,
            Integer.parseInt(countHeader),
            totalCount
        );
    }
}
