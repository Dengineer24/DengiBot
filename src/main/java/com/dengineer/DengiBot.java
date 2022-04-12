package com.dengineer;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DengiBot {

    public static void main(String[] args) throws LoginException {

        JDA dengi = JDABuilder.createDefault("")
                .setActivity(Activity.playing("Baseball"))
                .build();
    }
};
