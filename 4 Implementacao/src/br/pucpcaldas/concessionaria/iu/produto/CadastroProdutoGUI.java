package br.pucpcaldas.concessionaria.iu.produto;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorEstoque;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.dominio.Adicional;
import br.pucpcaldas.concessionaria.dominio.Cor;
import br.pucpcaldas.concessionaria.dominio.Notificacao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CadastroProdutoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bConfirmar = null;
	private JButton bCancelar = null;
	private JLabel lProduto = null;
	private JTextField tfProduto = null;
	private JLabel lPeso = null;
	private JTextField tfPeso = null;
	private JLabel lDescricao = null;
	private JTextField tfDescricao = null;
	private JLabel lValor = null;
	private JTextField tfValor = null;
	private JLabel lCor = null;
	private JComboBox cbCor = null;
	private JComboBox cbAdicional = null;
	private JLabel lAdicional = null;
	ControladorProdutos controlador = new ControladorProdutos();  //  @jve:decl-index=0:
	List<Cor> listaCores = null;  //  @jve:decl-index=0:
	List<Adicional> listaAdicionais = null;
	private JLabel lQtdInicial = null;
	private JTextField tfQtdInicial = null;
	ControladorEstoque controleEstoque = new ControladorEstoque();  //  @jve:decl-index=0:
	
	/**
	 * This is the default constructor
	 */
	public CadastroProdutoGUI() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 500);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Produtos");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPNorte(), BorderLayout.NORTH);
			jContentPane.add(getPSul(), BorderLayout.SOUTH);
			jContentPane.add(getPCentro(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes pNorte	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPNorte() {
		if (pNorte == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(20, 0, 20, 0);
			lTitulo = new JLabel();
			lTitulo.setText("Cadastro de Produtos");
			lTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
			pNorte = new JPanel();
			pNorte.setLayout(new GridBagLayout());
			pNorte.add(lTitulo, gridBagConstraints1);
		}
		return pNorte;
	}

	/**
	 * This method initializes pSul	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPSul() {
		if (pSul == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(10, 500, 10, 10);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints.gridy = 0;
			pSul = new JPanel();
			pSul.setLayout(new GridBagLayout());
			pSul.add(getBConfirmar(), gridBagConstraints2);
			pSul.add(getBCancelar(), gridBagConstraints);
		}
		return pSul;
	}

	/**
	 * This method initializes pCentro	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPCentro() {
		if (pCentro == null) {
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 6;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.insets = new Insets(5, 5, 5, 20);
			gridBagConstraints8.gridx = 4;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 3;
			gridBagConstraints7.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints7.anchor = GridBagConstraints.EAST;
			gridBagConstraints7.gridy = 6;
			lQtdInicial = new JLabel();
			lQtdInicial.setFont(new Font("Dialog", Font.BOLD, 14));
			lQtdInicial.setText("Qtd. Inicial:");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 6;
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints4.gridy = 5;
			lAdicional = new JLabel();
			lAdicional.setFont(new Font("Dialog", Font.BOLD, 14));
			lAdicional.setText("Adicional:");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 5;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(5, 5, 5, 100);
			gridBagConstraints3.gridx = 7;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.fill = GridBagConstraints.BOTH;
			gridBagConstraints22.gridy = 5;
			gridBagConstraints22.weightx = 1.0;
			gridBagConstraints22.insets = new Insets(5, 5, 5, 20);
			gridBagConstraints22.gridx = 4;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 3;
			gridBagConstraints21.anchor = GridBagConstraints.EAST;
			gridBagConstraints21.insets = new Insets(10, 100, 10, 0);
			gridBagConstraints21.gridy = 5;
			lCor = new JLabel();
			lCor.setText("Cor:");
			lCor.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.BOTH;
			gridBagConstraints20.gridy = 2;
			gridBagConstraints20.weightx = 1.0;
			gridBagConstraints20.gridwidth = 1;
			gridBagConstraints20.insets = new Insets(5, 5, 5, 100);
			gridBagConstraints20.anchor = GridBagConstraints.WEST;
			gridBagConstraints20.ipadx = 0;
			gridBagConstraints20.gridx = 7;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 6;
			gridBagConstraints19.anchor = GridBagConstraints.EAST;
			gridBagConstraints19.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints19.gridy = 2;
			lValor = new JLabel();
			lValor.setText("Valor Unitário:");
			lValor.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 1;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.anchor = GridBagConstraints.WEST;
			gridBagConstraints16.insets = new Insets(5, 5, 5, 100);
			gridBagConstraints16.ipadx = 1;
			gridBagConstraints16.gridwidth = 5;
			gridBagConstraints16.gridheight = 1;
			gridBagConstraints16.gridx = 4;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 3;
			gridBagConstraints15.anchor = GridBagConstraints.EAST;
			gridBagConstraints15.insets = new Insets(10, 100, 10, 0);
			gridBagConstraints15.gridy = 1;
			lDescricao = new JLabel();
			lDescricao.setText("Descrição:");
			lDescricao.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 2;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.insets = new Insets(5, 5, 5, 20);
			gridBagConstraints10.gridwidth = 2;
			gridBagConstraints10.gridheight = 1;
			gridBagConstraints10.ipadx = 0;
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.gridx = 4;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 3;
			gridBagConstraints9.anchor = GridBagConstraints.EAST;
			gridBagConstraints9.insets = new Insets(10, 100, 10, 0);
			gridBagConstraints9.gridy = 2;
			lPeso = new JLabel();
			lPeso.setText("Peso:");
			lPeso.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 0.0;
			gridBagConstraints6.insets = new Insets(5, 5, 5, 100);
			gridBagConstraints6.gridwidth = 5;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.ipadx = 1;
			gridBagConstraints6.gridheight = 1;
			gridBagConstraints6.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(10, 100, 10, 0);
			gridBagConstraints5.gridy = 0;
			lProduto = new JLabel();
			lProduto.setText("Produto:");
			lProduto.setFont(new Font("Dialog", Font.BOLD, 14));
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(lProduto, gridBagConstraints5);
			pCentro.add(getTfProduto(), gridBagConstraints6);
			pCentro.add(lPeso, gridBagConstraints9);
			pCentro.add(getTfPeso(), gridBagConstraints10);
			pCentro.add(lDescricao, gridBagConstraints15);
			pCentro.add(getTfDescricao(), gridBagConstraints16);
			pCentro.add(lValor, gridBagConstraints19);
			pCentro.add(getTfValor(), gridBagConstraints20);
			pCentro.add(lCor, gridBagConstraints21);
			pCentro.add(getCbCor(), gridBagConstraints22);
			pCentro.add(getCbAdicional(), gridBagConstraints3);
			pCentro.add(lAdicional, gridBagConstraints4);
			pCentro.add(lQtdInicial, gridBagConstraints7);
			pCentro.add(getTfQtdInicial(), gridBagConstraints8);
		}
		return pCentro;
	}

	/**
	 * This method initializes bConfirmar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBConfirmar() {
		if (bConfirmar == null) {
			bConfirmar = new JButton();
			bConfirmar.setText("Confirmar");
			bConfirmar.setIcon(new ImageIcon(getClass().getResource("/imagens/Ok0.png")));
			bConfirmar.setFont(new Font("Dialog", Font.BOLD, 14));
			bConfirmar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Cor corSelecionada = controlador.getCorSelecionada(cbCor.getSelectedItem().toString());
					Adicional adicionalSelecionado = controlador.getAdicionalSelecionado(cbAdicional.getSelectedItem().toString());
					boolean resposta1 = controlador.cadastrarProduto(tfProduto.getText(), tfDescricao.getText(), Double.parseDouble(tfPeso.getText()), corSelecionada, adicionalSelecionado, Double.parseDouble(tfValor.getText()));
					if(resposta1 == true){
						int idProduto = controlador.getIdUltimoProdutoCadastrado();
						int quantidade = Integer.parseInt(tfQtdInicial.getText());
						boolean resposta2 = controleEstoque.cadastraEstoqueProduto(idProduto, quantidade);
						Notificacao mensagem = new Notificacao();
						mensagem.notificacaoCadastrarProduto(resposta1, resposta2);
						if(resposta2 == true){
							ProdutoGUI produtoGui = new ProdutoGUI();
							produtoGui.setVisible(true);
							dispose();
						}
					}
				}
			});
		}
		return bConfirmar;
	}

	/**
	 * This method initializes bCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCancelar() {
		if (bCancelar == null) {
			bCancelar = new JButton();
			bCancelar.setText("Cancelar");
			bCancelar.setIcon(new ImageIcon(getClass().getResource("/imagens/12-em-cross.png")));
			bCancelar.setFont(new Font("Dialog", Font.BOLD, 14));
			bCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ProdutoGUI produtoGui = new ProdutoGUI();
					produtoGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCancelar;
	}

	/**
	 * This method initializes tfProduto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfProduto() {
		if (tfProduto == null) {
			tfProduto = new JTextField();
		}
		return tfProduto;
	}

	/**
	 * This method initializes tfPeso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfPeso() {
		if (tfPeso == null) {
			tfPeso = new JTextField();
		}
		return tfPeso;
	}

	/**
	 * This method initializes tfDescricao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfDescricao() {
		if (tfDescricao == null) {
			tfDescricao = new JTextField();
		}
		return tfDescricao;
	}

	/**
	 * This method initializes tfValor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfValor() {
		if (tfValor == null) {
			tfValor = new JTextField();
		}
		return tfValor;
	}

	/**
	 * This method initializes cbCor	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws Exception 
	 */
	private JComboBox getCbCor(){
		if (cbCor == null) {
			cbCor = new JComboBox();
			cbCor.setPreferredSize(new Dimension(31, 22));
			cbCor.addItem("- Selecione a cor");
			listaCores = controlador.getListaCores();

			for(int i = 0; i < listaCores.size(); i++){
				cbCor.addItem(listaCores.get(i).getCor());
			}
		}
		return cbCor;
	}

	/**
	 * This method initializes cbAdicional	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbAdicional() {
		if (cbAdicional == null) {
			cbAdicional = new JComboBox();
			cbAdicional.setPreferredSize(new Dimension(31, 22));
			cbAdicional.addItem("- Selecione o Adicional");
			listaAdicionais = controlador.getListaAdicionais();

			for(int i = 0; i < listaAdicionais.size(); i++){
				cbAdicional.addItem(listaAdicionais.get(i).getAdicional());
			}
		}
		return cbAdicional;
	}

	/**
	 * This method initializes tfQtdInicial	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfQtdInicial() {
		if (tfQtdInicial == null) {
			tfQtdInicial = new JTextField();
		}
		return tfQtdInicial;
	}

	

}
