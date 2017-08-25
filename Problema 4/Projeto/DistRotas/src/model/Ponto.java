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

public class Ponto {
	
	private String nome = "Ponto";// Nome padr�o do ponto.
	private int x = 0;
	private int y = 0;
	
	/*_____________________________________________________________________________________________________________________________*/
	public Ponto(){
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o nome do ponto.
	 * @return String - Nome do ponto.
	 */
	public String getNome() {
		return nome;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o nome do ponto.
	 * @param String - Novo nome do ponto.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o valor de x.
	 * @return int - Valor do x.
	 */
	public int getX() {
		return x;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o valor de x.
	 * @param int - Novo valor de x.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o valor de y.
	 * @return int - Valor de y.
	 */
	public int getY() {
		return y;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o valor de y.
	 * @param int - Novo valor de y.
	 */
	public void setY(int y) {
		this.y = y;
	}
	/*_____________________________________________________________________________________________________________________________*/
}
