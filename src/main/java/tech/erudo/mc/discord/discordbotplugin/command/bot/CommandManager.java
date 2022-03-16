package tech.erudo.mc.discord.discordbotplugin.command.bot;

import java.util.Iterator;
import java.util.Stack;

public class CommandManager {

    private Stack<Command> commands = new Stack<>();

    public void execute() {
        Iterator<Command> it = commands.iterator();
        while(it.hasNext()) {
            ((Command) it.next()).execute();
        }
    }

    public void append(Command cmd) {
        if(cmd != this) {
            commands.push(cmd);
        }
    }

    public void undo() {
        if(!commands.empty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
