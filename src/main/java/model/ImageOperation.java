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

    public double calculateProbabilityForPxValue(final double pxValue, final ArrayList pixelArray) {
        double p = 0.0;

        return p;
    }

    public double calculateEntropyOfPxArray(final ArrayList pixelArray) {
        double h = 0.0;

        return h;
    }
}
