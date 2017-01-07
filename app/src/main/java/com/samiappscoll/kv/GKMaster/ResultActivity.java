package com.samiappscoll.kv.GKMaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KV on 1/1/17.
 */

public class ResultActivity extends AppCompatActivity {

    final static String resfinal="resultfinal";
    Boolean ScienceQ=false;
    Boolean HistoryQ=false;
    Boolean GeoQ=false;
    Boolean VocabQ=false;
    Boolean EntQ=false;
    Boolean SpoQ=false;
    TextView sq,hq,eq,gq,spq,vq;
    int total=0;
    TextView comment;
    ImageView ivcomment;


    int sciscore,hisscore,geoscore,entscore,sposcore,voscore;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        List<User> resquiz;
        getSupportActionBar().setTitle("GK Master");

       resquiz = (List<User>) getIntent().getSerializableExtra(resfinal);

        for(User users:resquiz)
        {


            if(users.QuizName.equals("Science"))
            {
                ScienceQ=true;
                sciscore=users.getScore();

            }
            if(users.QuizName.equals("History")) {
                HistoryQ = true;
                hisscore=users.getScore();
            }
            if(users.QuizName.equals("Geography")) {
                GeoQ = true;
                geoscore=users.getScore();
            }
            if(users.QuizName.equals("Vocabulary")) {
                VocabQ = true;
                voscore=users.getScore();
            }
            if(users.QuizName.equals("Entertainment")) {
                EntQ = true;
                entscore=users.getScore();
            }
            if(users.QuizName.equals("Sports")) {
                SpoQ = true;
                sposcore=users.getScore();
            }

            //int score=users.getScore();
         total=this.sciscore+this.hisscore+this.voscore+this.geoscore+this.sposcore+this.entscore;
        }
        sq=(TextView) findViewById(R.id.resultsci);
        if(ScienceQ)
        {
            String st=Integer.toString(sciscore);
            sq.setText(st+"/5");

        }
        else
        sq.setText("NOT ATTEMPTED");
        gq=(TextView) findViewById(R.id.resultgeog);
        if(GeoQ)
        {
            String st=Integer.toString(geoscore);
            gq.setText(st+"/5");
        }
        else
        gq.setText("NOT ATTEMPTED");
        vq=(TextView) findViewById(R.id.resultvocab);
        if(VocabQ)
        {
            String st=Integer.toString(voscore);
            vq.setText(st+"/5");
        }
        else
        vq.setText("NOT ATTEMPTED");
        hq=(TextView) findViewById(R.id.resulthis);
        if(HistoryQ)
        {
            String st=Integer.toString(hisscore);
            hq.setText(st+"/5");
        }
        else
            hq.setText("NOT ATTEMPTED");
        //Entertainment
        eq=(TextView)findViewById(R.id.resultent);
        if(EntQ)
        {
            String st=Integer.toString(entscore);
            eq.setText(st+"/5");
        }
        else
            eq.setText("NOT ATTEMPTED");
        //Sports
        spq=(TextView)findViewById(R.id.resultspo);
        if(SpoQ)
        {
            String st=Integer.toString(sposcore);
            spq.setText(st+"/5");
        }
        else
            spq.setText("NOT ATTEMPTED");






        TextView edtres=(TextView) findViewById(R.id.resulttxt);
        edtres.setText(" "+total+"/30");
        float per=(total*100)/30;
        comment=(TextView)findViewById(R.id.commenttext);
        ivcomment=(ImageView)findViewById(R.id.imgcom);



        if(per<50)
        {
            comment.setText("Hard Luck!");
            ivcomment.setImageResource(R.drawable.hardluck);

        }
        else if(per>=50&&per<70)
        {

            comment.setText("Awesome!");
            ivcomment.setImageResource(R.drawable.goodwork);
        }
        else {
            comment.setText("You are GENIUS!");
            ivcomment.setImageResource(R.drawable.awesome);
        }





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.sharemenu,menu);
       /* MenuItem ib=menu.findItem(R.id.sharevia);
        View v=ib.getActionView();
        ImageButton imb=(ImageButton)v.findViewById(R.id.sharebut);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareintent=new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                String sendmsg="My total Score in Quiz "+total;
                shareintent.putExtra("tagshare",sendmsg);
                startActivity(Intent.createChooser(shareintent,"Share using"));

            }
        });
        */

        return true;


    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent shareintent=new Intent(Intent.ACTION_SEND);
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_SUBJECT,"My Quiz Score");
        String sendmsg="My total Score in Quiz is  "+total+"/30";
        shareintent.putExtra(Intent.EXTRA_TEXT,sendmsg);
        startActivity(Intent.createChooser(shareintent,"Share using"));
        return true;

    }
}
