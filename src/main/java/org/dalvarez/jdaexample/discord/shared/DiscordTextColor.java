package org.dalvarez.jdaexample.discord.shared;

import java.awt.*;

public enum DiscordTextColor {

    INFO(Color.CYAN),
    WARNING(Color.ORANGE),
    ERROR(Color.RED);

    private final Color value;

    DiscordTextColor(final Color value) {
        this.value = value;
    }

    public Color getValue() {
        return value;
    }

}
