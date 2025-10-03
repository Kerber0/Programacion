import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

class LoteJuegosTest {
    @Test
    void testErrorTamanoArrays() {
        LoteJuegos lote = new LoteJuegos();
        assertEquals(-1, lote.registrarLoteJuegos(new String[]{"A", "B"}, new int[]{10}));
    }

    @Test
    void testCantidadNegativa() {
        LoteJuegos lote = new LoteJuegos();
        assertEquals(-2, lote.registrarLoteJuegos(new String[]{"A", "B"}, new int[]{10, -5}));
    }

    @Test
    void testExcedeStockMaximo() {
        LoteJuegos lote = new LoteJuegos();
        assertEquals(-3, lote.registrarLoteJuegos(new String[]{"A", "B"}, new int[]{30, 40}, 50, new HashMap<>()));
    }

    @Test
    void testCodigosExisten() {
        LoteJuegos lote = new LoteJuegos();
        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("A", 5);
        stock.put("B", 15);
        assertEquals(30, lote.registrarLoteJuegos(new String[]{"A", "B"}, new int[]{10, 20}, 100, stock));
    }

    @Test
    void testAlgunosCodigosNuevos() {
        LoteJuegos lote = new LoteJuegos();
        HashMap<String, Integer> stock = new HashMap<>();
        stock.put("A", 5);
        assertEquals(60, lote.registrarLoteJuegos(new String[]{"A", "B", "C"}, new int[]{10, 20, 30}, 100, stock));
    }
}
