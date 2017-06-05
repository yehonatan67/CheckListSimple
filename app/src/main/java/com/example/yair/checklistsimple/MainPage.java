package com.example.yair.checklistsimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        final ArrayList<Goal> goalList = new ArrayList<Goal>();
        goalList.add(new Goal("Math", 3));
        goalList.add(new Goal("CS", 2));
        goalList.add(new Goal("Animation", 3));
        goalList.add(new Goal("Standing", 3));
        goalList.add(new Goal("Test", 4));

        GoalAdapter adapter = new GoalAdapter(this, goalList, R.color.myWhite);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        Button setGoals = (Button) findViewById(R.id.goals_button);

        setGoals.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lalala = new Intent(MainPage.this, SetGoalsActivity.class);
                startActivity(lalala);
                //Toast.makeText(MainPage.this, "working?" , Toast.LENGTH_SHORT).show();
            }
        });

    }

}


