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
 * Classe V�rtice do Grafo.
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
	 * Verifica se o v�rtice foi visitado.
	 * @return true - Caso tenha sido visitado | false - Caso n�o tenha sido visitado.
	 */
	public boolean foiVisitado() {
		return foiVisitado;
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Seta se o v�rtice foi visitado.
	 * @param foiVisitado.
	 */
	public void setFoiVisitado(boolean foiVisitado) {
		this.foiVisitado = foiVisitado;
	}
	
	/*___________________________________________________________________________________________*/
	/**
	 * Construtor da classe.	
	 * @param Object - Objeto do v�rtice.
	 */
	public Vertice(Object objeto){
		this.setObjeto(objeto);
		grau = 0;
		//listaArestas = new ArrayList<Aresta>();
	}

	/*___________________________________________________________________________________________*/
	/**
	 * Retorna o grau do v�rtice.
	 * @return int - Grau do v�rtice.
	 */
	public int getGrau() {
		return grau;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o grau do v�rtice.
	 * @param int - Novo grau do v�rtice.
	 */
	public void setGrau(int grau) {
		this.grau = grau;
	}
	
	/*___________________________________________________________________________________________*/

	/**
	 * Retorna o objeto do v�rtice.
	 * @return Object - Objeto do v�rtice.
	 */
	public Object getObjeto() {
		return objeto;
	}
	/*___________________________________________________________________________________________*/
	/**
	 * Altera o objeto do v�rtice.
	 * @param Object - Novo objeto do v�rtice.
	 */
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	/*___________________________________________________________________________________________*/
}
