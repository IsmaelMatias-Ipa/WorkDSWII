package cibertec.pe;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class frmServido extends JFrame{
    // Definimos el JTextArea como atributo de la clase
    private JTextArea txtResultado = new JTextArea();
    private JScrollPane scrollPanel;
    

    public frmServido() {
        // Configuración de la ventana del servidor
        setTitle("Servidor - Registro de Afiliados");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Inicializamos el JTextArea
        //txtResultado = new JTextArea();
        txtResultado.setEditable(false); // Recomendado para servidores (solo lectura)

        // Inicializamos el JScrollPane y le metemos el JTextArea adentro
        scrollPanel = new JScrollPane(txtResultado);

        iniciarServidor();

        // Usamos BorderLayout para que el scrollPanel ocupe todo el centro
        setLayout(new BorderLayout());
        add(scrollPanel, BorderLayout.CENTER);
    }

    void iniciarServidor(){
        new Thread(() -> {

            try {
                ServerSocket server = new ServerSocket(5000);
                txtResultado.append("Servidor Iniciado" + "\n");
                Socket socket = server.accept();
                txtResultado.append("Cliente conectado" + "\n\n");

                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                List<Afiliado> listAfiliados = (List<Afiliado>) entrada.readObject();

                porcesarAfiliados(listAfiliados);

                socket.close();
                server.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }).start();
    }

    void porcesarAfiliados(List<Afiliado> afiliados){
        double sumatotal = 0;
        int cantidadMorosos = 0;
        for(Afiliado c : afiliados){
            String estado;


            if (c.isCondicion() == 1){
                estado = "Puntual";

            }else {
                estado = "Moroso";
                cantidadMorosos ++;
            }
            sumatotal = sumatotal + c.getMonto();

            txtResultado.append("Codigo: "      +   c.getCodigo()   + "\n");
            txtResultado.append("Monto: "       +   c.getMonto()    + "\n");
            txtResultado.append("Condicion: "   +   estado          + "\n\n\n");

        }

        double promedioMonto = 0;
        if (!afiliados.isEmpty()) {
        promedioMonto = sumatotal / afiliados.size();
        }

        txtResultado.append("------------------------------------------------" + "\n");
        txtResultado.append("La suma total del prestamo: " + sumatotal + "\n");
        txtResultado.append("Cantidad total de Morosos: " + cantidadMorosos + "\n");
        txtResultado.append("Promedio del Montototal: " + promedioMonto + "\n");
        txtResultado.append("------------------------------------------------");
    }

    public static void main(String[] args) {
        // Ejecutar la ventana del servidor
        new frmServido().setVisible(true);
    }

    
}
