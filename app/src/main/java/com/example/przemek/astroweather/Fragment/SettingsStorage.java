package com.example.przemek.astroweather.Fragment;

import android.content.SharedPreferences;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.przemek.astroweather.CustomException.BadRangeException;
import com.example.przemek.astroweather.SettingsActivity;


/**
 * Created by Przemek on 18.04.2018.
 */

public class SettingsStorage {

    private static SettingsStorage settingsStorage = null;
    private static double longitude;
    private static double latitude;
    private static Integer dataFrequencyRefresh;
    private static Integer timeZone;

    public final int MIN_TIME_OFFSET = -12;
    public final int MAX_TIME_OFFSET = 14;
    public final static int MAX_LONGITUDE = 80;
    public final static int MAX_LATITUDE = 80;
    public final static int MIN_LONGITUDE = -80;
    public final static int MIN_LATITUDE = -80;

    private SettingsStorage(){

    }

    public static SettingsStorage getInstance(){
        if(settingsStorage == null){
            settingsStorage = new SettingsStorage();

            latitude = 51.7537150;
            longitude = 19.4517180;
            dataFrequencyRefresh = 1;
            timeZone = 2;
        }
        return settingsStorage;
    }


    public static SharedPreferences mPrefs;

    public static void restoreData() throws BadRangeException{
        SettingsStorage.setLongitude(Double.parseDouble(mPrefs.getString("longitude", "50")));
        SettingsStorage.setLatitude(Double.parseDouble(mPrefs.getString("latitude", "50")));
        SettingsStorage.setTimeZone(mPrefs.getInt("time_zone", 4));
        SettingsStorage.setDataFrequencyRefresh(mPrefs.getInt("refresh", 4));
    }

    public static void saveData(){
        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.putString("longitude", String.valueOf(SettingsStorage.getLongitude())).commit();
        mEditor.putString("latitude", String.valueOf(SettingsStorage.getLatitude())).commit();
        mEditor.putInt("time_zone", SettingsStorage.getTimeZone()).commit();
        mEditor.putInt("refresh", SettingsStorage.getDataFrequencyRefresh()).commit();
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) throws BadRangeException {
        if(longitude > MAX_LONGITUDE){
            SettingsStorage.longitude = MAX_LONGITUDE;
            throw new BadRangeException("Longitude", MIN_LONGITUDE, MAX_LONGITUDE);
        }
        if(longitude < MIN_LONGITUDE){
            SettingsStorage.longitude = MIN_LONGITUDE;
            throw new BadRangeException("Longitude", MIN_LONGITUDE, MAX_LONGITUDE);
        }

        SettingsStorage.longitude = longitude;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) throws BadRangeException {
        if(latitude > MAX_LATITUDE){
            SettingsStorage.latitude = MAX_LATITUDE;
            throw new BadRangeException("Latitude", MIN_LATITUDE, MAX_LATITUDE);
        }
        if(latitude < MIN_LATITUDE){
            SettingsStorage.latitude = MIN_LATITUDE;
            throw new BadRangeException("Latitude", MIN_LATITUDE, MAX_LATITUDE);
        }

        SettingsStorage.latitude = latitude;
    }

    public static int getDataFrequencyRefresh() {
        return dataFrequencyRefresh;
    }

    public static void setDataFrequencyRefresh(int dataFrequencyRefresh) {
        SettingsStorage.dataFrequencyRefresh = dataFrequencyRefresh;
    }

    public static Integer getTimeZone() {
        return timeZone;
    }

    public static void setTimeZone(Integer timeZone) {
        SettingsStorage.timeZone = timeZone;
    }
}