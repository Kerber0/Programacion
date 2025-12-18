package org.example.menu;//

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Inputs {
    private static final Scanner sc = new Scanner(System.in);

    public static String  input(String text) {
        boolean textcorrect = false;

        String resultado;
        do {
            System.out.println(text);
            resultado = sc.nextLine();
            if (resultado.isEmpty()) {
                System.out.println("Se debe ingresar algo.");
            } else {
                textcorrect = true;
            }
        } while(!textcorrect);

        return resultado;
    }

    public static int inputInt(String text) {
        int num = -1;
        boolean valido = false;

        while(!valido) {
            try {
                System.out.println(text);
                num = Integer.parseInt(sc.nextLine());
                valido = true;
            } catch (NumberFormatException var5) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }

        return num;
    }

    public static LocalDate inputFecha(String text) {
        boolean valido = false;
        LocalDate fechaNacimiento = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while(!valido) {
            System.out.println(text + " (formato: dd/MM/yyyy)");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Debe ingresar una fecha.");
            } else {
                try {
                    fechaNacimiento = LocalDate.parse(input, formato);
                    if (fechaNacimiento.isAfter(LocalDate.now())) {
                        System.out.println("Error: La fecha no puede ser futura.");
                    } else if (fechaNacimiento.isBefore(LocalDate.now().minusYears(120L))) {
                        System.out.println("Error: La fecha ingresada es demasiado antigua.");
                    } else {
                        valido = true;
                    }
                } catch (DateTimeParseException var7) {
                    System.out.println("Error: Formato inválido. Use dd/MM/yyyy (ej: 25/12/2000).");
                }
            }
        }

        return fechaNacimiento;
    }

    public static String inputOpcional(String text) {
        System.out.println(text);
        return sc.nextLine().trim();
    }

}
