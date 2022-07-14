package com.senac.tecinfo.calculator;

import com.senac.tecinfo.interfaces.ICalculator;
import com.senac.tecinfo.model.Calculator;
import org.junit.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static ICalculator calculator;

    @BeforeClass // executa ao inicia a classe
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @AfterClass // executa ao finalizar a classe
    public static void done() {
        System.out.println("Fim dos testes");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("Essa mensagem vai aparecer antes de cada teste");
    }

    @After
    public void afterEachTest() {
        System.out.println("Essa mensagem vai aparecer depois de cada teste");
    }

    @Test
    @DisplayName("Verifica calculo de soma")
    public void testSum() {
        int result = calculator.sum(3, 4);
        assertEquals(7, result);
        System.out.println("result = " + result);
    }

    @Test
    public void testDivison() {
        int result = 0;

        try {
            result = calculator.divison(2, 3);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        assertTrue(result == 0);
        System.out.println("result = " + result);
    }

    @Ignore
    @Test(expected = Exception.class)
    public void testDivison2() throws Exception {
        int result = calculator.divison(2, 0);
        System.out.println("result = " + result);
    }

    @Disabled("Desativado pois foi corrigido no último commit #123512321")
    @Test
    public void testDivison3() throws Exception {
        int result = calculator.divison(2, 0);
        System.out.println("result = " + result);
        assertThrows(Exception.class, () -> calculator.divison(2, 0));
    }
}