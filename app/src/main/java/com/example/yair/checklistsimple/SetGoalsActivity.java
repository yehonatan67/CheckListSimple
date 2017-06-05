package com.example.yair.checklistsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yeya2 on 26/05/2017.
 */

public class SetGoalsActivity extends AppCompatActivity {

    EditText userGoal;
    EditText userHours;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_goals_layout);

        userGoal = (EditText) findViewById(R.id.user_goal_name);
        userHours = (EditText) findViewById(R.id.user_hours);
        myText = (TextView) findViewById(R.id.my_text);



    }

    public void saveInfo(View view){

        //SharedPreferences goalsDB = getSharedPreferences("userGoals", Context.MODE_PRIVATE);
        // SharedPreferences.Editor editor = goalsDB.edit();

        GoalsArray.addGoal(this, "Math");
        GoalsArray.addGoal(this, "Animation");


        // editor.putString("GoalName", userGoal.getText().toString());
        //editor.putInt("GoalHours", Integer.parseInt(userHours.getText().toString()));
        //editor.apply();

        String[] goals = GoalsArray.getGoalList(this);

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

    }

    public void displayInfo(View view){
        SharedPreferences goalsDB = getSharedPreferences("userGoals", Context.MODE_PRIVATE);

        String name = goalsDB.getString("GoalName","");
        int hours = goalsDB.getInt("GoalHours", 0);

        myText.setText(name + "    " + hours);

    }


}
