package it.engineering.web.test.action.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.test.action.AbstractAction;
import it.engineering.web.test.constants.Constants;

public class BadRequestAction extends AbstractAction {
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return Constants.PAGE_ERROR;
	}
}
