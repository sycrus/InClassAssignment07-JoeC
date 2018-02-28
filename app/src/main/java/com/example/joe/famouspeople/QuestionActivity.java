package com.example.joe.famouspeople;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class QuestionActivity extends AppCompatActivity  {

    private String mNameString;
    private boolean mIsAlive;
    private String mGenderString;
    FamousPerson person = new FamousPerson("name", "gender", "field", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //Fields spinner display
        Spinner spinner = (Spinner) findViewById(R.id.fields_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(QuestionActivity.this,
                R.array.fields_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                person.setField((String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //Gender radio button
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gender_radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.male_radio_button:
                        person.setGender("Male");
                        break;

                    case R.id.female_radio_button:
                        person.setGender("Female");
                        break;
                }
            }
        });


        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Name EditText
                EditText name = (EditText) findViewById(R.id.name_text);
                person.setName(name.getText().toString());

                //IsAlive checkbox
                CheckBox checkbox = findViewById(R.id.doa_checkbox);
                if (checkbox.isChecked()) {
                    person.setAlive(true);
                } else {
                    person.setAlive(false);
                }

                Intent intent = new Intent(QuestionActivity.this, DisplayActivity.class);
                /*
                intent.putExtra(Keys.NAME, person.getName());
                intent.putExtra(Keys.GENDER, person.getGender());
                intent.putExtra(Keys.FIELD, person.getField());
                intent.putExtra(Keys.IS_ALIVE, person.isAlive());
                  */
                intent.putExtra(Keys.FAMOUS_PERSON, person);

                startActivity(intent);
            }

        });


    }
}










