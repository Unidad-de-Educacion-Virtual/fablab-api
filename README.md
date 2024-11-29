# ViveLab

## Repositorios

- [Frontend](https://github.com/juandavidafve/proyecto-web-frontend)
- [Backend](https://github.com/Guerrerod14Ufps/web2)

## Manual de Implementación

Es necesario crear un archivo .env en la raiz del proyecto. Puede tomar example.env como base.

```sh
cp example.env .env
```

### Con Docker

Si docker está instalado en el sistema, modifique el archivo .env para agregar las siguientes entradas

```
MYSQL_ROOT_PASSWORD=NotSecureRootPasswordChangeMe
MYSQL_USER=user
MYSQL_PASSWORD=NotSecurePasswordChangeMe
MYSQL_DATABASE=app
```

Y actualizar las siguientes

```
DATABASE_URL=jdbc:mysql://mysql:3306/app
DATABASE_USERNAME=user
DATABASE_PASSWORD=NotSecurePasswordChangeMe
SQL_INIT_MODE=always
JPA_HIBERNATE_DDL_AUTO=create
```

El archivo .env quedaria asi

```
DATABASE_URL=jdbc:mysql://mysql:3306/app
DATABASE_USERNAME=user
DATABASE_PASSWORD=NotSecurePasswordChangeMe

SQL_INIT_MODE=always
JPA_HIBERNATE_DDL_AUTO=create
JPA_HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect

JWT_SECRET_KEY=example
CORS_ALLOWED_ORIGINS=https://example.com,http://localhost:5173

MYSQL_ROOT_PASSWORD=NotSecureRootPasswordChangeMe
MYSQL_USER=user
MYSQL_PASSWORD=NotSecurePasswordChangeMe
MYSQL_DATABASE=app
```

Luego de haber modificado el archivo .env, hacer build del proyecto

```sh
docker compose build
```

Ahora se puede iniciar el proyecto con docker compose

```sh
docker compose up -d
```

Swagger se encuentra en la ubicación

- [http://localhost:8080/docs/swagger-ui/index.html](http://localhost:8080/docs/swagger-ui/index.html)

### De forma manual

Luego de haber creado el archivo .env, ejecutar la aplicación

```sh
./mvnw spring-boot:run
```
