package com.example.pgm8;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout lv;

    // in xml linearlayout should be inside scroll layout
    String arr[]= {
        "Subi", "Sreelekshmi", "Gokul", "Aarav", "Meera", "Rohan", "Liam", "Emma", "Noah", "Olivia",
                "Ethan", "Sophia", "Arjun", "Isha", "Kiran", "Zara", "Yash", "Anaya", "Dev", "Nina",
                "Leo", "Maya", "Aditya", "Tara", "Kabir", "Simran", "Jay", "Priya", "Neil", "Riya",
                "Omar", "Laila", "Harsha", "Sana", "Raj", "Diya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // always after this for dynamic contents
        lv=(LinearLayout) findViewById(R.id.lview);
        for(int i=0;i< arr.length;i++)
        {
            TextView tv=new TextView(MainActivity.this);
            tv.setText(arr[i]);
            tv.setTextSize(45);
            tv.setPadding(20,20,20,20);
            lv.addView(tv);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}