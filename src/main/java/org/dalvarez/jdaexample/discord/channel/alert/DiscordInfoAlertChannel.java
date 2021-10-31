package org.dalvarez.jdaexample.discord.channel.alert;

import net.dv8tion.jda.api.JDA;
import org.dalvarez.jdaexample.discord.shared.DiscordTextColor;
import org.dalvarez.jdaexample.discord.shared.properties.DiscordProperties;
import org.dalvarez.jdaexample.shared.channel.AlertLevel;

public final class DiscordInfoAlertChannel extends DiscordAlertChannel {

    private static final AlertLevel INFO_LEVEL = AlertLevel.INFO;

    public DiscordInfoAlertChannel(final JDA javaDiscordApi,
                                   final DiscordProperties appProperties) {
        super(
                javaDiscordApi,
                appProperties.getChannel(INFO_LEVEL)
                             .getId()
        );
    }

    @Override
    public DiscordTextColor messageColor() {
        return DiscordTextColor.INFO;
    }

    @Override
    public AlertLevel level() {
        return INFO_LEVEL;
    }

}
