FROM openjdk:11.0.7-jdk-slim AS build

WORKDIR /app
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle.kts .
COPY gradlew .
RUN ./gradlew build --refresh-dependencies

COPY . .

RUN ./gradlew shadowJar

FROM openjdk:11.0.7-jre-slim AS livraria-lello

WORKDIR /app
COPY key.jks .
COPY --from=build /app/build/libs/livrariaLello.jar .

CMD ["java", "-cp", "livrariaLello.jar", "com.santynu.livraria_lello.AppKt"]