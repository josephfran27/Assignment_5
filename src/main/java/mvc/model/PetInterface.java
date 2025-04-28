package mvc.model;

public interface PetInterface {
	
	/**
	 * Defines the methods that Pet should implement. I added this interface so that
	 * it can be implemented by ExoticAnimalAdapter.
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
