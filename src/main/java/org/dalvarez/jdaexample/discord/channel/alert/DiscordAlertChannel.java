package org.dalvarez.jdaexample.discord.channel.alert;

import net.dv8tion.jda.api.JDA;
import org.dalvarez.jdaexample.discord.channel.DiscordTextChannel;
import org.dalvarez.jdaexample.discord.shared.DiscordTextColor;
import org.dalvarez.jdaexample.shared.channel.AlertLevel;

public abstract class DiscordAlertChannel extends DiscordTextChannel<DiscordAlertMessage> {

    public DiscordAlertChannel(final JDA javaDiscordApi,
                               final String channelId) {
        super(javaDiscordApi, channelId);
    }

    public abstract AlertLevel level();

    public abstract DiscordTextColor messageColor();

    @Override
    public void sendMessage(final DiscordAlertMessage message) {
        super.sendMessage((DiscordAlertMessage) message.buildAndGetMessage(level(), messageColor().getValue()));
    }

}
