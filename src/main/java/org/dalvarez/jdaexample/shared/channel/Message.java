package org.dalvarez.jdaexample.shared.channel;

public interface Message<C> {

    String getTitle();

    String getDescription();

    C getDiscordTextColor();

}
