# java-springboot-api
Backend do webservice de clientes

Projeto utilizado para apresentar os conceitos de SpringBoot. Ver o ficheiro doc/check-list.txt 

Deploy no AWS ECS/Fargate

# Build Maven
mvn "-Dspring.profiles.active=dev" clean package

# Build
docker image build -t 204040696103.dkr.ecr.eu-west-2.amazonaws.com/java-springboot-api:0.0.1-SNAPSHOT .

`Before building check The End of Line Sequence of the file rename-jar.sh. It must be LF, not CRLF.`

# List Local Docker Images
docker image ls

# Run Docker Container
docker container run --rm -d -p 8089:8089 -e ENVIRONMENT=dev --name java-springboot-api 204040696103.dkr.ecr.eu-west-2.amazonaws.com/java-springboot-api:0.0.1-SNAPSHOT

# List Local Container
docker container ls

# Stop Local Container
docker container stop ContainerIDPrefix