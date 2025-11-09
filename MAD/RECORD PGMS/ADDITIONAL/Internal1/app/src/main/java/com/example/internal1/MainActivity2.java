package com.example.internal1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        e1=(EditText) findViewById(R.id.editText4);
        e2=(EditText) findViewById(R.id.editText5);
        b1=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                if(name.isEmpty())
                {
                    Toast.makeText(MainActivity2.this, "No name provided", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences sp=getSharedPreferences("Myprefs",MODE_PRIVATE);
                    int totmark=sp.getInt(name,-1); //-1 is default value if no mark for the name was found
                    if(totmark==-1)
                    {
                        Toast.makeText(MainActivity2.this, "Marks Not Found", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        e2.setText("Marks Obtained: "+String.valueOf(totmark)); //String.valueof is used to convert integer to string so that we can combine it with other string
                    }
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}