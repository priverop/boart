# Boart API

Todas las peticiones devuelven HttpStatus.OK si el recurso se encuentra, HttpStatus.NOT_FOUND si no existe, HttpStatus.FORBIDDEN si es un recurso privado y no se ha logueado.

## Rutas

### Grupos
/api/group

- GET (/) -> Lista de grupos.
```
[
  {
    "id": 1,
    "title": "Fotógrafos de Vallecas",
    "description": "Somos lo que somos por dónde nos criamos.",
    "img": "http://santaeugeniaesmibarrio.com/sites/default/files/styles/945x--/public/images/image_galeria_fotos/vallecas-escudo.jpg?itok=3nrnj_53",
    "publications": [],
    "miembroGrupos": []
  },
  {
    "id": 2,
    "title": "Amantes del Graffiti",
    "description": "Manchamos las calles buscando la belleza.",
    "img": "http://keusta.net/blog/images/graffiti/ivry/eyegasm/graphic_eye_stack_big.jpg",
    "publications": [],
    "miembroGrupos": []
  },
  {
    "id": 3,
    "title": "Música clásica",
    "description": "Música clásica en esencia vida y magia.",
    "img": "https://lucasemece.files.wordpress.com/2008/02/richard_wagner.jpg",
    "publications": [],
    "miembroGrupos": []
  },
  {
    "id": 4,
    "title": "Rap Femenino",
    "description": "Rap internacional hecho por mujeres.",
    "img": "http://www.hhgroups.com/imagenes/artistas/gata-cattana-artista.jpg",
    "publications": [
      {
        "id": 11,
        "title": "Lisístrata",
        "description": "Gata Cattana, Lisístrata",
        "media": "<iframe class=\"iframeVideo\" src=\"https://www.youtube.com/embed/GsMDU8gb5sQ\" frameborder=\"0\"></iframe>",
        "media_type": 2,
        "date": 1491236380000,
        "stringDate": "Publicado el 03/04/2017 a las 18:19",
        "num_visits": 0,
        "numberOfLikes": 4,
        "numberOfComments": 24,
        "user": "@emilio",
        "comments": [
          "@cristinaCrespo: so pretty",
          "@nataliaTorras: so pretty",
          "@mRosarioAyala: This is beautiful and cute",
          "@joseMariaNieves: looks nice!",
          "@m0scar: Impressive",
          "@nexmaniosis: cool!",
          "@ismaelMoreno: Absolutely gorgeous!",
          "@pilarGarzon: Gorgeous!",
          "@aitorGaleano: what a tremendous work!",
          "@cristinaCrespo: This is epic",
          "@mRosarioAyala: This is beautiful and cute",
          "@carlaNavarro: Wonderful",
          "@carlaNavarro: what a tremendous work!",
          "@aitorGaleano: Gorgeous!",
          "@hugoPariente: what a tremendous work!",
          "@vicenteGuash: Such style and skill!",
          "@consueloCasas: insaaaneeely good and stunning :d",
          "@pilarGarzon: Impressive",
          "@montserratDelValle: amazing piece",
          "@nataliaTorras: awesome",
          "@ismaelMoreno: Absolutely gorgeous!",
          "@mRosarioAyala: Beautiful!",
          "@ramonCapitan: Wonderful",
          "@nataliaTorras: So elegant",
          "@cristinaCrespo: so pretty",
          "@nataliaTorras: so pretty",
          "@mRosarioAyala: This is beautiful and cute",
          "@joseMariaNieves: looks nice!",
          "@m0scar: Impressive",
          "@nexmaniosis: cool!",
          "@ismaelMoreno: Absolutely gorgeous!",
          "@pilarGarzon: Gorgeous!",
          "@aitorGaleano: what a tremendous work!",
          "@cristinaCrespo: This is epic",
          "@mRosarioAyala: This is beautiful and cute",
          "@carlaNavarro: Wonderful",
          "@carlaNavarro: what a tremendous work!",
          "@aitorGaleano: Gorgeous!",
          "@hugoPariente: what a tremendous work!",
          "@vicenteGuash: Such style and skill!",
          "@consueloCasas: insaaaneeely good and stunning :d",
          "@pilarGarzon: Impressive",
          "@montserratDelValle: amazing piece",
          "@nataliaTorras: awesome",
          "@ismaelMoreno: Absolutely gorgeous!",
          "@mRosarioAyala: Beautiful!",
          "@ramonCapitan: Wonderful",
          "@nataliaTorras: So elegant"
        ],
        "likes": [
          "@m0scar",
          "@nexmaniosis",
          "@gcuencam",
          "@aitorGaleano"
        ],
        "tags": [
          "cattana",
          "dep",
          "rap",
          "gata"
        ]
      }
    ],
    "miembroGrupos": [
      {
        "id": 3,
        "username": "juan",
        "name": "Juan",
        "surname": "Cuesta",
        "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
        "img": "https://pickaface.net/assets/images/slides/slide2.png",
        "visits": 0,
        "signInDate": 1491236375000,
        "likes": [],
        "roles": [
          "ROLE_USER"
        ],
        "gallery": [
          "Amor bajo la lluvia",
          "La simetría y la comida",
          "Destellos del futuro permanente",
          "El punto de mira",
          "¿Quién está ahí?",
          "Amor bajo la lluvia",
          "La simetría y la comida",
          "Destellos del futuro permanente",
          "El punto de mira",
          "¿Quién está ahí?"
        ],
        "comments": [
          "@concha:Váyase señor Juan!!"
        ],
        "following": [
          "@emilio",
          "@nexmaniosis",
          "@gcuencam",
          "@celiaGaspar",
          "@mRosarioAyala"
        ],
        "followers": [
          "@emilio",
          "@concha"
        ],
        "groups": [
          "Rap Femenino"
        ],
        "publications": [
          "Amor bajo la lluvia",
          "La simetría y la comida",
          "Destellos del futuro permanente",
          "El punto de mira",
          "¿Quién está ahí?",
          "Amor bajo la lluvia",
          "La simetría y la comida",
          "Destellos del futuro permanente",
          "El punto de mira",
          "¿Quién está ahí?",
          "Werewolf",
          "Angelus of Hope",
          "Chopin Nocturne in F Minor-Op. 55",
          "Mozart: Concerto for Piano no 25",
          "Beethoven - Moonlight Sonata",
          "Mortal Kombat Dance",
          "Hysteria",
          "Reload ",
          "The Greatest",
          "See You Again",
          "The Force Awakens Trailer",
          "The magnificent landscape of Iceland",
          "POILUS Short Film"
        ]
      },
      {
        "id": 1,
        "username": "emilio",
        "name": "Emilio",
        "surname": "Delgado",
        "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
        "img": "https://pickaface.net/assets/images/slides/slide4.png",
        "visits": 0,
        "signInDate": 1491236374000,
        "likes": [],
        "roles": [
          "ROLE_USER"
        ],
        "gallery": [],
        "comments": [],
        "following": [
          "@juan"
        ],
        "followers": [
          "@juan"
        ],
        "groups": [
          "Rap Femenino"
        ],
        "publications": [
          "Lisístrata",
          "Epiclesis",
          "Red dragon",
          "Forbidden Kingdom",
          "Sibelius Violin Concerto 1st Movement",
          "Yiruma - River Flows in You",
          "LaLa Land movie Theme",
          "Asylum",
          "Triple concerto",
          "Rogue One Trailer",
          "NORWAY",
          "Alone in the Night"
        ]
      },
      {
        "id": 2,
        "username": "concha",
        "name": "Concha",
        "surname": "García",
        "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
        "img": "https://pickaface.net/assets/images/slides/slide1.png",
        "visits": 0,
        "signInDate": 1491236374000,
        "likes": [],
        "roles": [
          "ROLE_USER"
        ],
        "gallery": [],
        "comments": [],
        "following": [
          "@juan"
        ],
        "followers": [],
        "groups": [
          "Rap Femenino"
        ],
        "publications": [
          "ANCIENT GOD",
          "Chinese Dragon",
          "Dragon Cove",
          "Cant Forgive",
          "300 Violin Orchestra",
          "Fur Elise",
          "Bullet Train",
          "Faded",
          "America's Great Spaces",
          "Street Traffic",
          "Fat Animated Short Film"
        ]
      }
    ]
  }
]
```
- GET (/id) -> Grupo específico.
```
{
  "id": 3,
  "title": "Música clásica",
  "description": "Música clásica en esencia vida y magia.",
  "img": "https://lucasemece.files.wordpress.com/2008/02/richard_wagner.jpg",
  "publications": [],
  "miembroGrupos": []
}
```
- GET (/join/idgrupo) -> Usuario en sesión se une al grupo especificado.
- GET (/leave/idgrupo) -> Usuario en sesión deja el grupo especificado.
- POST (/create) -> Nuevo grupo. Entrada: String title, String description, MultipartFile file. Salida: BAD_REQUEST si alguno de los inputs está vacio.

### Likes
/api/like

- POST (/) -> Nuevo like. Entrada: IDPublicacion. Salida: BAD_REQUEST si ya existe el like. 
- DELETE (/publicationid) -> Eliminar like de la publicationid. Salida: BAD_REQUEST si el like no existía.

### Login
/api/login

- POST (/) -> Hace login.

### Logout
/api/logout

- GET (/) -> Logout.

### Private Profile
/api/private_profile

- GET (/) -> Perfil propio.
- PUT (/) -> Editar informacin usuario. Entrada: String name, String surname, String username, String password, String description, Multipartfile file.

### Publication
/api/publication

- GET (/list) -> Lista de publicaciones, solo la primera página.
```
{
  "content": [
    {
      "id": 11,
      "title": "Lisístrata",
      "description": "Gata Cattana, Lisístrata",
      "media": "<iframe class=\"iframeVideo\" src=\"https://www.youtube.com/embed/GsMDU8gb5sQ\" frameborder=\"0\"></iframe>",
      "media_type": 2,
      "date": 1491236380000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 4,
      "numberOfComments": 24,
      "user": "@emilio",
      "comments": [
        "@cristinaCrespo: so pretty",
        "@nataliaTorras: so pretty",
        "@mRosarioAyala: This is beautiful and cute",
        "@joseMariaNieves: looks nice!",
        "@m0scar: Impressive",
        "@nexmaniosis: cool!",
        "@ismaelMoreno: Absolutely gorgeous!",
        "@pilarGarzon: Gorgeous!",
        "@aitorGaleano: what a tremendous work!",
        "@cristinaCrespo: This is epic",
        "@mRosarioAyala: This is beautiful and cute",
        "@carlaNavarro: Wonderful",
        "@carlaNavarro: what a tremendous work!",
        "@aitorGaleano: Gorgeous!",
        "@hugoPariente: what a tremendous work!",
        "@vicenteGuash: Such style and skill!",
        "@consueloCasas: insaaaneeely good and stunning :d",
        "@pilarGarzon: Impressive",
        "@montserratDelValle: amazing piece",
        "@nataliaTorras: awesome",
        "@ismaelMoreno: Absolutely gorgeous!",
        "@mRosarioAyala: Beautiful!",
        "@ramonCapitan: Wonderful",
        "@nataliaTorras: So elegant",
        "@cristinaCrespo: so pretty",
        "@nataliaTorras: so pretty",
        "@mRosarioAyala: This is beautiful and cute",
        "@joseMariaNieves: looks nice!",
        "@m0scar: Impressive",
        "@nexmaniosis: cool!",
        "@ismaelMoreno: Absolutely gorgeous!",
        "@pilarGarzon: Gorgeous!",
        "@aitorGaleano: what a tremendous work!",
        "@cristinaCrespo: This is epic",
        "@mRosarioAyala: This is beautiful and cute",
        "@carlaNavarro: Wonderful",
        "@carlaNavarro: what a tremendous work!",
        "@aitorGaleano: Gorgeous!",
        "@hugoPariente: what a tremendous work!",
        "@vicenteGuash: Such style and skill!",
        "@consueloCasas: insaaaneeely good and stunning :d",
        "@pilarGarzon: Impressive",
        "@montserratDelValle: amazing piece",
        "@nataliaTorras: awesome",
        "@ismaelMoreno: Absolutely gorgeous!",
        "@mRosarioAyala: Beautiful!",
        "@ramonCapitan: Wonderful",
        "@nataliaTorras: So elegant"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam",
        "@aitorGaleano"
      ],
      "tags": [
        "gata",
        "dep",
        "rap",
        "cattana"
      ]
    },
    {
      "id": 1,
      "title": "Amor bajo la lluvia",
      "description": "Boda Juan y Elena",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery1.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 2,
      "title": "La simetría y la comida",
      "description": "Boda Pedro y Lucía",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery2.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 3,
      "title": "Destellos del futuro permanente",
      "description": "Boda Emilio y Marisa.",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery3.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 4,
      "title": "El punto de mira",
      "description": "Boda Emilio y Marisa",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery4.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 5,
      "title": "¿Quién está ahí?",
      "description": "La hija Isabel observaba al fotógrafo tras las escaleras",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery5.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 6,
      "title": "Amor bajo la lluvia",
      "description": "Boda Juan y Elena",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery1.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 7,
      "title": "La simetría y la comida",
      "description": "Boda Pedro y Lucía",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery2.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 8,
      "title": "Destellos del futuro permanente",
      "description": "Boda Emilio y Marisa.",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery3.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    },
    {
      "id": 9,
      "title": "El punto de mira",
      "description": "Boda Emilio y Marisa",
      "media": "<img  class=\"img-responsive\" src=\"/files/gallery4.jpg\">",
      "media_type": 0,
      "date": 1491236378000,
      "stringDate": "Publicado el 03/04/2017 a las 18:19",
      "num_visits": 0,
      "numberOfLikes": 0,
      "numberOfComments": 0,
      "user": "@juan",
      "comments": [],
      "likes": [],
      "tags": []
    }
  ],
  "last": false,
  "totalPages": 5,
  "totalElements": 46,
  "size": 10,
  "number": 0,
  "sort": [
    {
      "direction": "DESC",
      "property": "date",
      "ignoreCase": false,
      "nullHandling": "NATIVE",
      "ascending": false,
      "descending": true
    }
  ],
  "first": true,
  "numberOfElements": 10
}
```
- GET (/list/page) -> Lista de publicaciones por la página indicada.
```
{
  "content": [
    {
      "id": 21,
      "title": "Chopin Nocturne in F Minor-Op. 55",
      "description": "Produced by Chad Lawson & Alejandro Clavijo. Mixed by Stephen Lee Price. Mastered by Michael Graves of Osiris Studios (Atlanta, GA).",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/164691599&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491200380000,
      "stringDate": "Publicado el 03/04/2017 a las 08:19",
      "num_visits": 0,
      "numberOfLikes": 8,
      "numberOfComments": 10,
      "user": "@juan",
      "comments": [
        "@aitorGaleano: amazing piece",
        "@albertMesa: WOW",
        "@aitorGaleano: Inspiring!",
        "@carlaNavarro: sooooo coooool",
        "@pilarGarzon: WOW",
        "@ramonCapitan: insaaaneeely good and stunning :d",
        "@cristinaCrespo: Absolutely gorgeous!",
        "@ismaelMoreno: Beautiful <3 ",
        "@nataliaTorras: Wonderful",
        "@pilarGarzon: sooooo coooool"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam",
        "@aitorGaleano",
        "@ramonCapitan",
        "@celiaGaspar",
        "@carlaNavarro",
        "@montserratDelValle"
      ],
      "tags": [
        "cello",
        "violin",
        "chopin",
        "piano"
      ]
    },
    {
      "id": 22,
      "title": "Sibelius Violin Concerto 1st Movement",
      "description": "Performed live on March 26th, 2015 with the Gothenburg Symphony Orchestra and Maestro Kent Nagano",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/206466890&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491196780000,
      "stringDate": "Publicado el 03/04/2017 a las 07:19",
      "num_visits": 0,
      "numberOfLikes": 1,
      "numberOfComments": 25,
      "user": "@emilio",
      "comments": [
        "@hugoPariente: what a tremendous work!",
        "@ramonCapitan: Inspiring!",
        "@consueloCasas: This is beautiful and cute",
        "@albertMesa: Gorgeous!",
        "@hugoPariente: Inspiring!",
        "@vicenteGuash: beautiful artwork",
        "@ramonCapitan: Aaah! this is amazing!",
        "@ramonCapitan: This is beautiful and cute",
        "@m0scar: I love it",
        "@gcuencam: Inspiring!",
        "@celiaGaspar: It's absolute amazing.",
        "@ismaelMoreno: beautiful artwork",
        "@nexmaniosis: Wonderful",
        "@hugoPariente: Beautiful <3 ",
        "@carlaNavarro: It's absolute amazing.",
        "@albertMesa: cool!",
        "@consueloCasas: i have no words",
        "@m0scar: Absolutely gorgeous!",
        "@vicenteGuash: i have no words",
        "@mRosarioAyala: beautiful artwork",
        "@ismaelMoreno: This is beautiful and cute",
        "@ismaelMoreno: amazing piece",
        "@nataliaTorras: This is beautiful and cute",
        "@m0scar: Wonderful",
        "@ismaelMoreno: Impressive"
      ],
      "likes": [
        "@m0scar"
      ],
      "tags": [
        "concert",
        "orchestra",
        "violin",
        "boart"
      ]
    },
    {
      "id": 23,
      "title": "300 Violin Orchestra",
      "description": "300 Violin orchestra has become a sports anthem and very well known among the pump up songs category. ",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/12417512&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491193180000,
      "stringDate": "Publicado el 03/04/2017 a las 06:19",
      "num_visits": 0,
      "numberOfLikes": 18,
      "numberOfComments": 4,
      "user": "@concha",
      "comments": [
        "@nataliaTorras: amazing piece",
        "@mRosarioAyala: This is epic",
        "@joseMariaNieves: so pretty",
        "@celiaGaspar: This is beautiful and cute"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam",
        "@aitorGaleano",
        "@ramonCapitan",
        "@celiaGaspar",
        "@carlaNavarro",
        "@montserratDelValle",
        "@mRosarioAyala",
        "@nataliaTorras",
        "@joseMariaNieves",
        "@ismaelMoreno",
        "@albertMesa",
        "@hugoPariente",
        "@vicenteGuash",
        "@consueloCasas",
        "@cristinaCrespo",
        "@pilarGarzon"
      ],
      "tags": [
        "concert",
        "orchestra",
        "violin"
      ]
    },
    {
      "id": 24,
      "title": "Mozart: Concerto for Piano no 25",
      "description": "The New England Conservatory Philharmonia led by guest conductor Jefferey Kahane at the keyboard, present Mozart's Concerto for Piano no 25 in C major",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/121863093&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491189580000,
      "stringDate": "Publicado el 03/04/2017 a las 05:19",
      "num_visits": 0,
      "numberOfLikes": 1,
      "numberOfComments": 27,
      "user": "@juan",
      "comments": [
        "@mRosarioAyala: beautiful artwork",
        "@celiaGaspar: awesome",
        "@m0scar: cool!",
        "@albertMesa: Beautiful!",
        "@consueloCasas: what a tremendous work!",
        "@cristinaCrespo: Looks great!",
        "@celiaGaspar: Aaah! this is amazing!",
        "@gcuencam: sooooo coooool",
        "@nexmaniosis: It's absolute amazing.",
        "@ramonCapitan: I love it",
        "@ramonCapitan: beautiful artwork",
        "@montserratDelValle: i have no words",
        "@ramonCapitan: Impressive",
        "@hugoPariente: awesome",
        "@cristinaCrespo: looks nice!",
        "@ramonCapitan: what a tremendous work!",
        "@nexmaniosis: Gorgeous!",
        "@nexmaniosis: Amazing work!",
        "@montserratDelValle: Aaah! this is amazing!",
        "@montserratDelValle: I love it",
        "@pilarGarzon: Beautiful <3 ",
        "@montserratDelValle: looks nice!",
        "@ramonCapitan: beautiful artwork",
        "@albertMesa: Aaah! this is amazing!",
        "@consueloCasas: Looks great!",
        "@hugoPariente: This is beautiful and cute",
        "@albertMesa: I love it"
      ],
      "likes": [
        "@m0scar"
      ],
      "tags": [
        "concert",
        "orchestra",
        "mozart",
        "piano"
      ]
    },
    {
      "id": 25,
      "title": "Yiruma - River Flows in You",
      "description": "Cello & Piano Orchestral Version ft. Yiruma - River Flows in You",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/129893792&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491185980000,
      "stringDate": "Publicado el 03/04/2017 a las 04:19",
      "num_visits": 0,
      "numberOfLikes": 3,
      "numberOfComments": 4,
      "user": "@emilio",
      "comments": [
        "@cristinaCrespo: Impressive",
        "@pilarGarzon: This is beautiful and cute",
        "@consueloCasas: Such style and skill!",
        "@vicenteGuash: cool!"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam"
      ],
      "tags": [
        "orchestra",
        "music",
        "boart",
        "piano"
      ]
    },
    {
      "id": 26,
      "title": "Beethoven - Moonlight Sonata",
      "description": "I was just practicing tonight and felt like recording one of the pieces.",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/24880470&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491182380000,
      "stringDate": "Publicado el 03/04/2017 a las 03:19",
      "num_visits": 0,
      "numberOfLikes": 16,
      "numberOfComments": 3,
      "user": "@juan",
      "comments": [
        "@pilarGarzon: This is epic",
        "@cristinaCrespo: It's absolute amazing.",
        "@carlaNavarro: Impressive"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam",
        "@aitorGaleano",
        "@ramonCapitan",
        "@celiaGaspar",
        "@carlaNavarro",
        "@montserratDelValle",
        "@mRosarioAyala",
        "@nataliaTorras",
        "@joseMariaNieves",
        "@ismaelMoreno",
        "@albertMesa",
        "@hugoPariente",
        "@vicenteGuash",
        "@consueloCasas"
      ],
      "tags": [
        "dark",
        "epic",
        "sonata",
        "beauty",
        "beethoven",
        "piano"
      ]
    },
    {
      "id": 27,
      "title": "Fur Elise",
      "description": "Ludwig Van Beethoven-- Fur Elise",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/65833474&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491178780000,
      "stringDate": "Publicado el 03/04/2017 a las 02:19",
      "num_visits": 0,
      "numberOfLikes": 1,
      "numberOfComments": 14,
      "user": "@concha",
      "comments": [
        "@consueloCasas: Amazing work!",
        "@carlaNavarro: Absolutely gorgeous!",
        "@pilarGarzon: This is beautiful and cute",
        "@celiaGaspar: It's absolute amazing.",
        "@ismaelMoreno: It's absolute amazing.",
        "@gcuencam: It's absolute amazing.",
        "@ismaelMoreno: Looks great!",
        "@aitorGaleano: i have no words",
        "@consueloCasas: So elegant",
        "@nataliaTorras: looks nice!",
        "@m0scar: This is beautiful and cute",
        "@gcuencam: Awesome job!",
        "@aitorGaleano: Inspiring!",
        "@pilarGarzon: cool!"
      ],
      "likes": [
        "@m0scar"
      ],
      "tags": [
        "music",
        "religion",
        "beethoven",
        "piano"
      ]
    },
    {
      "id": 28,
      "title": "LaLa Land movie Theme",
      "description": "Piano Cover",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/301212235&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491175180000,
      "stringDate": "Publicado el 03/04/2017 a las 01:19",
      "num_visits": 0,
      "numberOfLikes": 4,
      "numberOfComments": 21,
      "user": "@emilio",
      "comments": [
        "@ismaelMoreno: I love it",
        "@montserratDelValle: So elegant",
        "@m0scar: Such style and skill!",
        "@pilarGarzon: i have no words",
        "@m0scar: looks nice!",
        "@gcuencam: I love it",
        "@consueloCasas: Looks great!",
        "@albertMesa: sooooo coooool",
        "@mRosarioAyala: Absolutely gorgeous!",
        "@montserratDelValle: so pretty",
        "@albertMesa: sooooo coooool",
        "@gcuencam: Impressive",
        "@mRosarioAyala: Gorgeous!",
        "@pilarGarzon: i have no words",
        "@gcuencam: looks nice!",
        "@consueloCasas: I love it",
        "@nexmaniosis: Looks great!",
        "@nataliaTorras: WOW",
        "@pilarGarzon: amazing piece",
        "@gcuencam: insaaaneeely good and stunning :d",
        "@aitorGaleano: This is epic"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam",
        "@aitorGaleano"
      ],
      "tags": [
        "cover",
        "boart",
        "lalaland",
        "piano"
      ]
    },
    {
      "id": 29,
      "title": "Bullet Train",
      "description": "by Stephen Swartz ft. Joni Fatora",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/57809396&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491171580000,
      "stringDate": "Publicado el 03/04/2017 a las 00:19",
      "num_visits": 0,
      "numberOfLikes": 2,
      "numberOfComments": 19,
      "user": "@concha",
      "comments": [
        "@nexmaniosis: insaaaneeely good and stunning :d",
        "@celiaGaspar: Beautiful!",
        "@pilarGarzon: sooooo coooool",
        "@pilarGarzon: beautiful artwork",
        "@vicenteGuash: Impressive",
        "@ramonCapitan: Gorgeous!",
        "@nexmaniosis: Looks great!",
        "@nataliaTorras: Beautiful!",
        "@mRosarioAyala: what a tremendous work!",
        "@vicenteGuash: beautiful artwork",
        "@cristinaCrespo: Inspiring!",
        "@albertMesa: i have no words",
        "@vicenteGuash: It's absolute amazing.",
        "@gcuencam: awesome",
        "@cristinaCrespo: Beautiful <3 ",
        "@ramonCapitan: This is beautiful and cute",
        "@celiaGaspar: I love it",
        "@pilarGarzon: insaaaneeely good and stunning :d",
        "@consueloCasas: so pretty"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis"
      ],
      "tags": [
        "epic",
        "dubstep",
        "music",
        "electronic"
      ]
    },
    {
      "id": 30,
      "title": "Asylum",
      "description": "STRANGUH - Asylum",
      "media": "<iframe class=\"iframeAudio\" scrolling=\"no\" frameborder=\"no\" src=\"https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/311584848&amp;color=ff5500&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false\"></iframe>",
      "media_type": 1,
      "date": 1491167980000,
      "stringDate": "Publicado el 02/04/2017 a las 23:19",
      "num_visits": 0,
      "numberOfLikes": 8,
      "numberOfComments": 28,
      "user": "@emilio",
      "comments": [
        "@nexmaniosis: Amazing work!",
        "@nataliaTorras: WOW",
        "@mRosarioAyala: sooooo coooool",
        "@pilarGarzon: Looks great!",
        "@vicenteGuash: cool!",
        "@albertMesa: Gorgeous!",
        "@ramonCapitan: This is beautiful and cute",
        "@consueloCasas: Absolutely gorgeous!",
        "@montserratDelValle: Aaah! this is amazing!",
        "@cristinaCrespo: This is beautiful and cute",
        "@consueloCasas: beautiful artwork",
        "@aitorGaleano: WOW",
        "@pilarGarzon: So elegant",
        "@consueloCasas: cool!",
        "@gcuencam: Beautiful <3 ",
        "@vicenteGuash: i have no words",
        "@m0scar: i have no words",
        "@hugoPariente: Wonderful",
        "@ramonCapitan: WOW",
        "@joseMariaNieves: Awesome job!",
        "@mRosarioAyala: amazing piece",
        "@cristinaCrespo: WOW",
        "@cristinaCrespo: This is beautiful and cute",
        "@ramonCapitan: Awesome job!",
        "@cristinaCrespo: Aaah! this is amazing!",
        "@mRosarioAyala: Impressive",
        "@montserratDelValle: looks nice!",
        "@mRosarioAyala: i have no words"
      ],
      "likes": [
        "@m0scar",
        "@nexmaniosis",
        "@gcuencam",
        "@aitorGaleano",
        "@ramonCapitan",
        "@celiaGaspar",
        "@carlaNavarro",
        "@montserratDelValle"
      ],
      "tags": [
        "dubstep",
        "music",
        "electronic"
      ]
    }
  ],
  "last": false,
  "totalPages": 5,
  "totalElements": 46,
  "size": 10,
  "number": 2,
  "sort": [
    {
      "direction": "DESC",
      "property": "date",
      "ignoreCase": false,
      "nullHandling": "NATIVE",
      "ascending": false,
      "descending": true
    }
  ],
  "first": false,
  "numberOfElements": 10
}
```
- POST (/list/page) -> Lista de publicaciones filtradas por la página indicada. Entradas: String filter, String tags.
- POST (/list) -> Lista de publicaciones filtrada. Entradas: String filter, String tags.
- GET (/id) -> Publicación específica.
```
{
  "id": 1,
  "title": "Amor bajo la lluvia",
  "description": "Boda Juan y Elena",
  "media": "<img  class=\"img-responsive\" src=\"/files/gallery1.jpg\">",
  "media_type": 0,
  "date": 1491236378000,
  "stringDate": "Publicado el 03/04/2017 a las 18:19",
  "num_visits": 0,
  "numberOfLikes": 0,
  "numberOfComments": 0,
  "user": "@juan",
  "comments": [],
  "likes": [],
  "tags": []
}
```
### Users
/api/user

- GET (/) -> Lista de usuarios.
```
[
  {
    "id": 1,
    "username": "emilio",
    "name": "Emilio",
    "surname": "Delgado",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide4.png",
    "visits": 0,
    "signInDate": 1491236374000,
    "likes": [],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [
      "@juan"
    ],
    "followers": [
      "@juan"
    ],
    "groups": [
      "Rap Femenino"
    ],
    "publications": [
      "Lisístrata",
      "Epiclesis",
      "Red dragon",
      "Forbidden Kingdom",
      "Sibelius Violin Concerto 1st Movement",
      "Yiruma - River Flows in You",
      "LaLa Land movie Theme",
      "Asylum",
      "Triple concerto",
      "Rogue One Trailer",
      "NORWAY",
      "Alone in the Night"
    ]
  },
  {
    "id": 2,
    "username": "concha",
    "name": "Concha",
    "surname": "García",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide1.png",
    "visits": 0,
    "signInDate": 1491236374000,
    "likes": [],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [
      "@juan"
    ],
    "followers": [],
    "groups": [
      "Rap Femenino"
    ],
    "publications": [
      "ANCIENT GOD",
      "Chinese Dragon",
      "Dragon Cove",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Fur Elise",
      "Bullet Train",
      "Faded",
      "America's Great Spaces",
      "Street Traffic",
      "Fat Animated Short Film"
    ]
  },
  {
    "id": 3,
    "username": "juan",
    "name": "Juan",
    "surname": "Cuesta",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide2.png",
    "visits": 0,
    "signInDate": 1491236375000,
    "likes": [],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [
      "Amor bajo la lluvia",
      "La simetría y la comida",
      "Destellos del futuro permanente",
      "El punto de mira",
      "¿Quién está ahí?",
      "Amor bajo la lluvia",
      "La simetría y la comida",
      "Destellos del futuro permanente",
      "El punto de mira",
      "¿Quién está ahí?"
    ],
    "comments": [
      "@concha:Váyase señor Juan!!"
    ],
    "following": [
      "@emilio",
      "@nexmaniosis",
      "@gcuencam",
      "@celiaGaspar",
      "@mRosarioAyala"
    ],
    "followers": [
      "@emilio",
      "@concha"
    ],
    "groups": [
      "Rap Femenino"
    ],
    "publications": [
      "Amor bajo la lluvia",
      "La simetría y la comida",
      "Destellos del futuro permanente",
      "El punto de mira",
      "¿Quién está ahí?",
      "Amor bajo la lluvia",
      "La simetría y la comida",
      "Destellos del futuro permanente",
      "El punto de mira",
      "¿Quién está ahí?",
      "Werewolf",
      "Angelus of Hope",
      "Chopin Nocturne in F Minor-Op. 55",
      "Mozart: Concerto for Piano no 25",
      "Beethoven - Moonlight Sonata",
      "Mortal Kombat Dance",
      "Hysteria",
      "Reload ",
      "The Greatest",
      "See You Again",
      "The Force Awakens Trailer",
      "The magnificent landscape of Iceland",
      "POILUS Short Film"
    ]
  },
  {
    "id": 4,
    "username": "user0",
    "name": "name0",
    "surname": "surname0",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236375000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 5,
    "username": "user1",
    "name": "name1",
    "surname": "surname1",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236375000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 6,
    "username": "user2",
    "name": "name2",
    "surname": "surname2",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236375000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 7,
    "username": "user3",
    "name": "name3",
    "surname": "surname3",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236375000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 8,
    "username": "user4",
    "name": "name4",
    "surname": "surname4",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 9,
    "username": "user5",
    "name": "name5",
    "surname": "surname5",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 10,
    "username": "user6",
    "name": "name6",
    "surname": "surname6",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 11,
    "username": "user7",
    "name": "name7",
    "surname": "surname7",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 12,
    "username": "user8",
    "name": "name8",
    "surname": "surname8",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 13,
    "username": "user9",
    "name": "name9",
    "surname": "surname9",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 14,
    "username": "user10",
    "name": "name10",
    "surname": "surname10",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 15,
    "username": "user11",
    "name": "name11",
    "surname": "surname11",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236376000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 16,
    "username": "user12",
    "name": "name12",
    "surname": "surname12",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 17,
    "username": "user13",
    "name": "name13",
    "surname": "surname13",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 18,
    "username": "user14",
    "name": "name14",
    "surname": "surname14",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 19,
    "username": "user15",
    "name": "name15",
    "surname": "surname15",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 20,
    "username": "user16",
    "name": "name16",
    "surname": "surname16",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 21,
    "username": "user17",
    "name": "name17",
    "surname": "surname17",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 22,
    "username": "user18",
    "name": "name18",
    "surname": "surname18",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 23,
    "username": "user19",
    "name": "name19",
    "surname": "surname19",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 24,
    "username": "user20",
    "name": "name20",
    "surname": "surname20",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236377000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 25,
    "username": "user21",
    "name": "name21",
    "surname": "surname21",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 26,
    "username": "user22",
    "name": "name22",
    "surname": "surname22",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 27,
    "username": "user23",
    "name": "name23",
    "surname": "surname23",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 28,
    "username": "user24",
    "name": "name24",
    "surname": "surname24",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 29,
    "username": "usuario1",
    "name": "prueba",
    "surname": "prueba",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "ROLE_USER",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [],
    "roles": [],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 30,
    "username": "m0scar",
    "name": "Oscar",
    "surname": "Ballesteros",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide4.png",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [
      "Lisístrata",
      "ANCIENT GOD",
      "Werewolf",
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Dragon Cove",
      "Forbidden Kingdom",
      "Angelus of Hope",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "Sibelius Violin Concerto 1st Movement",
      "300 Violin Orchestra",
      "Mozart: Concerto for Piano no 25",
      "Yiruma - River Flows in You",
      "Beethoven - Moonlight Sonata",
      "Fur Elise",
      "LaLa Land movie Theme",
      "Bullet Train",
      "Asylum",
      "Mortal Kombat Dance",
      "Hysteria",
      "Reload ",
      "Triple concerto",
      "The Greatest",
      "Faded",
      "See You Again",
      "Rogue One Trailer",
      "The Force Awakens Trailer",
      "America's Great Spaces",
      "NORWAY",
      "Street Traffic",
      "The magnificent landscape of Iceland",
      "Alone in the Night",
      "POILUS Short Film",
      "Fat Animated Short Film"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 31,
    "username": "nexmaniosis",
    "name": "Pablo",
    "surname": "Rivero",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-tech-guy.png",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [
      "Lisístrata",
      "ANCIENT GOD",
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Dragon Cove",
      "Forbidden Kingdom",
      "Angelus of Hope",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Yiruma - River Flows in You",
      "Beethoven - Moonlight Sonata",
      "LaLa Land movie Theme",
      "Bullet Train",
      "Asylum",
      "Mortal Kombat Dance",
      "Hysteria",
      "Reload ",
      "Triple concerto",
      "Faded",
      "See You Again",
      "The Force Awakens Trailer",
      "America's Great Spaces",
      "NORWAY",
      "Street Traffic",
      "The magnificent landscape of Iceland",
      "Alone in the Night",
      "POILUS Short Film",
      "Fat Animated Short Film"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [
      "@juan"
    ],
    "groups": [],
    "publications": []
  },
  {
    "id": 32,
    "username": "gcuencam",
    "name": "Gabriel",
    "surname": "Cuenca",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide2.png",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [
      "Lisístrata",
      "ANCIENT GOD",
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Dragon Cove",
      "Angelus of Hope",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Yiruma - River Flows in You",
      "Beethoven - Moonlight Sonata",
      "LaLa Land movie Theme",
      "Asylum",
      "Mortal Kombat Dance",
      "Hysteria",
      "Reload ",
      "Triple concerto",
      "Faded",
      "See You Again",
      "The Force Awakens Trailer",
      "America's Great Spaces",
      "NORWAY",
      "Street Traffic",
      "The magnificent landscape of Iceland",
      "Alone in the Night",
      "POILUS Short Film",
      "Fat Animated Short Film"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [
      "@juan"
    ],
    "groups": [],
    "publications": []
  },
  {
    "id": 33,
    "username": "aitorGaleano",
    "name": "Aitor",
    "surname": "Galeano",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://www.tm-town.com/assets/default_male600x600-79218392a28f78af249216e097aaf683.png",
    "visits": 0,
    "signInDate": 1491236378000,
    "likes": [
      "Lisístrata",
      "ANCIENT GOD",
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Angelus of Hope",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "LaLa Land movie Theme",
      "Asylum",
      "Hysteria",
      "Triple concerto",
      "Faded",
      "See You Again",
      "The Force Awakens Trailer",
      "America's Great Spaces",
      "NORWAY",
      "Street Traffic",
      "The magnificent landscape of Iceland",
      "Alone in the Night",
      "POILUS Short Film",
      "Fat Animated Short Film"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 34,
    "username": "ramonCapitan",
    "name": "Ramón",
    "surname": "Capitán",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide4.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Angelus of Hope",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "Asylum",
      "Hysteria",
      "Triple concerto",
      "Faded",
      "The Force Awakens Trailer",
      "America's Great Spaces",
      "NORWAY",
      "The magnificent landscape of Iceland",
      "Alone in the Night",
      "Fat Animated Short Film"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 35,
    "username": "celiaGaspar",
    "name": "Celia",
    "surname": "Gaspar",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://bootdey.com/img/Content/avatar/avatar3.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "Asylum",
      "Hysteria",
      "Triple concerto",
      "Faded",
      "The Force Awakens Trailer",
      "America's Great Spaces",
      "NORWAY",
      "Alone in the Night",
      "Fat Animated Short Film"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [
      "@juan"
    ],
    "groups": [],
    "publications": []
  },
  {
    "id": 36,
    "username": "carlaNavarro",
    "name": "Carla",
    "surname": "Navarro",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide1.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "Asylum",
      "Hysteria",
      "Triple concerto",
      "Faded",
      "NORWAY",
      "Alone in the Night"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 37,
    "username": "montserratDelValle",
    "name": "Monstserrat",
    "surname": "Del Valle",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://bootdey.com/img/Content/avatar/avatar3.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Chinese Dragon",
      "Red dragon",
      "Cant Forgive",
      "Chopin Nocturne in F Minor-Op. 55",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "Asylum",
      "Hysteria",
      "Triple concerto",
      "Faded",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 38,
    "username": "mRosarioAyala",
    "name": "María Rosario",
    "surname": "Ayala",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide1.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Red dragon",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "Hysteria",
      "Triple concerto",
      "Faded",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [
      "@juan"
    ],
    "groups": [],
    "publications": []
  },
  {
    "id": 39,
    "username": "nataliaTorras",
    "name": "Natalia",
    "surname": "Torras",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide1.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Red dragon",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "Faded",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 40,
    "username": "joseMariaNieves",
    "name": "José María",
    "surname": "Nieves",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide2.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Red dragon",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 41,
    "username": "ismaelMoreno",
    "name": "Ismael",
    "surname": "Moreno",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide4.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Red dragon",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 42,
    "username": "albertMesa",
    "name": "Albert",
    "surname": "Mesa",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-tech-guy.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 43,
    "username": "hugoPariente",
    "name": "Hugo",
    "surname": "Pariente",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide4.png",
    "visits": 0,
    "signInDate": 1491236379000,
    "likes": [
      "Epiclesis",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 44,
    "username": "vicenteGuash",
    "name": "Vicente",
    "surname": "Guash",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-tech-guy.png",
    "visits": 0,
    "signInDate": 1491236380000,
    "likes": [
      "Epiclesis",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 45,
    "username": "consueloCasas",
    "name": "Consuelo",
    "surname": "Casas",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://bootdey.com/img/Content/avatar/avatar3.png",
    "visits": 0,
    "signInDate": 1491236380000,
    "likes": [
      "Epiclesis",
      "Cant Forgive",
      "300 Violin Orchestra",
      "Beethoven - Moonlight Sonata",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 46,
    "username": "cristinaCrespo",
    "name": "Cristina",
    "surname": "Crespo",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "https://pickaface.net/assets/images/slides/slide1.png",
    "visits": 0,
    "signInDate": 1491236380000,
    "likes": [
      "Epiclesis",
      "Cant Forgive",
      "300 Violin Orchestra",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  },
  {
    "id": 47,
    "username": "pilarGarzon",
    "name": "Pilar",
    "surname": "Garzón",
    "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
    "img": "http://bootdey.com/img/Content/avatar/avatar3.png",
    "visits": 0,
    "signInDate": 1491236380000,
    "likes": [
      "Epiclesis",
      "Cant Forgive",
      "300 Violin Orchestra",
      "NORWAY"
    ],
    "roles": [
      "ROLE_USER"
    ],
    "gallery": [],
    "comments": [],
    "following": [],
    "followers": [],
    "groups": [],
    "publications": []
  }
]
```
- GET (/id) -> Usuario específico.
```
{
  "id": 3,
  "username": "juan",
  "name": "Juan",
  "surname": "Cuesta",
  "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
  "img": "https://pickaface.net/assets/images/slides/slide2.png",
  "visits": 0,
  "signInDate": 1491236375000,
  "likes": [],
  "roles": [
    "ROLE_USER"
  ],
  "gallery": [
    "Amor bajo la lluvia",
    "La simetría y la comida",
    "Destellos del futuro permanente",
    "El punto de mira",
    "¿Quién está ahí?",
    "Amor bajo la lluvia",
    "La simetría y la comida",
    "Destellos del futuro permanente",
    "El punto de mira",
    "¿Quién está ahí?"
  ],
  "comments": [
    "@concha:Váyase señor Juan!!"
  ],
  "following": [
    "@emilio",
    "@nexmaniosis",
    "@gcuencam",
    "@celiaGaspar",
    "@mRosarioAyala"
  ],
  "followers": [
    "@emilio",
    "@concha"
  ],
  "groups": [
    "Rap Femenino"
  ],
  "publications": [
    "Amor bajo la lluvia",
    "La simetría y la comida",
    "Destellos del futuro permanente",
    "El punto de mira",
    "¿Quién está ahí?",
    "Amor bajo la lluvia",
    "La simetría y la comida",
    "Destellos del futuro permanente",
    "El punto de mira",
    "¿Quién está ahí?",
    "Werewolf",
    "Angelus of Hope",
    "Chopin Nocturne in F Minor-Op. 55",
    "Mozart: Concerto for Piano no 25",
    "Beethoven - Moonlight Sonata",
    "Mortal Kombat Dance",
    "Hysteria",
    "Reload ",
    "The Greatest",
    "See You Again",
    "The Force Awakens Trailer",
    "The magnificent landscape of Iceland",
    "POILUS Short Film"
  ]
}
```
- GET (/usuario2/follow) -> Usuario 1 sigue a Usuario 2.
- GET (/usuario2/unfollow) -> Usuario 1 deja de seguir a Usuario 2.
- POST (/new) -> Nuevo usuario. Entrada: String username, String name, String surname, String password.
```
{
  "id": 48,
  "username": "username",
  "name": "name",
  "surname": "surname",
  "description": "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil",
  "img": "http://s3.amazonaws.com/37assets/svn/765-default-avatar.png",
  "visits": 0,
  "signInDate": 1491238197969,
  "likes": [],
  "roles": [
    "ROLE_USER"
  ],
  "gallery": [],
  "comments": [],
  "following": [],
  "followers": [],
  "groups": [],
  "publications": []
}
```
- POST (/idpublication) -> Nuevo comentario. Entrada: String comentario.

### Upload
/api/upload

- POST (/) -> Subimos un archivo mulimedia. Entradas: Object media, String title, String title, String description, String tags, String type, long idGroup. Salida: BAD_REQUEST si no se ha podido subir.
