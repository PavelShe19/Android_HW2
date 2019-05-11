package com.apporiotaxi.techbangla.quizapp.data;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apporiotaxi.techbangla.quizapp.Question;

import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_ANSWER;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_ID;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_OPTA;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_OPTB;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_OPTC;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_OPTD;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.KEY_QUES;
import static com.apporiotaxi.techbangla.quizapp.data.QuizContract.MovieEntry.TABLE_QUEST;


public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("How did Daenerys Targaryen eventually hatch her dragon eggs?"," In a lightning storm", " In a funeral pyre ", "In a fireplace"," In a frozen cave","In a funeral pyre");
        this.addQuestion(q1);
        Question q2=new Question("American actor Peter Dinklage, who plays Tyrion Lannister, also had a starring role in this fantasy franchise", "Lord of the Rings", "Highlander", "The Chronicles of Narnia", "The Legend of Zelda","The Chronicles of Narnia");
        this.addQuestion(q2);
        Question q3=new Question("What is the only thing that can put out volatile Wildfire?","Sand", "Water","Dragon's blood","Sunlight","Sand" );
        this.addQuestion(q3);
        Question q4=new Question("Besides dragonglass, what is the only other substance capable of defeating White Walkers?", "Weirwood", "Wildfire", "Valyrian Steel","Snowballs","Valyrian Steel");
        this.addQuestion(q4);
        Question q5=new Question("How many times has Beric Dondarrion been brought back to life?","Three times","Five times","Six times","Seven times","Six times");
        this.addQuestion(q5);
        Question q6=new Question("Game of Thrones star Ania Bukstein is not only a famous Israeli actress, but also a","Ballet dancer", "Watercolor artist ", "Singer and songwriter","Synchronized swimming instructor","Singer and songwriter");
        this.addQuestion(q6);
        Question q7=new Question("Which Stark family direwolf was killed in retaliation for an attack on Prince Joffrey?", "Ghost", "Lady", "Nymeria", "Summer","Lady");
        this.addQuestion(q7);
        Question q8=new Question("Arya's punishment for stealing from the Many-Face God is","Death", "Memory Loss","Blindness","Uncontrollable laughter","Blindness" );
        this.addQuestion(q8);
        Question q9=new Question("'It's nothing' were the last words of this infamous character", "Renly Baratheon", "Tywin Lannister", "Robb Stark","King Joffrey","King Joffrey");
        this.addQuestion(q9);
        Question q10=new Question("The name of King Tommen's favorite cat is","Battle Pus","Little Lion","Ser Pounce","Prince Fuzzy","Ser Pounce");
        this.addQuestion(q10);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}