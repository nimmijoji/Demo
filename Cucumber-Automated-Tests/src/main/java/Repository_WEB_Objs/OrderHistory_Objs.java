package Repository_WEB_Objs;

import java.util.*;

public class OrderHistory_Objs {

    // Creation of HashMap
    private static final Map<String, String> OrderHistory;

    static {
        OrderHistory = new HashMap<String, String>();
        OrderHistory.put("recentOrders_text", "(//*[@class='section'])[2]/h2");
        OrderHistory.put(
            "firstPONumber_element",
            "//a[contains(@href,'NonAjaxOrderDetail')]"
        );
        OrderHistory.put("viewAllOrders_button", "//*[@class='btnPrimary btn']");
        OrderHistory.put("txt_OrderHistory&Tracking", "//*[@id='article']/h1");
        OrderHistory.put("MyOrderDetails_text", "//*[@class='smMarginTop']");
        OrderHistory.put("orderSearch_button", "//*[@id='searchMultiCal']");
        OrderHistory.put(
            "addAllToBasket_button",
            "//*[@class='actionBar']//a[@class='btn btnPrimary reOrderItems']"
        );
        OrderHistory.put("firstPONumber_text", "//*[@class='thisPoNumber']");

        OrderHistory.put("orderHistory_table", "//*[@class='orderStatus']");
        OrderHistory.put(
            "exportOrdersAsXLS_button",
            "//*[@class='orderHistButton btn btnTertiary']"
        );
        OrderHistory.put("orderDetailsReport_link", "//*[@id='csvExp']");
        OrderHistory.put("lineDetailsReport_link", "//*[@id='csvExpLine']");
        OrderHistory.put("downloadReport_popUp", "//*[@class='popBody']/div/h3");
        OrderHistory.put(
            "downloadReportPopUpClose_button",
            "//*[@id='closeLinkcsvExport']"
        );
    }

    public String findLocator(String elementName) {
        if (OrderHistory.containsKey(elementName)) {
            return (OrderHistory.get(elementName.trim()));
        }

        return null;
    }
}
