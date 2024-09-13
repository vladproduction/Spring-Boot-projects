# players-doc-api-swagger
## Project to show how work with Dockerfile, docker-compose.yml;
## Based on concepts:
-spring-boot project
-swagger ui
-mysql
-crud operations
-Dockerfile
-docker-compose.yml

## commands:
- Docker Desktop is up

- docker build -t dockerhub-username/image-name:latest . //based on Dockerfile

- docker push dockerhub-username/image-name:latest //pushing to docker repository

- vladbogdadocker/players-doc-api-swagger:latest //could see on Tags section

- docker-compose.yml (https://github.com/vladproduction/Spring/blob/main/players-doc-api-swagger/docker-compose.yml⁠⁠):

Ensure that docker-compose.yaml file is correctly configured to use the image just built;

- docker-compose up -d //up docker-compose file in detached mode

- verify Running Image on Docker Desktop

- follow link: http://localhost:8084/swagger-ui/index.html#⁠
 
