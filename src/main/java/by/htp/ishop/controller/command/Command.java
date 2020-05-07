package by.htp.ishop.controller.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import by.htp.ishop.dao.connectionpool.ConnectionPool;

public interface Command {
	public String execute(HttpServletRequest request, ConnectionPool cp, Connection con);
}
