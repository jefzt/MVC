package vista;

import javax.swing.*;
import java.awt.*;

public class FrmConsulta extends JFrame {

    // Etiqueta donde se muestran los datos del resultado
    private JLabel lblDatos;

    public FrmConsulta() {
        setTitle("Consulta IMC");
        setSize(350, 280);
        setLayout(null);

        // Título de la ventana
        JLabel lblTitulo = new JLabel("RESULTADOS IMC");
        lblTitulo.setBounds(20, 10, 300, 30);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo);

        // Etiqueta que recibe y muestra los datos enviados por el controlador
        lblDatos = new JLabel();
        lblDatos.setBounds(20, 50, 300, 180);
        add(lblDatos);
    }

    // Método que recibe el texto con los datos y lo muestra en la etiqueta
    public void mostrarDatos(String texto) {
        lblDatos.setText("<html>" + texto + "</html>");
    }
}