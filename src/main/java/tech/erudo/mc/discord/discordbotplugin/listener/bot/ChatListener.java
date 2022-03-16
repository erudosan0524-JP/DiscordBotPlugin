package tech.erudo.mc.discord.discordbotplugin.listener.bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.erudo.mc.discord.discordbotplugin.util.MessageManager;

public class ChatListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String msg = e.getMessage().getContentRaw();

        if(!e.getAuthor().isBot()) {//メッセージ送信者がBOTじゃなかったら
            if(e.getMessage().toString().startsWith("!")) {//!から始まる＝＞コマンド
                int length = e.getMessage().toString().length();
                String cmd = e.getMessage().toString().substring(1,length);

            } else {
                MessageManager.sendAll(e.getAuthor().getName(),msg);
            }
        }
    }
}
