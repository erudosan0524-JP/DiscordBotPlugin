package tech.erudo.mc.discord.discordbotplugin.discord.command;

import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Stack;

public interface Command {
    String name();

    void execute(MessageReceivedEvent e, String[] args);
}
