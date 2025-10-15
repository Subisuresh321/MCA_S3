package com.example.program3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb1,rb2;
    CheckBox cb1,cb2,cb3;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg=(RadioGroup) findViewById(R.id.radiogrp);
        rb1=(RadioButton) findViewById(R.id.radioButton1);
        rb2=(RadioButton) findViewById(R.id.radioButton2);

        cb1=(CheckBox) findViewById(R.id.checkBox1);
        cb2=(CheckBox) findViewById(R.id.checkBox2);
        cb3=(CheckBox) findViewById(R.id.checkBox3);

        b1=(Button) findViewById(R.id.button);
        t1=(TextView)findViewById(R.id.textView4);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("Languanges Known: ");
                if(cb1.isChecked())
                {
                    t1.setText(t1.getText().toString()+" "+cb1.getText().toString());
                }
                if(cb2.isChecked())
                {
                    t1.setText(t1.getText().toString()+" "+cb2.getText().toString());
                }
                if(cb3.isChecked())
                {
                    t1.setText(t1.getText().toString()+" "+cb3.getText().toString());
                }

                int selectid= rg.getCheckedRadioButtonId();

                if(selectid == -1)
                {
                    Toast.makeText(MainActivity.this, "Select a gender", Toast.LENGTH_SHORT).show();
                }
                else if(selectid==R.id.radioButton1)
                {
                    Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                }
                else if(selectid==R.id.radioButton2)
                {
                    Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}