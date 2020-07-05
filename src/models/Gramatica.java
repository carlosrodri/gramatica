package models;

import java.util.ArrayList;

import utilities.Validador;

public class Gramatica {
	private ArrayList<Terminales> terminales;
	private ArrayList<NoTerminales> noTerminales;
	private ArrayList<Produccion> producciones;
	private String sterminales,  snoTerminales, sproducciones;

	public Gramatica(String terminales, String noTerminales) throws Exception {
		this.sterminales = terminales;
		this.snoTerminales = noTerminales;
		
		this.terminales = new ArrayList<>();
		this.noTerminales = new ArrayList<>();
		this.producciones = new ArrayList<>();
		
		generarGramatica();
	}

	public void generarGramatica() throws Exception {
		agregarTerminales();
		agregarNoTerminales();
	}

	public void agregarNoTerminales() throws Exception {
		String [] partes = snoTerminales.split(",");
		for (int i = 0; i < partes.length; i++) {
			noTerminales.add(new NoTerminales(partes[i]));
		}
	}

	public void agregarTerminales() throws Exception {
		String [] partes = sterminales.split(",");
		for (int i = 0; i < partes.length; i++) {
			terminales.add(new Terminales(partes[i]));
		}
	}

	public boolean agregarProducciones(CharSequence produccion) throws Exception {
		this.sproducciones = (String) produccion;
		if (Validador.validarProduccion(produccion)) {
			String [] partes = sproducciones.split(",");
			for (int i = 0; i < partes.length; i++) {
				producciones.add(new Produccion(new NoTerminales(partes[i].substring(0,1)), partes[i].substring(1,2), partes[i].substring(2,partes[i].length())));
			}
			return true;
		} else {
			throw new Exception("La Producción no es váida");
		}
	}
	
	public ArrayList<NoTerminales> getNoTerminales() {
		return noTerminales;
	}
	
	public ArrayList<Terminales> getTerminales() {
		return terminales;
	}

}
