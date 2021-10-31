package org.dalvarez.jdaexample.discord.shared.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.dalvarez.jdaexample.shared.channel.AppProperties;

import java.util.List;

public final class DiscordProperties extends AppProperties {

    @JsonProperty("bot-token")
    private String botToken;

    public DiscordProperties() {

    }

    public DiscordProperties(final String botToken,
                             final List<Channel> channels) {
        super(channels);
        this.botToken = botToken;
    }

    public String getBotToken() {
        return botToken;
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "botToken='" + botToken + '\'' +
                ", channels=" + channels +
                '}';
    }

}
