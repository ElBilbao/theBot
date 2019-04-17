package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class invite extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("!invite") && message.length == 1) {
            event.getChannel().sendMessage("-> !invite create").queue();
        } else if(message[0].equalsIgnoreCase("!invite") && message.length > 1 && message[1].equalsIgnoreCase("create")) {
            String inviteLink = event.getChannel().createInvite().complete().getURL().toString();
            event.getChannel().sendMessage(inviteLink).queue();
        }

    }

}
