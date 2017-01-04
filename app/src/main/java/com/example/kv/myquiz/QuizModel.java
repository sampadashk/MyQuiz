package com.example.kv.myquiz;

import java.io.Serializable;

/**
 * Created by KV on 26/12/16.
 */

public class QuizModel implements Serializable {
    int id;
    String ques;
    String op1;
    String op2;
    String op3;
    String op4;
    String ans;
    String category;
    public QuizModel()
    {
        id=0;
        ques="";
        op1="";
        op2="";
        op3="";
        ans="";
        category="";
    }
    public QuizModel(String ques,String op1,String op2,String op3,String op4,String ans,String category)
    {
        this.ques=ques;
        this.op1=op1;
        this.op2=op2;
        this.op3=op3;
        this.op4=op4;
        this.ans=ans;
        this.category=category;
    }
    public String getAns()
    {
        return ans;
    }
    public String getQues()
    {
        return ques;
    }
}
