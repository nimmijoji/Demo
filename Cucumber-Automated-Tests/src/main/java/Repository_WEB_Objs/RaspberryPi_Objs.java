package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class RaspberryPi_Objs {
	
	private static final Map<String, String> RaspberryPi;

	static {
		RaspberryPi = new HashMap<String, String>();
		RaspberryPi.put("Readmore_link","//*[contains(text(),'Read more')]");
		RaspberryPi.put("gb_link","(//*[@class='col-xs-6 by-bt-gb'])/a");
		RaspberryPi.put("compChart_link","//*[@id=\"boards\"]/div/div[1]/div[2]/a");
	}

	public String findLocator(String elementName) {

		if (RaspberryPi.containsKey(elementName)) {
			return (RaspberryPi.get(elementName.trim()));
		}

		return null;
	}

}
