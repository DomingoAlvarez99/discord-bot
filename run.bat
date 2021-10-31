@echo off

set resources_dir=src/main/resources
set config_file=%resources_dir%/config.yml

docker build --rm ^
    --build-arg CONFIG_FILE=%config_file% ^
    -t discord_bot .

docker create --rm --name temp_discord_bot discord_bot

docker rm temp_discord_bot