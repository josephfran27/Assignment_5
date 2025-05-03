package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import mvc.model.Cat;
import mvc.model.Dog;
import mvc.model.ExoticAnimal;
import mvc.model.ExoticAnimalAdapter;
import mvc.model.Pet;
import mvc.model.PetContainerModel;
import mvc.model.PetJSONReader;
import mvc.model.Rabbit;
import mvc.view.PetView;
import mvc.model.PetNameComparator;
import mvc.model.PetAgeComparator;
import mvc.model.PetSpeciesComparator;



public class ShelterInformationController {
	
	private PetContainerModel petContainerModel;
	private PetView petView;
	
	/**
	 * This is the constructor for the controller. It uses the passed model and view. It also loads the
	 * original and exotic pets from the JSON files. Lastly, it adds all of the listeners.
	 * @param petContainerModel: The model for the list of pets.
	 * @param petView: The view for the pets.
	 */
	public ShelterInformationController(PetContainerModel petContainerModel, PetView petView) {
		this.petContainerModel = petContainerModel;
		this.petView = petView;
		
		//load pets
		ArrayList<Pet> originalPets = PetJSONReader.loadPets("src/main/resources/pets.json");
		ArrayList<Pet> exoticPets = PetJSONReader.loadExoticPets("src/main/resources/exotic_animals.json");
		
		for(Pet pet: originalPets) {
			petContainerModel.getPetList().add(pet);
			petView.getPetList().addElement(pet);
		}
		
		for(Pet pet: exoticPets) {
			petContainerModel.getPetList().add(pet);
			petView.getPetList().addElement(pet);
		};
		
		//add listeners
		petView.addAddPetListener(new AddPetButtonListener());
		petView.addAdoptPetListener(new AdoptPetButtonListener());
		petView.addRemovePetListener(new RemovePetButtonListener());
		petView.addViewDetailsButtonListener(new ViewDetailsButtonListener());
		petView.addSavePetListener(new SavePetButtonListener());
		petView.addSortComboBoxListener(new SortComboBoxListener());
	}
	
	/**
	 * Shows the pet view.
	 */
	public void initiate() {
		petView.setVisible(true);
	}
	
	/**
	 * The listener for the Add Pet button. It uses the user input to create a new pet object based
	 * on the selected fields by using a switch case.
	 */
	private class AddPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = petContainerModel.getPetList().size() + 1;
			String name = petView.getName();
			String species = petView.getSpecies();
			int age = petView.getAge();
			String type = petView.getPetType();	
			
			Pet newPet = null;
			
			switch(type) {
			case "Dog":
				newPet = new Dog(id, name, "Dog", species, age, false);
				break;
			case "Cat":
				newPet = new Cat(id, name, "Cat", species, age, false);
				break;
			case "Rabbit":
				newPet = new Rabbit(id, name, "Rabbit", species, age, false);
				break;
			case "Exotic Animal":
				newPet = new ExoticAnimalAdapter(new ExoticAnimal("exo-" + id, name, "Exotic Animal", species, age));
				break;
			default:
				System.out.println("Error adding pet.");
				break;
			}
			
			if(newPet != null) {
				petContainerModel.getPetList().add(newPet);
				petView.getPetList().addElement(newPet);
				System.out.println("Pet (" + newPet.getName() + ") has been succesfully added!");
			}
			
		}
	}
	
	/**
	 * The listener for the Adopt Pet button. It checks that the pet isn't already adopted and it sets its
	 * status to true upon the click on the button. It also uses repaint to set the screen to say true.
	 */
	private class AdoptPetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet selectedPet = petView.getSelectedPet();
			if(selectedPet != null && selectedPet.isAdopted() != true) {
				System.out.println("Pet (" + selectedPet.getName() + ") has been succesfully adopted!");
				selectedPet.setAdopted(true);
				petView.repaint();
			}
				
		}
			
	}
	
	/**
	 * The listener for the Remove Pet button. It uses the selected index from the pet that the user clicked
	 * and removes the pet.
	 */
	private class RemovePetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedIndex = petView.getSelectedIndex();
			if(selectedIndex != -1) {
				Pet toRemove = petView.getPetList().getElementAt(selectedIndex);
				System.out.println("Pet (" + toRemove.getName() + ") has been succesfully removed!");
				petView.getPetList().removeElement(toRemove);
				petContainerModel.getPetList().remove(toRemove);
			}
			
		}
		
	}
	
	/**
	 * The listener for the View Details button. It displays a dialog that shows the information of the 
	 * selected pet object.
	 */
	private class ViewDetailsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet selectedPet = petView.getSelectedPet();
			if(selectedPet != null) {
				JOptionPane.showMessageDialog(petView, selectedPet.toString());
			}
			
		}
		
	}
	
	/**
	 * Listener for the Save button. It saves the list of pets to the JSON file with formatting to add the 
	 * time stamp.
	 */
	private class SavePetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd__HHmmss"));
			String filename = "output/" + timestamp + "src/main/resources/pets.json";
			PetJSONReader.savePetsToFile(petContainerModel.getPetList(), filename);
			JOptionPane.showMessageDialog(petView, "Pets saved.");
			
		}
		
	}
	
	/**
	 * Listener for the Sort combo box. It supports the pets based on the chosen comparator that were
	 * initially defined.
	 */
	private class SortComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedPet = (String) petView.getSortComboBox().getSelectedItem();
			ArrayList<Pet> pets = petContainerModel.getPetList();
			
			switch(selectedPet.toLowerCase()) {
			case "name":
				pets.sort(new PetNameComparator());
				break;
			case "age":
				pets.sort(new PetAgeComparator());
				break;
			case "species":
				pets.sort(new PetSpeciesComparator());
				break;
			default:
				break;
			}
			
			DefaultListModel<Pet> model = petView.getPetList();
			model.clear();
			for(Pet pet : pets) {
				model.addElement(pet);
			}
		}
		
	}
		
 
}
