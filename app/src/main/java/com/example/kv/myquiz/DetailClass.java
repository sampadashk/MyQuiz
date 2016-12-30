package com.example.kv.myquiz;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

/**
 * Created by KV on 25/12/16.
 */

public class DetailClass extends AppCompatActivity {
    public static final String TAGV = "tagvalue";
    int userScore = 0;
    TextView tvw;
    RadioButton r1, r2, r3, r4;
    RadioGroup rg;
    Button b;
    Button sub;
    Cursor rs;

    //QuizModel Sci=new QuizModel("Which of the following is not a primary colour", "red", "blue", "yellow", "green", "yellow");
   /* QuizModel[] Sci = new QuizModel[]{new QuizModel("Which of the following is not a primary colour", "red", "blue", "yellow", "green", "yellow"),
            new QuizModel("Acid present in gastric juice is", "Hydrochloric Acid", "Sulphuric Acid", "citric Acid", "Acetic acid", "Hydrochloric Acid"),
            new QuizModel("Which of the following is used in pencils", "Charcoal", "SILICON", "graphite", "Phosphorous", "graphite"),
            new QuizModel("What is the unit for measuring the amplitude of a sound", "decibel", "Coulomb", "cycles", "hum", "decibel"),
            new QuizModel("Which of the following is the lightest metal ", "Silver", "Mercury", "Lithium", "Lead", "Lithium")};
   /* QuizModel[] His = new QuizModel[]{new QuizModel("Which is considered as oldest civilization of the world ", "Egyptain Civilization", "Harappan Civilization", "Chinese Civilization", "Mesopotamian Civilization", "Mesopotamian Civilization"),
            new QuizModel("Vasco da Gama reached in India in The year ", "1498", "1500", "1480", "1495", "1498"),
            new QuizModel("Who was the first to sail round the world", "Francis Drake", "Columbus", "Magellan", "Vasco da Gama", "Magellan")
            , new QuizModel("Boston Tea Party incident happened in", "1770", "1771", "1772", "1773", "1773")
            , new QuizModel("When did World War 2 start ", "1937", "1938", "1939", "1940", "1939")};
            */
    DBHelper dbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_layout);
        tvw = (TextView) findViewById(R.id.quiztext);
        r1 = (RadioButton) findViewById(R.id.optbut1);
        r2 = (RadioButton) findViewById(R.id.optbut2);
        r3 = (RadioButton) findViewById(R.id.optbut3);
        r4 = (RadioButton) findViewById(R.id.optbut4);
        String titli = getIntent().getStringExtra(TAGV);
        rs = null;
        rg = (RadioGroup) findViewById(R.id.radiogrp);
        sub = (Button) findViewById(R.id.submitbut);


//        dbHelper.insertData(Sci);
        // dbHelper.insertData(His);
        getSupportActionBar().setTitle(titli);


        dbHelper = new DBHelper(this);


//           this.dbHelper.insertData(Sci);
        rs = dbHelper.getData(titli);
        Log.d("cursorcount", "count" + rs.getCount());
        if (rs == null) {
            Log.d("tagnullchk", "yes");
        }

        if (rs.getCount() > 0) {
            rs.moveToFirst();
            Log.d("tagnotnullchk", "yes");

            String nam = rs.getString(1);
            tvw.setText(nam);
            r1.setText(rs.getString(2));
            r2.setText(rs.getString(3));
            r3.setText(rs.getString(4));
            r4.setText(rs.getString(5));
        }
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radbut = rg.getCheckedRadioButtonId();
                String userSelected = " ";
                Log.d("radcheck", "val" + radbut);

                switch (radbut) {
                    case R.id.optbut1:
                        userSelected = rs.getString(2);
                        break;
                    case R.id.optbut2:
                        userSelected = rs.getString(3);
                        break;
                    case R.id.optbut3:
                        userSelected = rs.getString(4);
                        break;
                    case R.id.optbut4:
                        userSelected = rs.getString(5);
                        break;


                }
                Log.d("userse", userSelected);
                if (userSelected.equals(" ")) {
                    Toast.makeText(DetailClass.this, R.string.noans, Toast.LENGTH_SHORT).show();

                }
                if (userSelected.equals(rs.getString(6))) {
                    userScore += 1;
                    invalidateOptionsMenu();
                    Toast.makeText(DetailClass.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(DetailClass.this, R.string.wrong, Toast.LENGTH_SHORT).show();

            }
        });




        b = (Button) findViewById(R.id.nextbut);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rs.moveToNext()) {

                    String nam = rs.getString(rs.getColumnIndex(DBHelper.questionseries));
                    tvw.setText(nam);
                    r1.setText(rs.getString(2));
                    r2.setText(rs.getString(3));
                    r3.setText(rs.getString(4));
                    r4.setText(rs.getString(5));
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)

    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);


        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem totscore = menu.findItem(R.id.scoreval);
        totscore.setTitle(String.valueOf(userScore));



        return super.onPrepareOptionsMenu(menu);
    }
}


