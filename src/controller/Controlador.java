package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import models.Gramatica;
import models.NoTerminales;
import utilities.Validador;
import views.PanelDrawing;
import views.VentanaPrincipal;

public class Controlador implements ActionListener{

	private Gramatica gramatica;
	private VentanaPrincipal ventanaPrincipal;
	private PanelDrawing panelDrawing;
	private JDialog dialogPaint;

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
			pintarArbol();
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
					Validador.ObtenerProduccionesPorSimbolosNT(ventanaPrincipal.obtenerProducciones(), noTerminales, "");
					panelDrawing = new PanelDrawing(ventanaPrincipal.obtenerProducciones());
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		case VALIDAR_PALABRA_OK:
			break;
		}
	}

	private void pintarArbol() {
		dialogPaint = new JDialog();
		dialogPaint.setLayout(new BorderLayout());
		dialogPaint.add(panelDrawing, BorderLayout.CENTER);
		dialogPaint.setSize(new Dimension(800, 800));
		dialogPaint.setLocationRelativeTo(null);
		panelDrawing.setGramatica(gramatica);
		dialogPaint.setVisible(true);
	}

}
