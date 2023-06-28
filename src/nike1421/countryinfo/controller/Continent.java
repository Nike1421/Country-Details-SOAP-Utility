package nike1421.countryinfo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Continent {
	private String name;
	private String[] countryStrings;
	private List<String> countryISOStrings;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getCountryStrings() {
		return countryStrings;
	}

	public void setCountryStrings(String[] countryStrings) {
		this.countryStrings = countryStrings;
	}

	public Continent(String name, String[] countries, ArrayList<String> isos) {
		this.name = name;
		this.countryStrings = countries;
		this.countryISOStrings = isos;
	}

	public List<String> getCountryISOStrings() {
		return countryISOStrings;
	}

	public void setCountryISOStrings(List<String> countryISOStrings) {
		this.countryISOStrings = countryISOStrings;
	}
}
