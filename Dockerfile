FROM openjdk:8-jdk-alpine
# VOLUME /tmp
ADD target/test-1.0-SNAPSHOT.jar test.jar
ENV JAVA_OPTS=""
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /test.jar