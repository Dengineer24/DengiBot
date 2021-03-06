package com.dengineer;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


import javax.security.auth.login.LoginException;

public class DengiBot {

    public static void main(String[] args) throws LoginException, InterruptedException {
        try {
            JDA jda = JDABuilder.createDefault(System.getenv("DISC_Token"))
                .setActivity(Activity.listening("Flashing Lights - Kanye West, Dwele"))
                .addEventListeners(new StartUp())
                .addEventListeners(new MessageListener())
                .build();

            // optionally block until JDA is ready
            jda.awaitReady();
        } 
        catch (Exception e ) {
           e.printStackTrace();
        }
    }
}
