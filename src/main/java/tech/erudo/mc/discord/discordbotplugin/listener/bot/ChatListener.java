package tech.erudo.mc.discord.discordbotplugin.listener.bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.erudo.mc.discord.discordbotplugin.util.MessageManager;

public class ChatListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String msg = e.getMessage().getContentRaw();

        if(!e.getAuthor().isBot()) {
            MessageManager.sendAll(e.getAuthor().getName(),msg);
        }
    }
}
