// Autores: Santino Soto (381618) - Juan Manuel Díaz (376055)
package interfaz;

import dominio.Animal;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

// Pinta cada animal de una lista con el color de su estado (la usan varias ventanas)
public class RenderAnimales extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> lista, Object valor,
            int indice, boolean seleccionado, boolean foco) {
        super.getListCellRendererComponent(lista, valor, indice, seleccionado, foco);
        Animal animal = (Animal) valor;
        setText(animal.getNombre() + " - " + animal.getEstado());
        if (animal.estaDisponible()) {
            setForeground(new Color(0, 128, 0));
        } else if (animal.estaEntregado()) {
            setForeground(Color.BLUE);
        } else {
            setForeground(Color.RED);
        }
        return this;
    }
}
