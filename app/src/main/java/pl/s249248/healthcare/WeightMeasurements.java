package pl.s249248.healthcare;

public class WeightMeasurements {
    private String weight, date, time, food, other_info;

    public WeightMeasurements(String weight, String date, String time, String food, String other_info){
        this.weight = weight;
        this.date = date;
        this.time = time;
        this.food = food;
        this.other_info = other_info;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }
}
