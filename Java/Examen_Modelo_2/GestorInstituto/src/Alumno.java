import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona {
    private String curso;
    private ArrayList<Materias> notas;


    public Alumno(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String dni, String curso, ArrayList<Materias> notas) {
        super(nombre, apellido1, apellido2, fechaNacimiento, dni);
        this.curso = curso;
        this.notas = notas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ArrayList<Materias> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Materias> notas) {
        this.notas = notas;
    }



    @Override
    public String toString() {
        return "Alumno: " + getNombre() +
                ", " + getApellido1() + " " +
                getApellido2() + " con DNI: " +
                getDni() +
                " Curso: " + curso +
                "\n" + notas;
    }
}
