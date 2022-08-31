FROM openjdk:11.0.7-jdk-slim AS build

RUN apt-get update && apt-get install -y curl wget
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash
RUN apt-get install -y nodejs

WORKDIR /app/webapp
COPY webapp/package.json package.json
RUN npm install

WORKDIR /app
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle.kts .
COPY gradlew .
RUN ./gradlew build --refresh-dependencies

COPY . .
RUN cd webapp && npm run build-prod
RUN ./gradlew shadowJar

FROM openjdk:11.0.7-jre-slim AS livraria-lello

WORKDIR /app
COPY --from=build /app/build/libs/livrariaLello.jar .

CMD ["java", "-cp", "livrariaLello.jar", "com.santynu.livraria_lello.AppKt"]