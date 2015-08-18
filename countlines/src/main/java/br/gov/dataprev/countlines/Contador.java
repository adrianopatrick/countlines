/**
 * 
 */
package br.gov.dataprev.countlines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adrianopatrick@gmail.com
 * @since 18 de ago de 2015
 */
public class Contador {

	private Long qtdaLinhas = 0L;
	private Long qtdaDiretorios = 0L;
	private Long qtdaClasses = 0L;
	private List<String> sufixos = new ArrayList<String>();

	public void contador(String path) {
		File diretorio = new File(path);
		File[] files = diretorio.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				this.contador(file.getAbsolutePath());
			} else {
				qtdaDiretorios++;
				for (String sufixo : sufixos) {
					if (file.getName().endsWith(sufixo)) {
						this.contaLinhas(file);
						break;
					}
				}
				if (file.getName().endsWith(".java")) {
					qtdaClasses++;
				}

			}
		}
	}

	public void contaLinhas(File file) {
		try (BufferedReader arquivo = new BufferedReader(
				new FileReader(file))) {
			String linha = null;
			while ((linha = arquivo.readLine()) != null) {
				if (!linha.trim().equals("")) {
					qtdaLinhas++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the qtdaLinhas
	 */
	public Long getQtdaLinhas() {
		return qtdaLinhas;
	}

	/**
	 * @return the qtdaDiretorios
	 */
	public Long getQtdaDiretorios() {
		return qtdaDiretorios;
	}

	/**
	 * @return the qtdaClasses
	 */
	public Long getQtdaClasses() {
		return qtdaClasses;
	}

	/**
	 * @param sufixos
	 *            the sufixos to set
	 */
	public void addSufixo(String sufixo) {
		this.sufixos.add(sufixo);
	}

	public void removeSufixo(String sufixo) {
		this.sufixos.remove(sufixo);
	}

	public void zeraContadores() {
		this.qtdaLinhas = 0L;
		this.qtdaClasses = 0L;
		this.qtdaDiretorios = 0L;
	}

}
