package integration.factory.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConfig {

    Map<String, String> listaCampo = null;
    public static Properties config = new Properties();
    private HashMap<String, String> ColorDB;


    public Map<String, String> validaCampos() throws ClassNotFoundException, SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/banco_teste_automacao";

        String username = System.getenv().get("username");
        String password = System.getenv().get("password");

        String query = "select * from massas;";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {

            listaCampo = new HashMap<String, String>();
            listaCampo.put("nameProduct", rs.getString(2));
            listaCampo.put("customization", rs.getString(3));
            listaCampo.put("display", rs.getString(4));
            listaCampo.put("displayResolution", rs.getString(5));
            listaCampo.put("displaySize", rs.getString(6));
            listaCampo.put("memory", rs.getString(7));
            listaCampo.put("operatingSystem", rs.getString(8));
            listaCampo.put("processor", rs.getString(9));
            listaCampo.put("touchscreen", rs.getString(10));
            listaCampo.put("weight", rs.getString(11));
            listaCampo.put("color", rs.getString(12));
        }
        con.close();
        return listaCampo;
    }


    public void alteraCor(String string) throws ClassNotFoundException, SQLException {

        String dbUrl = "jdbc:mysql://localhost:3306/banco_teste_automacao";
        String username = System.getenv().get("username");
        String password = System.getenv().get("password");
        String query = "UPDATE massas SET COLOR = " + string;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate(query);

    }

    public static void realizaUpdateBanco(String color) throws ClassNotFoundException, SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/banco_teste_automacao";
        String username = System.getenv().get("username");
        String password = System.getenv().get("password");
        String updatequery = "UPDATE massas SET COLOR = ? where name_product = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL, username, password);
        PreparedStatement preparedStmt = con.prepareStatement(updatequery);
        preparedStmt.setString(1, color);
        preparedStmt.setString(2, "HP PAVILION 15Z TOUCH LAPTOP");

        preparedStmt.executeUpdate();
        con.close();
    }
}


