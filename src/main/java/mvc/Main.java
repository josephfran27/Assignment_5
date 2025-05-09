package mvc;

import javax.swing.SwingUtilities;

import mvc.controller.ShelterInformationController;
import mvc.model.PetContainerModel;
import mvc.view.PetView;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
            PetContainerModel model = new PetContainerModel();
            PetView view = new PetView();
            ShelterInformationController controller = new ShelterInformationController(model, view);
            controller.initiate();
        });
		
	}

}
