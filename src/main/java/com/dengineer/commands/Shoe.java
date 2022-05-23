package com.dengineer.commands;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.plaf.ColorUIResource;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.Response;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Shoe extends ListenerAdapter { 
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new ColorUIResource(90, 70, 155));
        String url = "https://www.nike.com/launch?s=upcoming";
        try {
            Document doc = Jsoup.connect(url).get();
            eb.setDescription("Fetching" + url + "...");
            Elements media = doc.select(".d-md-h ncss-col-sm-12 va-sm-t pb0-sm prl0-sm");
            for (Element headlines : media) {
                log("%s\n\t%s", headlines.attr("title"), headlines.absUrl("href"));
            }

        } catch (Exception e ) {
            eb.addField("Issue", e.toString(), false);
        }
            
    }
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}



// URL url;

//             try {
//                 url = new URL("https://www.nike.com/launch");
//                 HttpURLConnection connect = (HttpURLConnection) url.openConnection();
//                 connect.setRequestMethod("GET");
//                 int status = connect.getResponseCode();
//                 if (status == 200) {
//                     eb.addField("Status:" ,"Successful connection; code: " + status, false);
//                     channel.sendMessageEmbeds(eb.build()).queue();
//                 }
//                 else {
//                     eb.addField("Status:" ,"Unsuccessful connection; code: " + status, false);
//                     channel.sendMessageEmbeds(eb.build()).queue();
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }