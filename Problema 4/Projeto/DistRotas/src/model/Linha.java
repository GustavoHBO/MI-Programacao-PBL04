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

public class Linha {

	private Ponto ponto1 = null;
	private Ponto ponto2 = null;
	private int custo = 0;

	/*_____________________________________________________________________________________________________________________________*/
	public Linha(){
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o conteúdo do ponto 1.
	 * @return Ponto - Conteúdo do ponto 1.
	 */
	public Ponto getPonto1() {
		return ponto1;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o conteúdo do ponto1.
	 * @param Ponto - Novo conteúdo do ponto 1.
	 */
	public void setPonto1(Ponto ponto1) {
		this.ponto1 = ponto1;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o conteúdo do ponto 2.
	 * @return Ponto - Conteúdo do ponto 2.
	 */
	public Ponto getPonto2() {
		return ponto2;
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Altera o conteúdo do ponto 2.
	 * @param Ponto - Novo conteúdo do ponto 2.
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
