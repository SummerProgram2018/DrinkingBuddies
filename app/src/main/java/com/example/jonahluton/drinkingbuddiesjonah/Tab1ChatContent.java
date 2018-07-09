package com.example.jonahluton.drinkingbuddiesjonah;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static final int COUNT = 10;
    private static String Group1 = "Coffee Lovers";
    private static String Time1 = "4:35";


    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(ChatItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ChatItem createDummyItem(int position) {
        return new ChatItem(String.valueOf(position), Group1, "4:38");
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
        public final String id;
        public final String groupName;
        public final String messageTime;

        public ChatItem(String id, String groupName, String messageTime) {
            this.id = id;
            this.groupName = groupName;
            this.messageTime = messageTime;
        }

        @Override
        public String toString() {
            return groupName;
        }

    }
}
