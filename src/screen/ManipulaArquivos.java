package screen;

import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ManipulaArquivos {

	// metodo para ler um arquivo txt e criar um poligono usando ele
	public Polygon recebeArquivo() {

		Polygon p = new Polygon();

		String linha;
		String caminhoDoArquivo;
		JFileChooser arquivoEscolhido = new JFileChooser();

		arquivoEscolhido
				.setFileFilter(new javax.swing.filechooser.FileFilter() {
					// Filtro, converte as letras em minúsculas antes de
					// comparar
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".txt")
								|| f.isDirectory();
					}

					// Texto que será exibido para o usuário
					public String getDescription() {
						return "Arquivos de txt (.txt)";
					}
				});

		// seleciona caminho do arquivo
		int retorno = arquivoEscolhido.showOpenDialog(null);

		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoDoArquivo = arquivoEscolhido.getSelectedFile()
					.getAbsolutePath();

			try {
				// faz a leitura do arquivo
				FileReader reader = new FileReader(new File(caminhoDoArquivo));
				BufferedReader leitor = new BufferedReader(reader);

				while ((linha = leitor.readLine()) != null) {
					// o numero deve estar no formato *9999,99999* para ser lido
					p.addPoint(Integer.parseInt(linha.substring(0,
							linha.indexOf(","))), Integer.parseInt(linha
							.substring(linha.indexOf(",") + 1, linha.length())));
				}

				leitor.close();
				reader.close();
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado");
		}

		return p;
	}

	// Em teste
	public void enviaArquivo(Polygon p) {

		int[] pontosX = p.xpoints;
		int[] pontosY = p.ypoints;
		String arquivo = "E:\\Poligono.txt";

		try {

			if(p.npoints > 0){				

			File file = new File(arquivo);
			file.delete();
			FileWriter writer = new FileWriter(new File(arquivo),
					true);
			PrintWriter saida = new PrintWriter(writer, true);
			saida.println("x,y");
			

			
			
			for (int i = 0; i < pontosY.length; i++) {
				saida.println(pontosX[i] + "," + pontosY[i]);
			}

			writer.flush();
			writer.close();
			JOptionPane.showMessageDialog(null, "Arquivo gerado no c:");
			
			}else{
				JOptionPane.showMessageDialog(null, "Não existe nenhum poligono desenhado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}