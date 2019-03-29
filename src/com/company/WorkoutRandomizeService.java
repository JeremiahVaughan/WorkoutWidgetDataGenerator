package com.company;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class WorkoutRandomizeService {

    private final int setsAndReps[][];

    public WorkoutRandomizeService(int[][] setsAndReps) {
        this.setsAndReps = setsAndReps;
    }

    public int[][] getSetsAndReps() {
        return setsAndReps;
    }


    public int pickRandomSetRepCombo(int personalityWeights[]) {

        //Figuring out how big our pool numbers to choose from is
        int max = IntStream.of(personalityWeights).sum() - 1;
        int min = 0;
        int range = max - min;

        //Choosing a random value from our pool
        int randomVal = (int) Math.round(Math.random() * range) + min;
        if (randomVal == 100) randomVal = 99; //guard against truncation


        //Discovering which set and rep group our chosen value belongs to
        int favoredRoutine = 0;
        int counter = 0;
        while(counter < max) {
            while (personalityWeights[favoredRoutine] != 0) {
                if (counter == randomVal) {
                    return favoredRoutine;
                }
                personalityWeights[favoredRoutine] = personalityWeights[favoredRoutine] - 1;
                counter = counter + 1;
            }
            favoredRoutine++;
        }
        return 0;

    }

    public void pickRandomSetRepComboTest(int personalityWeights[], int numberOfTestIterations) {

        int[] chosenSetsAndReps = new int[personalityWeights.length];
        int workoutSelections = numberOfTestIterations;
        int counter = 0;
        while (counter < workoutSelections) {
            int setAndRepCombo = pickRandomSetRepCombo(personalityWeights.clone());
            chosenSetsAndReps[setAndRepCombo]++;
            counter++;
        }

        //print test results to screen
        for (int counter2 = 0; counter2 < personalityWeights.length; counter2++) {
            System.out.print(chosenSetsAndReps[counter2] + ", ");
        }
    }

    public void printWorkoutBootstrapStatements(int numberOfWorkouts) {
        int dayIncrement = 2;
        for (int i = 0; i < numberOfWorkouts; i++) {
            System.out.println(
                    "Workout workout" + i + " = new Workout();\n" +
                    "workout" + i + ".setName(\"Workout " + i + "\");" +
                    "workout" + i + ".setDate(LocalDate.now().minusDays(" + dayIncrement + " ));\n" +
                    "workout" + i + ".setPerson(person);\n\n" +
                    "person.getWorkouts().add(workout" + i + ");\n"
            );

            dayIncrement = dayIncrement + 2;
        }

    }

    public void printExerciseDetailsBootstrapStatements(int numberOfWorkouts, int chosenPersonality[]) {
        int numberOfExercises = 9;
        int currentWorkout = 0;
        for (int i = 0; i < (numberOfWorkouts * numberOfExercises); i++) {
            if (i % 9 == 0) {
                currentWorkout++;
            }
            int randomSetAndRep = pickRandomSetRepCombo(chosenPersonality.clone());
            GainsSimulator genericWeightSimulator = new GainsSimulator(2, 180, .990);
            System.out.println(
                    "ExerciseDetails exerciseDetails" + i + " = new ExerciseDetails();\n" +
                            "exerciseDetails" + i + ".setSets(" + setsAndReps[randomSetAndRep][0] + ");\n" +
                            "exerciseDetails" + i + ".setReps(" + setsAndReps[randomSetAndRep][1] + ");\n" +
                            "exerciseDetails" + i + ".setWeight(" + genericWeightSimulator.generateIncreasingWeightValue(randomSetAndRep) + ".00);\n" +
                            "exerciseDetails" + i + ".setExercise(exercise" + ((i % numberOfExercises) + 1) + ");\n" +
                            "exerciseDetails" + i + ".setWorkout(workout" + currentWorkout + ");\n\n" +
                            "log.debug(\"Saving exercise details.\");\n" +
                            "exerciseDetailsService.save(exerciseDetails" + i + ");\n"

            );


        }
    }
}
