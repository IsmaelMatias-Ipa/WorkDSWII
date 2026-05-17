package cibertec.pe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, PUERTO);

            //leer flujo de entrada
            in = new DataInputStream(sc.getInputStream());

            //leer flujo de salida
            out = new DataOutputStream(sc.getOutputStream());

            //se envia mensaje al servidor
            out.writeUTF("Hola Mundo desde cliente");

            //se recibe mensaje del servidor
            String menssaje = in.readUTF();

            //visualizar el mensaje
            System.out.println(menssaje);

            //cerrar las sesiones
            sc.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
