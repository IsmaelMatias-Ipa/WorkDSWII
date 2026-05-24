package cibertec.pe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        try {
            Socket sc = new Socket("127.0.0.1", 5000);

            DataInputStream in = new DataInputStream(sc.getInputStream());

            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println(mensaje);

            String name = sn.next();
            out.writeUTF(name);

            ClienteHilo hilo = new ClienteHilo(in, out);
            hilo.start();
            hilo.join();


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
