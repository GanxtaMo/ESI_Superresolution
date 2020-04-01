package esiCode;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class EsiApp {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/QD655.tif");
        ImageInputStream is = ImageIO.createImageInputStream(file);
        if (is == null | is.length() == 0) {
            throw new IOException("Error");
        }
        Iterator<ImageReader> iterator = ImageIO.getImageReaders(is);
        if (iterator == null || !iterator.hasNext()) {
            throw new IOException("Image file format not supported by ImageIO: " + file.getAbsolutePath());
        }
        // We are just looking for the first reader compatible:
        ImageReader reader = iterator.next();
        iterator = null;
        reader.setInput(is);
        int pageNum = reader.getNumImages(true);
        System.out.println("Anzahl der Pages des TiffImages: " + pageNum + " Bilder\n");
        //reader.read(Index der Seite) // Source: https://stackoverflow.com/questions/17770071/splitting-a-multipage-tiff-image-into-individual-images-java
    }
}