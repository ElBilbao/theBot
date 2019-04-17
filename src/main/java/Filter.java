import commands.filterMessage;
import commands.filterSwitch;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Filter extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(filterSwitch.filterSwitch) {
            String[] message = event.getMessage().getContentRaw().split(" ");
            String[] listOfBadWords = {"fuck", "motherfucker", "ass", "bitch", "fag"};

            for (int i = 0; i < message.length; i++) {
                for (int j = 0; j < listOfBadWords.length; j++) {
                    if (message[i].equalsIgnoreCase(listOfBadWords[j])) {
                        event.getMessage().delete().queue();
                        if(filterMessage.enabled) {
                            event.getChannel().sendMessage("Warning: Language.").queue();
                        }
                    }
                }
            }
        }
    }
}
