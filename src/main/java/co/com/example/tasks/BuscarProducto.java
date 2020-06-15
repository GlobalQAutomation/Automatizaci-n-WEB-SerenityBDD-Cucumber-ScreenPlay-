package co.com.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static co.com.example.userinterfaces.HomePage.*;

public class BuscarProducto implements Task {

    private final String descripcion;
    private final String tipoCategoria;

    public BuscarProducto(String descripcion, String tipoCategoria) {
        this.descripcion = descripcion;
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        validarVentanaEmergente(actor);
        actor.attemptsTo(
                Enter.theValue(descripcion).into(INPUT_BUSCAR_ARTICULO), //Diligenciar campo de búsqueda
                //SelectFromOptions.byVisibleText(tipoCategoria).from(SELECT_TIPO_CATEGORIA),
                Hit.the(Keys.ENTER).into(INPUT_BUSCAR_ARTICULO)); //Seleccionar producto a agregar
        validarVentanaEmergente(actor);
        actor.attemptsTo(Click.on(LNK_ARTICULO_ENCONTRADO.of(descripcion)));
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
        validarVentanaEmergente(actor);
    }

    public static BuscarProducto conDescripcion(String descripcion, String tipoCategoria) {
        return instrumented(BuscarProducto.class, descripcion, tipoCategoria);
    }

    private void validarVentanaEmergente(Actor actor) {
        Wait.until(the(BUTTON_CERRAR_VENTANA1), isPresent()).forNoLongerThan(5);
        if (Visibility.of(BUTTON_CERRAR_VENTANA1).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_CERRAR_VENTANA1));

        Wait.until(the(BUTTON_CERRAR_VENTANA2), isPresent()).forNoLongerThan(5);
        if (Visibility.of(BUTTON_CERRAR_VENTANA2).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_CERRAR_VENTANA2));
    }
}