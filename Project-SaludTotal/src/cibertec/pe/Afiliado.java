package cibertec.pe;

import java.io.Serializable;

public class Afiliado implements Serializable{
    
    private int codigo;
    private double monto;
    private int condicion;
    private String Name;
    private String LastName;
    private String email;
    
    public Afiliado() {
    }

    public Afiliado(int codigo, double monto, int condicion, String Name, String LastName, String email) {
        this.codigo = codigo;
        this.monto = monto;
        this.condicion = condicion;
        this.Name = Name;
        this.LastName = LastName;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int isCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
