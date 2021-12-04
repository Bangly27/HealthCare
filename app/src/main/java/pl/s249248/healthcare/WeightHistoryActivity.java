package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightHistoryActivity extends AppCompatActivity {

    String Username, UserID;
    TextView textView;
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_history);

        Username = SharedPrefManager.getInstance(this).getUsername();
        UserID = SharedPrefManager.getInstance(this).getUserID();

        textView = findViewById(R.id.json);

        getMeasurementsHistory();
    }

    private void getMeasurementsHistory(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_GET_WEIGHT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if(!obj.getBoolean("error")){
                        //Toast.makeText(getApplicationContext(),obj.getString("message"),Toast.LENGTH_LONG).show();
                        json_string = response;
                        textView.setText(obj.getString("message"));
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
                params.put("glucose", Username);
                params.put("date", Username);
                params.put("time", Username);
                params.put("food", Username);
                params.put("other_info", Username);
                params.put("user_name", Username);
                params.put("user_id", UserID);
                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void parseJSON(View view){
        Intent intent = new Intent(this, DisplayListView.class);
        intent.putExtra("json_data",json_string);
        startActivity(intent);
    }
}