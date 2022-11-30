package com.example.apptest;
//package com.example.healthapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptest.MainActivity;

import org.w3c.dom.Text;

public class FoodActivity extends AppCompatActivity {

    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        info=(TextView)findViewById(R.id.info);
        Intent intent = getIntent();
        Double id = intent.getExtras().getDouble("kcal");
        info.setText(Math.round(id)+"kcal");


        Button foodprev_btn = (Button) findViewById(R.id.foodprev);
        foodprev_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}