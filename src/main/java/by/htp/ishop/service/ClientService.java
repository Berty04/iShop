package by.htp.ishop.service;

import java.sql.Connection;

import by.htp.ishop.bean.User;
import by.htp.ishop.dao.connectionpool.ConnectionPool;

public interface ClientService {
	String signIn(String login, String password, ConnectionPool cp, Connection con) throws ServiceException;
	void registration(User user, ConnectionPool cp, Connection con) throws ServiceException;
}