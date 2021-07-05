FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8091
COPY build/libs/*.jar inventory-service.jar
ENTRYPOINT ["java","-jar","/inventory-service.jar"]