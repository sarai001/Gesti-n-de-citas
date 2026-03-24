package Modelo;

// Clase Enfermero que hereda de Persona, sin atributos adicionales
public class Enfermero extends Persona {

    // Constructor que recibe datos personales y los pasa a la superclase
    public Enfermero(String nombre, String telefono, String sexo, String domicilio, String email) {
        super(nombre, telefono, sexo, domicilio, email);
    }
}
