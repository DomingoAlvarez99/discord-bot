package org.dalvarez.jdaexample;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.dalvarez.jdaexample.discord.DiscordManager;
import org.dalvarez.jdaexample.discord.channel.alert.DiscordAlertMessage;
import org.dalvarez.jdaexample.shared.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;

public final class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private static final String CF_LONG_NAME = "cf";

    private static final String CF_DESCRIPTION = "Configuration file";

    public static void main(String[] args) throws LoginException, InterruptedException, IOException, ParseException {
        Options options = new Options();
        Option cfOption = Option.builder()
                                .longOpt(CF_LONG_NAME)
                                .hasArg()
                                .required()
                                .desc(CF_DESCRIPTION)
                                .build();
        options.addOption(cfOption);
        CommandLineParser cmdParser = new DefaultParser();
        CommandLine cmd = cmdParser.parse(options, args);

        Arrays.stream(cmd.getOptions())
              .forEach(option -> log.info("- {}: {}", option.getDescription(), option.getValue()));

        AppManager discordManager = new DiscordManager(cmd.getOptionValue(CF_LONG_NAME));
        discordManager.getInfoAlertChannel()
                      .sendMessage(new DiscordAlertMessage(
                              Instant.now(),
                              "Batch",
                              "Description info",
                              "Error creating the operation"
                      ));
        discordManager.getWarningAlertChannel()
                      .sendMessage(new DiscordAlertMessage(
                              Instant.now(),
                              "Batch",
                              "Description warning",
                              "Error creating the operation"
                      ));
        discordManager.getErrorAlertChannel()
                      .sendMessage(new DiscordAlertMessage(
                              Instant.now(),
                              "Batch",
                              "Description error",
                              null
                      ));
    }

}
