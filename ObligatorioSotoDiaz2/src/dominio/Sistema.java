// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

// Clase central del dominio: guarda todos los datos y avisa a las ventanas cuando algo cambia
public class Sistema extends Observable implements Serializable {

    public static final String ARCHIVO_DATOS = "datos.ser";
    private ArrayList<Animal> animales;
    private ArrayList<Familia> familias;
    private ArrayList<Empresa> empresas;
    private ArrayList<Adopcion> adopciones;
    private ArrayList<Donacion> donaciones;

    // Ultimo numero usado; no bajan al anular, asi un numero nunca se reutiliza
    private int ultimaAdopcion;
    private int ultimaDonacion;

    public Sistema() {
        animales = new ArrayList<>();
        familias = new ArrayList<>();
        empresas = new ArrayList<>();
        adopciones = new ArrayList<>();
        donaciones = new ArrayList<>();
        ultimaAdopcion = 0;
        ultimaDonacion = 0;
    }

    // Avisa a todas las ventanas que observan al sistema para que se actualicen
    private void avisarCambios() {
        setChanged();
        notifyObservers();
    }

    // ---------- Animales ----------
    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    // Devuelve false si el codigo ya existe
    public boolean agregarAnimal(Animal animal) throws DatosInvalidosException {
        if (!Animal.esPesoValido(animal.getPeso())) {
            throw new DatosInvalidosException("El peso debe ser un número mayor a 0");
        }
        boolean agregado = false;
        if (!animales.contains(animal)) {
            animales.add(animal);
            agregado = true;
            avisarCambios();
        }
        return agregado;
    }

    public ArrayList<Animal> getAnimalesDisponibles() {
        ArrayList<Animal> disponibles = new ArrayList<>();
        for (Animal a : animales) {
            if (a.estaDisponible()) {
                disponibles.add(a);
            }
        }
        return disponibles;
    }

    // Los que aparecen en "Cambiar de estado"
    public ArrayList<Animal> getAnimalesNoEntregados() {
        ArrayList<Animal> noEntregados = new ArrayList<>();
        for (Animal a : animales) {
            if (!a.estaEntregado()) {
                noEntregados.add(a);
            }
        }
        return noEntregados;
    }

    public void cambiarEstado(Animal animal) {
        animal.cambiarEstado();
        avisarCambios();
    }

    public int cantidadAnimalesEnEstado(String estado) {
        int cantidad = 0;
        for (Animal a : animales) {
            if (a.getEstado().equals(estado)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // ---------- Familias ----------
    public ArrayList<Familia> getFamilias() {
        return familias;
    }

    // Devuelve false si la cedula ya existe
    public boolean agregarFamilia(Familia familia) {
        boolean agregada = false;
        if (!familias.contains(familia)) {
            familias.add(familia);
            agregada = true;
            avisarCambios();
        }
        return agregada;
    }

    public int cantidadAdopcionesDe(Familia familia) {
        int cantidad = 0;
        for (Adopcion ad : adopciones) {
            if (ad.getFamilia().equals(familia)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Se devuelve una copia ordenada para no desordenar la lista original
    public ArrayList<Familia> getFamiliasPorApellido() {
        ArrayList<Familia> copia = new ArrayList<>(familias);
        copia.sort((f1, f2) -> f1.getApellido().compareToIgnoreCase(f2.getApellido()));
        return copia;
    }

    // De mayor a menor cantidad de adopciones
    public ArrayList<Familia> getFamiliasPorAdopciones() {
        ArrayList<Familia> copia = new ArrayList<>(familias);
        copia.sort((f1, f2) -> cantidadAdopcionesDe(f2) - cantidadAdopcionesDe(f1));
        return copia;
    }

    // ---------- Empresas ----------
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    // Devuelve false si el RUT ya existe
    public boolean agregarEmpresa(Empresa empresa) {
        boolean agregada = false;
        if (!empresas.contains(empresa)) {
            empresas.add(empresa);
            agregada = true;
            avisarCambios();
        }
        return agregada;
    }

    // Devuelve null si no hay ninguna empresa con ese RUT (se usa al importar)
    public Empresa buscarEmpresa(String rut) {
        Empresa encontrada = null;
        for (Empresa e : empresas) {
            if (e.getRut().equals(rut)) {
                encontrada = e;
            }
        }
        return encontrada;
    }

    // ---------- Adopciones ----------
    // Las adopciones se agregan en orden, asi que la lista ya queda ordenada por numero
    public ArrayList<Adopcion> getAdopciones() {
        return adopciones;
    }

    public Adopcion realizarAdopcion(Animal animal, Familia familia, String comentarios) {
        ultimaAdopcion++;
        Adopcion adopcion = new Adopcion(ultimaAdopcion, animal, familia, comentarios);
        adopciones.add(adopcion);
        animal.setEstado(Animal.ENTREGADO);
        avisarCambios();
        return adopcion;
    }

    public void anularAdopcion(Adopcion adopcion) {
        adopcion.getAnimal().setEstado(Animal.NO_DISPONIBLE);
        adopciones.remove(adopcion);
        avisarCambios();
    }

    // ---------- Donaciones ----------
    // Igual que las adopciones, ya quedan ordenadas por numero
    public ArrayList<Donacion> getDonaciones() {
        return donaciones;
    }

    public Donacion registrarDonacion(Empresa empresa, int tipo, double kilos) throws DatosInvalidosException {
        if (!Donacion.esTipoValido(tipo)) {
            throw new DatosInvalidosException("Tipo de alimento incorrecto");
        }
        if (!Donacion.esKilosValido(kilos)) {
            throw new DatosInvalidosException("Los kilos deben ser un número mayor a cero");
        }
        ultimaDonacion++;
        Donacion donacion = new Donacion(ultimaDonacion, empresa, tipo, kilos);
        donaciones.add(donacion);
        avisarCambios();
        return donacion;
    }

    // Total de kilos donados de un tipo de alimento
    public double stockDeTipo(int tipo) {
        double total = 0;
        for (Donacion d : donaciones) {
            if (d.getTipo() == tipo) {
                total += d.getKilos();
            }
        }
        return total;
    }

    // ---------- Importar donaciones ----------
    // Lee un archivo con lineas "rut#tipo#kilos" y registra las correctas.
    // Si alguna linea tiene errores genera "<nombre>Error.txt" en la misma carpeta.
    // Devuelve la cantidad de lineas con errores (0 = todo bien).
    public int importarDonaciones(File archivo) throws IOException {
        ArrayList<String> errores = new ArrayList<>();
        int numeroLinea = 0;
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea = lector.readLine();
            while (linea != null) {
                numeroLinea++;
                String problemas = procesarLinea(linea);
                if (!problemas.isEmpty()) {
                    errores.add("Linea " + numeroLinea + ": " + problemas);
                }
                linea = lector.readLine();
            }
        }
        if (!errores.isEmpty()) {
            grabarErrores(archivo, errores);
        }
        return errores.size();
    }

    // Registra la donacion si la linea es correcta; si no, devuelve el texto con los errores
    private String procesarLinea(String linea) {
        String problemas = "";
        String[] partes = linea.split("#");
        if (partes.length != 3) {
            problemas = "formato incorrecto (se espera rut#tipo#cantidadDeKilos)";
        } else {
            Empresa empresa = buscarEmpresa(partes[0].trim());
            if (empresa == null) {
                problemas += "empresa no registrada; ";
            }
            int tipo = 0;
            try {
                tipo = Integer.parseInt(partes[1].trim());
            } catch (NumberFormatException e) {
                tipo = 0;
            }
            if (!Donacion.esTipoValido(tipo)) {
                problemas += "tipo incorrecto; ";
            }
            double kilos = 0;
            try {
                kilos = Double.parseDouble(partes[2].trim());
            } catch (NumberFormatException e) {
                kilos = 0;
            }
            if (!Donacion.esKilosValido(kilos)) {
                problemas += "cantidad incorrecta, debe ser mayor a 0; ";
            }

            if (problemas.isEmpty()) {
                try {
                    registrarDonacion(empresa, tipo, kilos);
                } catch (DatosInvalidosException e) {
                    problemas = e.getMessage();
                }
            } else if (problemas.endsWith("; ")) {
                problemas = problemas.substring(0, problemas.length() - 2); // saca el "; " del final
            }
        }
        return problemas;
    }

    // Ej: "Datos.txt" -> "DatosError.txt"
    private void grabarErrores(File archivo, ArrayList<String> errores) throws IOException {
        String nombre = archivo.getName();
        int punto = nombre.lastIndexOf('.');
        String nombreError;
        if (punto >= 0) {
            nombreError = nombre.substring(0, punto) + "Error" + nombre.substring(punto);
        } else {
            nombreError = nombre + "Error";
        }
        File archivoError = new File(archivo.getParentFile(), nombreError);
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoError))) {
            for (String error : errores) {
                escritor.println(error);
            }
        }
    }

    // ---------- Pagina HTML ----------
    // Genera la pagina con todas las adopciones y devuelve el archivo creado (para abrirlo en el navegador)
    public File generarPagina(String ruta) throws IOException {
        if (!ruta.toLowerCase().endsWith(".html")) {
            ruta = ruta + ".html";
        }
        File pagina = new File(ruta);
        try (PrintWriter html = new PrintWriter(pagina, "UTF-8")) {
            html.println("<!DOCTYPE html>");
            html.println("<html><head><meta charset=\"UTF-8\"><title>Adopciones</title></head><body>");
            html.println("<h1>Adopciones del refugio</h1>");
            if (adopciones.isEmpty()) {
                html.println("<p>No hay adopciones registradas.</p>");
            } else {
                html.println("<p>Cantidad total de adopciones: " + adopciones.size() + "</p>");
                html.println("<table border=\"1\">");
                html.println("<tr><th>N&uacute;mero</th><th>C&oacute;digo</th><th>Animal</th><th>Familia</th><th>Comentarios</th></tr>");
                for (Adopcion ad : adopciones) {
                    html.println("<tr><td>" + ad.getNumero() + "</td><td>" + ad.getAnimal().getCodigo()
                            + "</td><td>" + ad.getAnimal().getNombre() + "</td><td>" + ad.getFamilia().getApellido()
                            + "</td><td>" + ad.getComentarios() + "</td></tr>");
                }
                html.println("</table>");
            }
            html.println("</body></html>");
        }
        return pagina;
    }

    // ---------- Persistencia ----------
    // Se llama solo al salir del programa
    public void guardar(String nombreArchivo) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
        }
    }

    // Copia los datos guardados dentro de este mismo objeto, asi las ventanas siguen observandolo
    public void recuperar(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Sistema guardado = (Sistema) entrada.readObject();
            animales = guardado.animales;
            familias = guardado.familias;
            empresas = guardado.empresas;
            adopciones = guardado.adopciones;
            donaciones = guardado.donaciones;
            ultimaAdopcion = guardado.ultimaAdopcion;
            ultimaDonacion = guardado.ultimaDonacion;
        }
        avisarCambios();
    }
}
