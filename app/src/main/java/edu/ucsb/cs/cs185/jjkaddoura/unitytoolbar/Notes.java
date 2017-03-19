package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manpreetbahia on 3/14/17.
 */

public class Notes {
    public static RecyclerView.Adapter<MyAdapter.ViewHolder> adapter;
    public static final List<Note> ITEMS = new ArrayList<Note>();
    public static final Map<String, Note> ITEM_MAP = new HashMap<String, Note>();

    public static void addNote(Note n) {
        ITEMS.add(n);
        ITEM_MAP.put(n.id, n);
        adapter.notifyDataSetChanged();
    }

    public static void deleteNote(Note n) {
        ITEMS.remove(n);
        ITEM_MAP.remove(n.id);
        adapter.notifyDataSetChanged();
    }

    public static class Note {
        public final String id;
        public String title;
        public static int count = 0;

        public String description;

        public Note (String title) {
            id = count++ + "";
            this.title = title;
        }
        public void updateNote(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getNoteTitle() {
            return this.title;
        }
    }
}
