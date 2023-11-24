package persistencia;

import java.io.*;

/**
 * Clase Conexion es una clase que se dedica a crear y a leer archivoa txt
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Conexion {

    protected BufferedReader ent;
    protected FileReader archLee;
    protected FileWriter archEscr;
    protected PrintWriter sal;

    /**
     * Un objeto de tipo Conexion utiliza los siguientes parametros
     *
     * @param ent : entrada la archivo
     * @param archLee : leer archivo
     * @param archEscr : escribir archivo
     * @param sal : salida de archivo
     *
     */
    public Conexion(BufferedReader ent, FileReader archLee, FileWriter archEscr, PrintWriter sal) {
        this.ent = ent;
        this.archLee = archLee;
        this.archEscr = archEscr;
        this.sal = sal;
    }

    /**
     * Crea objeto de tipo Envio con datos nulos
     * @exception IOException : error en entrada y salida
     */
    public Conexion() throws IOException {
        // this.ent = ent;
        this.archLee = null;
        this.archEscr = null;
        // this.sal = sal;
    }

    /**
     * Esta funcion se dedica a leer los datos de un archivo .txt y lo retorna
     * en una cadena de caracteres
     *
     * @exception IOException : error en entrada y salida
     * @param arch : nombre y ubicacion del archivo
     * @return String
     */
    public String leerDatos(String arch) throws IOException {
        //System.out.println("Entré...");
        this.archLee = new FileReader(arch);
        ent = new BufferedReader(archLee);
        String datos = " ";
        String linea = this.ent.readLine();
        while (linea != null) {
            datos += linea + "\n";
            //       System.out.println(" "+datos);
            linea = ent.readLine();
        }
        ent.close();
        return datos;
    }

    /**
     * Esta funcion se dedica a escribir los datos de un archivo .txt y lo
     * retorna en una cadena de caracteres
     *
     * @param arch : nombre y ubicacion del archivo
     * @param datos : cadena de caracteres de archivo
     * @exception IOException : error en entrada y salida
     */
    public void EscribeDatos(String arch, String datos) throws IOException {
        archEscr = new FileWriter(arch, true);
        sal = new PrintWriter(archEscr);
        sal.println(datos);
        System.out.println("Ejecuto accion");
        sal.close();
    }
}