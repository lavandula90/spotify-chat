#!/usr/bin/env bash
mvn clean package
java -jar target/spotify-chat-1.0-SNAPSHOT.jar server src/main/resources/spotifychat.yaml