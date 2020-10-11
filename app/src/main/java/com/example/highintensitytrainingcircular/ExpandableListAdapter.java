package com.example.highintensitytrainingcircular;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;


public class ExpandableListAdapter extends BaseExpandableListAdapter {


    private List<String> exerciceNames; // Store names of the exercices
    private HashMap<String, Exercice> mapOfExercices; // Map each exercise specific fields.
    private Context context; // Context of which activity will be in use.


    ExpandableListAdapter(Context context, List<String> exerciceNames, HashMap<String, Exercice> mapOfExercices){

        this.context = context;
        this.exerciceNames = exerciceNames;
        this.mapOfExercices = mapOfExercices;

    }


    // Functions where the views are inflated for each position.
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        //final Exercice exercice = (Exercice) getChild(groupPosition, childPosition);
        Log.d(TAG, "getChildView: Call");
        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_item, null);

        }

        TextView exerciseName = convertView.findViewById(R.id.exercise_name);
        exerciseName.setText(exerciceNames.get(childPosition));

        return convertView;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Log.d(TAG, "getGroupView: Call");
        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list_item, null);

        }

        TextView exerciseName = convertView.findViewById(R.id.exercise_name);
        exerciseName.setText(exerciceNames.get(groupPosition));

        return convertView;

    }



    // Numeric part of the code, where the count is set for the data structure length.

    @Override
    public int getGroupCount() {
        return this.exerciceNames.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.exerciceNames.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.mapOfExercices.get(this.exerciceNames.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
