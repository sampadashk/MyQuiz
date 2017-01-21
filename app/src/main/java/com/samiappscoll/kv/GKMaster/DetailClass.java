package com.samiappscoll.kv.GKMaster;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.samiappscoll.kv.GKMaster.MainActivity.PREFS_FILE;

/**
 * Created by KV on 25/12/16.
 */

public class DetailClass extends AppCompatActivity implements View.OnClickListener {
    public static final String TAGV = "tagvalue";
    public static final String TAGScore = "totalscore";
    public static final String Tagscorecount="count";
    public static final String PREFS_FILE = "prefsFile";

    ArrayList<QuizModel> missedList;

    public int userScore = 0;
    TextView tvw;
    Button r1, r2, r3, r4;
    int i = 1;
    String userSelected;
    public SharedPreferences prefs;



    Button clickbut;
    Button backbut;
    ProgressBar pbar;
    TextView Qser;

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

    private void setScoreResult(int scoreResult) {
       // SharedPreferences prefs=getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
       // SharedPreferences.Editor editor=prefs.edit();
       // editor.putInt(Tagscorecount, scoreResult);
       // editor.commit();
       // Log.d("scoreprefs","score is"+scoreResult);

      Intent data = new Intent(DetailClass.this, MainActivity.class);
        //startActivity(data);
      data.putExtra(TAGScore, scoreResult);
       setResult(RESULT_OK, data);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.detail_layout);
        missedList = new ArrayList<>();
        tvw = (TextView) findViewById(R.id.quiztext);
        r1 = (Button) findViewById(R.id.opbut1);
        r2 = (Button) findViewById(R.id.opbut2);
        r3 = (Button) findViewById(R.id.opbut3);
        r4 = (Button) findViewById(R.id.opbut4);

        String titli = getIntent().getStringExtra(TAGV);
        pbar = (ProgressBar) findViewById(R.id.firstBar);
        Qser = (TextView) findViewById(R.id.qsnum);
        backbut = (Button) findViewById(R.id.backbut);
        rs = null;


//        dbHelper.insertData(Sci);
        // dbHelper.insertData(His);
        getSupportActionBar().setTitle(titli);


        dbHelper = new DBHelper(this);


//           this.dbHelper.insertData(Sci);
        rs = dbHelper.getData(titli);
        backbut.setVisibility(View.INVISIBLE);

        if (rs == null) {

        }

        if (rs.getCount() > 0) {
            rs.moveToFirst();


            String nam = rs.getString(1);
            tvw.setText(nam);
            r1.setText(rs.getString(2));
            r2.setText(rs.getString(3));
            r3.setText(rs.getString(4));
            r4.setText(rs.getString(5));
        }
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        pbar.setVisibility(View.VISIBLE);
        pbar.setScaleY(3f);
        pbar.setProgress(i);
        pbar.setBackgroundColor(Color.GRAY);

        pbar.setMax(5);
        String st = i + "/5";
        Qser.setText(st);

       /* rg.setOnClickListener(new RadioGroup.OnClickListener() {
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
                if(rs.isLast())
                {
                    b.setVisibility(View.INVISIBLE);
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
        */




       /* b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rs.isFirst()) {
                    if (userSelected.equals(" ")) {
                        QuizModel qm = new QuizModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                        missedList.add(qm);
                        Toast.makeText(DetailClass.this, R.string.noans, Toast.LENGTH_SHORT).show();
                    }
                }




                if (rs.moveToNext()) {
                    userSelected=" ";
                    i += 1;

                    pbar.setProgress(i);

                    String st = i + "/5";
                    Qser.setText(st);
                    if(rs.isLast())
                    {
                        if(userSelected.equals(" ")) {
                            QuizModel qm = new QuizModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                            missedList.add(qm);
                            Toast.makeText(DetailClass.this, R.string.noans, Toast.LENGTH_SHORT).show();

                            lastfunct();

                        }
                    }
                    if (userSelected.equals(" ")&&!(rs.isLast())) {
                        QuizModel qm = new QuizModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                        missedList.add(qm);
                        Toast.makeText(DetailClass.this, R.string.noans, Toast.LENGTH_SHORT).show();



                    }






                    String nam = rs.getString(rs.getColumnIndex(DBHelper.questionseries));
                    tvw.setText(nam);
                    r1.setEnabled(true);
                    r2.setEnabled(true);
                    r3.setEnabled(true);
                    r4.setEnabled(true);
                    r1.setText(rs.getString(2));
                    r2.setText(rs.getString(3));
                    r3.setText(rs.getString(4));
                    r4.setText(rs.getString(5));
                }



            }
        });*/


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

    @Override
    public void onClick(View v) {
        final int redColor = 0xFFFF0000;
        // final int greencolor=0x006600;

        // final Drawable original=v.getBackground();
        int ide = v.getId();
        clickbut = (Button) findViewById(ide);

        final Drawable bkgbut = clickbut.getBackground();


        switch (v.getId()) {
            case R.id.opbut1:
                userSelected = rs.getString(2);
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);
                break;
            case R.id.opbut2:
                userSelected = rs.getString(3);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);
                r1.setEnabled(false);
                break;
            case R.id.opbut3:
                userSelected = rs.getString(4);
                r4.setEnabled(false);
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                break;
            case R.id.opbut4:
                userSelected = rs.getString(5);
                r2.setEnabled(false);
                r1.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);
                break;

        }



        if (userSelected.equals(rs.getString(6))) {

            // b.setBackgroundColor(Color.GREEN);


            userScore += 1;
            invalidateOptionsMenu();
            clickbut.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickbut.getBackground().clearColorFilter();
                }
            }, 100);


            Toast.makeText(DetailClass.this, R.string.correct, Toast.LENGTH_SHORT).show();

        } else {
            clickbut.getBackground().setColorFilter(redColor, PorterDuff.Mode.MULTIPLY);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickbut.getBackground().clearColorFilter();
                }
            }, 200);


            Toast.makeText(DetailClass.this, R.string.wrong, Toast.LENGTH_SHORT).show();
            QuizModel qm = new QuizModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            missedList.add(qm);
        }
        if (rs.isLast()) {
            // b.setVisibility(View.INVISIBLE);
            lastfunct();


        }
        if (rs.moveToNext()) {

            i += 1;

            pbar.setProgress(i);

            String st = i + "/5";
            Qser.setText(st);
            String nam = rs.getString(rs.getColumnIndex(DBHelper.questionseries));
            tvw.setText(nam);
            r1.setEnabled(true);
            r2.setEnabled(true);
            r3.setEnabled(true);
            r4.setEnabled(true);
            r1.setText(rs.getString(2));
            r2.setText(rs.getString(3));
            r3.setText(rs.getString(4));
            r4.setText(rs.getString(5));

        }
    }


    public void lastfunct() {



        AlertDialog.Builder altbut = new AlertDialog.Builder(this);
        altbut.setTitle("Score");
        altbut.setMessage("Score: " + userScore);
        altbut.setNeutralButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = altbut.create();
        alert.show();
        setScoreResult(userScore);

        if (!missedList.isEmpty()) {
            backbut.setVisibility(View.VISIBLE);
            backbut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DetailClass.this, MissedQs.class);
                    intent.putExtra(MissedQs.tagmissed, missedList);
                    //intent.putExtra(MissedQs.TAGCount,userScore);
                    startActivity(intent);

                }
            });


        }

    }
}










