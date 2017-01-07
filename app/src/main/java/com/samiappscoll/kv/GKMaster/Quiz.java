package com.samiappscoll.kv.GKMaster;

/**
 * Created by KV on 24/12/16.
 */

public class Quiz {
    private String name;
    int res;

    Quiz(String nm,int rs)
    {
        name=nm;
        res=rs;
    }
    public void setName(String title)
    {
        name=title;
    }
    public String getName()
    {
        return name;
    }
    public void setRes(int rss)
    {
        res=rss;
    }
    public int getRes()
    {
        return res;
    }
}
