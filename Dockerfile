FROM openjdk
COPY target/*.jar /
EXPOSE 8004
ENTRYPOINT ["java","-jar","/stockpricesapp-0.0.1-SNAPSHOT.jar"]
ENV spring.datasource.url=jdbc:mysql://host.docker.internal:3306/stock-db