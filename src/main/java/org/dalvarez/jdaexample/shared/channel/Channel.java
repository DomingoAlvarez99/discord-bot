package org.dalvarez.jdaexample.shared.channel;

public interface Channel<M extends Message<?>> {

    void sendMessage(M message);

    String name();

}
