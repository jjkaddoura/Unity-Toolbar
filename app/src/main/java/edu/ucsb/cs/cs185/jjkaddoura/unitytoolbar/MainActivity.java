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

    ImageButton btnCalc;
    ImageButton btnCalendar;
    ImageButton btnNotes;
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
    }
}