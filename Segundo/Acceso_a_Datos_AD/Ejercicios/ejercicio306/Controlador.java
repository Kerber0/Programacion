package ejercicio306;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controlador implements ActionListener{

    private Modelo modelo;
    private Vista vista;
    String user = "root";
    String clave = "abc123";
    String url = "jdbc:mysql://localhost:3306/";
    String bd = "empleados";

    // TODO: CONSTRUCTOR DEL CONTROLADOR CON LA VISTA Y EL MODELO

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        //TODO: USAR e.getActionCommand() PARA SABER QUE SE ESTÁ EJECUTANDO
        //TODO: OBTENER PARÁMETROS DE LA VISTA, OBTENER INFORMACIÓN USUARIO Y PINTAR EL VALOR EN LA VISTA
        if("CONECTAR".equals(comando)) {
            try {Connection conn = DriverManager.getConnection(url+bd, user, clave);

            }catch (SQLException x) {
                e.setSource(x);
            }
        }

    } 
}
