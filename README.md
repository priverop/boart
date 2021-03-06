# Boart

## Descripción
Aplicación web dedicada a la publicación y rating de arte. Podrás subir elementos artísticos (fotos, dibujos, música, videos artísticos...) y votar las publicaciones que más te gusten. Las que más gusten aparecerán en portada. Se podrá filtrar por tipo de arte, género, etiquetas... El usuario también dispondrá de una página personal con su galería personal. 

## Docker
Para ejecutar la app basta con irse a la raíz del proyecto y hacer docker-compose up --build

### Parte pública
- La portada tendrá tres vistas: lo mejor valorado, lo más comentado y lo nuevo. Tiene el buscador con etiquetas para filtrar. Estas tres pestañas, a la hora de mostrar publicaciones, se basan en un algoritmo que tiene en cuenta la clave principal (más ratio votos positivos /negativos, o comentarios o fecha más reciente), además de tus gustos personales (como se explica en la parte privada), y por supuesto del tiempo; para evitar que siempre estén las mismas en los primeros puestos.
- Puedes ver las publicaciones (otra vista), donde podrás comentar (si estás logueado) y acceder a los perfiles de los usuarios (si estás logueado; otra vista). 
- Puedes acceder al grupo de la publicación y entrarás en una vista de la página de grupo.
- Existirá la vista del registro para usuarios nuevos.
- Vista del login (ventana modal).

### Parte privada
- Perfil de cada usuario, puedes gestionar tus datos personales y tu galería (número limitado de publicaciones destacadas).
- Puedes contactar con otros artistas por medio de mensajes privados. Todo estaría en una sola vista.
- Puedes seguir usuarios, grupos y etiquetas, para que tengan más importancia en el algoritmo del usuario. Es decir, para que tengan más prioridad a la hora de mostrarse en tu portada.

## Entidades:

* Publicación: Constará de un elemento multimedia (fotografa, vídeo, audio...), un título de la obra y un texto más extenso que la describa. Cada publicación podrá tener un grupo determinada y etiquetas que ayuden a su búsqueda. Existirá la opción de permitir comentarios de otros usuarios.
* Usuario: Constará de un nick, contraseña, nombre, apellidos y correo electrónico. Cada usuario tendrá una página personal con sus datos, publicaciones y galera.
* Galería: Los usuarios tienen derecho a un número limitado de publicaciones a destacar en su perfil.
* Grupo: Página a la que podrán suscribirse los usuarios. Tendrá una foto y breve descripción de encabezado. Por ejemplo: grupo fotografa, música, dibujo...
* Etiqueta: Palabras que los usuarios podrán usar en sus publicaciones para que el resto de personas encuentren sus obras con más facilidad. Las etiquetas también servirán para ver publicaciones referentes a un mismo tema (filtro).
* Votos.
* Comentarios.
![Diagrama](http://i.imgur.com/w0wUk5I.png)

## Diagrama clases
![Diagrama](http://i.imgur.com/t19ZDun.jpg)

## Diagrama clases (Angular)
![Diagrama](http://i.imgur.com/HoymL6k.jpg)

## API REST
[DOCUMENTACIN](https://github.com/priverop/boart/blob/master/API.md)

## VIDEO FUNCIONAMIENTO
www.youtube.com/watch?v=V0u22DKVAGU

## Trello
https://trello.com/b/fG0uTmVa

## Navegación
![Navegacion](http://i.imgur.com/N1B1zfq.png)

# Portada
![Portada](http://i.imgur.com/b3bJRS0.png)

# Login
![Login](http://i.imgur.com/GPWvkUU.png)

# Registro
![Registro](http://i.imgur.com/EULGA32.png)

# Publicación
![Publicación](http://i.imgur.com/XqZVjT5.png)

# Grupo
![Grupo](http://i.imgur.com/F2zCQA5.png)

# Perfil privado
![Perfil privado](http://i.imgur.com/8Ox5MZC.png)

# Perfil público
![Perfil público](http://i.imgur.com/GlAyD6J.png)

# Upload
![Upload](http://i.imgur.com/TTXg9Be.png)

# Crear Grupo
![Crear Grupo](http://i.imgur.com/hirZCB2.png)

## Integrantes 
* Oscar Ballesteros Izquierdo. o.ballesteros@alumnos.urjc.es
* Gabriel Cuenca Moncin. g.cuencam@alumnos.urjc.es
* Pablo Rivero Pulido. p.riverop@alumnos.urjc.es. GitHub: priverop
