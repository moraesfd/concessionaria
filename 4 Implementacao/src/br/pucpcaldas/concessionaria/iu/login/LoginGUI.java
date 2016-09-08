package br.pucpcaldas.concessionaria.iu.login;

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
import br.pucpcaldas.concessionaria.controle.controlador.ControladorUsuarios;
import br.pucpcaldas.concessionaria.dominio.Notificacao;
import br.pucpcaldas.concessionaria.dominio.Usuario;
import br.pucpcaldas.concessionaria.iu.cliente.ClienteGUI;
import br.pucpcaldas.concessionaria.iu.principal.PrincipalGUI;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JButton bConfirmar = null;
	private JButton bCancelar = null;
	private JLabel lUsuario = null;
	private JLabel lSenha = null;
	ControladorUsuarios controlador = new ControladorUsuarios();;  //  @jve:decl-index=0:
	private JTextField tfUsuario = null;
	private JPasswordField pfSenha = null;
	private JButton bCadastraUsuario = null;
	/**
	 * This is the default constructor
	 */
	public LoginGUI() {
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
		this.setTitle("Concessionária de Automóveis - Login");
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
			lTitulo.setText("Concessionária de Automóveis");
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
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(10, 120, 10, 10);
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints.gridy = 0;
			pSul = new JPanel();
			pSul.setLayout(new GridBagLayout());
			pSul.add(getBConfirmar(), gridBagConstraints2);
			pSul.add(getBCancelar(), gridBagConstraints);
			pSul.add(getBCadastraUsuario(), gridBagConstraints11);
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
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridy = 1;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.insets = new Insets(10, 10, 10, 100);
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(10, 10, 10, 100);
			gridBagConstraints4.ipadx = 150;
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.insets = new Insets(10, 5, 10, 20);
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.ipadx = 0;
			gridBagConstraints6.gridx = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(10, 100, 10, 0);
			gridBagConstraints5.gridy = 1;
			lSenha = new JLabel();
			lSenha.setText("Senha:");
			lSenha.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(10, 100, 10, 0);
			gridBagConstraints3.gridy = 0;
			lUsuario = new JLabel();
			lUsuario.setText("Usuário:");
			lUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(lUsuario, gridBagConstraints3);
			pCentro.add(lSenha, gridBagConstraints5);
			pCentro.add(getTfUsuario(), gridBagConstraints4);
			pCentro.add(getPfSenha(), gridBagConstraints7);
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
					String login, senha;					
					login = getTfUsuario().getText();
					senha = getPfSenha().getText();
					
					boolean resposta = controlador.validaUsuario(login, senha);
					Notificacao notificacao = new Notificacao();
					notificacao.notificacaoLogin(resposta);
					if(resposta == true){
						PrincipalGUI principalGui = new PrincipalGUI();
						principalGui.setVisible(true);
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
					dispose();
				}
			});
		}
		return bCancelar;
	}

	/**
	 * This method initializes tfUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfUsuario() {
		if (tfUsuario == null) {
			tfUsuario = new JTextField();
		}
		return tfUsuario;
	}

	/**
	 * This method initializes pfSenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPfSenha() {
		if (pfSenha == null) {
			pfSenha = new JPasswordField();
		}
		return pfSenha;
	}

	/**
	 * This method initializes bCadastraUsuario	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBCadastraUsuario() {
		if (bCadastraUsuario == null) {
			bCadastraUsuario = new JButton();
			bCadastraUsuario.setText("");
			bCadastraUsuario.setIcon(new ImageIcon(getClass().getResource("/imagens/Mais.png")));
			bCadastraUsuario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CadastroUsuarioGUI cadastroGui = new CadastroUsuarioGUI();
					cadastroGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCadastraUsuario;
	}

}
