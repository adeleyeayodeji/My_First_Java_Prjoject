package com.biggidroid.testingkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button calculateButton;
    private TextView resultText;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageText;
    private EditText weightText;
    private EditText feetText;
    private EditText inchesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    /**
     * Find all views by their id
     *
     * @return void
     */
    private void findViews() {
        resultText = findViewById(R.id.text_view_result);

        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);

        ageText = findViewById(R.id.edit_text_age);
        weightText = findViewById(R.id.edit_text_weight);
        feetText = findViewById(R.id.edit_text_feet);
        inchesText = findViewById(R.id.edit_text_inches);

        calculateButton = findViewById(R.id.button_calculate);
    }

    /**
     * Setup button click listener
     *
     * @return void
     */
    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }
        });
    }

    /**
     * Calculate BMI
     *
     * @return void
     */
    private void calculateBmi() {
        String ageString = ageText.getText().toString();
        String weightString = weightText.getText().toString();
        String feetString = feetText.getText().toString();
        String inchesString = inchesText.getText().toString();

       //set text
        resultText.setText("Age: " + ageString + ", Weight: " + weightString + ", Feet: " + feetString + ", Inches: " + inchesString);
    }
}