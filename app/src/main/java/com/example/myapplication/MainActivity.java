package com.example.myapplication;
import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText e1=(EditText)findViewById(R.id.editText);
                EditText e2=(EditText)findViewById(R.id.editText2);

                Double p=Double.parseDouble(e1.getText().toString());
                Double r=Double.parseDouble(e2.getText().toString());
                SeekBar s1=(SeekBar)findViewById(R.id.seekBar);
                int time=s1.getProgress();

                Double res=emi(p,r,time);
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("emivalue",res);
                intent.putExtra("pvalue",p);
                intent.putExtra("time",time);
                startActivity(intent);


            }
        });

    }
    public Double emi(Double p,Double r,int time)
    {
        Double emi;

        r = r / (12 * 100); // one month interest
        time = time * 12; // one month period
        emi = (p * r * (float)Math.pow(1 + r, time))
                / (float)(Math.pow(1 + r, time) - 1);

        return (emi);
    }

}
