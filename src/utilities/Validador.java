package utilities;

import java.util.regex.Pattern;

import models.NoTerminales;

public class Validador {
	private static String expresionProduccion = "^[A-Z][=]{1}[\\w]*[[|][\\w]]*|^[A-Z][=]{1}[\\w]*";
	private static String expresionPralabra = "[\\w][^A-Z]*|[\\w]*";
	
	public static boolean validarProduccion(CharSequence entrada) {
		boolean opcion = false;
		Pattern pattern = Pattern.compile(expresionProduccion);
		String[] partes = String.valueOf(entrada).split(",");
		for (int i = 0; i < partes.length; i++) {
			opcion = Pattern.matches(pattern.toString(), partes[i]);
		}
		return opcion;
	}


	public static boolean ValidarPalabra(CharSequence entrada) {
		Pattern pattern = Pattern.compile(expresionPralabra);
		return Pattern.matches(pattern.toString(), entrada);
	}


	public static void ObtenerProduccionesPorSimbolosNT(String producciones, NoTerminales noTerminales, String acarreo) {
		//TO-DO  estamos en el segundo nivel, falta agregar 3 niveles mas
		String[] partes = producciones.split(",");
		for (int i = 0; i < partes.length; i++) {
			if (noTerminales.getSimbolo().equals(partes[i].substring(0,1))) {
				noTerminales.agregarCuerpo(obtenerCuerpo(partes[i]), acarreo);
			}
		}
	}


	private static String obtenerCuerpo(String string) {
		String[] partes = string.split("=");
		return partes[1];
	}

//	public static void main(String[] args) {
//		System.out.println(Validador.ValidarPalabra("sdzafsdg"));
//	}
	
}
