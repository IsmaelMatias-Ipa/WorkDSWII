package cibertec.pe.service;

import jakarta.xml.ws.Endpoint;

public class CalculatorPublish {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1515/ws/calculator", new CalculatorImplement());
    }
}
