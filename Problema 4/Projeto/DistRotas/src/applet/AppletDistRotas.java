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
package applet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import exception.CaminhoInexistenteException;
import exception.NomeInvalidoException;
import model.Linha;
import model.Ponto;
import util.Vertice;


/**
 * Classe applet, responsável pela execução no browser.
 * @author Gustavo Henrique.
 * @author Leonardo Melo.
 *
 */
public class AppletDistRotas extends JApplet {

	private static final long serialVersionUID = 1L;
	private Controller controller = null;
	private final int RAIO = 10;
	private JPanel panelControle = null;
	private static JPanel panelArea = null;

	private static List<Ponto> listaDePontos;
	private static List<Linha> listaDeLinhas;

	private List<Linha> linhasCaminhos;

	private JTextField textFieldNome = null;

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Construtor da classe, é instanciado os atributos da classe.
	 */
	public AppletDistRotas() {

		listaDePontos = new ArrayList<Ponto>();
		listaDeLinhas = new ArrayList<Linha>();
		linhasCaminhos = new ArrayList<Linha>();
		this.controller = Controller.getInstance();
		montarTela();
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Método que define o tamanho do applet.
	 */
	public void init(){
		this.setSize(600, 540);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Monta a tela da aplicação, preparando os panel's da classe.
	 */
	public void montarTela(){
		prepararPanelControle();
		prepararPanelArea();
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Instância o JPanel e define o layout.
	 */
	private void prepararPanelControle() {
		getContentPane().setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{214, 310, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		panelControle = new JPanel();
		panelControle.setLayout(null);
		GridBagConstraints gbc_panelControle = new GridBagConstraints();
		gbc_panelControle.insets = new Insets(0, 0, 0, 5);
		gbc_panelControle.fill = GridBagConstraints.BOTH;
		gbc_panelControle.gridx = 0;
		gbc_panelControle.gridy = 0;
		getContentPane().add(panelControle, gbc_panelControle);

		/*Prepara os botões do panel controle*/
		prepararBotaoCadastrarPonto();
		prepararBotaoCadastrarAresta();
		prepararBotaoRemoverPonto();
		prepararBotaoRemoverAresta();
		prepararBotaoEscolherRota();
		prepararBotaoMostrarGrafo();
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o JPanel e define o layout.
	 */
	private void prepararPanelArea(){

		if(panelArea != null)
			this.remove(panelArea);

		panelArea = new JPanel();
		GridBagConstraints layoutPanel = new GridBagConstraints();
		layoutPanel.fill = GridBagConstraints.BOTH;
		layoutPanel.gridx = 1;
		layoutPanel.gridy = 0;
		getContentPane().add(panelArea, layoutPanel);
		GroupLayout layoutGroupPanel = new GroupLayout(panelArea);
		layoutGroupPanel.setHorizontalGroup(layoutGroupPanel.createParallelGroup(Alignment.LEADING).addGap(0, 428, Short.MAX_VALUE));
		layoutGroupPanel.setVerticalGroup(layoutGroupPanel.createParallelGroup(Alignment.LEADING).addGap(0, 450, Short.MAX_VALUE));
		panelArea.setLayout(null);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o botão cadastrar ponto.
	 */
	private void prepararBotaoCadastrarPonto(){
		JButton botaoCadastrarPonto = new JButton("Cadastrar Ponto");
		botaoCadastrarPonto.setBounds(35, 22, 140, 33);

		botaoCadastrarPonto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaCadastrarPonto();
			}
		});

		panelControle.add(botaoCadastrarPonto);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o botão cadastrar aresta.
	 */
	private void prepararBotaoCadastrarAresta(){
		JButton botaoCadastrarAresta = new JButton("Cadastrar Aresta");
		botaoCadastrarAresta.setBounds(35, 66, 140, 33);

		botaoCadastrarAresta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaCadastrarAresta();
			}
		});

		panelControle.add(botaoCadastrarAresta);
	}

	/**
	 * Prepara o botão remover ponto.
	 */
	private void prepararBotaoRemoverPonto(){
		JButton botaoRemoverPonto = new JButton("Remover Ponto");
		botaoRemoverPonto.setBounds(35, 110, 140, 33);

		botaoRemoverPonto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaRemoverPonto();
			}
		});

		panelControle.add(botaoRemoverPonto);
	}
	/*___________________________________________________________________________________________________________________*/
	/**
	 * Prepara o botão remover aresta.
	 */
	private void prepararBotaoRemoverAresta(){
		JButton botaoRemoverAresta = new JButton("Remover Aresta");
		botaoRemoverAresta.setBounds(35, 154, 140, 33);

		botaoRemoverAresta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaRemoverAresta();

			}
		});

		panelControle.add(botaoRemoverAresta);
	}

	/*___________________________________________________________________________________________________________________*/
	/**
	 * Prepara o botão escolher rota.
	 */
	private void prepararBotaoEscolherRota(){
		JButton botaoEscolherRota = new JButton("Escolher Rota");
		botaoEscolherRota.setBounds(35, 198, 140, 33);

		botaoEscolherRota.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaEscolherRota();
			}
		});

		panelControle.add(botaoEscolherRota);
	}

	/*___________________________________________________________________________________________________________________*/
	/**
	 * Prepara o botão mostrar grafo.
	 */
	private void prepararBotaoMostrarGrafo(){
		JButton botaoMostrarGrafo = new JButton("Mostrar Grafo");
		botaoMostrarGrafo.setBounds(35, 243, 140, 33);

		botaoMostrarGrafo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaMostrarGrafo(listaDePontos, listaDeLinhas);
				panelArea.repaint();
			}
		});

		panelControle.add(botaoMostrarGrafo);
	}

	/*___________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel area para cadastrar o ponto.
	 */
	private void prepararPanelAreaCadastrarPonto(){
		prepararPanelArea();
		Ponto ponto = new Ponto();

		textFieldNome = new JTextField("Insira o nome aqui!");
		textFieldNome.setSize(120, 20);
		textFieldNome.setLocation(130, 20);
		textFieldNome.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// Evento não utilizado.
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				textFieldNome.setText("");
			}
		});

		panelArea.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// Evento não utilizado.

			}

			@Override
			public void mousePressed(MouseEvent e) {
				ponto.setX(e.getX());
				ponto.setY(e.getY());
				String nome = textFieldNome.getText();
				if(nome.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Insira um nome primeiro");
					return;
				}
				ponto.setNome(textFieldNome.getText());

				try {
					controller.cadastrarPonto(ponto.getNome());
					listaDePontos.add(ponto);
					desenharPonto(ponto);
					JOptionPane.showMessageDialog(null, "Ponto inserido com sucesso");
					prepararPanelArea();
				} catch (NomeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, "Já existe ponto com o nome cadastrado!");
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Evento não utilizado.
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// Evento não utilizado.

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Evento não utilizado.

			}
		});
		panelArea.add(textFieldNome);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Desenha o ponto recebido no panel area.
	 * @param ponto - Ponto a ser desenhado na tela.
	 */
	private void desenharPonto(Ponto ponto){
		Graphics grap = panelArea.getGraphics();
		grap.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);
		grap.drawString(ponto.getNome(), ponto.getX() - RAIO - 5, ponto.getY() - RAIO - 5);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel de cadastro de aresta.
	 */
	private void prepararPanelAreaCadastrarAresta(){

		prepararPanelArea();

		Linha linha = new Linha();

		JComboBox<String> comboInicio = new JComboBox<String>();
		JComboBox<String> comboFim = new JComboBox<String>();

		for(Ponto ponto : listaDePontos){
			comboInicio.addItem(ponto.getNome());
		}
		comboInicio.setSize(140, 20);
		comboInicio.setLocation(130, 20);
		panelArea.add(comboInicio);

		for(Ponto ponto : listaDePontos){
			comboFim.addItem(ponto.getNome());
		}
		comboFim.setSize(140, 20);
		comboFim.setLocation(130, 60);

		JLabel labelPeso = new JLabel("Peso");
		labelPeso.setBounds(190, 80, 40, 40);
		panelArea.add(labelPeso);

		JTextField textNumber = new JTextField();
		textNumber.setText("1");
		textNumber.setHorizontalAlignment(JLabel.CENTER);// Posiciona o texto no centro do Label.
		textNumber.setEditable(false);
		textNumber.setBounds(180, 110, 50, 20);
		panelArea.add(textNumber);

		JButton botaoMenos = new JButton("-");
		botaoMenos.setBounds(110, 110, 50, 20);

		botaoMenos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String valorString = textNumber.getText();
				int valorInteiro = Integer.parseInt(valorString);

				if(valorInteiro == 1){
					return;
				} else{
					textNumber.setText(Integer.toString(--valorInteiro));
				}

			}
		});

		panelArea.add(botaoMenos);

		JButton botaoMais = new JButton("+");
		botaoMais.setBounds(250, 110, 50, 20);

		botaoMais.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String valorString = textNumber.getText();
				int valorInteiro = Integer.parseInt(valorString);

				textNumber.setText(Integer.toString(++valorInteiro));

			}
		});

		panelArea.add(botaoMais);

		JButton botaoCriarAresta = new JButton("Criar Aresta");
		botaoCriarAresta.setSize(140, 20);
		botaoCriarAresta.setLocation(130, 160);

		botaoCriarAresta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ponto ponto1, ponto2;
				if(listaDePontos.size() <= 1){
					JOptionPane.showMessageDialog(null, "Não existe pontos suficientes!");
					return;
				}
				ponto1 = listaDePontos.get(comboInicio.getSelectedIndex());
				ponto2 = listaDePontos.get(comboFim.getSelectedIndex());
				if(ponto1.equals(ponto2)){
					JOptionPane.showMessageDialog(null, "Você não pode criar uma aresta com inicio e fim iguais");
					return;
				} 
				else {
					String valorString = textNumber.getText();
					int valorInteiro = Integer.parseInt(valorString);
					linha.setPonto1(ponto1);
					linha.setPonto2(ponto2);
					linha.setCusto(valorInteiro);

					Iterator<Linha> it = listaDeLinhas.iterator();
					Linha aux;
					while(it.hasNext()){
						aux = it.next();
						if((aux.getPonto1().equals(ponto1) && aux.getPonto2().equals(ponto2)) || (aux.getPonto1().equals(ponto2) && aux.getPonto2().equals(ponto1))){
							JOptionPane.showMessageDialog(null, "Já existe aresta cadastrada entre os pontos");
							return;
						}
					}

					controller.cadastrarCaminho(ponto1.getNome(), ponto2.getNome(), linha.getCusto());
					listaDeLinhas.add(linha);
					JOptionPane.showMessageDialog(null, "Aresta Cadastrada!");
					prepararPanelArea();
				}
			}
		});
		panelArea.add(botaoCriarAresta);
		panelArea.add(comboFim);
	}
	
	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel de remoção do ponto.
	 */
	private void prepararPanelAreaRemoverPonto(){
		prepararPanelArea();

		JComboBox<String> comboRemover = new JComboBox<String>();
		comboRemover.setSize(140, 20);
		comboRemover.setLocation(100, 20);

		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDePontos.size(); i++){
			comboRemover.addItem(listaDePontos.get(i).getNome());
		}

		panelArea.add(comboRemover);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setSize(100, 20);
		botaoRemover.setLocation(260, 20);

		botaoRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaDePontos.size() == 0)
					JOptionPane.showMessageDialog(null, "Não existem pontos a serem removidos!");
				else{
					Ponto ponto = listaDePontos.remove(comboRemover.getSelectedIndex());
					Linha linha = null;
					for(int i = 0; i < listaDeLinhas.size(); i++){
						linha = listaDeLinhas.get(i);
						if(linha.getPonto1().equals(ponto) || linha.getPonto2().equals(ponto)){
							listaDeLinhas.remove(i);
						}
					}
					JOptionPane.showMessageDialog(null, "Ponto Removido!");
					prepararPanelArea();
				}

			}
		});
		panelArea.add(botaoRemover);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel de remoção da aresta.
	 */
	private void prepararPanelAreaRemoverAresta(){
		prepararPanelArea();

		JComboBox<String> comboRemover = new JComboBox<String>();
		comboRemover.setSize(140, 20);
		comboRemover.setLocation(100, 20);

		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDeLinhas.size(); i++){
			comboRemover.addItem(listaDeLinhas.get(i).getPonto1().getNome() + " - " + listaDeLinhas.get(i).getPonto2().getNome());
		}

		panelArea.add(comboRemover);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setSize(100, 20);
		botaoRemover.setLocation(260, 20);

		botaoRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaDeLinhas.size() == 0)
					JOptionPane.showMessageDialog(null, "Não existem arestas a serem removidas!");
				else{
					Linha linha = listaDeLinhas.remove(comboRemover.getSelectedIndex());
					controller.removerCaminho(linha.getPonto1().getNome(), linha.getPonto2().getNome());
					JOptionPane.showMessageDialog(null, "Aresta Removida!");
					prepararPanelArea();
				}

			}
		});
		panelArea.add(botaoRemover);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel para a escolha da rota.
	 */
	private void prepararPanelAreaEscolherRota(){
		prepararPanelArea();

		JLabel labelGaragem = new JLabel("Garagem");
		labelGaragem.setSize(100, 20);
		labelGaragem.setLocation(60, 20);
		panelArea.add(labelGaragem);

		JComboBox<String> comboGaragem = new JComboBox<String>();
		comboGaragem.setSize(140, 20);
		comboGaragem.setLocation(130, 20);
		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDePontos.size(); i++){
			comboGaragem.addItem(listaDePontos.get(i).getNome());
		}
		panelArea.add(comboGaragem);

		JLabel labelColeta = new JLabel("Coleta");
		labelColeta.setSize(100, 20);
		labelColeta.setLocation(60, 60);
		panelArea.add(labelColeta);

		JComboBox<String> comboColeta = new JComboBox<String>();
		comboColeta.setSize(140, 20);
		comboColeta.setLocation(130, 60);
		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDePontos.size(); i++){
			comboColeta.addItem(listaDePontos.get(i).getNome());
		}
		panelArea.add(comboColeta);

		JLabel labelBanco = new JLabel("Banco");
		labelBanco.setSize(100, 20);
		labelBanco.setLocation(60, 100);
		panelArea.add(labelBanco);

		JComboBox<String> comboBanco = new JComboBox<String>();
		comboBanco.setSize(140, 20);
		comboBanco.setLocation(130, 100);
		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDePontos.size(); i++){
			comboBanco.addItem(listaDePontos.get(i).getNome());
		}
		panelArea.add(comboBanco);

		JButton botaoGerarRota = new JButton("Gerar Rota");
		botaoGerarRota.setSize(140, 20);
		botaoGerarRota.setLocation(130, 140);

		botaoGerarRota.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(listaDePontos.size() <= 0){
					JOptionPane.showMessageDialog(null, "Não existe pontos suficientes!");
					return;
				}

				Ponto pontoGaragem = listaDePontos.get(comboGaragem.getSelectedIndex());
				Ponto pontoColeta = listaDePontos.get(comboColeta.getSelectedIndex());
				Ponto pontoBanco = listaDePontos.get(comboBanco.getSelectedIndex());

				if(pontoGaragem.equals(pontoColeta)){
					JOptionPane.showMessageDialog(null, "O ponto de coleta não pode ser o mesmo que a garagem!");
					return;
				} else if(pontoColeta.equals(pontoBanco)){
					JOptionPane.showMessageDialog(null, "O ponto de coleta não pode ser o mesmo que o banco!");
					return;
				}

				try {
					desenharGrafo(pontoGaragem.getNome(), pontoColeta.getNome(), pontoBanco.getNome());
				} catch (CaminhoInexistenteException e1) {
					JOptionPane.showMessageDialog(null, "Não exite o caminho entre os pontos!");
				}
			}
		});
		panelArea.add(botaoGerarRota);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Desenha o grafo criado com os pontos de rota escolhido.
	 * @param nome1 - Ponto da garagem.
	 * @param nome2 - Ponto de coleta.
	 * @param nome3 - Ponto do banco.
	 * @throws CaminhoInexistenteException - Caso não exista caminho entre algum dos pontos escolhidos.
	 */
	private void desenharGrafo(String nome1, String nome2, String nome3) throws CaminhoInexistenteException{
		List<List<Vertice>> caminhos = controller.menorCaminho(nome1, nome2);
		if(caminhos == null){
			throw new CaminhoInexistenteException();
		}
		linhasCaminhos = new ArrayList<Linha>();// Reinicializa a lista, para poder criar novos caminhos.
		criarLinhas(caminhos);
		caminhos = controller.menorCaminho(nome2, nome3);
		criarLinhas(caminhos);
		prepararPanelMostrarMenorCaminho(linhasCaminhos);
		panelArea.repaint();
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Busca o ponto a partir do nome.
	 * @param nome - Nome do ponto a ser buscado.
	 * @return ponto - Ponto encontrado || null -  Caso o ponto não exista.
	 */
	private Ponto buscarPonto(String nome){
		Ponto ponto = null;
		Iterator<Ponto> it = listaDePontos.iterator();
		while(it.hasNext()){
			ponto = it.next();
			if(ponto.getNome().equals(nome))
				return ponto;
		}
		return null;
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Busca a linha a partir dos pontos composto por elas.
	 * @param ponto1 - Ponto da linha.
	 * @param ponto2 - Ponto da linha.
	 * @return linha - Linha encontrada || null - Caso a linha não exista.
	 */
	private Linha buscarLinha(Ponto ponto1, Ponto ponto2){
		Iterator<Linha> it = listaDeLinhas.iterator();
		Linha linha = null;
		while(it.hasNext()){
			linha = it.next();
			if(linha.getPonto1().equals(ponto1) && linha.getPonto2().equals(ponto2)){
				return linha;
			}
			else if(linha.getPonto1().equals(ponto2) && linha.getPonto2().equals(ponto1)){
				return linha;
			}
		}
		return null;
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel para exibição do grafo formado pelos pontos e linhas recebidos.
	 * @param pontos - Lista de pontos.
	 * @param linhas - Lista de linhas.
	 */
	private void prepararPanelAreaMostrarGrafo(List<Ponto> pontos, List<Linha> linhas){
		this.remove(panelArea);
		panelArea = new PanelGrafo(pontos, linhas);
		panelArea.setSize(386, 540);
		panelArea.setLocation(214, 0);
		this.add(panelArea);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Prepara o panel para exibir o menor caminho formado pelas linhas recebidas.
	 * @param linhas - Lista de linhas.
	 */
	private void prepararPanelMostrarMenorCaminho(List<Linha> linhas){
		this.remove(panelArea);
		panelArea = new PanelMenorCaminho(linhas);
		panelArea.setSize(386, 540);
		panelArea.setLocation(214, 0);
		this.add(panelArea);
	}

	/*____________________________________________________________________________________________________________________*/
	/**
	 * Cria a lista de linhas para os caminhos existentes na lista de caminhos possíveis.
	 * @param caminhos - Lista de caminhos.
	 */
	private void criarLinhas(List<List<Vertice>> caminhos){

		Ponto ponto = null;
		Ponto ponto2 = null;
		Linha linha = null;

		Iterator<Vertice> itV = null;

		for(List<Vertice> caminho : caminhos){
			itV = caminho.iterator();
			while(itV.hasNext()){
				ponto = buscarPonto(itV.next().getObjeto().toString());
				if(ponto2 == null){
					ponto2 = ponto;
				} else{
					linha = buscarLinha(ponto, ponto2);
					linhasCaminhos.add(linha);
					ponto2 = ponto;
				}
			}
			ponto2 = null;
		}

	}
}
