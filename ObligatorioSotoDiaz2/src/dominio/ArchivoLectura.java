// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

// Clase del libro del curso; en vez de System.exit lanza la excepción para que la interfaz avise al usuario
public class ArchivoLectura {

    private Scanner in;
    private String linea;

    public ArchivoLectura(String unNombre) throws IOException {
        in = new Scanner(Paths.get(unNombre));
    }

    // Debe llamarse antes de linea(): si hay otra línea, la deja disponible
    public boolean hayMasLineas() {
        boolean hay = false;
        linea = null;
        if (in.hasNext()) {
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }

    public String linea() {
        return linea;
    }

    public void cerrar() {
        in.close();
    }
}
