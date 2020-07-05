package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Controlador;
import controller.MyActions;
import utilities.Validador;

public class DialogoValidarPalabra extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField tfPalabra;
	private JButton botonValidarPalabra;

	public DialogoValidarPalabra(Controlador controlador, VentanaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal, true);
		
		setModal(true);
		setLayout(new BorderLayout());
		setSize(new Dimension(200, 150));
		setLocationRelativeTo(null);

		tfPalabra = new JTextField();
		tfPalabra.setBorder(new TitledBorder("Ingresa la palabra a validar"));
		add(tfPalabra, BorderLayout.CENTER);

		botonValidarPalabra = new JButton("Validar palabra");
		botonValidarPalabra.setFocusable(false);
		botonValidarPalabra.setBackground(Color.decode("#228199"));
		botonValidarPalabra.setForeground(Color.WHITE);
		botonValidarPalabra.setActionCommand(MyActions.VALIDAR_PALABRA_OK.toString()); 
		botonValidarPalabra.addActionListener(controlador);
		add(botonValidarPalabra, BorderLayout.SOUTH);

		setVisible(false);
	}

	public void limpiarCampos() {
		this.tfPalabra.setText("");
	}

	public String obtenerPalabra() throws Exception {
		if (Validador.ValidarPalabra(tfPalabra.getText())) {
			return tfPalabra.getText();
		} else {
			throw new Exception("Palabra no vàlida o vacia");
		}
	}
}
