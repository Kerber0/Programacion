/*
Aplicación de libros
Dado la base de datos de libros, la cual tiene el siguiente diagrama ER:



Se pide, desarrollar una aplicación Java que permita realizar consultas y recuperar los datos utilizando los siguientes procedimientos almacenados:

pa_libros_limite_stock(): devuelve la lista de libros en stock
get_libro_by_id(IN id int): devuelve la información de un libro por le código
contar_libros_precio(IN precio decimal(5,2), OUT total int): permite obtener el número de libros que cuestan más que una determinada cantidad
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn;

        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pb","postgres","190418");
            System.out.print("Funciono");
        }catch (SQLException e){
            System.out.print(e.getMessage());
            System.out.print("no funciono");
        }
    }
}




