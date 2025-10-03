public class LocalComercial extends Inmueble {
    private String zona;
    private boolean terraza;


    public LocalComercial(int id, String ubicacion, double precio, double superficie, String zona, boolean terraza) {
        super(id, ubicacion, precio, superficie);
        this.zona = zona;
        this.terraza = terraza;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isTerraza() {
        return terraza;
    }

    public void setTerraza(boolean terraza) {
        this.terraza = terraza;
    }

}
