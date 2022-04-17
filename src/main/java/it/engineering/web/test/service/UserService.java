package it.engineering.web.test.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	String login(HttpServletRequest request, String username, String password);

	String logout(HttpServletRequest request);

}