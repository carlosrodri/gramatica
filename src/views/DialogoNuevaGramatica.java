package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import controller.Controlador;
import controller.MyActions;

public class DialogoNuevaGramatica extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField tfTerminales, tfNoTerminales, tfProducciones;
	private JButton btnGenerarGramatica;

	public DialogoNuevaGramatica(Controlador controlador, VentanaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal, true);
		
		setTitle("Nueva Gramatica");
		setBackground(Color.decode("#A62C1C"));
		setModal(true);
		setLayout(new GridLayout(4, 1));
		setSize(new Dimension(400, 500));
		setLocationRelativeTo(null);
		
		tfTerminales = new JTextField();
		tfTerminales.setBorder(new TitledBorder("Simbolos Terminales"));
		add(tfTerminales);
		
		tfNoTerminales = new JTextField();
		tfNoTerminales.setBorder(new TitledBorder("Simbolos NO Terminales"));
		add(tfNoTerminales);

		tfProducciones = new JTextField();
		tfProducciones.setBorder(new TitledBorder("Producciones"));
		add(tfProducciones);
		

		btnGenerarGramatica = new JButton("Generar Gramàtica");
		btnGenerarGramatica.setFocusable(false);
		btnGenerarGramatica.setBackground(Color.decode("#A62C1C"));
		btnGenerarGramatica.setForeground(Color.WHITE);
		btnGenerarGramatica.setActionCommand(MyActions.GENERAR_GRAMATICA.toString()); 
		btnGenerarGramatica.addActionListener(controlador);
		add(btnGenerarGramatica);
		
		setVisible(false);
	}
	
	public void limpiarCampos() {
		this.tfNoTerminales.setText("");
		this.tfProducciones.setText("");
		this.tfTerminales.setText("");
	}
	
	public String obtenerNoTerminales() throws Exception {
		return tfNoTerminales.getText();
	}
	
	public String obtenerTerminales() throws Exception {
		return tfTerminales.getText();
	}

	public String obtenerProducciones() throws Exception {
		return tfProducciones.getText();
	}
}
