package com.dengineer;

import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class StartUp implements EventListener {
    @Override
    public void onEvent(GenericEvent event)
    {
        if (event instanceof ReadyEvent) {
            System.out.println("API is ready!");
        }
    }
}
