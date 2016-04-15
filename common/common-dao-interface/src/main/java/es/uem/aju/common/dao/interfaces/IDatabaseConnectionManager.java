package es.uem.aju.common.dao.interfaces;

import java.sql.Connection;

public interface IDatabaseConnectionManager {
	
	 public Connection getConnection();
}
