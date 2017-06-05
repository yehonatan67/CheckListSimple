package com.example.yair.checklistsimple;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by yeya2 on 26/05/2017.
 */

public abstract class GoalsArray {


    public static boolean addGoal(Activity activity, String goalName){
        //Get previous favorite items
        String goalList = getStringFromPreferences(activity,null,"goalName");
        // Append new Favorite item
        if(goalList!=null){
            goalList = goalList+","+goalName;
        }else{
            goalList = goalName;
        }
        // Save in Shared Preferences
        return putStringInPreferences(activity,goalList,"goals");
    }
    public static String[] getGoalList(Activity activity){
        String goalList = getStringFromPreferences(activity,null,"goals");
        return convertStringToArray(goalList);
    }
    private static boolean putStringInPreferences(Activity activity,String nick,String key){
        SharedPreferences sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, nick);
        editor.commit();
        return true;
    }
    private static String getStringFromPreferences(Activity activity,String defaultValue,String key){
        SharedPreferences sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
        String temp = sharedPreferences.getString(key, defaultValue);
        return temp;
    }

    private static String[] convertStringToArray(String str){
        String[] arr = str.split(",");
        return arr;
    }
}
