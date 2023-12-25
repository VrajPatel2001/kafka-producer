FROM openjdk:17-oracle
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/producer-0.0.1-SNAPSHOT.jar producer.jar
EXPOSE 8001
# ENTRYPOINT exec java $JAVA_OPTS -jar producer.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar producer.jar
