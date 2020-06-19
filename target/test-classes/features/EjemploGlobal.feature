# language: es

Característica: Realizar compras de artículos
  Como un nuevo cliente
  Quiero ingresar a la página www.abc.com
  Para realizar una compra de un artículo

  Antecedentes:
    Dado que un nuevo cliente Arturo accede hasta la web de compras

  @EscenarioSinEjemplos
  Escenario: Agregar artículos al carrito de compras
    Cuando el agrega 3 unidades de Máscara de respirador N95 de Belleza y salud al carro
    Entonces el ve los productos listado en el carro de compras

  @EscenarioConEjemplos
  Esquema del escenario: Agregar artículos al carrito de compras
    Cuando el agrega productos al carro
      | <cantidadAgregar> | <nombreProducto> | <tipoCategoria> |
    Entonces el ve los productos listado en el carro de compras

    Ejemplos:
      | cantidadAgregar | nombreProducto                         | tipoCategoria   |
      | 3               | Máscara de respirador N95              | Belleza y salud |
      | 4               | Gel desinfectante de manos de 50ml 75% | Belleza y salud |
      | 5               | Máscara de Gas facial 4 estilo 6800    | Belleza y salud |