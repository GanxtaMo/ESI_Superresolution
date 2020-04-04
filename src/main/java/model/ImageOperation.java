package model;

import java.util.ArrayList;

public class ImageOperation {


    /**
     * @param pixelArray Pixel array for mean calculation
     * @return returns the mean intensity of pixel array as double.
     */
    public double calculateAvg(final ArrayList pixelArray) {
        double avg = 0.0;
        double dummy = 0.0;
        for (int i = 0; i < pixelArray.size(); i++) {
            dummy += (double) pixelArray.get(i);
        }
        avg = dummy / pixelArray.size();
        return avg;
    }

    /**
     * @param pixelArray Pixel array for standard deviation calculation.
     * @return The standard deviation as double value.
     */
    public double calculateStd(final ArrayList pixelArray) {
        final double avg = calculateAvg(pixelArray);
        double dummy = 0.0;
        for (int i = 0; i < pixelArray.size(); i++) {
            dummy += Math.pow((double) pixelArray.get(i) - avg, 2);
        }

        return Math.sqrt(dummy / pixelArray.size());
    }

    /**
     * @param pxValue
     * @param pixelArray
     * @return
     */
    public double calculateProbabilityForPxValue(final double pxValue, final ArrayList pixelArray) {
        double probability = 0.0;
        int counter = 0;
        final int convValue = (int) pxValue;
        final ArrayList<Double> probabilityArray = new ArrayList<>();

        if (probabilityArray.get(convValue) == null) {
            for (int i = 0; i < pixelArray.size(); i++) {
                if (convValue == (int) (pixelArray.get(i))) {
                    counter++;
                }
            }
            probability = counter / pixelArray.size();
            probabilityArray.add(convValue, probability);
            return probability;
            /*adds the probability of a given pixel intensity to the ArrayList at
         index=convValue to build up a performance table.*/


        } else {
            return probabilityArray.get(convValue);
            /*checks if the probability for the convValue already exists to avoid recalculation.*/
        }
    }

    /**
     * @param pixelArray
     * @return
     */
    public double calculateEntropyOfPxArray(final ArrayList pixelArray) {
        final double h = 0.0;

        return h;
    }
}
