package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.sun.org.apache.regexp.internal.recompile;

import br.pucpcaldas.concessionaria.controle.repositorio.LivroDePedidos;
import br.pucpcaldas.concessionaria.dominio.CondicaoPagamento;
import br.pucpcaldas.concessionaria.dominio.ItemPedidoVenda;
import br.pucpcaldas.concessionaria.dominio.PedidoVenda;
import br.pucpcaldas.concessionaria.dominio.StatusPedido;

public class ControladorPedido {
	
	LivroDePedidos livroPedidos = new LivroDePedidos();
	List<CondicaoPagamento> lista;
	
	
//	M�todo respons�vel por criar e retornar uma lista com as poss�veis condi��es de pagamento
	public List<CondicaoPagamento> getListCondicaoPagamento(){			
		try {
			lista = livroPedidos.getCondicaoPagamento();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
	}
	
//	M�todo respons�vel por criar e retornar uma lista com os status do Pedido
	public List<StatusPedido> getListStatusPedido(){
		List<StatusPedido> lista = new ArrayList<StatusPedido>();			
		LivroDePedidos lvPedidos = new LivroDePedidos();
		
		try {
			lista = lvPedidos.getStatusPedido();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;		
	} 
	
//	M�todo respons�vel por retornar o ID do �ltimo peido que foi feito
	public int getNumeroUltimoPedido(){
		int idPedido = livroPedidos.getNumeroUltimoPedido();
		return idPedido;
	}

//	M�todo respons�vel por retornar o ID do �ltimo item que foi inserido ao pedido	
	public int getNumeroPedidoUltimoItem(){
		int idPedido = livroPedidos.getNumeroPedidoUltimoItem();
		return idPedido;
	}
	
//	M�todo respons�vel por criar e inserir uma nova inst�ncia de Item de venda ao banco de dados
	public boolean insereItem(ItemPedidoVenda item){
		try {
			livroPedidos.insereItem(item);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}
	
//	M�todo respons�vel por criar e retornar uma tabela com os dados dos Itens de um Pedido
	public JTable getTabelaItens(int numPedido){
		JTable tabela = livroPedidos.getTabelaItens(numPedido);
		return tabela;
	}
	
//	M�todo respons�vel por criar e retornar uma tabela com os dados dos Pedidos	
	public JTable getTabelaPedidos(){
		JTable tabela = livroPedidos.getTabelaPedidos();
		return tabela;
	}
	
//	M�todo respons�vel por deletar o pedido caso o pedido n�o seja confirmado
	public void deletaItensPedidoCorrente(int numPedido){
		try {
			livroPedidos.deletaItensPedidoCorrente(numPedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	M�todo respons�vel por obter o valor total do Pedido
	public double getValorTotalPedidoCorrente(int numPedido){
		double valorTotalPedido = livroPedidos.getValorTotalPedidoCorrente(numPedido);
		return valorTotalPedido;
	}
	
//	M�todo respons�vel por inserir uma nova inst�ncia de Pedido de venda ao banco de dados
	public void inserePedido(PedidoVenda pedido){
		try {
			livroPedidos.inserePedido(pedido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
