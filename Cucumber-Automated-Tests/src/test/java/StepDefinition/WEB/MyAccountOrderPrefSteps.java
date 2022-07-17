package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class MyAccountOrderPrefSteps extends WebDriverConfig {

    private ContextStore context;

    public MyAccountOrderPrefSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*select Order Preferences in page$")
    public void select_order_Preferences() throws Exception {
        String cardNumber = null;
        String accountNumber = null;
        cardNumber = context.creditCardNum.substring(context.creditCardNum.length() - 4);
        if (getRegionName().equalsIgnoreCase("newark")) {
            accountNumber = context.tradeAccountNum;
            actionMethods.selectValueByText(
                "Card-" + cardNumber,
                "MyAccountOrderPref.paymentType_dropdown"
            );
            actionMethods.selectValueByIndex(
                2,
                "MyAccountOrderPref.prefDeliveryMethod_dropdown"
            );
            actionMethods.enterText(
                accountNumber,
                "MyAccountOrderPref.prefShipAccountNumber_textbox"
            );
        } else {
            actionMethods.selectValueByText(
                "Card-" + cardNumber,
                "MyAccountOrderPref.paymentType_dropdown"
            );
            actionMethods.selectValueByIndex(
                1,
                "MyAccountOrderPref.prefDeliveryMethod_dropdown"
            );
        }
        actionMethods.selectValueByText(
            "Premier",
            "MyAccountOrderPref.prefDeliveryAddress_dropdown"
        );
    }
}
