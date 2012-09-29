package ru.db.init;

import org.postgresql.ds.PGPoolingDataSource;

public class PostgreSQLPooledConnection {

	private static volatile PGPoolingDataSource source = null;

	private PostgreSQLPooledConnection() {
	}

	public static PGPoolingDataSource getInstance() {
		if (source == null) {
			synchronized (PostgreSQLPooledConnection.class) {
				if (source == null) {
					source = new PGPoolingDataSource();
					source.setDataSourceName("PGSQLDataSource");
					source.setServerName("localhost");
					source.setDatabaseName("postgres");
					source.setUser("postgres");
					source.setPassword("123456");
					source.setMaxConnections(20);
				}
			}
		}
		return source;
	}
}
