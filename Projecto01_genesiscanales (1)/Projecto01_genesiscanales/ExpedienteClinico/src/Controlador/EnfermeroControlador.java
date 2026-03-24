package Controlador;

import Modelo.Enfermero;
import java.util.ArrayList;

public class EnfermeroControlador {

    // Lista para almacenar los enfermeros registrados
    private ArrayList<Enfermero> listaEnfermeros = new ArrayList<>();

    // Agrega un nuevo enfermero a la lista
    public void agregarEnfermero(Enfermero e) {
        listaEnfermeros.add(e);
    }

    // Devuelve la lista completa de enfermeros
    public ArrayList<Enfermero> getEnfermeros() {
        return listaEnfermeros;
    }
}
