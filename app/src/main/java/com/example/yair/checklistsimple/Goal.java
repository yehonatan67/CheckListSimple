package com.example.yair.checklistsimple;



public class Goal {

    private String goalName;
    private int hours;

    public Goal (String name, int h){

        goalName = name;
        hours = h;
    }

    public String getGoalName(){
        return goalName;
    }

    public int getHours(){
        return hours;
    }

    public String toString(){
        return String.valueOf(hours);
    }


}
