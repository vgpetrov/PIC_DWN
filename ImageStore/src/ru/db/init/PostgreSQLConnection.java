package ru.db.init;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLConnection {

	private Connection conn = null;

	public Connection getConnection(Boolean commit) {
		try {
			conn = PostgreSQLPooledConnection.getInstance().getConnection();
			if (commit)
				conn.setAutoCommit(true);
			else
				conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
