package mvc.model;

import java.util.ArrayList;

public class PetContainerModel {
	
	private ArrayList<Pet> petList;
	
	/**
	 * 
	 */
	public PetContainerModel() {
		this.petList = new ArrayList<>();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Pet> getPetList() {
		return petList;
	}
	
	

}
