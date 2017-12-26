
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hernan
 */
public class Conexion {
    
    public static String bd="clinica2";
    public static String login = "root";
    public static String pass = "root";
    
    public static String url = "jdbc:mysql://localhost/"+bd;
    public static Connection conn;
    public static Statement sentencia;
    
    public static boolean buscarRutCli;
    
    public static void conectar(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, pass);
            if (conn != null) {
                System.out.println("Conexion establecida con "+bd);
            }
            
        } catch (SQLException e) {
            System.out.println("Hubo un problema al conectar");
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public static void desconectar() throws SQLException{
        conn.close();
    }
    
    public void hola()
    {
        System.out.println("hola");
    }
}
