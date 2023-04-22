package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.model.Notas;
import br.edu.unicid.util.ConnectionFactory;

public class NotasDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs; 
	private Notas notas;
	
	//construtora
		public NotasDAO() throws Exception {
			// chama a classe ConnectionFactory e estabele uma conexão
			try {
				this.conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				throw new Exception("erro: \n" + e.getMessage());
			}
		}
		
		
		//salvar nota do aluno
		public void salvar(Notas nota) throws Exception {
			if (nota == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO tb_notas(rgm, nota, matéria, semestre, faltas) "
						+ "VALUES "
						+ "(?, ?, ?, ?, ?);";
						
				ps = conn.prepareStatement(SQL);
				ps.setString(1, nota.getRGM());
				ps.setFloat(2, nota.getNota());
				ps.setString(3, nota.getMateria());
				ps.setString(4, nota.getSemestre());
				ps.setInt(5, nota.getFaltas());

				ps.executeUpdate();
				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}

		//atualiza a nota do aluno
		public void atualizar(Notas nota) throws Exception {
			if (nota == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE tb_notas SET nota = ?, "
						+ "semestre = ?, faltas = ? "
						+ "WHERE rgm = ? and matéria = ?;";
				ps = conn.prepareStatement(SQL);
				ps.setFloat(1, nota.getNota());
				ps.setString(2, nota.getSemestre());
				ps.setInt(3, nota.getFaltas());
				ps.setString(4, nota.getRGM());
				ps.setString(5, nota.getMateria());



				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao alterar dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}

		//exclui todas as notas do aluno
		public void excluir(String rgm) throws Exception {
			if (rgm == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "DELETE FROM tb_notas WHERE rgm = ?;";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, rgm);
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps);
			}
		}
		
		//exclui uma nota específica do aluno
				public void excluirNotaEspecifica(String rgm, String materia) throws Exception {
					if (rgm == null || materia == null)
						throw new Exception("O valor passado nao pode ser nulo");
					try {
						String SQL = "DELETE FROM tb_notas WHERE rgm = ? and matéria = ?;";
						ps = conn.prepareStatement(SQL);
						ps.setString(1, rgm);
						ps.setString(2, materia);
						ps.executeUpdate();
					} catch (SQLException sqle) {
						throw new Exception("Erro ao excluir dados " + sqle);
					} finally {
						ConnectionFactory.closeConnection(conn, ps);
					}
				}

		//procurar uma nota específica de um aluno
		public Notas procurarMateria(String materia, String rgm_s) throws Exception {
			try {
				String SQL = "SELECT  * FROM tb_notas WHERE matéria=? and rgm = ?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, materia);	
				ps.setString(2, rgm_s);
				rs = ps.executeQuery();
				if (rs.next()) {
					String rgm = rs.getString(1);
					float nota_bd = rs.getFloat(2);
					String nota_materia = rs.getString(3);
					String semestre = rs.getString(4);
					int faltas = rs.getInt(5);
					
					notas = new Notas(rgm, nota_materia, semestre, faltas, nota_bd);
				}
				return notas;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		//listar todas as notas de um aluno específico
		public List<Notas> todasNotasDeUmAluno(String rgm_s) throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM tb_notas WHERE rgm = ? ORDER BY nota DESC");
				ps.setString(1, rgm_s);	
				rs = ps.executeQuery();
				List<Notas> list = new ArrayList<Notas>();
				while (rs.next()) {
					String rgm = rs.getString(1);
					float nota_bd = rs.getFloat(2);
					String nota_materia = rs.getString(3);
					String semestre = rs.getString(4);
					int faltas = rs.getInt(5);
					
					list.add(new Notas(rgm, nota_materia, semestre, faltas, nota_bd));
				}
				return list;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
		
		//lista a nota de todos os alunos
		public List<Notas> todasNotasDeTodosAlunos() throws Exception {
			try {
				ps = conn.prepareStatement("SELECT * FROM tb_notas ORDER BY nota ASC");
				rs = ps.executeQuery();
				List<Notas> list = new ArrayList<Notas>();
				while (rs.next()) {
					String rgm = rs.getString(1);
					float nota_bd = rs.getFloat(2);
					String nota_materia = rs.getString(3);
					String semestre = rs.getString(4);
					int faltas = rs.getInt(5);
					
					list.add(new Notas(rgm, nota_materia, semestre, faltas, nota_bd));
				}
				return list;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}
		}
}
