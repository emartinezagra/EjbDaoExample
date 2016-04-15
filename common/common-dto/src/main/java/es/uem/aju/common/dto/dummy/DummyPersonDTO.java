package es.uem.aju.common.dto.dummy;

import es.uem.aju.common.dto.base.BaseDTO;

/**
 * Dummy DTO for person entity
 * @author emartinezagra
 *
 */
public final class DummyPersonDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1667751109878207756L;

	private String name;
	
	public DummyPersonDTO(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
