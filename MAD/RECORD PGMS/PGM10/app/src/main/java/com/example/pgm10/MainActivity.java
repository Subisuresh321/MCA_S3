package com.example.pgm10;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1,b2;
    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.editText1);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        t1=(TextView) findViewById(R.id.textView);

        SharedPreferences sp=getSharedPreferences("MyPrefs",MODE_PRIVATE);

        //write data logic
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=e1.getText().toString();      // use editor (se) to write data
                SharedPreferences.Editor se= sp.edit();
                se.putString("username",data);
                se.apply();
            }
        });

        //read data logic
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result;                      // use shared preferences itself to read data (sp)
                result= sp.getString("username",""); // key and default value as parameter
                t1.setText(result);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}