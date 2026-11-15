// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.Serializable;

public class Empresa implements Serializable {

    private String nombre;
    private String rut;
    private String direccion;

    public Empresa(String nombre, String rut, String direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getDireccion() {
        return direccion;
    }

    // Dos empresas son iguales si tienen el mismo RUT (se usa para validar repetidos)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Empresa)) {
            return false;
        }
        Empresa otra = (Empresa) o;
        return rut.equals(otra.getRut());
    }

    // Texto que muestran las listas de las ventanas
    @Override
    public String toString() {
        return nombre + " (RUT " + rut + ")";
    }
}
