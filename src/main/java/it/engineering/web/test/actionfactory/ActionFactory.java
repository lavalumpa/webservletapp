package it.engineering.web.test.actionfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.action.HomeGetAction;
import it.engineering.web.test.action.error.BadRequestAction;
import it.engineering.web.test.action.login.LoginGetAction;
import it.engineering.web.test.action.login.LoginPostAction;
import it.engineering.web.test.action.logout.LogoutAction;
import it.engineering.web.test.action.producer.ButtonProducersPageAction;
import it.engineering.web.test.action.producer.DeleteConfirmAction;
import it.engineering.web.test.action.producer.EditConfirmProducerAction;
import it.engineering.web.test.action.producer.EditProducerAction;
import it.engineering.web.test.action.producer.GetAddProducerAction;
import it.engineering.web.test.action.producer.PostAddProducerAction;
import it.engineering.web.test.action.producer.ViewProducersAction;
import it.engineering.web.test.constants.Constants;


@Component
public class ActionFactory {
	
	private BadRequestAction badRequestAction;
	private LoginGetAction loginGetAction;
	private LoginPostAction loginPostAction;
	private LogoutAction logoutAction;
	private ButtonProducersPageAction buttonProducersPageAction;
	private DeleteConfirmAction deleteConfirmAction;
	private EditProducerAction editProducerAction;
	private EditConfirmProducerAction editConfirmProducerAction;
	private GetAddProducerAction getAddProducerAction;
	private PostAddProducerAction postAddProducerAction;
	private ViewProducersAction viewProducersAction;
	private HomeGetAction homeGetAction;

	@Autowired
	public ActionFactory(BadRequestAction badRequestAction, LoginGetAction loginGetAction,
			LoginPostAction loginPostAction, LogoutAction logoutAction,
			ButtonProducersPageAction buttonProducersPageAction, DeleteConfirmAction deleteConfirmAction,
			EditConfirmProducerAction editConfirmProducerAction, GetAddProducerAction getAddProducerAction,
			PostAddProducerAction postAddProducerAction, ViewProducersAction viewProducersAction,
			HomeGetAction homeGetAction, EditProducerAction editProducerAction) {
		super();
		this.badRequestAction = badRequestAction;
		this.loginGetAction = loginGetAction;
		this.loginPostAction = loginPostAction;
		this.logoutAction = logoutAction;
		this.buttonProducersPageAction = buttonProducersPageAction;
		this.deleteConfirmAction = deleteConfirmAction;
		this.editConfirmProducerAction = editConfirmProducerAction;
		this.getAddProducerAction = getAddProducerAction;
		this.postAddProducerAction = postAddProducerAction;
		this.viewProducersAction = viewProducersAction;
		this.homeGetAction = homeGetAction;
		this.editProducerAction = editProducerAction;
	}







	public AbstractAction createAction(String method, String path) {
		AbstractAction action = null;
		switch (path) {
		case Constants.PATH_LOGIN:
			if (method.equalsIgnoreCase("get")) {
				action = loginGetAction;
			}if (method.equalsIgnoreCase("post")) {
				action = loginPostAction;
			}
			break;
		case Constants.PATH_ALL_PRODUCERS:{
			action =viewProducersAction;
			break;
		}
		case Constants.PATH_ADD_PRODUCER:{
			if (method.equalsIgnoreCase("get")) {
				action = getAddProducerAction;
			}
			if (method.equalsIgnoreCase("post")) {
				action = postAddProducerAction;
			}
			break;
		}
		case Constants.PATH_PRODUCER_BUTTON:{
			action = buttonProducersPageAction;
			break;
		}
		case Constants.PATH_HOME:{
			action =homeGetAction;
			break;
		}
		case Constants.PATH_EDIT:{
			action = editProducerAction;
			break;
		}
		case Constants.PATH_EDIT_CONFIRM:{
			action =editConfirmProducerAction;
			break;
		}
		case Constants.PATH_DELETE_CONFIRM:{	
			action = deleteConfirmAction;
			break;
		}
		case Constants.PATH_LOGOUT:{	
			action = logoutAction;
			break;
		}
		default:
			action = badRequestAction;
			break;
		}
		return action;
	}

}
