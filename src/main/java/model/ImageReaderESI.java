package model;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageReaderESI {

    private String path;

public ImageReaderESI(final String path){

    this.path=path;

}

    public void read() throws IOException {

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
        javax.imageio.ImageReader reader = iterator.next();
        iterator = null;
        reader.setInput(is);
        int pageNum = reader.getNumImages(true);
        System.out.println("Anzahl der Pages des TiffImages: " + pageNum + " Bilder\n");
        //reader.read(Index der Seite) // Source: https://stackoverflow.com/questions/17770071/splitting-a-multipage-tiff-image-into-individual-images-java
    }
}