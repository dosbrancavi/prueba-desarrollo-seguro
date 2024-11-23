package tech.codestrux.sca.models;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;

import java.util.HashMap;
import java.util.Map;

@SpringComponent
@VaadinSessionScope
public class Prueba {
    private String nombre;
    private Map<Integer, String> respuestasUsuario;

    public static final Map<Integer, String> respuestasCorrectas = new HashMap<>();

    static {
        respuestasCorrectas.put(1, "b) Confidencialidad");
        respuestasCorrectas.put(2, "b) Usar más de un método de verificación para acceder al sistema");
        respuestasCorrectas.put(3, "b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo");
        respuestasCorrectas.put(4, "b) Phishing");
        respuestasCorrectas.put(5, "a) Explotación de vulnerabilidad");
        respuestasCorrectas.put(6, "c) Contraseña más un código de un solo uso");
        respuestasCorrectas.put(7, "c) El gusano se replica por sí mismo sin intervención humana.");
        respuestasCorrectas.put(8, "d) Rootkit");
        respuestasCorrectas.put(9, "a) Segmentación de la red");
        respuestasCorrectas.put(10, "b) Filtrar tráfico no deseado y permitir tráfico autorizado");
        respuestasCorrectas.put(11, "a) Un ataque que utiliza múltiples dispositivos para sobrecargar un servidor y hacerlo inaccesible.");
        respuestasCorrectas.put(12, "c) Un tipo de criptografía que utiliza una clave pública y una clave privada para encriptar y desencriptar información");
        respuestasCorrectas.put(13, "a) Identificar vulnerabilidades y garantizar el cumplimiento de las políticas de seguridad.");
        respuestasCorrectas.put(14, "c) Un intento de engañar a los usuarios para que revelen información confidencial.");
        respuestasCorrectas.put(15, "b) Monitoreo constante y análisis de tráfico de red.");
        respuestasCorrectas.put(16, "b) Un protocolo para asegurar la comunicación entre un servidor y un cliente.");
        respuestasCorrectas.put(17, "c) Usar contraseñas largas y complejas que incluyan números, letras y caracteres especiales.");
        respuestasCorrectas.put(18, "a) Un ataque donde el atacante intercepta y altera la comunicación entre dos partes sin que lo sepan.");
        respuestasCorrectas.put(19, "b) Usar múltiples capas de defensa para proteger un sistema.");
        respuestasCorrectas.put(20, "a) Inyección de SQL");
        respuestasCorrectas.put(21, "c) Manteniendo los sistemas actualizados y realizando copias de seguridad frecuentes.");
        respuestasCorrectas.put(22, "c) Escáner de vulnerabilidades");
        respuestasCorrectas.put(23, "d) Un sistema diseñado para atraer y detectar atacantes.");
        respuestasCorrectas.put(24, "b) HTTPS");
    }

    public Prueba() {
        respuestasUsuario = new HashMap<>();
    }

    public String getNombre() {
        if (nombre == null) {
            return "";
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<Integer, String> getRespuestasUsuario() {
        return respuestasUsuario;
    }

    public int calcularCalificacion() {
        int calificacion = 0;

        for (Map.Entry<Integer, String> entry : respuestasUsuario.entrySet()) {
            Integer preguntaId = entry.getKey();
            String respuestaUsuario = entry.getValue();

            if (respuestasCorrectas.containsKey(preguntaId) && respuestasCorrectas.get(preguntaId).equals(respuestaUsuario)) {
                calificacion++;
            }
        }

        return calificacion; 
    }
}