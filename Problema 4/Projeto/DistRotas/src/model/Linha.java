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
package model;

public class Linha {

	private Ponto ponto1 = null;
	private Ponto ponto2 = null;
	private int custo = 0;

	/*_____________________________________________________________________________________________________________________________*/
	public Linha(){
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o conte�do do ponto 1.
	 * @return Ponto - Conte�do do ponto 1.
	 */
	public Ponto getPonto1() {
		return ponto1;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o conte�do do ponto1.
	 * @param Ponto - Novo conte�do do ponto 1.
	 */
	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o conte�do do ponto 2.
	 * @return Ponto - Conte�do do ponto 2.
	 */
	public Ponto getPonto2() {
		return ponto2;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o conte�do do ponto 2.
	 * @param Ponto - Novo conte�do do ponto 2.
	 */
	public void setPonto2(Ponto ponto2) {
		this.ponto2 = ponto2;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o Peso da linha
	 * @return int - Peso da linha
	 */
	public int getCusto() {
		return custo;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o peso da linha
	 * @param int - Novo peso.
	 */
	public void setCusto(int custo) {
		this.custo = custo;
	}
	/*_____________________________________________________________________________________________________________________________*/
}
