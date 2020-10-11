package com.example.highintensitytrainingcircular;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListExercices;
    private HashMap<String, Exercice> exerciceHashMap;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: 9/20/2020 Initialize progressbar to full capacity before creating the view. In order to provide a complete user experience.



        final ProgressBar circleBar = findViewById(R.id.progress_bar);
        TextView startTimer = findViewById(R.id.button_start);

        init();
        expandableListView.setAdapter(expandableListAdapter);



        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //circleProgressBarBehaviour(circleBar);
                circleBar.setMax(100*2); // Set max and progress of the progressbar dynamically when pressing the start button of the timer.
                circleBar.setProgress(200);// Limitation: It only fills the progress bar after pressed.

                startTimer(2, circleBar);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    // =========================================================== Functions outside of activity lifecycle ==========================================================================

    private void manageActivities(){

        return;

    }
    private void startTimer(final int minuti, final ProgressBar barTimer) {


        CountDownTimer countDownTimer = new CountDownTimer(60 * minuti * 1000, 1000) {
            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 600;
                barTimer.setProgress((int) seconds);
                //textTimer.setText(String.format("%02d", seconds/60) + ":" + String.format("%02d", seconds%60));
            }

            @Override
            public void onFinish() {
//                if(textTimer.getText().equals("00:00")){
//                    textTimer.setText("STOP");
//                }
//                else{
//                    textTimer.setText("2:00");
//                    barTimer.setProgress(60*minuti);
//                }
            }
        }.start();

    }

    private void init(){

        this.expandableListView = findViewById(R.id.expandable_list_view);
        this.exerciceHashMap = getExercisesMap();
        this.expandableListExercices = new ArrayList<>(this.exerciceHashMap.keySet());
        this.expandableListAdapter = new ExpandableListAdapter(getApplicationContext(),  expandableListExercices, exerciceHashMap);

    }


    private HashMap<String, Exercice> getExercisesMap(){

        HashMap<String, Exercice> exerciceHashMap = new HashMap<>();

        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));
        exerciceHashMap.put("Running", new Exercice("Running", 20));

        return exerciceHashMap;
    }


}











































































