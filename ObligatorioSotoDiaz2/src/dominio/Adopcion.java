// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.Serializable;

public class Adopcion implements Serializable {

    private static final long serialVersionUID = 1L;

    private int numero; // lo asigna Sistema, autonumerado desde 1
    private Animal animal;
    private Familia familia;
    private String comentarios;

    public Adopcion(int numero, Animal animal, Familia familia, String comentarios) {
        this.numero = numero;
        this.animal = animal;
        this.familia = familia;
        this.comentarios = comentarios;
    }

    public int getNumero() {
        return numero;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Familia getFamilia() {
        return familia;
    }

    public String getComentarios() {
        return comentarios;
    }

    // Texto que muestra la lista de "Anular adopcion"
    @Override
    public String toString() {
        return "Nro. " + numero + " - " + animal.getNombre() + " -> " + familia.getApellido();
    }
}
