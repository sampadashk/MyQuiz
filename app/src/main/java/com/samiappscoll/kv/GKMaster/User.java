package com.samiappscoll.kv.GKMaster;

import java.io.Serializable;

/**
 * Created by KV on 31/12/16.
 */

public class User implements Serializable {
    int score;
    String QuizName;

    String name;

    public void setName(String name) {
        this.name = name;
    }
    User(String QuizName,int score)
    {
        this.QuizName=QuizName;
        this.score=score;

    }

    public int getScore() {
        return score;
    }
    public String getQuizName()
    {
        return QuizName;
    }
}
