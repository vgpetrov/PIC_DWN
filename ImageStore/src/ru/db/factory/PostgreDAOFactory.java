package ru.db.factory;

import ru.db.dao.ImagePropertyDAO;
import ru.db.dao.PostgreSiteDAO;
import ru.db.dao.SiteDAO;

public class PostgreDAOFactory extends DAOFactory {

	@Override
	public SiteDAO getSiteDAO() {
		return new PostgreSiteDAO();
	}

	@Override
	public ImagePropertyDAO getImagePropertyDAO() {
		// TODO Auto-generated method stub
		return null;
	}


}
