FROM --platform=linux/amd64 openjdk:17-alpine

ENV JAVA_MINIMAL=/opt/jre
ENV PATH="$PATH:$JAVA_MINIMAL/bin"

COPY target/google-analytics-integration-service-*.jar app.jar

RUN wget -O /dd-java-agent.jar https://dtdg.co/latest-java-tracer

EXPOSE 8080:8080

ENTRYPOINT java -javaagent:dd-java-agent.jar -Ddd.logs.injection=true -Ddd.service=google-analytics-integration-service -Ddd.env=local -jar /app.jar