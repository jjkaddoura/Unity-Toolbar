package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class appAdapter extends BaseAdapter{
    private Context context;
    public static List<simpleAppClass> apps = new ArrayList<simpleAppClass>();
    public appAdapter(Context hold){
        context = hold;
    }
    @Override
    public int getCount() {
        return apps.size();
    }

    @Override
    public Object getItem(int i) {
        return apps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.add_application_item, null);
        }
        TextView app_name = (TextView) view.findViewById(R.id.app_name);
        ImageView app_image = (ImageView) view.findViewById(R.id.app_image);
        simpleAppClass holder = apps.get(position);
        app_name.setText("   " + holder.name);
        app_image.setImageResource(holder.imageId);
        return view;
    }
}
