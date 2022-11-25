package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CalendarView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button routineBtn, dayRoutineBtn, foodBtn, alertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        routineBtn = findViewById(R.id.btn_type);
        dayRoutineBtn = findViewById(R.id.btn_day);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                System.out.println(dayOfMonth);
                AlertDialog.Builder myAlertBuilder =
                        new AlertDialog.Builder(MainActivity.this);
                // alert의 title과 Messege 세팅
                myAlertBuilder.setTitle("몸무게를 입력해주세요");
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                myAlertBuilder.setView(inflater.inflate(R.layout.activity_graph, null));
                myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        // OK 버튼을 눌렸을 경우 메인페이지로 이동!
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                myAlertBuilder.show();
            }
        });
        Button btn_rest = (Button) findViewById(R.id.btn_rest);
        btn_rest.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent);
            }
        });
        Button btn_food = (Button) findViewById(R.id.btn_food);
        btn_food.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(intent);
            }
        });
        routineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RoutineActivity.class);
                startActivity(intent);
            }
        });
        dayRoutineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DayRoutineActivity.class);
                startActivity(intent);
            }
        });
    }
}