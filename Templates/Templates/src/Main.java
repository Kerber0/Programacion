//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}

    public static void main(String[] args) {
        String usuario = "root";
        String clave = "abc123.";
        String url ="jdbc:mysql://localhost:3306/empleados";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, usuario,clave);
            amosarInformacionBD(conn);
            amosarProxectos(conn);
            inserirProxecto(conn, 11, "Bases de datos", "Lugo", 3);
            amosarProxectos(conn);
            eliminarProxecto(conn, 11);
            amosarProxectos(conn);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    conn