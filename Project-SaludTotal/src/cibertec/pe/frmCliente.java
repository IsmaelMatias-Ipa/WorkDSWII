package cibertec.pe;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.util.List;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class frmCliente extends JFrame{
    
    public frmCliente() {
        // Configuración de la ventana
        setTitle("Formulario Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Usamos FlowLayout para centrar los componentes añadidos
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 70));

        // Creamos y añadimos el botón
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(e -> enviarAfiliados());
        add(btnEnviar);
    }

    public void enviarAfiliados(){
        Afiliado afiliado1 = new Afiliado(123, 1500.5, true);
        Afiliado afiliado2 = new Afiliado(578, 2000.5, false);
        Afiliado afiliado3 = new Afiliado(662, 1000.5, false);
        Afiliado afiliado4 = new Afiliado(475, 3500.5, false);

        List<Afiliado> afiliados = new ArrayList<>();

        afiliados.add(afiliado1);
        afiliados.add(afiliado2);
        afiliados.add(afiliado3);
        afiliados.add(afiliado4);

        try {
            Socket socket = new Socket("localhost", 5000);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(afiliados);

            socket.close();

            JOptionPane.showMessageDialog(null, "Lista de Afiliados Enviada");

        } catch (Exception e) {
            
        }
    }

    public static void main(String[] args) {
        // Hacemos visible la ventana
        new frmCliente().setVisible(true);
    }
}
