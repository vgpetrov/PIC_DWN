/**
 * 
 */
package ru.file.store;

import java.util.Date;

import ru.api.interfaces.IImageStore;
import ru.db.dao.SiteDAO;
import ru.db.entities.Site;
import ru.db.factory.DAOFactory;

/**
 * @author admin
 *
 */
public class StoreFileDbFS implements IImageStore {

	/* (non-Javadoc)
	 * @see ru.api.interfaces.IImageStore#putImageFile(java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public void putImageFile(String dir, String fileName, Date date) {
		DAOFactory factory = DAOFactory.getDAOFactory(1);
		SiteDAO sitedao = factory.getSiteDAO();
		
		Site site = new Site();
		site.setSiteName("google.com");
		sitedao.insertCustomer(site);
	}

}
