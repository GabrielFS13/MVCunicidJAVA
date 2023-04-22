package br.edu.unicid.view;




import javax.swing.*;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.text.MaskFormatter;

import br.edu.unicid.dao.AlunoDAO;
import br.edu.unicid.dao.NotasDAO;
import br.edu.unicid.model.Aluno;
import br.edu.unicid.model.Notas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;

import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import java.awt.CardLayout;


public class VIEW {

	public JFrame frmAlunos;
	private JTextField txtRGM;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtMunicipio;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField consultRGM;
	private JTextField txtFaltas;
	private String selected_turn;
	

	private JTextField rgm_boletim;
	private JTable table_1;
	private JTextField otherBoletimRGM;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEW frame = new VIEW();
					frame.frmAlunos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public VIEW() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception{
		frmAlunos = new JFrame();
		frmAlunos.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\T-GAMER\\Pictures\\mikageee.jpg"));
		frmAlunos.setTitle("Sistema de Alunos");
		frmAlunos.setBounds(100, 100, 692, 475);
		frmAlunos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlunos.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 52, 660, 380);
		frmAlunos.getContentPane().add(tabbedPane);
		
		JPanel DadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, DadosPessoais, null);
		DadosPessoais.setLayout(null);
		
		JLabel RGM = new JLabel("RGM");
		RGM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RGM.setBounds(10, 22, 46, 14);
		DadosPessoais.add(RGM);
		
		txtRGM = new JTextField();
		txtRGM.setColumns(10);
		txtRGM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRGM.setBounds(45, 21, 199, 20);
		DadosPessoais.add(txtRGM);
		
		JLabel NOME = new JLabel("Nome");
		NOME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NOME.setBounds(283, 24, 46, 14);
		DadosPessoais.add(NOME);
		
		txtNome = new JTextField();
		txtNome.setBounds(339, 21, 306, 20);
		DadosPessoais.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 68, 165, 14);
		DadosPessoais.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(457, 68, 46, 14);
		DadosPessoais.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 121, 46, 14);
		DadosPessoais.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 120, 579, 20);
		DadosPessoais.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 172, 65, 14);
		DadosPessoais.add(lblNewLabel_3);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(85, 171, 560, 20);
		DadosPessoais.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Município");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 236, 67, 14);
		DadosPessoais.add(lblNewLabel_4);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(89, 235, 86, 20);
		DadosPessoais.add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("UF");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(198, 236, 46, 14);
		DadosPessoais.add(lblNewLabel_5);
		
		JComboBox<?> boxUf = new JComboBox();
		boxUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		boxUf.setBounds(232, 234, 56, 22);
		DadosPessoais.add(boxUf);
		
		JLabel lblNewLabel_6 = new JLabel("Celular");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(324, 238, 65, 14);
		DadosPessoais.add(lblNewLabel_6);
		
		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(498, 67, 147, 20);
		DadosPessoais.add(txtCpf);
		
		JFormattedTextField txtCelular = new JFormattedTextField(new MaskFormatter("(##) #-########"));
		txtCelular.setBounds(399, 235, 246, 20);
		DadosPessoais.add(txtCelular);
		
		JFormattedTextField txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData.setBounds(160, 67, 147, 20);
		DadosPessoais.add(txtData);
		
		JPanel Curso = new JPanel();
		tabbedPane.addTab("Curso", null, Curso, null);
		Curso.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Curso");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 23, 46, 14);
		Curso.add(lblNewLabel_7);
		
		JComboBox boxCurso = new JComboBox();
		boxCurso.setModel(new DefaultComboBoxModel(new String[] {"", "Análise e Desenvolvimento de Sistemas", "Banco de Dados", "Ciência da Computação", "Ciência de Dados", "Desenvolvimento Back-end", "Desenvolvimento Mobile", "Engenharia da Computação", "Engenharia de Software", "Inteligência Artificial", "Jogos Digitais", "Redes de Computadores", "Segurança da Informação", "Sistema de informação", "Sistemas para Internet"}));
		boxCurso.setBounds(66, 21, 579, 22);
		Curso.add(boxCurso);
		
		JLabel lblNewLabel_8 = new JLabel("Campus");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(10, 65, 65, 14);
		Curso.add(lblNewLabel_8);
		
		JComboBox boxCampus = new JComboBox();
		boxCampus.setModel(new DefaultComboBoxModel(new String[] {"", "Tatuapé", "Pinheiros"}));
		boxCampus.setBounds(76, 63, 569, 22);
		Curso.add(boxCampus);
		
		JLabel lblNewLabel_9 = new JLabel("Período");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 121, 65, 14);
		Curso.add(lblNewLabel_9);
		
		JRadioButton matutino = new JRadioButton("Matutino");
		matutino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_turn = "Matutino";
			}
		});
		matutino.setBounds(116, 119, 109, 23);
		Curso.add(matutino);
		
		JRadioButton vesperino = new JRadioButton("Vesperino");
		vesperino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_turn = "Vesperino";
			}
		});
		vesperino.setBounds(242, 119, 109, 23);
		Curso.add(vesperino);
		
		JRadioButton noturno = new JRadioButton("Noturno");
		noturno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_turn = "Noturno";
			}
		});
		noturno.setBounds(374, 119, 109, 23);
		Curso.add(noturno);
		
		bg.add(noturno);
		bg.add(vesperino);
		bg.add(matutino);
		
		JButton btnNewButton = new JButton("Apaga?");
		btnNewButton.setBounds(43, 204, 100, 100);
		Curso.add(btnNewButton);
		
		JButton btnSalva = new JButton("Salva?");
		btnSalva.setBounds(153, 204, 100, 100);
		Curso.add(btnSalva);
		
		JButton btnLista = new JButton("Lista?");
		btnLista.setBounds(263, 204, 100, 100);
		Curso.add(btnLista);
		
		JButton btnAtualiza = new JButton("Atualiza?");
		btnAtualiza.setBounds(374, 204, 100, 100);
		Curso.add(btnAtualiza);
		
		JButton btnNemIdeia = new JButton("novo?");
		btnNemIdeia.setBounds(484, 204, 100, 100);
		Curso.add(btnNemIdeia);
		
		JPanel NotasEfaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, NotasEfaltas, null);
		NotasEfaltas.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("RGM");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(22, 24, 46, 14);
		NotasEfaltas.add(lblNewLabel_10);
		
		JLabel labelAluno = new JLabel("");
		labelAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAluno.setBounds(235, 26, 410, 14);
		NotasEfaltas.add(labelAluno);
		
		JLabel labelCursoAluno = new JLabel("");
		labelCursoAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCursoAluno.setBounds(22, 69, 623, 14);
		NotasEfaltas.add(labelCursoAluno);
		
		consultRGM = new JTextField();
		consultRGM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					AlunoDAO dao = new AlunoDAO();
					//busca o aluno com vinculado com o rgm informado
					Aluno currentAluno = dao.procurarAluno(consultRGM.getText());
					labelAluno.setText(currentAluno.getNome());
					labelCursoAluno.setText(currentAluno.getCurso());
					
								
				} catch(Exception e1) {
					
				}			

			}
		});
		consultRGM.setBounds(60, 23, 141, 20);
		NotasEfaltas.add(consultRGM);
		consultRGM.setColumns(10);
		
		
		JLabel lblNewLabel_13 = new JLabel("Disciplina");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_13.setBounds(22, 138, 67, 14);
		NotasEfaltas.add(lblNewLabel_13);
		
		JComboBox boxDisci = new JComboBox();
		
		boxDisci.setModel(new DefaultComboBoxModel(new String[] {"", "Programação Orientada a Objetos", "Estrutura de Dados I", "Matemática Discreta", "Modelagem de Dados(EAD)", "Redes de Computadores(EAD)", "Cálculo Diferencial e Integral II"}));
		boxDisci.setBounds(99, 136, 546, 22);
		NotasEfaltas.add(boxDisci);
		
		JLabel lblNewLabel_14 = new JLabel("Semestre");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_14.setBounds(22, 206, 85, 14);
		NotasEfaltas.add(lblNewLabel_14);
		
		JComboBox boxSemestre = new JComboBox();
		boxSemestre.setModel(new DefaultComboBoxModel(new String[] {"", "1-2023", "2-2023"}));
		boxSemestre.setBounds(99, 204, 90, 22);
		NotasEfaltas.add(boxSemestre);
		
		JLabel lblNewLabel_15 = new JLabel("Nota");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_15.setBounds(199, 208, 46, 14);
		NotasEfaltas.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Faltas");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_16.setBounds(332, 208, 46, 14);
		NotasEfaltas.add(lblNewLabel_16);
		
		txtFaltas = new JTextField();
		txtFaltas.setBounds(388, 205, 86, 20);
		NotasEfaltas.add(txtFaltas);
		txtFaltas.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Apaga?");
		btnNewButton_1.setBounds(22, 237, 100, 100);
		NotasEfaltas.add(btnNewButton_1);
		
		JButton btnSalva_1 = new JButton("Salva?");
		btnSalva_1.setBounds(132, 237, 100, 100);
		NotasEfaltas.add(btnSalva_1);
		
		JButton btnLista_1 = new JButton("Lista?");
		btnLista_1.setBounds(246, 237, 100, 100);
		NotasEfaltas.add(btnLista_1);
		
		JButton btnAtualiza_1 = new JButton("Atualiza?");
		btnAtualiza_1.setBounds(356, 237, 100, 100);
		NotasEfaltas.add(btnAtualiza_1);
		
		JButton btnNemIdeia_1 = new JButton("nem ideia");
		
		btnNemIdeia_1.setBounds(466, 237, 100, 100);
		NotasEfaltas.add(btnNemIdeia_1);
		
		JFormattedTextField txtNota = new JFormattedTextField(new MaskFormatter("##,##"));
		txtNota.setBounds(246, 205, 58, 20);
		NotasEfaltas.add(txtNota);
		
		JPanel Boletim = new JPanel();
		tabbedPane.addTab("Boletim", null, Boletim, null);
		Boletim.setLayout(null);
		
		JLabel cursoAluno = new JLabel("");
		cursoAluno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cursoAluno.setBounds(304, 43, 303, 33);
		Boletim.add(cursoAluno);
		
	
		
		JLabel semestreBoletim = new JLabel("");
		semestreBoletim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		semestreBoletim.setBounds(72, 78, 261, 33);
		Boletim.add(semestreBoletim);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		table_1 = new JTable(tableModel);
		tableModel.addColumn("Matéria");
		tableModel.addColumn("Nota");
		tableModel.addColumn("Faltas");

		table_1.setBounds(71, 130, 536, 172);
		Boletim.add(table_1);
		
		rgm_boletim = new JTextField();
		rgm_boletim.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					NotasDAO boletim = new NotasDAO();
					AlunoDAO getAluno = new AlunoDAO();
					Aluno a = getAluno.procurarAluno(rgm_boletim.getText());
					List<Notas> notas = boletim.todasNotasDeUmAluno(rgm_boletim.getText());
					cursoAluno.setText(a.getCurso());
					semestreBoletim.setText(notas.get(0).getSemestre());
					tableModel.setRowCount(0);
					
					for(Notas n : notas) {
						tableModel.insertRow(0, new Object[] { n.getMateria(), String.valueOf(n.getNota()).replace('.',','), n.getFaltas() });
					}

				}
				catch(Exception boletimErr) {
					//JOptionPane.showMessageDialog(null, boletimErr.getMessage());
				}
			}
		});
		
		rgm_boletim.setToolTipText("Informe o rgm...");
		rgm_boletim.setBounds(70, 56, 164, 20);
		Boletim.add(rgm_boletim);
		rgm_boletim.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Matéria");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(72, 108, 113, 14);
		Boletim.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Nota");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_12.setBounds(263, 105, 120, 14);
		Boletim.add(lblNewLabel_12);
		
		JLabel lblNewLabel_17 = new JLabel("Faltas");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_17.setBounds(433, 105, 46, 14);
		Boletim.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("RGM");
		lblNewLabel_18.setBounds(71, 31, 46, 14);
		Boletim.add(lblNewLabel_18);
		
		JButton btnNewButton_2 = new JButton("...");
		btnNewButton_2.setBounds(244, 56, 46, 20);
		Boletim.add(btnNewButton_2);
		
		JPanel OtherBoletim = new JPanel();
		tabbedPane.addTab("OtherBoletim", null, OtherBoletim, null);
		OtherBoletim.setLayout(null);
		
		JProgressBar bar1 = new JProgressBar();
		bar1.setMaximum(10);
		bar1.setBounds(46, 42, 168, 20);
		OtherBoletim.add(bar1);
		
		JLabel mat1 = new JLabel("");
		mat1.setBounds(46, 25, 221, 14);
		OtherBoletim.add(mat1);
		
		JProgressBar bar2 = new JProgressBar();
		bar2.setMaximum(10);
		bar2.setBounds(46, 92, 168, 20);
		OtherBoletim.add(bar2);
		
		JLabel mat2 = new JLabel("");
		mat2.setBounds(46, 67, 221, 14);
		OtherBoletim.add(mat2);
		
		JProgressBar bar3 = new JProgressBar();
		bar3.setMaximum(10);
		bar3.setBounds(46, 148, 168, 20);
		OtherBoletim.add(bar3);
		
		JLabel mat3 = new JLabel("");
		mat3.setBounds(46, 123, 221, 14);
		OtherBoletim.add(mat3);
		
		JProgressBar bar4 = new JProgressBar();
		bar4.setMaximum(10);
		bar4.setBounds(46, 204, 168, 20);
		OtherBoletim.add(bar4);
		
		JLabel mat4 = new JLabel("");
		mat4.setBounds(46, 179, 221, 14);
		OtherBoletim.add(mat4);
		
		JProgressBar bar5 = new JProgressBar();
		bar5.setMaximum(10);
		bar5.setBounds(46, 260, 168, 20);
		OtherBoletim.add(bar5);
		
		JLabel mat5 = new JLabel("");
		mat5.setBounds(46, 235, 221, 14);
		OtherBoletim.add(mat5);
		
		JProgressBar bar6 = new JProgressBar();
		bar6.setMaximum(10);
		bar6.setBounds(46, 316, 168, 20);
		OtherBoletim.add(bar6);
		
		JLabel mat6 = new JLabel("");
		mat6.setBounds(46, 291, 221, 14);
		OtherBoletim.add(mat6);
		
		JLabel lblNewLabel_19 = new JLabel("RGM");
		lblNewLabel_19.setBounds(497, 11, 46, 14);
		OtherBoletim.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Faltas");
		lblNewLabel_20.setBounds(265, 25, 46, 14);
		OtherBoletim.add(lblNewLabel_20);
		
		JLabel f1 = new JLabel("");
		f1.setBounds(265, 48, 46, 14);
		OtherBoletim.add(f1);
		
		JLabel f2 = new JLabel("");
		f2.setBounds(265, 92, 46, 14);
		OtherBoletim.add(f2);
		
		JLabel f3 = new JLabel("");
		f3.setBounds(265, 148, 46, 14);
		OtherBoletim.add(f3);
		
		JLabel f4 = new JLabel("");
		f4.setBounds(265, 204, 46, 14);
		OtherBoletim.add(f4);
		
		JLabel f5 = new JLabel("");
		f5.setBounds(265, 255, 46, 14);
		OtherBoletim.add(f5);
		
		JLabel f6 = new JLabel("");
		f6.setBounds(265, 316, 46, 14);
		OtherBoletim.add(f6);
		
		JLabel otherSemestre = new JLabel("");
		otherSemestre.setBounds(497, 67, 129, 14);
		OtherBoletim.add(otherSemestre);
		
		
		otherBoletimRGM = new JTextField();
		otherBoletimRGM.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String rgms = otherBoletimRGM.getText();
				try {
					NotasDAO boletim = new NotasDAO();

					List<Notas> notas = boletim.todasNotasDeUmAluno(rgms);
					
					//define as cores de acordo com a nota
					if((int) notas.get(5).getNota() >= 6 && (int) notas.get(5).getNota() < 8) {
						bar1.setForeground(Color.yellow);
					}
					if((int) notas.get(5).getNota() < 6 ) {
						bar1.setForeground(Color.red);
					}
					if((int) notas.get(5).getNota() > 8 ) {
						bar1.setForeground(Color.blue);
					}
					if((int) notas.get(4).getNota() >= 6 && (int) notas.get(4).getNota() < 8) {
						bar2.setForeground(Color.yellow);
					}
					if((int) notas.get(4).getNota() < 6 ) {
						bar2.setForeground(Color.red);
					}
					if((int) notas.get(4).getNota() > 8 ) {
						bar2.setForeground(Color.blue);
					}
					if((int) notas.get(3).getNota() >= 6 && (int) notas.get(3).getNota() < 8) {
						bar3.setForeground(Color.yellow);
					}
					if((int) notas.get(3).getNota() < 6 ) {
						bar3.setForeground(Color.red);
					}
					if((int) notas.get(3).getNota() > 8 ) {
						bar3.setForeground(Color.blue);
					}
					if((int) notas.get(2).getNota() >= 6 && (int) notas.get(2).getNota() < 8) {
						bar4.setForeground(Color.yellow);
					}
					if((int) notas.get(2).getNota() < 6 ) {
						bar4.setForeground(Color.red);
					}
					if((int) notas.get(2).getNota() > 8 ) {
						bar4.setForeground(Color.blue);
					}
					if((int) notas.get(1).getNota() >= 6 && (int) notas.get(1).getNota() < 8) {
						bar5.setForeground(Color.yellow);
					}
					if((int) notas.get(1).getNota() < 6 ) {
						bar5.setForeground(Color.red);
					}
					if((int) notas.get(1).getNota() > 8 ) {
						bar5.setForeground(Color.blue);
					}
					if((int) notas.get(0).getNota() >= 6 && (int) notas.get(0).getNota() < 8) {
						bar6.setForeground(Color.yellow);
					}
					if((int) notas.get(0).getNota() < 6 ) {
						bar6.setForeground(Color.red);
					}
					if((int) notas.get(0).getNota() > 8 ) {
						bar6.setForeground(Color.blue);
					}
				
					mat1.setText(notas.get(5).getMateria());
					bar1.setValue((int) notas.get(5).getNota());
					f1.setText(String.valueOf(notas.get(5).getFaltas()));
					//verifica se estourou o limite de faltas
					if(notas.get(5).getFaltas() > 15 ) {
						f1.setForeground(Color.red);
					}
					mat2.setText(notas.get(4).getMateria());
					bar2.setValue((int) notas.get(4).getNota());
					f2.setText(String.valueOf(notas.get(4).getFaltas()));
					if(notas.get(4).getFaltas() > 15 ) {
						f2.setForeground(Color.red);
					}
					mat3.setText(notas.get(3).getMateria());
					bar3.setValue((int) notas.get(3).getNota());
					f3.setText(String.valueOf(notas.get(3).getFaltas()));
					if(notas.get(3).getFaltas() > 15 ) {
						f3.setForeground(Color.red);
					}
					mat4.setText(notas.get(2).getMateria());
					bar4.setValue((int) notas.get(2).getNota());
					f4.setText(String.valueOf(notas.get(2).getFaltas()));
					if(notas.get(2).getFaltas() > 15 ) {
						f4.setForeground(Color.red);
					}
					mat5.setText(notas.get(1).getMateria());
					bar5.setValue((int) notas.get(1).getNota());
					f5.setText(String.valueOf(notas.get(1).getFaltas()));
					if(notas.get(1).getFaltas() > 15 ) {
						f5.setForeground(Color.red);
					}
					mat6.setText(notas.get(0).getMateria());
					bar6.setValue((int) notas.get(0).getNota());
					f6.setText(String.valueOf(notas.get(0).getFaltas()));
					if(notas.get(0).getFaltas() > 15 ) {
						f6.setForeground(Color.red);
					}
					otherSemestre.setText(notas.get(0).getSemestre());

				}catch(Exception err) {
					
				}

			}
		});
		
		otherBoletimRGM.setBounds(497, 36, 86, 20);
		OtherBoletim.add(otherBoletimRGM);
		otherBoletimRGM.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(593, 33, 33, 23);
		OtherBoletim.add(btnNewButton_3);
		
		

		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 668, 22);
		frmAlunos.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Alunos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtRGM.getText().isEmpty() || txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() ||
					txtCelular.getText().isEmpty() || txtMunicipio.getText().isEmpty() || txtEndereco.getText().isEmpty() ||
					txtCpf.getText().isEmpty() || txtData.getText().isEmpty() || boxCampus.getSelectedItem().toString().isEmpty() ||
					boxCurso.getSelectedItem().toString().isEmpty() || boxUf.getSelectedItem().toString().isEmpty() || selected_turn.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Preecha todos os campos (incluindo os da aba curso)");
					
				}else {
					
					Aluno aluno = new Aluno();
					aluno.setRGM(txtRGM.getText());
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCell(txtCelular.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setNascimento(txtData.getText());
					aluno.setCampus(boxCampus.getSelectedItem().toString());
					aluno.setCurso(boxCurso.getSelectedItem().toString());
					aluno.setUf(boxUf.getSelectedItem().toString());
					aluno.setTurno(selected_turn);
					
					try {
						
						AlunoDAO dao = new AlunoDAO();
						//salva o aluno
						dao.salvar(aluno);
						JOptionPane.showMessageDialog(null, "Salvo com Sucesso");			
						
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtRGM.getText().isEmpty() || txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() ||
						txtCelular.getText().isEmpty() || txtMunicipio.getText().isEmpty() || txtEndereco.getText().isEmpty() ||
						txtCpf.getText().isEmpty() || txtData.getText().isEmpty() || boxCampus.getSelectedItem().toString().isEmpty() ||
						boxCurso.getSelectedItem().toString().isEmpty() || boxUf.getSelectedItem().toString().isEmpty() || selected_turn.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, "Preecha todos os campos (incluindo os da aba curso)");
						
					}else {
					Aluno aluno = new Aluno();
					aluno.setRGM(txtRGM.getText());
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCell(txtCelular.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setNascimento(txtData.getText());
					aluno.setCampus(boxCampus.getSelectedItem().toString());
					aluno.setCurso(boxCurso.getSelectedItem().toString());
					aluno.setUf(boxUf.getSelectedItem().toString());
					aluno.setTurno(selected_turn);

					try {
						AlunoDAO dao = new AlunoDAO();
						//salva o aluno
						dao.atualizar(aluno);
						JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");				
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtRGM.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um RGM para realizar a consulta!");
					txtRGM.setBorder(BorderFactory.createLineBorder(Color.red));
				}else {
					txtRGM.setBorder(BorderFactory.createLineBorder(Color.black));
					
					try {
						AlunoDAO dao = new AlunoDAO();
						Aluno aluno = dao.procurarAluno(txtRGM.getText());
						
						//mostra as infos do aluno vinculado ao rgm fornecido
						txtNome.setText(aluno.getNome());
						txtEmail.setText(aluno.getEmail());
						txtCelular.setText(aluno.getCell());
						txtData.setText(aluno.getNascimento());
						txtCpf.setText(aluno.getCpf());
						txtEndereco.setText(aluno.getEndereco());
						boxUf.setSelectedItem(aluno.getUf());
						boxCampus.setSelectedItem(aluno.getCampus());
						boxCurso.setSelectedItem(aluno.getCurso());
						txtMunicipio.setText(aluno.getMunicipio());
						
					    ButtonModel noturnoM = noturno.getModel();
					    ButtonModel vespM = vesperino.getModel();
					    ButtonModel matM = matutino.getModel();


						if(aluno.getTurno().equals("Noturno")) {
							bg.setSelected(noturnoM, true);
							selected_turn = "Nortuno";
						}
						if(aluno.getTurno().equals("Vesperino")) {
							bg.setSelected(vespM, true);
							selected_turn = "Vesperino";
						}
						if(aluno.getTurno().equals("Matutino")) {
							bg.setSelected(matM, true);
							selected_turn = "Matutino";
						}
						
					}catch(Exception consultErr) {
						JOptionPane.showMessageDialog(null, consultErr.getMessage());
					}

				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtRGM.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o RGM do aluno que deseja excluir!");

				}else {
					try {
						AlunoDAO e_aluno = new AlunoDAO();
						NotasDAO e_nota = new NotasDAO();
						int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir o aluno vinculado ao RGM "+txtRGM.getText());
						if(escolha == 0) {
							e_nota.excluir(txtRGM.getText());
							e_aluno.excluir(txtRGM.getText());
							JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
						}
					}
					catch(Exception ex_aluno){
						JOptionPane.showMessageDialog(null, ex_aluno.getMessage());

					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Salvar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(consultRGM.getText().isEmpty() || txtFaltas.getText().isEmpty() || boxDisci.getSelectedItem().toString().isEmpty() ||
						boxSemestre.getSelectedItem().toString().isEmpty() || txtNota.getText().isEmpty()
				) {
					JOptionPane.showMessageDialog(null, "Informe todos os dados!");			
				}else {
					Notas nota = new Notas();
					nota.setRGM(consultRGM.getText());
					nota.setFaltas(Integer.parseInt(txtFaltas.getText()));
					nota.setMateria(boxDisci.getSelectedItem().toString());
					nota.setSemestre(boxSemestre.getSelectedItem().toString());
					nota.setNota(Float.parseFloat(String.valueOf(txtNota.getText().replace(',', '.')))); 
					try {
						
						NotasDAO dao = new NotasDAO();
						NotasDAO v_dao = new NotasDAO();
						//verifica se já existe nota pra essa matéria
						
						if(v_dao.procurarMateria(nota.getMateria(), nota.getRGM()) == null) {
							//salva a nota do aluno
							dao.salvar(nota);
							JOptionPane.showMessageDialog(null, "Salvo com Sucesso");			
						}else {
							JOptionPane.showMessageDialog(null, "Já foi informada uma nota para esse aluno, caso queira alterar, utilze a opção de 'alterar'");			
						}
			
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Alterar");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultRGM.getText().isEmpty() || txtFaltas.getText().isEmpty() || boxDisci.getSelectedItem().toString().isEmpty() ||
						boxSemestre.getSelectedItem().toString().isEmpty() || txtNota.getText().isEmpty()
				) {
					JOptionPane.showMessageDialog(null, "Informe todos os dados!");			
				}else {
					Notas nota = new Notas();
					nota.setRGM(consultRGM.getText());
					nota.setFaltas(Integer.parseInt(txtFaltas.getText()));
					nota.setMateria(boxDisci.getSelectedItem().toString());
					nota.setSemestre(boxSemestre.getSelectedItem().toString());
					nota.setNota(Float.parseFloat(txtNota.getText().replace(',', '.')));
					
					try {
						NotasDAO att_dao = new NotasDAO();
						att_dao.atualizar(nota);
						JOptionPane.showMessageDialog(null, "Nota atualiza com sucesso!");
					}catch(Exception attErr) {
						
					JOptionPane.showMessageDialog(null, attErr.getMessage());
					
					}
				}
			}
		});
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Excluir");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boxDisci.getSelectedItem().toString().isEmpty() || consultRGM.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a matéria e o RGM que deseja excluir!");			
				}else {
					try {
						NotasDAO n_dao = new NotasDAO();
						
						//deleta nota de uma matéria específica
						String mat = boxDisci.getSelectedItem().toString();
						String rgm_s = consultRGM.getText();
						
						int escolha = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar a nota de "
						+mat+ " do aluno vinculado ao RGM "+rgm_s);
						
						if(escolha == 0) {
							n_dao.excluirNotaEspecifica(rgm_s, mat);
							JOptionPane.showMessageDialog(null, "Nota deletada com sucesso!");			
						}
					}catch(Exception excluirErr) {
						JOptionPane.showMessageDialog(null, excluirErr.getMessage());			
	
					}
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Consultar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Basta informar o RGM no campo 'RGM' em 'Notas e Faltas', caso queira todas as notas, vá até o boletim");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);
		
		boxDisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultRGM.getText().isEmpty() || boxDisci.getSelectedItem().toString().isEmpty()) {
					
				}else {
					try {
						NotasDAO get_nota = new NotasDAO();
						Notas nota = get_nota.procurarMateria(boxDisci.getSelectedItem().toString(), consultRGM.getText());
						boxSemestre.setSelectedItem(nota.getSemestre());
						if(nota.getNota() < 10) {
							txtNota.setText('0' + String.valueOf(nota.getNota()).replace('.', ','));
						}else {
							txtNota.setText(String.valueOf(nota.getNota()).replace('.', ','));
						}
						txtFaltas.setText(String.valueOf(nota.getFaltas()));
						
					}catch(Exception getErr) {
						boxSemestre.setSelectedItem(null);
						txtNota.setText(null);
						txtFaltas.setText(null);
					}
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Sobre");
		mntmNewMenuItem_9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Projeto MVC em Java \n"
						+ "Integrantes do grupo: \n"
						+ "Gabriel Falcão G Carvalho \n"
						+ "Victor Custodio \n"
						+ "João Romano \n"
						+ "Alexandre \n"
						+ "Richard \n");
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);

	}
}