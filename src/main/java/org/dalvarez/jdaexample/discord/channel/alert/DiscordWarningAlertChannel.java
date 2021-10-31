package org.dalvarez.jdaexample.discord.channel.alert;

import net.dv8tion.jda.api.JDA;
import org.dalvarez.jdaexample.discord.shared.DiscordTextColor;
import org.dalvarez.jdaexample.discord.shared.properties.DiscordProperties;
import org.dalvarez.jdaexample.shared.channel.AlertLevel;

public final class DiscordWarningAlertChannel extends DiscordAlertChannel {

    private static final AlertLevel WARNING_LEVEL = AlertLevel.WARNING;

    public DiscordWarningAlertChannel(final JDA javaDiscordApi,
                                      final DiscordProperties appProperties) {
        super(
                javaDiscordApi,
                appProperties.getChannel(WARNING_LEVEL)
                             .getId()
        );
    }

    @Override
    public AlertLevel level() {
        return WARNING_LEVEL;
    }

    @Override
    public DiscordTextColor messageColor() {
        return DiscordTextColor.WARNING;
    }

}
