package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class BOMUploadPage_Objs {

    // Creation of HashMap
    private static final Map<String, String> BOMUploadPage;

    static {
        BOMUploadPage = new HashMap<String, String>();

        BOMUploadPage.put("bomUpload_element", "//div[@class='section BOMHome']");
        BOMUploadPage.put("delete_icon", "//*[@class='btn delBom']");
        BOMUploadPage.put("uploadFile_text", "//input[@id='upfile']");
        BOMUploadPage.put("selectAFile_text", "//*[@class='custom-file-upload']");
        BOMUploadPage.put("dateCreated_text", "//*[@id='datecreated1']");
        BOMUploadPage.put(
            "lastModified_text",
            "//*[@class='dtModified column2span']/strong"
        );
        BOMUploadPage.put("verfiedLines_text", "//*[@class='verfiedlines column2span']");
        BOMUploadPage.put("view_button", "//*[@id='viewBOMURL']");
        BOMUploadPage.put("deleteYes_button", "//*[@id='deleteYesBOMURL']");
        BOMUploadPage.put("deleteCancel_button", "//*[@id='delCancel']");
        BOMUploadPage.put("edit_icon", "(//*[@class='editFileNamePath'])[1]");
        BOMUploadPage.put("editFileName_text", "//*[@id='editFileNameText']");
        BOMUploadPage.put("allSelect_checkbox", "//*[@for='selectMasterCheckB']");

        //Add Product
        BOMUploadPage.put("addPart_link", "//*[@class='bomDetailsHeader-addSec']");
        BOMUploadPage.put("ordercode_text", "//*[@id='partNumber']");
        BOMUploadPage.put("quantity_text", "//*[@id='quantity']");
        BOMUploadPage.put("addPart_button", "//*[@id='bomAddpartSubt']");
        BOMUploadPage.put("showAllitems_text", "//*[@class='tab1-circle circle2']");
        BOMUploadPage.put("qualifier9_text", "//*[@id='bomFileRow_9']/td[6]");

        //create  Quote
        BOMUploadPage.put("CreateQuote_link", "//*[@class='createQuoteIcn']");
        BOMUploadPage.put("pricingQuery_radio", "(//*[@name='quoteforgrp'])[1]");
        BOMUploadPage.put("intendedOrder_radio", "(//*[@name='quoteforgrp'])[2]");
        BOMUploadPage.put("continue_button", "(//*[@class='btn btnPrimary'])[6]");
        BOMUploadPage.put("bomQuote_link", "//a[contains(@href,'bomQuote')]");
        BOMUploadPage.put("selectAll_checkbox", "//*[@id='addAllLines']");
        BOMUploadPage.put("addToBasket_button", "//*[@id='buySelectedIdBom']");
        BOMUploadPage.put("editQuotename_text", "(//*[@class='saveBomTitle'])[1]/h3");
        BOMUploadPage.put("editQuoteName_icon", "(//*[@id='editFileName'])[2]");
        BOMUploadPage.put("editQuoteName_text", "//*[@id='editBomFileName']");
        BOMUploadPage.put(
            "saveQuoteName_button",
            "//*[@class='btn btnPrimary bomSaveBut']"
        );
    }

    public String findLocator(String elementName) {
        if (BOMUploadPage.containsKey(elementName)) {
            return (BOMUploadPage.get(elementName.trim()));
        }

        return null;
    }
}
