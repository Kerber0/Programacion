/*
Desarrolla un programa en Java que dada la siguiente entrada:

Nombre_Alumno# LMSXI # SI # BD # PRO # CD # FOL;Alumno 1  # 4     #    # 5  #  2  # 8  # 9;Alumno 2     # 5     # 3  # 6  #  7  # 10 # 6;Alumno 3     # 7     # 4  # 9  #  9  # 9  # 8;


Permita obtener:

Calcular la nota media de cada alumno en el ciclo, teniendo en cuenta solo aquellos módulos que han cursado.

Calcular la nota media de cada módulo, teniendo en cuenta solo aquellos alumnos que cursaron el módulo.

Calcular el número de alumnos que aprobaron todos los módulos que han cursado.

Calcular el número de alumnos que no han cursado algún módulo.

Indicar cuál es el módulo que tiene la nota media más alta.

Indicar cuál es el alumno que mejor nota ha sacado por módulo.
 */



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