package tech.erudo.mc.discord.discordbotplugin.discord.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.erudo.mc.discord.discordbotplugin.discord.command.CommandManager;
import tech.erudo.mc.discord.discordbotplugin.util.MessageManager;

public class ChatListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        String msg = e.getMessage().getContentRaw();

        //BOTのコマンドを設定
        CommandManager botCommandManager = new CommandManager(e);

        if(!e.getAuthor().isBot()) {//メッセージ送信者がBOTじゃなかったら
            if(msg.toLowerCase().startsWith("!")) {//!から始まる＝＞コマンド
                int length = msg.toLowerCase().length();
                String cmd = msg.toLowerCase().toLowerCase().substring(1,length);

                botCommandManager.execute(cmd);
                System.out.println("\"" + cmd + "\" command executed");

            } else {
                MessageManager.sendAll(e.getAuthor().getName(),msg);
            }
        }
    }
}
