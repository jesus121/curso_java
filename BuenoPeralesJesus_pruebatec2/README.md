
# BuenoPeralesJesus_pruebatec2

**Descripción de la prueba técnica** 

Una entidad gubernamental necesita del desarrollo de un "turnero" (aplicación de gestión de turnos), donde se puedan almacenar en una base de datos turnos para diferentes trámites y ciudadanos asignados a los mismos.

Los turnos son numéricos y se asignan según el orden de llegada. Al mismo tiempo, poseen un estado, el cual puede ser "En espera" o "Ya atendido".

En esta aplicación se ha desarrollado un  backend lógico, que permite a los usuario realizar las siguientes operaciones : 

1-**Agregar un ciudadano :** le pedirá su nombre y apellido.

2-**Agregar un turno :** le pedirá información del número , fecha , una breve descripción y el en que estado se encuentra ( en espera o ya atendido ). También le pedirá información sobre la id del usuario , para así relacionar un usuario con ese turno o que un usuario pueda tener varios turnos .

3-**Filtrado de turnos :** se podrá filtra tanto por fecha como por fecha y el estado que se encuentre el turno .

**Materiales** 

Para esta aplicación se ha utilizado lo siguientes programas : 

-Apache NetBeans IDE 17

-XAMPP v3.3.0

**Funcionamiento** 

En este apartado se informará sobre que necesita para que la aplicación funcione. 

Lo primero que tendremos que hacer es dirigirnos a nuestra base de datos. Para ello tendremos que dirigirnos a nuestro programa XAMPP y darle al botón “Start” en Apache y MySQL. 

Luego nos dirigimos a nuestro navegador y pondremos la siguiente localhost/phpmyadmin/ para asi poder manejar nuestra base de datos. 

A continuación añadimos una base de datos llamada turnosjsp. 

Otra forma que podemos hacer si ya tenemos una base de datos preparada con diferente nombre es seguir los siguientes pasos.

Tendremos que dirigirnos al programa NetBeans y abrimos nuestro proyecto.

Luego nos tendremos que dirigir al archivo persistence.xml, este se encuentra dentro de Other sources > src/main/resources > META-INF.

A continuación le damos a la pestaña de Source y dentro de este podemos cambiar los diferentes datos para que se conecte con nuestra base de datos. Podremos cambiar la dirección de nuestra base de datos, el nombre de usuario para acceder a ella y la contraseña.

**Dato extra**

Dentro de la pagina web ( en el apartado grafico ) aparecerá varios formularios, uno para ciudadano y otro para turno. En cada uno de ello hay un botón para mostrar todo el listado de cada uno de ellos. 

Dentro del formulario turno, cuando se muestra todos los turnos en una tabla hay un apartado llamado opción y un botón. Dicho botón es para eliminar los turnos.

En cada uno de los formularios todos los campos son obligatorios de rellenar excepto en el formulario de turno el apartado de descripción. 

En el filtrado de turnos se puede seleccionar solamente la fecha para filtrar por la misma o también se puede elegir el estado que se encuentra, para hacer un filtrado por fecha y estado 
