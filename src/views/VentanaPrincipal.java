package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Controlador;
import controller.MyActions;

public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton botonGramatica, botonArbol, botonPalabra;
	private DialogoNuevaGramatica dialogoNuevaGramatica;
	private DialogoValidarPalabra dialogoValidarPalabra;
	
	public VentanaPrincipal(Controlador controlador) {
        setIconImage(new ImageIcon(getClass().getResource("/img/lenguaje.png")).getImage());
        
		setSize(new Dimension(500, 150));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 3));
		
		dialogoNuevaGramatica = new DialogoNuevaGramatica(controlador, this);
		dialogoValidarPalabra = new DialogoValidarPalabra(controlador, this);
		
		botonGramatica = new JButton("Agregar Gramàtica");
		botonGramatica.setBackground(Color.decode("#A62C1C"));
		botonGramatica.setForeground(Color.WHITE);
		botonGramatica.setFocusable(false);
		botonGramatica.setActionCommand(MyActions.AGREGAR_GRAMATICA.toString()); 
		botonGramatica.addActionListener(controlador);
		add(botonGramatica);
		
		botonArbol = new JButton("Graficar Arbol");
		botonArbol.setFocusable(false);
		botonArbol.setForeground(Color.WHITE);
		botonArbol.setBackground(Color.decode("#B0AF1E"));
		botonArbol.setActionCommand(MyActions.GRAFICAR_ARBOL.toString()); 
		botonArbol.addActionListener(controlador);
		add(botonArbol);
		
		botonPalabra = new JButton("Validar palabra");
		botonPalabra.setFocusable(false);
		botonPalabra.setForeground(Color.WHITE);
		botonPalabra.setBackground(Color.decode("#228199"));
		botonPalabra.setActionCommand(MyActions.VALIDAR_PALABRA.toString()); 
		botonPalabra.addActionListener(controlador);
		add(botonPalabra);
		
		setVisible(true);
	}
	
	public void ocultarDialogoNuevaGramatica(boolean opcion) {
		if (opcion) {
			dialogoNuevaGramatica.limpiarCampos();
		} 
		this.dialogoNuevaGramatica.setVisible(opcion);
	}
	
	public void ocultarDialogoValidarPalabra(boolean opcion) {
		if (opcion) {
			dialogoValidarPalabra.limpiarCampos();
		} 
		this.dialogoValidarPalabra.setVisible(opcion);
	}
	
	
	public String obtenerNoTerminales() throws Exception {
		return dialogoNuevaGramatica.obtenerNoTerminales();
	}
	
	public String obtenerTerminales() throws Exception {
		return dialogoNuevaGramatica.obtenerTerminales();
	}

	public String obtenerProducciones() throws Exception {
		return dialogoNuevaGramatica.obtenerProducciones();
	}
}
