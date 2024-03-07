package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnplay, btnstop;
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnplay = findViewById(R.id.btnplay);
        btnstop = findViewById(R.id.btnstop);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //  Khai báo Intent công khai để khởi động Service
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                startService(intent1);
                if (flag == true)
                {
                    btnplay.setImageResource(R.drawable.pause);
                    flag = false;
                }
                else
                {
                    btnplay.setImageResource(R.drawable.play);
                    flag = true;
                }

            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,MyService.class);
                stopService(intent2);

            }
        });
    }
}