package modelo;

import com.barcodelib.barcode.QRCode;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
//archivos
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//librerias ajenas a itext
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.tools.jar.Main;

/**
 * Clase ArchPdf es una clase que se dedica a generar un PDF a partir de los
 * datos de un objeto Factura
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class ArchPdf {

    private File rutaDestino;

    /**
     * Crea objeto de tipo ArchPdf con datos nulos
     */
    public ArchPdf() {
        this.rutaDestino = null;
    }

    /**
     * Crea o manipula un archivo PDF a partir de un objeto factura con todos
     * los datos que este contiene
     *
     * @param factura : objeto de tipo Factura
     */
    /* metodo que hace uso de la clase itext para manipular archivos PDF*/
    public void crearPDF(Factura factura) {
        //abre ventana de dialogo "guardar"
        ColocarDestino();
        //si destino es diferente de null
        if (this.rutaDestino != null) {
            try {
                // se crea instancia del documento
                Document mipdf = new Document();
                // se establece una instancia a un documento pdf
                PdfWriter p = PdfWriter.getInstance(mipdf, new FileOutputStream(this.rutaDestino + ".pdf"));
                mipdf.open();// se abre el documento
                mipdf.addTitle("Factura Multienvios"); // se añade el titulo

                /*mipdf.addAuthor(a); // se añade el autor del documento
                mipdf.addSubject(s); //se añade el asunto del documento
                mipdf.addKeywords(k); //Se agregan palabras claves*/
                mipdf.add(new Paragraph("Factura Multienvios:\n"));
                mipdf.add(codigoQR(factura));
                mipdf.add(new Paragraph(factura.toString()));
                mipdf.add(new Paragraph("Valor Total: $" + factura.total() + "\n\n"));
                mipdf.add(codigoBarras(mipdf, p, factura));
                // se añade el contendio del PDF
                mipdf.close(); //se cierra el PDF&
                //JOptionPane.showMessageDialog(null, "Documento PDF creado");
            } catch (DocumentException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Funcion que se dedica a elegir el destino que el usuario elija en donde
     * se va a guardar el archivo PDF
     *
     */
    /* abre la ventana de dialogo GUARDAR*/
    public void ColocarDestino() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf", "PDF");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.rutaDestino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }

    /**
     * Esta funcion se dedica a crear un codigo de barras en un archivo PDF a
     * partir de unos datos elegidos en la funcion convertiraCodigoBarras, los
     * datos son de tipo factura
     *
     * @param doc : objeto de tipo Documento
     * @param pw : objeto de tipo PdfWriter
     * @param factura : objeto de tipo Factura
     * @return Image
     */
    public Image codigoBarras(Document doc, PdfWriter pw, Factura factura) {

        PdfContentByte cimg = pw.getDirectContent();
        Barcode128 code128 = new Barcode128();
        code128.setCode(convertiraCodigoBarras(factura));
        //tipo de codigo que se le va a enviar
        code128.setCodeType(Barcode128.CODE128);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        Image img = code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
        //para el posicionamiento y tamaÃƒÆ’Ã‚ ±o  
        img.setAlignment(Element.ALIGN_CENTER);
        return img;

    }

    /**
     * Esta funcion se dedica a crear un codigo de QR en un archivo PDF a partir
     * de unos datos elegidos en la funcion convertiraCodigoQR, los datos son de
     * tipo factura
     *
     * @param factura : objeto de tipo Factura
     * @return Image
     */
    public Image codigoQR(Factura factura) {
        Image img = null;
        int udm = 0; //unidad dimensión pixeles
        int resol = 72; //resolución del qr
        //margenes de la zona blanca del qr
        float mi = 0.000f;
        float md = 0.000f;
        float ms = 0.000f;
        float min = 0.000f;
        //rotacion grados
        int rot = 0;
        //tamaño de la imagen
        float tam = 5.000f;
        QRCode cod = new QRCode();
        cod.setData(convertiraCodigoQR(factura));
        cod.setDataMode(QRCode.MODE_BYTE);
        cod.setUOM(udm);
        cod.setLeftMargin(mi);
        cod.setTopMargin(ms);
        cod.setBottomMargin(min);
        cod.setRightMargin(md);
        cod.setRotate(rot);
        cod.setResolution(resol);
        cod.setModuleSize(tam);
        String archiv = System.getProperty("user.home") + "/QRDemo.gif";
        try {
            cod.renderBarcode(archiv);
            img = Image.getInstance(archiv);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return img;
    }

    /**
     * Retorna la ruta de destino del archivo PDF en un objeto de tipo File
     *
     * @return File
     */
    public File getRutaDestino() {
        return rutaDestino;
    }

    /**
     * Establece o modifica la ruta de destino del archivo PDF a partir de un
     * objeto de tipo File
     *
     * @param rutaDestino : ruta de destino de archivo PDF
     */
    public void setRutaDestino(File rutaDestino) {
        this.rutaDestino = rutaDestino;
    }

    /**
     * Esta funcion se dedica a retornar en una cadena de caracteres dos datos
     * de tipo Factura los cuales son la fecha y el numero de factura
     *
     * @param factura : objeto de tipo Factura
     * @return String
     */
    public String convertiraCodigoBarras(Factura factura) {
        return factura.getFecha() + "-" + factura.getNumeroFactura();
    }

    /**
     * Esta funcion se dedica a retornar en una cadena de caracteres dos datos
     * de tipo Factura los cuales son el nombre de la persona y ID de la persona
     *
     * @param factura : objeto de tipo Factura
     * @return String
     */
    public String convertiraCodigoQR(Factura factura) {
        return factura.getPersona().getId() + "-" + factura.getPersona().getNombre();
    }
}
