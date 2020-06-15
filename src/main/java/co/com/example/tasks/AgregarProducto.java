package co.com.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Visibility;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static co.com.example.userinterfaces.DetallesArticuloPage.*;

public class AgregarProducto implements Task {

    private String cantidad;
    public AgregarProducto(String cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(Visibility.of(ITEM_ENVIO_DESDE).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(ITEM_ENVIO_DESDE));
        actor.attemptsTo(
                Click.on(ITEM_ARTICULO), //Seleccionar "color"
                //Enter.theValue(cantidad).into(INPUT_CANTIDAD), //Ingresar Cantidad
                Click.on(BOTON_ANADIR_CESTA), //Seleccionar añadir a la cesta
                Click.on(BOTON_VER_CESTA) //Seleccionar ver la cesta
        );
    }

    public static AgregarProducto cantidad(String cantidad) {
        return instrumented(AgregarProducto.class, cantidad);
    }

}
