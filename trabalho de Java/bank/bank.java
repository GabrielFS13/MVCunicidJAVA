package bank;

import java.sql.*;


public class bank {
    // chamando o banco de dados
    public static Connection getBank() throws Exception {
        // toda a vez que for conectar com o banco de dados, é preciso o try

        try {
            //vou indicar qual benco de dados estara sendo utilizado
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbaluno";
            String login = "root";
            String senha = "";
            return DriverManager.getConnection(url, login, senha);

        }catch(Exception tentativa1) {
            throw new Exception(tentativa1.getMessage());
        }

        
    } 
    //funcoes para fechar o banco de dados
    public static void closeBank(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        closeBank(conn, stmt, rs);
    }
    
    public static void main(String args[]) {
    	Connection c = Connection.getBank();
    	System.out.println(c);
    }
}