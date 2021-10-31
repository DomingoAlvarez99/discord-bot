package org.dalvarez.jdaexample.shared.channel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public abstract class PropertyReader<T> {

    protected final Class<T> clazz;

    protected PropertyReader(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public T read(String filePath) {
        File file = new File(filePath);
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        try {
            return om.readValue(file, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
