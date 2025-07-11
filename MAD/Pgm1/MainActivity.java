package com.example.mypgm1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner s1;
    EditText name,ph;
    RadioGroup gender;
    Switch lang1,lang2,lang3;
    Button btn;

    String nameval,phval,langval,semvalue,genderval;



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

        name=(EditText)findViewById(R.id.nameEdit);
        ph=(EditText)findViewById(R.id.phEdit);
        gender=(RadioGroup)findViewById(R.id.rb1);
        lang1=(Switch)findViewById(R.id.switch1);
        lang2=(Switch)findViewById(R.id.switch2);
        lang3=(Switch)findViewById(R.id.switch3);
        s1=(Spinner)findViewById(R.id.spinner1);
        btn=(Button)findViewById(R.id.btn1);




        ArrayList<String> obj1 = new ArrayList<String>();
        obj1.add("SEM1");
        obj1.add("SEM2");

        ArrayAdapter ad=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,obj1);
        s1.setAdapter(ad);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                semvalue=obj1.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                semvalue="No Item";
            }
        });
        int genderid=gender.getCheckedRadioButtonId();

        if(genderid == R.id.rb1Button1)
        {
            genderval="Male";
        } else if (genderid == R.id.rb1Button2) {
            genderval="Female";
        }

        ArrayList<String> langs=new ArrayList<String>();
        if(lang1.isChecked()) langs.add("CPP");
        if(lang2.isChecked()) langs.add("Swift");
        if(lang3.isChecked()) langs.add("Python");

        langval= langs.isEmpty()? "none": String.join(",",langs);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameval=name.getText().toString();
                phval=ph.getText().toString();
            }
        });
    }
}