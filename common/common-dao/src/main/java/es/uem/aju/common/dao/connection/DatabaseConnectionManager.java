package es.uem.aju.common.dao.connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import es.uem.aju.common.dao.interfaces.IDatabaseConnectionManager;

public class DatabaseConnectionManager implements IDatabaseConnectionManager, Serializable {

	private static final long serialVersionUID = -7677524070173149045L;

	@Resource( lookup = "java:/aju" )
    private DataSource connection;
	
	public Connection getConnection()
    {
        try
        {
            return connection.getConnection();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}
