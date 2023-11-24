package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;

/**
 * Clase PersonaDAO es una clase que permite encapsular las operaciones de
 * acceso a datos por medio de un objeto de tipo Persona
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class PersonaDAO {

    private Persona objPersona;

    /**
     * Un objeto de tipo PersonaDAO utiliza los siguientes parametros
     *
     * @param objPersona : objeto de tipo persona
     */
    public PersonaDAO(Persona objPersona) {
        this.objPersona = objPersona;
    }

    /**
     * Crea objeto de tipo Envio con datos nulos
     */
    public PersonaDAO() {
        this.objPersona = new Persona();
    }

    /**
     * Retorna el objeto persona
     *
     * @return Persona
     */
    public Persona getObjPersona() {
        return objPersona;
    }

    /**
     * Establece o modifica el objeto persona
     *
     * @param objPersona : objeto persona
     */
    public void setObjPersona(Persona objPersona) {
        this.objPersona = objPersona;
    }

    /**
     * Esta funcion se dedica a insertar elementos a la base de datos por medio
     * de la tabla persona de multienvios
     *
     * @return String
     */
    public String insertar() {
        String mensaje = "";
        try {
            ConexionBD objConexionBD = new ConexionBD();
            PreparedStatement consulta = null;
            objConexionBD.conectar();
            String comando = "insert into persona values(?,?,?)";
            consulta = objConexionBD.getConexion().prepareStatement(comando);
            consulta.setString(1, String.valueOf(objPersona.getNombre()));
            consulta.setString(2, String.valueOf(objPersona.getId()));
            consulta.setString(3, String.valueOf(objPersona.getTelefono()));
            consulta.execute();
            mensaje = "Registro a Base de Datos fue exitoso";
            consulta.close();
            objConexionBD.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar conectar en Base de Datos" + ex;
        }
        return mensaje;
    }

    /**
     * Esta funcion se dedica consultar los elementos que hay en la tabla
     * persona de la base de datos de multienvios
     *
     * @return String
     */
    public DefaultTableModel consulta() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objConexionBD = new ConexionBD();
        try {
            objConexionBD.conectar();
            Statement consulta = objConexionBD.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("select * from Persona");
            ResultSetMetaData campos = datos.getMetaData();

            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while (datos.next()) {
                Object[] fila = new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                    fila[i] = datos.getObject(i + 1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            objConexionBD.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error: " + ex);
        }
        return plantilla;
    }

    public String actuaizar() {
        String mensaje = "";
        try {
            ConexionBD objConexionBD = new ConexionBD();
            PreparedStatement consulta = null;
            objConexionBD.conectar();
            String comando = "UPDATE persona set nombre=?,identicacion=? where telefono=? ";
            consulta = objConexionBD.getConexion().prepareStatement(comando);
            consulta.setString(1, String.valueOf(objPersona.getNombre()));
            consulta.setString(2, String.valueOf(objPersona.getId()));
            consulta.setString(3, String.valueOf(objPersona.getTelefono()));
            consulta.execute();
            mensaje = "Registro a Base de Datos fue exitoso";
            consulta.close();
            objConexionBD.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar conectar en Base de Datos" + ex;
        }
        return mensaje;
    }
}
