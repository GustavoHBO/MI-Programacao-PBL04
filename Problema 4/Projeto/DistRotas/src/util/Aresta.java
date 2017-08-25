/*******************************************************************************
Autor: Gustavo Henrique.
Autor: Leonardo Melo.
Componente Curricular: MI - Programa��o.
Conclu�do em: 14/05/2016
Declaro que este c�digo foi elaborado por mim e minha dupla e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o a minha est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
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
	 * Construtor padr�o da classe.
	 * @param vertice1 - Vertice1 da aresta.
	 * @param vertice2 - Vertice2 da aresta.
	 */
	public Aresta(Vertice vertice1, Vertice vertice2){
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o v�rtice de destino da aresta.
	 * @return Vertice - V�rtice de destino
	 */
	public Vertice getVertice2() {
		return vertice2;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Altera o v�rtice de destino da aresta.
	 * @param Vertice - Novo v�rtice de destino da aresta.
	 */
	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o v�rtice de origem da aresta.
	 * @return Vertice - V�rtice de origem
	 */
	public Vertice getVertice1() {
		return vertice1;
	}
	
	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Altera o v�rtice de origem da aresta.
	 * @param Vertice - Novo v�rtice de origem da aresta.
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
