package com.example.innu.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp1;
    SharedPreferences sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating a SharedPreferences
        sp1 = getPreferences(MODE_PRIVATE);
        sp2 = getSharedPreferences("user",MODE_PRIVATE);
        SaveData();
        ReadData();
        DeleteData();
        SearchData();



    }

    public void SaveData()
    {
        //To Write or Edit data in a sharedpreference create an Editor object on the sharedpreference
        SharedPreferences.Editor ed1 = sp1.edit();
        ed1.putString("name","OSAM");
        ed1.putInt("age",20);
        ed1.commit();

        //Cascading Function Calls
        sp2.edit().putString("name","OSAM").putInt("age",20).commit();
        Log.i("myapp","data inserted");
    }

    public void ReadData()
    {
        String name1=sp1.getString("name",null);
        Log.i("myapp",name1);
    }

    public void DeleteData()
    {
        //To Clear SharedPreference
        sp1.edit().clear();

        //To Delete Specific Key Value
        sp2.edit().remove("name").commit();
        Log.i("myapp","data deleted");
    }

    public void SearchData()
    {
        if(sp2.contains("name"))
        {
            //Name is Saved
            Log.i("myapp","data exist");
        }
        else
        {
            //Name is not saved
            Log.i("myapp","data doesnot exist");
        }
    }
}
