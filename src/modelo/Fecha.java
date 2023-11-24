package Modelo;

import java.util.Calendar;

/**
 * Clase Fecha permite definir la fecha del sisma Multienvios
 *
 * @author Victor Huertas
 * @version 1.0
 */
public class Fecha {

    private int dd, mm, aa;

    /**
     * Un objeto de tipo Fecha utiliza los siguientes parametros
     *
     * @param dd : dia del año
     * @param mm : mes del año
     * @param aa : año
     */
    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    /**
     * Crea objeto de tipo Factura de manera que la fecha toma la informacion de
     * la maquina
     */
    public Fecha() {
        Calendar aux = Calendar.getInstance();
        this.dd = aux.get(Calendar.DAY_OF_MONTH);
        this.mm = aux.get(Calendar.MONTH) + 1;
        this.aa = aux.get(Calendar.YEAR);
    }

    /**
     * Retorna el dia de la fecha en un numero entero
     *
     * @return int
     */
    public int getDd() {
        return dd;
    }

    /**
     * Establece o modifica el dia del objeto fecha a partir de una dato enetero
     *
     * @param dd: dia de fecha
     */
    public void setDd(int dd) {
        this.dd = dd;
    }

    /**
     * Retorna el mes de la fecha en un numero entero
     *
     * @return int
     */
    public int getMm() {
        return mm;
    }

    /**
     * Establece o modifica el mes del objeto fecha a partir de una dato enetero
     *
     * @param mm: mes de fecha
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * Retorna el año de la fecha en un numero entero
     *
     * @return int
     */
    public int getAa() {
        return aa;
    }

    /**
     * Establece o modifica el año del objeto fecha a partir de una dato enetero
     *
     * @param aa: año de fecha
     */
    public void setAa(int aa) {
        this.aa = aa;
    }

    /**
     * Retorna la información total de la Fecha correspondiente a su dia, mes y
     * año en tipo de cadena de caracteres
     *
     * @return String
     */
    @Override
    public String toString() {
        return +dd + "/" + mm + "/" + aa;
    }

}
