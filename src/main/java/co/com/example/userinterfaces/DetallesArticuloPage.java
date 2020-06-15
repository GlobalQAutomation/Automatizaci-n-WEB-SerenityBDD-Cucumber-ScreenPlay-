package co.com.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DetallesArticuloPage {

    public static final Target ITEM_ARTICULO = Target.the("Característica del artículo").locatedBy("(//img[@title])[1]");
    public static final Target ITEM_ENVIO_DESDE = Target.the("Envío del artículo").locatedBy("(//div[@class='sku-property-text'])[1]");
    public static final Target INPUT_CANTIDAD = Target.the("Input cantidad").locatedBy("//input[@aria-valuemax='209943']");
    public static final Target BOTON_ANADIR_CESTA = Target.the("Botón añadir a la cesta").locatedBy("//button[contains(text(),'Añadir a la cesta') and @title='']");
    public static final Target BOTON_VER_CESTA = Target.the("Botón ver la cesta").locatedBy("//button[contains(text(),'Ver la Cesta')]");

}
