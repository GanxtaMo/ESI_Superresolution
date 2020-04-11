package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriterESI {

    private BufferedImage theImage;
    private String path;

    private int imgWidth;
    private int imgHeight;

    public ImageWriterESI(int imgWidth, int imgHeight, String path) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        theImage = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_BYTE_GRAY);
        this.path = path;
    }

    public void setPixelValue(int xPos, int yPos, double value) {
        double[] val = new double[1];
        val[0] = value;
        theImage.getRaster().setPixel(xPos, yPos, val);
        //theImage.setRGB(xPos,yPos,(int)value);

    }

    public void saveToFile() {
        File outputfile = new File(path);
        try {
            ImageIO.write(theImage, "tiff", outputfile);
        } catch (IOException e1) {
            System.out.println("unable to save file!");
        }
    }


}
