package com.samiappscoll.kv.GKMaster;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KV on 24/12/16.
 */

public class QuizAdapter extends ArrayAdapter<Quiz> {

    public QuizAdapter(Activity c, List<Quiz> qz)
    {
        super(c,0,qz);
    }
    public View getView(int position, View convertview, ViewGroup parent)
    {
        Quiz q=getItem(position);
        if(convertview==null)
        {
            convertview= LayoutInflater.from(getContext()).inflate(R.layout.customlayout,null);

        }
        ImageView iv=(ImageView)convertview.findViewById(R.id.imgv);
        iv.setImageResource(q.getRes());
        TextView tv=(TextView)convertview.findViewById(R.id.txtv);
        tv.setText(q.getName());
        return convertview;

    }
}
