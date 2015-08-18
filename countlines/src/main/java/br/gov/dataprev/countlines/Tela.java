/**
 * 
 */
package br.gov.dataprev.countlines;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author adrianopatrick@gmail.com
 * @since 18 de ago de 2015
 */
public class Tela extends JFrame {

	private static final long serialVersionUID = 1338475988185391608L;
	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private static Contador contador = new Contador();
	private static final String SUFIXO_JAVA = ".java";
	private static final String SUFIXO_XHTML = ".xhtml";
	private static final String SUFIXO_JS = ".js";
	private static final String SUFIXO_CSS = ".css";
	private static final String SUFIXO_HTML = ".html";
	private static final String SUFIXO_HTM = ".htm";
	private static final String SUFIXO_JSP = ".jsp";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbGit = new JLabel("https://github.com/adrianopatrick/countlines.git");
		lbGit.setBounds(10, 29, 147, 14);
		
		JLabel lblDiretrioDoProjeto = new JLabel("Diretório do Projeto:");
		lblDiretrioDoProjeto.setBounds(10, 29, 147, 14);
		contentPane.add(lblDiretrioDoProjeto);

		textField = new JTextField();
		textField.setBounds(140, 26, 259, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnDiretorio = new JButton("Diretorio");
		btnDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(panel);
				contentPane.remove(panel_1);
				contentPane.repaint();
				JFileChooser file = new JFileChooser(new File(System.getProperty("user.home")));
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					textField.setText("");
				} else {
					File arquivo = file.getSelectedFile();
					textField.setText(arquivo.getPath());
					contentPane.add(panel_1);
					contentPane.repaint();
				}

			}
		});
		btnDiretorio.setBounds(402, 25, 89, 23);
		contentPane.add(btnDiretorio);

		JButton btnContar = new JButton("Contar");
		btnContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador.zeraContadores();
				contador.contador(textField.getText());
				lblNewLabel.setText(contador.getQtdaLinhas().toString());
				lblNewLabel_1.setText(contador.getQtdaClasses().toString());
				lblNewLabel_2.setText(contador.getQtdaDiretorios().toString());
				contentPane.add(panel);
				contentPane.repaint();
			}
		});
		btnContar.setBounds(222, 71, 89, 23);
		contentPane.add(btnContar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 209, 523, 2);
		contentPane.add(separator);

		panel = new JPanel();
		panel.setBounds(10, 207, 523, 115);
		panel.setLayout(null);

		JLabel lblTotalizadores = new JLabel("Totalizadores");
		lblTotalizadores.setBounds(10, 11, 91, 14);
		panel.add(lblTotalizadores);

		JLabel lblTotalDeLinhas = new JLabel("Total de Linhas:");
		lblTotalDeLinhas.setBounds(10, 35, 119, 14);
		panel.add(lblTotalDeLinhas);

		JLabel lblTotalDeClasses = new JLabel("Total de Classes");
		lblTotalDeClasses.setBounds(10, 54, 119, 14);
		panel.add(lblTotalDeClasses);

		JLabel lblTotalDeDiretrios = new JLabel("Total de Diretórios:");
		lblTotalDeDiretrios.setBounds(10, 75, 126, 14);
		panel.add(lblTotalDeDiretrios);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(139, 35, 46, 14);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(139, 54, 46, 14);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(139, 75, 46, 14);
		panel.add(lblNewLabel_2);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 105, 523, 93);
		panel_1.setLayout(null);

		JCheckBox chckbxjava = new JCheckBox(SUFIXO_JAVA);
		chckbxjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxjava, SUFIXO_JAVA);
			}
		});
		chckbxjava.setBounds(391, 33, 97, 23);
		panel_1.add(chckbxjava);

		JCheckBox chckbxxhtml = new JCheckBox(SUFIXO_XHTML);
		chckbxxhtml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxxhtml, SUFIXO_XHTML);
			}
		});
		chckbxxhtml.setBounds(267, 33, 97, 23);
		panel_1.add(chckbxxhtml);

		JCheckBox chckbxjs = new JCheckBox(SUFIXO_JS);
		chckbxjs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxjs, SUFIXO_JS);
			}
		});
		chckbxjs.setBounds(143, 33, 97, 23);
		panel_1.add(chckbxjs);

		JCheckBox chckbxcss = new JCheckBox(SUFIXO_CSS);
		chckbxjs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxcss, SUFIXO_CSS);
			}
		});
		chckbxcss.setBounds(267, 63, 97, 23);
		panel_1.add(chckbxcss);
		
		JCheckBox chckbxhtml = new JCheckBox(SUFIXO_HTML);
		chckbxhtml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxhtml, SUFIXO_HTML);
			}
		});
		chckbxhtml.setBounds(20, 33, 97, 23);
		panel_1.add(chckbxhtml);
		
		JCheckBox chckbxhtm = new JCheckBox(SUFIXO_HTM);
		chckbxhtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxhtm, SUFIXO_HTM);
			}
		});
		chckbxhtm.setBounds(20, 63, 97, 23);
		panel_1.add(chckbxhtm);
		
		JCheckBox chckbxjsp = new JCheckBox(SUFIXO_JSP);
		chckbxjsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checked(chckbxjsp, SUFIXO_JSP);
			}
		});
		chckbxjsp.setBounds(143, 63, 97, 23);
		panel_1.add(chckbxjsp);

		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setBounds(10, 11, 46, 14);
		panel_1.add(lblFiltros);

	}
	
	public static void checked(JCheckBox checkbox, final String sufixo){
		if(checkbox.isSelected()){
			contador.addSufixo(sufixo);
		} else {
			contador.removeSufixo(sufixo);
		}
	}
}
