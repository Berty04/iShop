package by.htp.ishop.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.ishop.bean.RegisteredUser;
import by.htp.ishop.controller.command.Command;
import by.htp.ishop.dao.connectionpool.ConnectionPool;
import by.htp.ishop.dao.connectionpool.ConnectionPoolException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CommandProvider provider = new CommandProvider();

	private ConnectionPool cp;
	private Connection con;
	
	public RegisteredUser regUser;

	public Controller() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		cp = ConnectionPool.getInstance();
		try {
			cp.initPoolData();
			con = cp.takeConnection();
		} catch (ConnectionPoolException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
		cp.dispose();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String result = executeTask(request);
		
		request.setAttribute("message", result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mainPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public String executeTask(HttpServletRequest request) {
		String commandName;
		Command executionCommand;
		String response;

		commandName = request.getParameter("command");
		
		executionCommand = provider.getCommand(commandName);

		response = executionCommand.execute(request, cp, con);

		return response;
	}
}