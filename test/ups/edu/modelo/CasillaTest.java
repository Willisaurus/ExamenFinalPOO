package ups.edu.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas unitarias para Casilla - Happy Path")
class CasillaTest {

    private Casilla casilla;

    @BeforeEach
    void setUp() {
        casilla = new Casilla();
    }

    @Test
    @DisplayName("Casilla se inicializa correctamente")
    void testInicializacionCasilla() {
        assertFalse(casilla.esMina());
        assertFalse(casilla.estaDescubierta());
        assertFalse(casilla.estaMarcada());
        assertEquals(0, casilla.getMinasVecinas());
    }

    @Test
    @DisplayName("Colocar mina funciona correctamente")
    void testPonerMina() {
        casilla.ponerMina();
        assertTrue(casilla.esMina());
    }

    @Test
    @DisplayName("Descubrir casilla funciona correctamente")
    void testDescubrir() {
        casilla.descubrir();
        assertTrue(casilla.estaDescubierta());
    }

    @Test
    @DisplayName("Alternar marca funciona correctamente")
    void testAlternarMarcada() {
        assertFalse(casilla.estaMarcada());
        casilla.alternarMarcada();
        assertTrue(casilla.estaMarcada());
        casilla.alternarMarcada();
        assertFalse(casilla.estaMarcada());
    }

    @Test
    @DisplayName("Incrementar minas vecinas funciona correctamente")
    void testIncrementarMinasVecinas() {
        assertEquals(0, casilla.getMinasVecinas());
        casilla.incrementarMinasVecinas();
        assertEquals(1, casilla.getMinasVecinas());
        casilla.incrementarMinasVecinas();
        assertEquals(2, casilla.getMinasVecinas());
    }

    @Test
    @DisplayName("Una casilla puede tener mina y ser descubierta")
    void testCasillaConMinaDescubierta() {
        casilla.ponerMina();
        casilla.descubrir();
        assertTrue(casilla.esMina());
        assertTrue(casilla.estaDescubierta());
    }

    @Test
    @DisplayName("Una casilla puede tener mina y ser marcada")
    void testCasillaConMinaMarcada() {
        casilla.ponerMina();
        casilla.alternarMarcada();
        assertTrue(casilla.esMina());
        assertTrue(casilla.estaMarcada());
    }

    @Test
    @DisplayName("Incrementar múltiples veces las minas vecinas")
    void testIncrementarVariasVecesMinasVecinas() {
        for (int i = 1; i <= 8; i++) {
            casilla.incrementarMinasVecinas();
            assertEquals(i, casilla.getMinasVecinas());
        }
    }
}

