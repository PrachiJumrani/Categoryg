package com.example.category;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        // Finding views by ID
        EditText editmail = findViewById(R.id.textemail);
        TextView errormsg = findViewById(R.id.textview);
        Button btn = findViewById(R.id.act_next);

        // Adding TextWatcher for email validation in real-time
        editmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String mail = editmail.getText().toString();
                if (!isValidEmail(mail)) {
                    errormsg.setVisibility(View.VISIBLE);
                    errormsg.setText("Invalid email format");
                } else {
                    errormsg.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }

            // Method to validate email format
            private boolean isValidEmail(String mail) {
                String pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                return mail.matches(pattern);
            }
        });

        // Handling button click to navigate to the next activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}
