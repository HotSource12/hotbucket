package com.hotsource.hotbucket.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by KSJ on 2016-12-20.
 * SharedPreference Class
 */
public class HotPreference {
    private static HotPreference mHotSP = null;
    private SharedPreferences mPref;
    //Key String
    public final static String PREFIX_SPINER_SORT = "SORT";

    private HotPreference(Context context) {
        mPref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /** SharedPreference HotPreference.getInstance() 로 불러서 사용하면 된다*/
    public static HotPreference getInstance(Context context) {
        if (mHotSP == null) {
            mHotSP = new HotPreference(context);
        }
        return mHotSP;
    }
    /**
     * string 저장
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * boolean 저장
     * @param key
     * @param value
     */
    public void put(String key, boolean value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * int 저장
     * @param key
     * @param value
     */
    public void put(String key, int value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * String get
     * @param key Key
     * @param dftValue default value
     * @return
     */
    public String getValue(String key, String dftValue) {
        try {
            return mPref.getString(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }

    /**
     * int get
     * @param key
     * @param dftValue default value
     * @return
     */
    public int getValue(String key, int dftValue) {
        try {
            return mPref.getInt(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }

    /**
     * boolean get
     * @param key
     * @param dftValue
     * @return
     */
    public boolean getValue(String key, boolean dftValue) {
        try {
            return mPref.getBoolean(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }
}
