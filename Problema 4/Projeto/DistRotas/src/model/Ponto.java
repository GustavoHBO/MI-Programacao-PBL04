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
package model;

public class Ponto {
	
	private String nome = "Ponto";// Nome padrão do ponto.
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
