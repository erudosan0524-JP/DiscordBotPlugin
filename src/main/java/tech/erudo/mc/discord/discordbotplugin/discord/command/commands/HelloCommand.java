package tech.erudo.mc.discord.discordbotplugin.discord.command.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.erudo.mc.discord.discordbotplugin.discord.command.Command;

public class HelloCommand implements Command {

    @Override
    public String name() {
        return "hello";
    }

    @Override
    public void execute(MessageReceivedEvent e) {
        e.getTextChannel().sendMessage("Hello!").queue();
    }
}