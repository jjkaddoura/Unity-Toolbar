package edu.ucsb.cs.cs185.jjkaddoura.unitytoolbar;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.icu.util.Calendar;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    ImageButton btnHome;
    ImageButton btnNotes;
    ImageButton btnCalendar;

    ImageButton btnEquals;
    ImageButton btnMinus;
    ImageButton btnPlus;
    ImageButton btnTimes;
    ImageButton btnDiv;
    Button btnBanger;
    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    Button btnClear;
    TextView total;

    boolean plusOp, timesOp, divOp, minusOp = false;
    boolean eq = false;
    int num;
    String current;
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
        btnDiv = (ImageButton) findViewById(R.id.btnDiv);
        btnEquals = (ImageButton) findViewById(R.id.btnEqual);

        btnClear = (Button) findViewById(R.id.btnClear);
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

        total = (TextView) findViewById(R.id.textViewTotal);


        btnEquals.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        eq = true;
                        if(isNoop()) return true;
                        if(plusOp){
                            num += Integer.parseInt(current);
                        }
                        else if(timesOp){
                            num *= Integer.parseInt(current);
                        }
                        else if(minusOp){
                            num -= Integer.parseInt(current);
                        }
                        else if(divOp){
                            num /= Integer.parseInt(current);
                        }

                        setNoop();
                        current = Integer.toString(num);
                        total.setText(current);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return true;
            }
        });

        btnPlus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        plusOp = true;
                        divOp = timesOp = minusOp = false;
                        current = "";
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return true;
            }
        });

        btnTimes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        timesOp = true;
                        divOp = plusOp = minusOp = false;
                        current = "";
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return true;
            }
        });

        btnMinus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        minusOp = true;
                        divOp = timesOp = plusOp = false;
                        current = "";
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return true;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        divOp = true;
                        plusOp = timesOp = minusOp = false;
                        current = "";
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return true;
            }
        });


        btnClear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent){
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        current = "0";
                        total.setText(current);
                        num = 0;
                        btnClear.setText("AC");
                        eq = false;
                        setNoop();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return true;
            }
        });

        // ZERO
        btnZero.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            if(!current.equals("0")) current += "0";
                            num = Integer.parseInt(current);
                        }
                        else if(!isNoop() && num != 0 ){
                            if(current.length() < 1 && eq) current = "0";
                            else current += "0";
                            num = Integer.parseInt(current);
                        }

                        total.setText(current);

                        break;
                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        // ONE
        btnOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            current += "1";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq)&& isNoop()){
                            btnClear.setText("C");
                            num = 1;
                            current = "1";
                            eq = false;
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "1";
                            else current += "1";
                        }
                            total.setText(current);
                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        // TWO
        btnTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0&&!eq&& isNoop()) {
                            current += "2";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq) && isNoop()){
                            btnClear.setText("C");
                            current = "2";
                            num = 2;
                            eq = false;
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "2";
                            else current += "2";
                        }
                        total.setText(current);
                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        // THREE
        btnThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            current += "3";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq) && isNoop()) {
                            btnClear.setText("C");
                            current = "3";
                            num = 3;
                            eq = false;
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "3";
                            else current += "3";
                        }
                        total.setText(current);

                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        //FOUR
        btnFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0&& !eq && isNoop()) {
                            btnClear.setText("C");
                            current += "4";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq) && isNoop()) {
                            current = "4";
                            eq = false;
                            num = 4;
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "4";
                            else current += "4";
                        }
                        total.setText(current);

                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        //FIVE
        btnFive.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq&& isNoop()) {
                            current += "5";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq) && isNoop()) {
                            btnClear.setText("C");
                            num = 5;
                            eq = false;
                            current = "5";
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "5";
                            else current += "5";
                        }

                        total.setText(current);


                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        // SIX
        btnSix.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            current += "6";
                            num = Integer.parseInt(current);

                        }
                        else if((num == 0 || eq) && isNoop()) {
                            btnClear.setText("C");
                            num = 6;
                            current = "6";
                            eq = false;
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "6";
                            else current += "6";
                        }
                        total.setText(current);
                        break;
                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        // SEVEN
        btnSeven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            current += "7";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq) && isNoop()){
                            btnClear.setText("C");
                            num = 7;
                            eq = false;
                            current = "7";
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "7";
                            else current += "7";
                        }
                        total.setText(current);
                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }
                }
                return true;
            }
        });

        // EIGHT
        btnEight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            current += "8";
                            num = Integer.parseInt(current);
                        }
                        else if((num == 0 || eq) && isNoop()){
                            btnClear.setText("C");
                            num = 8;
                            eq = false;
                            current = "8";
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "8";
                            else current += "8";
                        }
                        total.setText(current);
                        break;

                    case MotionEvent.ACTION_CANCEL: {

                        break;
                    }


                }
                return true;
            }
        });

        // NINE
        btnNine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        if(num != 0 && !eq && isNoop()) {
                            current += "9";
                            num = Integer.parseInt(current);

                        }
                        else if((num == 0 || eq)&& isNoop()) {
                            btnClear.setText("C");
                            current = "9";
                            eq = false;
                            num = 9;
                        }
                        else if(!isNoop()){
                            if(current.length() < 1) current = "9";
                            else current += "9";
                        }
                        total.setText(current);
                        break;
                    case MotionEvent.ACTION_CANCEL: {
                        break;
                    }
                }
                return true;
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

        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            btnBanger = (Button) findViewById(R.id.btnBanger);
            btnBanger.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:

                            break;
                        case MotionEvent.ACTION_UP:
                            if(num != 0){
                                for(int i = num-1; i > 0; i--){
                                    num *= i;
                                }
                            }
                            current = Integer.toString(num);
                            total.setText(current);
                            break;

                        case MotionEvent.ACTION_CANCEL: {

                            break;
                        }
                    }
                    return true;
                }
            });
        }


    }


    public boolean isNoop(){
        if(divOp || minusOp || plusOp || timesOp)
            return false;
        return true;
    }

    public void setNoop(){
        divOp = minusOp = plusOp = timesOp = false;
    }
}
