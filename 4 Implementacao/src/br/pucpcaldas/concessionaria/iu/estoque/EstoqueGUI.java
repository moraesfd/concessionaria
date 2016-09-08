package br.pucpcaldas.concessionaria.iu.estoque;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorEstoque;
import br.pucpcaldas.concessionaria.iu.principal.PrincipalGUI;

public class EstoqueGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bAtualizar = null;
	private JButton bSair = null;
	private JScrollPane spEstoque = null;
	private JTable tEstoque = null;
	ControladorEstoque controlador = new ControladorEstoque();

	/**
	 * This is the default constructor
	 */
	public EstoqueGUI() {
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
		this.setTitle("Estoque");
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
			lTitulo.setText("Estoque");
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
			gridBagConstraints3.insets = new Insets(10, 0, 10, 20);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(10, 0, 10, 20);
			pSul = new JPanel();
			pSul.setLayout(new GridBagLayout());
			pSul.add(getBAtualizar(), gridBagConstraints2);
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
			pCentro.add(getSpEstoque(), gridBagConstraints4);
		}
		return pCentro;
	}

	/**
	 * This method initializes bAtualizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBAtualizar() {
		if (bAtualizar == null) {
			bAtualizar = new JButton();
			bAtualizar.setText("Atualizar Estoque");
			bAtualizar.setIcon(new ImageIcon(getClass().getResource("/imagens/page_edit.png")));
			bAtualizar.setFont(new Font("Dialog", Font.BOLD, 14));
			bAtualizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AtualizaEstoqueGUI atualizaGui = new AtualizaEstoqueGUI();
					atualizaGui.setVisible(true);
					dispose();
				}
			});
		}
		return bAtualizar;
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
	 * This method initializes spEstoque	
	 * 
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSpEstoque() {
		if (spEstoque == null) {
			spEstoque = new JScrollPane();
			spEstoque.setViewportView(getTEstoque());
		}
		return spEstoque;
	}

	/**
	 * This method initializes tEstoque	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTEstoque() {
		if (tEstoque == null) {
			tEstoque = controlador.getTabelaEstoque();
			tEstoque.setFont(new Font("Dialog", Font.PLAIN, 14));
			tEstoque.setRowHeight(20);
		}
		return tEstoque;
	}

}
