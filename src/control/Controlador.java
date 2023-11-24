package control;

import persistencia.Conexion;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Aereo;
import modelo.ArchPdf;
import modelo.Envio;
import modelo.Factura;
import modelo.Mercancia;
import modelo.Persona;
import modelo.Recaudo;
import modelo.Terrestre;
import persistencia.EnvioDAO;
import persistencia.MercanciaDAO;
import persistencia.PersonaDAO;
import vista.frmConsultaEnvio;
import vista.frmConsultaMercancia;
import vista.frmConsultaPersona;
import vista.frmPrincipal;
import vista.frmRegistroEnvio;
import vista.frmRegistroFactura;
import vista.frmRegistroMercancia;
import vista.frmRegistroPersona;

/**
 *
 * @author Victor Huertas
 */
public class Controlador implements ActionListener {

    private frmPrincipal frmInicio;
    private frmRegistroEnvio frmEnvio;
    private frmRegistroMercancia frmMercancia;
    private frmRegistroPersona frmPersona;
    private frmRegistroFactura frmFactura;
    private frmConsultaPersona frmoObjConsultaPersona;
    private Conexion conexion;
    private Recaudo objRecaudo;
    private Factura objFactura;

    public Controlador(frmPrincipal frmInicio, frmRegistroEnvio frmEnvio, frmRegistroMercancia frmMercancia, frmRegistroPersona frmPersona, frmRegistroFactura frmFactura, Conexion conexion, Recaudo objRecaudo, Factura objFactura) {
        this.frmInicio = frmInicio;
        this.frmEnvio = frmEnvio;
        this.frmMercancia = frmMercancia;
        this.frmPersona = frmPersona;
        this.frmFactura = frmFactura;
        this.conexion = conexion;
        this.objRecaudo = objRecaudo;
        this.objFactura = objFactura;
        iniComponetesInicio();
    }

    public Controlador() throws IOException {
        this.frmInicio = new frmPrincipal();
        this.frmEnvio = new frmRegistroEnvio();
        this.frmMercancia = new frmRegistroMercancia();
        this.frmPersona = new frmRegistroPersona();
        this.frmFactura = new frmRegistroFactura();
        this.conexion = new Conexion();
        this.objRecaudo = new Recaudo();
        this.objFactura = new Factura();
        this.frmoObjConsultaPersona = new frmConsultaPersona();
        iniComponetesInicio();
    }

    public void inicio() {
        frmInicio.setTitle("Multienvios");
        frmInicio.setVisible(true);
    }

    public void iniComponetesInicio() {
        frmInicio.getOpcRegistroEnvio().addActionListener(this);
        frmInicio.getOpcRegistroMercancia().addActionListener(this);
        frmInicio.getOpcRegistrarPersona().addActionListener(this);
        frmInicio.getOpcConsultarEnvios().addActionListener(this);
        frmInicio.getOpcConsultarMercancia().addActionListener(this);
        frmInicio.getOpcConsultarPersona().addActionListener(this);
        frmInicio.getOpcRegistrarFactura().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Registro Envio
        if (frmInicio.getOpcRegistroEnvio() == e.getSource()) {
            frmEnvio = new frmRegistroEnvio();
            frmInicio.getJdpEscritorio().add(frmEnvio);
            frmEnvio.setVisible(true);
            frmEnvio.getBtnGuardarEnvio().addActionListener(this);
        }
        if (frmEnvio.getBtnGuardarEnvio() == e.getSource()) {
            try {
                EnvioDAO objEnvioDAO = new EnvioDAO();
                switch (frmEnvio.getCmbTipoEnvio().getSelectedIndex()) {
                    case 0:
                        Envio objEnvioAereo = new Aereo();
                        objEnvioAereo.setNumeroEnvio(frmEnvio.getTxtNumeroEnvio().getText());
                        objEnvioAereo.setDescripcion(frmEnvio.getTxtDescripcion().getText());
                        objEnvioAereo.setOrigen(frmEnvio.getTxtOrigen().getText());
                        objEnvioAereo.setDestino(frmEnvio.getTxtDestino().getText());
                        objEnvioAereo.getDestinatario().setNombre(frmEnvio.getTxtDestinatario().getText());
                        conexion = new Conexion();
                        conexion.EscribeDatos("archivos/Envio.txt", objEnvioAereo.registroEnvio());
                        JOptionPane.showMessageDialog(frmInicio, "Datos de Envio Registrados correctamente en archivo");
                        objFactura.getListaEnvio().add(objEnvioAereo);
                        objEnvioDAO = new EnvioDAO();
                        objEnvioDAO.setObjEnvio(objEnvioAereo);
                        JOptionPane.showMessageDialog(frmInicio, objEnvioDAO.insertar());
                        break;
                    case 1:
                        Envio objEnvioTerrestre = new Terrestre();
                        objEnvioTerrestre.setNumeroEnvio(frmEnvio.getTxtNumeroEnvio().getText());
                        objEnvioTerrestre.setOrigen(frmEnvio.getTxtOrigen().getText());
                        objEnvioTerrestre.setDestino(frmEnvio.getTxtDestino().getText());
                        objEnvioTerrestre.setDescripcion(frmEnvio.getTxtDescripcion().getText());
                        objEnvioTerrestre.getDestinatario().setNombre(frmEnvio.getTxtDestinatario().getText());
                        conexion = new Conexion();
                        conexion.EscribeDatos("archivos/Envio.txt", objEnvioTerrestre.registroEnvio());
                        JOptionPane.showMessageDialog(frmInicio, "Datos de Envio Registrados correctamente en archivo");
                        objFactura.getListaEnvio().add(objEnvioTerrestre);
                        objEnvioDAO = new EnvioDAO();
                        objEnvioDAO.setObjEnvio(objEnvioTerrestre);
                        JOptionPane.showMessageDialog(frmInicio, objEnvioDAO.insertar());
                        break;
                }
                limpiarTexto(frmEnvio.getjPanel1());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error en guardado de Envio");
            }
        }

        //Registro Mercancia
        if (frmInicio.getOpcRegistroMercancia() == e.getSource()) {
            frmMercancia = new frmRegistroMercancia();
            frmInicio.getJdpEscritorio().add(frmMercancia);
            frmMercancia.setVisible(true);
            frmMercancia.getBtnGuardarMercancia().addActionListener(this);
        }
        if (frmMercancia.getBtnGuardarMercancia() == e.getSource()) {
            try {
                Mercancia objMercancia = new Mercancia(frmMercancia.getTxtSerial().getText(),
                        frmMercancia.getTxtDescripcion().getText(),
                        Integer.valueOf(frmMercancia.getTxtCantidad().getText()),
                        Integer.valueOf(frmMercancia.getTxtPeso().getText()));
                objFactura.getListaEnvio().get(objFactura.getListaEnvio().size()-1).getListaMercancia().add(objMercancia);
                conexion = new Conexion();
                conexion.EscribeDatos("archivos/Mercancia.txt", objMercancia.registroMercancia());
                JOptionPane.showMessageDialog(frmInicio, "Datos de Mercancia Registrados correctamente en archivo");
                MercanciaDAO objMercanciaDAO = new MercanciaDAO();
                objMercanciaDAO.setObjMercancia(objMercancia);
                JOptionPane.showMessageDialog(frmInicio, objMercanciaDAO.insertar());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error en guardado de Mercancia, tiene que registrar antes al menos un Envio");
            } 
            limpiarTexto(frmMercancia.getjPanel1());
        }

        //Registro Persona
        if (frmInicio.getOpcRegistrarPersona() == e.getSource()) {
            frmPersona = new frmRegistroPersona();
            frmInicio.getJdpEscritorio().add(frmPersona);
            frmPersona.setVisible(true);
            frmPersona.getBtnGuardarPersona().addActionListener(this);
        }
        if (frmPersona.getBtnGuardarPersona() == e.getSource()) {
            try {
                Persona objPersona = new Persona(frmPersona.getTxtNombre().getText(),
                        frmPersona.getTxtIdentificacion().getText(),
                        frmPersona.getTxtTelefono().getText());
                conexion = new Conexion();
                conexion.EscribeDatos("archivos/Persona.txt", objPersona.registroPersona());
                JOptionPane.showMessageDialog(frmInicio, "Datos de Persona Registrados correctamente en archivo");
                objFactura.setPersona(objPersona);
                PersonaDAO objPersonaDAO = new PersonaDAO();
                objPersonaDAO.setObjPersona(objPersona);
                JOptionPane.showMessageDialog(frmInicio, objPersonaDAO.insertar());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error en guardado de Persona");
            }
            limpiarTexto(frmPersona.getjPanel1());
        }

        //Registro Factura
        if (frmInicio.getOpcRegistrarFactura() == e.getSource()) {
            frmFactura = new frmRegistroFactura();
            frmInicio.getJdpEscritorio().add(frmFactura);
            frmFactura.setVisible(true);
            frmFactura.getBtnGenerarPDF().addActionListener(this);
        }
        if (frmFactura.getBtnGenerarPDF() == e.getSource()) {
            try {
                ArchPdf objArchPdf = new ArchPdf();
                objArchPdf.crearPDF(objFactura);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error en guardado de Factura");
            }
        }

        //Consulta Envio
        if (frmInicio.getOpcConsultarEnvios() == e.getSource()) {
            frmConsultaEnvio frmConsultarEnvio = new frmConsultaEnvio();
            frmInicio.getJdpEscritorio().add(frmConsultarEnvio);
            try {
                EnvioDAO objEnvioDAO = new EnvioDAO();
                frmConsultarEnvio.setVisible(true);
                frmConsultarEnvio.getTblListaEnvios().setModel(objEnvioDAO.consulta());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error al abrir el archivo Envio");
            }
        }

        //Consulta Mercancia
        if (frmInicio.getOpcConsultarMercancia() == e.getSource()) {
            try {
                frmConsultaMercancia frmConsultarMercancia1 = new frmConsultaMercancia();
                frmInicio.getJdpEscritorio().add(frmConsultarMercancia1);
                MercanciaDAO objMercanciaDAO = new MercanciaDAO();
                frmConsultarMercancia1.getTblListaMercancia().setModel(objMercanciaDAO.consulta());
                frmConsultarMercancia1.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error al abrir Mercancia");
            }
        }

        //Consulta Persona
        if (frmInicio.getOpcConsultarPersona() == e.getSource()) {
            try {
                frmoObjConsultaPersona = new frmConsultaPersona();
                frmInicio.getJdpEscritorio().add(frmoObjConsultaPersona);
                PersonaDAO objPersonaDAO = new PersonaDAO();
                frmoObjConsultaPersona.getTblListaPersona().setModel(objPersonaDAO.consulta());
                frmoObjConsultaPersona.setVisible(true);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error al abrir el archivo Mercancia");
            }
        }
        if (frmoObjConsultaPersona.getBtnEditarEnvio() == e.getSource()) {
            try {
                int fila=frmoObjConsultaPersona.getTblListaPersona().getSelectedRow();
                if(fila==-1){
                    JOptionPane.showMessageDialog(frmInicio, "Seleccione una fila");
                }else{
                    int id=Integer.parseInt((String)frmoObjConsultaPersona.getTblListaPersona().getValueAt(fila, 0).toString());
                    String nombre=(String)frmoObjConsultaPersona.getTblListaPersona().getValueAt(fila, 1);
                    String identificacion=(String)frmoObjConsultaPersona.getTblListaPersona().getValueAt(fila, 2);
                    String telefono=(String)frmoObjConsultaPersona.getTblListaPersona().getValueAt(fila, 3);
                    frmoObjConsultaPersona.setTxtEditarNombre(nombre);
                    frmoObjConsultaPersona.setTxtEditarNombre(identificacion);
                    frmoObjConsultaPersona.setTxtEditarNombre(telefono);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmInicio, "Error al abrir el archivo Mercancia");
            }
        }
        
    }

    public void limpiarTexto(JPanel panel) {
        for (Object i : panel.getComponents()) {
            if (i instanceof JTextField) {
                ((JTextField) i).setText("");
            }
        }
    }
}
