package org.dalvarez.jdaexample.discord.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Map;
import java.util.function.Consumer;

public final class OnCommandListener extends ListenerAdapter {

    private static final String COMMAND_START_REGEX = "^!";

    private static final String COMMAND_REGEX = COMMAND_START_REGEX + "(.+)?";

    private final Map<String, Consumer<MessageChannel>> commands = Map.of(
            "ping", this::pingCommandHandler
    );

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor()
                 .isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();

        if (isCommand(content))
            commands.getOrDefault(content.replaceFirst(COMMAND_START_REGEX, ""),
                                  messageChannel -> channel.sendMessage("Command not found")
                                                                         .queue()
            )
                    .accept(channel);
    }

    private boolean isCommand(String messageContent) {
        return messageContent.matches(COMMAND_REGEX);
    }

    private void pingCommandHandler(MessageChannel channel) {
        channel.sendMessage("Ping")
               .queue();
    }

}
