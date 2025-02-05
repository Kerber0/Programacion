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

  public boolean getcasado() {
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

  public double calculoIrpf() {
    double irpf = 2;

    if ((sueldoBruto() / 12) > 0 || (sueldoBruto() / 12) < 12450) {
      irpf = 19;
    } else if ((sueldoBruto() / 12) > 12450 || (sueldoBruto() / 12) < 20199) {
      irpf = 24;
    } else if ((sueldoBruto() / 12) > 20199 || (sueldoBruto() / 12) < 35199) {
      irpf = 30;
    } else if ((sueldoBruto() / 12) > 35199 || (sueldoBruto() / 12) < 59999) {
      irpf = 37;
    } else {
      irpf = 45;
    }
  }
   if(casado = true){

    }


}
