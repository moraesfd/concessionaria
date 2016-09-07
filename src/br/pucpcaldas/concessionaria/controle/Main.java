package br.pucpcaldas.concessionaria.controle;

import javax.swing.UIManager;

import br.pucpcaldas.concessionaria.iu.login.LoginGUI;
import br.pucpcaldas.concessionaria.iu.principal.PrincipalGUI;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try 
	    {
	      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	    } 
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	    }
		
		LoginGUI gui = new LoginGUI();
		gui.setVisible(true);
	    
//	    PrincipalGUI gui = new PrincipalGUI();
//		gui.setVisible(true);

	}

}
