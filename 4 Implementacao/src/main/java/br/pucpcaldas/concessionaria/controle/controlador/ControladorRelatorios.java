package br.pucpcaldas.concessionaria.controle.controlador;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import br.pucpcaldas.concessionaria.dominio.Cliente;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;

public class ControladorRelatorios {
	private Document doc = null;
	private OutputStream os = null;
	private Paragraph p;
	private PdfPTable table;
	private Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
	private ControladorClientes controladorClientes = new ControladorClientes();
	List<Cliente> listaClientes = null;

//	Método responsável por criar um arquivo em  PDF em C:\\testes\\Relatorio.pdf
//	com as informações dos clientes através de uma tabela 
	public void criarRelatorio() throws Exception{

		try {
			//cria o documento tamanho A4, margens de 2,54cm
			doc =  new Document(PageSize.A4, 72, 72,72,72);

			//associa a stream de saída ao
			os = new FileOutputStream("C:\\testes\\Relatorio.pdf");

			//associa a stream de saída ao
			PdfWriter.getInstance(doc, os);

			//abre o documento
			doc.open();

			//adiciona o texto ao PDF
			p = new Paragraph("Relatorio de todos os Clientes", f);
			p.setAlignment(Element.ALIGN_CENTER);
			p.setSpacingAfter(20);						
			doc.add(p);

			criarTabelaDeClientes();

		} finally{
			if(doc != null){
				System.out.println("Relatorio criado! Doc.close executado!");
				doc.close();
			}

			if(os != null){
				os.close();
			}
		}

	}
	
//	Método responsável por criar e retornar uma tabela com os dados dos Clientes
	private void criarTabelaDeClientes() throws Exception{
		table = new PdfPTable(4);


		listaClientes = controladorClientes.getListClientesTodasInformacoes();
		int i;

		table.addCell("Nome");
		table.addCell("Municipio");
		table.addCell("CEP");
		table.addCell("CPF");


		for(i = 0; i < listaClientes.size(); i++){
			table.addCell(listaClientes.get(i).getNome());
			table.addCell(listaClientes.get(i).getMunicipio());
			table.addCell(listaClientes.get(i).getCep());
			table.addCell(listaClientes.get(i).getCpf());
		}

		doc.add(table);
	}

//	Método responsável por abrir o relatório corrente
	public void abrirRelatorio(){
		String caminho = "c:\\testes\\Relatorio.pdf";
		File arquivo = new File(caminho);  
		try {  
			Desktop.getDesktop().open(arquivo);  
		} catch (Exception ex) {  
			ex.printStackTrace();  
			JOptionPane.showMessageDialog(null, ex,  "ERRO",JOptionPane.ERROR_MESSAGE);  

		}  
	}

}