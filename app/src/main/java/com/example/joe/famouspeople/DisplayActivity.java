package com.example.joe.famouspeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        FamousPerson per = (FamousPerson) intent.getSerializableExtra(Keys.FAMOUS_PERSON);
        TextView text = findViewById(R.id.display_text);
        text.setText("Name: " + per.getName() + "\n" +
                "Field famous for: " + per.getField() + "\n" +
                "Is Alive: " + per.isAlive() + "\n" +
                "Gender:" + per.getGender());
    }
}