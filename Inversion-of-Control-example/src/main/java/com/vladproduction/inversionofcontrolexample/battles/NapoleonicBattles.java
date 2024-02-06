package com.vladproduction.inversionofcontrolexample.battles;

import java.util.ArrayList;

public class NapoleonicBattles {

    private ArrayList<Battle> battles = new ArrayList<>();

    public void setList(ArrayList<Battle> list) {

        this.battles = list;
    }

    public NapoleonicBattles() {
    }

    public void printBattles() {
        for (Battle battle : battles) {
            System.out.println(battle);
        }
        System.out.println("----------------");

    }
}
