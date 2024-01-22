package org.kulynych;

import org.kulynych.entity.Cow;
import org.kulynych.service.SimpleDairyFarm;

public class Main {
    public static void main(String[] args) {

        //TODO data structure is simple tree, so search has linear complexity.
        //Each node has link to next sibling and next child
        //Printer do job by tree branches starting from root

        DairyFarm farm = new SimpleDairyFarm();

        farm.giveBirth("1", new Cow("2", "child_1_1", "1"));

        farm.giveBirth("2", new Cow("3", "child_2_1", "2"));

        farm.giveBirth("1", new Cow("4", "child_1_2", "1"));

        farm.giveBirth("3", new Cow("5", "child_3_1", "3"));

        farm.giveBirth("2", new Cow("6", "child_2_1", "2"));

        farm.giveBirth("5", new Cow("7", "child_5_1", "5"));

        farm.printFarmData();


        farm.endLifeSpan("3");
        System.out.println();
        System.out.println("Cow 3 is gone to her vacation");
        farm.printFarmData();

    }
}