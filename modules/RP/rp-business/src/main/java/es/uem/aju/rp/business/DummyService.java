package es.uem.aju.rp.business;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import es.uem.aju.common.dao.DummyPersonDAO;
import es.uem.aju.common.dto.dummy.DummyPersonDTO;
import es.uem.aju.common.util.Dummy;
import es.uem.aju.rp.business.IDummyLocal;
import es.uem.aju.rp.business.IDummyRemote;

@Stateless( name = "DummyService" )
@Local( IDummyLocal.class )
@Remote( IDummyRemote.class )
public class DummyService implements IDummyLocal{

	
	@Inject
	private DummyPersonDAO personDao;
	
	/**
	 * Dummy method: Checking maven dependencies are available at runtime 
	 */
	public String dummyRTMethod() {

		Dummy commonDummy = new Dummy(); 
		return "This is "+getClass()+" making use of commonn util: "+commonDummy.dummyMethod();
	}
	

	/**
	 * Checking DB connectivity and DAO Injection
	 */
	public String findDummyPersonByID(Long id) {
		try {
			DummyPersonDTO person = personDao.find(id);			
			return "Person retreived: "+person.getName();
			
		} catch (SQLException e) {			
			e.printStackTrace();
			return "Error retrieving Person List " + e.getMessage();			
		}
	}

	/**
	 * Checking DB connectivity and DAO Injection
	 */
	public String findDummyPersonByCity(String cityName) {
		try {
			List<DummyPersonDTO> personList = (List<DummyPersonDTO>) personDao.findByCity(cityName);
			StringBuilder sb = new StringBuilder("People found in "+cityName+": ");
			for (DummyPersonDTO person : personList){
				sb.append(person.getName()+" ");
			}
			return sb.toString();
			
		} catch (SQLException e) {			
			e.printStackTrace();
			return "Error retrieving Person List " + e.getMessage();			
		}
	}	
}
