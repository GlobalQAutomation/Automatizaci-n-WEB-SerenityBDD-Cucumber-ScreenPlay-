package co.com.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarroCompras {

    public static final Target LNK_ARTICULO_AGREGADO = Target.the("Articulo agregado al carrito").located(By.className("product-name-link"));

}
