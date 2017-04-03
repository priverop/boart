# Boart API

Todas las peticiones devuelven HttpStatus.OK si el recurso se encuentra, HttpStatus.NOT_FOUND si no existe, HttpStatus.FORBIDDEN si es un recurso privado y no se ha logueado.

## Rutas

### Grupos
/api/group

GET (/) -> .
GET (/id) -> .
GET (/idgrupo/join/usuario) -> Usuario se une al grupo especificado.
GET (/idgrupo/leave/usuario) -> Usuario deja el grupo especificado.
POST (/create) -> Nuevo grupo. Entrada: String title, String description, MultipartFile file. Salida: BAD_REQUEST si alguno de los inputs está vacio.

### Likes
/api/like

POST (/) -> Nuevo like. Entrada: IDPublicacion. Salida: BAD_REQUEST si ya existe el like. 
DELETE (/publicationid) -> Eliminar like de la publicationid. Salida: BAD_REQUEST si el like no existía.

### Login
/api/login

POST (/) -> Hace login.

### Logout
/api/logout

GET (/) -> Logout.

### Private Profile
/api/private_profile

GET (/) -> Perfil propio.
PUT (/) -> Editar informacin usuario. Entrada: String name, String surname, String username, String password, String description, Multipartfile file.

### Publication
/api/publication

GET (/list) -> Lista de publicaciones, solo la primera página.
GET (/list/page) -> Lista de publicaciones por la página indicada.
POST (/list/page) -> Lista de publicaciones filtradas por la página indicada. Entradas: String filter, String tags.
POST (/list) -> Lista de publicaciones filtrada. Entradas: String filter, String tags.
GET (/id) -> Publicación específica.

### Users
/api/user

GET (/) -> Lista de usuarios.
GET (/id) -> Usuario específico.
GET (/usuario1/follow/usuario2) -> Usuario 1 sigue a Usuario 2.
GET (/usuario1/unfollow/usuario2) -> Usuario 1 deja de seguir a Usuario 2.
POST (/new) -> Nuevo usuario. Entrada: String username, String name, String surname, String password.
POST (/id) -> Nuevo comentario. Entrada: String comentario.

### Upload
/api/upload

POST (/) -> Subimos un archivo mulimedia. Entradas: Object media, String title, String title, String description, String tags, String type, long idGroup. Salida: BAD_REQUEST si no se ha podido subir.
