import java.time.LocalDate;
import java.time.Period;

public abstract class  Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate   fechaNacimiento;
    private String dni;

    public Persona(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public  int caluclarEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dni='" + dni + '\'' +
                '}';
    }

}

