package stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.BuscarProducto;
import tasks.AgregarProducto;
import userinterfaces.HomePage;

import java.util.List;

public class EjemploGlobalSteps {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor actor = Actor.named("Global");
    private HomePage homePage = new HomePage();

    @Dado("^que un nuevo cliente accede hasta la web de compras$")
    public void queUnNuevoClienteAccedeHastaLaWebDeCompras() {
          actor.can(BrowseTheWeb.with(navegador));
          actor.wasAbleTo(Open.browserOn(homePage));
          navegador.manage().window().maximize();
    }

    @Cuando("^el agrega (.*) unidades de (.*) de (.*) al carro$")
    public void elAgregaUnProductoAlCarro(String cantidad, String descripcion, String tipoCategoria) {
        actor.wasAbleTo(
                BuscarProducto.conDescripcion(descripcion, tipoCategoria),
                AgregarProducto.cantidad(cantidad)
        );
    }

    @Entonces("^el ve los productos listado en el carro de compras$")
    public void elVeLosProductosListadoEnElCarroDeCompras() {

    }

    @Cuando("^el agrega productos al carro$")
    public void elAgregaProductosAlCarro(List<String> datos) {

    }
}
