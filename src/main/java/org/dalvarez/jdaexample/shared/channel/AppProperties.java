package org.dalvarez.jdaexample.shared.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public abstract class AppProperties {

    @JsonProperty("channels")
    protected final List<AppProperties.Channel> channels;

    protected AppProperties() {
        channels = Collections.emptyList();
    }

    protected AppProperties(final List<AppProperties.Channel> channels) {
        this.channels = channels;
    }

    public AppProperties.Channel getChannel(AlertLevel alertLevel) {
        return channels.stream()
                       .filter(channel -> alertLevel.equals(AlertLevel.fromValue(channel.getName())))
                       .findFirst()
                       .orElseThrow(() -> new RuntimeException("Channel not found: name=" + alertLevel));
    }

    protected List<Channel> getChannels() {
        return channels;
    }

    public static class Channel {

        private String name;

        private String id;

        public Channel() {

        }

        public Channel(final String name,
                       final String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Channel{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

    }

}
