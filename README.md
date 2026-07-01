# API USER CRUD
Api prueba CRUD Clientes

## Descripcion

EL CRUD  Create , get User By Id , delete y Update para todo el proceso de registro o modificacion de algun usuario
## Getting Started

### Dependencias

* Es necesario el uso de Docker para poder consumir las imagenes docker de Mongo y de RabbitMQ para el correcto funcionamiento del microservicio

### Instalacion

* How/where to Get ,Git , Java 17 , Intelij Community Edition and Maven


### Ejecutar el programa

* How to run the program
```
By MVN 
or 
InteliJ Cumunitty
```


### Operaciones

* GET http://localhost:8082/user/{id}
  * No body
```
   http://localhost:8082/user/1235897

```

* POST http://localhost:8082/create
    * Body
```
{
    "userId": "1235897",
    "name": "dan",
    "aPaterno": "g",
    "aMaterno": "a",
    "email": "danielsg@g.com",
    "orders": [
        "23",
        "44",
        "888"
    ]
}
```

* PUT http://localhost:8082/userup
    * Body
```
{
        "userId": "1235897",
        "name": "dano",
        "aPaterno": "g",
        "aMaterno": "a",
        "email": "laboa@gmail.com",
        "orders": ["23","44","1234564532"]
    }
```

* Delete http://localhost:8082/userdel
    * Body
```
1235897
```

## Authors

Contributors names and contact info

ex. Sergio Granados 
ex. [sergio.daniel.granados@hotmail.com](sergio.daniel.granados@hotmail.com)

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Conocimientos

Recursos
* [Items](https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/items)
* [Pedidos](https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/pedidos)