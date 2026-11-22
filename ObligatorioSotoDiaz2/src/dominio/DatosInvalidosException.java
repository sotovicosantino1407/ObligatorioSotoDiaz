// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

// Se lanza cuando un dato no cumple las reglas del refugio; el mensaje se muestra al usuario
public class DatosInvalidosException extends Exception {

    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
