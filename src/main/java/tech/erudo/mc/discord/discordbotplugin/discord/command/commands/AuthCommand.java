package tech.erudo.mc.discord.discordbotplugin.discord.command.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import tech.erudo.mc.discord.discordbotplugin.discord.command.Command;
import tech.erudo.mc.discord.discordbotplugin.auth.AuthManager;

public class AuthCommand implements Command {
    @Override
    public String name() {
        return "auth";
    }

    @Override
    public void execute(MessageReceivedEvent e, String[] args) {
        TextChannel channel = e.getTextChannel();
        Member member = e.getMember();
        User user = member.getUser();
        String code = AuthManager.generateAuthCode(member);

        try {
            user.openPrivateChannel().complete()
                    .sendMessage("Your auth code is " + code).queue();
        } catch(ErrorResponseException ex) {
            channel.sendMessage("I can not open your private channel").queue();
        }
    }
}
