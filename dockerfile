FROM openjdk:18
WORKDIR /app
COPY site1/entrypoint.sh entrypoint.sh
COPY site1/target/site1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9080
ENTRYPOINT ["/app/entrypoint.sh"]