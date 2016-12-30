package com.example.kv.myquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by KV on 25/12/16.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String Database_name="QuizDB.db";
    public static final String TABLE_Ques = "question";
    public static final String questionseries="quest";

    DBHelper(Context ct)
    {
        super(ct,Database_name,null,21);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table question"+"(id integer primary key autoincrement,quest text,OP1 text,OP2 text,OP3 text,OP4 text,ans text,categ text)");
        //QuizModel Sci=new QuizModel("Which of the following is not a primary colour", "red", "blue", "yellow", "green", "yellow");
        QuizModel[] Sci = new QuizModel[]{new QuizModel("Which of the following is not a primary colour", "red", "blue", "yellow", "green", "yellow", "Science"),
                new QuizModel("Acid present in gastric juice is", "Hydrochloric Acid", "Sulphuric Acid", "citric Acid", "Acetic acid", "Hydrochloric Acid", "Science"),
                new QuizModel("Which of the following is used in pencils", "Charcoal", "SILICON", "graphite", "Phosphorous", "graphite", "Science"),
                new QuizModel("What is the unit for measuring the amplitude of a sound", "decibel", "Coulomb", "cycles", "hum", "decibel", "Science"),
                new QuizModel("Which of the following is the lightest metal ", "Silver", "Mercury", "Lithium", "Lead", "Lithium", "Science"),
                new QuizModel("Which is considered as oldest civilization of the world ", "Egyptain Civilization", "Harappan Civilization", "Chinese Civilization", "Mesopotamian Civilization", "Mesopotamian Civilization", "History"),
                new QuizModel("Vasco da Gama reached in India in The year ", "1498", "1500", "1480", "1495", "1498", "History"),
                new QuizModel("Who was the first to sail round the world", "Francis Drake", "Columbus", "Magellan", "Vasco da Gama", "Magellan", "History")
                , new QuizModel("Boston Tea Party incident happened in", "1770", "1771", "1772", "1773", "1773", "History")
                , new QuizModel("When did World War 2 start ", "1937", "1938", "1939", "1940", "1939", "History")
                , new QuizModel("Joseph Barbera created which one of the following famous cartoon characters", "Spiderman", "Mickey Mouse", "Tom and Jerry", "Phantom", "Tom and Jerry", "Entertainment"),
                new QuizModel("Who is known as father of Indian Cinema", "Dadasaheb Phalke", "Hiralal Sen", "Jamshedji Framji Madan ", "H S Bhatavdekar", "Dadasaheb Phalke", "Entertainment"),
                new QuizModel("Walt Disney was born on", "1 dec 1901", "6 dec 1900", "1 jan 1905", "5 dec 1901", "5 dec 1901", "Entertainment"),
                new QuizModel("Which Indian movie was the first Cinemascope Film", "Kagaz Ke Phool", "Deewana", "Ram Teri Ganga Maili", "Mera naam Joker ", "Kagaz Ke Phool", "Entertainment"),
                new QuizModel("Film and TV institute of India is located at", "Guwahati", "Pune", "Mumbai", "Delhi", "Pune", "Entertainment"),
                new QuizModel("Which one is the largest among the following deserts", "Australian", "Gobi", "Kalahari", "Atacama", "Australian", "Geography"),
                new QuizModel("Which of the following do not belong to solar system","Asteroids","Comets","Planets","Nebulae","Nebulae","Geography"),
                new QuizModel("Ozone holes are more pronounced at the ","Equator","Tropic of Cancer","Poles","Tropic of Capricorn","Poles","Geography"),
                new QuizModel("The great Victoria Desert is located in","Australia","Canada","North America","West Africa","Australia","Geography"),
                new QuizModel("Mount Etna, one of the world's most active volcanoes, is located in which country","France","Italy","Dubai","Egypt","Italy","Geography")

        };
        Log.d("taglen","len"+Sci.length);
        for(int i=0;i<Sci.length;i++) {
            this.insertData(db, Sci[i]);
        }
    }
    @Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
       db.execSQL("DROP TABLE IF EXISTS question");
       onCreate(db);
    }
    public void insertData(SQLiteDatabase db,QuizModel obj)
    {


       // try {
            ContentValues values = new ContentValues();


            values.put("quest",obj.ques);
            values.put("OP1",obj.op1);
            values.put("OP2",obj.op2);
            values.put("OP3",obj.op3);
            values.put("OP4",obj.op4);
            values.put("ans",obj.ans);
        values.put("categ",obj.category);
            db.insert(TABLE_Ques, null, values);

        Log.d("tagb","inserted");
          /*  for(int i=0;i<obj.length;i++)
            {
                values.put("quest",obj[i].ques);
                values.put("OP1",obj[i].op1);
                values.put("OP2",obj[i].op2);
                values.put("OP3",obj[i].op3);
                values.put("OP4",obj[i].op4);
                values.put("ans",obj[i].ans);
                db.insert(TABLE_Ques, null, values);

            }
            */


          //  db.setTransactionSuccessful();
      //  } finally {
      //      db.endTransaction();
        //}

    }
    public Cursor getData(String str) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] params = new String[]{ str };
        Cursor res =  db.rawQuery( "select * from question where categ=?", params);
        return res;
    }


}

