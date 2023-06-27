package nike1421.countryinfo.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class CountryInfoUtilityUI {
	JFrame mainUIFrame;
	JLabel titleLabel;
	JPanel componentPanel;

	JButton retrieveResultsButton;
	JLabel inputLabel;
	JComboBox continentComboBox;
	JComboBox countryComboBox;

	JLabel countryFlagLabel;
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
		mainUIFrame.setSize(500, 475);
		mainUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainUIFrame.setResizable(false);

		// The JPanel where all the widgets will be placed
		componentPanel = new JPanel();
		componentPanel.setLayout(null);
		mainUIFrame.setContentPane(componentPanel);

		// Widgets on the first row
		
		// Title Widget for the application
		titleLabel = new JLabel("Country SOAP Detail Extractor");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
		titleLabel.setBounds(30, 30, 440, 35);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		componentPanel.add(titleLabel);

		// Widgets on the second row
		
		// Instruction Label
		inputLabel = new JLabel("Select Continent and Country: ");
		inputLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		inputLabel.setBounds(30, 85, 200, 15);
		inputLabel.setHorizontalAlignment(JLabel.CENTER);
		componentPanel.add(inputLabel);

		// ComboBox for selecting continent
		continentComboBox = new JComboBox();
		continentComboBox.setBounds(245, 87, 90, 15);
		continentComboBox.setEditable(false);
		componentPanel.add(continentComboBox);

		// ComboBox for selecting Country
		countryComboBox = new JComboBox();
		countryComboBox.setBounds(350, 87, 100, 15);
		countryComboBox.setEditable(false);
		componentPanel.add(countryComboBox);

		// Widgets on the third row
		
		// Add button to invoke web service
		retrieveResultsButton = new JButton("Invoke");
		retrieveResultsButton.setBounds(175, 120, 150, 20);
		componentPanel.add(retrieveResultsButton);
		
		// Add Separator for aesthetics
		JSeparator horizontalSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		horizontalSeparator.setBounds(10, 150, 460, 2);
		componentPanel.add(horizontalSeparator);
		
		// Widgets on the fourth row
		
		// Add the Country Flag Panel
		countryFlagLabel = new JLabel();
		countryFlagLabel.setIcon(new ImageIcon("D:\\Code Files\\Java Codes\\Java Spring Wksp\\CountryInfo\\src\\images\\India.jpg"));
		countryFlagLabel.setBounds(50, 160, 200, 126);
		componentPanel.add(countryFlagLabel);
		
		// Add Country Name Label
		countryNameLabel = new JLabel();
		countryNameLabel.setText("India");
		countryNameLabel.setFont(new Font("Serif", Font.BOLD, 45));
		countryNameLabel.setBounds(310, 200, 150, 45);
		componentPanel.add(countryNameLabel);
		
		// Widgets on the fifth row
		
		// Add Capital Labels
		countryCapitalLabel = new JLabel();
		countryCapitalLabel.setText("Capital: ");
		countryCapitalLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCapitalLabel.setBounds(30, 315, 85, 15);
		componentPanel.add(countryCapitalLabel);
		
		countryCapitalResultLabel = new JLabel();
		countryCapitalResultLabel.setText("New Delhi");
		countryCapitalResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCapitalResultLabel.setBounds(145, 315, 85, 15);
		componentPanel.add(countryCapitalResultLabel);

		// Add Continent Labels
		countryContinentLabel = new JLabel();
		countryContinentLabel.setText("Continent");
		countryContinentLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryContinentLabel.setBounds(270, 315, 85, 15);
		componentPanel.add(countryContinentLabel);

		countryContinentResultLabel = new JLabel();
		countryContinentResultLabel.setText("Asia");
		countryContinentResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryContinentResultLabel.setBounds(385, 315, 85, 15);
		componentPanel.add(countryContinentResultLabel);
		
		// Widgets on the sixth row
		
		// Add Phone Code Labels
		countryPhoneCodeLabel = new JLabel();
		countryPhoneCodeLabel.setText("Phone Code");
		countryPhoneCodeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryPhoneCodeLabel.setBounds(30, 345, 85, 15);
		componentPanel.add(countryPhoneCodeLabel);
		
		countryPhoneCodeResultLabel = new JLabel();
		countryPhoneCodeResultLabel.setText("+91");
		countryPhoneCodeResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryPhoneCodeResultLabel.setBounds(145, 345, 85, 15);
		componentPanel.add(countryPhoneCodeResultLabel);
		
		// Add ISO Code Labels
		countryISOCodeLabel = new JLabel();
		countryISOCodeLabel.setText("ISO Code");
		countryISOCodeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryISOCodeLabel.setBounds(270, 345, 85, 15);
		componentPanel.add(countryISOCodeLabel);
		
		countryISOCodeResultLabel = new JLabel();
		countryISOCodeResultLabel.setText("IN");
		countryISOCodeResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryISOCodeResultLabel.setBounds(385, 345, 85, 15);
		componentPanel.add(countryISOCodeResultLabel);
		
		// Widgets on the seventh row
		
		// Add Currency Labels
		countryCurrencyLabel = new JLabel();
		countryCurrencyLabel.setText("Currency");
		countryCurrencyLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCurrencyLabel.setBounds(30, 375, 85, 15);
		componentPanel.add(countryCurrencyLabel);
		
		countryCurrencyResultLabel = new JLabel();
		countryCurrencyResultLabel.setText("Indian Rupee");
		countryCurrencyResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCurrencyResultLabel.setBounds(145, 375, 85, 15);
		componentPanel.add(countryCurrencyResultLabel);
		
		// Add Language Labels
		countryLanguageLabel = new JLabel();
		countryLanguageLabel.setText("Language");
		countryLanguageLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryLanguageLabel.setBounds(270, 375, 85, 15);
		componentPanel.add(countryLanguageLabel);
		
		countryLanguageResultLabel = new JLabel();
		countryLanguageResultLabel.setText("Hindi");
		countryLanguageResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryLanguageResultLabel.setBounds(385, 375, 85, 15);
		componentPanel.add(countryLanguageResultLabel);

		// Set the main frame visible
		mainUIFrame.setVisible(true);
	}

	public static void main(String[] args) {
		CountryInfoUtilityUI countryInfoUtilityUI = new CountryInfoUtilityUI();
	}

}
