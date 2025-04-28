package mvc.model;

public class ExoticAnimal {
	
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private int yearsOld;
	
	/**
	 * Constructor for ExoticAnimal object, initializes all of the unique fields of the exotic animal.
	 * @param uniqueId: ID of animal.
	 * @param animalName: Name of animal.
	 * @param category: Category (type) of animal.
	 * @param subSpecies: Species of animal.
	 * @param yearsOld: Age of animal.
	 */
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
	}

	/**
	 * Returns the unique ID of the animal.
	 * @return: The unique ID of the animal.
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Sets the unique ID of the animal.
	 * @param uniqueId: The unique ID of the animal.
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Returns the name of the animal.
	 * @return: The name of the animal.
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * Sets the name of the animal.
	 * @param animalName: The name of the animal.
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	/**
	 * Returns the category of the animal.
	 * @return: The category of the animal.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category of the animal.
	 * @param category: The category of the animal.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns the subSpecies of the animal.
	 * @return: The subSpecies of the animal.
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * Sets the subSpecies of the animal.
	 * @param subSpecies: The subSpecies of the animal.
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	/**
	 * Returns the age of the animal.
	 * @return: The age of the animal.
	 */
	public int getYearsOld() {
		return yearsOld;
	}

	/**
	 * Sets the age of the animal.
	 * @param yearsOld: The age of the animal.
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
	
	
	

}
