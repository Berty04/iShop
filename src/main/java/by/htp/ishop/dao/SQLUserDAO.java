package by.htp.ishop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ishop.bean.RegisteredUser;
import by.htp.ishop.bean.User;
import by.htp.ishop.dao.connectionpool.ConnectionPool;

public class SQLUserDAO implements UserDAO {

	private static final String signInQuery = "SELECT * FROM users WHERE login=? AND password=?";
	private static final String registerQuery = "INSERT INTO users(login,password,name,surname) VALUES(?,?,?,?)";
	public RegisteredUser regUser;
	
	@Override
	public String signIn(String login, String password, ConnectionPool cp, Connection con) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(signInQuery);
			
			ps.setString(1, login);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString(4);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cp.closeConnection(con, ps, rs);
		}
		return null;
	}

	@Override
	public boolean registration(User user, ConnectionPool cp, Connection con) throws DAOException {
		PreparedStatement ps = null;
		boolean result = false;

		System.out.println(user.getLogin());
		System.out.println(user.getPassword());
		
		try {
//			cp = ConnectionPool.getInstance();
//			cp.initPoolData();
//			
//			con = cp.takeConnection();
			ps = con.prepareStatement(registerQuery);

			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getSurname());

			ps.executeUpdate();

			System.out.println("Registration successful: " + user.getName() + " " + user.getSurname());
			result = true;

			//user.setPassword(null);
			
			//cp.dispose();

//		} catch (ConnectionPoolException e) {
//			throw new DAOException(e);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			cp.closeConnection(con, ps);
		}

		return result;
	}
}
