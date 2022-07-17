package StepDefinition.MOBILE;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.java.en.And;

import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class CheckoutSteps extends WebDriverConfig {

	private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
	private ContextStore context;
	String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
			+ "//";

	public CheckoutSteps(ContextStore context) {
		this.context = context;
	}

	@And("^.*fill mobile checkout your details in address section using given file \"([^\"]*)\"$")
	public void enter_your_details(String FileName) throws Exception {
		String path = FilePath + FileName;

		List<Map<String, String>> testData = ExcelUtil.getData(path, store);

		String firstName = testData.get(0).get("firstName");
		String lastName = testData.get(0).get("lastName");
		String emailAddress = testData.get(0).get("billEmail");

		logger.info("File values :" + firstName + "," + lastName + "," + emailAddress);

		actionMethods.enterText(firstName, "Checkout.firstName_textbox");
		context.scenario.log("First Name : " + firstName);
		actionMethods.enterText(lastName, "Checkout.lastName_textbox");
		context.scenario.log("Last Name : " + lastName);
		actionMethods.enterText(emailAddress, "Checkout.email_textbox");
		context.scenario.log("Email : " + emailAddress);
		ContextStore.ORDER_TRACKING_EMAIL = emailAddress;

		actionMethods.selectValueByIndex(3, "Checkout.primaryRole_dropdown");
		actionMethods.selectValueByIndex(3, "Checkout.primaryUse_dropdown");
	}

	@And("^.*fill mobile checkout Invoice or billing address manually using given file \"([^\"]*)\"$")
	public void enter_Invoice_address(String FileName) throws Exception {
		String path = FilePath + FileName;

		List<Map<String, String>> testData = ExcelUtil.getData(path, store);

		String firstName = testData.get(0).get("firstName");
		String lastName = testData.get(0).get("lastName");
		String companyName = testData.get(0).get("billCompanyName");
		String officeName = testData.get(0).get("billOfficeName");
		String officePhone = testData.get(0).get("billOfficePhone");
		String addressLine1 = testData.get(0).get("billAddressLine1");
		String addressLine2 = testData.get(0).get("billAddressLine2");
		String city = testData.get(0).get("billCity");
		String province = testData.get(0).get("billProvince");
		String zipCode = testData.get(0).get("billPostCode");
		String email = testData.get(0).get("accountsEmailBuisness");

		if (uiMethods.verifyElementExistence("Checkout.firstName_textbox")) {
			actionMethods.enterText(firstName, "Checkout.firstName_textbox");
			context.scenario.log("FirstName :" + firstName);
		}

		if (uiMethods.verifyElementExistence("Checkout.lastName_textbox")) {
			actionMethods.enterText(lastName, "Checkout.lastName_textbox");
			context.scenario.log("LastName :" + lastName);
		}

		if (uiMethods.verifyElementExistence("Checkout.companyName_textbox")) {
			actionMethods.enterText(companyName, "Checkout.companyName_textbox");
			context.scenario.log("CompanyName :" + companyName);
		}

		// for china condition
		if (officeName == null || officeName.equalsIgnoreCase("skip")) {
		} else {
			actionMethods.enterText(officeName, "Checkout.officeName_textbox");
			actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
		}
		actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
		context.scenario.log("AddressLine1 :" + addressLine1);
		actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
		context.scenario.log("AddressLine2 :" + addressLine2);
		actionMethods.enterText(city, "Checkout.townCity_textbox");
		context.scenario.log("City :" + city);

		if (province == null || province.equalsIgnoreCase("skip")) {
		} else {
			if (context.constants.getStateDropdownStores().contains(getStore())) {
				actionMethods.selectValueByText(province.trim(), "Checkout.state_dropdown");
			} else {
				actionMethods.enterText(province, "Checkout.countryProvince_textbox");
			}
			context.scenario.log("Province :" + province);
		}
		actionMethods.enterText(zipCode, "Checkout.zipCode_textbox");
		context.scenario.log("Zipcode :" + zipCode);
		ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

		if (uiMethods.verifyElementExistence("Checkout.email_textbox")) {
			actionMethods.enterText(email, "Checkout.email_textbox");
			context.scenario.log("Email :" + email);
		}
	}

	@And("^.*fill Credit Card Details in mobile using given file \"([^\"]*)\"$")
	public void enter_CreditCard_Details(String FileName) throws Exception {
		String path = FilePath + FileName;

		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

		String creditCardNum = testData.get(0).get("billCardNumber");
		String expiryMonth = testData.get(0).get("billCardExpiryMonth");
		String expiryYear = testData.get(0).get("billCardExpiryYear");
		String securityNum = testData.get(0).get("billCardSecurityNumber");
		String nameOnCard = testData.get(0).get("billNameOnCard");
		String cardHolderPhone = testData.get(0).get("billCardHolderPhone");

		if (!xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() && Arrays
				.asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(",")).contains(getStore())) {
			actionMethods.enterText(creditCardNum, "Checkout.creditCardNum_textbox");
		} else {
			driver.switchTo().frame("webtokenize-iframeframe-card-1");
			actionMethods.enterText(creditCardNum, "Checkout.creditCardNumWebtokenize_textbox");
			driver.switchTo().parentFrame();
		}
		context.scenario.log("CreditCardNum :" + creditCardNum);

		actionMethods.enterText(expiryMonth, "Checkout.expiryMonth_dropdown");
		context.scenario.log("expiryMonth :" + expiryMonth);
		actionMethods.enterText(expiryYear, "Checkout.expiryYear_dropdown");
		context.scenario.log("expiryYear :" + expiryYear);

		if (!xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() && Arrays
				.asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(",")).contains(getStore())) {
			actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
		} else {
			driver.switchTo().frame("webtokenize-iframe");
			actionMethods.enterText(securityNum, "Checkout.cvvWebtokenize_textbox");
			driver.switchTo().parentFrame();
		}
		context.scenario.log("securityNum :" + securityNum);

		actionMethods.enterText(nameOnCard, "Checkout.nameOnCard_textbox");
		context.scenario.log("nameOnCard :" + nameOnCard);
		actionMethods.enterText(cardHolderPhone, "Checkout.cardHolderPhone_textbox");
		context.scenario.log("cardHolderPhone :" + cardHolderPhone);
		Thread.sleep(3000);
	}

	@And(".*selects special instructions \"([^\"]*)\" from dropdown and enter instructions if any$")
	public void select_special_instructions(String value) throws Exception {
		if (!getRegionName().equalsIgnoreCase("newark")) {
			actionMethods.selectValueByValue(value, "Checkout.specialInstruction_dropdown");
			if (value.equalsIgnoreCase("other")) {
				actionMethods.enterText(this.context.constants.getSpecialInstructions(),
						"Checkout.specialDeliveryInstructions_textbox");
			}
		}
	}

	@And("^.*fill mobile checkout Invoice or billing address \"([^\"]*)\" specifically using given file \"([^\"]*)\"$")
	public HashMap<String, String> enter_invoice_or_delivery_address_specifically(String address, String FileName)
			throws Exception {
		int row = 0;
		String path = FilePath + FileName;
		HashMap<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> testData = ExcelUtil.getData(path, store);
		for (int i = 0; i < testData.size(); i++) {
			String addressType = testData.get(i).get(0);
			if (addressType.equalsIgnoreCase(address)) {

				row = i;
			}

		}

		String firstName = testData.get(row).get("firstName");
		String lastName = testData.get(row).get("lastName");
		String companyName = testData.get(row).get("billCompanyName");
		String officeName = testData.get(row).get("billOfficeName");
		String officePhone = testData.get(row).get("billOfficePhone");
		String addressLine1 = testData.get(row).get("billAddressLine1");
		String addressLine2 = testData.get(row).get("billAddressLine2");
		String city = testData.get(row).get("billCity");
		String province = testData.get(row).get("billProvince");
		String zipCode = testData.get(row).get("billPostCode");
		String email = testData.get(row).get("accountsEmailBuisness");
		String country = testData.get(row).get("billCountry");
		String attentionOf = testData.get(row).get("billAttention");

		map.put("firstName", firstName);
		map.put("lastName", lastName);
		map.put("companyName", companyName);
		map.put("officeName", officeName);
		map.put("officePhone", officePhone);
		map.put("addressLine1", addressLine1);
		map.put("addressLine2", addressLine2);
		map.put("city", city);
		map.put("province", province);
		map.put("zipCode", zipCode);
		map.put("email", email);
		map.put("country", country);
		map.put("Attention of", attentionOf);

		if (uiMethods.verifyElementExistence("Checkout.firstName_textbox")) {
			actionMethods.enterText(firstName, "Checkout.firstName_textbox");
			context.scenario.log("FirstName :" + firstName);
		}

		if (uiMethods.verifyElementExistence("Checkout.lastName_textbox")) {
			actionMethods.enterText(lastName, "Checkout.lastName_textbox");
			context.scenario.log("LastName :" + lastName);
		}

		if (uiMethods.verifyElementExistence("Checkout.companyName_textbox")) {
			actionMethods.enterText(companyName, "Checkout.companyName_textbox");
			context.scenario.log("CompanyName :" + companyName);
		}

		// for china condition
		if (officeName == null || officeName.equalsIgnoreCase("skip")) {
		} else {
			actionMethods.enterText(officeName, "Checkout.officeName_textbox");
			actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
		}
		actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
		context.scenario.log("AddressLine1 :" + addressLine1);
		actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
		context.scenario.log("AddressLine2 :" + addressLine2);
		actionMethods.enterText(city, "Checkout.townCity_textbox");
		context.scenario.log("City :" + city);

		if (province == null || province.equalsIgnoreCase("skip")) {
		} else {
			if (context.constants.getStateDropdownStores().contains(getStore())) {
				actionMethods.selectValueByText(province.trim(), "Checkout.state_dropdown");
			} else {
				actionMethods.enterText(province, "Checkout.countryProvince_textbox");
			}
			context.scenario.log("Province :" + province);
		}
		actionMethods.enterText(zipCode, "Checkout.zipCode_textbox");
		context.scenario.log("Zipcode :" + zipCode);
		ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;

		if (uiMethods.verifyElementExistence("Checkout.email_textbox")) {
			actionMethods.enterText(email, "Checkout.email_textbox");
			context.scenario.log("Email :" + email);
		}

		return map;
	}

	@And("^.*verify if address entered \"([^\"]*)\" from \"([^\"]*)\" file is displayed correct \"([^\"]*)\"$")
	public void verify_invoice_or_delivery_address_entered(String address,String fileName,String locator)
			throws Exception {
		List<WebElement> addressLines = getMutipleLocators(locator);
		HashMap<String, String> addressMap = enter_invoice_or_delivery_address_specifically(address,fileName);
		for (int i = 0; i < addressLines.size(); i++) {

			WebElement addressLine = getLocator("(" + addressLines + ")[" + i + "]");
			String addressLineText = addressLine.getText().trim();
			switch (i) {

			case 1:

				Assert.assertEquals(addressMap.get("addressLine1"), addressLineText);

			case 2:

				Assert.assertEquals(addressMap.get("companyName"), addressLineText);

			case 3:

				Assert.assertEquals("For the Attention Of:" + addressMap.get("Attention of"), addressLineText);

			case 4:

				String expectedAddress = addressMap.get("addressLine1") + "\r\n" + addressMap.get("addressLine2")
						+ "\r\n" + addressMap.get("city") + "," + addressMap.get("province") + "\r\n"
						+ addressMap.get("country") + "," + addressMap.get("zipCode") + "\r\n"
						+ addressMap.get("email");

				Assert.assertEquals(expectedAddress, addressLineText);
			}
		}
	}

	@And(".*enters the ordercode \"([^\"]*)\" in the cart page \"([^\"]*)\" from file \"([^\"]*)\".*$")
	public void enter_order_code_in_cartpage(String key, String fileName) throws Exception {

		String path = FilePath + fileName;
		List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
		String productToAdd = testData.get(0).get(key);
		if (productToAdd == null || productToAdd.equalsIgnoreCase("")) {
			assumeTrue("Data missing.NA for this store. product Type:" + key, false);
		} else {
			actionMethods.enterText(productToAdd, "firstOrderCode_textbox.firstOrderCode_textbox");
			this.context.scenario.log("Product Added :" + productToAdd);
		}
	}
}
