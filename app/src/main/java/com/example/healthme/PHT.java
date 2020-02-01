package com.example.healthme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class PHT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pht);
        final EditText bp = (EditText) findViewById(R.id.bp);
        final EditText bs = (EditText) findViewById(R.id.bs);
        final EditText hr = (EditText) findViewById(R.id.hr);
        final EditText w = (EditText) findViewById(R.id.w);

        final TextView rslt = (TextView) findViewById(R.id.message);
        final TextView rslt2 = (TextView) findViewById(R.id.lp);
        final TextView rslt3 = (TextView) findViewById(R.id.pp);

        Button enter = (Button)findViewById(R.id.ent);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String str1 = bp.getText().toString();
                final String str2 = bs.getText().toString();
                final String str3 = hr.getText().toString();
                final String str4 = w.getText().toString();

                //Get input from user
                if(TextUtils.isEmpty(str1)){
                    rslt.setText("Enter Blood Pressure");
                    rslt2.setText("");
                    rslt3.setText("");
                    return;
                }
                if(TextUtils.isEmpty(str2)){
                    rslt.setText("Enter Blood Sugar");
                    rslt2.setText("");
                    rslt3.setText("");
                    return;
                }
                if(TextUtils.isEmpty(str3)){
                    rslt.setText("Enter Heart Rate");
                    rslt2.setText("");
                    rslt3.setText("");
                    return;
                }
                if(TextUtils.isEmpty(str4)){
                    rslt.setText("Enter Weight");
                    rslt2.setText("");
                    rslt3.setText("");
                    return;
                }

                rslt.setText("");

                //Check blood pressure
                if(Double.parseDouble(str1)<80 ){
                    rslt.setText("Low blood pressure");
                }
                else if(Double.parseDouble(str1)>120 ){
                    rslt.setText("High blood pressure");
                }
                else if(Double.parseDouble(str2)<=120&&Double.parseDouble(str2)>=80){
                    rslt.setText("Normal blood pressure");
                }

                //Check blood sugar
                if(Double.parseDouble(str2)<70 ){
                    rslt2.setText("Low blood sugar");
                }
                else if(Double.parseDouble(str2)>130 ){
                    rslt2.setText("High blood sugar");
                }
                else if(Double.parseDouble(str2)<=130&&Double.parseDouble(str2)>=80){
                    rslt2.setText("Normal blood sugar");
                }

                //Check heart rate
                if(Double.parseDouble(str3)<60 ){
                    rslt3.setText("Low heart rate");
                }
                else if(Double.parseDouble(str3)>100 ){
                    rslt3.setText("High heart rate");
                }
                else if(Double.parseDouble(str2)<=100&&Double.parseDouble(str2)>=60){
                    rslt3.setText("Normal heart rate");
                }
                return;
                }


        });
    }


}
