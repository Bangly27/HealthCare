package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddTemperatureActivity extends AppCompatActivity {

    EditText Temperature, Date, Time, Food, Other_Info;
    Button addButton;
    String Username, UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_temperature);

        Username = SharedPrefManager.getInstance(this).getUsername();
        UserID = SharedPrefManager.getInstance(this).getUserID();

        Temperature = findViewById(R.id.temperature_input);
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
    }

    private void addMeasurement(){
        final String TemperatureString = Temperature.getText().toString().trim();
        final String DateString = Date.getText().toString().trim();
        final String TimeString = Time.getText().toString().trim();
        final String FoodString = Food.getText().toString().trim();
        final String OtherInfoString = Other_Info.getText().toString().trim();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_ADD_TEMPERATURE, new Response.Listener<String>() {
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
                params.put("temperature", TemperatureString);
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
}