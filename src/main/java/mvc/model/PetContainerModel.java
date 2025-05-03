package mvc.model;

import java.util.ArrayList;

public class PetContainerModel {
	
	private ArrayList<Pet> petList;
	
	/**
	 * Constructs a new PetContainerModel with an empty list of pets before reading them 
	 * from the JSON file.
	 */
	public PetContainerModel() {
		this.petList = new ArrayList<>();
	}
	
	/**
	 * Returns the list of pets that are currently in the shelter.
	 * @return The list of pets.
	 */
	public ArrayList<Pet> getPetList() {
		return petList;
	}
	
	

}
