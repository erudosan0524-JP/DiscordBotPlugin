package tech.erudo.mc.discord.discordbotplugin.command.bot;

import java.util.Stack;

public interface Command {
    String name();

    void execute();
}
