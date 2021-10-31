package org.dalvarez.jdaexample.shared.channel;

import java.time.Instant;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AlertMessage<TC> implements Message<TC> {

    private String title;

    private String description;

    private TC textColor;

    private final Instant date;

    private final String application;

    private final String message;

    private final String messageDescription;


    public AlertMessage(final Instant date,
                        final String application,
                        final String message,
                        final String messageDescription) {
        this.date = date;
        this.messageDescription = messageDescription;
        this.application = application;
        this.message = message;
    }

    public AlertMessage<TC> buildAndGetMessage(AlertLevel level,
                                               TC textColor) {
        setTitle(level);
        setDescription();
        this.textColor = textColor;
        return this;
    }

    private void setTitle(AlertLevel level) {
        title = String.format("%s [%s]", application, level);
    }

    private void setDescription() {
        String format = "Date: %s" + (Objects.nonNull(messageDescription) && !messageDescription.isBlank() ? "%nDescription: %s" : "") + "%nMessage: %s ";
        String[] args = Stream.of(date.toString(), messageDescription, message)
                              .filter(Objects::nonNull)
                              .filter(Predicate.not(String::isBlank))
                              .toArray(String[]::new);

        description = String.format(format, (Object[]) args);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public TC getDiscordTextColor() {
        return textColor;
    }

}
