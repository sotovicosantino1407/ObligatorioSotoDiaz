// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.Serializable;

public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cedula; // del titular, sin validar formato
    private String apellido;
    private String celular; // sin validar formato

    public Familia(String cedula, String apellido, String celular) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.celular = celular;
    }

    public String getCedula() {
        return cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    // Dos familias son iguales si tienen la misma cedula (se usa para validar repetidos)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Familia)) {
            return false;
        }
        Familia otra = (Familia) o;
        return cedula.equals(otra.getCedula());
    }

    // Texto que muestran las listas de las ventanas
    @Override
    public String toString() {
        return apellido + " (" + cedula + ")";
    }
}
