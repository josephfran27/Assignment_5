package mvc.model;

import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PetJSONReader {
	
	/**
	 * Loads the Pet objects from pets.json and adds them into a list.
	 * @param filePath: The filePath that will be read (pets.json)
	 * @return: An ArrayList of the different pets that were read from the file. If there
	 * is an error reading the file, an empty ArrayList is returned.
	 */
	public static ArrayList<Pet> loadPets(String filePath) {
		try(FileReader reader = new FileReader(filePath)) {
			Gson gson = new Gson();
			Type petListType = new TypeToken<ArrayList<Pet>>(){}.getType();
			return gson.fromJson(reader, petListType);
			
		} catch(IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	/**
	 * Loads the Exotic Animal objects from exotic_animals.json and adds them to a list. It 
	 * also implements the adapter and makes the exotic animal objects compatible with the 
	 * original pet objects.
	 * @param filePath: The filePath that will be read (exotic_animals.json)
	 * @return An ArrayList of the adapted pets. If there
	 * is an error reading the file, an empty ArrayList is returned.
	 */
	public static ArrayList<Pet> loadExoticPets(String filePath) {
		try(FileReader reader = new FileReader(filePath)) {
			Gson gson = new Gson();
			Type exoticPetListType = new TypeToken<ArrayList<ExoticAnimal>>(){}.getType();
			ArrayList<ExoticAnimal> exoticAnimals = gson.fromJson(reader, exoticPetListType);
			
			ArrayList<Pet> adaptedPets = new ArrayList<>();
			for(ExoticAnimal exotic : exoticAnimals) {
				adaptedPets.add(new ExoticAnimalAdapter(exotic));
			}
			return adaptedPets;
			
		} catch(IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	/**
	 * Saves the list of pets to a JSON file.
	 * @param pets: The list of pets that is to be saved.
	 * @param filePath: The filePath where the list is saved, in this case a new file is written.
	 */
	public static void savePetsToFile(List<Pet> pets, String filePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(pets, writer);
		} catch (IOException e) {
			System.err.println("Failed to save pets: " + e.getMessage());
		}
	}

}
