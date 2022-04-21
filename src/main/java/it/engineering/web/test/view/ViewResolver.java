package it.engineering.web.test.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import it.engineering.web.test.constants.Constants;

@Component
public class ViewResolver {
	private Map<String, String> map;
	
	public ViewResolver() {
		
		this.map = new HashMap<String, String>();
		map.put(Constants.VIEW_LOGIN, Constants.PAGE_LOGIN);
	}

	public String getPage(String view) {
		return map.get(view);
	}
}
