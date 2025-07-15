
package com.example.mypgm6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner s1,s2,s3,s4;
    EditText et1,et2,et3,et4;
    Button btn1;
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

        s1=(Spinner) findViewById(R.id.spinner1);
        s2=(Spinner) findViewById(R.id.spinner2);
        s3=(Spinner) findViewById(R.id.spinner3);
        s4=(Spinner) findViewById(R.id.spinner4);

        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);
        et3=(EditText) findViewById(R.id.editText3);
        et4=(EditText) findViewById(R.id.editText4);

        btn1=(Button)findViewById(R.id.button1);
        String arr[] = {"mango","apple","banana","pineapple"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
        s1.setAdapter(ad);
        s3.setAdapter(ad);
        s2.setAdapter(ad);
        s4.setAdapter(ad);

        int price[]= {30,25,35,40};
        String items[]=new String[4];


        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                items[0]=arr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                items[0]="";
            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                items[1]=arr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                items[1]="";
            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                items[2]=arr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                items[2]="";
            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                items[3]=arr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                items[3]="";
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int qt[]={Integer.parseInt(et1.getText().toString()), Integer.parseInt(et2.getText().toString()),Integer.parseInt(et3.getText().toString()),Integer.parseInt(et4.getText().toString())};
                Intent i=new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("items",arr);
                i.putExtra("Prices",price);
                i.putExtra("itemssel",items);
                i.putExtra("quant",qt);

                startActivity(i);
            }
        });

    }
}