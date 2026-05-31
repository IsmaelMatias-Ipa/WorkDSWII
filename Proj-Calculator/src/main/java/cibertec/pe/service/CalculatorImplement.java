package cibertec.pe.service;

import jakarta.jws.WebService;

@WebService
public class CalculatorImplement implements ICalculator{

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int rest(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multi(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divi(int num1, int num2) {
        return num1 / num2;
    }
    
}
