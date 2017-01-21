package com.samiappscoll.kv.GKMaster;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String Tagscorecount="count";
    public static final String PREFS_FILE = "prefsFile";
    public int finalScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("GK Master");
        FragmentManager fm=getSupportFragmentManager();
        Fragment f=fm.findFragmentById(R.id.fragment_container);
        if(f==null)
        {
            f=new QuizFragment();

            fm.beginTransaction().add(R.id.fragment_container,f).commit();
        }
        SharedPreferences sharedPref = this.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(Tagscorecount, finalScore);
        editor.apply();



    }
}
