package nike1421.countryinfo.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SOAPResponsePOJO {
	private String countryISOCode;
	private String countryName;
	private String countryCapital;
	private String countryPhoneCode;
	private String contintent;
	private String currency;
	private String countryFlagUrl;
	private String countryLangauge;

	public SOAPResponsePOJO(String countryISOCode, String countryName, String countryCapital, String countryPhoneCode,
			String contintent, String currency, String countryFlagUrl) {
		this.countryISOCode = countryISOCode;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
		this.countryPhoneCode = countryPhoneCode;
		this.contintent = contintent;
		this.currency = currency;
		this.countryFlagUrl = countryFlagUrl;
	}
}
