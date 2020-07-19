package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import models.Gramatica;
import models.NoTerminales;
import utilities.Validador;

public class PanelDrawing extends JPanel{

	private static final int DIAMETRO = 40;
	private static final long serialVersionUID = 1L;
	private Graphics g;
	private Gramatica gramatica;
	private String produccionesSinFiltrar;
	private ArrayList<String> palabras;

	public PanelDrawing(String produccionesSinFiltrar) {
		this.palabras = new ArrayList<>();
		this.produccionesSinFiltrar = produccionesSinFiltrar;
		setSize(new Dimension(500, 500));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.g = g;
		int x = (getWidth()/2)-(DIAMETRO/2);
		int y = DIAMETRO;
		pintarRaiz(x, y);
		try {
			ArrayList<NoTerminales> n = new ArrayList<>();
			n.add(gramatica.getNoTerminales().get(0));
			pintarGramatica(n, y, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void setGramatica(Gramatica gramatica) {
		this.gramatica = gramatica;
	}

	public void pintarRaiz(int x, int y) {
		g.drawOval(x, 20 , DIAMETRO, y);
		g.drawString(gramatica.getNoTerminales().get(0).getSimbolo(), getWidth()/2, y);
	}

	public void setProduccionesSinFiltrar(String produccionesSinFiltrar) {
		this.produccionesSinFiltrar = produccionesSinFiltrar;
	}

	/**
	 * Método recursivo para pintar las producciones correspondientes a cada nivel
	 * @param noTerminales el array de simbolos no terminales correspondientes al nivel de la iteracion
	 * @param y posicion en y del nivel
	 * @param iteracion numero dl nivel en el que se encuantra pintando
	 * @throws Exception
	 */
	public void pintarGramatica(ArrayList<NoTerminales> noTerminales, int y, int iteracion) throws Exception {
		int x = (getWidth()/noTerminales.size())/(noTerminales.size()*4);
		int xStep = getWidth()/(noTerminales.size()*2);
		if (iteracion < 5) {
			ArrayList<NoTerminales> noTerminalesPorNivel = new ArrayList<>();
			y += 50;
			for (NoTerminales not : noTerminales) {
				for (String cuerpo : not.getCuerpo()) {
					this.palabras.add(cuerpo);
					g.drawOval(x-2, y-(DIAMETRO/2) , DIAMETRO, DIAMETRO);
					g.drawString(cuerpo, x, y);
					String simboloTerminal = cuerpo.substring(cuerpo.length()-1, cuerpo.length());
					if(simboloTerminal.codePointAt(0) >= 65 && simboloTerminal.codePointAt(0) <= 90 ) {
						NoTerminales n = new NoTerminales(cuerpo.substring(cuerpo.length()-1, cuerpo.length()));
						Validador.ObtenerProduccionesPorSimbolosNT(produccionesSinFiltrar, n, cuerpo.substring(0, cuerpo.length()-1));
						noTerminalesPorNivel.add(n);
					}
					x += (xStep+(DIAMETRO/2));
				}
			}
			iteracion += 1;
			pintarGramatica(noTerminalesPorNivel, y, iteracion);
		}
		setVisible(true);
	}

	/**
	 * La gramatica valida que la palabra pertenezca a ella
	 * @param palabra
	 * @return
	 */
	public boolean validarPalabra(String palabra){
		boolean valida = false;
		for (String string : palabras) {
			if (string.equals(palabra)) {
				valida = true;
			}
		}
		return valida;
	}
}
