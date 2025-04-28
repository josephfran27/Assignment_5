package mvc.model;

import java.util.Comparator;

public class PetNameComparator implements Comparator<PetInterface> {

	/**
	 * Compares the names of pets. Helps with sorting.
	 */
	@Override
	public int compare(PetInterface o1, PetInterface o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
