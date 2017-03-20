package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class AddActivity extends Activity {
    appAdapter adapt;
    ImageButton btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_application);
        adapt = new appAdapter(getApplicationContext());
        ListView app_list = (ListView) findViewById(R.id.apps_list);
        app_list.setAdapter(adapt);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("pos", -1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        app_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("pos", position);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        if(adapt.getCount() == 0){
            adapt.apps.add(new simpleAppClass("camera", R.drawable.camera));
            adapt.apps.add(new simpleAppClass("Chrome", R.drawable.chrome));
            adapt.apps.add(new simpleAppClass("Clock", R.drawable.clock));
            adapt.apps.add(new simpleAppClass("Facebook", R.drawable.facebook));
            adapt.apps.add(new simpleAppClass("Gallery", R.drawable.gallery));
            adapt.apps.add(new simpleAppClass("Maps", R.drawable.maps));
            adapt.apps.add(new simpleAppClass("Messages", R.drawable.messages));
            adapt.apps.add(new simpleAppClass("Music", R.drawable.music));
            adapt.apps.add(new simpleAppClass("Netflix", R.drawable.netflix));
            adapt.apps.add(new simpleAppClass("Play Store", R.drawable.play));
            adapt.apps.add(new simpleAppClass("Settings", R.drawable.settings));
            adapt.apps.add(new simpleAppClass("Snapchat", R.drawable.snapchat));
            adapt.apps.add(new simpleAppClass("Spotify", R.drawable.spotify));
            adapt.apps.add(new simpleAppClass("Twitter", R.drawable.twitter));
            adapt.apps.add(new simpleAppClass("Youtube", R.drawable.youtube));
        }
    }
}
