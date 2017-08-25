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
import java.util.Iterator;
import java.util.List;

public class Grafo{

	private int numVertices;
	private int numArestas;
	private List<Vertice> listaVertices;
	private List<Aresta> listaArestas;

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Construtor, inicializa os atributos da classe.
	 */
	public Grafo(){
		numVertices = 0;
		numArestas = 0;
		listaVertices = new ArrayList<Vertice>();
		listaArestas = new ArrayList<Aresta>();
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para retorno da quantidade de v�rtices do grafo
	 * @return int - N�mero de v�rtices do grafo
	 */
	public int numVertices() {
		return numVertices;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para retorno da quantidade de arestas do grafo
	 * @return int - N�mero de arestas do grafo
	 */
	public int numArestas() {
		return numArestas;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para retorno dos v�rtices do grafo
	 * @return List<Vertice> - Lista de todos os v�rtices do grafo
	 */
	public List<Vertice> getVertices(){
		return listaVertices;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para retorno das arestas do grafo
	 * @return List<Aresta> - Lista de todas as arestas do grafo
	 */
	public List<Aresta> getArestas(){
		return listaArestas;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Remove o v�rtice a partir do objeto do v�rtice.
	 * @param Object - Objeto inserido
	 * @return Vertice - O v�rtice com o objeto inserido
	 */
	public Vertice inserir(Object o) {
		if(o == null){// Caso o objeto recebido seja nulo.
			return null;
		}
		Vertice vertice = new Vertice(o);
		listaVertices.add(vertice);
		numVertices++;

		return vertice;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * M�todo para inserir uma aresta orientada
	 * @param Vertice - V�rtice de origem
	 * @param Vertice - V�rtice de destino
	 * @param int - Peso da aresta
	 */
	public void inserirAresta(Vertice v, Vertice w, int peso) {
		if(v == null || w == null){
			return;
		}
		Aresta aresta = new Aresta(v, w);
		aresta.setPeso(peso);

		numArestas++;

		listaArestas.add(aresta);

	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Inserir no grafouma aresta n�o orientada
	 * @param Vertice - V�rtice
	 * @param Vertice - V�rtice
	 * @param int - Peso da aresta
	 */
	public void inserirArestaNaoOrientada(Vertice v, Vertice w, int peso) {
		inserirAresta(v , w , peso);
		inserirAresta(w , v , peso);
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Remove a aresta
	 * @param Aresta - Aresta do grafo
	 */
	public void removerAresta(Aresta a) {
		Aresta aresta = buscarAresta(a.getVertice1(), a.getVertice2());
		if(aresta != null){
			listaArestas.remove(aresta);
		}

	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Remove o v�rtice a partir do objeto do v�rtice.
	 * @param Object - Objeto do v�rtice a ser removido.
	 * @return Vertice - V�rtice removido || null - Caso o v�rtice n�o seja encontrado.
	 */
	public Vertice removerVertice(Object o){
		Iterator<Aresta> it = listaArestas.iterator();

		Vertice vertice = buscarVertice(o);

		if(vertice == null){
			return null;
		}
		Aresta aresta = null;
		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().equals(vertice) || aresta.getVertice2().equals(vertice)){
				listaArestas.remove(aresta);
			}
		}
		listaVertices.remove(vertice);
		return vertice;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Busca o v�rtice a partir do objeto armazenado nele.
	 * @param Object - Objeto do v�rtice procurado.
	 * @return Vertice - V�rtice procurado | null - Caso o v�rtice n�o seja encontrado.
	 */
	public Vertice buscarVertice(Object objeto){
		Iterator<Vertice> it = listaVertices.iterator();
		Vertice vertice = null;
		while(it.hasNext()){
			vertice = it.next();
			if(vertice.getObjeto().equals(objeto)){
				return vertice;
			}
		}
		return null;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Busca a aresta a partir dos v�rtices que determinam o inicio e fim da aresta.
	 * @param Vertice - V�rtice origem da aresta.
	 * @param Vertice - V�rtice destino da aresta.
	 * @return Aresta - Aresta procurada || null - Caso a aresta n�o seja encontrada.
	 */
	public Aresta buscarAresta(Vertice vertice1, Vertice vertice2){
		Iterator<Aresta> it = listaArestas.iterator();
		Aresta aresta = null;
		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().equals(vertice1) && aresta.getVertice2().equals(vertice2)){
				return aresta;
			}
		}
		return null;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna uma lista de todas as aresta incidentes no v�rtice encontrado.
	 * @param String - Nome do v�rtice.
	 * @return List<Aresta> - Todas as arestas incidentes no v�rtice encontrado.
	 */
	public List<Aresta> arestasIncidentes(String nome){
		List<Aresta> arestasIncidentes = new ArrayList<Aresta>();
		Iterator<Aresta> it = listaArestas.iterator();
		Aresta aresta = null;

		while(it.hasNext()){
			aresta = it.next();
			if(aresta.getVertice1().getObjeto().equals(nome) || aresta.getVertice2().getObjeto().equals(nome)){
				arestasIncidentes.add(aresta);
			}
		}
		if(arestasIncidentes.size() == 0){
			return null;
		}
		return arestasIncidentes;
	}

	/*______________________________________________________________________________________________________________________________*/
	/**
	 * Retorna um operador Dijkstra do grafo recebido.
	 * @return Dijkstra - Operador dijkstra do grafo.
	 */
	public Dijkstra menorCaminho(){
		return new Dijkstra(this);
	}
	/*______________________________________________________________________________________________________________________________*/
}
