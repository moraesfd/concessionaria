package br.pucpcaldas.concessionaria.dominio;

import javax.swing.JOptionPane;

public class Notificacao {
	
	public void notificacaoCadastrarCliente(boolean resposta){
		if(resposta == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void notificacaoCadastrarProduto(boolean resposta1, boolean resposta2){
		if(resposta1 == false || resposta2 == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void notificacaoCadastrarVendedor(boolean resposta){
		if(resposta == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Vendedor cadastrado com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
	}

	public void notificacaoAtualizarProduto(boolean resposta) {
		if(resposta == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Estoque atualizado com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void notificacaoLogin(boolean resposta) {
		if(resposta == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Login realizado com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void notificacaoCadastraUsuario(boolean resposta) {
		if(resposta == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void notificacaoInsereProduto(boolean resposta) {
		if(resposta == false){
			JOptionPane.showMessageDialog(null,"Há campos Vazios, preencha todos os campos para continuar !",null, JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,"Produto inserido com sucesso !",null, JOptionPane.INFORMATION_MESSAGE);
		
	}

}
