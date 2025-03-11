package org.example;

public class Main {
    public static void main(String[] args) {
        ValidadorContrasena validador = new ValidadorContrasena();
        System.out.println(validador.validar("Passw0rd!"));
        System.out.println(validador.validar("Pwd1!"));
        System.out.println(validador.validar("password1!"));
        System.out.println(validador.validar("PASSWORD1!"));
        System.out.println(validador.validar("Password!"));
        System.out.println(validador.validar("Password1"));
    }
}
