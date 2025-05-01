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
	
	public static void savePetsToFile(List<Pet> pets, String filePath) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(FileWriter writer = new FileWriter(filePath)) {
			gson.toJson(pets, writer);
		} catch (IOException e) {
			System.err.println("Failed to save pets: " + e.getMessage());
		}
	}

}
