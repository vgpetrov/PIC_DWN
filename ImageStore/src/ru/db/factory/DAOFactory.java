package ru.db.factory;

import ru.db.dao.ImagePropertyDAO;
import ru.db.dao.SiteDAO;

public abstract class DAOFactory {
	// List of DAO types supported by the factory
	public static final int POSTGRESQL = 1;

	// There will be a method for each DAO that can be
	// created. The concrete factories will have to
	// implement these methods.
	public abstract SiteDAO getSiteDAO();
	public abstract ImagePropertyDAO getImagePropertyDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case POSTGRESQL:
			return new PostgreDAOFactory();
		default:
			return null;
		}
	}
}
