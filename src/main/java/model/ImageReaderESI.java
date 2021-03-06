package model;


import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ImageReaderESI {

    private String path;
    private javax.imageio.ImageReader reader; //ImageReader read set as global

    //The constructor now calls the read method to avoid calling it in the main method

    /**
     * @param path Path of the image file.
     * @throws IOException Throws an IOException when path is invalid.
     */
    public ImageReaderESI(final String path) throws IOException {
        this.path = path;
    }


    /**
     * Reads the specified image file.
     *
     * @throws IOException Throws IOException in case of invalid convertion of image and no matching ImageReader
     */
    public void read() throws IOException {

        final File file = new File(System.getProperty("user.dir") + path);
        final ImageInputStream is = ImageIO.createImageInputStream(file);
        if (is == null | is.length() == 0) {
            throw new IOException("Error");
        }
        final Iterator<javax.imageio.ImageReader> iterator = ImageIO.getImageReaders(is);

        if (iterator == null || !iterator.hasNext()) {
            throw new IOException("Image file format not supported by ImageIO: " + file.getAbsolutePath());
        }
        // We are just looking for the first reader compatible:
        /*javax.imageio.ImageReader*/
        this.reader = iterator.next();
        this.reader.setInput(is);
    }

    /**
     * @param frameNo Index of the frame.
     * @param xPos    X-Coordinate of the pixel.
     * @param yPos    Y-Coordinate of the pixel.
     * @return Returns the brightness of a pixel of a frame at position 'xPos,yPos'
     * @throws IOException Throws exception in case of error while reading the frame.
     */
    public double getPixelIntensity(final int frameNo, final int xPos, final int yPos) throws IOException {
        final double[] arr = new double[1];
        reader.read(frameNo).getRaster().getPixel(xPos, yPos, arr);
        return arr[0];
    }

    /**
     * @param xPos       X-Coordinate of the pixel.
     * @param yPos       Y-Coordinate of the pixel.
     * @param startFrame Starting frame of the frame sequence.
     * @param endframe   Ending frame of the frame sequence.
     * @return The intensities of a specific pixel over all frames.
     * @throws IOException Throws IOException in case there's an error while reading the frame.
     */
    public HashMap<Double, Integer> getFullPixelArray(final int xPos, final int yPos, final int startFrame, final int endframe) throws IOException {
        int count = 1;
        int tmp = 0;
        final HashMap<Double, Integer> pxIntensities = new HashMap<>();
        for (int i = startFrame; i < endframe; i++) {
            if (pxIntensities.get(getPixelIntensity(i, xPos, yPos)) == null) {
                pxIntensities.put(getPixelIntensity(i, xPos, yPos), count);
            } else {
                tmp = pxIntensities.get(getPixelIntensity(i, xPos, yPos));
                tmp++;
                pxIntensities.put(getPixelIntensity(i, xPos, yPos), tmp);
            }
        }

        return pxIntensities;


    }
}
