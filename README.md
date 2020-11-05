# UMB_APP_SISDIS_202
Desarrollo de una app distribuida por medio de microservicios en apache kafka

## Integrantes
* Jose Buelvas
* Alessandro Nuñez

## Funcionalidades
1. El servicio usará las compras recientes del usuario para revisar las categorías de producto.
2. Usando las categorías de los productos del historial de compras del usuario el servicio hará una búsqueda de productos en dicha categoría para recomendarlos.
3. Las recomendaciones serán dinámicas, eso quiere decir que tendrá los siguientes parámetros para las recomendaciones:
    * userID: {opcional} El id del usuario del cual se necesita el historial de usuario.
    * limit: el número de recomendaciones que se necesitan.
    * productID: {opcional} Con el id de producto se harán reocmnedaciones con respecto a las categorías de productos del mismo.
4. Si no se ingresa el id del usuario o el id de algún producto entonces el servicio devolverá los productos más populares (en caso de que haya popularidad).
5. Caso contrario entonces se mostrará productos al azar.