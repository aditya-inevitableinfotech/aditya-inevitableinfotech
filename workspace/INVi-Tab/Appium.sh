#!/usr/bin/bash

mvn test
mvn install
mvn clean install
mvn package
