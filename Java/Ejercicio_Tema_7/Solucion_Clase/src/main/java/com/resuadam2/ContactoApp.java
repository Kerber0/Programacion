package main.java.com.resuadam2;




import main.java.com.resuadam2.cli.ContactoCLI;

import java.sql.SQLException;

public class ContactoApp {
    public static void main(String[] args) {
        ContactoCLI cli = new ContactoCLI();
        try {
            cli.showMenu();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cli.close();
    }
}