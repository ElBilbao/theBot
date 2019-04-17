package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class filterMessage extends ListenerAdapter {

    public static boolean enabled = true;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase("!filtermessage") && enabled) {
            event.getChannel().sendMessage("Filter Message Disabled.").queue();
            enabled = false;
        } else if (event.getMessage().getContentRaw().equalsIgnoreCase("!filtermessage") && !enabled) {
            event.getChannel().sendMessage("Filter Message Enabled.").queue();
            enabled = true;
        }
    }
}
