package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Mercancia;

/**
 * Clase MercanciaDAO es una clase que permite encapsular las operaciones de
 * acceso a datos por medio de un objeto de tipo Mercancia
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class MercanciaDAO {

    private Mercancia objMercancia;

    /**
     * Un objeto de tipo EnvioDAO utiliza los siguientes parametros
     *
     * @param objMercancia : objeto de tipo Mercancia
     */
    public MercanciaDAO(Mercancia objMercancia) {
        this.objMercancia = objMercancia;
    }

    /**
     * Crea objeto de tipo Envio con datos nulos
     */
    public MercanciaDAO() {
        this.objMercancia = new Mercancia();
    }

    /**
     * Retorna el objeto mercancia
     *
     * @return Mercancia
     */
    public Mercancia getObjMercancia() {
        return objMercancia;
    }

    /**
     * Establece o modifica el objeto mercancia
     *
     * @param objMercancia : objeto mercancia
     */
    public void setObjMercancia(Mercancia objMercancia) {
        this.objMercancia = objMercancia;
    }

    /**
     * Esta funcion se dedica a insertar elementos a la base de datos por medio
     * de la tabla mercancia de multienvios
     *
     * @return String
     */
    public String insertar() {
        String mensaje = "";
        try {
            ConexionBD objConexionBD = new ConexionBD();
            PreparedStatement consulta = null;
            objConexionBD.conectar();
            String comando = "insert into mercancia values(?,?,?,?)";
            consulta = objConexionBD.getConexion().prepareStatement(comando);
            consulta.setString(1, String.valueOf(objMercancia.getSerial()));
            consulta.setString(2, String.valueOf(objMercancia.getDescripcion()));
            consulta.setString(3, String.valueOf(objMercancia.getCantidad()));
            consulta.setString(4, String.valueOf(objMercancia.getPeso()));
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
     * mercancia de la base de datos de multienvios
     *
     * @return String
     */
    public DefaultTableModel consulta() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objConexionBD = new ConexionBD();
        try {
            objConexionBD.conectar();
            Statement consulta = objConexionBD.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("select * from Mercancia");
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
}
