package com.company;

public class GainsSimulator {

    private double gainsPerWeek;
    private double startingWeight;
    private final double diminishingReturnsValue;
    private double startingReps;
    private double startingTime;

    public GainsSimulator(int gainsPerWeek, int startingWeight, double diminishingReturnsValue) {
        this.gainsPerWeek = gainsPerWeek;
        this.startingWeight = startingWeight;
        this.diminishingReturnsValue = diminishingReturnsValue;
    }

    public GainsSimulator(int gainsPerWeek, int startingReps, double diminishingReturnsValue) {
        this.gainsPerWeek = gainsPerWeek;
        this.startingReps = startingReps;
        this.diminishingReturnsValue = diminishingReturnsValue;
    }

    public String generateIncreasingWeightValue(int setsAndReps) {

        //Induce natural plato
        gainsPerWeek = gainsPerWeek * diminishingReturnsValue;

        //Add gains since last workout
        startingWeight = startingWeight + gainsPerWeek;

        //Adjust the weight depending on how many reps and sets
        double adjustedStartingWeight = startingWeight;
        if (setsAndReps == 0) {
            adjustedStartingWeight = startingWeight * .93;
        } else if (setsAndReps == 1) {
            adjustedStartingWeight = startingWeight * .90;
        } else if (setsAndReps == 2) {
            adjustedStartingWeight = startingWeight * .87;
        } else if (setsAndReps == 3) {
            adjustedStartingWeight = startingWeight * .87;
        } else if (setsAndReps == 4) {
            adjustedStartingWeight = startingWeight * .85;
        } else if (setsAndReps == 5) {
            adjustedStartingWeight = startingWeight * .8;
        } else if (setsAndReps == 6) {
            adjustedStartingWeight = startingWeight * .8;
        } else if (setsAndReps == 7) {
            adjustedStartingWeight = startingWeight * .75;
        } else if (setsAndReps == 8) {
            adjustedStartingWeight = startingWeight * .75;
        } else if (setsAndReps == 9) {
            adjustedStartingWeight = startingWeight * .71;
        } else if (setsAndReps == 10) {
            adjustedStartingWeight = startingWeight * .67;
        } else if (setsAndReps == 11) {
            adjustedStartingWeight = startingWeight * .60;
        }


        //Add total
        int total = (int)(adjustedStartingWeight + gainsPerWeek);
        StringBuilder result = new StringBuilder();
        result.append(total - (total % 5));
        return result.toString();

    }

    public String generateIncreasingRepValue() {

        //Induce natural plato
        gainsPerWeek = gainsPerWeek * diminishingReturnsValue;

        //Add gains since last workout
        startingReps = startingReps + gainsPerWeek;

        //Add total
        StringBuilder result = new StringBuilder();
        result.append(startingReps - (startingReps % 5));

        return result.toString();

    }


    public double getGainsPerWeek() {
        return gainsPerWeek;
    }
}
