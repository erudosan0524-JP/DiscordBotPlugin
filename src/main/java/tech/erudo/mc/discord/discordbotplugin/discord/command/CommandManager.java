package tech.erudo.mc.discord.discordbotplugin.discord.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.erudo.mc.discord.discordbotplugin.discord.command.commands.ChatCommand;
import tech.erudo.mc.discord.discordbotplugin.discord.command.commands.HelloCommand;
import tech.erudo.mc.discord.discordbotplugin.discord.command.commands.JoinCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class CommandManager {

    private Stack<Command> commands = new Stack<>();

    private MessageReceivedEvent event;

    public CommandManager(MessageReceivedEvent e) {
        this.event = e;
        this.setup();
    }

    private void setup() {
        append(new HelloCommand());
        append(new JoinCommand());
        append(new ChatCommand());
    }

    public void execute(String name) {
        String[] args = name.split(" "); //空白で文字を区切る
        if(args.length == 0) {
            System.err.println("[Discord] Command split ERROR");
            return;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(args));
        arrayList.remove(0);

        Iterator<Command> it = commands.iterator();
        while(it.hasNext()) {
            Command cmd = it.next();
            if(args[0].equals(cmd.name())) {
                cmd.execute(event, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }

    private void append(Command cmd) {
            commands.push(cmd);
    }

    private void undo() {
        if(!commands.empty()) {
            commands.pop();
        }
    }

    private void clear() {
        commands.clear();
    }
}
