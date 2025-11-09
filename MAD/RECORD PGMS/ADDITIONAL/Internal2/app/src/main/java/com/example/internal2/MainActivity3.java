package com.example.internal2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    TextView t4;
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        t4=(TextView) findViewById(R.id.textView4);
        b4=(Button) findViewById(R.id.button4);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");

        SharedPreferences sp=getSharedPreferences("Myprefs",MODE_PRIVATE);
        int total=sp.getInt(name+"total",-1);
        String size=sp.getString(name+"size","no size");
        String toppings=sp.getString(name+"top","no toppings");

        if(total==-1)
        {
            t4.setText("NO DATA FOUND");
        }
        else
        {
            String bill = "BILL GENERATED\n\n";
            bill += "Name: " + name + "\n";
            bill += "Size: " + size + "\n";
            bill += "Toppings: " + toppings + "\n";
            bill += "Total: ₹" + total;

            t4.setText(bill);
        }

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity3.this, MainActivity.class);
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