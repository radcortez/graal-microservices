# Web App

This web application aims at showing how to use Microprofile JWT to secure your microservices.
It uses Apache TomEE as the default Microprofile implementation.

# OAuth2 + JWT (STS)

In order to work, this application requires an STS capable of generating signed JWT tokens.
We use Tribestream API Gateway as it's a complete Security Token Service.
It's also capable of doing routing and while enforcing permissions.
If you want to know more, check out the website at https://tribestream.io

The best and simplest way to start the API Gateway is to use Docker as follow

For Linux:
```
docker run --net="host" --rm -it --name tag -e LICENSE=accept -e CASSANDRA_EMBEDDED=true -p 8080:8080 tomitribe/tribestream-api-gateway:latest
```

For OSX and Windows:
```
docker run --rm -it --name tag -e LICENSE=accept -e CASSANDRA_EMBEDDED=true -p 8080:8080 tomitribe/tribestream-api-gateway:latest
```

Once the Tribestream API Gateway is up and running, you can connect to the console with the following URL
http://localhost:8080/tag/

# Load Tribestream API Gateway configuration
Once Tribestream API Gateway configuration is up and running, execute the following shell script available in this repository.
            /src/main/scripts/load-configuration.sh

# Start the movie chat application

Up on start up, the movie application will populate necessary data into the API Gateway.

```
mvn clean install -DskipTests tomee:run
```

It should start on port 8181 so it does not clash with the Gateway
So what you need is to open a browser and navigate to http://localhost:8181/moviefun/

There are 4 accounts created at startup
- alex/password with create, update and delete role

To run a full demo of Microprofile JWT using this application access: https://tribestream.io/guide/en/api-gateway/microservice-security-microprofile-jwt/current/
