package Controlador;

import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class PacienteControlador {

    // Listas estáticas para almacenar los datos centrales del sistema
    public static List<Paciente> pacientes = new ArrayList<>();
    public static List<Doctor> doctores = new ArrayList<>();
    public static List<Enfermero> enfermeros = new ArrayList<>();
    public static List<Cita> citas = new ArrayList<>();
    public static List<HojaMedica> hojasMedicas = new ArrayList<>();
    public static List<Vacuna> vacunas = new ArrayList<>();
    public static List<HojaEnfermeria> hojasEnfermeria = new ArrayList<>();

    // Métodos para agregar datos a las listas

    public void agregarPaciente(Paciente p) {
        pacientes.add(p);
    }

    public void agregarDoctor(Doctor d) {
        doctores.add(d);
    }

    public void agregarEnfermero(Enfermero e) {
        enfermeros.add(e);
    }

    public void agregarCita(Cita c) {
        citas.add(c);
    }

    public void agregarVacuna(Vacuna vacuna) {
        vacunas.add(vacuna);
    }

    public void agregarHojaMedica(HojaMedica h) {
        hojasMedicas.add(h);
    }

    public void agregarHojaEnfermeria(HojaEnfermeria h) {
        hojasEnfermeria.add(h);
    }
}
