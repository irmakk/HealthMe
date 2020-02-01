package com.example.healthme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EER extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eer);

        final EditText age = (EditText) findViewById(R.id.age);
        final EditText weight = (EditText) findViewById(R.id.weight);
        final EditText height = (EditText) findViewById(R.id.height);

        final RadioGroup activity = (RadioGroup) findViewById(R.id.activity);
        final RadioGroup gender = (RadioGroup) findViewById(R.id.gender);
        final TextView result = (TextView) findViewById(R.id.result);

        Button calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton female = (RadioButton)findViewById(R.id.radioButton2);
                RadioButton male = (RadioButton)findViewById(R.id.radioButton3);
                RadioButton sedentary = (RadioButton)findViewById(R.id.radioButton4);
                RadioButton low = (RadioButton)findViewById(R.id.radioButton5);
                RadioButton active = (RadioButton)findViewById(R.id.radioButton6);
                RadioButton veryactive = (RadioButton)findViewById(R.id.radioButton7);

                String str1 = age.getText().toString();
                String str2 = weight.getText().toString();
                String str3 = height.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    result.setText("Enter age");
                    result.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(str2)){
                    result.setText("Enter weight");
                    result.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(str3)){
                    result.setText("Enter height");
                    result.requestFocus();
                    return;
                }
                double agee = Double.parseDouble(str1);
                double weightt = Double.parseDouble(str2);
                double heightt = Double.parseDouble(str3);

                if(agee >= 19){
                    if(female.isChecked())
                    {
                        if(sedentary.isChecked()){
                            String r = String.valueOf(calculateEERWomen(weightt, heightt, agee, 1.0));
                            result.setText(r);
                        }
                        else if(low.isChecked()){
                            String r = (String.valueOf(calculateEERWomen(weightt, heightt, agee, 1.12)));
                            result.setText(r);
                        }
                        else if(active.isChecked()){
                            String r = (String.valueOf(calculateEERWomen(weightt, heightt, agee, 1.27)));
                            result.setText(r);
                        }
                        else if(veryactive.isChecked()){
                            String r = (String.valueOf(calculateEERWomen(weightt, heightt, agee, 1.45)));
                            result.setText(r);
                        }
                    }
                    if(male.isChecked())
                    {
                        if(sedentary.isChecked()){
                            String r = String.valueOf(calculateEERMen(weightt, heightt, agee, 1.0));
                            result.setText(r);
                        }
                        else if(low.isChecked()){
                            String r = (String.valueOf(calculateEERMen(weightt, heightt, agee, 1.11)));
                            result.setText(r);
                        }
                        else if(active.isChecked()){
                            String r = (String.valueOf(calculateEERMen(weightt, heightt, agee, 1.25)));
                            result.setText(r);
                        }
                        else if(veryactive.isChecked()){
                            String r = (String.valueOf(calculateEERMen(weightt, heightt, agee, 1.48)));
                            result.setText(r);
                        }
                    }

                }else{
                    result.setText("Must be older than 18");
                }
            }

        });
    }
    private double calculateEERMen ( double weight, double height, double age, double activity )
    {
        return (double) 662 - (9.53 * age) + activity * ((15.91 * weight) + (539.6 * height));
    }
    private double calculateEERWomen ( double weight, double height, double age, double activity )
    {
        return (double) 354 - (6.91 * age) + activity * ((9.36 * weight) + (726 * height));
    }
}





