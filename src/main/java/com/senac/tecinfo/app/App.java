package com.senac.tecinfo.app;

import com.senac.tecinfo.interfaces.ICalculator;
import com.senac.tecinfo.model.Calculator;

public class App {
    public static void main(String[] args) throws Exception {
        ICalculator calculator = new Calculator();

        System.out.println("Result(sum): " + calculator.sum(1, 3));
        System.out.println("Result(divison): " + calculator.divison(2, 3));
        System.out.println("Result(subtraction): " + calculator.subtraction(1, 3));
        System.out.println("Result(multiplication): " + calculator.multiplication(3, 3));
    }
}