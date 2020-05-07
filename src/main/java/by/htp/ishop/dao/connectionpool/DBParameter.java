package by.htp.ishop.dao.connectionpool;

public final class DBParameter {
	private DBParameter(){}
	
	private static final String DB_DRIVER = "db.driver";
	private static final String DB_URL = "db.url";
	private static final String DB_USER = "db.user";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_POOL_SIZE = "db.poolsize";
	
	public static String getDbDriver() {
		return DB_DRIVER;
	}

	public static String getDbUrl() {
		return DB_URL;
	}

	public static String getDbUser() {
		return DB_USER;
	}

	public static String getDbPassword() {
		return DB_PASSWORD;
	}

	public static String getDbPoolSize() {
		return DB_POOL_SIZE;
	}
}
