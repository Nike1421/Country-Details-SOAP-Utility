package nike1421.countryinfo.controller;

import java.util.ArrayList;
import java.util.List;

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
