package vista;

import javax.swing.*;

public class FrmAcercaDe extends JFrame {

    public FrmAcercaDe() {

        setTitle("Acerca de");
        setSize(250, 180);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("ACERCA DE");
        titulo.setBounds(80, 10, 150, 30);
        add(titulo);

        JLabel lbl = new JLabel("<html>Desarrollador: Jefry Leandro<br>ADSO<br>2026<br>MVC IMC</html>");
        lbl.setBounds(30, 50, 200, 100);
        add(lbl);
    }
}