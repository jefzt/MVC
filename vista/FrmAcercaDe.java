package vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class FrmAcercaDe extends JFrame {

    public FrmAcercaDe() {
        setTitle("Acerca de");
        setSize(320, 230);
        setLayout(null);

        // Título de la ventana
        JLabel lblTitulo = new JLabel("INFORMACIÓN DEL DESARROLLADOR");
        lblTitulo.setBounds(10, 10, 290, 30);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitulo);

        // Información del desarrollador con fecha tomada automáticamente del sistema
        JLabel lbl = new JLabel("<html>"
                + "Desarrollador: JEFRY LEANDRO<br>"
                + "Programa: ADSO<br>"
                + "Fecha: " + LocalDate.now() + "<br>"
                + "App para calcular IMC usando MVC"
                + "</html>");
        lbl.setBounds(20, 55, 270, 120);
        add(lbl);
    }
}