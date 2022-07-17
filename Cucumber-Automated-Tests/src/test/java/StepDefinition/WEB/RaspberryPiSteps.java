package StepDefinition.WEB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class RaspberryPiSteps extends WebDriverConfig {

	private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public RaspberryPiSteps(ContextStore context) {
        this.context = context;
    }
    
    @Then("^.*user verify URL update to \"([^\"]*)\"$")
    public void verifyURLUpdate() throws Exception{
    	actionMethods.waitForURLContains(2, "raspberry-pi/rpi4-modbp-");
    }
    
    @And("^.*open \"([^\"]*)\" by keyboardEvent$")
    	public void nav_by_KeyEvent(String locator) {
    	List<WebElement> elementsList = driver.findElements(By.xpath(locator));
    	for(WebElement ele :elementsList) {
    		String keyAct = Keys.chord(Keys.CONTROL,Keys.ENTER);
    		ele.sendKeys(keyAct);
    	}  	
    	
    }
   
	@And("^.*get URL of \"([^\"]*)\" as \"([^\"]*)\"$")
	public void getURL(String locator, String expected) {
    	List<WebElement> GBLinks = driver.findElements(By.xpath(locator));
		
		for (WebElement ele : GBLinks)  {
			String actualURL = ele.getAttribute("href");
			if(actualURL.contains(expected)) {
				System.out.println("URL verified");
			}
		
	}

    }
}


