#!/bin/bash
mvn clean install
java -jar target/notes-0.0.1-SNAPSHOT.jar server src/main/resources/stupid.yml