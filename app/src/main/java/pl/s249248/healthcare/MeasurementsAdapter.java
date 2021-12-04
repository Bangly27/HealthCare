package pl.s249248.healthcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MeasurementsAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public MeasurementsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(WeightMeasurements object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        MeasurementsHolder measurementsHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            measurementsHolder = new MeasurementsHolder();
            measurementsHolder.tv_weight = (TextView) row.findViewById(R.id.tv_weight);
            measurementsHolder.tv_date = (TextView) row.findViewById(R.id.tv_date);
            measurementsHolder.tv_time = (TextView) row.findViewById(R.id.tv_time);
            measurementsHolder.tv_food = (TextView) row.findViewById(R.id.tv_food);
            row.setTag(measurementsHolder);
        }else{
            measurementsHolder = (MeasurementsHolder) row.getTag();
        }

        WeightMeasurements wm = (WeightMeasurements) this.getItem(position);
        measurementsHolder.tv_weight.setText(wm.getWeight());
        measurementsHolder.tv_date.setText(wm.getDate());
        measurementsHolder.tv_time.setText(wm.getTime());
        measurementsHolder.tv_food.setText(wm.getFood());
        return row;
    }

    static class MeasurementsHolder{
        TextView tv_weight, tv_date, tv_time, tv_food, tv_otherinfo;
    }
}
