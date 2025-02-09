public class Persona {

    private String nombre;
    private String direccion;
    private int cp;
    private String ciudad;
    private String fechaNacimiento;

    public Persona(String nombre, String direccion, int cp, String ciudad, String fechaNacimiento){
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNombre(){ return nombre;}
    public String getDireccion(){ return direccion;}
    public int getCp(){return cp;}
    public String getCiudad(){return ciudad;}
    public String getFechaNacimiento(){return fechaNacimiento;}

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setCp(int cp){
        this.cp = cp;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }















}
