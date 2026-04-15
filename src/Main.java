import controlador.Controlador;
import modelo.Proceso;
import vista.*;

public class Main {

    public static void main(String[] args) {

        // Se crean las vistas
        FrmRegistro vistaRegistro = new FrmRegistro();
        FrmConsulta vistaConsulta = new FrmConsulta();
        FrmAcercaDe vistaAcerca = new FrmAcercaDe();

        // Se crea el proceso
        Proceso proceso = new Proceso();

        // Se crea el controlador
        Controlador ctrl = new Controlador();

        // Se conectan las vistas y el proceso al controlador
        ctrl.setVistaRegistro(vistaRegistro);
        ctrl.setVistaConsulta(vistaConsulta);
        ctrl.setVistaAcerca(vistaAcerca);
        ctrl.setProceso(proceso);

        // Se conectan los botones con sus acciones
        ctrl.iniciarEventos();

        // Se inicia la aplicacion
        ctrl.mostrarVistaRegistro();
    }
}