package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FrmRegistro extends JFrame {

    // Campos de texto para ingresar los datos
    private JTextField txtNombre, txtEdad, txtPeso, txtEstatura;
    // Botones de la interfaz
    private JButton btnCalcular, btnVer, btnAcerca, btnLimpiar;

    public FrmRegistro() {
        setTitle("Registro IMC");
        setSize(320, 410);
        setLayout(null);
        // Cierra la aplicación al cerrar esta ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Título de bienvenida en la parte superior
        JLabel lblTitulo = new JLabel("<html><center>BIENVENIDO A LA<br>CALCULADORA DE IMC</center></html>");
        lblTitulo.setBounds(20, 10, 270, 45);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo);

        // Campos del formulario
        addLabel("Nombre:", 20, 70);
        txtNombre = addTextField(120, 70);

        addLabel("Edad:", 20, 110);
        txtEdad = addTextField(120, 110);

        addLabel("Peso (kg):", 20, 150);
        txtPeso = addTextField(120, 150);

        addLabel("Estatura (m):", 20, 190);
        txtEstatura = addTextField(120, 190);

        // Botones de acción
        btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(20, 230, 250, 30);
        add(btnCalcular);

        btnVer = new JButton("Ver Resultado");
        btnVer.setBounds(20, 265, 250, 30);
        add(btnVer);

        btnAcerca = new JButton("Acerca de");
        btnAcerca.setBounds(20, 300, 250, 30);
        add(btnAcerca);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(20, 335, 250, 30);
        add(btnLimpiar);
    }

    // Método reutilizable para crear etiquetas
    private void addLabel(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 100, 25);
        add(lbl);
    }

    // Método reutilizable para crear campos de texto
    private JTextField addTextField(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 150, 25);
        add(txt);
        return txt;
    }

    // Método que limpia todos los campos del formulario
    public void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtEstatura.setText("");
    }

    // Getters que obtienen los valores ingresados por el usuario
    public String getNombre() { 
        return txtNombre.getText(); 
    }

    public int getEdad() { 
        return Integer.parseInt(txtEdad.getText()); 
    }

    public double getPeso() { 
        return Double.parseDouble(txtPeso.getText()); 
    }

    public double getEstatura() { 
        return Double.parseDouble(txtEstatura.getText()); 
    }

    // Métodos para asignar los listeners desde el controlador
    public void setCalcularListener(ActionListener l) { 
        btnCalcular.addActionListener(l); 
    }

    public void setVerListener(ActionListener l) { 
        btnVer.addActionListener(l); 
    }

    public void setAcercaListener(ActionListener l) { 
        btnAcerca.addActionListener(l); 
    }

    public void setLimpiarListener(ActionListener l) { 
        btnLimpiar.addActionListener(l); 
    }
}