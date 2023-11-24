package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase ConexionBD se dedica a concetar el programa a una base de datos SQL por
 * medio de Xampp
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class ConexionBD {

    private Connection conexion;
    private String baseDatos;
    private String usuario;
    private String clave;
    private String mensaje;

    /**
     * Un objeto de tipo Conexion utiliza los siguientes parametros
     *
     * @param conexion : conector a la base de datos
     * @param baseDatos : base de datos
     * @param usuario : usuario de la base de datos
     * @param clave : clave de la base de datos
     * @param mensaje : mensage de la base datos
     *
     */
    public ConexionBD(Connection conexion, String baseDatos, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }

    /**
     * Crea objeto de tipo ConexionBD con datos nulos
     */
    public ConexionBD() {
        this.conexion = null;
        this.baseDatos = "multienvios";
        this.usuario = "";
        this.clave = "";
        this.mensaje = "";
    }

    /**
     * Retorna la coneccion de ConexionBD en un objeto de tipo Connection
     *
     * @return Connection
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Establece o modifica la coneccion de ConexionBD por medio de un objeto
     * Connection
     *
     * @param conexion : conector a la base de datos
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Retorna la base de datos de ConexionBD en una cadena de caracteres
     *
     * @return String
     */
    public String getBaseDatos() {
        return baseDatos;
    }

    /**
     * Establece la base de datos de ConexionBD a partir de una cadena de
     * caracteres
     *
     * @param baseDatos : base de datos
     */
    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    /**
     * Retorna el usuario de ConexionBD en una cadena de caracteres
     *
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario de ConexionBD a partir de una cadena de caracteres
     *
     * @param usuario : usuario de la base de datos
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna la clave de ConexionBD en una cadena de caracteres
     *
     * @return String
     */
    public String getClave() {
        return clave;
    }

    /**
     * Establece la clave de ConexionBD a partir de una cadena de caracteres
     *
     * @param clave : clave de base de datos
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Retorna el mensaje de ConexionBD en una cadena de caracteres
     *
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el mensaje de ConexionBD a partir de una cadena de caracteres
     *
     * @param mensaje : mensaje de base de datos
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Esta funcin concta directamente a la base de datos de SQL
     *
     * @exception SQLException : anomalias en base de datos
     */
    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String ruta = "jdbc:mysql://localhost:3306/" + baseDatos;
            conexion = DriverManager.getConnection(ruta, "root", clave);
            mensaje = "Conexión exitosa a Base de Datos " + baseDatos;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error, Driver no encontrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar conectar a la Base de Datos: " + baseDatos + "\n" + ex);
        }
    }
}
