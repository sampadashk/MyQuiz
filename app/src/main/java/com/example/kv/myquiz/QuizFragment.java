package com.example.kv.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by KV on 24/12/16.
 */

public class QuizFragment extends ListFragment {

    QuizAdapter qzad;


    Quiz[] q = new Quiz[]{new Quiz("Science", R.drawable.sci), new Quiz("History", R.drawable.hist), new Quiz("Entertainment", R.drawable.entertainment), new Quiz("Geography", R.drawable.geog)};


    public QuizFragment() {

    }

    public void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        getActivity().setTitle("Quiz");
        qzad = new QuizAdapter(getActivity(), Arrays.asList(q));
        setListAdapter(qzad);

    }
    @Override
    public void onListItemClick(ListView l, View vt,int position,long id)
    {
        Quiz q=((QuizAdapter)getListAdapter()).getItem(position);
        String namet=q.getName();
        Intent ig=new Intent(getActivity(),DetailClass.class);
        ig.putExtra(DetailClass.TAGV,namet);
        startActivity(ig);

    }
}




