package com.example.apptest;
//package com.example.healthapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.apptest.DataClass;
import com.example.apptest.ExerciseActivity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RoutineActivity extends AppCompatActivity {

    ArrayList<DataClass> movieDataList;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);


        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listview);
        final ListAdapter myAdapter = new ListAdapter(this,movieDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent intent = new Intent(getBaseContext(), ExerciseActivity.class);

                intent.putExtra("exerciseNum", position);
                intent.putExtra("exerciseName", myAdapter.getItem(position).getText());
                startActivity(intent);
            }
        });
    }

    public void InitializeMovieData()
    {
        movieDataList = new ArrayList<DataClass>();

        movieDataList.add(new DataClass(R.drawable.e1, "CYCLING"));
        movieDataList.add(new DataClass(R.drawable.e2, "2"));
        movieDataList.add(new DataClass(R.drawable.e3, "3"));
        movieDataList.add(new DataClass(R.drawable.e4, "4"));
        movieDataList.add(new DataClass(R.drawable.e5, "5"));
        movieDataList.add(new DataClass(R.drawable.e6, "6"));
        movieDataList.add(new DataClass(R.drawable.e7, "7"));
        movieDataList.add(new DataClass(R.drawable.e8, "7"));
        movieDataList.add(new DataClass(R.drawable.e9, "7"));
        movieDataList.add(new DataClass(R.drawable.e10, "7"));
        movieDataList.add(new DataClass(R.drawable.e11, "7"));
        movieDataList.add(new DataClass(R.drawable.e12, "7"));
        movieDataList.add(new DataClass(R.drawable.e13, "7"));
        movieDataList.add(new DataClass(R.drawable.e14, "FORM ROLL"));
        movieDataList.add(new DataClass(R.drawable.e15, "Push UP"));
    }
}