package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://es.aliexpress.com")
public class HomePage extends PageObject {

    public static final Target INPUT_BUSCAR_ARTICULO = Target.the("Input donde se realizar la búsqueda").located(By.id("search-key"));
    public static final Target SELECT_TIPO_CATEGORIA = Target.the("Select tipo de categoría").located(By.id("search-dropdown-box"));
    public static final Target BUTTON_BUSCAR_ARTICULO = Target.the("Botón buscar artículo").located(By.className("search-button"));
    public static final Target BUTTON_CERRAR_VENTANA1 = Target.the("Botón cerrar ventana emergente").located(By.className("close-layer"));
    public static final Target BUTTON_CERRAR_VENTANA2 = Target.the("Botón cerrar ventana emergente").located(By.className("next-dialog-close"));
    public static final Target LNK_ARTICULO_ENCONTRADO = Target.the("Link objeto encontrado").locatedBy("//a[starts-with(@title,'{0}')]");

}
