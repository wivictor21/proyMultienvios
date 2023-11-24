package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aereo;
import modelo.Envio;

/**
 * Clase EnvioDAO es una clase que permite encapsular las operaciones de acceso
 * a datos por medio de un objeto de tipo Envio
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class EnvioDAO {

    private Envio objEnvio;

    /**
     * Un objeto de tipo EnvioDAO utiliza los siguientes parametros
     *
     * @param objEnvio : objeto de tipo envio
     */
    public EnvioDAO(Envio objEnvio) {
        this.objEnvio = objEnvio;
    }

    /**
     * Crea objeto de tipo Envio con datos nulos, por defecto se crea de tipo
     * Envio Aereo
     */
    public EnvioDAO() {
        this.objEnvio = new Aereo();

    }

    /**
     * Retorna el objeto envio
     *
     * @return Envio
     */
    public Envio getObjEnvio() {
        return objEnvio;
    }

    /**
     * Establece o modifica el objeto envio
     *
     * @param objEnvio : objeto envio
     */
    public void setObjEnvio(Envio objEnvio) {
        this.objEnvio = objEnvio;
    }

    /**
     * Esta funcion se dedica a insertar elementos a la base de datos por medio
     * de la tabla envio de multienvios
     *
     * @return String
     */
    public String insertar() {
        String mensaje = "";
        try {
            ConexionBD objConexionBD = new ConexionBD();
            PreparedStatement consulta = null;
            objConexionBD.conectar();
            String comando = "insert into envio values(?,?,?,?,?)";
            consulta = objConexionBD.getConexion().prepareStatement(comando);
            consulta.setString(1, String.valueOf(objEnvio.tipo()));
            consulta.setString(2, String.valueOf(objEnvio.getNumeroEnvio()));
            consulta.setString(3, String.valueOf(objEnvio.getOrigen()));
            consulta.setString(4, String.valueOf(objEnvio.getDestino()));
            consulta.setString(5, String.valueOf(objEnvio.getDestinatario().getNombre()));
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
     * Esta funcion se dedica consultar los elementos que hay en la tabla envios
     * de la base de datos de multienvios
     *
     * @return String
     */
    public DefaultTableModel consulta() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objConexionBD = new ConexionBD();
        try {
            objConexionBD.conectar();
            Statement consulta = objConexionBD.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("select * from Envio");
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
