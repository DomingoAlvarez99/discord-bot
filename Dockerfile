FROM maven:3.8.3-openjdk-11

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean compile assembly:single

ARG JAR_FILE=target/*.jar
ARG CONFIG_FILE
ARG INTERNAL_CONFIG_FILE_DIR=./resources
ARG INTERNAL_CONFIG_FILE=${INTERNAL_CONFIG_FILE_DIR}/config.yml
COPY ${CONFIG_FILE} ${INTERNAL_CONFIG_FILE}

RUN java -jar ${JAR_FILE} \
    -cf ${INTERNAL_CONFIG_FILE}