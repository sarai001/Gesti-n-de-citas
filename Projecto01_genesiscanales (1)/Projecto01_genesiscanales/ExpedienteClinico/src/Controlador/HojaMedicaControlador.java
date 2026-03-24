package Controlador;

import Modelo.HojaMedica;
import java.util.ArrayList;

public class HojaMedicaControlador {

    // Lista que almacena todas las hojas médicas registradas
    private ArrayList<HojaMedica> listaHojasMedicas = new ArrayList<>();

    // Método para agregar una hoja médica a la lista
    public void agregarHojaMedica(HojaMedica hm) {
        listaHojasMedicas.add(hm);
    }

    // Devuelve la lista completa de hojas médicas
    public ArrayList<HojaMedica> getHojasMedicas() {
        return listaHojasMedicas;
    }
}
