package com.example.healthme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Button calc = (Button) findViewById(R.id.calcBMI);
        final EditText wei = (EditText) findViewById(R.id.q1);
        final EditText hei = (EditText) findViewById(R.id.q2);
        final TextView result = (TextView) findViewById(R.id.res);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = wei.getText().toString();
                String str2 = hei.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    result.setText("Enter weight");
                    result.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(str2)){
                    result.setText("Enter height");
                    result.requestFocus();
                    return;
                }

                double w = Double.parseDouble(str1);
                double h = Double.parseDouble(str2);
                result.setText(CalculateBMI(w,h)+"");

                if(CalculateBMI(w,h)<18.5){
                    result.setText("Underweight");
                }
                else if(CalculateBMI(w,h)<25){
                    result.setText("Normal Weight");
                }
                else if(CalculateBMI(w,h)<30){
                    result.setText("Overweight");
                }else{
                    result.setText("Obesity");
                }
            }


        });
    }
    public double CalculateBMI(double w,double h){
        return (double) w/(h*h);
    }

}
