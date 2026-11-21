// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.Serializable;

public class Animal implements Serializable {

    // Estados posibles de un animal
    public static final String NO_DISPONIBLE = "No disponible";
    public static final String DISPONIBLE = "Disponible";
    public static final String ENTREGADO = "Entregado a familia";

    private String codigo;
    private String nombre;
    private String temperamento;
    private double peso; // en kilos, admite decimales
    private String estado;

    public Animal(String codigo, String nombre, String temperamento, double peso, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.temperamento = temperamento;
        this.peso = peso;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // true si el animal se puede adoptar
    public boolean estaDisponible() {
        return estado.equals(DISPONIBLE);
    }

    // true si ya fue entregado a una familia en una adopción
    public boolean estaEntregado() {
        return estado.equals(ENTREGADO);
    }

    // Pasa de disponible a no disponible y viceversa (no aplica a entregados)
    public void cambiarEstado() {
        if (estaDisponible()) {
            estado = NO_DISPONIBLE;
        } else if (estado.equals(NO_DISPONIBLE)) {
            estado = DISPONIBLE;
        }
    }

    // Dos animales son iguales si tienen el mismo codigo (se usa para validar repetidos)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal otro = (Animal) o;
        return codigo.equalsIgnoreCase(otro.getCodigo());
    }

    // Texto que muestran las listas de las ventanas
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
