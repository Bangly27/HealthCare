package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddPressureActivity extends AppCompatActivity {

    EditText Pressure_Diastole, Pressure_Systole, Pulse , Date, Time, Food, Other_Info;
    Button addButton;
    String Username, UserID;
    Switch date_switch;
    boolean isSwitchOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pressure);

        Username = SharedPrefManager.getInstance(this).getUsername();
        UserID = SharedPrefManager.getInstance(this).getUserID();

        Pressure_Diastole = findViewById(R.id.pressure_diastole_input);
        Pressure_Systole = findViewById(R.id.pressure_systole_input);
        Pulse = findViewById(R.id.pulse_input);
        Date = findViewById(R.id.date_input);
        Time = findViewById(R.id.time_input);
        Food = findViewById(R.id.food_input);
        Other_Info = findViewById(R.id.other_info_input);

        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMeasurement();
            }
        });

        date_switch = findViewById(R.id.switch_date);

        date_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(date_switch.isChecked()){
                    isSwitchOn = true;
                    Date.setEnabled(false);
                    Time.setEnabled(false);
                    setCurrentDate();
                    setCurrentTime();
                }
                else{
                    isSwitchOn = false;
                    Date.setEnabled(true);
                    Time.setEnabled(true);
                    Date.setText("");
                    Date.setHint("Date (format: YYYY-MM-DD)");
                    Time.setText("");
                    Time.setHint("Time (format HH:MM)");
                }
            }
        });

    }

    private void addMeasurement(){
        final String Pressure_DiastoleString = Pressure_Diastole.getText().toString().trim();
        final String Pressure_SystoleString = Pressure_Systole.getText().toString().trim();
        final String PulseString = Pulse.getText().toString().trim();
        final String DateString = Date.getText().toString().trim();
        final String TimeString = Time.getText().toString().trim();
        final String FoodString = Food.getText().toString().trim();
        final String OtherInfoString = Other_Info.getText().toString().trim();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_ADD_PRESSURE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if(!obj.getBoolean("error")){
                        Toast.makeText(getApplicationContext(),"Measurement added successfully",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),obj.getString("message"),Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("pressure_diastole", Pressure_DiastoleString);
                params.put("pressure_systole", Pressure_SystoleString);
                params.put("pulse", PulseString);
                params.put("date", DateString);
                params.put("time", TimeString);
                params.put("food", FoodString);
                params.put("other_info", OtherInfoString);
                params.put("username", Username);
                params.put("userid", UserID);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void setCurrentDate(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String date = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day);
        Date.setText(date);
    }

    private void setCurrentTime(){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        String time = Integer.toString(hour) + ":" + Integer.toString(minute);
        Time.setText(time);
    }
}