package com.dengineer;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

import com.dengineer.commands.MyCalendar;
import com.dengineer.commands.Help;
import com.dengineer.commands.Shoe;
import com.dengineer.*;


public class MessageListener extends ListenerAdapter{
    HashMap<String, String> map = new HashMap<>();
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        try {

            Message msg = event.getMessage();
            if (msg.getContentRaw().equals("!help"))
            {
                Help help = new Help();
                help.onMessageReceived(event);
            }

            if (msg.getContentRaw().equals("!calender")) {
                MyCalendar calendar = new MyCalendar();
                calendar.onMessageReceived(event);
            }

            if (msg.getContentRaw().equals("!shoe")) {
                Shoe shoe = new Shoe();
                shoe.onMessageReceived(event);
            }

            if (msg.getContentRaw().startsWith("!") && (!(msg.getContentRaw().equals("!help") || (msg.getContentRaw().equals("!todo") || (msg.getContentRaw().equals("!shoe")))))) {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Invalid Command").queue();
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
