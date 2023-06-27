package nike1421.countryinfo.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
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
		mainUIFrame.setSize(500, 400);
		mainUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainUIFrame.setResizable(false);

		// The JPanel where all the widgets will be placed
		componentPanel = new JPanel();
		componentPanel.setLayout(null);
		mainUIFrame.setContentPane(componentPanel);

		// Title Widget for the application
		titleLabel = new JLabel("Country SOAP Detail Extractor");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 35));
		titleLabel.setBounds(30, 30, 700, 35);
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

		// Add the Country Flag Panel
		countryFlagLabel = new JLabel();
		countryFlagLabel.setIcon(new ImageIcon("D:\\Code Files\\Java Codes\\Java Spring Wksp\\CountryInfo\\src\\images\\India.jpg"));
		countryFlagLabel.setBounds(30, 130, 200, 126);
		componentPanel.add(countryFlagLabel);
		
		// Add Country Name Label
		countryNameLabel = new JLabel();
		countryNameLabel.setText("India");
		countryNameLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryNameLabel.setBounds(400, 130, 80, 15);
		componentPanel.add(countryNameLabel);
		
		// Add Capital Labels
		countryCapitalLabel = new JLabel();
		countryCapitalLabel.setText("Capital: ");
		countryCapitalLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCapitalLabel.setBounds(30, 270, 80, 15);
		componentPanel.add(countryCapitalLabel);
		
		countryCapitalResultLabel = new JLabel();
		countryCapitalResultLabel.setText("New Delhi");
		countryCapitalResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCapitalResultLabel.setBounds(200, 270, 80, 15);
		componentPanel.add(countryCapitalResultLabel);

		
		countryContinentLabel = new JLabel();
		countryContinentLabel.setText("Continent");
		countryContinentLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryContinentLabel.setBounds(300, 270, 80, 15);
		componentPanel.add(countryContinentLabel);

		countryContinentResultLabel = new JLabel();
		countryContinentResultLabel.setText("Asia");
		countryContinentResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryContinentResultLabel.setBounds(400, 270, 80, 15);
		componentPanel.add(countryContinentResultLabel);
		
		
		countryPhoneCodeLabel = new JLabel();
		countryPhoneCodeLabel.setText("Phone Code");
		countryPhoneCodeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryPhoneCodeLabel.setBounds(30, 300, 80, 15);
		componentPanel.add(countryPhoneCodeLabel);
		
		countryPhoneCodeResultLabel = new JLabel();
		countryPhoneCodeResultLabel.setText("+91");
		countryPhoneCodeResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryPhoneCodeResultLabel.setBounds(200, 300, 80, 15);
		componentPanel.add(countryPhoneCodeResultLabel);
		
		
		countryCurrencyLabel = new JLabel();
		countryCurrencyLabel.setText("Currency");
		countryCurrencyLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCurrencyLabel.setBounds(300, 300, 80, 15);
		componentPanel.add(countryCurrencyLabel);
		
		countryCurrencyResultLabel = new JLabel();
		countryCurrencyResultLabel.setText("Indian Rupee");
		countryCurrencyResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCurrencyResultLabel.setBounds(400, 300, 80, 15);
		componentPanel.add(countryCurrencyResultLabel);
		
		
		countryISOCodeLabel = new JLabel();
		countryISOCodeLabel.setText("ISO Code");
		countryISOCodeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryISOCodeLabel.setBounds(30, 330, 80, 15);
		componentPanel.add(countryISOCodeLabel);
		
		countryISOCodeResultLabel = new JLabel();
		countryISOCodeResultLabel.setText("IN");
		countryISOCodeResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryISOCodeResultLabel.setBounds(200, 330, 80, 15);
		componentPanel.add(countryISOCodeResultLabel);
		
		countryLanguageLabel = new JLabel();
		countryLanguageLabel.setText("Language");
		countryLanguageLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryLanguageLabel.setBounds(300, 330, 80, 15);
		componentPanel.add(countryLanguageLabel);
		
		countryLanguageResultLabel = new JLabel();
		countryLanguageResultLabel.setText("Hindi");
		countryLanguageResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryLanguageResultLabel.setBounds(400, 330, 80, 15);
		componentPanel.add(countryLanguageResultLabel);

		
		mainUIFrame.setVisible(true);
	}

	public static void main(String[] args) {
		CountryInfoUtilityUI countryInfoUtilityUI = new CountryInfoUtilityUI();
	}

}
