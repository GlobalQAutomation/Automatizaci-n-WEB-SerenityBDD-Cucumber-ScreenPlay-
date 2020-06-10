# language: es

Característica: Realizar compras de artículos
  Como un nuevo cliente
  Quiero ingresar a la página www.abc.com
  Para realizar una compra de un artículo

  @EscenarioSinEjemplos
  Escenario: Agregar artículos al carrito de compras
    Dado que un nuevo cliente accede hasta la web de compras
    Cuando el agrega 3 unidades de Máscara de respirador N95 de Belleza y salud al carro
    Entonces el ve los productos listado en el carro de compras

  @EscenarioConEjemplos
  Esquema del escenario: Agregar artículos al carrito de compras
    Dado que un nuevo cliente accede hasta la web de compras
    Cuando el agrega productos al carro
      | <nombreProducto> | <cantidadAgregar> |
    Entonces el ve los productos listado en el carro de compras

    Ejemplos:
      | cantidadAgregar | nombreProducto | tipoCategoria   |
      | 100             | Tapabocas N95  | Belleza y salud |