package by.htp.ishop.service;

import java.sql.Connection;

import by.htp.ishop.bean.User;
import by.htp.ishop.dao.DAOException;
import by.htp.ishop.dao.DAOFactory;
import by.htp.ishop.dao.UserDAO;
import by.htp.ishop.dao.connectionpool.ConnectionPool;

public class ClientServiceImpl implements ClientService {
	@Override
	public String signIn(String login, String password, ConnectionPool cp, Connection con) throws ServiceException {
		if (login == null || login.isEmpty()) {
			throw new ServiceException("Incorrect login");
		}
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			return userDAO.signIn(login, password, cp, con);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		//....
	}

	@Override
	public void registration(User user, ConnectionPool cp, Connection con) throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.registration(user, cp, con);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}