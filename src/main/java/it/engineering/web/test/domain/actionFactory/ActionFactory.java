package it.engineering.web.test.domain.actionFactory;

import it.engineering.web.test.constants.Constants;
import it.engineering.web.test.domain.action.AbstractAction;
import it.engineering.web.test.domain.action.login.LoginGetAction;
import it.engineering.web.test.domain.action.login.LoginPostAction;

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

		default:
			break;
		}
		return action;
	}

}
