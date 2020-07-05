package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.text.Utilities;

import models.Gramatica;
import models.NoTerminales;
import models.Palabra;
import utilities.Validador;
import views.VentanaPrincipal;

public class Controlador implements ActionListener{
	
	private Gramatica gramatica;
	private Palabra palabra;
	private VentanaPrincipal ventanaPrincipal;
	
	public Controlador() {
		ventanaPrincipal = new VentanaPrincipal(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (MyActions.valueOf(e.getActionCommand())) {
		case AGREGAR_GRAMATICA:
			ventanaPrincipal.ocultarDialogoNuevaGramatica(true);
			break;
		case GRAFICAR_ARBOL:
			break;
		case VALIDAR_PALABRA:
			ventanaPrincipal.ocultarDialogoValidarPalabra(true);
			break;
		case GENERAR_GRAMATICA:
			try {
				gramatica = new Gramatica(ventanaPrincipal.obtenerTerminales(), ventanaPrincipal.obtenerNoTerminales());
				if(gramatica.agregarProducciones(ventanaPrincipal.obtenerProducciones())) {
					JOptionPane.showMessageDialog(null, "Gramática Correcta");
					ventanaPrincipal.ocultarDialogoNuevaGramatica(false);
				}
				for (NoTerminales noTerminales : gramatica.getNoTerminales()) {
					Validador.ObtenerProduccionesPorSimbolosNT(ventanaPrincipal.obtenerProducciones(), noTerminales);
				}
				for (NoTerminales noTerminales : gramatica.getNoTerminales()) {
					System.out.println(noTerminales);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		case VALIDAR_PALABRA_OK:
			break;
		}
	}

}
