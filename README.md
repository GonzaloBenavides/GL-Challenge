# GL-Challenge
Springboot web exercise for Global Logic


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
