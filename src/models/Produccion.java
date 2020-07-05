package models;

import utilities.Validador;

public class Produccion {
	
	private NoTerminales noTerminales;
	private String igualador;
	private String cuerpo;
	
	public Produccion(NoTerminales noTerminales, String igualador, String cuerpo) {
		this.noTerminales = noTerminales;
		this.igualador = igualador;
		this.cuerpo = cuerpo;
	}
	
	public boolean validarProduccion() {
		System.out.println(cuerpo + " cuerpo de la produccion");
		return Validador.validarProduccion(noTerminales.getSimbolo()+igualador+cuerpo);
	}
	
	public NoTerminales getNoTerminales() {
		return noTerminales;
	}
	public String getIgualador() {
		return igualador;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	
	@Override
	public String toString() {
		return "Produccion [noTerminales=" + noTerminales + ", igualador=" + igualador + ", cuerpo=" + cuerpo + "]";
	}
	

}
