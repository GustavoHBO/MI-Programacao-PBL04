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

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe do algoritmo de Dijkstra, respons�vel por descobrir o menor caminho em um grafo.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 */
public class Dijkstra {

	private final List<Aresta> arestas;
	private List<List<Vertice>> listaResultados;
	private Set<Vertice> nosVisitados;
	private Set<Vertice> nosNaoVisitados;
	private Map<Vertice, ArrayList<Vertice>> antecessores;
	private Map<Vertice, Integer> peso;

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Construtor da classe, recebe o grafo a ser utilizado no algoritmo.
	 * @param grafo - Grafo utilizado no algoritmo.
	 */
	public Dijkstra(Grafo grafo) {
		this.arestas = new ArrayList<Aresta>(grafo.getArestas());
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Gera as menores dist�ncias da raiz para cada outro v�rtice conexo do grafo 
	 * @param Vertice - V�rtice de origem
	 */
	public void executar(Vertice raiz) {
		listaResultados = new ArrayList<List<Vertice>>();
		nosVisitados = new HashSet<Vertice>();
		nosNaoVisitados = new HashSet<Vertice>();
		peso = new HashMap<Vertice, Integer>();
		antecessores = new HashMap<Vertice, ArrayList<Vertice>>();
		peso.put(raiz, 0);
		nosNaoVisitados.add(raiz);
		while (nosNaoVisitados.size() > 0) {
			Vertice no = getVertMenorDistancia(nosNaoVisitados);
			nosVisitados.add(no);
			nosNaoVisitados.remove(no);
			acharDistanciaMinima(no);
		}
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Acha a dist�ncia m�nima at� o n�
	 * @param Vertice - Vertice
	 */
	private void acharDistanciaMinima(Vertice no) {
		List<Vertice> nosAdjacentes = getVizinhos(no);
		ArrayList<Vertice> listaAuxiliar;
		for (Vertice target : nosAdjacentes) {
			if (getMenorDistancia(target) > getMenorDistancia(no) + getDistancia(no, target)) {
				peso.put(target, getMenorDistancia(no) + getDistancia(no, target));
				listaAuxiliar = new ArrayList<Vertice>();
				listaAuxiliar.add(no);
				antecessores.put(target, listaAuxiliar);
				nosNaoVisitados.add(target);
			}else if(getMenorDistancia(target) == getMenorDistancia(no) + getDistancia(no, target)){
				antecessores.get(target).add(no);
			}
		}

	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para retorno do peso da aresta entre n�s adjacentes
	 * @param Vertice - N� do grafo
	 * @param Vertice - N� do grafo
	 * @return int - Peso da aresta.
	 */
	private int getDistancia(Vertice no, Vertice no2) {
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& aresta.getVertice2().equals(no2)) {
				return aresta.getPeso();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo que descobre todos os v�rtices adjacentes a certo v�rtice
	 * @param Vertice - V�rtice do grafo
	 * @return List<Vertice> - Lista de v�rtices
	 */
	private List<Vertice> getVizinhos(Vertice no) {
		List<Vertice> adjacentes = new ArrayList<Vertice>();
		for (Aresta aresta : arestas) {
			if (aresta.getVertice1().equals(no)
					&& !isVisitado(aresta.getVertice2())) {
				adjacentes.add(aresta.getVertice2());
			}
		}
		return adjacentes;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para c�lculo do v�rtice com a menor dist�ncia
	 * @param Set<Vertice> - Lista de V�rtices
	 * @return Vertice - Peso da aresta.
	 */
	private Vertice getVertMenorDistancia(Set<Vertice> vertices) {
		Vertice minimo = null;
		for (Vertice vertice : vertices) {
			if (minimo == null) {
				minimo = vertice;
			} else {
				if (getMenorDistancia(vertice) < getMenorDistancia(minimo)) {
					minimo = vertice;
				}
			}
		}
		return minimo;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Verifica se o n� j� foi visitado
	 * @return Boolean - Se j� foi visitado
	 */
	private boolean isVisitado(Vertice vertice) {
		return nosVisitados.contains(vertice);
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o valor da menor dist�ncia j� calculada
	 * @param Vertice - V�rtice do grafo
	 * @return int - Peso da aresta.
	 */
	private int getMenorDistancia(Vertice vertice) {
		Integer d = peso.get(vertice);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo que retorna todos os caminhos m�nimos 
	 * @param Vertice - V�rtice origem
	 * @param ArrayList<Vertice> - Caminho m�nimo at� o v�rtice origem
	 * @return List<List<Vertice>> - Lista de caminhos m�nimos
	 */
	public List<List<Vertice>> getCaminho(ArrayList<Vertice> aux, Vertice vertice) {
		if(aux == null){
			aux = new ArrayList<Vertice>();
		}
		ArrayList<Vertice> caminho = new ArrayList<Vertice>(aux);
		Vertice vertAux = vertice;
		ArrayList<Vertice> vertAuxList;

		if (antecessores.get(vertAux) == null) {
			return null;
		}
		caminho.add(vertAux);
		while (antecessores.get(vertAux) != null) {
			vertAuxList = antecessores.get(vertAux);
			if(vertAuxList.size() > 1){
				for(int i = 1; i < vertAuxList.size(); i++){
					vertAux = vertAuxList.get(i);
					getCaminho(caminho, vertAux);
				}
			}
			vertAux = vertAuxList.get(0);
			caminho.add(vertAux);
		}

		Collections.reverse(caminho);
		listaResultados.add(caminho);
		return listaResultados;
	}
	/*______________________________________________________________________________________________________________________________*/

} 
