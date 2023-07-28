package com.biggidroid.testingkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

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
                double bmiResult = calculateBmi();
                //get age
                String ageString = ageText.getText().toString();
                //parse age
                int age = Integer.parseInt(ageString);

                //check if age is greater than 18
                if (age >= 18) {
                    //display result
                    displayResult(bmiResult);
                }else{
                    displayGuidance(bmiResult);
                }
            }
        });
    }

    /**
     * Display guidance
     * @param bmi double
     */
    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiString = myDecimalFormatter.format(bmi);

        String fullResultString;

        if(maleButton.isChecked()){
            //Display boy guidance
            fullResultString = bmiString + " - You are under 18, and you need to see a doctor for healthy range for boys";
        } else if (femaleButton.isChecked()){
            //Display girl guidance
            fullResultString = bmiString + " - You are under 18, and you need to see a doctor for healthy range for girls";
        } else {
            //Display generic guidance
            fullResultString = bmiString + " - You are under 18, and you need to see a doctor for healthy range";
        }

        resultText.setText(fullResultString);
    }

    /**
     * Calculate BMI
     *
     * @return void
     */
    private double calculateBmi() {
        // Get user values from the widget references
        String weightString = weightText.getText().toString();
        String feetString = feetText.getText().toString();
        String inchesString = inchesText.getText().toString();

        // Convert string to number
        int weight = Integer.parseInt(weightString);
        int feet = Integer.parseInt(feetString);
        int inches = Integer.parseInt(inchesString);

        // Calculate BMI
        double totalInches = (feet * 12) + inches;
        double heightInMeters = totalInches * 0.0254;

        return weight / (heightInMeters * heightInMeters);
    }

    /**
     * Display result
     *
     * @param bmi double
     */
    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiString = myDecimalFormatter.format(bmi);

        String fullResultString;

        if (bmi < 18.5) {
            // The user is underweight
            fullResultString = bmiString + " - You are underweight";
        } else if (bmi > 25) {
            // The user is overweight
            fullResultString = bmiString + " - You are overweight";
        } else {
            // The user is healthy
            fullResultString = bmiString + " - You are healthy";
        }

        resultText.setText(fullResultString);
    }
}