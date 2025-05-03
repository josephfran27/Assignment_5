package mvc.view;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import mvc.model.Pet;

public class PetView extends JFrame {
	
	private JPanel panel;
	
	//input boxes/selectors for pet information
	private JTextField nameTextField;
	private JTextField speciesTextField;
	private JTextField ageTextField;
	private JComboBox<String> typeComboBox;
	private JComboBox<String> sortComboBox;
	
	//buttons for pet list methods
	private JButton addPetButton;
	private JButton adoptPetButton;
	private JButton removePetButton;
	private JButton viewDetailsButton;
	private JButton savePetButton;
	
	//initializer for pet list and display
	private JList<Pet> petList;
	private DefaultListModel<Pet> petListModel;
	
	/**
	 * Constructs and initializes the shelter graphical user interface.
	 */
	public PetView() {
		setTitle("Pet/Shelter Information Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		//input fields/combo boxes
		nameTextField = new JTextField();
		nameTextField.setBounds(620, 40, 120, 20);
		panel.add(nameTextField);
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(620, 70, 120, 20);
		panel.add(speciesTextField);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(620, 100, 120, 20);
		panel.add(ageTextField);
		
		typeComboBox = new JComboBox<>(new String[] {"Select Type", "Dog", "Cat", "Rabbit", "Exotic Animal"});
		typeComboBox.setBounds(620, 130, 120, 20);
		panel.add(typeComboBox);
		
		//labels, buttons, and combo boxes
		panel.add(new JLabel("Name: ")).setBounds(560, 40, 100, 20);
		panel.add(new JLabel("Species: ")).setBounds(560, 70, 100, 20);
		panel.add(new JLabel("Age: ")).setBounds(560, 100, 100, 20);
		panel.add(new JLabel("Type: ")).setBounds(560, 130, 100, 20);
		
		addPetButton = new JButton("Add Pet");
		addPetButton.setBounds(550, 160, 190, 25);
		panel.add(addPetButton);
		
		panel.add(new JLabel("Other Options")).setBounds(600, 210, 100, 15);
		
		adoptPetButton = new JButton("Adopt Pet");
		adoptPetButton.setBounds(550, 230, 190, 25);
		panel.add(adoptPetButton);
		
		removePetButton = new JButton("Remove Pet");
		removePetButton.setBounds(550, 260, 190, 25);
		panel.add(removePetButton);
		
		viewDetailsButton = new JButton("View Details");
		viewDetailsButton.setBounds(550, 290, 190, 25);
		panel.add(viewDetailsButton);
		
		savePetButton = new JButton("Save");
		savePetButton.setBounds(550, 320, 190, 25);
		panel.add(savePetButton);
		
		sortComboBox = new JComboBox<>(new String[] {"Name", "Age", "Species"});
		sortComboBox.setBounds(220, 340, 190, 25);
		panel.add(sortComboBox);
		
		panel.add(new JLabel("Sort By: ")).setBounds(170, 345, 100, 15);
		
		//pet list
		DefaultListModel<Pet> petListModel = new DefaultListModel<>();
		petList = new JList<>(petListModel);
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane = new JScrollPane(petList);
		scrollPane.setBounds(30, 30, 500, 300);
		panel.add(scrollPane);
	}
	
	/**
	 * Returns the pet name input.
	 */
	public String getName() {
		return nameTextField.getText();
	}
	
	/**
	 * Returns the pet species input.
	 */
	public String getSpecies() {
		return speciesTextField.getText();
	}
	
	/**
	 * Returns the pet age input as an integer.
	 */
	public int getAge() {
		return Integer.parseInt(ageTextField.getText());
	}
	
	/**
	 * Returns the selected pet type.
	 */
	public String getPetType() {
		return (String) typeComboBox.getSelectedItem();
	}
	
	/**
	 * Returns the selected pet from the pet list.
	 */
	public Pet getSelectedPet() {
		return petList.getSelectedValue();
	}
	
	/**
	 * Returns the index of the selected pet from the pet list.
	 */
	public int getSelectedIndex() {
		return petList.getSelectedIndex();
	}
	
	/**
	 * Returns the model that holds the pet list.
	 * @return
	 */
	public DefaultListModel<Pet> getPetListModel() {
		return petListModel;
	}
	
	//Returns the different buttons
	public JButton getAddPetButton() {
		return addPetButton;
	}
	
	public JButton getAdoptPetButton() {
		return adoptPetButton;
	}
	
	public JButton getRemovePetButton() {
		return removePetButton;
	}
	
	public JButton getViewDetailsButton() {
		return viewDetailsButton;
	}
	
	public JButton getSaveButton() {
		return savePetButton;
	}
	
	//Returns the sort combo box
	public JComboBox<String> getSortComboBox() {
		return sortComboBox;
	}
	
	//listeners for the different buttons
	public void addAddPetListener(ActionListener listener) {
		addPetButton.addActionListener(listener);
	}
	
	public void addAdoptPetListener(ActionListener listener) {
		adoptPetButton.addActionListener(listener);
	}
	
	public void addRemovePetListener(ActionListener listener) {
		removePetButton.addActionListener(listener);
	}
	
	public void addViewDetailsButtonListener(ActionListener listener) {
		viewDetailsButton.addActionListener(listener);
	}
	public void addSavePetListener(ActionListener listener) {
		savePetButton.addActionListener(listener);
	}
	
	public void addSortComboBoxListener(ActionListener listener) {
		sortComboBox.addActionListener(listener);
	}
	
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) petList.getModel();
	}
	
	
}
