package nike1421.countryinfo.ui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import nike1421.countryinfo.controller.Continent;
import nike1421.countryinfo.controller.CountryInfoSOAPClient;
import nike1421.countryinfo.controller.SOAPResponsePOJO;

public class CountryInfoUtilityUI {
	JFrame mainUIFrame;
	JLabel titleLabel;
	JPanel componentPanel;

	JButton retrieveResultsButton;
	JLabel inputLabel;
	JComboBox<String> continentComboBox;
	JComboBox<String> countryComboBox;

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

	Continent africaContinent;
	Continent asiaContinent;
	Continent australiaContinent;
	Continent americaContinent;
	Continent europeContinent;
	Continent antarcticaContinent;

	String continent[] = { "-----", "Africa", "The Americas", "Antarctica", "Asia", "Europe", "Australia" };

	public CountryInfoUtilityUI() {

		declareAllCountries();

		// Set the main application frame
		mainUIFrame = new JFrame("SOAP Retrieval Utility");
		mainUIFrame.setSize(500, 500);
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
		inputLabel.setBounds(15, 85, 180, 15);
		inputLabel.setHorizontalAlignment(JLabel.CENTER);
		componentPanel.add(inputLabel);

		// ComboBox for selecting continent
		continentComboBox = new JComboBox<String>(continent);
		continentComboBox.setBounds(210, 87, 105, 15);
		continentComboBox.setEditable(false);
		continentComboBox.setSelectedItem("HIII");
		continentComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Remove all items from the ComboBox
				countryComboBox.removeAllItems();

				// Enable the ComboBox
				countryComboBox.setEnabled(true);

				// Depending on selected continent, populate the country ComboBox
				switch (continentComboBox.getSelectedItem().toString()) {
				case "Africa":
					countryComboBox.setModel(new DefaultComboBoxModel<String>(africaContinent.getCountryStrings()));
					break;
				case "The Americas":
					countryComboBox.setModel(new DefaultComboBoxModel<String>(americaContinent.getCountryStrings()));
					break;
				case "Asia":
					countryComboBox.setModel(new DefaultComboBoxModel<String>(asiaContinent.getCountryStrings()));
					break;
				case "Europe":
					countryComboBox.setModel(new DefaultComboBoxModel<String>(europeContinent.getCountryStrings()));
					break;
				case "Australia":
					countryComboBox.setModel(new DefaultComboBoxModel<String>(australiaContinent.getCountryStrings()));
					break;
				case "Antarctica":
					countryComboBox.setModel(new DefaultComboBoxModel<String>(antarcticaContinent.getCountryStrings()));
					break;
				default:
					countryComboBox.setEnabled(false);
				}
			}
		});
		componentPanel.add(continentComboBox);

		// ComboBox for selecting Country
		countryComboBox = new JComboBox<String>();
		countryComboBox.setBounds(330, 87, 135, 15);
		countryComboBox.setEditable(false);
		countryComboBox.setEnabled(false);
		componentPanel.add(countryComboBox);

		// Widgets on the third row

		// Add button to invoke web service
		retrieveResultsButton = new JButton("Invoke");
		retrieveResultsButton.setBounds(175, 120, 150, 20);
		retrieveResultsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the index of the selected country from the country ComboBox
				int selectedCountry = countryComboBox.getSelectedIndex();
				
				// Get the ISO Code of the country using the index
				String isoCodeSelectedCountryString = null;
				
				switch (continentComboBox.getSelectedItem().toString()) {
				case "Africa":
					isoCodeSelectedCountryString = africaContinent.getCountryISOStrings().get(selectedCountry);
					break;
				case "The Americas":
					isoCodeSelectedCountryString = americaContinent.getCountryISOStrings().get(selectedCountry);
					break;
				case "Asia":
					isoCodeSelectedCountryString = asiaContinent.getCountryISOStrings().get(selectedCountry);
					break;
				case "Europe":
					isoCodeSelectedCountryString = europeContinent.getCountryISOStrings().get(selectedCountry);
					break;
				case "Australia":
					isoCodeSelectedCountryString = australiaContinent.getCountryISOStrings().get(selectedCountry);
					break;
				case "Antarctica":
					isoCodeSelectedCountryString = antarcticaContinent.getCountryISOStrings().get(selectedCountry);
					break;
				default:
					JOptionPane.showMessageDialog(null, "ISO Code Not Found");
				}
				
				// Set Response Object
				SOAPResponsePOJO soapResponse = null;
				
				// Call SOAP API HERE
				try {
					// Get Response from Web Service
					soapResponse = CountryInfoSOAPClient.callSoapWebService(isoCodeSelectedCountryString);
					
					// Set Flag Image
					URL imageUrl = new URL(soapResponse.getCountryFlagUrl().replaceAll(" ", "%20"));
					Image flagImage = ImageIO.read(imageUrl);
					countryFlagLabel.setIcon(new ImageIcon(flagImage));
					
					// Set Results Labels
					countryNameLabel.setText(soapResponse.getCountryName());
					countryPhoneCodeResultLabel.setText(soapResponse.getCountryPhoneCode());
					countryCapitalResultLabel.setText(soapResponse.getCountryCapital());
					countryContinentResultLabel.setText(continentComboBox.getSelectedItem().toString());
					countryISOCodeResultLabel.setText(soapResponse.getCountryISOCode());
					countryLanguageResultLabel.setText(soapResponse.getCountryLanguage());
					countryCurrencyResultLabel.setText(soapResponse.getCurrency());
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
			}
		});
		componentPanel.add(retrieveResultsButton);

		// Add Separator for aesthetics
		JSeparator horizontalSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		horizontalSeparator.setBounds(10, 150, 460, 2);
		componentPanel.add(horizontalSeparator);

		// Widgets on the fourth row

		// Add the Country Flag Panel
		countryFlagLabel = new JLabel();
		countryFlagLabel.setIcon(
				new ImageIcon("./src/images/Flag.png"));
		countryFlagLabel.setBounds(150, 160, 200, 126);
		componentPanel.add(countryFlagLabel);

		// Add Country Name Label
		countryNameLabel = new JLabel();
		countryNameLabel.setText("");
		countryNameLabel.setFont(new Font("Serif", Font.BOLD, 25));
		countryNameLabel.setBounds(30, 300, 440, 45);
		countryNameLabel.setHorizontalAlignment(JLabel.CENTER);
		componentPanel.add(countryNameLabel);

		// Widgets on the fifth row

		// Add Capital Labels
		countryCapitalLabel = new JLabel();
		countryCapitalLabel.setText("Capital: ");
		countryCapitalLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCapitalLabel.setBounds(30, 360, 85, 15);
		componentPanel.add(countryCapitalLabel);

		countryCapitalResultLabel = new JLabel();
		countryCapitalResultLabel.setText("");
		countryCapitalResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCapitalResultLabel.setBounds(145, 360, 85, 15);
		componentPanel.add(countryCapitalResultLabel);

		// Add Continent Labels
		countryContinentLabel = new JLabel();
		countryContinentLabel.setText("Continent");
		countryContinentLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryContinentLabel.setBounds(270, 360, 85, 15);
		componentPanel.add(countryContinentLabel);

		countryContinentResultLabel = new JLabel();
		countryContinentResultLabel.setText("");
		countryContinentResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryContinentResultLabel.setBounds(385, 360, 85, 15);
		componentPanel.add(countryContinentResultLabel);

		// Widgets on the sixth row

		// Add Phone Code Labels
		countryPhoneCodeLabel = new JLabel();
		countryPhoneCodeLabel.setText("Phone Code");
		countryPhoneCodeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryPhoneCodeLabel.setBounds(30, 390, 85, 15);
		componentPanel.add(countryPhoneCodeLabel);

		countryPhoneCodeResultLabel = new JLabel();
		countryPhoneCodeResultLabel.setText("");
		countryPhoneCodeResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryPhoneCodeResultLabel.setBounds(145, 390, 85, 15);
		componentPanel.add(countryPhoneCodeResultLabel);

		// Add ISO Code Labels
		countryISOCodeLabel = new JLabel();
		countryISOCodeLabel.setText("ISO Code");
		countryISOCodeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryISOCodeLabel.setBounds(270, 390, 85, 15);
		componentPanel.add(countryISOCodeLabel);

		countryISOCodeResultLabel = new JLabel();
		countryISOCodeResultLabel.setText("");
		countryISOCodeResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryISOCodeResultLabel.setBounds(385, 390, 85, 15);
		componentPanel.add(countryISOCodeResultLabel);

		// Widgets on the seventh row

		// Add Currency Labels
		countryCurrencyLabel = new JLabel();
		countryCurrencyLabel.setText("Currency");
		countryCurrencyLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCurrencyLabel.setBounds(30, 420, 85, 15);
		componentPanel.add(countryCurrencyLabel);

		countryCurrencyResultLabel = new JLabel();
		countryCurrencyResultLabel.setText("");
		countryCurrencyResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryCurrencyResultLabel.setBounds(145, 420, 85, 15);
		componentPanel.add(countryCurrencyResultLabel);

		// Add Language Labels
		countryLanguageLabel = new JLabel();
		countryLanguageLabel.setText("Language");
		countryLanguageLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryLanguageLabel.setBounds(270, 420, 85, 15);
		componentPanel.add(countryLanguageLabel);

		countryLanguageResultLabel = new JLabel();
		countryLanguageResultLabel.setText("");
		countryLanguageResultLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		countryLanguageResultLabel.setBounds(385, 420, 85, 15);
		componentPanel.add(countryLanguageResultLabel);

		// Set the main frame visible
		mainUIFrame.setVisible(true);
	}

	public void declareAllCountries() {
		String africaCountries[] = { "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi",
				"C\u00f4te D'Ivoire (Ivory Coast)", "Cameroon", "Cape Verde", "Central African Republic", "Chad",
				"Comoros", "Congo", "Congo, Democratic Republic", "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea",
				"Ethiopia", "Gabon", "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho", "Liberia",
				"Libyan Arab Jamahiriya", "Madagascar", "Malawi", "Mali", "Mauritania", "Mauritius", "Mayotte",
				"Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Reunion", "Rwanda", "Sao Tome & Principe",
				"Senegal", "Seychelles", "Sierra Leone", "Somalia", "South Africa", "Sudan", "Swaziland", "Tanzania",
				"Togo", "Tunisia", "Uganda", "Western Sahara", "Zambia", "Zimbabwe" };
		ArrayList<String> africaISO = new ArrayList<String>(Arrays.asList("DZ", "AO", "BJ", "BW", "BF", "BI", "CI",
				"CM", "CV", "CF", "TD", "KM", "CG", "CD", "DJ", "EG", "GQ", "ER", "ET", "GA", "GM", "GH", "GN", "GW",
				"KE", "LS", "LR", "LY", "MG", "MW", "ML", "MR", "MU", "YT", "MA", "MZ", "NA", "NE", "NG", "RE", "RW",
				"ST", "SN", "SC", "SL", "SO", "ZA", "SD", "SZ", "TZ", "TG", "TN", "UG", "EH", "ZM", "ZW"));
		africaContinent = new Continent("Africa", africaCountries, africaISO);

		String asiaCountries[] = { "Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan",
				"British Indian Ocean Territory", "Brunei-Darussalam", "Cambodia", "China", "Cyprus", "Georgia",
				"Hong Kong", "India", "Indonesia", "Iran", "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Kuwait",
				"Kyrgyzstan", "Laos", "Lebanon", "Macao", "Malaysia", "Maldives (Maladive Ilands)", "Mongolia",
				"Myanmar (Burma)", "Nepal", "North Korea", "Oman", "Pakistan", "Palestinian Territory, Occupied",
				"Philippines", "Quatar", "Russian Federation", "Saudi Arabia", "Singapore", "South Korea", "Sri Lanka",
				"Syrian Arab Republic", "Taiwan", "Tajikistan", "Thailand", "Timor-Leste", "Turkey", "Turkmenistan",
				"United Arab Emirates", "Uzbekistan", "Vietnam", "Yemen" };
		ArrayList<String> asiaISO = new ArrayList<>(Arrays.asList("AF", "AM", "AZ", "BH", "BD", "BT", "IO", "BN", "KH",
				"CN", "CY", "GE", "HK", "IN", "ID", "IR", "IQ", "IL", "JP", "JO", "KZ", "KW", "KG", "LA", "LB", "MO",
				"MY", "MV", "MN", "MM", "NP", "KP", "OM", "PK", "PS", "PH", "QA", "RU", "SA", "SG", "KR", "LK", "SY",
				"TW", "TJ", "TH", "TL", "TR", "TM", "AE", "UZ", "VN", "YE"));
		asiaContinent = new Continent("Asia", asiaCountries, asiaISO);

		String antarcticaCountries[] = { "Antarctica", "Bouvet Island", "French Southern Territories" };
		ArrayList<String> antarcticaISO = new ArrayList<>(Arrays.asList("AQ", "BV", "TF"));
		antarcticaContinent = new Continent("Antarctica", antarcticaCountries, antarcticaISO);

		String americaCountries[] = { "Anguilla", "Antigua & Barbuda", "Argentina", "Aruba", "Bahamas", "Barbados",
				"Belize", "Bermuda", "Bolivia", "Bonaire, Sint Eustatius and Saba", "Brazil", "Canada",
				"Cayman Islands", "Chile", "Collectivity of Saint Martin", "Colombia", "Costa Rica", "Cuba",
				"Cura\u00e7ao", "Dominica", "Dominican Republic", "Ecuador", "El Salvador",
				"Falkand Islands (Malvinas)", "French Guiana", "Grenada", "Guadeloupe", "Guatemala", "Guyana", "Haiti",
				"Honduras", "Jamaica", "Martinique", "Mexico", "Montserrat", "Netherlands Antilles", "Nicaragua",
				"Panama", "Paraguay", "Peru", "Puerto Rico", "Saint Barth\u00e9lemy",
				"Saint Helena, Ascension and Tristan da Cunha", "Saint Pierre And Micquelon", "Sint-Maarten",
				"South Georgia & South Sandwich Islands", "St. Kitts & Nevis", "St. Lucia", "St. Vincent & Grenadines",
				"Suriname", "Trinidad & Tobago", "Turks And Caicos Islands", "United States", "Uruguay", "Venezuela",
				"Virgin Islands, British", "Virgin Islands, U.S." };
		ArrayList<String> americaISO = new ArrayList<>(Arrays.asList("AI", "AG", "AR", "AW", "BS", "BB", "BZ", "BM",
				"BO", "BQ", "BR", "CA", "KY", "CL", "MF", "CO", "CR", "CU", "CW", "DM", "DO", "EC", "SV", "FK", "GF",
				"GD", "GP", "GT", "GY", "HT", "HN", "JM", "MQ", "MX", "MS", "AN", "NI", "PA", "PY", "PE", "PR", "BL",
				"SH", "PM", "SX", "GS", "KN", "LC", "VC", "SR", "TT", "TC", "US", "UY", "VE", "VG", "VI"));
		americaContinent = new Continent("The Americas", americaCountries, americaISO);

		String europeCountries[] = { "\u00c5land Islands", "Albania", "Andorra", "Austria", "Belarus", "Belgium",
				"Bosnia & Herzegovina", "Bulgaria", "Croatia", "Czech Republic", "Denmark", "Estonia", "Faroe Islands",
				"Finland", "France", "Germany", "Gibraltar", "Greece", "Greenland", "Hungary", "Iceland", "Ireland",
				"Italy", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia  (former YR)", "Malta",
				"Moldova, Republic of", "Monaco", "Montenegro", "Netherlands", "Norway", "Poland", "Portugal",
				"Romania", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Svalbard And Jan Mayen", "Sweden",
				"Switzerland", "Ukraine", "United Kingdom", "Vatican City" };
		ArrayList<String> europeISO = new ArrayList<>(Arrays.asList("AX", "AL", "AD", "AT", "BY", "BE", "BA", "BG",
				"HR", "CZ", "DK", "EE", "FO", "FI", "FR", "DE", "GI", "GR", "GL", "HU", "IS", "IE", "IT", "LV", "LI",
				"LT", "LU", "MK", "MT", "MD", "MC", "ME", "NL", "NO", "PL", "PT", "RO", "SM", "RS", "SK", "SI", "ES",
				"SJ", "SE", "CH", "UA", "GB", "VA"));
		europeContinent = new Continent("Europe", europeCountries, europeISO);

		String australiaCountries[] = { "American Samoa", "Australia", "Chrismas Island", "Cocos (Keeling) Islands",
				"Cook Islands", "Fiji", "French Polynesia", "Guam", "Heard Island And McDonald Islands", "Kiribati",
				"Marshall Islands", "Micronesia  (Federa States of)", "Nauru", "New Caledonia", "New Zealand", "Niue",
				"Norfolk Island", "Northern Mariana Islands", "Palau", "Papua-New Guinea", "Pitcairn",
				"Solomon Islands", "Tokelau", "Tonga", "Tuvalu", "United States Minor Outlying Islands", "Vanuatu",
				"Wallis And Futuna", "Western Samoa" };
		ArrayList<String> australiaISO = new ArrayList<>(
				Arrays.asList("AS", "AU", "CX", "CC", "CK", "FJ", "PF", "GU", "HM", "KI", "MH", "FM", "NR", "NC", "NZ",
						"NU", "NF", "MP", "PW", "PG", "PN", "SB", "TK", "TO", "TV", "UM", "VU", "WF", "WS"));
		australiaContinent = new Continent("Australia", australiaCountries, australiaISO);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CountryInfoUtilityUI countryInfoUtilityUI = new CountryInfoUtilityUI();
	}

}
