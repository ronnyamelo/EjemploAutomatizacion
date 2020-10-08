# new feature
# Tags: optional
  @AutomatizacionAmazon
  Feature: Test Cases para ejemplo de Automatizacion


  Scenario: Buscar y Agregar articulos de Amazon
    Given Un usuario esta registrado y  va al portal de amazon
    Then  Un usuario busca un articulo : Nintendo Switch
    And Un usuario selecciona la primera opcion resultado de la busqueda
    And Usuario Agrega el articulo al carrito
    Then Usuario Va al Carrito
    And Se Verifica que el Articulo ha sido Anadido
    Then Usuario busca un articulo : Super Smash Bros Ultimate
    And Usuario selecciona la primera opcion resultado de la busqueda
    And Usuario agrega articulo al carrito
    Then Usuario Va al Carrito
    And Se Verifica que el Articulo ha sido Anadido