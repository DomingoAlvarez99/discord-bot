package org.dalvarez.jdaexample.discord.channel;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import org.dalvarez.jdaexample.shared.channel.Channel;
import org.dalvarez.jdaexample.shared.channel.Message;

import java.awt.*;

public abstract class DiscordTextChannel<M extends Message<Color>> implements Channel<M> {

    private final TextChannel textChannel;

    private final String channelId;

    public DiscordTextChannel(final JDA javaDiscordApi,
                              final String channelId) {
        textChannel = javaDiscordApi.getTextChannelById(channelId);
        this.channelId = channelId;
    }

    @Override
    public void sendMessage(final M message) {
        if (!textChannel.canTalk())
            throw new IllegalStateException("Bot does not have permission to speak");

        final MessageEmbed messageEmbed = new EmbedBuilder()
                .setTitle(message.getTitle())
                .setDescription(message.getDescription())
                .setColor(message.getDiscordTextColor())
                .build();

        textChannel.sendMessageEmbeds(messageEmbed)
                   .queue();
    }

    @Override
    public String name() {
        return textChannel.getName();
    }

    public String getChannelId() {
        return channelId;
    }

}
