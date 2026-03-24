package Modelo;

// Clase que representa un paciente, hereda atributos comunes de Persona
public class Paciente extends Persona {

    // Constructor que inicializa el paciente con sus datos personales
    public Paciente(String nombre, String telefono, String sexo, String domicilio, String email) {
        super(nombre, telefono, sexo, domicilio, email);
    }
}
