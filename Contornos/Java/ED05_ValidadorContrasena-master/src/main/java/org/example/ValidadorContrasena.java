package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ValidadorContrasena {

    public boolean validar(String contrasena) {
        // Verificar longitud mínima
        if (contrasena == null || contrasena.length() < 8) {
            return false;
        }

        // Verificar al menos una letra mayúscula
        boolean tieneMayuscula = false;
        // Verificar al menos un dígito
        boolean tieneDigito = false;
        // Verificar al menos un carácter especial
        boolean tieneEspecial = false;
        // Verificar al menos una letra minúscula
        boolean tieneMinuscula = false;

        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneDigito = true;
            } else if (!Character.isLetterOrDigit(c)) {
                tieneEspecial = true;
            } else {
                tieneMinuscula = true;
            }

            if (tieneMayuscula && tieneDigito && tieneEspecial && tieneMinuscula) {
                return true;
            }
        }

        // Si llega a este punto, la contraseña no cumple con los requisitos
        return false;
    }
}