FROM openjdk:11-jre-slim-buster

LABEL maintainerName="Filipe Pinheiro"

LABEL maintainerEmail="filipe.pinheiro@servexternos.isban.pt"

ENV ENVIRONMENT dev

# Create working dir
RUN mkdir -p /opt/spring-boot-api/
WORKDIR /opt/spring-boot-api/

# Copy  and rename jar file
COPY target/*.jar .
COPY scripts/*.sh .
RUN chmod +x rename-jar.sh
RUN ./rename-jar.sh

# Start webapp
CMD java -Dspring.profiles.active=$ENVIRONMENT -jar webapp.jar

