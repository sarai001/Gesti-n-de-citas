package Modelo;

public class HojaEnfermeria {
    private String fecha;
    private String hora;
    private String signosVitales;
    private String observaciones;
    private String evolucion;
    private Enfermero enfermero;

    // Constructor que inicializa todos los atributos de la hoja de enfermería
    public HojaEnfermeria(String fecha, String hora, String signosVitales, String observaciones, String evolucion, Enfermero enfermero) {
        this.fecha = fecha;
        this.hora = hora;
        this.signosVitales = signosVitales;
        this.observaciones = observaciones;
        this.evolucion = evolucion;
        this.enfermero = enfermero;
    }

    // Getters y setters (omitir por brevedad, pero deben incluirse para cada atributo)
}
