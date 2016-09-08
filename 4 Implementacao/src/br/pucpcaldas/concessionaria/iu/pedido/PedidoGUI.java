package br.pucpcaldas.concessionaria.iu.pedido;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorPedido;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorProdutos;
import br.pucpcaldas.concessionaria.iu.principal.PrincipalGUI;

public class PedidoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bNovo = null;
	private JButton bSair = null;
	private JScrollPane jScrollPane = null;
	private JTable tProdutos = null;
	ControladorProdutos controlador = new ControladorProdutos();  //  @jve:decl-index=0:
	int numeroPedido;
	ControladorPedido controladorPedido = new ControladorPedido();  //  @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public PedidoGUI() {
		super();
		numeroPedido = (controladorPedido.getNumeroUltimoPedido()) + 1;
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
		this.setTitle("Pedidos");
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
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(20, 0, 20, 0);
			lTitulo = new JLabel();
			lTitulo.setText("Pedidos");
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
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(10, 10, 10, 0);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(10, 0, 10, 10);
			pSul = new JPanel();
			pSul.setLayout(new GridBagLayout());
			pSul.add(getBNovo(), gridBagConstraints1);
			pSul.add(getBSair(), gridBagConstraints3);
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
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.gridx = 0;
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(getJScrollPane(), gridBagConstraints4);
		}
		return pCentro;
	}

	/**
	 * This method initializes bNovo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBNovo() {
		if (bNovo == null) {
			bNovo = new JButton();
			bNovo.setText("Novo");
			bNovo.setIcon(new ImageIcon(getClass().getResource("/imagens/12-em-plus.png")));
			bNovo.setFont(new Font("Dialog", Font.BOLD, 14));
			bNovo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NovoItemGUI novoItemGui = null;
					try {
						novoItemGui = new NovoItemGUI(numeroPedido);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					novoItemGui.setVisible(true);
					dispose();
				}
			});
		}
		return bNovo;
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
					PrincipalGUI principalGui = new PrincipalGUI();
					principalGui.setVisible(true);
					dispose();
				}
			});
		}
		return bSair;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTProdutos());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tProdutos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTProdutos() {
		if (tProdutos == null) {
			tProdutos = controladorPedido.getTabelaPedidos();
		}
		return tProdutos;
	}

}
