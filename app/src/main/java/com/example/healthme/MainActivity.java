package com.example.healthme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BMI = (Button) findViewById(R.id.BMI);
        Button EER = (Button) findViewById(R.id.EER);
        Button PHT = (Button) findViewById(R.id.PHT);
        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BMI();
            }
        });

        EER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EER();
            }
        });

        PHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PHT();
            }
        });

    }

    public void BMI(){//Body Mass Index
        Intent intent = new Intent(getApplicationContext(),BMI.class);
        startActivity(intent);
    }
    public void EER(){//Energy Efficiency Rating
        Intent intent = new Intent(getApplicationContext(),EER.class);
        startActivity(intent);
    }
    public void PHT(){//Personal Health Track
        Intent intent = new Intent(getApplicationContext(),PHT.class);
        startActivity(intent);
    }
}
