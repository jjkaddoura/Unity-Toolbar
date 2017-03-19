package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Intent;
import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CalculatorActivity extends AppCompatActivity {

    ImageButton btnHome;
    ImageButton btnNotes;
    ImageButton btnCalendar;

    ImageButton btnMinus;
    ImageButton btnPlus;
    ImageButton btnTimes;
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_calculator);
        else
            setContentView(R.layout.activity_calculator_2);

        btnMinus = (ImageButton) findViewById(R.id.btnMinus);
        btnPlus = (ImageButton) findViewById(R.id.btnPlus);
        btnTimes = (ImageButton) findViewById(R.id.btnTimes);

        btnZero = (Button) findViewById(R.id.btn0);
        btnOne = (Button) findViewById(R.id.btn1);
        btnTwo = (Button) findViewById(R.id.btn2);
        btnThree = (Button) findViewById(R.id.btn3);
        btnFour = (Button) findViewById(R.id.btn4);
        btnFive = (Button) findViewById(R.id.btn5);
        btnSix = (Button) findViewById(R.id.btn6);
        btnSeven = (Button) findViewById(R.id.btn7);
        btnEight = (Button) findViewById(R.id.btn8);
        btnNine = (Button) findViewById(R.id.btn9);


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });







        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnNotes = (ImageButton) findViewById(R.id.btnNotes);
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotesActivity.class);
                startActivity(intent);
            }
        });

        btnCalendar = (ImageButton) findViewById(R.id.btnCalendar);
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });


    }
}
