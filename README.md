# Getting Started
Tenemos un proyecto de VideoClup, de registrar Peliculas.

En Front tenemos un proyecto videoclubFront, con el lenguaje Html, CSS y Javascript.
Git: https://github.com/elramonete/videoclubFront
Alta de registro:
Url: http://127.0.0.1:5500/peliculas.html
![img.png](img.png)
Listado de peliculas :
UrlFormulario: http://127.0.0.1:5500/formularioPelis.html
![img_1.png](img_1.png)

Añadimos la herramienta Jenkins para la automatizacion CI/CD en el desarrollo del software.
Previamente en github sobre el proyecto que tenemos en Jenkins debemos de añadir en setting/Webhooks, la URL. De esta forma cuando realizamos un commit automaticamente se autodespliega en el Jenkins.
Jenkins_Url: http://localhost:8080/job/ProyectoVideoclub/
![img_2.png](img_2.png)


Obtener todas las peliculas o guardar peliculas desde el postman.
http://localhost:8090/api/pelicula
Postman: 
GET ALL Peliculas (todas las peliculas)
GET Pelicula (una pelicula por id)
DELETE Pelicula (borramos una pelicula por id)
POST Pelicula (nueva pelicula)
PUT Pelicula (actualizar pelicula)  
![img_3.png](img_3.png)

Hemos añadido el Cacheable de REDIS, para el get all y el getbyId. 
Y el guardar, actualizar y borrar CacheEvict lo desactivamos.
Reducir la latencia y mejorer los tiempos de respuesta utilizando tecnologías 
de caching como Redis que almacenan en memoria datos altamente fecuentados
por los usuarios.
![img_4.png](img_4.png)

![img_5.png](img_5.png)

Para borrar la bbdd de Redis Cache (en cmd C:\redis>redis-cli.exe FLUSHALL)

Hemos añadido un sistema de monitoreo, con Prometheus y Grafana.
Prometheus:
http://localhost:9090/query
http://elramonete:8090/actuator/prometheus

![img_6.png](img_6.png)

Grafana: http://localhost:3000/

![img_9.png](img_9.png)

http_server_requests_seconds_sum: Suma de los tiempos de respuesta de todas las solicitudes HTTP.
http_server_requests_seconds_count: Número total de solicitudes HTTP.
Con estos dos, puedes calcular la latencia promedio de las solicitudes