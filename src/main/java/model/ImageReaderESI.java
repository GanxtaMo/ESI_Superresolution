package model;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageReaderESI {

    private String path;
    private int pageNum; //Number of pages of tiff-movie
    private javax.imageio.ImageReader reader; //ImageReader read set as global

    public ImageReaderESI(final String path) throws IOException {//The constructor now calls the read method to avoid calling it in the main method

        this.path = path;
        read();

    }

    public /*ImageReader*/ void read() throws IOException { //return set to void

        File file = new File(System.getProperty("user.dir") + path);
        ImageInputStream is = ImageIO.createImageInputStream(file);
        if (is == null | is.length() == 0) {
            throw new IOException("Error");
        }
        Iterator<javax.imageio.ImageReader> iterator = ImageIO.getImageReaders(is);

        if (iterator == null || !iterator.hasNext()) {
            throw new IOException("Image file format not supported by ImageIO: " + file.getAbsolutePath());
        }
        // We are just looking for the first reader compatible:
        /*javax.imageio.ImageReader*/
        reader = iterator.next();
        iterator = null;
        reader.setInput(is);
        pageNum = reader.getNumImages(true);
        // System.out.println("Anzahl der Pages des TiffImages: " + pageNum + " Bilder\n");
        //reader.read(Index der Seite) // Source: https://stackoverflow.com/questions/17770071/splitting-a-multipage-tiff-image-into-individual-images-java
        //return reader;
    }

    //the following method returns the brightness of a pixel of a given frame at position 'xPos,yPos' in a movie of length 'movieLength'
    public double getPixelIntensity(int frameNo, int xPos, int yPos) throws IOException {
        double[] arr = new double[1];
        reader.read(frameNo).getRaster().getPixel(xPos, yPos, arr);
        return arr[0];
    }

    public ArrayList<Double> getFullPixelArray(int xPos, int yPos, int startFrame, int endframe) throws IOException {
        ArrayList<Double> pxIntensities = new ArrayList<Double>();

        for (int i = startFrame; i < endframe; i++) {
            pxIntensities.add(getPixelIntensity(i, xPos, yPos));
        }

        return pxIntensities;


    }
}