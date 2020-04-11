package model;

import javax.imageio.ImageIO;
import java.awt.*;
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
        theImage = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        this.path = path;
    }

    public void setPixelValue(int xPos, int yPos, double value) {
        Color c = new Color((int) value);
        int red = ((int) value);
        int green = ((int) value);
        int blue = ((int) value);
        Color greyScaleColor = new Color(red + green + blue,
            red + green + blue, red + green + blue);
        theImage.setRGB(xPos, yPos, greyScaleColor.getRGB());
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
