import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.example.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
  static Calculadora calculadora;

  @BeforeEach
  void setup(){
   calculadora = new Calculadora();
  }

  @Test
    public void testSumar(){
    Calculadora calculadora = new Calculadora();
    assertEquals(8, calculadora.sumar(5, 3));
  }
  @Test
  public void testResta(){
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.restar(10, 5));
  }
  @Test
  public void testMultiplicar(){
    Calculadora calculadora = new Calculadora();
    assertEquals(50, calculadora.multiplicar(10, 5));
  }

  @Test
  public void testdividir(){
    Calculadora calculadora = new Calculadora();
    assertEquals(2, calculadora.dividir(10, 5));
    assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(10, 0));
  }

  @Test
  public void testRaizCuadrada(){
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.raizCuadrada(25));
    assertThrows(IllegalArgumentException.class, () -> calculadora.raizCuadrada(-5));
  }

}
