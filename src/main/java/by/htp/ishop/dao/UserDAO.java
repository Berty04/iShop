package by.htp.ishop.dao;

import java.sql.Connection;

import by.htp.ishop.bean.User;
import by.htp.ishop.dao.connectionpool.ConnectionPool;

public interface UserDAO {
	String signIn(String login, String password, ConnectionPool cp, Connection con) throws DAOException;
	boolean registration(User user, ConnectionPool cp, Connection con) throws DAOException;
}