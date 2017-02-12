CREATE TABLE publicacion (
	id int NOT NULL AUTO_INCREMENT,
	autor varchar(50) NOT NULL,
	titulo varchar(255) NOT NULL,
	descripcion text,
	media varchar(255) NOT NULL,
	tipo_media int NOT NULL,
	fecha_publicacion DATETIME NOT NULL,
	num_visitas int NOT NULL DEFAULT '0',
	PRIMARY KEY (id)
);

CREATE TABLE usuario (
	nombre_usuario varchar(50) NOT NULL,
	nombre_real varchar(50) NOT NULL,
	apellidos varchar(50) NOT NULL,
	contraseña varchar(25) NOT NULL,
	img_perfil varchar(255),
	num_visitas int NOT NULL DEFAULT '0',
	nivel_privilegios int NOT NULL DEFAULT '0',
	fecha_registro DATETIME NOT NULL,
	fecha_lastlogin DATETIME NOT NULL,
	PRIMARY KEY (nombre_usuario)
);

CREATE TABLE likes (
	nombre_usuario varchar(50) NOT NULL,
	id_publicacion int NOT NULL,
	PRIMARY KEY (nombre_usuario,id_publicacion)
);

CREATE TABLE rrss_usuario (
	red_social varchar(25) NOT NULL,
    nombre_en_rs varchar(50) NOT NULL,
	nombre_usuario varchar(50) NOT NULL,
	PRIMARY KEY (red_social,nombre_usuario)
);

CREATE TABLE grupo (
	id int NOT NULL AUTO_INCREMENT,
	titulo varchar(255) NOT NULL,
	descripcion TEXT NOT NULL,
	img_perfil varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE publicacion_grupo (
	id_publicacion int NOT NULL,
	id_grupo int NOT NULL,
	fecha_compartido DATETIME NOT NULL,
	PRIMARY KEY (id_publicacion,id_grupo)
);

CREATE TABLE tags (
	id_publicacion int NOT NULL,
	tag varchar(50) NOT NULL,
	fecha_tag DATETIME NOT NULL,
	PRIMARY KEY (id_publicacion,tag)
);

CREATE TABLE miembro_grupo (
	nombre_usuario varchar(50) NOT NULL,
	id_grupo int NOT NULL,
	nivel_privilegio int NOT NULL,
	fecha_union DATETIME NOT NULL,
	PRIMARY KEY (nombre_usuario,id_grupo)
);

CREATE TABLE comentario (
	nombre_usuario varchar(50) NOT NULL,
	comentario TEXT NOT NULL,
	fecha_publicacion DATE NOT NULL,
	tipo_destino int NOT NULL,
	id_destino int NOT NULL,
	PRIMARY KEY (nombre_usuario)
);

CREATE TABLE galeria (
	nombre_usuario varchar(50) NOT NULL,
	url_imagen varchar(255) NOT NULL,
	titulo_imagen varchar(255),
	fecha_publicacion DATETIME
);

CREATE TABLE usuario_usuario (
	usuario_seguidor varchar(50) NOT NULL,
	usuario_seguido varchar(50) NOT NULL,
	PRIMARY KEY (usuario_seguidor,usuario_seguido)
);

ALTER TABLE publicacion ADD CONSTRAINT publicacion_fk0 FOREIGN KEY (autor) REFERENCES usuario(nombre_usuario);

ALTER TABLE likes ADD CONSTRAINT likes_fk0 FOREIGN KEY (nombre_usuario) REFERENCES usuario(nombre_usuario);

ALTER TABLE likes ADD CONSTRAINT likes_fk1 FOREIGN KEY (id_publicacion) REFERENCES publicacion(id);

ALTER TABLE rrss_usuario ADD CONSTRAINT rrss_usuario_fk0 FOREIGN KEY (nombre_usuario) REFERENCES usuario(nombre_usuario);

ALTER TABLE publicacion_grupo ADD CONSTRAINT publicacion_grupo_fk0 FOREIGN KEY (id_publicacion) REFERENCES publicacion(id);

ALTER TABLE publicacion_grupo ADD CONSTRAINT publicacion_grupo_fk1 FOREIGN KEY (id_grupo) REFERENCES grupo(id);

ALTER TABLE tags ADD CONSTRAINT tags_fk0 FOREIGN KEY (id_publicacion) REFERENCES publicacion(id);

ALTER TABLE miembro_grupo ADD CONSTRAINT miembro_grupo_fk0 FOREIGN KEY (nombre_usuario) REFERENCES usuario(nombre_usuario);

ALTER TABLE miembro_grupo ADD CONSTRAINT miembro_grupo_fk1 FOREIGN KEY (id_grupo) REFERENCES grupo(id);

ALTER TABLE comentario ADD CONSTRAINT comentario_fk0 FOREIGN KEY (nombre_usuario) REFERENCES usuario(nombre_usuario);

ALTER TABLE galeria ADD CONSTRAINT galeria_fk0 FOREIGN KEY (nombre_usuario) REFERENCES usuario(nombre_usuario);

ALTER TABLE usuario_usuario ADD CONSTRAINT usuario_usuario_fk0 FOREIGN KEY (usuario_seguidor) REFERENCES usuario(nombre_usuario);

ALTER TABLE usuario_usuario ADD CONSTRAINT usuario_usuario_fk1 FOREIGN KEY (usuario_seguido) REFERENCES usuario(nombre_usuario);

INSERT INTO usuario (nombre_usuario,nombre_real,apellidos,contraseña,img_perfil,nivel_privilegios, fecha_registro, fecha_lastlogin)
VALUES ('m0scar','Oscar','Ballesteros Izquierdo','****','/assets/m0scar.png',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO publicacion (autor,titulo,descripcion,media,tipo_media, fecha_publicacion) 
VALUES ('m0scar','El ruedo de MTZ','Centro cultural del barrio', '/assets/elruedo.png', 1, CURRENT_TIMESTAMP);

INSERT INTO likes (nombre_usuario,id_publicacion)
VALUES ('m0scar',1);

INSERT INTO rrss_usuario(red_social,nombre_en_rs,nombre_usuario)
VALUES ('twitter', '@m0scar', 'm0scar');

INSERT INTO grupo(titulo,descripcion,img_perfil)
VALUES ('Fotografos de MTZ', 'Fotografos de MTZ', '/assets/mtz.png');

INSERT INTO publicacion_grupo(id_publicacion,id_grupo,fecha_compartido)
VALUES (1,1,CURRENT_TIMESTAMP);

INSERT INTO tags (id_publicacion,tag,fecha_tag)
VALUES (1,'moratalaz',CURRENT_TIMESTAMP);

INSERT INTO miembro_grupo (nombre_usuario, id_grupo, nivel_privilegio, fecha_union)
VALUES ('m0scar',1,0,CURRENT_TIMESTAMP);

INSERT INTO comentario (nombre_usuario, comentario, fecha_publicacion,tipo_destino,id_destino)
VALUES ('m0scar', 'Viva el hood', CURRENT_TIMESTAMP, 1, 1);

INSERT INTO galeria (nombre_usuario,url_imagen,titulo_imagen)
VALUES ('m0scar', '/assets/mtz.png', 'M.O. Moratalaz');

INSERT INTO usuario (nombre_usuario,nombre_real,apellidos,contraseña,img_perfil,nivel_privilegios, fecha_registro, fecha_lastlogin)
VALUES ('coletaMorada', 'Pablo', 'Iglesias','****','/assets/podemos.png',0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO usuario_usuario (usuario_seguidor, usuario_seguido)
VALUES ('m0scar','coletaMorada');