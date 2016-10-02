package br.pucpcaldas.concessionaria.iu.cliente;

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
import javax.swing.JTextField;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorClientes;
import br.pucpcaldas.concessionaria.dominio.Notificacao;

public class CadastroClienteGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bConfirmar = null;
	private JButton bCancelar = null;
	private JLabel lNome = null;
	private JTextField tfNome = null;
	private JLabel lCpf = null;
	private JTextField tfCpf = null;
	private JLabel lEndereco = null;
	private JTextField tfEndereco = null;
	private JLabel lNumero = null;
	private JTextField tfNumero = null;
	private JLabel lBairro = null;
	private JTextField tfBairro = null;
	private JLabel lMunicipio = null;
	private JTextField tfMunicipio = null;
	private JLabel lCep = null;
	private JTextField tfCep = null;
	private JLabel lTelefone = null;
	private JTextField tfTelefone = null;
	private JLabel lUf = null;
	private JTextField tfUf = null;
	ControladorClientes controlador = new ControladorClientes();  //  @jve:decl-index=0:
	
	/**
	 * This is the default constructor
	 */
	public CadastroClienteGUI() {
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
		this.setTitle("Cadastro de Clientes");
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
			lTitulo.setText("Cadastro de Clientes");
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
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints14.gridy = 4;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.anchor = GridBagConstraints.WEST;
			gridBagConstraints14.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints14.ipadx = 50;
			gridBagConstraints14.gridx = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.anchor = GridBagConstraints.EAST;
			gridBagConstraints13.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints13.gridy = 4;
			lUf = new JLabel();
			lUf.setText("UF:");
			lUf.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints20.gridy = 3;
			gridBagConstraints20.weightx = 1.0;
			gridBagConstraints20.gridwidth = 2;
			gridBagConstraints20.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints20.anchor = GridBagConstraints.WEST;
			gridBagConstraints20.ipadx = 120;
			gridBagConstraints20.gridx = 4;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 3;
			gridBagConstraints19.anchor = GridBagConstraints.EAST;
			gridBagConstraints19.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints19.gridy = 3;
			lTelefone = new JLabel();
			lTelefone.setText("Telefone:");
			lTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.BOTH;
			gridBagConstraints18.gridy = 3;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints18.gridwidth = 2;
			gridBagConstraints18.gridx = 1;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.anchor = GridBagConstraints.EAST;
			gridBagConstraints17.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints17.gridy = 3;
			lCep = new JLabel();
			lCep.setText("CEP:");
			lCep.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 2;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.anchor = GridBagConstraints.WEST;
			gridBagConstraints16.insets = new Insets(5, 5, 5, 100);
			gridBagConstraints16.ipadx = 1;
			gridBagConstraints16.gridx = 5;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 3;
			gridBagConstraints15.anchor = GridBagConstraints.EAST;
			gridBagConstraints15.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints15.gridy = 2;
			lMunicipio = new JLabel();
			lMunicipio.setText("Municipio");
			lMunicipio.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridy = 2;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints11.gridy = 2;
			lBairro = new JLabel();
			lBairro.setText("Bairro:");
			lBairro.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.insets = new Insets(5, 5, 5, 0);
			gridBagConstraints10.gridwidth = 2;
			gridBagConstraints10.gridheight = 1;
			gridBagConstraints10.ipadx = 50;
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.gridx = 4;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 3;
			gridBagConstraints9.anchor = GridBagConstraints.EAST;
			gridBagConstraints9.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints9.gridy = 1;
			lNumero = new JLabel();
			lNumero.setText("Número:");
			lNumero.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 1;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints8.gridwidth = 2;
			gridBagConstraints8.gridx = 1;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.anchor = GridBagConstraints.EAST;
			gridBagConstraints7.insets = new Insets(10, 50, 10, 0);
			gridBagConstraints7.gridy = 1;
			lEndereco = new JLabel();
			lEndereco.setText("Endereço:");
			lEndereco.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 0.0;
			gridBagConstraints6.insets = new Insets(5, 5, 5, 100);
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.ipadx = 1;
			gridBagConstraints6.gridheight = 1;
			gridBagConstraints6.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints5.gridy = 0;
			lCpf = new JLabel();
			lCpf.setText("CPF / CNPJ:");
			lCpf.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(10, 50, 10, 0);
			gridBagConstraints3.gridy = 0;
			lNome = new JLabel();
			lNome.setText("Nome:");
			lNome.setFont(new Font("Dialog", Font.BOLD, 14));
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(lNome, gridBagConstraints3);
			pCentro.add(getTfNome(), gridBagConstraints4);
			pCentro.add(lCpf, gridBagConstraints5);
			pCentro.add(getTfCpf(), gridBagConstraints6);
			pCentro.add(lEndereco, gridBagConstraints7);
			pCentro.add(getTfEndereco(), gridBagConstraints8);
			pCentro.add(lNumero, gridBagConstraints9);
			pCentro.add(getTfNumero(), gridBagConstraints10);
			pCentro.add(lBairro, gridBagConstraints11);
			pCentro.add(getTfBairro(), gridBagConstraints12);
			pCentro.add(lMunicipio, gridBagConstraints15);
			pCentro.add(getTfMunicipio(), gridBagConstraints16);
			pCentro.add(lCep, gridBagConstraints17);
			pCentro.add(getTfCep(), gridBagConstraints18);
			pCentro.add(lTelefone, gridBagConstraints19);
			pCentro.add(getTfTelefone(), gridBagConstraints20);
			pCentro.add(lUf, gridBagConstraints13);
			pCentro.add(getTfUf(), gridBagConstraints14);
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
					boolean resposta = controlador.cadastraCliente(tfNome.getText(), tfEndereco.getText(), Integer.parseInt(tfNumero.getText()), tfBairro.getText(), 
							tfMunicipio.getText(), tfUf.getText(), tfCep.getText(), tfTelefone.getText(), tfCpf.getText());
					Notificacao mensagem = new Notificacao();
					mensagem.notificacaoCadastrarCliente(resposta);
					if(resposta == true){
						ClienteGUI clienteGui = new ClienteGUI();
						clienteGui.setVisible(true);
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
					ClienteGUI clienteGui = new ClienteGUI();
					clienteGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCancelar;
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

	/**
	 * This method initializes tfCpf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfCpf() {
		if (tfCpf == null) {
			tfCpf = new JTextField();
		}
		return tfCpf;
	}

	/**
	 * This method initializes tfEndereco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfEndereco() {
		if (tfEndereco == null) {
			tfEndereco = new JTextField();
		}
		return tfEndereco;
	}

	/**
	 * This method initializes tfNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfNumero() {
		if (tfNumero == null) {
			tfNumero = new JTextField();
		}
		return tfNumero;
	}

	/**
	 * This method initializes tfBairro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfBairro() {
		if (tfBairro == null) {
			tfBairro = new JTextField();
		}
		return tfBairro;
	}

	/**
	 * This method initializes tfMunicipio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfMunicipio() {
		if (tfMunicipio == null) {
			tfMunicipio = new JTextField();
		}
		return tfMunicipio;
	}

	/**
	 * This method initializes tfCep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfCep() {
		if (tfCep == null) {
			tfCep = new JTextField();
		}
		return tfCep;
	}

	/**
	 * This method initializes tfTelefone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfTelefone() {
		if (tfTelefone == null) {
			tfTelefone = new JTextField();
		}
		return tfTelefone;
	}

	/**
	 * This method initializes tfUf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfUf() {
		if (tfUf == null) {
			tfUf = new JTextField();
		}
		return tfUf;
	}

}
