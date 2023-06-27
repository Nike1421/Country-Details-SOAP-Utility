package nike1421.countryinfo.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CountryInfoUtilityUI {
	JFrame mainUIFrame;
	JLabel titleLabel;
	JPanel componentPanel;
	
	JButton retrieveResultsButton;
	JLabel inputLabel;
	JComboBox continentComboBox;
	JComboBox countryComboBox;
	
	JPanel countryFlagPanel;
	JLabel countryNameLabel;
	
	JLabel countryCapitalLabel;
	JLabel countryCapitalResultLabel;
	
	JLabel countryContinentLabel;
	JLabel countryContinentResultLabel;
	
	JLabel countryPhoneCodeLabel;
	JLabel countryPhoneCodeResultLabel;
	
	JLabel countryISOCodeLabel;
	JLabel countryISOCodeResultLabel;
	
	JLabel countryCurrencyLabel;
	JLabel countryCurrencyResultLabel;
	
	JLabel countryLanguageLabel;
	JLabel countryLanguageResultLabel;
	
	public CountryInfoUtilityUI() {
		// Set the main application frame
		mainUIFrame = new JFrame("SOAP Retrieval Utility");
		mainUIFrame.setSize(800, 560);
		mainUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainUIFrame.setResizable(false);
		
		// The JPanel where all the widgets will be placed
		componentPanel = new JPanel();
		componentPanel.setLayout(null);
		mainUIFrame.setContentPane(componentPanel);
		
		// Title Widget for the application
		titleLabel = new JLabel("Country SOAP Detail Extractor");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 35));
		titleLabel.setBounds(30, 30, 740 , 35);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		componentPanel.add(titleLabel);
		
		// Instruction Label
		inputLabel = new JLabel("Select Continent and Country: ");
		inputLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		inputLabel.setBounds(30, 100, 250, 15);
		inputLabel.setHorizontalAlignment(JLabel.CENTER);
		componentPanel.add(inputLabel);
		
		// ComboBox for selecting continent
		continentComboBox = new JComboBox();
		continentComboBox.setBounds(300, 102, 150, 15);
		continentComboBox.setEditable(false);
		componentPanel.add(continentComboBox);
		
		// ComboBox for selecting Country
		countryComboBox = new JComboBox();
		countryComboBox.setBounds(480, 102, 150, 15);
		countryComboBox.setEditable(false);
		componentPanel.add(countryComboBox);
		
		mainUIFrame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		CountryInfoUtilityUI countryInfoUtilityUI = new CountryInfoUtilityUI();
	}
	
}
