package com.example.jonahluton.drinkingbuddiesjonah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Tab1ChatContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ChatItem> ITEMS = new ArrayList<ChatItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ChatItem> ITEM_MAP = new HashMap<String, ChatItem>();

    private static List<String> GROUPS = new ArrayList<>();
    private static List<String> MESSAGES = new ArrayList<>();
    private static List<String> TIMES = new ArrayList<>();


    //public static final List<String> CHATS = new ArrayList<String>();

    private static final int COUNT = 8;
    private static String Group1 = "Coffee Lovers";

    static {
        GROUPS.add("Coffee Lovers");
        GROUPS.add("Sunday Casual Drinks");
        GROUPS.add("Football Fridays");
        GROUPS.add("Lunchtime Coffee");
        GROUPS.add("Tea Tasters");
        GROUPS.add("After Uni Drinks");
        GROUPS.add("Monday Morning Coffee");
        GROUPS.add("Tuesday Tea");

        TIMES.add("4:26pm");
        TIMES.add("2:38pm");
        TIMES.add("11:34am");
        TIMES.add("10:28am");
        TIMES.add("9:31am");
        TIMES.add("8:45am");
        TIMES.add("Yesterday");
        TIMES.add("Tuesday");

        MESSAGES.add("Sounds good! I'll meet you guys there!");
        MESSAGES.add("I'll be there from 4pm");
        MESSAGES.add("World cup final this week!");
        MESSAGES.add("Finishing up now");
        MESSAGES.add("I haven't tried that one but I'll give it a go");
        MESSAGES.add("My class finished early, on my way now");
        MESSAGES.add("See you guys tomorrow");
        MESSAGES.add("We'll have to go again next week");

        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(ChatItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.time, item);
    }

    private static ChatItem createDummyItem(int position) {
        return new ChatItem(GROUPS.get(position-1),MESSAGES.get(position-1) ,TIMES.get(position-1));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ChatItem {
        public final String group;
        public final String message;
        public final String time;

        public ChatItem(String group, String message, String time) {
            this.group = group;
            this.message = message;
            this.time = time;
        }

        @Override
        public String toString() {
            return message;
        }

    }
}
