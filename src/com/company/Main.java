package com.company;

public class Main {

    public static void main(String[] args) {

        int setsAndReps[][] = {
                {8, 3},
                {6, 4},
                {3, 5},
                {5, 5},
                {4, 6},
                {3, 8},
                {4, 8},
                {3, 10},
                {4, 10},
                {2, 12},
                {2, 15},
                {2, 20}
        };

        int personalityVaughan[] = {0,0,15,0,20,30,0,15,0,20,0,0};
        int personalityBodyBuilder[] = {0,0,0,0,10,0,30,20,40, 0,0,0};
        int personalityEnduranceFreak[] = {0,0,0,0,0,0,0,0,25,25,25,25};
        int personalityStrengthIsEverything[] = {40,20,20,20,0,0,0,0,0,0,0,0};
        int personalityJames[] = {0,0,0,0,0,0,0,100,0,0,0,0};


        WorkoutRandomizeService workoutRandomizeService = new WorkoutRandomizeService(setsAndReps);
        GainsSimulator benchWeightSimulator = new GainsSimulator(2, 180, .990);
        GainsSimulator dumbellFlyWeightSimulator = new GainsSimulator(1, 35, .988);

        /*
        //Printing out statistics to console
        int numberOfWeeks = 1000;
        int chosenPersonality[] = personalityVaughan;
        for (int i = 0; i < numberOfWeeks; i++) {
            int randomSetAndRep = workoutRandomizeService.pickRandomSetRepCombo(chosenPersonality.clone());
            System.out.println(setsAndReps[randomSetAndRep][0] + ", " + setsAndReps[randomSetAndRep][1] + ", " + dumbellFlyWeightSimulator.generateIncreasingWeightValue(randomSetAndRep));
        }
        */

        /*
        //Printing out SQL statements for bootstrap data
        int numberOfWeeks = 16;
        int workoutsPerWeek = 2;
        int chosenPersonality[] = personalityVaughan;
        workoutRandomizeService.printWorkoutBootstrapStatements(numberOfWeeks * workoutsPerWeek);
        */

        //Print out exercise statements for bootstrap data
        int numberOfWeeks = 16;
        int workoutsPerWeek = 2;
        int chosenPersonality[] = personalityVaughan;
        workoutRandomizeService.printExerciseDetailsBootstrapStatements(numberOfWeeks * workoutsPerWeek, chosenPersonality);

        /*
        //run test on random workout picker
        workoutRandomizeService.pickRandomSetRepComboTest(personalityVaughan, 100000);
        */







    }
}