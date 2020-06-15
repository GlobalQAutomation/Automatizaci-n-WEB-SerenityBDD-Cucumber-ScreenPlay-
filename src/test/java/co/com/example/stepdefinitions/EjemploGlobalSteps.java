package co.com.example.stepdefinitions;

import co.com.example.tasks.AgregarProducto;
import co.com.example.tasks.BuscarProducto;
import co.com.example.userinterfaces.HomePage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static co.com.example.userinterfaces.CarroCompras.LNK_ARTICULO_AGREGADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class EjemploGlobalSteps {

    @Managed(driver = "chrome")
    private WebDriver navegador;
    private HomePage homePage = new HomePage();

    @Dado("^que un nuevo cliente (.*) accede hasta la web de compras$")
    public void queUnNuevoClienteAccedeHastaLaWebDeCompras(String nombreActor) {
          theActorCalled(nombreActor).can(BrowseTheWeb.with(navegador));
          theActorInTheSpotlight().wasAbleTo(Open.browserOn(homePage));
          navegador.manage().window().maximize();
    }

    @Cuando("^el agrega (.*) unidades de (.*) de (.*) al carro$")
    public void elAgregaUnProductoAlCarro(String cantidad, String descripcion, String tipoCategoria) {
        theActorInTheSpotlight().wasAbleTo(
                BuscarProducto.conDescripcion(descripcion, tipoCategoria),
                AgregarProducto.cantidad(cantidad)
        );
    }

    @Cuando("^el agrega productos al carro$")
    public void elAgregaProductosAlCarro(List<String> datos) {
        theActorInTheSpotlight().wasAbleTo(
                BuscarProducto.conDescripcion(datos.get(1), datos.get(2)),
                AgregarProducto.cantidad(datos.get(0))
        );
    }

    @Entonces("^el ve los productos listado en el carro de compras$")
    public void elVeLosProductosListadoEnElCarroDeCompras() {
        theActorInTheSpotlight().should(seeThat(the(LNK_ARTICULO_AGREGADO), isPresent()));
    }

}
