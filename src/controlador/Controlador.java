package controlador;

import modelo.Persona;
import vista.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Controlador {

    // Referencias a las capas del sistema
    private Persona persona;
    private FrmRegistro vista;
    private FrmConsulta consulta;
    private FrmAcercaDe acerca;

    // Constructor que recibe las tres vistas y asigna los listeners
    public Controlador(FrmRegistro v, FrmConsulta c, FrmAcercaDe a) {
        this.vista = v;
        this.consulta = c;
        this.acerca = a;
        // Se crea la instancia del modelo
        this.persona = new Persona();

        // Se asigna cada botón a su acción correspondiente
        vista.setCalcularListener(new Calcular());
        vista.setVerListener(new Ver());
        vista.setAcercaListener(new Acerca());
        vista.setLimpiarListener(new Limpiar());
    }

    // Muestra la ventana principal al iniciar la aplicación
    public void iniciar() {
        vista.setVisible(true);
    }

    // Acción del botón "Calcular IMC"
    class Calcular implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                // Valida que el nombre no esté vacío
                if (vista.getNombre().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nombre vacío");
                    return;
                }

                // Obtiene los datos de la vista y los envía al modelo
                persona.setNombre(vista.getNombre());
                persona.setEdad(vista.getEdad());
                persona.setPeso(vista.getPeso());
                persona.setEstatura(vista.getEstatura());

                // Valida que peso y estatura sean valores positivos
                if (persona.getPeso() <= 0 || persona.getEstatura() <= 0) {
                    JOptionPane.showMessageDialog(null, "Datos inválidos");
                    return;
                }

                // Llama al método del modelo para calcular el IMC
                persona.calcularIMC();
                JOptionPane.showMessageDialog(null, "IMC calculado: " + String.format("%.2f", persona.getImc()));

            } catch (Exception ex) {
                // Captura errores si el usuario ingresa texto en lugar de números
                JOptionPane.showMessageDialog(null, "Error en datos");
            }
        }
    }

    // Acción del botón "Ver Resultado"
    class Ver implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // Valida que ya se haya calculado el IMC antes de mostrar resultados
            if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Primero calcule el IMC");
                return;
            }

            // Asigna un color según la clasificación del IMC
            String color;
            String clasificacion = persona.clasificacion();

            if (clasificacion.equals("Normal")) {
                color = "green";
            } else if (clasificacion.equals("Sobrepeso")) {
                color = "orange";
            } else if (clasificacion.equals("Obesidad")) {
                color = "red";
            } else {
                // Bajo peso
                color = "blue";
            }

            // Construye el texto con los datos del modelo para enviarlo a la vista
            String datos = "Nombre: " + persona.getNombre() + "<br>"
                    + "Edad: " + persona.getEdad() + "<br>"
                    + "Peso: " + String.format("%.1f", persona.getPeso()) + " kg<br>"
                    + "Estatura: " + String.format("%.2f", persona.getEstatura()) + " m<br>"
                    + "IMC: " + String.format("%.2f", persona.getImc()) + "<br>"
                    + "Clasificación: <font color='" + color + "'>" + clasificacion + "</font>";

            // Envía los datos a la vista de consulta y la muestra
            consulta.mostrarDatos(datos);
            consulta.setVisible(true);
        }
    }

    // Acción del botón "Acerca de"
    class Acerca implements ActionListener {cd modelo
        public void actionPerformed(ActionEvent e) {
            // Muestra la ventana de información del desarrollador
            acerca.setVisible(true);
        }
    }

    // Acción del botón "Limpiar"
    class Limpiar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Llama al método de la vista que limpia todos los campos
            vista.limpiarCampos();
        }
    }
}