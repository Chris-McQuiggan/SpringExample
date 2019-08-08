
FROM maven:latest AS maven

COPY . .

RUN mvn package

EXPOSE 8084

ENTRYPOINT java -jar /target/BankExampleConsumer-0.0.1-SNAPSHOT.jar
