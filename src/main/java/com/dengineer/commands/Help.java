package com.dengineer.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.*;

import java.awt.Color;
import java.lang.StringBuilder;

import javax.swing.plaf.ColorUIResource;

public class Help extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        StringBuilder sb = new StringBuilder();
        eb.setColor(new ColorUIResource(90, 70, 155));
        eb.setTitle("Help is here!");
        eb.setDescription("Full Command Center and Guide for DengiBot!");
        eb.setAuthor("Dengibot", "https://dengineer.vercel.app", "https://dengineer.vercel.app/favicon.png");
        eb.setThumbnail("https://dengineer.vercel.app/favicon.png");
        eb.addField("Commands:", sb.toString(), false);
        eb.addField("!Help", "`Brings up this menu. Used to see all commands`", true).addBlankField(true);
        eb.addField("!todo", "`Gives today's to-do list`", false);
        eb.addField("!shoe", "`Gives shoe drop information for the coming days`", false);
        MessageChannel channel = event.getChannel();
        channel.sendMessageEmbeds(eb.build()).queue();
    }
}
