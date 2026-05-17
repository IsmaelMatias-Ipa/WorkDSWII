package cibertec.pe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while (true) {
                //aceptamos cualquier conexion entrante
                sc = servidor.accept();

                //se imprime el mensaje
                System.out.println("Cliente conectado");

                //leer flujo de entrada
                in = new DataInputStream(sc.getInputStream());

                //leer flujo de salida
                out = new DataOutputStream(sc.getOutputStream());

                //se realiza lectura del mensaje
                String mensaje = in.readUTF();

                //se imprime el mensaje
                System.out.println(mensaje);

                //se envia el mensaje
                out.writeUTF("Hola mundo desde el servidor");

                //cerrar la conexion 
                sc.close();

                //se imprime mensaje
                System.out.println("cliente desconectado");
                
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
