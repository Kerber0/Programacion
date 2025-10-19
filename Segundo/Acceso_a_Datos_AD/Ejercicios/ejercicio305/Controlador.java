package ejercicio305;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{
    
    // TODO CONSTRUCTOR DEL CONTROLADOR CON LA VISTA Y EL MODELO

    private Modelo modelo;
    private Vista vista;

    // CONSTRUCTOR: recibe el modelo y la vista
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        //TODO: USAR e.getActionCommand() PARA SABER QUE SE ESTÁ EJECUTANDO
        //TODO: OBTENER PARÁMETROS DE LA VISTA, LLAMAR A SUMAR Y PINTAR EL VALOR EN LA VISTA

        if ("SUMAR".equals(comando)) {
            try {
                // obtengo los textos desde la vista
                String t1 = vista.getCampo1();
                String t2 = vista.getCampo2();

                // convierto a enteros (puede lanzar NumberFormatException)
                int a = Integer.parseInt(t1.trim());
                int b = Integer.parseInt(t2.trim());

                // llamo al modelo
                int resultado = modelo.suma(a, b);

                // pinto el resultado en la vista
                vista.setResultado(String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                // si el usuario escribió algo que no es número
                vista.setResultado("Error: ingresá números enteros válidos");
            }
        }

    } 
}
