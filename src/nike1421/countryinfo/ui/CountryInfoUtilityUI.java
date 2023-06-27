package nike1421.countryinfo.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CountryInfoUtilityUI {
	JFrame mainUIFrame;
	JLabel inputLabel;
	JPanel componentPanel;
	JButton retrieveResultsButton;
	JComboBox countinentComboBox;
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
		mainUIFrame = new JFrame("SOAP Retrieval Utility");
		mainUIFrame.setSize(800, 560);
		mainUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainUIFrame.setResizable(false);
		
		componentPanel = new JPanel();
		componentPanel.setLayout(null);
		mainUIFrame.setContentPane(componentPanel);
		
		mainUIFrame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		CountryInfoUtilityUI countryInfoUtilityUI = new CountryInfoUtilityUI();
	}
	
}
