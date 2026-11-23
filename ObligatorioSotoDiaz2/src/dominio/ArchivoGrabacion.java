// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

// Clase del libro del curso; en vez de System.exit lanza la excepción para que la interfaz avise al usuario
public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String unNombre) throws IOException {
        out = new Formatter(unNombre);
    }

    // Si ext es true se agrega al final del archivo; si es false se sobreescribe
    public ArchivoGrabacion(String unNombre, boolean ext) throws IOException {
        out = new Formatter(new FileWriter(unNombre, ext));
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}
