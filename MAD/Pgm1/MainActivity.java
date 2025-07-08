package com.example.mypgm1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
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
    String nameval,phval,genderval,langval;
    String semvalue;
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
        lang2

        s1=(Spinner)findViewById(R.id.spinner1);
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
    }
}