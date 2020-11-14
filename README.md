# UMB_APP_SISDIS_202
Desarrollo de una app distribuida por medio de microservicios en apache kafka

## Integrantes
* Jose Buelvas
* Alessandro Nuñez

## Integrante 
Juan Sebastian Nuñez Pinzon

## Funcionalidades
1. El servicio usará las compras recientes del usuario para revisar las categorías de producto.
2. Usando las categorías de los productos del historial de compras del usuario el servicio hará una búsqueda de productos en dicha categoría para recomendarlos.
3. Las recomendaciones serán dinámicas, eso quiere decir que tendrá los siguientes parámetros para las recomendaciones:
    * userID: {opcional} El id del usuario del cual se necesita el historial de usuario.
    * limit: el número de recomendaciones que se necesitan.
    * productID: {opcional} Con el id de producto se harán reocmnedaciones con respecto a las categorías de productos del mismo.
4. Si no se ingresa el id del usuario o el id de algún producto entonces el servicio devolverá los productos más populares (con la condicion de que haya popularidad).
5. Caso contrario entonces se mostrará productos al azar.

## Instrucciones de instalación
### Desarrollo
1. Instalar Go -> https://golang.org/dl/
2. Configurar `GO_ROOT` y `GO_PATH`.
3. Clonar el proyecto dentro del directorio `src` de Go.
4. `git clone https://github.com/ihojose/UMB_APP_SISDIS_202.git -b recomendation`
5. Descargar dependencias `go mod download`
6. Iniciar servicio `go run .`

### Docker

Para ejecutar el contenedor en servicio de fondo:
```
$ docker-compose up --build -d
```

Para verificar que se esté ejecutando el servicio use el comando:
```
$ docker logs -f sisdis
```

**NOTA:** el nombre `sisdis` puede cambiar según sea asignado por Docker al final de la compilación

## Dependencias del proyecto
Meramente informativo, el proyecto descarga estas dependencias automaticamente:
* https://github.com/kataras/iris
* https://github.com/shurcooL/sanitized_anchor_name
* https://godoc.org/golang.org/x/crypto
