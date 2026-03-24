package Modelo;

// Representa una vacuna aplicada a un paciente
public class Vacuna {
    private String fecha;          // Fecha en que se aplicó la vacuna
    private String nombreVacuna;   // Nombre o tipo de vacuna
    private Persona aplicadoPor;   // Persona (doctor o enfermero) que aplicó la vacuna

    // Constructor para inicializar los atributos
    public Vacuna(String fecha, String nombreVacuna, Persona aplicadoPor) {
        this.fecha = fecha;
        this.nombreVacuna = nombreVacuna;
        this.aplicadoPor = aplicadoPor;
    }

    // Getters y setters para acceder y modificar los atributos
}
