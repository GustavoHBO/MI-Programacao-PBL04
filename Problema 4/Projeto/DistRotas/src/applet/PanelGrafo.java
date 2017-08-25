/**
 * 
 */
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

/**
 * Classe que estende de JPanel e sobrescreve o método paintComponent.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 *
 */
public class PanelGrafo extends JPanel {

	private static final long serialVersionUID = -7784228856215948909L;
	private List<Ponto> pontos = null;
	private List<Linha> linhas = null;

	private final int RAIO = 10;

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Construtor da classe, recebe os componentes que serão desenhados na tela.
	 * @param pontos - Lista de pontos.
	 * @param linhas - Lista de linhas.
	 */
	public PanelGrafo(List<Ponto> pontos, List<Linha> linhas) {
		super();
		this.pontos = pontos;
		this.linhas = linhas;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Sobrescreve o método do JPanel herdado.
	 * Pinta na tela todas as linhas e pontos recebidos pelo construtor.
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.white);
		g.setColor(Color.black);
		Graphics2D grap2D = (Graphics2D) g;
		grap2D.setStroke(new BasicStroke(2));

		if(pontos == null || linhas == null){
			return;
		}

		Iterator<Ponto> itP = pontos.iterator();
		Iterator<Linha> itL = linhas.iterator();

		Ponto ponto = null;
		Linha linha = null;

		while(itP.hasNext()){
			ponto = itP.next();
			g.drawString(ponto.getNome(), ponto.getX() - RAIO - 5, ponto.getY() - RAIO - 5);
			g.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);
		}

		while(itL.hasNext()){
			linha = itL.next();
			g.drawString(Integer.toString(linha.getCusto()), (linha.getPonto1().getX() + linha.getPonto2().getX())/2, ((linha.getPonto1().getY() + linha.getPonto2().getY())/2));
			grap2D.drawLine(linha.getPonto1().getX(), linha.getPonto1().getY(), linha.getPonto2().getX(), linha.getPonto2().getY());
		}
	}
	/*_____________________________________________________________________________________________________________________________*/
}
