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
	
	//text boxes/selector for pet information
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
	
	//initializer for pet list
	private JList<Pet> petList;
	private DefaultListModel<Pet> petListModel;
	
	public PetView() {
		setTitle("Pet/Shelter Information Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		//Header text
		JLabel headerLabel = new JLabel("Welcome to Joe's Pet Shelter!", JLabel.CENTER);
		headerLabel.setSize(350, 100);
		panel.add(headerLabel);
		
		//text fields/combo boxes
		nameTextField = new JTextField();
		nameTextField.setBounds(620, 40, 100, 20);
		panel.add(nameTextField);
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(620, 5070, 120, 20);
		panel.add(speciesTextField);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(620, 100, 120, 20);
		panel.add(ageTextField);
		
		typeComboBox = new JComboBox<>(new String[] {"Dog", "Cat", "Rabbit", "Exotic Animal"});
		ageTextField.setBounds(620, 130, 100, 20);
		panel.add(typeComboBox);
		
		//labels, buttons, and combo boxes
		panel.add(new JLabel("Name: ")).setBounds(560, 40, 100, 20);
		panel.add(new JLabel("Species: ")).setBounds(560, 70, 100, 20);
		panel.add(new JLabel("Age: ")).setBounds(560, 100, 100, 20);
		panel.add(new JLabel("Type: ")).setBounds(560, 130, 100, 20);
		
		addPetButton = new JButton("Add Pet");
		addPetButton.setBounds(550, 180, 80, 25);
		panel.add(addPetButton);
		
		adoptPetButton = new JButton("Adopt Pet");
		adoptPetButton.setBounds(640, 180, 80, 25);
		panel.add(adoptPetButton);
		
		removePetButton = new JButton("Remove Pet");
		removePetButton.setBounds(550, 220, 170, 25);
		panel.add(removePetButton);
		
		viewDetailsButton = new JButton("View Details");
		viewDetailsButton.setBounds(550, 260, 170, 25);
		
		savePetButton = new JButton("Save");
		savePetButton.setBounds(550, 300, 170, 25);
		panel.add(savePetButton);
		
		sortComboBox = new JComboBox<>(new String[] {"Name", "Age", "Species"});
		sortComboBox.setBounds(30, 350, 150, 25);
		panel.add(sortComboBox);
		
		panel.add(new JLabel("Sort By: ")).setBounds(30, 330, 100, 15);
		
		DefaultListModel<Pet> petListModel = new DefaultListModel<>();
		petList = new JList<>(petListModel);
		petList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		JScrollPane scrollPane = new JScrollPane(petList);
		scrollPane.setBounds(30, 30, 500, 203000);
		panel.add(scrollPane);
	}
	
	//methods for controller
	public String getName() {
		return nameTextField.getText();
	}
	
	public String getSpecies() {
		return speciesTextField.getText();
	}
	
	public int getAge() {
		return Integer.parseInt(ageTextField.getText());
	}
	
	public String getType() {
		return (String) typeComboBox.getSelectedItem();
	}
	
	public Pet getSelectedPet() {
		return petList.getSelectedValue();
	}
	
	
	public int getSelectedIndex() {
		return petList.getSelectedIndex();
	}
	
	public DefaultListModel<Pet> getPetListModel() {
		return petListModel;
	}
	
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
	
	public JComboBox<String> getSortComboBox() {
		return sortComboBox;
	}
	
	//listeners
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
