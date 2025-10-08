public class Piscina {

    private double largoPisc;
    private double anchoPisc;
    private double largoParcela;
    private double anchoParcela;
    private int aforo;
    private final int metrosReservados = 2;

    public Piscina(double largoPisc, double anchoPisc, double largoParcela, double anchoParcela) {
        this.largoPisc = largoPisc;
        this.anchoPisc = anchoPisc;
        this.largoParcela = largoParcela;
        this.anchoParcela = anchoParcela;
    }

    public double getLargoPisc() {
        return largoPisc;
    }

    public void setLargoPisc(double largoPisc) {
        this.largoPisc = largoPisc;
    }

    public double getAnchoPisc() {
        return anchoPisc;
    }

    public void setAnchoPisc(double anchoPisc) {
        this.anchoPisc = anchoPisc;
    }

    public double getLargoParcela() {
        return largoParcela;
    }

    public void setLargoParcela(double largoParcela) {
        this.largoParcela = largoParcela;
    }

    public double getAnchoParcela() {
        return anchoParcela;
    }

    public void setAnchoParcela(double anchoParcela) {
        this.anchoParcela = anchoParcela;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo() {
        double superficiePiscina = (anchoPisc * largoPisc) / metrosReservados;
        double superficieParcela = (anchoParcela * largoParcela) / metrosReservados;

        double menor = Math.min(superficiePiscina, superficieParcela);
        aforo = (int) menor;
    }

}
