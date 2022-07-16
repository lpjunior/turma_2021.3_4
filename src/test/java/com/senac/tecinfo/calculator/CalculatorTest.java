package com.senac.tecinfo.calculator;

import com.senac.tecinfo.interfaces.ICalculator;
import com.senac.tecinfo.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private static ICalculator calculator;

    @BeforeAll // executa ao inicia a classe
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @AfterAll // executa ao finalizar a classe
    public static void done() {
        System.out.println("Fim dos testes");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Essa mensagem vai aparecer antes de cada teste");
    }

    @AfterEach
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

    @Disabled
    @Test()
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