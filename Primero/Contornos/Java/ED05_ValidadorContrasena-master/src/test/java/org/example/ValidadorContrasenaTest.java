package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorContrasenaTest {
ValidadorContrasena validador ;

    @BeforeEach
    void setup(){
        validador = new ValidadorContrasena();
    }



    @Test
    void testValidadorContrasenia(){
        assertFalse(validador.validar(null));
    }
    @Test
    void testValidadorContraseniaCorta(){
        assertFalse(validador.validar("abcd"));
    }

    @Test
    void testValidadorContraseniaMin(){
        assertFalse(validador.validar("contraseña"));
    }

    @Test
    void testValidadorContraseniaMinusYMayus(){
        assertFalse(validador.validar("Contraseña"));
    }

    @Test
    void testValidadorContraseniaMinusMayusYNum(){
        assertFalse(validador.validar("Contraseña1"));
    }
    @Test
    void testValidadorContraseniaMayusYNum(){
        assertFalse(validador.validar("CONTRASEÑA1!"));
    }

    @Test
    void testValidadorContraseniaValida(){
        assertTrue(validador.validar("Contraseña1!"));
    }

}