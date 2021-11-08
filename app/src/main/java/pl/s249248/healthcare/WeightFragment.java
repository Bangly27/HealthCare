package pl.s249248.healthcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WeightFragment extends Fragment {

    EditText Weight, Date, Time, Food, Other_Info;
    Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        Weight = view.findViewById(R.id.weight_input);
        Date = view.findViewById(R.id.date_input);
        Time = view.findViewById(R.id.time_input);
        Food = view.findViewById(R.id.food_input);
        Other_Info = view.findViewById(R.id.other_info_input);

        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String WeightString = Weight.getText().toString().trim();
                final String DateString = Date.getText().toString().trim();
                final String TimeString = Time.getText().toString().trim();
                final String FoodString = Food.getText().toString().trim();
                final String OtherInfoString = Other_Info.getText().toString().trim();

                final String text = WeightString + "\n" + DateString + "\n" + TimeString + "\n"  + FoodString + "\n"  + OtherInfoString;
                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
