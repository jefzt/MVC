package modelo;

import java.util.ArrayList;



public class Proceso {

    private ArrayList<Persona> lista = new ArrayList<>();

    //Método para calcular IMC con validaciones
    public String calcularIMC(String nombre, String edad, String peso, String estatura) {

        try {

            // Validar campos vacíos
            if (nombre == null || nombre.trim().isEmpty() ||
                edad == null || edad.trim().isEmpty() ||
                peso == null || peso.trim().isEmpty() ||
                estatura == null || estatura.trim().isEmpty()) {

                return "Debe completar todos los campos";
            }

            int ed = Integer.parseInt(edad);
            if (ed <= 0) return "Edad inválida";

            double pe = Double.parseDouble(peso);
            if (pe <= 0) return "Peso inválido";

            double es = Double.parseDouble(estatura.replace(",", "."));
            if (es <= 0) return "Estatura inválida";

            double imc = pe / (es * es);

            // Crear objeto Persona
            Persona persona = new Persona();
            persona.setNombre(nombre.trim());
            persona.setEdad(ed);
            persona.setPeso(pe);
            persona.setEstatura(es);
            persona.setImc(imc);

            // Guardar en la lista
            lista.add(persona);

            return "IMC calculado correctamente";

        } catch (Exception e) {
            return "Error en datos (solo números)";
        }
    }

    //  Método de búsqueda 
    public String buscarPorNombre(String nombre) {

        // Validar nombre vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Debe ingresar un nombre";
        }

        // Validar si no hay datos
        if (lista.isEmpty()) {
            return "No hay datos registrados";
        }

        // Buscar persona
        for (Persona persona : lista) {

            if (persona.getNombre().trim().equalsIgnoreCase(nombre.trim())) {

                String clasificacion;

                if (persona.getImc() < 18.5) clasificacion = "Bajo peso";
                else if (persona.getImc() < 25) clasificacion = "Normal";
                else if (persona.getImc() < 30) clasificacion = "Sobrepeso";
                else clasificacion = "Obesidad";

                return "Nombre: " + persona.getNombre() + "<br>"
                        + "Edad: " + persona.getEdad() + "<br>"
                        + "Peso: " + persona.getPeso() + " kg<br>"
                        + "Estatura: " + persona.getEstatura() + " m<br>"
                        + "IMC: " + String.format("%.2f", persona.getImc()) + "<br>"
                        + "Clasificación: " + clasificacion;
            }
        }

        return "No se encontró la persona";
    }
}