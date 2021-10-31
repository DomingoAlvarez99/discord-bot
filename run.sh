#!/bin/bash

CONFIG_FILE=$1

if [ ! -d "$CONFIG_FILE" ]; then
  RESOURCES_DIR=./src/main/resources
  CONFIG_FILE=$RESOURCES_DIR/config.yml
fi

docker build --rm \
  --build-arg CONFIG_FILE="$CONFIG_FILE" \
  -t discord_bot .

docker create --rm --name temp_discord_bot discord_bot