#!/bin/sh
mvn clean compile flyway:clean flyway:migrate -Dflyway.configFile=./src/main/webapp/WEB-INF/flyway.properties -P dev
