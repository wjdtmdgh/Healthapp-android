package com.example.apptest;
//package com.example.healthapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {
    Intent intent;
    String exerciseName;
    TextView name, explain, use, type;
    ImageView img;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        intent = getIntent();
        exerciseName = intent.getStringExtra("exerciseName");

        img = findViewById(R.id.img);
        use = findViewById(R.id.tv_use);
        type = findViewById(R.id.tv_type);
        name = findViewById(R.id.ex_title_tv);
        explain = findViewById(R.id.how);


        num = intent.getIntExtra("exerciseNum",0);
        Log.e("Asdf", String.valueOf(num));
        switch (num){
            case 0: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e1);
                break;

            }
            case 1: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e2);
                break;

            }case 2: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e3);
                break;

            }case 3: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e4);break;

            }case 4: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e5);break;

            }case 5: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e6);break;

            }case 6: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e7);break;

            }case 7: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e8);break;

            }case 8: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e9);break;

            }case 9: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e10);break;

            }case 10: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e11);break;

            }case 11: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e12);break;

            }case 12: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e13);break;

            }case 13: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e14);break;

            }case 14: {
                name.setText("여기에 이미지 운동 이름 넣어주시면 돼요!");
                explain.setText("운동 설명 여기 적어주세요");
                img.setImageResource(R.drawable.e15);break;

            }

        }



    }
}