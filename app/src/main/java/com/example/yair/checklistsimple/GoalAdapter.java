package com.example.yair.checklistsimple;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class GoalAdapter extends ArrayAdapter<Goal>  {

    private int mColorResourceId;


    public GoalAdapter(Context context, ArrayList<Goal> goalList, int colorResourceId) {
        super(context, 0, goalList);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Goal currentGoal = getItem(position);

        TextView goalTextView = (TextView) listItemView.findViewById(R.id.goal_text);

        goalTextView.setText(currentGoal.getGoalName());

        TextView hourTextView = (TextView) listItemView.findViewById(R.id.hour_text);

        hourTextView.setText(currentGoal.toString());

        TextView hTextView = (TextView) listItemView.findViewById(R.id.hour_h);

        hTextView.setText("H");



        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}