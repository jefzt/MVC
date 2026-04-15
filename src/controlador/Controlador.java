package controlador;

import modelo.Proceso;
import vista.*;

public class Controlador {

    private FrmRegistro vistaRegistro;
    private FrmConsulta vistaConsulta;
    private FrmAcercaDe vistaAcerca;
    private Proceso proceso;

    public void setVistaRegistro(FrmRegistro vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }

    public void setVistaConsulta(FrmConsulta vistaConsulta) {
        this.vistaConsulta = vistaConsulta;
    }

    public void setVistaAcerca(FrmAcercaDe vistaAcerca) {
        this.vistaAcerca = vistaAcerca;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    // Conecta cada boton con su accion
    public void iniciarEventos() {

        vistaRegistro.setCalcularListener(e -> {
            String resultado = calcularIMC(
                vistaRegistro.getNombre(),
                String.valueOf(vistaRegistro.getEdad()),
                String.valueOf(vistaRegistro.getPeso()),
                String.valueOf(vistaRegistro.getEstatura())
            );
            vistaRegistro.mostrarMensaje(resultado);
        });

        vistaRegistro.setVerListener(e -> {
            String nombre = vistaRegistro.pedirNombre();
            String datos = buscarPersona(nombre);
            enviarDatosConsulta(datos);
            mostrarVistaConsulta();
        });

        vistaRegistro.setAcercaListener(e -> mostrarVistaAcerca());

        vistaRegistro.setLimpiarListener(e -> limpiarFormulario());
    }

    public void mostrarVistaRegistro() {
        vistaRegistro.setVisible(true);
    }

    public void mostrarVistaConsulta() {
        vistaConsulta.setVisible(true);
    }

    public void mostrarVistaAcerca() {
        vistaAcerca.setVisible(true);
    }

    public String calcularIMC(String nombre, String edad, String peso, String estatura) {
        return proceso.calcularIMC(nombre, edad, peso, estatura);
    }

    public String buscarPersona(String nombre) {
        return proceso.buscarPorNombre(nombre);
    }

    public void limpiarFormulario() {
        vistaRegistro.limpiarCampos();
    }

    public void enviarDatosConsulta(String datos) {
        vistaConsulta.mostrarDatos(datos);
    }
}