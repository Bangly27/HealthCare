package pl.s249248.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    MeasurementsAdapter mAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);

        json_string = getIntent().getExtras().getString("json_data");


        listView = (ListView) findViewById(R.id.listview1);
        mAdapter = new MeasurementsAdapter(this, R.layout.row_layout);
        listView.setAdapter(mAdapter);

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("message");
            String weight, date, time, food, otherinfo;

            int count = 0;
            while(count<jsonArray.length()){
                JSONObject JO = jsonArray.getJSONObject(count);
                weight = JO.getString("weight");
                date = JO.getString("date");
                time = JO.getString("time");
                food = JO.getString("food");
                otherinfo = JO.getString("other_info");

                WeightMeasurements wm = new WeightMeasurements(weight, date, time, food, otherinfo);
                mAdapter.add(wm);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}