package br.pucpcaldas.concessionaria.iu.pedido;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.pucpcaldas.concessionaria.controle.controlador.ControladorClientes;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorPedido;
import br.pucpcaldas.concessionaria.controle.controlador.ControladorVendedores;
import br.pucpcaldas.concessionaria.controle.repositorio.CarteiraDeClientes;
import br.pucpcaldas.concessionaria.controle.repositorio.RegistroDeVendedores;
import br.pucpcaldas.concessionaria.dominio.Cliente;
import br.pucpcaldas.concessionaria.dominio.CondicaoPagamento;
import br.pucpcaldas.concessionaria.dominio.Notificacao;
import br.pucpcaldas.concessionaria.dominio.PedidoVenda;
import br.pucpcaldas.concessionaria.dominio.StatusPedido;
import br.pucpcaldas.concessionaria.dominio.Vendedor;
import javax.swing.BorderFactory;
import java.awt.Color;

public class NovoPedidoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel pNorte = null;
	private JPanel pSul = null;
	private JPanel pCentro = null;
	private JLabel lTitulo = null;
	private JLabel lCliente = null;
	private JComboBox cbCliente = null;
	private JLabel lVendedor = null;
	private JComboBox cbVendedor = null;
	private JLabel lCondPagto = null;
	private JComboBox cbCondPagto = null;
	private JLabel lStatus = null;
	private JComboBox cbStatus = null;
	private JLabel lDesconto = null;
	private JTextField tfDesconto = null;
	private JLabel lTotal = null;
	private JTextField tfTotal = null;
	private JButton bConfirmar = null;
	private JButton bCancelar = null;
	private JScrollPane spNovoPedido = null;
	private JTable tNovoPedido = null;
	private JButton bAddItem = null;
	int numeroPedido;
	ControladorPedido controladorPedido = new ControladorPedido();  //  @jve:decl-index=0:
	List<Cliente> listaClientes = new ArrayList<Cliente>();  //  @jve:decl-index=0:
	ControladorClientes controladorClientes = new ControladorClientes();
	List<CondicaoPagamento> listaCondPagto = new ArrayList<CondicaoPagamento>();
	ControladorVendedores controladorVendedores = new ControladorVendedores();
	List<Vendedor> listaVendedores = new ArrayList<Vendedor>();  //  @jve:decl-index=0:
	List<StatusPedido> listaStatusPedido = new ArrayList<StatusPedido>();

	/**
	 * This is the default constructor
	 * @throws SQLException 
	 */
	public NovoPedidoGUI() throws SQLException {
		super();
		numeroPedido = (controladorPedido.getNumeroUltimoPedido()) + 1;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		this.setSize(800, 500);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Novo Pedido de Venda");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws SQLException 
	 */
	private JPanel getJContentPane() throws SQLException {
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
	 * @throws SQLException 
	 */
	private JPanel getPNorte() throws SQLException {
		if (pNorte == null) {
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 2;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.insets = new Insets(5, 5, 10, 60);
			gridBagConstraints8.gridx = 3;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 2;
			gridBagConstraints7.anchor = GridBagConstraints.EAST;
			gridBagConstraints7.insets = new Insets(5, 0, 10, 0);
			gridBagConstraints7.gridy = 2;
			lStatus = new JLabel();
			lStatus.setText("Status Atual:");
			lStatus.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 2;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.insets = new Insets(5, 5, 10, 20);
			gridBagConstraints6.gridx = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(5, 60, 10, 0);
			gridBagConstraints5.gridy = 2;
			lCondPagto = new JLabel();
			lCondPagto.setText("Cond. de Pagto:");
			lCondPagto.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(5, 5, 5, 60);
			gridBagConstraints4.gridx = 3;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(5, 0, 5, 0);
			gridBagConstraints3.gridy = 1;
			lVendedor = new JLabel();
			lVendedor.setText("Vendedor:");
			lVendedor.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(5, 5, 5, 20);
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.EAST;
			gridBagConstraints1.insets = new Insets(5, 60, 5, 0);
			gridBagConstraints1.gridy = 1;
			lCliente = new JLabel();
			lCliente.setText("Cliente:");
			lCliente.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(20, 0, 10, 0);
			gridBagConstraints.gridwidth = 4;
			lTitulo = new JLabel();
			lTitulo.setText("Novo Pedido de Venda");
			lTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
			pNorte = new JPanel();
			pNorte.setLayout(new GridBagLayout());
			pNorte.add(lTitulo, gridBagConstraints);
			pNorte.add(lCliente, gridBagConstraints1);
			pNorte.add(getCbCliente(), gridBagConstraints2);
			pNorte.add(lVendedor, gridBagConstraints3);
			pNorte.add(getCbVendedor(), gridBagConstraints4);
			pNorte.add(lCondPagto, gridBagConstraints5);
			pNorte.add(getCbCondPagto(), gridBagConstraints6);
			pNorte.add(lStatus, gridBagConstraints7);
			pNorte.add(getCbStatus(), gridBagConstraints8);
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
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 4;
			gridBagConstraints16.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints16.gridy = 0;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.insets = new Insets(10, 20, 10, 0);
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 6;
			gridBagConstraints13.insets = new Insets(10, 10, 10, 20);
			gridBagConstraints13.gridy = 0;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 5;
			gridBagConstraints12.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints12.gridy = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.insets = new Insets(10, 5, 10, 10);
			gridBagConstraints11.gridx = 3;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 2;
			gridBagConstraints10.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints10.gridy = 0;
			lTotal = new JLabel();
			lTotal.setText("Total:");
			lTotal.setFont(new Font("Dialog", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.BOTH;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.insets = new Insets(10, 5, 10, 10);
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.ipadx = 0;
			gridBagConstraints9.gridx = 1;
			lDesconto = new JLabel();
			lDesconto.setText("Desconto (%):");
			lDesconto.setFont(new Font("Dialog", Font.BOLD, 14));
			pSul = new JPanel();
			pSul.setLayout(new GridBagLayout());
			pSul.add(lDesconto, gridBagConstraints14);
			pSul.add(getTfDesconto(), gridBagConstraints9);
			pSul.add(lTotal, gridBagConstraints10);
			pSul.add(getTfTotal(), gridBagConstraints11);
			pSul.add(getBConfirmar(), gridBagConstraints12);
			pSul.add(getBCancelar(), gridBagConstraints13);
			pSul.add(getBAddItem(), gridBagConstraints16);
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
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.BOTH;
			gridBagConstraints15.gridy = 0;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.weighty = 1.0;
			gridBagConstraints15.gridx = 0;
			pCentro = new JPanel();
			pCentro.setLayout(new GridBagLayout());
			pCentro.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
			pCentro.add(getSpNovoPedido(), gridBagConstraints15);
		}
		return pCentro;
	}

	/**
	 * This method initializes cbCliente	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws SQLException 
	 */
	private JComboBox getCbCliente() throws SQLException {
		if (cbCliente == null) {
			cbCliente = new JComboBox();
			cbCliente.setPreferredSize(new Dimension(31, 22));
			cbCliente.setFont(new Font("Dialog", Font.BOLD, 14));

			listaClientes = controladorClientes.getListClientes();
			int contador = 0;
			
			while(contador < listaClientes.size()){
				cbCliente.addItem(listaClientes.get(contador).getNome());
				contador++;
			}
			
		}
		return cbCliente;
	}

	/**
	 * This method initializes cbVendedor	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws SQLException 
	 */
	private JComboBox getCbVendedor() throws SQLException {
		if (cbVendedor == null) {
			cbVendedor = new JComboBox();
			cbVendedor.setPreferredSize(new Dimension(31, 22));
			cbVendedor.setFont(new Font("Dialog", Font.BOLD, 14));

			listaVendedores = controladorVendedores.getListVendedor();
			
			int contador = 0;
			
			while(contador < listaVendedores.size()){
				cbVendedor.addItem(listaVendedores.get(contador).getNome());
				contador++;
			}
			
			
		}
		return cbVendedor;
	}

	/**
	 * This method initializes cbCondPagto	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws SQLException 
	 */
	private JComboBox getCbCondPagto() throws SQLException {
		if (cbCondPagto == null) {
			cbCondPagto = new JComboBox();
			cbCondPagto.setPreferredSize(new Dimension(31, 22));
			cbCondPagto.setFont(new Font("Dialog", Font.BOLD, 14));
			
			listaCondPagto = controladorPedido.getListCondicaoPagamento();
			int contador = 0;
			
			while(contador < listaCondPagto.size()){
				cbCondPagto.addItem(listaCondPagto.get(contador).getDescricao());
				contador++;
			}
		}
		return cbCondPagto;
	}

	/**
	 * This method initializes cbStatus	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws SQLException 
	 */
	private JComboBox getCbStatus() throws SQLException {
		if (cbStatus == null) {
			cbStatus = new JComboBox();
			cbStatus.setPreferredSize(new Dimension(31, 22));
			cbStatus.setFont(new Font("Dialog", Font.BOLD, 14));			
			
			listaStatusPedido = controladorPedido.getListStatusPedido();
			int contador = 0;
			
			while(contador < listaStatusPedido.size()){
				cbStatus.addItem(listaStatusPedido.get(contador).getDescricao());
				contador++;
			}
		}
		return cbStatus;
	}

	/**
	 * This method initializes tfDesconto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfDesconto() {
		if (tfDesconto == null) {
			tfDesconto = new JTextField();
			tfDesconto.setFont(new Font("Dialog", Font.PLAIN, 14));
			tfDesconto.setText("0");
		}
		return tfDesconto;
	}

	/**
	 * This method initializes tfTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfTotal() {
		if (tfTotal == null) {
			tfTotal = new JTextField();
			tfTotal.setFont(new Font("Dialog", Font.PLAIN, 14));
			tfTotal.setEditable(false);
			double valorTotal = controladorPedido.getValorTotalPedidoCorrente(numeroPedido);
			System.out.println(valorTotal);
			tfTotal.setText(String.valueOf(valorTotal));
		}
		return tfTotal;
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
					int contador = 0;
					String clienteSelecionado = cbCliente.getSelectedItem().toString();
					String condPagtoSelecionada = cbCondPagto.getSelectedItem().toString();
					String vendedorSelecionado = cbVendedor.getSelectedItem().toString();
					String statusSelecionado = cbStatus.getSelectedItem().toString();
					double porcentagem = Double.parseDouble(tfDesconto.getText())/100;
					double campoTotal = Double.parseDouble(tfTotal.getText());
					double valorTotal = campoTotal-(campoTotal*porcentagem);
					Cliente cliente = null;
					CondicaoPagamento cond = null;
					Vendedor vend = null;
					StatusPedido status = null;
					
					for(int i = 0; i < listaClientes.size(); i++){
						if(listaClientes.get(i).getNome().equals(clienteSelecionado)){
							cliente = listaClientes.get(i);
						}
					}
					for(int i = 0; i < listaCondPagto.size(); i++){
						if(listaCondPagto.get(i).getDescricao().equals(condPagtoSelecionada)){
							cond = listaCondPagto.get(i);
						}
					}
					for(int i = 0; i < listaVendedores.size(); i++){
						if(listaVendedores.get(i).getNome().equals(vendedorSelecionado)){
							vend = listaVendedores.get(i);
						}
					}
					for(int i = 0; i < listaStatusPedido.size(); i++){
						if(listaStatusPedido.get(i).getDescricao().equals(statusSelecionado)){
							status = listaStatusPedido.get(i);
						}
					}
					PedidoVenda pedido = new PedidoVenda(numeroPedido, cliente, vend, cond, status, porcentagem, valorTotal);
					controladorPedido.inserePedido(pedido);
					JOptionPane.showMessageDialog(null,"Pedido cadastrado com sucesso !!",null, JOptionPane.INFORMATION_MESSAGE);
					PedidoGUI pedidoGui = new PedidoGUI();
					pedidoGui.setVisible(true);
					dispose();					
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
					controladorPedido.deletaItensPedidoCorrente(numeroPedido);
					PedidoGUI pedidoGui = new PedidoGUI();
					pedidoGui.setVisible(true);
					dispose();
				}
			});
		}
		return bCancelar;
	}

	/**
	 * This method initializes spNovoPedido	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSpNovoPedido() {
		if (spNovoPedido == null) {
			spNovoPedido = new JScrollPane();
			spNovoPedido.setViewportView(getTNovoPedido());
		}
		return spNovoPedido;
	}

	/**
	 * This method initializes tNovoPedido	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTNovoPedido() {
		if (tNovoPedido == null) {
			tNovoPedido = controladorPedido.getTabelaItens(numeroPedido);
			
		}
		return tNovoPedido;
	}

	/**
	 * This method initializes bAddItem	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBAddItem() {
		if (bAddItem == null) {
			bAddItem = new JButton();
			bAddItem.setText("Item");
			bAddItem.setIcon(new ImageIcon(getClass().getResource("/imagens/Mais.png")));
			bAddItem.setFont(new Font("Dialog", Font.BOLD, 14));
			bAddItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					NovoItemGUI itemGui = new NovoItemGUI(numeroPedido);
					itemGui.setVisible(true);
					dispose();
				}
			});
		}
		return bAddItem;
	}

}
