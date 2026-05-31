package cibertec.pe.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ICalculator {
    
    @WebMethod
    int add(int num1, int num2);

    @WebMethod
    int rest(int num1, int num2);

    @WebMethod
    int multi(int num1, int num2);
    
    @WebMethod
    int divi(int num1, int num2);
}
