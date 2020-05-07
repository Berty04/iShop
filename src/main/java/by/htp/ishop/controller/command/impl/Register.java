package by.htp.ishop.controller.command.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import by.htp.ishop.bean.User;
import by.htp.ishop.controller.command.Command;
import by.htp.ishop.dao.connectionpool.ConnectionPool;
import by.htp.ishop.service.ClientService;
import by.htp.ishop.service.ServiceException;
import by.htp.ishop.service.ServiceFactory;

public class Register implements Command {
	@Override
	public String execute(HttpServletRequest request, ConnectionPool cp, Connection con) {
		String login = null;
		String password = null;
		String name = null;
		String surname = null;
		String response = null;

		login = request.getParameter("login");
		password = request.getParameter("password");
		name = request.getParameter("name");
		surname = request.getParameter("surname");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getCLientService();

		User user = User.getInstance();
		
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setSurname(surname);

		try {
			clientService.registration(user, cp, con);
			response = "Welcome";
		} catch (ServiceException e) {
			// write log
			response = "Error duiring registration procedure";
		}
		return response;
	}
}
