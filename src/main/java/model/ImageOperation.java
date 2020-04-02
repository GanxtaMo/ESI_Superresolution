package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageOperation {
    private List<BufferedImage> ImgList;

    public ImageOperation(final List<BufferedImage> ImgList) {
        this.ImgList = ImgList;
    }

    public ImageOperation() {
    } //Default constructor

    public double calculateAvg(ArrayList pixelArray) { //Calculates the average intensity of a pixel array.
        double avg = 0.0;
        double dummy = 0.0;
        for (int i = 0; i < pixelArray.size(); i++) {
            dummy += (double) pixelArray.get(i);
        }
        avg = dummy / pixelArray.size();
        return avg;
    }

    public double calculateStd(ArrayList pixelArray) { //Calculates the standard deviation of a pixel array.
        double avg = calculateAvg(pixelArray);
        double dummy = 0.0;
        for (int i = 0; i < pixelArray.size(); i++) {
            dummy += Math.pow((double) pixelArray.get(i) - avg, 2);
        }

        return Math.sqrt(dummy / pixelArray.size());
    }


}
