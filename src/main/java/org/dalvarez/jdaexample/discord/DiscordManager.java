package org.dalvarez.jdaexample.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.dalvarez.jdaexample.discord.channel.alert.DiscordErrorAlertChannel;
import org.dalvarez.jdaexample.discord.channel.alert.DiscordInfoAlertChannel;
import org.dalvarez.jdaexample.discord.channel.alert.DiscordWarningAlertChannel;
import org.dalvarez.jdaexample.discord.listener.OnCommandListener;
import org.dalvarez.jdaexample.discord.shared.properties.DiscordProperties;
import org.dalvarez.jdaexample.discord.shared.properties.YamlPropertyReader;
import org.dalvarez.jdaexample.shared.AppManager;
import org.dalvarez.jdaexample.shared.channel.Channel;
import org.dalvarez.jdaexample.shared.channel.PropertyReader;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class DiscordManager implements AppManager {

    private final Channel<?> infoAlertsChannel;

    private final Channel<?> warningAlertsChannel;

    private final Channel<?> errorAlertsChannel;

    private final JDA javaDiscordApi;

    public DiscordManager(final String propertiesName) throws LoginException, InterruptedException, IOException {
        PropertyReader<DiscordProperties> ymlReader = new YamlPropertyReader<>(DiscordProperties.class);
        DiscordProperties appProperties = ymlReader.read(propertiesName);

        javaDiscordApi = JDABuilder.createDefault(appProperties.getBotToken())
                                   .setMemberCachePolicy(MemberCachePolicy.ALL)
                                   .enableIntents(GatewayIntent.GUILD_MEMBERS)
                                   .enableIntents(GatewayIntent.GUILD_PRESENCES)
                                   .setActivity(Activity.listening("events."))
                                   .setStatus(OnlineStatus.DO_NOT_DISTURB)
                                   .build();

        javaDiscordApi.addEventListener(new OnCommandListener());

        javaDiscordApi.awaitReady();

        infoAlertsChannel = new DiscordInfoAlertChannel(javaDiscordApi, appProperties);
        warningAlertsChannel = new DiscordWarningAlertChannel(javaDiscordApi, appProperties);
        errorAlertsChannel = new DiscordErrorAlertChannel(javaDiscordApi, appProperties);
    }

    @Override
    public Channel getInfoAlertChannel() {
        return infoAlertsChannel;
    }

    @Override
    public Channel getWarningAlertChannel() {
        return warningAlertsChannel;
    }

    @Override
    public Channel getErrorAlertChannel() {
        return errorAlertsChannel;
    }

    @Override
    public Long getUsers() {
        return users().stream()
                      .filter(Predicate.not(User::isBot))
                      .count();
    }

    @Override
    public Long getBots() {
        return users().stream()
                      .filter(User::isBot)
                      .count();
    }

    private List<User> users() {
        return javaDiscordApi.getGuilds()
                             .stream()
                             .flatMap(guild -> guild.getMembers()
                                                    .stream()
                                                    .map(Member::getUser))
                             .collect(Collectors.toList());
    }

}
