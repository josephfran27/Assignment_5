package mvc.model;

public interface PetInterface {
	
	/**
	 * Defines the methods that Pet should implement.
	 * @return
	 */
	int getId();
	String getName();
	String getType();
	String getSpecies();
	int getAge();
	boolean isAdopted();
	void setAdopted(boolean adopted);
	
	
}
