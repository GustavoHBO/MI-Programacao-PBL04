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
 * Classe Vértice do Grafo.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 * @since 16 abr. 2016.
 */

public class Vertice {

	private int grau;
	private boolean foiVisitado = false;
	private Object objeto;

	/*___________________________________________________________________________________________*/
	/**
	 * Verifica se o vértice foi visitado.
	 * @return true - Caso tenha sido visitado | false - Caso não tenha sido visitado.
	 */
	public boolean foiVisitado() {
		return foiVisitado;
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Seta se o vértice foi visitado.
	 * @param foiVisitado.
	 */
	public void setFoiVisitado(boolean foiVisitado) {
		this.foiVisitado = foiVisitado;
	}
	
	/*___________________________________________________________________________________________*/
	/**
	 * Construtor da classe.	
	 * @param Object - Objeto do vértice.
	 */
	public Vertice(Object objeto){
		this.setObjeto(objeto);
		grau = 0;
		//listaArestas = new ArrayList<Aresta>();
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do vértice.
	 * @return int - Grau do vértice.
	 */
	public int getGrau() {
		return grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o grau do vértice.
	 * @param int - Novo grau do vértice.
	 */
	public void setGrau(int grau) {
		this.grau = grau;
	}
	
	/*___________________________________________________________________________________________*/

	/**
	 * Retorna o objeto do vértice.
	 * @return Object - Objeto do vértice.
	 */
	public Object getObjeto() {
		return objeto;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o objeto do vértice.
	 * @param Object - Novo objeto do vértice.
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	/*___________________________________________________________________________________________*/
}
