package com.example.mypgm3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewActivity extends AppCompatActivity {
    TextView user;
    TextView pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        SharedPreferences sp= getSharedPreferences("file1",MODE_PRIVATE);
        String u=sp.getString("username","");
        String p=sp.getString("password","");
        user=(TextView)findViewById(R.id.userview);
        pass=(TextView) findViewById(R.id.passview);
        user.setText(u);
        pass.setText(p);
    }
}