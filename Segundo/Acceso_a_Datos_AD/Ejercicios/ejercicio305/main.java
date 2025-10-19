package ejercicio305;

public class main {
    
    public static void main(String[] args) {
        
        // TODO: INSTANCIAR EL MODELO, LA VISTA Y EL CONTROLADOR
        // TODO: ARRANCHAR LA VISTA Y ESTABLECERLE EL CONTROLADOR
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);

        // arrancamos la ventana
        vista.arranca();

        // le decimos a la vista quién es su controlador
        vista.setControlador(controlador);


    }
}
