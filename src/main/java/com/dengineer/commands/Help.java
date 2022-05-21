package com.dengineer.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.Color;
import java.lang.StringBuilder;

public class Help extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        StringBuilder sb = new StringBuilder();
        eb.setColor(Color.MAGENTA);
        eb.setTitle("Help is here!");
        eb.setDescription("Full Command Center and Guide for DengiBot!");
        eb.setAuthor("Dengibot", "https://dengineer.vercel.app", "https://dengineer.vercel.app/favicon.png");
        eb.setThumbnail("https://dengineer.vercel.app/favicon.png");
        sb = sb.append(">!help:\n\n  Brings up this menu. Used to see all commands.\n\n");
        sb = sb.append(">!todo:\n\n  Brings up to-do list, for the user.\n\n");
        sb = sb.append(">!shoe:\n\n Stay on top of new sneaker relesases.\n\n");
        eb.addField("Commands:", sb.toString(), false);
        eb.addField("Help", "Brings up this menu. Used to see all commands", true).addBlankField(true);
        eb.setFooter("Visit: [links](Https://dengineer.vercel.app)");
        

        MessageChannel channel = event.getChannel();
        channel.sendMessageEmbeds(eb.build()).queue();
    }
}
