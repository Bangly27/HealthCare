package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity {

    Button button;
    EditText et_weight, et_height;
    TextView bmitext, bmi, bmitextext;
    double weight, height, bmi_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        button = findViewById(R.id.button_calculate);

        et_weight = findViewById(R.id.et_weight);
        et_height = findViewById(R.id.et_height);

        bmitext = findViewById(R.id.yourbmi_text);
        bmi = findViewById(R.id.bmi_text);
        bmitextext = findViewById(R.id.bmi_text_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = Double.parseDouble(et_weight.getText().toString().trim());
                height = Double.parseDouble(et_height.getText().toString().trim())/100;
                bmi_score = (weight/(height*height));
                DecimalFormat df = new DecimalFormat("0.0");
                String s = df.format(bmi_score);
                bmi.setText(s);
                if(bmi_score>18.5 && bmi_score<24.99){
                    bmitextext.setText("Your weight is correct!");
                    bmitextext.setTextColor(Color.GREEN);
                    bmi.setTextColor(Color.GREEN);
                }
            }
        });
    }
}