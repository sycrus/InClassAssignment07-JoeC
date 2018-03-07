package com.example.joe.famouspeople;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Button submitButton = (Button) findViewById(R.id.add_person_button);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addPerson(this);
            }

        });

    }

    public void addPerson(View.OnClickListener view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivityForResult(intent, RequestCode.ADD_PERSON);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RequestCode.ADD_PERSON && resultCode == RESULT_OK) {
            FamousPerson person = (FamousPerson) data.getSerializableExtra(Keys.FAMOUS_PERSON);
            displayText(person);
        }
    }

    protected void displayText (FamousPerson person) {

        TextView text = findViewById(R.id.display_text);
        text.setText("Name: " + person.getName() + "\n" +
                "Field famous for: " + person.getField() + "\n" +
                "Is Alive: " + person.isAlive() + "\n" +
                "Gender:" + person.getGender());
    }

}