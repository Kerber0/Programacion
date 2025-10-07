public abstract class TransportePublico {
    String matricula;
    int capacidadPasajeros;
    int velocidadMaxima;



    public TransportePublico(String matricula, int capacidadPasajeros, int velocidadMaxima) {
        this.matricula = matricula;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    abstract double calcularTarifa();


    @Override
    public String toString() {
        return "TransportePublico{" +
                "matricula='" + matricula + '\'' +
                ", capacidadPasajeros=" + capacidadPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                '}';
    }
}
