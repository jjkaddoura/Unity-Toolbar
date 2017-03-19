package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotesView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        Bundle b = getIntent().getExtras();
        String ID = b.getString("item_id");

        int findPos = -1;

        for (int i = 0; i < NotesActivity.n.ITEMS.size(); i++) {
            Notes.Note tmp = NotesActivity.n.ITEMS.get(i);
            if (ID.equals(tmp.getNoteTitle())) {
                findPos = i;
            }
        }
        Notes.Note n = NotesActivity.n.ITEMS.get(findPos);

        TextView titleText = (TextView) findViewById(R.id.viewTitle);
        TextView contentText = (TextView) findViewById(R.id.viewContent);

        titleText.setText(n.title);
        contentText.setText(n.description);

        Button back = (Button) findViewById(R.id.viewBackButton);
        back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                // Perform action on click
                Context context = v.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
