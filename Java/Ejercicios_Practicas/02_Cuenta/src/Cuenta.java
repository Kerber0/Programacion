public class Cuenta {
    private String nombreCliente;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;

    public Cuenta(){
        this.nombreCliente = "";
        this.numeroCuenta = "";
    };

    public Cuenta(String nombreCliente, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;   // orden de atributos en el construtctor
        this.saldo = saldo;
    }

    public Cuenta(Cuenta otraCuenta) {
        this.nombreCliente = otraCuenta.nombreCliente;
        this.numeroCuenta = otraCuenta.numeroCuenta;
        this.tipoInteres = otraCuenta.tipoInteres;
        this.saldo = otraCuenta.saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean ingreso(double valorAingresar){
        if (valorAingresar <= 0){
            System.out.println("Error el importe debe ser positivo y mayor que zero.");
            return false;
        } else {
            this.saldo += valorAingresar;
            return true;
        }
    }
    public boolean reintegro(double valorAreintegrar) {
        if ((this.saldo - valorAreintegrar) < 0) {
            System.out.println("Error! Saldo insuficiente.");
            return false;
        } else {
            this.saldo -= valorAreintegrar;   // consultar si esto es lo mismo que lo que puso el
            return true;
        }
    }
    public boolean transferencia(Cuenta cuentaDestino, double cantidad){
        if( cantidad <= 0  || cantidad > this.saldo) return false;
        else {
            this.reintegro(cantidad);
            cuentaDestino.ingreso(cantidad);
            return true;
        }
    }
}


