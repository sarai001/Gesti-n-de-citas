package Controlador;

import Modelo.Vacuna;
import java.util.ArrayList;

public class VacunaControlador {

    // Lista que almacena las vacunas registradas
    private ArrayList<Vacuna> listaVacunas = new ArrayList<>();

    // Agrega una nueva vacuna a la lista
    public void agregarVacuna(Vacuna v) {
        listaVacunas.add(v);
    }

    // Devuelve la lista completa de vacunas
    public ArrayList<Vacuna> getVacunas() {
        return listaVacunas;
    }
}
