package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button buttonProfile, buttonWeight, buttonTemp, buttonPressure, buttonGlucose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonProfile = findViewById(R.id.buttonProfile);
        buttonWeight = findViewById(R.id.buttonWeight);
        buttonTemp = findViewById(R.id.buttonTemp);
        buttonPressure = findViewById(R.id.buttonPressure);
        buttonGlucose = findViewById(R.id.buttonGlucose);

        Intent profile = new Intent(this, ProfileActivity.class);
        Intent addWeight = new Intent(this, AddWeightActivity.class);
        Intent addTemperature = new Intent(this, AddTemperatureActivity.class);
        Intent addPressure = new Intent(this, AddPressureActivity.class);
        Intent addGlucose = new Intent(this, AddGlucoseActivity.class);

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
    }
}