package Controlador;

import Modelo.Cita;
import java.util.ArrayList;

public class CitaControlador {

    // Lista que almacena todas las citas registradas
    private ArrayList<Cita> listaCitas = new ArrayList<>();

    // Agrega una nueva cita a la lista
    public void agregarCita(Cita c) {
        listaCitas.add(c);
    }

    // Devuelve la lista completa de citas
    public ArrayList<Cita> getCitas() {
        return listaCitas;
    }
}
