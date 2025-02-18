
# BuenoPeralesJesus_pruebatec4

**Descripción de la prueba técnica** 

Una agencia de turismo desea llevar a cabo el desarrollo de una aplicación que le permita recibir solicitudes de reservas para los diferentes tipos de paquetes que ofrece. Por el momento los dos servicios con los que cuenta son el de búsqueda y reserva de hoteles y búsqueda y reserva de vuelos.

**Materiales** 

Para esta aplicación se ha utilizado lo siguientes programas : 

-IntelliJ IDEA 2024.3

-XAMPP v3.3.0

-Spring Boot

-Postman

**Funcionamiento** 

En este apartado se informará sobre que necesita para que la aplicación funcione. 

Lo primero que tendremos que hacer es dirigirnos a nuestra base de datos. Para ello tendremos que dirigirnos a nuestro programa XAMPP y darle al botón “Start” en Apache y MySQL. 

Luego nos dirigimos a nuestro navegador y pondremos la siguiente localhost/phpmyadmin/ para asi poder manejar nuestra base de datos. 

A continuación añadimos una base de datos llamada agencia. 

Otra forma que podemos hacer si ya tenemos una base de datos preparada con diferente nombre es seguir los siguientes pasos.

Tendremos que dirigirnos al programa IntelliJ y abrimos nuestro proyecto.

Luego nos tendremos que dirigir al archivo resources, dentro de este nos dirigimos a aplication.properties

A continuación nos mostrará que esta vacio para ello tendremos que poner lo siguiente : 

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/agencia?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

Donde tendremos que cambiar la segunda linea , y poner el nombre de nuestra base de datos junto a la direccion que se encuentre .

**Funcionalidad** 

En este apartado se explica las funcionalidades que tiene los endpoints.

En los apartados de  hotel  y vuelo podemos hacer lo siguiente : 

-Un listado : te muestra todos los hoteles o vuelos que se encuentren . 

-Filtrado de hoteles : se puede filtrar por rango de fecha y donde esta situado dicho hotel , tambien se puede filtrar por id.

-Filtrado de vuelos : se puede filtrar por las fechas de ida y vuelta y el lugar de origen y destino , tambien se puede filtrar por id .

-Modificación : se puede por su correspondiente id se puede modificar un vuelo u hotel.

-Eliminar de hoteles o vuelos : a traves de su correspondiente id se puede eliminar un hotel o vuelo .

-Crear : Se puede crear tanto vuelo como hotel con su correspondientes datos.

En los apartados de reserva hotel y reserva vuelo podemos hacer lo siguiente : 

-Crear : se puede crear una reserva tanto de hotel como vuelo con su correspondientes datos .

**Dato extra**

En los metodos de crear reserva ( tanto para hoteles como para vuelos) tendremos que meterle todos los datos de estas clases , es decir , cuando quiera reservar un vuelo o un hotel se tendrá que proporcionar todos los campos de hotel o vuelo que querramos reservar .  

El programa no contempla la opción de eliminar ninguna reserva ya que no se pide que se haga .

Dentro de este programa hay una colección de todas las peticiones de postamn
