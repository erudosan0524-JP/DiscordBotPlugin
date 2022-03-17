package tech.erudo.mc.discord.discordbotplugin.discord.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import tech.erudo.mc.discord.discordbotplugin.discord.command.commands.HelloCommand;
import tech.erudo.mc.discord.discordbotplugin.discord.command.commands.JoinCommand;

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
    }

    public void execute(String name) {
        Iterator<Command> it = commands.iterator();
        while(it.hasNext()) {
            Command cmd = it.next();
            if(name.equals(cmd.name())) {
                cmd.execute(event);
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
