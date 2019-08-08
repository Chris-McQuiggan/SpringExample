FROM maven:latest AS maven

COPY . .

RUN mvn package

EXPOSE 8082

ENTRYPOINT java -jar /target/PrizeGen-0.0.1-SNAPSHOT.jar
