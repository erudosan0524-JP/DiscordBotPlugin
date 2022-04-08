package tech.erudo.mc.discord.discordbotplugin.discord.command.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.erudo.mc.discord.discordbotplugin.discord.command.Command;

public class LeaveCommand implements Command {
    @Override
    public String name() {
        return "leave";
    }

    @Override
    public void execute(MessageReceivedEvent e, String[] args) {

    }
}
