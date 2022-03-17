package tech.erudo.mc.discord.discordbotplugin.discord.command.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.erudo.mc.discord.discordbotplugin.discord.command.Command;
import tech.erudo.mc.discord.discordbotplugin.util.MessageManager;

import java.util.Arrays;

public class ChatCommand implements Command {
    @Override
    public String name() {
        return "chat";
    }

    @Override
    public void execute(MessageReceivedEvent e, String[] args) {
        if(args.length != 0) {
            MessageManager.sendAll(Arrays.toString(args));
        }
    }
}
