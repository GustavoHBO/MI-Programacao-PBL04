package applet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import model.Linha;
import model.Ponto;

public class PanelMenorCaminho extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Linha> linhas = null;

	private final int RAIO = 10;

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Construtor da classe.
	 * @param linhas - Lista de linhas.
	 */
	public PanelMenorCaminho(List<Linha> linhas) {
		super();
		this.linhas = linhas;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Sobrescreve o método da classe herdada.
	 * Agora desenha na tela todas as linha e os pontos que compõem a linha.
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.white);
		g.setColor(Color.black);
		Graphics2D grap2D = (Graphics2D) g;
		grap2D.setStroke(new BasicStroke(2));

		Iterator<Linha> it = linhas.iterator();
		Linha linha = null;
		Ponto ponto = null;
		while(it.hasNext()){
			linha = it.next();
			g.drawString(Integer.toString(linha.getCusto()), (linha.getPonto1().getX() + linha.getPonto2().getX())/2, ((linha.getPonto1().getY() + linha.getPonto2().getY())/2));
			grap2D.drawLine(linha.getPonto1().getX(), linha.getPonto1().getY(), linha.getPonto2().getX(), linha.getPonto2().getY());

			ponto = linha.getPonto1();
			g.drawString(ponto.getNome(), ponto.getX() - RAIO - 5, ponto.getY() - RAIO - 5);
			g.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);

			ponto = linha.getPonto2();
			g.drawString(ponto.getNome(), ponto.getX() - RAIO - 5, ponto.getY() - RAIO - 5);
			g.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);

		}
	}
	/*_____________________________________________________________________________________________________________________________*/
}
