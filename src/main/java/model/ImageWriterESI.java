package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriterESI {

    private String path;

    public ImageWriterESI(final String path) throws IOException {
        this.path = path;
    }


    public void writePixel(int x, int y, double value) {
        BufferedImage theImage = new BufferedImage(x, y,
            BufferedImage.TYPE_BYTE_BINARY);

        theImage.setRGB(x, y, (int) (value));

        File outputfile = new File(path);
        try {
            ImageIO.write(theImage, "png", outputfile);
        } catch (IOException e1) {
            System.out.println("Unable to write file: " + e1.getStackTrace());

        }

    }


}
