package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class dateAdapter extends BaseAdapter {
    private Context context;
    public static List<simpleDateClass> events = new ArrayList<simpleDateClass>();
    public dateAdapter(Context hold){
        context = hold;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public void addItem(simpleDateClass temp){
        events.add(temp);
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.datelistitem, null);
        }
        TextView Descript = (TextView) view.findViewById(R.id.DescriptionHolder);
        TextView Date = (TextView) view.findViewById(R.id.DateHolder);
        simpleDateClass holder = events.get(position);
        Descript.setText(holder.desc);
        String displayDate;
        if(holder.month < 10) displayDate = "0" + Integer.toString(holder.month);
        else displayDate = Integer.toString(holder.month);
        if(holder.day < 10) displayDate = displayDate + "/0" + Integer.toString(holder.day);
        else displayDate = displayDate + "/" + Integer.toString(holder.day);
        displayDate = displayDate + "/" + Integer.toString(holder.year);
        Date.setText(displayDate);
        return view;
    }

    public static void add(simpleDateClass date){
        int pos = 0;
        while(pos < events.size()){
            if(date.year > events.get(pos).year) {
                pos++;
                continue;
            }
            else if(date.month > events.get(pos).month && date.year >= events.get(pos).year){
                pos++;
                continue;
            }
            else if(date.day > events.get(pos).day && date.month >= events.get(pos).month && date.year >= events.get(pos).year){
                pos++;
                continue;
            }
            else {
                events.add(pos, date);
                break;
            }
        }
        if(pos == events.size()) events.add(date);
    }
}

