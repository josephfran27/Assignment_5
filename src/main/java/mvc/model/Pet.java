package mvc.model;

public class Pet implements Comparable<Pet>, PetInterface {
	
	private int id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;
	
	/**
	 * Constructor for the Pet object, creating a pet with the given fields.
	 * @param id: ID of the pet.
	 * @param name: Name of the pet.
	 * @param type: Type of pet.
	 * @param species: Species of the pet.
	 * @param age: Age of the pet.
	 * @param adopted: Adoption status of the pet.
	 */
	public Pet(int id, String name, String type, String species, int age, boolean adopted) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = adopted;
	}

	/**
	 * Returns the id of the pet.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id of the pet.
	 * @param id: The id of the pet.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the name of the pet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the pet.
	 * @param name: The name of the pet.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the type of pet.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of pet.
	 * @param type: Type of pet.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the species of the pet.
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Sets the species of the pet.
	 * @param species: The species of the pet.
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * Returns the age of the pet.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the pet.
	 * @param age: The age of the pet.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the adoption status of the pet.
	 */
	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * Sets the adoption status of the pet.
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	

	/**
	 * Returns a string representation of the pet and its fields.
	 */
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", adopted=" + adopted + "]";
	}

	/**
	 * Compares the pet to another pet based on their names. Helps with sorting.
	 */
	@Override
	public int compareTo(Pet o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	
	
	
	
}
