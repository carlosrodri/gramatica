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

	public PanelDrawing(String produccionesSinFiltrar) {
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

	public void pintarGramatica(ArrayList<NoTerminales> noTerminales, int y, int iteracion) throws Exception {
		int x = (getWidth()/noTerminales.size())/(noTerminales.size()*4);
		int xStep = getWidth()/(noTerminales.size()*2);
		if (iteracion < 5) {
			ArrayList<NoTerminales> noTerminalesPorNivel = new ArrayList<>();
			y += 50;
			for (NoTerminales not : noTerminales) {
				for (String cuerpo : not.getCuerpo()) {
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
}
