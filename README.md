# Discord bot
> Este proyecto es un ejemplo de la integración de la librería ([JDA](https://github.com/DV8FromTheWorld/JDA)). Permite lanzar comandos, enviar mensajes a través de un canal...

## Requisitos
`Docker`

## Configuración y ejecución
1. Crear y configurar un bot
2. Añadir el bot a un servidor
3. Habilitar el modo desarrollador en discord para permitir obtener el id de los canales
4. Clonar el repositorio `> git clone https://github.com/DomingoAlvarez99/discord-bot.git`
5. Crear el fichero de configuración
  ```yml
  bot-token: ${TOKEN}
  channels:
    -   name: INFO
        id: ${INFO_CHANNEL_ID}
    -   name: WARNING
        id: ${WARNING_CHANNEL_ID}
    -   name: ERROR
        id: ${ERROR_CHANNEL_ID}
  ```
6. Ejecutar la aplicación `> bash run.sh ${FICHERO_CFG}`

### Lanzar comando de prueba
Desde un canal de texto del servidor. Escribir `> !ping`.
