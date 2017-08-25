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

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Classe do algoritmo de Dijkstra, responsável por descobrir o menor caminho em um grafo.
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
	 * Gera as menores distâncias da raiz para cada outro vértice conexo do grafo 
	 * @param Vertice - Vértice de origem
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
	 * Acha a distância mínima até o nó
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
	 * Método para retorno do peso da aresta entre nós adjacentes
	 * @param Vertice - Nó do grafo
	 * @param Vertice - Nó do grafo
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
	 * Método que descobre todos os vértices adjacentes a certo vértice
	 * @param Vertice - Vértice do grafo
	 * @return List<Vertice> - Lista de vértices
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
	 * Método para cálculo do vértice com a menor distância
	 * @param Set<Vertice> - Lista de Vértices
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
	 * Verifica se o nó já foi visitado
	 * @return Boolean - Se já foi visitado
	 */
	private boolean isVisitado(Vertice vertice) {
		return nosVisitados.contains(vertice);
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna o valor da menor distância já calculada
	 * @param Vertice - Vértice do grafo
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
	 * Método que retorna todos os caminhos mínimos 
	 * @param Vertice - Vértice origem
	 * @param ArrayList<Vertice> - Caminho mínimo até o vértice origem
	 * @return List<List<Vertice>> - Lista de caminhos mínimos
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
