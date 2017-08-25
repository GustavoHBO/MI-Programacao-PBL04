/*******************************************************************************
Autor: Gustavo Henrique.
Autor: Leonardo Melo.
Componente Curricular: MI - Programação.
Concluído em: 14/05/2016
Declaro que este código foi elaborado por mim e minha dupla e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package util;

/**
 * Classe aresta.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 */
public class Aresta {

	private Vertice vertice1 = null;
	private Vertice vertice2 = null;
	private int peso = 0;
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Construtor padrão da classe.
	 * @param vertice1 - Vertice1 da aresta.
	 * @param vertice2 - Vertice2 da aresta.
	 */
	public Aresta(Vertice vertice1, Vertice vertice2){
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o vértice de destino da aresta.
	 * @return Vertice - Vértice de destino
	 */
	public Vertice getVertice2() {
		return vertice2;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Altera o vértice de destino da aresta.
	 * @param Vertice - Novo vértice de destino da aresta.
	 */
	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o vértice de origem da aresta.
	 * @return Vertice - Vértice de origem
	 */
	public Vertice getVertice1() {
		return vertice1;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Altera o vértice de origem da aresta.
	 * @param Vertice - Novo vértice de origem da aresta.
	 */
	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o valor peso da aresta.
	 * @return int - Peso da aresta.
	 */
	public int getPeso() {
		return peso;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Altera o valor peso da aresta.
	 * @param int - Novo valor peso da aresta.
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	/*______________________________________________________________________________________________________________________________*/
}
