package Common.UTILS;

import Translation.APAC_Countries.AU_Translation;
import Translation.APAC_Countries.CN_Translation;
import Translation.APAC_Countries.SG_Translation;
import Translation.EU_Countries.CH_DE_Translation;
import Translation.EU_Countries.CH_FR_Translation;
import Translation.EU_Countries.CPC_Translation;
import Translation.EU_Countries.DE_Translation;
import Translation.EU_Countries.FR_Translation;
import Translation.US_Countries.US_ES_Translation;
import Translation.US_Countries.US_Translation;

public class TranslationConfig implements BaseTest {

    String RegionName = "";
    String StoreValue = "";
    String value = "";
    String getCurrentUrl = "";

    US_Translation us = new US_Translation();
    US_ES_Translation us_es = new US_ES_Translation();
    SG_Translation sg = new SG_Translation();
    AU_Translation au = new AU_Translation();
    FR_Translation fr = new FR_Translation();
    DE_Translation de = new DE_Translation();
    CH_FR_Translation ch_fr = new CH_FR_Translation();
    CH_DE_Translation ch_de = new CH_DE_Translation();
    CPC_Translation cpc = new CPC_Translation();
    CN_Translation cn = new CN_Translation();

    public String getStoreText(String text) {
        RegionName = driver.getRegionName();
        StoreValue = driver.getStore();
        getCurrentUrl = driver.getCurrentUrl();

        // ****************APAC Translation File*********************************
        if (RegionName.equalsIgnoreCase("apac")) {
            if (StoreValue.equalsIgnoreCase("sg")) {
                value = sg.sgTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("au")) {
                value = au.auTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("cn")) {
                value = cn.cnTranslations(text);
            }
        }

        // ****************NEWARK Translation File*********************************
        if (RegionName.equalsIgnoreCase("newark")) {
            if (
                StoreValue.equalsIgnoreCase("us") &&
                (getCurrentUrl.contains("/es") || getCurrentUrl.contains("langId=72"))
            ) {
                value = us_es.esUSTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("us") || getCurrentUrl.contains("langId=-1")
            ) {
                value = us.usTranslations(text);
            }
        }

        // ****************EUROPE Translation File*********************************
        if (RegionName.equalsIgnoreCase("europe")) {
            if (StoreValue.equalsIgnoreCase("uk")) {
                value = ukTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("fr")) {
                value = fr.frTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("de") &&
                (getCurrentUrl.contains("langId=74") || getCurrentUrl.contains("en-DE"))
            ) {
                value = ukTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("de") &&
                (!getCurrentUrl.contains("en-DE") || getCurrentUrl.contains("langId=-3"))
            ) {
                value = de.deTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("ch") &&
                (getCurrentUrl.contains("fr-CH") || getCurrentUrl.contains("langId=35"))
            ) {
                value = ch_fr.chFRTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("ch") || getCurrentUrl.contains("langId=41")
            ) {
                value = ch_de.chDETranslations(text);
            } else if (StoreValue.equalsIgnoreCase("cpc")) {
                value = cpc.cpcTranslations(text);
            }
        }
        return value;
    }

    // ############uk--English############
    public String ukTranslations(String text) {
        return (text.trim());
    }
}
