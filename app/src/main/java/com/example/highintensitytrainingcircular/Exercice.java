package com.example.highintensitytrainingcircular;

public class Exercice {

    String name;

    int time;


    Exercice(String name, int time){

        this.name = name;
        this.time = time;

    }

    // Getter functions
    public int getTime() {
        return time;
    }

    // Setter functions
    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
