package br.pucpcaldas.concessionaria.controle.controlador;

import java.sql.SQLException;

import javax.swing.JTable;

import com.sun.org.apache.regexp.internal.recompile;

import br.pucpcaldas.concessionaria.controle.repositorio.OrganizacaoDeEstoque;
import br.pucpcaldas.concessionaria.dominio.Estoque;

public class ControladorEstoque {
	
	private OrganizacaoDeEstoque organizacaoEstoque;
	
	public ControladorEstoque() {
		organizacaoEstoque = new OrganizacaoDeEstoque();
	}
	
//	Método responsável por criar e retornar uma tabela com os dados do Estoque	
	public JTable getTabelaEstoque(){
		JTable tabela = organizacaoEstoque.getTabelaEstoque();
		return tabela;
	}
	
	
//	Método responsável por criar e inserir uma nova instância de Estoque ao banco de dados
	public boolean cadastraEstoqueProduto(int idProduto, int quantidade){
		boolean retorno = false;
		if(idProduto == 0 || quantidade == 0){
			retorno = false;
		}else{
			Estoque estoque = new Estoque(idProduto, quantidade);
			try {
				organizacaoEstoque.cadastraEstoqueProduto(estoque);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				retorno = false;
			}
			retorno = true;
		}
		return retorno;
	}
	
//	Método responsável por alterar informações sobre o Estoque no banco de dados
	public boolean atualizaEstoque(Estoque estoque){
		try {
			if(estoque.getQuantidade() < 0.0){
				return false;
			}else{
				organizacaoEstoque.atualizaEstoque(estoque);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
