package Modelo;

public class Cita {
    // Paciente asignado a la cita
    private Paciente paciente;
    // Doctor asignado a la cita
    private Doctor doctor;
    // Fecha de la cita (formato String, e.g., "yyyy-MM-dd")
    private String fecha;
    // Hora de la cita (formato String, e.g., "HH:mm")
    private String hora;

    // Constructor para inicializar una cita con paciente, doctor, fecha y hora
    public Cita(Paciente paciente, Doctor doctor, String fecha, String hora) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y setters (se pueden generar automáticamente)
}
