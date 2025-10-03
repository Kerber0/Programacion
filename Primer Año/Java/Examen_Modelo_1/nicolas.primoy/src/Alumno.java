public class Alumno {
    String nombre;
    String apellido1;
    String apellido2;
    double tema1;
    double tema2;
    double tema3;
    double tema4;
    int id;


    public Alumno(int id,String nombre, String apellido1, String apellido2, double tema1, double tema2,
        double tema3, double tema4) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tema1 = tema1;
        this.tema2 = tema2;
        this.tema3 = tema3;
        this.tema4 = tema4;


    }

    public Alumno(int id, double tema1, double tema2,
        double tema3, double tema4) {
        this.id = id;
        this.tema1 = tema1;
        this.tema2 = tema2;
        this.tema3 = tema3;
        this.tema4 = tema4;

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

    public double getTema1() {
        return tema1;
    }

    public void setTema1(double tema1) {
        this.tema1 = tema1;
    }

    public double getTema2() {
        return tema2;
    }

    public void setTema2(double tema2) {
        this.tema2 = tema2;
    }

    public double getTema3() {
        return tema3;
    }

    public void setTema3(double tema3) {
        this.tema3 = tema3;
    }

    public double getTema4() {
        return tema4;
    }

    public void setTema4(double tema4) {
        this.tema4 = tema4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double calcularMedia() {
        return ((this.tema1 + this.tema2 + this.tema3 + this.tema4 ) /4);
    }

    @Override
    public String toString() {
        return "Alumno: " +  apellido1 + " " +
            apellido2 + ", " + nombre + "\n" +
           "Tema 1: " + tema1 + "\n" +
            "Tema 2: " + tema2 + "\n" +
            "Tema 3: " + tema3 + "\n" +
            "Tema 4: " + tema4
            ;
    }


}
