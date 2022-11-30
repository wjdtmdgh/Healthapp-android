package com.example.apptest;
//package com.example.healthapp;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CalendarView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.apptest.RoutineActivity;
import com.example.apptest.TimerActivity;
import com.example.apptest.DayRoutineActivity;
import com.example.apptest.FoodActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button routineBtn, dayRoutineBtn, foodBtn, alertBtn;
    Button btn_food;
    View v_d;
    EditText et1;
    EditText et2;
    EditText et3;
    double kcal;
    private void initChart(BarChart barChart){
        // 차트 회색 배경 설정 (default = false)
        barChart.setDrawGridBackground(false);
        // 막대 그림자 설정 (default = false)
        barChart.setDrawBarShadow(false);
        // 차트 테두리 설정 (default = false)
        barChart.setDrawBorders(false);

        Description description = new Description();
        // 오른쪽 하단 모서리 설명 레이블 텍스트 표시 (default = false)
        description.setEnabled(false);
        barChart.setDescription(description);

        // X, Y 바의 애니메이션 효과
        barChart.animateY(1000);
        barChart.animateX(1000);

        // 바텀 좌표 값
        XAxis xAxis = barChart.getXAxis();
        // x축 위치 설정
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 그리드 선 수평 거리 설정
        xAxis.setGranularity(1f);
        // x축 텍스트 컬러 설정
        xAxis.setTextColor(Color.RED);
        // x축 선 설정 (default = true)
        xAxis.setDrawAxisLine(false);
        // 격자선 설정 (default = true)
        xAxis.setDrawGridLines(false);

        YAxis leftAxis= barChart.getAxisLeft();
        // 좌측 선 설정 (default = true)
        leftAxis.setDrawAxisLine(false);
        // 좌측 텍스트 컬러 설정
        leftAxis.setTextColor(Color.BLUE);

        YAxis rightAxis = barChart.getAxisRight();
        // 우측 선 설정 (default = true)
        rightAxis.setDrawAxisLine(false);
        // 우측 텍스트 컬러 설정
        rightAxis.setTextColor(Color.GREEN);

        // 바차트의 타이틀
        Legend legend= barChart.getLegend();
        // 범례 모양 설정 (default = 정사각형)
        legend.setForm( Legend.LegendForm.LINE);
        // 타이틀 텍스트 사이즈 설정
        legend.setTextSize(20f);
        // 타이틀 텍스트 컬러 설정
        legend.setTextColor(Color.BLACK);
        // 범례 위치 설정
        legend.setVerticalAlignment( Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        // 범례 방향 설정
        legend.setOrientation( Legend.LegendOrientation.HORIZONTAL);
        // 차트 내부 범례 위치하게 함 (default = false)
        legend.setDrawInside(false);
    }
    private static ArrayList<BarEntry> valueList = new ArrayList<>();
    private void appendData(BarChart barChart,int dayOfMonth,float weight){
        valueList.add(new BarEntry(dayOfMonth,weight));
        refreshData(barChart);
    }
    private void refreshData(BarChart barChart){
        String title = "몸무게";
        BarDataSet barDataSet = new BarDataSet(valueList, title);
        // 바 색상 설정 (ColorTemplate.LIBERTY_COLORS)
        barDataSet.setColors(
                Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187),
                Color.rgb(118, 174, 175), Color.rgb(42, 109, 130));

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
    }
    private void setData(BarChart barChart){
        barChart.setScaleEnabled(false);

        // 임의 데이터
        List<Float> weightList= Arrays.asList(44f);
        for (int i=0;i<weightList.size();i++) {
            valueList.add(new BarEntry((float)i+1, weightList.get(i)));
        }
        refreshData(barChart);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        routineBtn = findViewById(R.id.btn_type);
        dayRoutineBtn = findViewById(R.id.btn_day);

        BarChart barChart = (BarChart) findViewById(R.id.chart);
        initChart(barChart);
        setData(barChart);
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
                View view1=inflater.inflate(R.layout.activity_graph, null);
                myAlertBuilder.setView(view1);
                myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        // OK 버튼을 눌렸을 경우 차트그려주고 메인액티비티 refresh
                        EditText editText=(EditText)view1.findViewById(R.id.weight);
                        System.out.println(editText.getText().toString());
                        appendData(barChart,dayOfMonth,Float.parseFloat(editText.getText().toString()));
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
        btn_food = (Button) findViewById(R.id.btn_food);
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onClick 함수가 Dialog(대화상자)를 만들어 줌.
                AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);

                //d.setTitle("칼로리 계산을 위한 정보를 입력해주세요.");

                //View.inflate 이용하여 그 뷰에 해당하는 것을 '구현/실행'해주고,
                v_d = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                //실행한 것을 setView 함수로 전달.
                d.setView(v_d);

                d.setPositiveButton("입력",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //dialog라는 레이아웃이 실제로 생성(inflate)되고 난 다음에, v_d라는 애를 통해서,
                                //그 안에 속한 것 중에서 찾아오는 것이 가능하다.
                                //setPositiveButton이 눌리게 되었을 때, dialog에 해당하는 우리가 만든 View (=v_d)로부터 et를 찾아옴
                                //dialog라는 레이아웃이 실제로 생성(inflate)되고 난 다음에, v_d라는 애를 통해서,
                                //그 안에 속한 것 중에서 찾아오는 것이 가능하다.
                                //setPositiveButton이 눌리게 되었을 때, dialog에 해당하는 우리가 만든 View (=v_d)로부터 et를 찾아옴
                                et1 = (EditText) v_d.findViewById(R.id.et_age);
                                et2 = (EditText) v_d.findViewById(R.id.et_weight);
                                et3 = (EditText) v_d.findViewById(R.id.et_height);
                                kcal=Double.parseDouble(et2.getText().toString());

                                RadioGroup rg= (RadioGroup)v_d.findViewById(R.id.gender);
                                int checkedId= rg.getCheckedRadioButtonId();
                                RadioButton rb= (RadioButton)rg.findViewById(checkedId);
                                String gender= rb.getText().toString();
                                if(gender.equals("남자"))
                                    kcal=66.47+(13.75*Double.parseDouble(et2.getText().toString()))+(5*Double.parseDouble(et3.getText().toString()))-(6.76*Double.parseDouble(et1.getText().toString()));
                                else
                                    kcal=655.1+(9.56*Double.parseDouble(et2.getText().toString()))+(1.85*Double.parseDouble(et3.getText().toString()))-(4.68*Double.parseDouble(et1.getText().toString()));


                                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                                //입력한 input값을 intent로 전달한다.
                                intent.putExtra("kcal", kcal);
                                //액티비티 이동
                                startActivity(intent);
                            }
                        });
                d.show();
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