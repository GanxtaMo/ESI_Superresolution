package model;

import java.util.ArrayList;
import java.util.List;

public class ImageOperation {


    /**
     * @param pixelArray Pixel array for mean calculation
     * @return returns the mean intensity of pixel array as double.
     */
    public double calculateAvg(final List<Double> pixelArray) {
        double avg = 0.0;
        double dummy = 0.0;
        for (final double d : pixelArray) {
            dummy += d;
        }
        avg = dummy / pixelArray.size();
        return avg;
    }

    /**
     * @param pixelArray Pixel array for standard deviation calculation.
     * @return The standard deviation as double value.
     */
    public double calculateStd(final List<Double> pixelArray) {
        final double avg = calculateAvg(pixelArray);
        double dummy = 0.0;
        for (final double d : pixelArray) {
            dummy += Math.pow(d - avg, 2);
        }

        return Math.sqrt(dummy / pixelArray.size());
    }

    /**
     * @param pxValue
     * @param pixelArray
     * @return
     */
    public double calculateProbabilityForPxValue(final double pxValue, final List<Double> pixelArray) {
        double probability = 0.0;
        int counter = 0;
        final int convValue = (int) pxValue;
        final List<Double> probabilityArray = new ArrayList<>();

        if (probabilityArray.get(convValue) == null) {
            for (final double d : pixelArray) {
                if (convValue == (int) (d)) {
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
    public double calculateEntropyOfPxArray(final List<Double> pixelArray) {
        double h = 0.0;
        for (final double d : pixelArray) {
            final double tmp = calculateProbabilityForPxValue(d, pixelArray);
            h += tmp * Math.log10(tmp);
        }
        return -h;
    }

    public double higherOrderMoment() {

        return 0.0;

    }
}
