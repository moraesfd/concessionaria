package br.pucpcaldas.concessionaria.iu.principal;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.ImageIcon;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorRelatorios;
import br.pucpcaldas.concessionaria.iu.cliente.ClienteGUI;
import br.pucpcaldas.concessionaria.iu.estoque.EstoqueGUI;
import br.pucpcaldas.concessionaria.iu.pedido.PedidoGUI;
import br.pucpcaldas.concessionaria.iu.produto.ProdutoGUI;
import br.pucpcaldas.concessionaria.iu.vendedor.VendedorGUI;

public class PrincipalGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bSair = null;
	private JButton bCliente = null;
	private JButton bProduto = null;
	private JButton bVendedor = null;
	private JButton bPedido = null;
	private JButton bEstoque = null;
	private JButton bRelatorio = null;
	ControladorRelatorios controladorRelatorio = new ControladorRelatorios();  //  @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public PrincipalGUI() {
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
		this.setTitle("Sistema de Concessionária de Automóveis");
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
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(20, 0, 20, 0);
			lTitulo = new JLabel();
			lTitulo.setText("Sistema de Concessionária de Automóveis");
			lTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
			pNorte = new JPanel();
			pNorte.setLayout(new GridBagLayout());
			pNorte.add(lTitulo, gridBagConstraints);
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
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(10, 650, 10, 0);
			pSul = new JPanel();
			pSul.setLayout(new GridBagLayout());
			pSul.add(getBSair(), gridBagConstraints1);
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
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.insets = new Insets(20, 20, 20, 0);
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.gridy = 2;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.insets = new Insets(20, 20, 20, 0);
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.gridy = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.insets = new Insets(20, 20, 20, 0);
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.insets = new Insets(20, 0, 20, 20);
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.insets = new Insets(20, 0, 20, 20);
			gridBagConstraints3.gridy = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.insets = new Insets(20, 0, 20, 20);
			gridBagConstraints2.gridy = 0;
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(getBCliente(), gridBagConstraints2);
			pCentro.add(getBProduto(), gridBagConstraints3);
			pCentro.add(getBVendedor(), gridBagConstraints4);
			pCentro.add(getBPedido(), gridBagConstraints5);
			pCentro.add(getBEstoque(), gridBagConstraints6);
			pCentro.add(getBRelatorio(), gridBagConstraints7);
		}
		return pCentro;
	}

	/**
	 * This method initializes bSair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBSair() {
		if (bSair == null) {
			bSair = new JButton();
			bSair.setText("Sair");
			bSair.setIcon(new ImageIcon(getClass().getResource("/imagens/12-em-cross.png")));
			bSair.setFont(new Font("Dialog", Font.BOLD, 14));
			bSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return bSair;
	}

	/**
	 * This method initializes bCliente	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCliente() {
		if (bCliente == null) {
			bCliente = new JButton();
			bCliente.setText("Clientes");
			bCliente.setFont(new Font("Dialog", Font.BOLD, 18));
			bCliente.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ClienteGUI clienteGui = new ClienteGUI();
					clienteGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCliente;
	}

	/**
	 * This method initializes bProduto	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBProduto() {
		if (bProduto == null) {
			bProduto = new JButton();
			bProduto.setText("Produtos");
			bProduto.setFont(new Font("Dialog", Font.BOLD, 18));
			bProduto.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ProdutoGUI produtoGui = new ProdutoGUI();
					produtoGui.setVisible(true);
					dispose();
				}
			});
		}
		return bProduto;
	}

	/**
	 * This method initializes bVendedor	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBVendedor() {
		if (bVendedor == null) {
			bVendedor = new JButton();
			bVendedor.setText("Vendedores");
			bVendedor.setFont(new Font("Dialog", Font.BOLD, 18));
			bVendedor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					VendedorGUI vendedorGui = new VendedorGUI();
					vendedorGui.setVisible(true);
					dispose();
				}
			});
		}
		return bVendedor;
	}

	/**
	 * This method initializes bPedido	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBPedido() {
		if (bPedido == null) {
			bPedido = new JButton();
			bPedido.setText("Pedidos");
			bPedido.setFont(new Font("Dialog", Font.BOLD, 18));
			bPedido.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PedidoGUI pedidoGui = new PedidoGUI();
					pedidoGui.setVisible(true);
					dispose();
				}
			});
		}
		return bPedido;
	}

	/**
	 * This method initializes bEstoque	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBEstoque() {
		if (bEstoque == null) {
			bEstoque = new JButton();
			bEstoque.setText("Estoque");
			bEstoque.setFont(new Font("Dialog", Font.BOLD, 18));
			bEstoque.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EstoqueGUI estoqueGui = new EstoqueGUI();
					estoqueGui.setVisible(true);
					dispose();
				}
			});
		}
		return bEstoque;
	}

	/**
	 * This method initializes bRelatorio	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBRelatorio() {
		if (bRelatorio == null) {
			bRelatorio = new JButton();
			bRelatorio.setText("Relatórios");
			bRelatorio.setFont(new Font("Dialog", Font.BOLD, 18));
			bRelatorio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					try {
						controladorRelatorio.criarRelatorio();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					controladorRelatorio.abrirRelatorio();
				}
			});
		}
		return bRelatorio;
	}
}
