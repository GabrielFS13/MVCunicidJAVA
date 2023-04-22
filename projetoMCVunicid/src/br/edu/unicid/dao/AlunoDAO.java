package br.edu.unicid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.model.Aluno;
import br.edu.unicid.util.ConnectionFactory;

public class AlunoDAO {
	
	//declaração de atributos
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs; 
	private Aluno aluno;
	
	//construtora
	public AlunoDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}
	
	//salva novo aluno
	public void salvar(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tb_aluno(rgm, nome, email, nascimento, cpf, uf, municipio, celular, endereco, curso, campus, turno)"
					+ "VALUES"
					+ "(?, ?, ?, ?,?,?, ?, ?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, aluno.getRGM());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.setString(4, aluno.getNascimento());
			ps.setString(5, aluno.getCpf());
			ps.setString(6, aluno.getUf());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getCell());
			ps.setString(9, aluno.getEndereco());
			ps.setString(10, aluno.getCurso());
			ps.setString(11, aluno.getCampus());
			ps.setString(12, aluno.getTurno());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	//atualiza dados do aluno
	public void atualizar(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE tb_aluno SET nome = ?, email = ?, "
					+ "nascimento = ?, cpf = ?, uf = ?, municipio = ?,"
					+ "celular = ?, endereco = ?, curso = ?, campus = ?, turno = ? WHERE rgm = ?;";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getEmail());
			ps.setString(3, aluno.getNascimento());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getUf());
			ps.setString(6, aluno.getMunicipio());
			ps.setString(7, aluno.getCell());
			ps.setString(8, aluno.getEndereco());
			ps.setString(9, aluno.getCurso());
			ps.setString(10, aluno.getCampus());
			ps.setString(11, aluno.getTurno());
			ps.setString(12, aluno.getRGM());


			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	//exclui o aluno e as notas do mesmo
	public void excluir(String rgm) throws Exception {
		if (rgm == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM tb_aluno WHERE rgm = ?;";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, rgm);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	//procurar um aluno específico
	public Aluno procurarAluno(String rgm) throws Exception {
		try {
			String SQL = "SELECT  * FROM tb_aluno WHERE rgm=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, rgm);			
			rs = ps.executeQuery();
			if (rs.next()) {
				String aluno_rgm = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String nascimento = rs.getString(4);
				String cpf = rs.getString(5);
				String uf = rs.getString(6);
				String municipio = rs.getString(7);
				String celular = rs.getString(8);
				String endereco = rs.getString(9);
				String curso = rs.getString(10);
				String campus = rs.getString(11);
				String turno = rs.getString(12);
				
				aluno = new Aluno(nome, aluno_rgm, nascimento, cpf, 
						email, endereco, celular, uf, municipio,
						curso, campus, turno);
			}
			return aluno;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
	
	//listar todos alunos cadastrados
	public List<Aluno> todosAlunos() throws Exception {
		try {
			ps = conn.prepareStatement("SELECT * FROM tb_aluno");
			rs = ps.executeQuery();
			List<Aluno> list = new ArrayList<Aluno>();
			while (rs.next()) {
				String aluno_rgm = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String nascimento = rs.getString(4);
				String cpf = rs.getString(5);
				String uf = rs.getString(6);
				String municipio = rs.getString(7);
				String celular = rs.getString(8);
				String endereco = rs.getString(9);
				String curso = rs.getString(10);
				String campus = rs.getString(11);
				String turno = rs.getString(12);
				
				list.add(new Aluno(nome, aluno_rgm, nascimento, cpf, 
						email, endereco, celular, uf, municipio,
						curso, campus, turno));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}
