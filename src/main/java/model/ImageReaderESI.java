package model;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageReaderESI {

    private String path;

    public ImageReaderESI(final String path) {

        this.path = path;

    }

    public List<BufferedImage> read() throws IOException {

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
        List<BufferedImage> ImgList = new ArrayList<>();
        for (int i = 0; i < pageNum; i++) {
            ImgList.add(reader.read(i));
        }
        double[] arr = new double[pageNum];
        reader.read(0).getRaster().getPixel(0, 0, arr);
        System.out.println(arr[0]);

        return ImgList;
    }
}