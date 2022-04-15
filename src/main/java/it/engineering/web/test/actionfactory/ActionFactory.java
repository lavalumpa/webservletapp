package it.engineering.web.test.actionfactory;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.action.HomeGetAction;
import it.engineering.web.test.action.login.LoginGetAction;
import it.engineering.web.test.action.login.LoginPostAction;
import it.engineering.web.test.action.producer.GetAddProducerAction;
import it.engineering.web.test.action.producer.PostAddProducerAction;
import it.engineering.web.test.action.producer.ViewProducersAction;
import it.engineering.web.test.constants.Constants;

public class ActionFactory {

	public static AbstractAction createAction(String method, String path) {
		AbstractAction action = null;
		switch (path) {
		case Constants.PATH_LOGIN:
			if (method.equalsIgnoreCase("get")) {
				action = new LoginGetAction();
			}if (method.equalsIgnoreCase("post")) {
				action = new LoginPostAction();
			}
			break;
		case Constants.PATH_ALL_PRODUCERS:{
			action = new ViewProducersAction();
			break;
		}
		case Constants.PATH_ADD_PRODUCER:{
			if (method.equalsIgnoreCase("get")) {
				action = new GetAddProducerAction();
			}
			if (method.equalsIgnoreCase("post")) {
				action = new PostAddProducerAction();
			}
			break;
		}
		case Constants.PATH_HOME:{
			action = new HomeGetAction();
			break;
		}
		default:
			break;
		}
		return action;
	}

}
