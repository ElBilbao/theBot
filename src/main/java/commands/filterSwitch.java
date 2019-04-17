package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class filterSwitch extends ListenerAdapter {

    public static boolean filterSwitch = true;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("!filter") && message.length == 1) {
            event.getChannel().sendMessage("!filter <on/off>").queue();
        } else if (message[0].equalsIgnoreCase("!filter") && message[1].equalsIgnoreCase("on") && !filterSwitch) {
            event.getChannel().sendMessage("```Chat Filter On```").queue();
            filterSwitch = true;
        } else if(message[0].equalsIgnoreCase("!filter") && message[1].equalsIgnoreCase("off") && filterSwitch) {
            event.getChannel().sendMessage("```Chat Filter Off```").queue();
            filterSwitch = false;
        }
    }
}
