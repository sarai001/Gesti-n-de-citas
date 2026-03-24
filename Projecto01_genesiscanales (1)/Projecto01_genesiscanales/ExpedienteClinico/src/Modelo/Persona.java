package Modelo;

// Clase abstracta que representa una persona con atributos comunes
public abstract class Persona {
    protected String nombre;
    protected String telefono;
    protected String sexo;
    protected String domicilio;
    protected String email;

    // Constructor para inicializar los datos personales
    public Persona(String nombre, String telefono, String sexo, String domicilio, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sexo = sexo;
        this.domicilio = domicilio;
        this.email = email;
    }

    // Getters y setters para acceder y modificar los atributos

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
