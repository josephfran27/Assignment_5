package mvc.model;

import java.util.Comparator;

public class PetSpeciesComparator implements Comparator<PetInterface> {

	/**
	 * Compares the species of pets. Helps with sorting.
	 */
	@Override
	public int compare(PetInterface o1, PetInterface o2) {
		return o1.getSpecies().compareToIgnoreCase(o2.getSpecies());
	}

}
