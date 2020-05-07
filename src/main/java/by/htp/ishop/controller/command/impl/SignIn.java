package by.htp.ishop.controller.command.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import by.htp.ishop.controller.command.Command;
import by.htp.ishop.dao.connectionpool.ConnectionPool;
import by.htp.ishop.service.ClientService;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;

public class SignIn implements Command {
	@Override
	public String execute(HttpServletRequest request, ConnectionPool cp, Connection con) {
		String login = null;
		String password = null;
		String response = null;
		
		login = request.getParameter("login");
		password = request.getParameter("password");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getCLientService();
		
		try {
			response = clientService.signIn(login, password, cp, con);
			//response = "Welcome";
		} catch (ServiceException e) {
			// write log
			response = "Error duiring login procedure";
		}
		return response;
	}
}