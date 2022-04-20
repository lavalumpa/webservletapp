package it.engineering.web.test.verificator;

import javax.servlet.http.HttpServletRequest;

public class ProducerFieldsValidator {
	
	
	private String invalidPib;
	private String invalidMaticniBroj;
	private String invalidAdresa;
	
	
	
	
	private boolean isValidMaticniBroj(String data) {
		return data != null && Validator.isAllDigitString(data) && Validator.isLength(data, 13);
	}
	
	private boolean isValidPib(String data) {
		return data != null && Validator.isAllDigitString(data) && Validator.isLength(data, 8);	
	}
	
	private boolean isValidAdressa(String data) {
		return data != null && Validator.isEmpty(data) && Validator.isMaxLength(data, 50);
	}
	
	
	public void validate(HttpServletRequest request) {
		String pib =request.getParameter("pib");
		String matBroj =request.getParameter("maticniBroj");
		String adresa = request.getParameter("adresa");
		if (!isValidPib(pib)) {
			invalidPib="Pib has to be 8 characters";
		}
		if (!isValidMaticniBroj(matBroj)) {
			invalidMaticniBroj="Maticni Broj has to be 13 characters";
		}
		if(!isValidAdressa(adresa)) {
			invalidAdresa="Adresa can't be empty and up to 50 characters";
		}
		
	}
}
