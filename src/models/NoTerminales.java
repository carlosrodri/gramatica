package models;

import java.util.ArrayList;

import constants.ConstantsUI;

public class NoTerminales {


	private String simbolo;
	private ArrayList<String> cuerpo;

	public NoTerminales(String simbolo) throws Exception {
		this.cuerpo = new ArrayList<>();
		if (simbolo.codePointAt(0) >= 65 && simbolo.codePointAt(0) <= 90 ) {
			this.simbolo = simbolo;
		} else {
			throw new Exception(ConstantsUI.SIMBOLO_NO_TERMINAL_NO_VALIDO);
		}
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void agregarCuerpo(String cuerpo, String acarreo) {
		if (cuerpo.contains("|")) {
			String[] p = cuerpo.split("\\|");
			for (int i = 0; i < p.length; i++) {
				this.cuerpo.add(acarreo + p[i]);
			}
		} else {
			this.cuerpo.add(acarreo + cuerpo);
		}
	}

	public ArrayList<String> getCuerpo() {
		return this.cuerpo;
	}

	@Override
	public String toString() {
		return "NoTerminales [simbolo=" + simbolo + ", cuerpo=" + cuerpo + "]";
	}

}
