FROM openjdk:latest
EXPOSE 8400
COPY /target/src /src
ADD /target/boart-0.0.1-SNAPSHOT.jar boartBack.jar
CMD ["java", "-jar", "boartBack.jar"]
