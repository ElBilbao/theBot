package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class UserInfo extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");

        if(message[0].equalsIgnoreCase("!userinfo") && message.length == 1) {
            event.getChannel().sendMessage("!userinfo <username>").queue();

        } else if(message[0].equalsIgnoreCase("!userinfo") && message.length == 2) {
            String userName = message[1];
            User user = event.getGuild().getMembersByName(userName, true).get(0).getUser();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("User Info");
            eb.setColor(Color.ORANGE);
            eb.setThumbnail(user.getAvatarUrl());

            String info = "ID: " + user.getId() + "\nAvatar ID:" + user.getAvatarId();
            eb.addField(userName, info, true);

            event.getChannel().sendMessage(eb.build()).queue();

        }

    }
}
