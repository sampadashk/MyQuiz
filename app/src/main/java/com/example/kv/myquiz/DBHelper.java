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
        super(ct,Database_name,null,23);
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
                new QuizModel("Mount Etna, one of the world's most active volcanoes, is located in which country","France","Italy","Dubai","Egypt","Italy","Geography"),
                new QuizModel("Synonym of Calumniate is","To accuse falsely","To accuse truthfully","To denounce","To ditch","To accuse falsely","Vocabulary"),
                new QuizModel("Meaning of Commence","To End","To Begin","Nearing Finish","To Run","To Begin","Vocabulary"),
                new QuizModel("Detest means","Love","To hate intensely","Neglect","To support","To hate intensely","Vocabulary"),
                new QuizModel("Synonym of Beset","Plead","Deny","Deprive","Perplex","Perplex","Vocabulary"),
                new QuizModel("Synonym of ARDENT","Eager","YouthfuL","Silvery","Difficult","Eager","Vocabulary"),
                new QuizModel("Who was the first Indian to win the World Amateur Billiards title","Geet Sethi","Wilson Jones","Michael Ferreira","Manoj Kothari","Wilson Jones","Sports"),
                new QuizModel("Who has won the 2016 Women’s Singles Wimbledon Championship","Simona Halep","Serena Williams","Angelique Kerber","Andy Murray","Serena Williams","Sports"),
                new QuizModel("Who was the goodwill ambassador for the 35th National Games of India","Sachin Tendulkar","Pankaj Advani","Sania Mirza","Saina Nehwal","Sachin Tendulkar","Sports"),
                new QuizModel("Who was the first person to make three test centuries in his first innings as a captain","Virat Kohli","M S Dhoni","Steve Smith","Hashim Amla","Virat Kohli","Sports"),
                new QuizModel("Who among the following cricketer is referred to as The Don","Vivians Richard","Donald Bradman","Gary Sobers","Wasim Akram","Donald Bradman","Sports"),
                new QuizModel("When ancient Olympic games first held","776 BC","780 BC","790 BC","800 BC","776 BC","History"),
                new QuizModel("In which year American Revolution started ","1774","1775","1776","1777","1775","History"),
                new QuizModel("In which year Hitler became the Chancellor of Germany","1932","1933","1944","1945","1933","History"),
                new QuizModel("The Renaissance scientist who explained how planets moved around the sun was","Kepler","Rebelais","Francis Bacorr","Gutenberg","Kepler","History"),
                new QuizModel("Russian revolutionary, who founded the Communist Party was","Karl Marx","Stalin","Lenin","Trotsky","Lenin","History"),
                new QuizModel("Synonym of HAGGLE ","Crisis","Ignore","Impeach","Bargain","Bargain","Vocabulary"),
                new QuizModel("Synonym of ZENITH ","Middle","Under","Pinnacle","Nadir","Pinnacle","Vocabulary"),
                new QuizModel("Synonym of IMPASSE","Stalemate","Impossibility","Difficulty","Confrontation","Stalemate","Vocabulary"),
                new QuizModel("Synonym of CONCEAL","Unfold","Reveal","Open","Discover","Reveal","Vocabulary"),
                new QuizModel("Synonym of TAINT","Soil","STAIN","dirty","corrupt","corrupt","Vocabulary"),
                new QuizModel("A naturally occurring substance that has a definite chemical composition is a","mineral","compound","METAL","rock","compound","Geography"),
                new QuizModel("Which country has no known mineral deposits","Hungry","Austria","Netherlands","Switzerland","Switzerland","Geography"),
                new QuizModel("The largest producer of mica in the world is","Australia","India","China","Korea","India","Geography"),
                new QuizModel("Silicon, used in the computer industry is obtained from","quartz","bauxite","cuprite","Magnetite","quartz","Geography"),
                new QuizModel("Petroleum means","Land Oil","Black Oil","Shell Oil","Rock Oil","Rock Oil","Geography"),
                new QuizModel("Which of the following is necessary for burning","Nitrogen","Carbon","Oxygen","Petrol","Oxygen","Science"),
                new QuizModel("Enzymes and anti-bodies are mainly made of","Vitamins","Proteins","Carbohydrates","Fats","Proteins","Science"),
                new QuizModel("Which gas in the atmosphere protects us from harmful ultraviolet radiation","Carbon Dioxide","Oxygen","Nitrogen","Ozone","Ozone","Science"),
                new QuizModel("The SI unit of charge is","Ampere","Coulomb","Ohm","Volt","Coulomb","Science"),
                new QuizModel("The lifespan of Red Blood Cells is","60 days","120 days","180 days","240 days","120 days","Science"),
                new QuizModel("Archery is the national sport of which country","Afghanistan","Japan","India","Bhutan","Bhutan","Sports"),
                new QuizModel("When was the Commonwealth game started","1930","1934","1945","1950","1930","Sports"),
                new QuizModel("Which country has won Cricket world cup for the maximum number of times","West Indies","Sri Lanka","Australia","India","Australia","Sports"),
                new QuizModel("Football World Cup has been won by which country for the maximum number of times","Brazil","Uruguay","Germany","Italy","Brazil","Sports"),
                new QuizModel("First Olympic Games was held in","Jamacia","Canada","England","Australia","Canada","Sports"),
                new QuizModel("What was Walt Disney's Mickey Mouse's original name","Manville","Melvin","Mortimer","Murgatroyd","Mortimer","Entertainment"),
                new QuizModel("which singer has won the most grammys","Georg Solti","Quincy Jones","Alison Krauss","Pierre Boulez","Georg Solti","Entertainment"),
                new QuizModel("Who won Oscar award best actor winner 2015","Eddie Redmayne","Bradley Cooper","Steve Carell","Michael Keaton","Eddie Redmayne","Entertainment"),
                new QuizModel("First Sound film THE JAZZ SINGER was released in which year","1927","1925","1920","1915","1927","Entertainment"),
                new QuizModel("Which movie won OSCARS BEST PICTURE 2016","The Big Short","Brooklyn","Spotlight","Room","Spotlight","Entertainment")










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

