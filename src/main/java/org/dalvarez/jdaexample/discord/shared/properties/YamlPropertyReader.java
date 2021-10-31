package org.dalvarez.jdaexample.discord.shared.properties;

import org.dalvarez.jdaexample.shared.channel.PropertyReader;

public final class YamlPropertyReader<T> extends PropertyReader<T> {

    public YamlPropertyReader(Class<T> clazz) {
        super(clazz);
    }

}
