package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Intent;
import android.icu.util.Calendar;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_APP = 1234;
    ImageButton btnCalc;
    ImageButton btnCalendar;
    ImageButton btnNotes;
    ImageButton btnExtra;
    Button btnDelete;
    FloatingActionButton btnAdd;
    boolean isDeleting = false;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalc = (ImageButton) findViewById(R.id.btnCalc);
        btnCalendar = (ImageButton) findViewById(R.id.btnCalendar);
        btnNotes = (ImageButton) findViewById(R.id.btnNotes);
        btnExtra = (ImageButton) findViewById(R.id.btnExtra);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDeleting) {
                    Intent intent = new Intent(getApplicationContext(), NotesActivity.class);
                    startActivity(intent);
                }
                else{
                    btnNotes.setVisibility(View.INVISIBLE);
                    isDeleting = false;
                }
            }
        });
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDeleting) {
                    Intent intent = new Intent(getApplicationContext(), CalculatorActivity.class);
                    startActivity(intent);
                }
                else {
                    btnCalc.setVisibility(View.INVISIBLE);
                    isDeleting = false;
                }
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDeleting){
                    Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
                    startActivity(intent);
                }
                else{
                    btnCalendar.setVisibility(View.INVISIBLE);
                    isDeleting = false;
                }

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast = new Toast(getApplicationContext()).makeText(getApplicationContext(),
                        "Please select an application to add to toolbar.", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP,0,0);
                isDeleting = false;
                toast.show();
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(intent, ADD_APP);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast = new Toast(getApplicationContext()).makeText(getApplicationContext(),
                        "Please select one of your toolbar applications to delete", Toast.LENGTH_LONG);
                isDeleting = true;
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
            }
        });
        btnExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnExtra.setVisibility(View.INVISIBLE);
                isDeleting = false;
            }
        });
    }

    protected void onActivityResult(int ReqeustCode, int resultCode, Intent intent){
        super.onActivityResult(ReqeustCode, resultCode, intent);
        if(ReqeustCode == ADD_APP){
            if(resultCode == RESULT_OK) {
                int position = intent.getIntExtra("pos", -10);
                if(position >= 0) {
                    btnExtra.setImageResource(appAdapter.apps.get(position).imageId);
                    btnExtra.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}