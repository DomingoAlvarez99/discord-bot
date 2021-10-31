package org.dalvarez.jdaexample.shared;

import org.dalvarez.jdaexample.shared.channel.Channel;
import org.dalvarez.jdaexample.shared.channel.Message;

public interface AppManager {

    Channel<Message<?>> getInfoAlertChannel();

    Channel<Message<?>> getWarningAlertChannel();

    Channel<Message<?>> getErrorAlertChannel();

    Long getUsers();

    Long getBots();

}
