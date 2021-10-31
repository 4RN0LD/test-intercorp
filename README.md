# Customers

Servicio encargado de manipular informacion de clientes y entregar indicadores


## Requerimientos
Los siguientes componentes son necesarios para ejecutar el microservicio customers
- Maquina Virtual de Java instalada en su sistema operativo
- Cliente http (Ejemplo: Insomnia o Postman) para ejecucion de pruebas
-	Puerto 8080 libre, ya que sera el puerto de uso para el servicio

## Instalacion y Ejecucion
Para instalar y ejecutar debe ejecutar los siguientes comandos
```bash

git clone --branch realease/1.0 https://github.com/4RN0LD/test-intercorp.git #clona el repositorio
cd test-intercorp/target # Accedemos al directorio
java -jar customers-0.0.1-SNAPSHOT.jar # Ejecuta el servicio
```
Puede ejecutar directamente luego de ingresar al directorio el archivo **customers-0.0.1-SNAPSHOT.jar**, pero no podra visualizar los logs en tiempo real
## EndPoints
| Http method | URL | Descripcion |
| :----------: | :---------: | :---------: |
|POST|http://localhost:8080/customers|Creacion de cliente|
|GET|http://localhost:8080/customers|Busqueda de clientes, puede enviarse dni y/o email como parametros de filtro|
|GET|http://localhost:8080/indicators|Muestra los indicadores de Clientes|


## Anexos
-	Documentacion de API: https://github.com/4RN0LD/test-intercorp/blob/master/Swagger.yml
-	Coleccion Postman: https://github.com/4RN0LD/test-intercorp/blob/master/Test%20Intercorp.postman_collection.json
