package com.dengineer;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


import javax.security.auth.login.LoginException;

public class DengiBot {

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("OTYzNDc3MjgzMDM1ODE1OTQ3.YlWqJA.yPjB8i2C3JEdrOoydRrJPSWqND4")
            .setActivity(Activity.listening("Best Friend - Young Thug"))
            .addEventListeners(new StartUp())
            .addEventListeners(new MessageListener())
            .build();

        // optionally block until JDA is ready
        jda.awaitReady();
    }
}
