package es.uem.aju.rp.business;

public interface IDummyRemote {
	
	public String dummyRTMethod();
	
	public String findDummyPersonByID(Long id);
	
	public String findDummyPersonByCity(String cityName);

}

