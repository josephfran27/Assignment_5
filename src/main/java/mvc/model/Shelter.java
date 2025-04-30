package mvc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter <T extends Pet>{
	
	private List<T> pets;
	
	/**
	 * Constructor to initialize an empty pet list.
	 */
	public Shelter() {
		this.pets = new ArrayList<>();
	}
	
	/**
	 * Constructor to initialize a list with the given pets.
	 * @param pets: The pets to be put into the list.
	 */
	public Shelter(List<T> pets) {
		super();
		this.pets = pets;
	}

	/**
	 * Adds a new pet to the shelter list.
	 * @param pet: Pet to be added.
	 */
	public void addPet(T pet) {
		if(pet == null) {
			System.out.println("Error adding pet to shelter.");
			return;
		}
		System.out.println("Success adding pet (" + pet.getName() + ") to the Shelter!");
		pets.add(pet);
	}

	/**
	 * Removes a pet from the shelter list.
	 * @param pet: Pet to be removed.
	 */
	public void removePet(T pet) {
		if(pet == null) {
			System.out.println("Error removing pet from the shelter.");
			return;
		}
		System.out.println("Success removing pet (" + pet.getName() + ") from the Shelter!");
		pets.remove(pet);
	}
	
	/**
	 * Returns the list of pets.
	 * @return
	 */
	public List<T> getPets() {
		return pets;
	}
	
	/**
	 * Sorts the pets using the given comparator (name, species, age, etc.)
	 */
	public void sortPets(Comparator<T> comparator) {
		Collections.sort(pets, comparator);
	}
	
	/**
	 * Sets the adoption status of a pet to true if it isn't already adopted.
	 * @param pet: Pet to be adopted.
	 * @return: True or false based on pets adoption status/success.
	 */
	public boolean adoptPet(T pet) {
		if(pet != null) {
			if(pet.isAdopted() == true) {
				System.out.println("Pet ("+ pet.getName() + ") is already adopted!");
				return false;
			}
			System.out.println("Pet ("+ pet.getName() + ") has been adopted!");
			pet.setAdopted(true);
			return true;
		}
		return false;
	}
	

}
