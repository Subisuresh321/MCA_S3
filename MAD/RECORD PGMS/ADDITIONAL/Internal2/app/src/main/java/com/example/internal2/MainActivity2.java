package com.example.internal2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb1,rb2,rb3;
    CheckBox cb1,cb2;

    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        rg=(RadioGroup) findViewById(R.id.rg);
        rb1=(RadioButton) findViewById(R.id.radioButton);
        rb2=(RadioButton) findViewById(R.id.radioButton2);
        rb3=(RadioButton) findViewById(R.id.radioButton3);
        cb1=(CheckBox) findViewById(R.id.checkBox);
        cb2=(CheckBox) findViewById(R.id.checkBox2);
        b3=(Button) findViewById(R.id.button3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String name= intent.getStringExtra("name");

                int selectedid=rg.getCheckedRadioButtonId();
                if(selectedid==-1)
                {
                    Toast.makeText(MainActivity2.this, "Size not selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    int total=0;
                    String size;
                    String Toppings="";
                    if(selectedid==R.id.radioButton)
                    {
                        size="small";
                        total+=100;
                    }
                    else if(selectedid==R.id.radioButton2)
                    {
                        size="medium";
                        total+=200;
                    }
                    else
                    {
                        size="large";
                        total+=450;
                    }

                    if(cb1.isChecked())
                    {
                        Toppings+=" Cheesse ";
                        total+=50;
                    }
                    if(cb2.isChecked()) // dont use else is as multiple checkbox can checked
                    {
                        Toppings+=" Veg ";
                        total+=55;
                    }

                    SharedPreferences sp=getSharedPreferences("Myprefs",MODE_PRIVATE);
                    SharedPreferences.Editor se=sp.edit();
                    se.putString(name+"size",size);
                    se.putString(name+"top",Toppings);
                    se.putInt(name+"total",total);
                    se.apply();

                    Intent i=new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(i);  //going back to home page

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