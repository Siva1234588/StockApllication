FROM openjdk
COPY target/*.jar /
EXPOSE 9001
ENTRYPOINT ["java","-jar","/stockpricesapp-0.0.1-SNAPSHOT.jar"]
ENV spring.datasource.url=jdbc:mysql://stockapp.churpiutuhbc.ap-northeast-1.rds.amazonaws.com:3306/stockapp