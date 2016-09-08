package br.pucpcaldas.concessionaria.iu.estoque;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorEstoque;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.dominio.Estoque;
import br.pucpcaldas.concessionaria.dominio.Notificacao;
import br.pucpcaldas.concessionaria.dominio.Produto;

public class AtualizaEstoqueGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bConfirmar = null;
	private JButton bCancelar = null;
	private JLabel lProduto = null;
	private JLabel lQuantidade = null;
	ControladorEstoque controladorEstoque = new ControladorEstoque();
	ControladorProdutos controladorProdutos = new ControladorProdutos();  //  @jve:decl-index=0:
	private JTextField tfQuantidade = null;
	private JComboBox cbProduto = null;
	List<Produto> listaProdutos = null;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public AtualizaEstoqueGUI() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 300);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Atualiza Estoque");
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
			gridBagConstraints1.insets = new Insets(15, 0, 15, 0);
			lTitulo = new JLabel();
			lTitulo.setText("Atualiza Estoque");
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
			gridBagConstraints2.insets = new Insets(10, 200, 10, 10);
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
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(10, 5, 10, 0);
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.insets = new Insets(10, 5, 10, 50);
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.ipadx = 0;
			gridBagConstraints6.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints5.gridy = 0;
			lQuantidade = new JLabel();
			lQuantidade.setText("Quantidade:");
			lQuantidade.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(10, 50, 10, 0);
			gridBagConstraints3.gridy = 0;
			lProduto = new JLabel();
			lProduto.setText("Produto:");
			lProduto.setFont(new Font("Dialog", Font.BOLD, 14));
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(lProduto, gridBagConstraints3);
			pCentro.add(lQuantidade, gridBagConstraints5);
			pCentro.add(getTfQuantidade(), gridBagConstraints6);
			pCentro.add(getCbProduto(), gridBagConstraints4);
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
					String produto = cbProduto.getSelectedItem().toString();
					int idProduto = 0;
					for(int i=0; i < listaProdutos.size(); i++){
						if(listaProdutos.get(i).getProduto().equals(produto)){
							idProduto = listaProdutos.get(i).getIdProduto();
						}
					}
					int quantidade = Integer.parseInt(tfQuantidade.getText());
					Estoque estoque = new Estoque(idProduto, quantidade);
					boolean resposta = controladorEstoque.atualizaEstoque(estoque);
					Notificacao mensagem = new Notificacao();
					mensagem.notificacaoAtualizarProduto(resposta);
					if(resposta == true){
						EstoqueGUI estoqueGui = new EstoqueGUI();
						estoqueGui.setVisible(true);
						dispose();
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
					EstoqueGUI estoqueGui = new EstoqueGUI();
					estoqueGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCancelar;
	}

	/**
	 * This method initializes tfQuantidade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfQuantidade() {
		if (tfQuantidade == null) {
			tfQuantidade = new JTextField();
		}
		return tfQuantidade;
	}

	/**
	 * This method initializes cbProduto	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbProduto() {
		if (cbProduto == null) {
			cbProduto = new JComboBox();
			cbProduto.setPreferredSize(new Dimension(31, 22));
			cbProduto.addItem("- Selecione o produto");
			listaProdutos = controladorProdutos.getListaProdutos();
			for(int i = 0; i < listaProdutos.size(); i++){
				cbProduto.addItem(listaProdutos.get(i).getProduto());
			}
		}
		return cbProduto;
	}

}
