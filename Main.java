import vista.*;
import controlador.Controlador;

public class Main {

    public static void main(String[] args) {

        // Se crean las tres vistas
        FrmRegistro v = new FrmRegistro();
        FrmConsulta c = new FrmConsulta();
        FrmAcercaDe a = new FrmAcercaDe();

        // Se crea el controlador pasándole las tres vistas
        Controlador ctrl = new Controlador(v, c, a);
        // Se inicia la aplicación mostrando la ventana principal
        ctrl.iniciar();
    }
}