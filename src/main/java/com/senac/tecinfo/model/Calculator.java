package com.senac.tecinfo.model;

import com.senac.tecinfo.interfaces.ICalculator;

public class Calculator implements ICalculator {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }

    @Override
    public int divison(int a, int b) throws Exception {
        if(b == 0)
            throw new Exception("Divider can't be zero");
        return a / b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }
}
