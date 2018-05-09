# profileBack
Código Backend

1.-Se debe tener Mongodb corriendo con el siguiente comando antes de comenzar: mongod --dbpath C:\mongodb\data\db ('directorio donde se encuentren los binarios de mongo').
2.-Una vez mongo corriendo se utiliza el siguiente comando para levantar el back: mvn spring-boot:run.

Notas: Para utilizar Swagger dirigirse a las siguientes ligas: http://localhost:8080/v2/api-docs para obtener datos en json y para ver la UI de Swagger usar: http://localhost:8080/swagger-ui.html.

*Tener en cuenta que el proyecto esta bajo Spring-security y por ende se te pediran credenciales para acceder: 
  --el usuario es: user
  --el password se muestra en la consola de spring.boot de la siguiente manera: 
    Using generated security password: b058c2e9-9244-4ead-96dd-ec0fa7bb3615
*El password cambia cada vez que se levanta el proyecto de spring-boot.

Para cualquier aclaración me pueden comentar en la sección de Issues o a mi correo: marcogante@gmail.com
