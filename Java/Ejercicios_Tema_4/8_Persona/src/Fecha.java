import java.time.Year;
import org.w3c.dom.ls.LSOutput;


public class Fecha {

  private int dia;
  private int mes;
  private int anio;

  public Fecha() {

  }

  public Fecha(int dia, int mes, int anio) {
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  }

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAnio() {
    return anio;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }


  public boolean fechaCorrecta(int dia, int mes, int anio) {
    if (anio < 1) {
      return false;
    }

    if (mes < 1 || mes > 12) {
      return false;
    }

    int[] diasPorMes = {0, 31, esBisiesto(anio) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    return dia >= 1 && dia <= diasPorMes[mes];
  }

  private boolean esBisiesto(int year) {
    return Year.isLeap(year);
  }

  //  Calculo anio bisiesto
  //  private boolean esBisiesto(int anio) {return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);}


  public String fechaSiguiente(int dia, int mes, int anio, int adelante) {
    if (adelante < 0) {
      return "Error: el número de días debe ser positivo.";
    }

    int[] diasPorMes = {0, 31, esBisiesto(anio) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    while (adelante > 0) {
      if (dia + adelante > diasPorMes[mes]) {
        adelante -= (diasPorMes[mes] - dia + 1);
        dia = 1;
        mes++;
        if (mes > 12) {
          mes = 1;
          anio++;
          diasPorMes[2] = esBisiesto(anio) ? 29 : 28;
        }
      } else {
        dia += adelante;
        adelante = 0;
      }
    }
    if (!fechaCorrecta(dia, mes, anio)) {
      return "Error: La fecha calculada no es valida";
    }
    return anio + "-" + (mes < 10 ? "0" + mes : mes) + "-" + (dia < 10 ? "0" + dia : dia);
  }

  public boolean esMayorQue(int diaComparar, int mesComparar, int anioComparar) {
    return false;
  }


  public boolean esMayorQue(Fecha fechaNacimiento) {
  }
}