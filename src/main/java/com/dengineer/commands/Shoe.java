package com.dengineer.commands;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.plaf.ColorUIResource;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Shoe extends ListenerAdapter {
    private LinkedHashMap<String, String> tempHashMap = new LinkedHashMap<>();
    private LinkedHashMap<String, String> mainHashMap;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new ColorUIResource(90, 70, 155));
        final String url = "https://www.nike.com/launch?s=upcoming";

        try {

            Document doc = Jsoup.connect(url).get();
            org.jsoup.Connection.Response response = Jsoup.connect(url).followRedirects(false).execute();

            // connection code
            if (response.statusCode() == 200) {
                eb.setDescription("Successful connection with " + response.url() + " code: " + response.statusCode());
            }
            else {
                eb.setDescription("Unsuccessful connection with " + response.url() + " code: " + response.statusCode());
            }

            Elements media = doc.select("figure.d-md-h.ncss-col-sm-12.va-sm-t.pb0-sm.prl0-sm");
            for (Element headlines : media) {
                
                final String headLink = headlines.select("a.ncss-col-sm-8.launch-details.u-full-height.va-sm-t.full").attr("href");
                if (headlines.select("a.ncss-col-sm-8.launch-details.u-full-height.va-sm-t.full").text().equals(null)) {
                    break;
                }
                else {
                    final String shoes = headlines.select("a.ncss-col-sm-8.launch-details.u-full-height.va-sm-t.full").text().replaceAll("2:00 PM", "10:00 AM EST");
                    final String fullLink = "https://www.nike.com" + headLink;
                    tempHashMap.put(shoes, fullLink);
                }
            }  

            // clean hash map to discord embedBuilder
            mainHashMap = removeDuplicates(tempHashMap); 
            for (String i : mainHashMap.keySet()) {
                eb.addField(i, mainHashMap.get(i), false);
            }
               

            try {
                channel.sendMessageEmbeds(eb.build()).queue();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } 
        catch (Exception e) {
            eb.addField("Issue", e.toString(), false);
            channel.sendMessageEmbeds(eb.build()).queue();
        }
            
    }

    // remove duplicates from LinkedHashMap input
    public static <K, V> LinkedHashMap<K, V> removeDuplicates(LinkedHashMap<K, V> newMap) {
        LinkedHashMap<K, V> mainHashMap = new LinkedHashMap<>();
        LinkedHashMap<V, K> tempHashMap = new LinkedHashMap<>();
        for(Map.Entry<K, V> entry : newMap.entrySet()) {
            if (!(tempHashMap.containsKey(entry.getValue()))) {
                tempHashMap.put(entry.getValue(), entry.getKey());
            }
        }
        for(Map.Entry<V, K> entry : tempHashMap.entrySet()) {
            mainHashMap.put(entry.getValue(), entry.getKey());
        }
        return mainHashMap;
    }    
}