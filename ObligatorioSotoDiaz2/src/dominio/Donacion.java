// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.Serializable;

public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int PERROS_GRANDES = 1;
    public static final int PERROS_CHICOS = 2;
    public static final int PERROS_ADULTOS = 3;
    public static final int OTRO = 4;

    private int numero; // lo asigna Sistema, autonumerado desde 1
    private Empresa empresa;
    private int tipo;
    private double kilos;

    public Donacion(int numero, Empresa empresa, int tipo, double kilos) {
        this.numero = numero;
        this.empresa = empresa;
        this.tipo = tipo;
        this.kilos = kilos;
    }

    public int getNumero() {
        return numero;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public int getTipo() {
        return tipo;
    }

    public double getKilos() {
        return kilos;
    }

    // Se usa para validar el tipo al registrar e importar donaciones
    public static boolean esTipoValido(int tipo) {
        return tipo >= PERROS_GRANDES && tipo <= OTRO;
    }
    
    // Se usa para validar los kilos al registrar e importar donaciones
    public static boolean esKilosValido(double kilos) {
        return kilos > 0 && !Double.isInfinite(kilos);
    }
    
    // Nombre del tipo para mostrar en pantalla
    public static String nombreTipo(int tipo) {
        String nombre;
        switch (tipo) {
            case PERROS_GRANDES:
                nombre = "Perros grandes";
                break;
            case PERROS_CHICOS:
                nombre = "Perros chicos";
                break;
            case PERROS_ADULTOS:
                nombre = "Perros adultos";
                break;
            default:
                nombre = "Otro";
        }
        return nombre;
    }

    @Override
    public String toString() {
        return "Nro. " + numero + " - " + empresa.getNombre() + " - " + nombreTipo(tipo) + " - " + kilos + " kg";
    }
}
