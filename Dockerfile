FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /src

COPY ./ /src

# build war file
RUN mvn clean package

# KAO WEI CHENG make, it's safe, don't worry
FROM jtr23455166/orange-tomcat:1.0

RUN mkdir /usr/local/apache-tomcat-10.1.16/webapps-javaee

WORKDIR /app

COPY --from=builder /src/target/*.war /usr/local/apache-tomcat-10.1.16/webapps-javaee/

EXPOSE 8080

CMD ["catalina.sh", "run"]