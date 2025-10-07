public class Empleado {

  private String nif;
  private String nombre;
  private double sueldoBase;
  private double horasExtras;
  private double irpf;
  private boolean casado;
  private int cantHijos;
  private static double importeHoraExtra;

  public Empleado() {
  }

  public Empleado(String nif) {
    this.nif = nif;
  }


  public String getNif() {
    return nif;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getSueldoBase() {
    return sueldoBase;
  }

  public void setSueldoBase(double sueldo) {
    this.sueldoBase = sueldo;
  }

  public double getHorasExtras() {
    return horasExtras;
  }

  public void setHorasExtras(double horas) {
    if (horas < 0) {
      this.horasExtras = 0;
    } else {
      this.horasExtras = horas;
    }
  }

  public double getIrpf() {
    return irpf;
  }

  public void setIrpf(double irpf) {
    this.irpf = irpf;
  }

  public boolean getCasado() {
    return casado;
  }

  public void setCasado(boolean casado) {
    this.casado = casado;
  }

  public int getCantHijos() {
    return cantHijos;
  }

  public void setCantHijos(int hijos) {
    this.cantHijos = hijos;
  }

  public double getImporteHoraExtra() {
    return importeHoraExtra;
  }

  public static void setImporteHorasExtra(double valorHoras) {
    importeHoraExtra = valorHoras;
  }

  public double complementoHorasExtras() {

    return this.horasExtras * Empleado.importeHoraExtra;
  }

  public double sueldoBruto() {
    return this.sueldoBase + complementoHorasExtras();
  }

  private  int franjaSalarial(double sueldoBruto){
    double sueldoAnual = sueldoBruto * 12;
    if (sueldoAnual >= 0 && sueldoAnual <= 12450) return 0;
    if (sueldoAnual > 12450 && sueldoAnual < 20199) return 1;
    else if (sueldoAnual > 20199 && sueldoAnual < 35199) return 2;
    else if (sueldoAnual > 35199 && sueldoAnual < 59999) return 3;
    else return 4;
  }

  public double calculoIrpf() {
    double irpf = switch (franjaSalarial(sueldoBruto())) {
      case 0 -> 19;
      case 1 -> 24;
      case 2 -> 30;
      case 3 -> 37;
      case 4 -> 45;
      default -> 17;
    };
    if (casado){irpf -=2;}
    if (cantHijos >= 1){ irpf -= cantHijos;}
    return irpf;
    }

    public double calcularSueldo(){
    return sueldoBruto() * (1 - (calculoIrpf() / 100));
    }

    public String toString(){
        return "NIF: " + nif + "\n" +
                "Empleado: " + nombre + "\n" +
                "Sueldo Base: $" + sueldoBase + "\n" +
                "Tipo IRPF: " + calculoIrpf() + "%\n" +
                "Casado: " + (casado ? "Sí" : "No") + "\n" +
                "Hijos: " + (cantHijos > 0 ? cantHijos : "Ninguno") + "\n";
    }

}
