package tech.codestrux.sca.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import tech.codestrux.sca.models.Prueba;

/**
 * The main view contains a button and a click listener.
 */
@Route("result")
@PageTitle("Resultados")
@PreserveOnRefresh
public class ResultView extends VerticalLayout {

    @Autowired
    Prueba prueba;

    public ResultView(Prueba prueba) {
        // Título de la vista
        add(new H3("Resultados"));

        // Mostrar las respuestas correctas
        Div respuestasDiv = new Div();
        respuestasDiv.setText("Respuestas correctas:");

        // Mostrar las respuestas correctas en un formato adecuado
        for (Map.Entry<Integer, String> entry : Prueba.respuestasCorrectas.entrySet()) {
            Div respuesta = new Div();
            respuesta.setText("Pregunta " + entry.getKey() + ": " + entry.getValue());
            respuestasDiv.add(respuesta);
        }

        // Calificación del usuario
        Div calificacionDiv = new Div();
        int calificacion = prueba.calcularCalificacion();
        calificacionDiv.setText("Calificación: " + calificacion + " / " + Prueba.respuestasCorrectas.size());

        // Agregar los elementos a la vista
        add(respuestasDiv);
        add(calificacionDiv);

        // Botón para finalizar
        Button button = new Button("Finalizar", e -> {
            UI.getCurrent().navigate("");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);

        addClassName("wider-content");

        // Agregar el botón a la vista
        add(button);
    }
}