package Controlador;

import Modelo.HojaEnfermeria;
import java.util.ArrayList;

public class HojaEnfermeriaControlador {

    // Lista para almacenar las hojas de enfermería registradas
    private ArrayList<HojaEnfermeria> listaHojasEnfermeria = new ArrayList<>();

    // Agrega una nueva hoja de enfermería a la lista
    public void agregarHojaEnfermeria(HojaEnfermeria he) {
        listaHojasEnfermeria.add(he);
    }

    // Devuelve la lista completa de hojas de enfermería
    public ArrayList<HojaEnfermeria> getHojasEnfermeria() {
        return listaHojasEnfermeria;
    }
}

