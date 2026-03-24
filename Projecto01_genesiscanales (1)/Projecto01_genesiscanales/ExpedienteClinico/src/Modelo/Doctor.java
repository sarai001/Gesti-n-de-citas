package Modelo;

// Clase Doctor hereda de Persona y agrega la especialidad médica
public class Doctor extends Persona {
    private String especialidad;

    // Constructor que recibe datos personales y la especialidad
    public Doctor(String nombre, String telefono, String sexo, String domicilio, String email, String especialidad) {
        super(nombre, telefono, sexo, domicilio, email);
        this.especialidad = especialidad;
    }

    // Getter para especialidad
    public String getEspecialidad() {
        return especialidad;
    }

    // Setter para especialidad
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
