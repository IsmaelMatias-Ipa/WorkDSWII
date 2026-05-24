package cibertec.pe;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServidorHilo extends Thread{
    

    private DataInputStream in;
    private DataOutputStream out;
    private String nameClient; 

    public ServidorHilo(DataInputStream in, DataOutputStream out, String nameCliente){
        this.in = in;
        this.out = out;
        this.nameClient = nameCliente;
    }

    @Override
    public void run() {}
}
