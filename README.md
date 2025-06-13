# GL-Challenge (ES)
Ejercicio de Springboot para Global Logic. Se trata de un proyecto de Springboot hecho con maven y dos diagramas.

## Diagramas
Hace mucho que no hacía diagramas de este tipo, por lo que estoy un poco oxidado en este conocimiento.

## Proyecto de Springboot
Son dos requests de tipo POST. Una para registrarse en la app y otra para ingresar.

El proyecto usa Java 8, Springboot 2.5.14 y Maven. Se inicia con el servidor de Tomcat incorporado en Springboot.
Para utilizarlo sólo debes clonar el repo y usar el comando de Maven "mvn spring-boot:run"


Como era necesario usar JUnit intenté implementarlo en los controladores RESt pero fallé en el proceso. Por lo tanto, para probar la aplicación se debieran usar los siguientes JSONs.
El email tiene una validación para que mantenga su formato de email (correo@dominio.ccxx), mientras que la contraseña requiere exactamente 2 dígitos, 1 mayúscula y un largo entre 8 y 12 caracteres.

POST = "localhost:8080/sign-up"
{
    "name": "Admin",
    "email": "admin@domain.com",
    "password": "Password10",
    "phones": [
        {
            "number": 55555555,
            "cityCode": 9,
            "countryCode": "+56"
        }
    ]
}

Luego de registrarse, la contraseña será cifrada y se generará un token con JWT. Este token se mostrará en el response junto con los datos del usuario. Lo debemos usar si queremos probar el request de login.

POST = "localhost:8080/login"
{
    "token": "token-obtenido-al-registrarse"
}

Luego de usar el token para ingresar a la aplicación, este se renovará, por lo que no será el mismo.

# GL-Challenge (EN)
Springboot web exercise for Global Logic. It contains a Maven Springboot project & two diagrams.


## About the diagrams
It's been a long time since I made a diagram of this kind so I'm a bit rusty on its design.


## About the Springboot project
It consists in two POST requests. One for signing up & another for logging in.

This project runs with Java 8, Springboot 2.5.14 and Maven. It uses Springboot's embedded Tomcat server.
Just clone this project and use maven command "mvn spring-boot:run"


I tried to use JUnit to set some tests for the controllers but I failed, so if you want to test the controllers use the following JSONs as templates.
The email has a validation so it keeps an email format (mail@domain.ccxx), while the password only accepts 2 digits, 1 uppercase letter and its length must range between 8 & 12.



POST = "localhost:8080/sign-up"
{
    "name": "Admin",
    "email": "admin@domain.com",
    "password": "Password10",
    "phones": [
        {
            "number": 55555555,
            "cityCode": 9,
            "countryCode": "+56"
        }
    ]
}

After signing-up, the password will be encoded and a JWT token will be generated. This token will be displayed in the response. Use it to call the POST login.

POST = "localhost:8080/login"
{
    "token": "use-the-token-provided-by-the-sign-up"
}

After using the login POST call the token will renew.
