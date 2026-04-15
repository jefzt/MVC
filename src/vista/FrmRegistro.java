package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FrmRegistro extends JFrame {

    private JTextField txtNombre, txtEdad, txtPeso, txtEstatura;
    private JButton btnCalcular, btnVer, btnAcerca, btnLimpiar;

    public FrmRegistro() {

        setTitle("Registro IMC");
        setSize(300, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("CALCULADORA IMC");
        titulo.setBounds(60, 10, 200, 30);
        add(titulo);

        add(new JLabel("Nombre")).setBounds(20, 60, 80, 25);
        txtNombre = new JTextField(); txtNombre.setBounds(100, 60, 150, 25); add(txtNombre);

        add(new JLabel("Edad")).setBounds(20, 100, 80, 25);
        txtEdad = new JTextField(); txtEdad.setBounds(100, 100, 150, 25); add(txtEdad);

        add(new JLabel("Peso")).setBounds(20, 140, 80, 25);
        txtPeso = new JTextField(); txtPeso.setBounds(100, 140, 150, 25); add(txtPeso);

        add(new JLabel("Estatura")).setBounds(20, 180, 80, 25);
        txtEstatura = new JTextField(); txtEstatura.setBounds(100, 180, 150, 25); add(txtEstatura);

        btnCalcular = new JButton("Calcular"); btnCalcular.setBounds(20, 230, 230, 30); add(btnCalcular);
        btnVer = new JButton("Ver"); btnVer.setBounds(20, 270, 230, 30); add(btnVer);
        btnAcerca = new JButton("Acerca"); btnAcerca.setBounds(20, 310, 230, 30); add(btnAcerca);
        btnLimpiar = new JButton("Limpiar"); btnLimpiar.setBounds(20, 350, 230, 30); add(btnLimpiar);
    }

    public String getNombre() { return txtNombre.getText(); }
    public int getEdad() { return Integer.parseInt(txtEdad.getText()); }
    public double getPeso() { return Double.parseDouble(txtPeso.getText()); }
    public double getEstatura() { return Double.parseDouble(txtEstatura.getText().replace(",", ".")); }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtEstatura.setText("");
    }

    public String pedirNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre a buscar:");
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

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