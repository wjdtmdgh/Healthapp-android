package com.example.healthapp;

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