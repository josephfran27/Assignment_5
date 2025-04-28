package mvc.model;

import java.util.Comparator;

public class PetNameComparator implements Comparator<Pet> {

	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
