package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

/**
 * Created by manpreetbahia on 3/19/17.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        Bundle b = getIntent().getExtras();
        String oldTitle = b.getString("oldTitle");
        String oldContent = b.getString("oldContent");
        final int currentPos = b.getInt("position");

        EditText et = (EditText) findViewById(R.id.editTitle);
        et.setText(oldTitle);

        EditText et2 = (EditText) findViewById(R.id.editDescription);
        et2.setText(oldContent);

        Button saveButton = (Button) findViewById(R.id.editSave);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                // Perform action on click
                EditText titleNew = (EditText) findViewById(R.id.editTitle);
                EditText contentNew = (EditText) findViewById(R.id.editDescription);

                String s = titleNew.getText().toString();

                String s2 = contentNew.getText().toString();


                Notes.Note currentNote = NotesActivity.n.ITEMS.get(currentPos);
                currentNote.updateNote(s, s2);
                Context context = v.getContext();
                Intent intent = new Intent(context, NotesActivity.class);
                context.startActivity(intent);
            }
        });

        Button back = (Button) findViewById(R.id.editBackButton);
        back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                // Perform action on click
                finish();
            }
        });
    }

}
