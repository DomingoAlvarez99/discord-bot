package org.dalvarez.jdaexample.discord.channel.alert;

import net.dv8tion.jda.api.JDA;
import org.dalvarez.jdaexample.discord.shared.DiscordTextColor;
import org.dalvarez.jdaexample.discord.shared.properties.DiscordProperties;
import org.dalvarez.jdaexample.shared.channel.AlertLevel;

public final class DiscordErrorAlertChannel extends DiscordAlertChannel {

    private static final AlertLevel ERROR_LEVEL = AlertLevel.ERROR;

    public DiscordErrorAlertChannel(final JDA javaDiscordApi,
                                    final DiscordProperties appProperties) {
        super(
                javaDiscordApi,
                appProperties.getChannel(ERROR_LEVEL)
                             .getId()
        );
    }

    @Override
    public AlertLevel level() {
        return ERROR_LEVEL;
    }

    @Override
    public DiscordTextColor messageColor() {
        return DiscordTextColor.ERROR;
    }

}
