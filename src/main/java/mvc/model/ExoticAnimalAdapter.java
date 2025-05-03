package mvc.model;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal = null;
	
	//exotic animal is initially missing this field;
	private boolean adopted;
	
	/**
	 * Creates the exotic animal and sets the adoption status to false as default to adhere to the initial structure of the
	 * original Pets.
	 * @param exoticAnimal
	 */
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		super(
				exoticAnimal.getUniqueId().hashCode(),
				exoticAnimal.getAnimalName(),
				exoticAnimal.getCategory(),
				exoticAnimal.getSubSpecies(),
				exoticAnimal.getYearsOld(),
				exoticAnimal.isAdopted()
		);
		this.exoticAnimal = exoticAnimal;
		this.adopted = false;
	}

	/**
	 * Returns the uniqueID of the animal.
	 */
	@Override
	public int getId() {
		//.hashCode() converts the uniqueID string to an integer
		return exoticAnimal.getUniqueId().hashCode();
	}

	/**
	 * Returns the name of the animal.
	 */
	@Override
	public String getName() {
		return exoticAnimal.getAnimalName();
	}

	/**
	 * Returns the category(type) of the animal.
	 */
	@Override
	public String getType() {
		return exoticAnimal.getCategory();
	}

	/**
	 * Returns the species(subspecies) of the animal.
	 */
	@Override
	public String getSpecies() {
		return exoticAnimal.getSubSpecies();
	}

	/*
	 * Returns the age of the animal.
	 */
	@Override
	public int getAge() {
		return exoticAnimal.getYearsOld();
	}

	/**
	 * Returns the adoption status of the animal.
	 */
	@Override
	public boolean isAdopted() {
		return exoticAnimal.isAdopted();
	}
	
	/**
	 * Sets the adoption status of the animal.
	 */
	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
		exoticAnimal.setAdopted(adopted);
	}

	

}
