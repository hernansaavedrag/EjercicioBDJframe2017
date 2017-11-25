
package negocio;

import datos.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author hernan
 */
public class Cliente {
    
    private String rut;
    private String nombre;
    private int edad;

    public Cliente(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void imprimirCliente()
    {
        System.out.println("Rut: "+this.getRut());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Edad: "+this.getEdad());
    }
    
    public void guardarCliente(){
        
        try {
            String strSql = "insert into cliente values ('"+rut+"','"+nombre+"',"+edad+")";
            Conexion.conectar();
            Conexion.sentencia = Conexion.conn.prepareStatement(strSql);
            Conexion.sentencia.execute(strSql);
            System.out.println("Datos Almacenados");
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error en el metodo guardar cliente");
        }
        
    }
    
    public void cargarRutCliente(){
        try {
            Conexion.buscarRutCli=false;
            String strSql = "select * from cliente where rut = '"+rut+"'";
            Conexion.conectar();
            Conexion.sentencia=Conexion.conn.prepareStatement(strSql);
            ResultSet objRes = Conexion.sentencia.executeQuery(strSql);
            if (objRes.next()) {
                Conexion.buscarRutCli=true;
                rut = objRes.getString(1);
                nombre = objRes.getString(2);
                edad = Integer.parseInt(objRes.getString(3));
            }
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente");
        }
    }
    
    public void actualizar()
    {
        try {
            String strSql = "update cliente set nombre = '"+nombre+"',edad="+edad+" where rut='"+rut+"'";
            Conexion.conectar();
            Conexion.sentencia=Conexion.conn.prepareStatement(strSql);
            Conexion.sentencia.execute(strSql);
            System.out.println("Cliente actualizado");
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente");
        }
    }
    
    public void borrar()
    {
        try {
            String strSql = "delete from cliente where rut = '"+rut+"'";
            Conexion.conectar();
            Conexion.sentencia=Conexion.conn.prepareStatement(strSql);
            Conexion.sentencia.execute(strSql);
            System.out.println("Cliente eliminado");
            Conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente");
        }
    }
    
}
