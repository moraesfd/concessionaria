package br.pucpcaldas.concessionaria.iu.vendedor;

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

import br.pucpcaldas.concessionaria.controle.controlador.ControladorClientes;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorVendedores;
import br.pucpcaldas.concessionaria.dominio.Notificacao;
import br.pucpcaldas.concessionaria.iu.cliente.ClienteGUI;

import java.awt.Color;

public class CadastroVendedorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bConfirmar = null;
	private JButton bCancelar = null;
	private JLabel lNome = null;
	private JLabel lComissao = null;
	ControladorVendedores controlador = new ControladorVendedores();  //  @jve:decl-index=0:
	private JTextField tfComissao = null;
	private JTextField tfNome = null;
	/**
	 * This is the default constructor
	 */
	public CadastroVendedorGUI() {
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
		this.setTitle("Cadastrar Vendedor");
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
			lTitulo.setText("Cadastrar Vendedor");
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
			gridBagConstraints4.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints4.ipadx = 150;
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.insets = new Insets(5, 5, 5, 20);
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.ipadx = 0;
			gridBagConstraints6.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints5.gridy = 0;
			lComissao = new JLabel();
			lComissao.setText("Comissão (%):");
			lComissao.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(10, 20, 10, 0);
			gridBagConstraints3.gridy = 0;
			lNome = new JLabel();
			lNome.setText("Nome:");
			lNome.setFont(new Font("Dialog", Font.BOLD, 14));
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(lNome, gridBagConstraints3);
			pCentro.add(lComissao, gridBagConstraints5);
			pCentro.add(getTfComissao(), gridBagConstraints6);
			pCentro.add(getTfNome(), gridBagConstraints4);
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
					boolean resposta = controlador.cadastraVendedor(tfNome.getText(), Double.parseDouble(tfComissao.getText()));
					Notificacao mensagem = new Notificacao();
					mensagem.notificacaoCadastrarVendedor(resposta);
					if(resposta == true){
						VendedorGUI vendedorGui = new VendedorGUI();
						vendedorGui.setVisible(true);
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
					VendedorGUI vendedorGui = new VendedorGUI();
					vendedorGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCancelar;
	}

	/**
	 * This method initializes tfComissao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfComissao() {
		if (tfComissao == null) {
			tfComissao = new JTextField();
		}
		return tfComissao;
	}

	/**
	 * This method initializes tfNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
		}
		return tfNome;
	}

}
