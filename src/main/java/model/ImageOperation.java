package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageOperation {
    private List<BufferedImage> ImgList;

    public ImageOperation(final List<BufferedImage> ImgList) {
        this.ImgList = ImgList;
    }

    public double calculateAvg(ArrayList pixel) {
        double avg = 0.0;
        double dummy = 0.0;
        for (int i = 0; i <= pixel.size(); i++) {
            dummy += (double) pixel.get(i);
        }
        return avg;
    }
}
