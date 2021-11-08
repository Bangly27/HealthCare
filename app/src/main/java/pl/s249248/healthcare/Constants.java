package pl.s249248.healthcare;

public class Constants {

    private static final String ROOT_URL = "http://192.168.0.48/HealthCare/v1/";

    public static final String URL_REGISTER = ROOT_URL + "registerUser.php";
    public static final String URL_LOGIN = ROOT_URL + "userLogin.php";
    public static final String URL_ADD_WEIGHT = ROOT_URL + "addWeight.php";
    public static final String URL_ADD_TEMPERATURE = ROOT_URL + "addTemperature.php";
    public static final String URL_ADD_PRESSURE = ROOT_URL + "addPressure.php";
    public static final String URL_GET_WEIGHT = ROOT_URL + "getMeasurementWeight.php";
    public static final String URL_GET_TEMPERATURE = ROOT_URL + "getMeasurementTemperature.php";
    public static final String URL_GET_PRESSURE = ROOT_URL + "getMeasurementPressure.php";
}
