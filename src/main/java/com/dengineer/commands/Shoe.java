package com.dengineer.commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.Response;

public class Shoe extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("https://dengineer.vercel.app").queue();   
    }
}
