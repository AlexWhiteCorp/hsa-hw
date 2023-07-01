FROM openjdk:17-alpine

ENV JAVA_MINIMAL=/opt/jre
ENV PATH="$PATH:$JAVA_MINIMAL/bin"

COPY target/book-search-service-*.jar app.jar

EXPOSE 8080:8080

ENTRYPOINT java -jar /app.jar