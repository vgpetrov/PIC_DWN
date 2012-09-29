package ru.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ru.db.entities.Site;
import ru.db.init.PostgreSQLConnection;

public class PostgreSiteDAO implements SiteDAO {

	private PostgreSQLConnection conn = new PostgreSQLConnection();
	
	@Override
	public int insertCustomer(Site site) {
		Connection con = conn.getConnection(true);
		try {
			PreparedStatement ps = con.prepareStatement("insert into public.site values (?,?)");
			ps.setInt(1, site.getId());
			ps.setString(2, site.getSiteName());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}


}
