package models;

import java.util.ArrayList;

public class Nivel {

	private String nombre;
	private ArrayList<NoTerminales> noTerminales;

	public Nivel(String nombre) {
		this.nombre = nombre;
		this.noTerminales = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void agregarNoTerminales(NoTerminales noTerminales) {
		this.noTerminales.add(noTerminales);
	}
	
	public ArrayList<NoTerminales> getNoTerminales() {
		return noTerminales;
	}

}