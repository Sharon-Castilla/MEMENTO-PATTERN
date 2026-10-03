package main;

import caretaker.Historial;
import memento.Memento;
import originator.Editor;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        Historial historial = new Historial();

        System.out.println("Restaurar sin historial");
        restaurarUltimo(editor, historial);

        System.out.println("\nCambio 1");
        editor.setContenido("Hola");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        historial.guardarEstado(editor.guardar());
        System.out.println("Se guarda el estado.");

        System.out.println("\nCambio 2");
        editor.setContenido("Hola, mundo");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
        historial.guardarEstado(editor.guardar());
        System.out.println("Se guarda el estado.");

        System.out.println("\nCambio 3 (sin guardar)");
        editor.setContenido("Hola, mundo. Adios");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

        System.out.println("\nRestaurar");
        restaurarUltimo(editor, historial);
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

        System.out.println("\nNueva modificacion despues de restaurar");
        editor.setContenido("Hola, mundo. Bienvenidos");
        System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");
    }


    private static void restaurarUltimo(Editor editor, Historial historial) {
        if (!historial.hayEstados()) {
            System.out.println("No hay estados guardados para restaurar.");
            return;
        }
        Memento ultimo = historial.obtenerUltimoEstado();
        editor.restaurar(ultimo);
        System.out.println("Se restaura el ultimo estado guardado.");
    }
}
