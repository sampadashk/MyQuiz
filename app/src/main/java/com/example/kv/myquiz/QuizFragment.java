package com.example.kv.myquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by KV on 24/12/16.
 */

public class QuizFragment extends Fragment {

    QuizAdapter qzad;
    SharedPreferences prefs;
    GridView gridView;
    int totscore=0;
    public ArrayList<User> quizTaken;
    String namet;
    ImageButton Resultbut;




    Quiz[] q = new Quiz[]{new Quiz("Science", R.drawable.sci), new Quiz("History", R.drawable.hist), new Quiz("Entertainment", R.drawable.entertainment), new Quiz("Geography", R.drawable.geog),new Quiz("Sports",R.drawable.sport),new Quiz("Vocabulary",R.drawable.vocab)};


    public QuizFragment() {

    }

    public void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);




    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        getActivity().setTitle("Quiz");
        View rootView=inflater.inflate(R.layout.grid_layout,container,false);
        quizTaken=new ArrayList<User>();
        qzad = new QuizAdapter(getActivity(), Arrays.asList(q));
        gridView=(GridView) rootView.findViewById(R.id.grd);
        gridView.setAdapter(qzad);
        gridView.setVisibility(View.VISIBLE);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView,View v,int i,long l) {
                Quiz q=qzad.getItem(i);
                namet=q.getName();
                Intent ig=new Intent(getActivity(),DetailClass.class);
                ig.putExtra(DetailClass.TAGV,namet);
               startActivityForResult(ig,0);
                //startActivity(ig);

            }
        });


        Resultbut=(ImageButton)rootView.findViewById(R.id.resultbut);





        Resultbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent=new Intent(getActivity(),ResultActivity.class);
                newintent.putExtra(ResultActivity.resfinal,quizTaken);
                startActivity(newintent);


            }
        });
        return rootView;

    }

   /* @Override
    public void onResume()
    {
        super.onResume();
        prefs= PreferenceManager.getDefaultSharedPreferences(getContext());
        totscore=prefs.getInt(getString(R.string.saved_high_score),0);
    }
    */
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(data==null)
        {
            return;
        }

        totscore=data.getIntExtra(DetailClass.TAGScore,0);
        User u=new User(namet,totscore);
        for(User us:quizTaken)
        {
            if(us.getQuizName().equals(namet))
            {
                quizTaken.remove(us);
            }
        }
        quizTaken.add(u);



    }



}




