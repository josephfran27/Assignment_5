package mvc.model;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<PetInterface> {


	/**
	 * Compares the age of pets. Helps with sorting.
	 */
	@Override
	public int compare(PetInterface o1, PetInterface o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}
