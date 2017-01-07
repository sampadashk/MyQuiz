package com.samiappscoll.kv.GKMaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KV on 4/1/17.
 */

public class MissedQs extends AppCompatActivity {
    public static String tagmissed="missedqs";
    List<QuizModel> missedList;
    int i=0;
    public static final String TAGCount="countscore";


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("GK Master");
        setContentView(R.layout.missed_q);
        missedList= (List<QuizModel>) getIntent().getSerializableExtra(tagmissed);
        LinearLayout lt=(LinearLayout)findViewById(R.id.linear);

        for(QuizModel qmm:missedList)
        {
            i+=1;
            String qs=qmm.getQues();
            String ans=qmm.getAns();


            TextView qstext=new TextView(this);
            qstext.setTextSize(18);


            qstext.setText("Q"+i+")"+"\t"+qs+"?");
            TextView anstext=new TextView(this);
            anstext.setTextSize(18);
            anstext.setText("Ans"+i+")"+"\t"+ans);
            lt.addView(qstext);
            lt.addView(anstext);


        }

    }

   /* public void onBackPressed() {

        finish();
        Intent intentback = new Intent(MissedQs.this,MainActivity.class);
       // int getcount=intentback.getIntExtra(TAGCount,0);
        //intentback.putExtra(MainActivity.Tagscorecount,getcount);

        startActivity(intentback);
    }
    */
}
