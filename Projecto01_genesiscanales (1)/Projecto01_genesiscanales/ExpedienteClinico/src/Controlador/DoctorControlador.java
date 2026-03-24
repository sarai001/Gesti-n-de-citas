package Controlador;

import Modelo.Doctor;
import java.util.ArrayList;

public class DoctorControlador {

    // Lista que almacena los doctores registrados
    private ArrayList<Doctor> listaDoctores = new ArrayList<>();

    // Agrega un doctor a la lista
    public void agregarDoctor(Doctor d) {
        listaDoctores.add(d);
    }

    // Devuelve la lista completa de doctores
    public ArrayList<Doctor> getDoctores() {
        return listaDoctores;
    }
}
