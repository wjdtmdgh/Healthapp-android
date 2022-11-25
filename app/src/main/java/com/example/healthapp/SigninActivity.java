package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;
public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button developer_info_btn = (Button) findViewById(R.id.btn_signin);
        developer_info_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder myAlertBuilder =
                        new AlertDialog.Builder(SigninActivity.this);
                // alert의 title과 Messege 세팅
                myAlertBuilder.setTitle("정승호님 환영합니다!");
                myAlertBuilder.setMessage("오늘도 행복한 하루 보내세요 득근득근");
                // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        // OK 버튼을 눌렸을 경우 메인페이지로 이동!
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                myAlertBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancle 버튼을 눌렸을 경우
                        Toast.makeText(getApplicationContext(),"입장에 실패하셨습니다",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                // Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
                myAlertBuilder.show();
            }
        });

        Button developer_info_btn2 = (Button) findViewById(R.id.btn_signup);
        developer_info_btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder myAlertBuilder =
                        new AlertDialog.Builder(SigninActivity.this);
                // alert의 title과 Messege 세팅
                myAlertBuilder.setTitle("회원가입");
                myAlertBuilder.setMessage("회원가입 창으로 넘어가시겠습니까?");
                // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        // OK 버튼을 눌렸을 경우 회원가입으로 이동!
                        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(intent);
                    }
                });
                myAlertBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancle 버튼을 눌렸을 경우
                        Toast.makeText(getApplicationContext(),"회원가입 실패",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                // Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
                myAlertBuilder.show();
            }
        });
    }
    }