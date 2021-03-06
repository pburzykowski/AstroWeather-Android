package com.example.przemek.astroweather.Weather;

/**
 * Created by Przemek on 28.05.2018.
 */

public class WeatherUnit {

    public static final String DISTANCE = "miles";
    public static final String PRESSURE = "in";
    public static final String SPEED = "mph";
    public static final String DEGREE  = "\u00b0";

    private WeatherUnit(){

    }

    public static float convertFahrenheitToCelsius(float celsius){
        return (celsius - 32) * 5/9;
    }

    public static String getFormattedCelsius(float celsius){
        return convertDegreeWithPrecision(celsius) + " " + DEGREE + "C";
    }

    public static String getFormattedFahrenheit(float fahrenheit){
        return convertDegreeWithPrecision(fahrenheit) + " " + DEGREE + "F";
    }

    private static String convertDegreeWithPrecision(float degree){
        return String.format("%.2f", degree);
    }

}
