package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button buttonProfile, buttonWeight, buttonTemp, buttonPressure, buttonGlucose, buttonWeightHistory, buttonTempHistory, buttonPressureHistory, buttonGlucoseHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonProfile = findViewById(R.id.profile_button);
        buttonWeight = findViewById(R.id.add_weight);
        buttonTemp = findViewById(R.id.add_temp);
        buttonPressure = findViewById(R.id.add_pressure);
        buttonGlucose = findViewById(R.id.add_glucose);

        buttonWeightHistory = findViewById(R.id.weight_history);
        buttonTempHistory = findViewById(R.id.temp_history);
        buttonPressureHistory = findViewById(R.id.pressure_history);
        buttonGlucoseHistory = findViewById(R.id.glucose_history);

        Intent profile = new Intent(this, ProfileActivity.class);
        Intent addWeight = new Intent(this, AddWeightActivity.class);
        Intent addTemperature = new Intent(this, AddTemperatureActivity.class);
        Intent addPressure = new Intent(this, AddPressureActivity.class);
        Intent addGlucose = new Intent(this, AddGlucoseActivity.class);
        Intent WeightHistory = new Intent(this, WeightHistoryActivity.class);
        //Intent TempHistory = new Intent(this, TemperatureHistoryActivity.class);
        //Intent PressureHistory = new Intent(this, PressureHistoryActivity.class);
        //Intent GlucoseHistory = new Intent(this, GlucoseHistoryActivity.class);

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(profile);
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addWeight);
            }
        });

        buttonTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addTemperature);
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addPressure);
            }
        });

        buttonGlucose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addGlucose);
            }
        });

        buttonWeightHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(WeightHistory);
            }
        });
    }
}