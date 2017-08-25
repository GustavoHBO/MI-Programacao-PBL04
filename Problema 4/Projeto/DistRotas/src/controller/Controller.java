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

package controller;

import java.util.Iterator;
import java.util.List;

import exception.NomeInvalidoException;
import util.Aresta;
import util.Dijkstra;
import util.Grafo;
import util.Vertice;

/**
 * Classe controller, respons�vel pela liga��o interface com o sistema.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 */

public class Controller {

	private static Controller controller = null;
	private Grafo grafo = new Grafo();

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Construtor privado.
	 */
	private Controller(){}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Retorna uma inst�ncia da classe caso n�o exista outra.
	 * @return Controller - Controller.
	 */
	public static Controller getInstance(){
		if(controller == null){
			return new Controller();
		} else{
			return controller;
		}
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Cria uma nova inst�ncia da classe.
	 */
	public static void zerarSingleton(){
		controller = new Controller();
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Cadastra os pontos no grafo.
	 * @param String - Nome do ponto cadastrado.
	 * @throws NomeInvalidoException - Caso o nome seja invalido.
	 */
	public void cadastrarPonto(String nome) throws NomeInvalidoException{

		Iterator<Vertice> it = grafo.getVertices().iterator();
		Vertice aux = null;
		while(it.hasNext()){
			aux = it.next();
			if(aux.getObjeto().equals(nome)){
				throw new NomeInvalidoException();
			}
		}

		grafo.inserir(nome);
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Cadastra um caminho entre os pontos.
	 * @param String - Nome do ponto 1.
	 * @param String - Nome do ponto 2.
	 * @param int - Custo do caminho.
	 */
	public void cadastrarCaminho(String nome1, String nome2, int peso){

		Vertice vertice1 = grafo.buscarVertice(nome1);
		Vertice vertice2 = grafo.buscarVertice(nome2);
		grafo.inserirAresta(vertice1, vertice2, peso);
		grafo.inserirAresta(vertice2, vertice1, peso);
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Remove o ponto e todas as arestas incidentes no ponto.
	 * @param String - Nome do ponto a ser removido.
	 */
	public void removerPonto(String nome){
		grafo.removerVertice(nome);
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * Remove todos os caminhos entre os objetos com o nome recebido.
	 * @param String - Nome do v�rtice 1.
	 * @param String - Nome do v�rtice 2.
	 */
	public void removerCaminho(String nome1, String nome2){
		Vertice vertice1 = grafo.buscarVertice(nome1);// Busca a aresta com nome1.
		Vertice vertice2 = grafo.buscarVertice(nome2);// Busca a aresta com nome2.

		Aresta aresta = grafo.buscarAresta(vertice1, vertice2); // Pega aresta de vertice1 a vertice2
		Aresta aresta2 = grafo.buscarAresta(vertice2, vertice1); // Pega aresta de vertice2 a vertice1

		grafo.removerAresta(aresta);// Remove a primeira aresta.
		grafo.removerAresta(aresta2);// Remove a segunda aresta.
	}

	/*_____________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para c�lculo dos caminhos m�nimos entre dois v�rtices
	 * @param String - Nome do v�rtice de origem.
	 * @param String - Nome do v�rtice de destino.
	 * @return List<List<Vertice>> - Lista de caminhos m�nimos
	 */
	public List<List<Vertice>> menorCaminho(String nome1, String nome2){

		Dijkstra operador = grafo.menorCaminho();
		Vertice veticeInicio = grafo.buscarVertice(nome1);
		Vertice verticeFim = grafo.buscarVertice(nome2);
		operador.executar(veticeInicio);
		List<List<Vertice>> caminhos = operador.getCaminho(null, verticeFim);

		return caminhos;
	}
	/*_____________________________________________________________________________________________________________________________*/
}
