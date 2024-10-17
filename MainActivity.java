package com.example.category;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int count_t=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button count=findViewById(R.id.btncout);

        Button next_pg=findViewById(R.id.next_btn);
        count.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count_text=(TextView) findViewById(R.id.countno);
                count_t++;
                count_text.setText(String.valueOf(count_t));
            }
        });

        next_pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}