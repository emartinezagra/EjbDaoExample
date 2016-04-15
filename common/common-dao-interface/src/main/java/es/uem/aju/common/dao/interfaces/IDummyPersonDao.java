package es.uem.aju.common.dao.interfaces;

import java.sql.SQLException;
import java.util.Collection;

import es.uem.aju.common.dao.base.GenericDAO;
import es.uem.aju.common.dto.dummy.DummyPersonDTO;

public interface IDummyPersonDao extends GenericDAO<DummyPersonDTO, Long> {
	
	 public Collection<DummyPersonDTO> findByCity(String cityName ) throws SQLException;
}
