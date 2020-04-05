package model;

import java.util.*;

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

    public double calculateAvg(final HashMap<Double, Integer> pixelArray) {
        double avg = 0.0;
        double dummy = 0.0;
        Set entrySet = pixelArray.entrySet();

        Iterator it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            double d = (double) me.getKey();
            dummy += d;
        }
        return dummy / (double) pixelArray.size();
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
    public double calculateProbabilityForPxValue(final double pxValue, final HashMap<Double, Integer> pixelArray) {
        double probability = 0.0;
        int counter = 0;
        final int convValue = (int) pxValue;
        probability = pixelArray.get(pxValue) / (double) pixelArray.size();
        return probability;


    }

    /**
     * @param pixelArray
     * @return
     */
    public double calculateEntropyOfPxArray(final HashMap<Double, Integer> pixelArray) {
        double h = 0.0;

        Set entrySet = pixelArray.entrySet();

        Iterator it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            double d = (double) me.getKey();
            double tmp = calculateProbabilityForPxValue((double) me.getKey(), pixelArray);
            System.out.println(tmp);
            h += tmp * Math.log(tmp);
        }
        return h;
    }

    /**
     * @param order
     * @param pixelArray
     * @return
     */
    public double higherOrderMoment(final int order, final HashMap<Double, Integer> pixelArray) {

        final double avg = calculateAvg(pixelArray);
        final List<Double> powerOfDiffernces = new ArrayList<>();

        Set entrySet = pixelArray.entrySet();

        Iterator it = entrySet.iterator();

        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            double d = (double) me.getKey();
            powerOfDiffernces.add(Math.pow((double) (me.getKey()) - avg, order));
        }

        return calculateAvg(powerOfDiffernces);

    }
}
