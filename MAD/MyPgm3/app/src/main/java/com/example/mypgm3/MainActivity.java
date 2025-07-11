package com.example.mypgm3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name,pass;
    Button btn;
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
      name=(EditText)findViewById(R.id.name);
      pass=(EditText)findViewById(R.id.pass);
      btn=(Button)findViewById(R.id.button);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              SharedPreferences sp=getSharedPreferences("file1",MODE_PRIVATE);
              SharedPreferences.Editor ed=sp.edit();
              ed.putString("username",name.getText().toString());
              ed.apply();
              ed.putString("password",pass.getText().toString());
              ed.apply();
              Intent i = new Intent(MainActivity.this,ViewActivity.class);
              startActivity(i);
          }
      });
    }
}