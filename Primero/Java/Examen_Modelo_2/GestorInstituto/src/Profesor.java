import java.time.LocalDate;

public class Profesor extends Persona {
    private double salario;

    public Profesor(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String dni, double salario) {
        super(nombre, apellido1, apellido2, fechaNacimiento, dni);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor: " + getNombre() +
                ", " + getApellido1() + " " +
                getApellido2() + " con DNI: " +
                 getDni() +
                "con un salario de:" + salario +
                '€';
    }
}
