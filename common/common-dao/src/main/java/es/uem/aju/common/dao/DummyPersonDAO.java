package es.uem.aju.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import es.uem.aju.common.dao.base.Columns;
import es.uem.aju.common.dao.interfaces.IDatabaseConnectionManager;
import es.uem.aju.common.dao.interfaces.IDummyPersonDao;
import es.uem.aju.common.dto.base.BaseDTO;
import es.uem.aju.common.dto.dummy.DummyPersonDTO;


public class DummyPersonDAO implements IDummyPersonDao {
	 
	private final static String FIND_PERSON = 			"SELECT * FROM PERSON WHERE id =?";
	private final static String FIND_PERSON_BY_CITY = 	"SELECT * FROM PERSON WHERE city =?";
	
    @Inject
    @Named( "dataBaseConnectionManager" )
    private IDatabaseConnectionManager dataBaseConnectionManager;
	
	public DummyPersonDTO find(Long pk) throws SQLException {
		
		Connection con = dataBaseConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(FIND_PERSON);
		ps.setLong(1, pk);
		
		List<DummyPersonDTO> results = (List<DummyPersonDTO>) processListResultSet(ps.executeQuery());
		return results.get(0);				
	}
	
	public Collection<DummyPersonDTO> findByCity(String cityName) throws SQLException {
		Connection con = dataBaseConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(FIND_PERSON_BY_CITY);
		ps.setString(1, cityName);
		return (List<DummyPersonDTO>) processListResultSet(ps.executeQuery());		
	}
	
	/**
	 * Process a resultSet and convert it to a list of DTOs
	 */
	public Collection<? extends BaseDTO> processListResultSet(ResultSet resultSet) throws SQLException {
		List<DummyPersonDTO> result = new ArrayList<DummyPersonDTO>();
		while (resultSet.next()){
			result.add(new DummyPersonDTO(resultSet.getString(Columns.PERSON_NAME.getColumnName())));
			
		}
		return result;
	}
	
	public void store(DummyPersonDTO o) throws SQLException {
		throw new UnsupportedOperationException( "this method is not supported for "+this.getClass() );
		
	}

	public void update(DummyPersonDTO o) throws SQLException {
		throw new UnsupportedOperationException( "this method is not supported for "+this.getClass() );
		
	}

	public int delete(Long pk) throws SQLException {
		throw new UnsupportedOperationException( "this method is not supported for "+this.getClass() );
	}
}
