package com.example.pgm21;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1;
    RadioButton rbs;
    Spinner sp1;
    Button btn;
    String arr[]={"subi","suresh","tommy","jerry","Leo"};
    String myname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rg1=(RadioGroup) findViewById(R.id.rg1);
        sp1=(Spinner) findViewById(R.id.spinner);
        btn=(Button) findViewById(R.id.button1);
        ArrayAdapter adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,arr);
        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                myname=adapter.getItem(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                myname="";
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected=rg1.getCheckedRadioButtonId();
                if(selected!=-1)
                {
                    rbs=(RadioButton) findViewById(selected);
                    Toast.makeText(MainActivity.this, myname+" wants "+rbs.getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}