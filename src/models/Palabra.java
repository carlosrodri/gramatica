package models;

import java.util.ArrayList;

public class Palabra {
	private ArrayList<Terminales> palabra;
	
	public Palabra(String palabra) throws Exception {
		this.palabra = new ArrayList<>();
		
		for (int i = 0; i < palabra.length(); i++) {
			this.palabra.add(new Terminales(String.valueOf(palabra.charAt(i))));
		}
	}

	public ArrayList<Terminales> getPalabra() {
		return palabra;
	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + "]";
	}
	
}
