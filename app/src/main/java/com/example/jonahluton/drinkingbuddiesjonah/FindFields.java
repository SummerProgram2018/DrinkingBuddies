package com.example.jonahluton.drinkingbuddiesjonah;

import java.util.ArrayList;

public class FindFields {


    private int groupSize = 0;
    public ArrayList<String> drinks;
    private int range = 0;

    public FindFields(){
    }

    public FindFields(int groupSize, int range, ArrayList<String> drinks){
        this.groupSize = groupSize;
        this.drinks = drinks;
        this.range = range;
    }

    public void setRange(int i){
        if (!(i>1)){
            return;
        }
            range = i;

    }

    public int getRange(){
        return range;
    }

    public int getGroupSize(){
        return groupSize;
    }

    public void setGroupSize(int i){
        if (!(i>2)){
            return;
        }
            groupSize = i;

    }
}