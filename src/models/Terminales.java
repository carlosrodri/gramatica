package models;

import constants.ConstantsUI;

public class Terminales {
	
	private String simbolo;
	
	public Terminales(String simbolo) throws Exception {
		if (simbolo.codePointAt(0) >= 97 && simbolo.codePointAt(0) <= 122 || simbolo.codePointAt(0) >= 48 && simbolo.codePointAt(0) <= 57) {
			this.simbolo = simbolo;
		} else {
			throw new Exception(ConstantsUI.SIMBOLO_TERMINAL_NO_VALIDO);
		}
	}

	public String getSimbolo() {
		return simbolo;
	}
	
	@Override
	public String toString() {
		return  simbolo;
	}
}
