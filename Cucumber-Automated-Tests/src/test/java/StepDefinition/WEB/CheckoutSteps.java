package StepDefinition.WEB;

import static org.junit.Assume.assumeTrue;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import com.jayway.jsonpath.ReadContext;
import io.cucumber.java.en.And;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By;

public class CheckoutSteps extends WebDriverConfig {

    private ContextStore context;
    private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    public CheckoutSteps(ContextStore context) {
        this.context = context;
    }

    @And(".*selects Title for EU and APAC regions$")
    public void select_title(String title) throws Exception {
        if (!getRegionName().equalsIgnoreCase("NEWARK")) {
            actionMethods.selectValueByIndex(3, title);
        }
    }

    @And(".*would like to open a new Trade Account.*$")
    public void open_new_trade_Account() throws Exception {
        actionMethods.click("Checkout.wouldLikeToOpenNewTradeAcc_radio");
        if (store.equalsIgnoreCase("uk")) {
            actionMethods.click("Checkout.newTradeAcc_radio");
        }
    }

    @And(".*click on \"([^\"]*)\" option in section 1 payment method if presented.*$")
    public void select_checkout_section1_tile(String locator) throws Exception {
        if (
            this.context.constants.getCreditCardTileSection1DisabledStores()
                .contains(store)
        ) {
            this.context.scenario.log("NA for current store:" + store);
        } else {
            actionMethods.click(locator);
        }
    }

    @And(
        ".*select trade account radio button and click continue button in section 4 payment method.*$"
    )
    public void select_trade_account_section4() throws Exception {
        if (store.equalsIgnoreCase("cn")) {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "Checkout.tradeAccountChina_radio"
            );
            actionMethods.click("Checkout.tradeAccountChina_radio");
            if (uiMethods.isElementDisplayed("Checkout.invoiceTypeChina_radio")) {
                actionMethods.click("Checkout.invoiceTypeChina_radio");
                actionMethods.enterText(
                    this.context.constants.getInVoiceLocalName(),
                    "Checkout.invoiceLocalNameChina_radio"
                );
            }
            actionMethods.clickUsingJSExecutor(
                "Checkout.paymentDetailsSectionContinue_button"
            );
        } else if (store.equalsIgnoreCase("ph")) {
            this.context.scenario.log("Payment method section is N/A for this store");
        } else {
            actionMethods.waitForElementToAppear(
                this.context.constants.getShortWaitSeconds(),
                "Checkout.tradeAccount_radio"
            );
            actionMethods.click("Checkout.tradeAccount_radio");
            actionMethods.clickUsingJSExecutor(
                "Checkout.paymentDetailsSectionContinue_button"
            );
        }
    }

    @And("^.*fill Checkout Your details section form using given file \"([^\"]*)\"$")
    public void enter_your_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String firstName = testData.get(0).get("firstName");
        String lastName = testData.get(0).get("lastName");
        String emailAddress = testData.get(0).get("billEmail");

        logger.info("File values: " + firstName + "," + lastName + "," + emailAddress);

        if (
            !(getRegionName().equalsIgnoreCase("newark")) && !store.equalsIgnoreCase("ee")
        ) {
            context.scenario.log("User selects title for Guest user : Mr");
            actionMethods.selectValueByIndex(1, "Checkout.title_dropdown");
        }

        actionMethods.enterText(firstName, "Checkout.firstName_textbox");
        context.scenario.log("First Name : " + firstName);
        actionMethods.enterText(lastName, "Checkout.lastName_textbox");
        context.scenario.log("Last Name : " + lastName);
        actionMethods.enterText(emailAddress, "Checkout.email_textbox");
        context.scenario.log("Email : " + emailAddress);
        ContextStore.ORDER_TRACKING_EMAIL = emailAddress;
        // As part of STM4-1867, below fields are removed
        // actionMethods.selectValueByIndex(3, "Checkout.primaryRole_dropdown");
        // context.scenario.log("primaryRole dropdown value index 3");
        // actionMethods.selectValueByIndex(3, "Checkout.primaryUse_dropdown");
        // context.scenario.log("primary use dropdown value index 3");

    }

    @And("^.*fill Checkout Invoice address manually using given file \"([^\"]*)\"$")
    public void enter_Invoice_address(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String companyName = testData.get(0).get("billCompanyName");
        String officeName = testData.get(0).get("billOfficeName");
        String officePhone = testData.get(0).get("billOfficePhone");
        String addressLine1 = testData.get(0).get("billAddressLine1");
        String addressLine2 = testData.get(0).get("billAddressLine2");
        String city = testData.get(0).get("billCity");
        String province = testData.get(0).get("billProvince");
        String zipCode = testData.get(0).get("billPostCode");

        if (!this.context.currentUserType.equalsIgnoreCase("guest")) {
            actionMethods.enterText(companyName, "Checkout.companyName_textbox");
            context.scenario.log("CompanyName :" + companyName);
        }

        actionMethods.enterText(addressLine1, "Checkout.addressLaneOne_textbox");
        context.scenario.log("AddressLine1 :" + addressLine1);
        actionMethods.enterText(addressLine2, "Checkout.addressLaneTwo_textbox");
        context.scenario.log("AddressLine2 :" + addressLine2);
        actionMethods.enterText(city, "Checkout.townCity_textbox");
        context.scenario.log("City :" + city);

        if (officeName != null && !officeName.equalsIgnoreCase("skip")) {
            actionMethods.enterText(officeName, "Checkout.officeName_textbox");
            context.scenario.log("officeName :" + officeName);
            actionMethods.enterText(officePhone, "Checkout.officePhone_textbox");
            context.scenario.log("officePhone :" + officePhone);
        }

        if (province == null || province.equalsIgnoreCase("skip")) {} else {
            if (context.constants.getStateDropdownStores().contains(getStore())) {
                actionMethods.selectValueByValue(
                    province.trim(),
                    "Checkout.state_dropdown"
                );
            } else {
                actionMethods.enterText(province, "Checkout.countryProvince_textbox");
            }
            context.scenario.log("Province :" + province);
        }
        actionMethods.enterText(zipCode, "Checkout.zipCode_textbox");
        context.scenario.log("Zipcode :" + zipCode);
        ContextStore.ORDER_TRACKING_ZIPCODE = zipCode;
    }

    @And("^.*fill Credit Card Details using given file \"([^\"]*)\"$")
    public void enter_CreditCard_Details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

        String creditCardNum = testData.get(0).get("billCardNumber");
        String expiryMonth = testData.get(0).get("billCardExpiryMonth");
        String expiryYear = testData.get(0).get("billCardExpiryYear");
        String securityNum = testData.get(0).get("billCardSecurityNumber");
        String nameOnCard = testData.get(0).get("billNameOnCard");
        String cardHolderPhone = testData.get(0).get("billCardHolderPhone");
        String expirationDate = testData.get(0).get("expirationDate");

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(creditCardNum, "Checkout.creditCardNum_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-card-1");
            actionMethods.enterText(
                creditCardNum,
                "Checkout.creditCardNumWebtokenize_textbox"
            );
            driver.switchTo().parentFrame();
        }
        context.scenario.log("CreditCardNum :" + creditCardNum);
        if (uiMethods.isElementDisplayed("Checkout.expirationDate_textbox")) {
            actionMethods.enterText(expirationDate, "Checkout.expirationDate_textbox");
            context.scenario.log("expirationDate :" + expirationDate);
        } else {
            actionMethods.enterText(expiryMonth, "Checkout.expiryMonth_dropdown");
            context.scenario.log("expiryMonth :" + expiryMonth);
            actionMethods.enterText(expiryYear, "Checkout.expiryYear_dropdown");
            context.scenario.log("expiryYear :" + expiryYear);
        }

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-cvv-new");
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

    @And(
        "^.*fill Additional Information Details for New Trade Account using given file \"([^\"]*)\"$"
    )
    public void enter_additional_information_Details(String FileName) throws Exception {
        if (region.equalsIgnoreCase("europe") || store.equalsIgnoreCase("hk")) {
            String path = FilePath + FileName;

            List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());

            String monthlySpend = testData.get(0).get("monthlySpend");
            String fullCompanyNameBuisness = testData
                .get(0)
                .get("fullCompanyNameBuisness");
            String legalEntity = testData.get(0).get("legalEntity");
            String accountsEmailBuisness = testData.get(0).get("accountsEmailBuisness");
            String companyRegistrationBusiness = testData
                .get(0)
                .get("companyRegistrationBusiness");
            String formVatNumberBuisness = testData.get(0).get("formVatNumberBuisness");
            String landlinenumber = testData.get(0).get("landLineNumber");
            actionMethods.enterText(monthlySpend, "Checkout.averageMonthlySpend_textbox");
            context.scenario.log(
                "Anticipated average monthly spend in GBP(given currency) :" +
                monthlySpend
            );
            actionMethods.enterText(
                fullCompanyNameBuisness,
                "Checkout.companyTradingName_textbox"
            );
            context.scenario.log("Full Company Trading Name :" + fullCompanyNameBuisness);
            actionMethods.selectValueByValue(
                legalEntity,
                "Checkout.legalTradingEntry_list"
            );
            context.scenario.log("Legal Trading Entity :" + legalEntity);
            actionMethods.enterText(
                accountsEmailBuisness,
                "Checkout.accountPayableEmail_textbox"
            );
            context.scenario.log(
                "Finance/Accounts Payable Email Address :" + accountsEmailBuisness
            );
            actionMethods.enterText(landlinenumber, "Checkout.landLineNumber_textbox");
            context.scenario.log("Landline number:" + landlinenumber);

            if (
                companyRegistrationBusiness != null &&
                !companyRegistrationBusiness.equalsIgnoreCase("skip")
            ) {
                actionMethods.enterText(
                    companyRegistrationBusiness,
                    "Checkout.companyRegistrationBusiness_textbox"
                );
                context.scenario.log(
                    "company Registration Business SIRET:" + companyRegistrationBusiness
                );
            }
            if (
                formVatNumberBuisness != null &&
                !formVatNumberBuisness.equalsIgnoreCase("skip")
            ) {
                actionMethods.enterText(
                    formVatNumberBuisness,
                    "Checkout.formVatNumberBuisness_textbox"
                );
                context.scenario.log("form Vat Number Buisness:" + formVatNumberBuisness);
            }
            actionMethods.clickUsingJSExecutor(
                "Checkout.additionalInformationContinue_button"
            );
            Thread.sleep(4000);
            context.scenario.log(
                "I verify Additional Information Details section edit button element" +
                uiMethods.isElementDisplayed(
                    "Checkout.editAdditionalInformation_button"
                ) +
                "is present on page"
            );
        } else {
            this.context.scenario.log(
                    "Additional Details Section is N/A for Newark and apac region"
                );
        }
    }

    @And(
        "^.*fill Checkout Invoice address by entering four characters in auto Search textbox.* \"([^\"]*)\"$"
    )
    public void invoice_address_using_autosearch(String textToSearch) throws Exception {
        // address vertification service has unlimited calls for specific stores,
        // if current store part of the list, go ahead else enter address
        // manually

        if (
            !this.getEnv().equalsIgnoreCase("pp") &&
            this.context.constants.getAddressVerificationStores().contains(getStore())
        ) {
            actionMethods.enterText(
                textToSearch,
                "Checkout.billingAddressSearch_textbox"
            );
            Thread.sleep(7000);
            actionMethods.click("Checkout.firstBillingAddressSearch_link");
            Thread.sleep(3000);
            actionMethods.enterText("ABC Pvt Ltd", "Checkout.companyName_textbox");
        } else {
            if (
                xcomregConfig.getProperty("AV_ENABLED_N").isEmpty() ||
                !Arrays
                    .asList(xcomregConfig.getProperty("AV_ENABLED_N").split(","))
                    .contains(getStore())
            ) {
                actionMethods.click("Checkout.addAddressManually_link");
            }
            enter_Invoice_address("OrderInformation.xlsx");
        }
    }

    @And(
        "^.*enter Trade account Account number and CID details using given file \"([^\"]*)\"$"
    )
    public void enter_account_details(String FileName) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String tradeAccountNumber = testData.get(0).get("billAccountNumber");
        String CIDNumber = testData.get(0).get("billCustomerID");
        if (region.equalsIgnoreCase("newark")) {
            actionMethods.enterText(tradeAccountNumber, "Checkout.tradeAccno_textbox");
        } else {
            actionMethods.enterText(tradeAccountNumber, "Checkout.tradeAccno_textbox");
            actionMethods.enterText(CIDNumber, "Checkout.cid_textbox");
        }
        context.scenario.log("trade account number: " + tradeAccountNumber);
        context.scenario.log("Customer ID (CID): " + CIDNumber);
    }

    @And(".*enter random PO Number on Order Review section$")
    public void enter_PO_Number() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getLongWaitSeconds(),
            "Checkout.poNumber_textbox"
        );
        String poNumber_random = actionMethods.generateRandomNumberString(
            this.context.constants.getOrderRefString()
        );
        logger.info("Random PO number is: " + poNumber_random);
        ContextStore.ORDER_TRACKING_PO_NUM = poNumber_random.toUpperCase();

        actionMethods.enterText(poNumber_random, "Checkout.poNumber_textbox");
        context.scenario.log("PONumber_random :" + poNumber_random.toUpperCase());
    }

    @And("^.*checks terms and conditions checkbox and click on Submit Order button$")
    public void check_TandC_and_click_on_SubmitOrder_button() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            if (!(getRegionName().equalsIgnoreCase("NEWARK"))) {
                actionMethods.click("Checkout.termsAndConditions_checkbox");
            }
            Thread.sleep(5000);
            actionMethods.clickUsingJSExecutor("Checkout.submitOrder_button");
        }
    }

    @And("^.*gets Order confirmation Number$")
    public void get_order_confirmation_number() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            String orderConfirmationNo = null;
            orderConfirmationNo =
                actionMethods.getValue("Checkout.orbitOrderConfirmationText_text");
            String[] orderConfNumberSplit = orderConfirmationNo.split("\\s+");
            int length = orderConfNumberSplit.length;
            orderConfirmationNo = orderConfNumberSplit[length - 1];
            context.scenario.log("Order confirmation No: " + orderConfirmationNo);
            if (orderConfirmationNo.contains("STUB_")) {
                ContextStore.STUB_ENABLED = true;
            }
            ContextStore.ORDER_TRACKING_ORDER_CONFIRMATION_NUM = orderConfirmationNo;
        }
    }

    @And(
        "^.*verify order confirmation message is present on page and display.*in report$"
    )
    public void verify_order_confirmation_display_in_report() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            actionMethods.waitForElementToAppear(
                this.context.constants.getLongWaitSeconds(),
                "Checkout.orderConfirmationTitle_text"
            );
            Assert.assertTrue(
                uiMethods.isElementDisplayed("Checkout.orderConfirmationTitle_text")
            );
            String value = actionMethods.getValue("Checkout.orderConfirmationTitle_text");
            Assert.assertFalse("Text is missing", value.isEmpty());
            this.context.scenario.log(
                    "The value of the element verified on page: " + value
                );
        }
    }

    @And("I continue only if guest checkout feature is enabled")
    public void check_Guest_checkout_feature_flag() {
        if (
            Arrays
                .asList(
                    xcomregConfig.getProperty("ENABLE_GUEST_CHECKOUT_FALSE").split(",")
                )
                .contains(getStore())
        ) {
            assumeTrue("NA for this store:" + store, false);
        }
    }

    @And("^.*check terms and conditions checkbox and click on Paypal button$")
    public void check_TandC_and_click_on_Paypal_button() throws Exception {
        if (getEnv().equalsIgnoreCase("live")) {
            this.context.scenario.log("NA for LIVE sites");
        } else {
            if (!(getRegionName().equalsIgnoreCase("EUROPE"))) {
                this.context.scenario.log("Paypal NA for APAC and NEWARK Regions");
            }
            actionMethods.click("Checkout.termsAndConditions_checkbox");
            actionMethods.click("Checkout.payPal_button");
        }
    }

    @And("^.*enter cvv number \"([^\"]*)\"$")
    public void enter_cvv_number(String securityNum) throws Exception {
        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-cvv-express");
            actionMethods.enterText(securityNum, "Checkout.cvvWebtokenize_textbox");
            driver.switchTo().parentFrame();
        }
        context.scenario.log("securityNum :" + securityNum);
    }

    @And("^I check if the order is sent$")
    public void check_if_order_send() throws Exception {
        if (uiMethods.isElementDisplayed("Checkout.shareOrderUnavailable_message")) {
            assumeTrue("The Order is still processing message is dispalyed!!", false);
            context.scenario.log("The order is still processing message is displayed!");
        }
    }

    @And(
        "^.*select no.* \"([^\"]*)\" radio button as Shipping method option.* and display its name in report$"
    )
    public void select_shipping_option(String optionNum) throws Exception {
        String deliveryCharge_xpath =
            actionMethods.getLocatorString("Checkout.partialDeliveryCharge_text") +
            "[" +
            optionNum +
            "]";
        actionMethods.getDriver().findElement(By.xpath(deliveryCharge_xpath)).click();
        String deliveryCharge = actionMethods
            .getDriver()
            .findElement(By.xpath(deliveryCharge_xpath))
            .getText();
        String deliveryMethod_xpath =
            actionMethods.getLocatorString("Checkout.partialDeliveryOption_text") +
            "[" +
            optionNum +
            "]";
        String deliveryMethod = actionMethods
            .getDriver()
            .findElement(By.xpath(deliveryMethod_xpath))
            .getText();
        this.context.scenario.log("The Delivery Method title is : " + deliveryMethod);
        this.context.scenario.log(
                "The Delivery/Shipping charge for selected delivery method is : " +
                deliveryCharge
            );
        ContextStore.shippingCharge = deliveryCharge;
    }

    @And("^.* verify shipping charge is applied in Order Total$")
    public void verify_shiping_charge_applied() throws Exception {
        String actualCharge = actionMethods
            .getValue("Checkout.shippingChargePrice")
            .trim();
        this.context.scenario.log(
                "The applied Delivery/Shipping charge from order total is : " +
                actualCharge
            );
        Assert.assertEquals(actualCharge, ContextStore.shippingCharge);
    }

    @And("^.*enter \"([^\"]*)\" credit card details from json \"([^\"]*)\"$")
    public void enter_CreditCard_Details_json(String cardType, String FileName)
        throws Exception {
        String path = FilePath + FileName;
        ReadContext rx = JsonUtil.getJsonDocument(path);

        String creditCardNum = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".cardnumber"
        );
        String expiryMonth = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".expirymonth"
        );
        String expiryYear = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".expiryyear"
        );
        String securityNum = JsonUtil.getKeyValueFromCommonJson(rx, cardType + ".cv2");
        String nameOnCard = JsonUtil.getKeyValueFromCommonJson(rx, cardType + ".name");
        String cardHolderPhone = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + ".phonenumber"
        );
        String expirationDate = expiryMonth + "/" + expiryYear;

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(creditCardNum, "Checkout.creditCardNum_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-card-1");
            actionMethods.enterText(
                creditCardNum,
                "Checkout.creditCardNumWebtokenize_textbox"
            );
            driver.switchTo().parentFrame();
        }
        context.scenario.log("CreditCardNum :" + creditCardNum);
        if (uiMethods.isElementDisplayed("Checkout.expirationDate_textbox")) {
            actionMethods.enterText(expirationDate, "Checkout.expirationDate_textbox");
            context.scenario.log("expirationDate :" + expirationDate);
        } else {
            actionMethods.enterText(expiryMonth, "Checkout.expiryMonth_dropdown");
            context.scenario.log("expiryMonth :" + expiryMonth);
            actionMethods.enterText(expiryYear, "Checkout.expiryYear_dropdown");
            context.scenario.log("expiryYear :" + expiryYear);
        }

        if (
            !xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").isEmpty() &&
            Arrays
                .asList(xcomregConfig.getProperty("SECURE_IFRAME_ENABLED_N").split(","))
                .contains(getStore())
        ) {
            actionMethods.enterText(securityNum, "Checkout.cvv_textbox");
        } else {
            driver.switchTo().frame("webtokenize-iframeframe-cvv-new");
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

    /*method for unionpay taking details from json credit card file */
    @And(
        "^.*enter the \"([^\"]*)\" card \"([^\"]*)\" in textbox \"([^\"]*)\" from json \"([^\"]*)\"$"
    )
    public void enter_UnionPayCreditCard_Details_json(
        String cardType,
        String value,
        String locator,
        String FileName
    ) throws Exception {
        String path = FilePath + FileName;
        ReadContext rx = JsonUtil.getJsonDocument(path);

        String outputValue = JsonUtil.getKeyValueFromCommonJson(
            rx,
            cardType + "." + value
        );

        actionMethods.enterText(outputValue, locator);
    }

    /**
     * Method to submit details on 3D auth screen, it is somtimes asked for visa credit cards.
     * @param cardType
     * @param FileName
     * @throws Exception
     */
    @And(
        "^.*submit details on 3D Auth screen to verify \"([^\"]*)\" credit card if asked$"
    )
    public void enter_password_auth_screen(String cardType) throws Exception {
        if (cardType.equalsIgnoreCase("visa")) {
            actionMethods.waitForURLContains(
                this.context.constants.getMediumWaitSeconds(),
                "ThreedAuthView"
            );
            if (driver.getCurrentUrl().contains("ThreedAuthView")) {
                try {
                    driver.switchTo().frame("cardframe");
                    actionMethods.enterText(
                        this.context.constants.getThreedAuthPassword(),
                        "ThreedAuthView.password_textbox"
                    );
                    actionMethods.click("ThreedAuthView.submit_button");
                } catch (Exception e) {}
            } else {
                this.context.scenario.log("3d auth screen is not displayed");
            }
        } else {
            this.context.scenario.log("NA for card type - " + cardType);
        }
    }

    @And("I select credit card or paypal Payment method in section one for DE store")
    public void select_payment_method() throws Exception {
        String path = FilePath + "OrderInformation.xlsx";

        List<Map<String, String>> testData = ExcelUtil.getData(path, store);

        String tradeAccountNumber = testData.get(0).get("billAccountNumber");
        String CIDNumber = testData.get(0).get("billCustomerID");

        if (store.equalsIgnoreCase("de")) {
            actionMethods.click("Checkout.existingTradeAcc_radio");
            actionMethods.enterText(tradeAccountNumber, "Checkout.tradeAccno_textbox");
            actionMethods.enterText(CIDNumber, "Checkout.cid_textbox");
        } else {
            actionMethods.click("Checkout.creditcardPaypal_radio");
        }
    }
}
