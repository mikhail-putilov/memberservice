FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    SLEEP=0 \
    JAVA_OPTS=""

# Add a testuser user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh testuser
WORKDIR /home/testuser

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown testuser:testuser entrypoint.sh
USER testuser

ADD *.war app.war

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080
