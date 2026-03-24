package Modelo;

public class HojaMedica {
    private String fecha;
    private String hora;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private Doctor doctor;

    // Constructor que inicializa todos los campos de la hoja médica
    public HojaMedica(String fecha, String hora, String motivoConsulta, String diagnostico, String tratamiento, Doctor doctor) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.doctor = doctor;
    }

    // Getters y setters pueden ser agregados aquí para cada atributo si se requieren
}

