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
		map.put(Constants.VIEW_HOME, Constants.PAGE_HOME);
		map.put(Constants.VIEW_INDEX,Constants.PAGE_INDEX);
		map.put(Constants.VIEW_LOGIN, Constants.PAGE_LOGIN);
		map.put(Constants.VIEW_ERROR, Constants.PAGE_ERROR);
		map.put(Constants.VIEW_ADD_PRODUCER, Constants.PAGE_ADD_PRODUCER);
		map.put(Constants.VIEW_ALL_PRODUCERS, Constants.PAGE_ALL_PRODUCERS);
		map.put(Constants.VIEW_EDIT_PRODUCER,Constants.PAGE_EDIT_PRODUCER);
		map.put(Constants.VIEW_EDIT_PRODUCER_CONFIRM, Constants.PAGE_EDIT_PRODUCER_CONFIRM);
		map.put(Constants.VIEW_DELETE_PRODUCER, Constants.PAGE_DELETE_PRODUCER);
		
	}

	public String getPage(String view) {
		return map.get(view);
	}
}
