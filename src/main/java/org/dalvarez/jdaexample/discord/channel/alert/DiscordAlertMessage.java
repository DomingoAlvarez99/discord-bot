package org.dalvarez.jdaexample.discord.channel.alert;

import org.dalvarez.jdaexample.shared.channel.AlertMessage;

import java.awt.*;
import java.time.Instant;

public final class DiscordAlertMessage extends AlertMessage<Color> {

    public DiscordAlertMessage(final Instant date,
                               final String application,
                               final String message,
                               final String messageDescription) {
        super(date, application, message, messageDescription);
    }

}
