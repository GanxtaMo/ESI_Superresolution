import model.ImageReaderESI;

import java.io.IOException;

public class ESIApp {

    public static void main(String[] args) throws IOException {
        ImageReaderESI readerESI = new ImageReaderESI("/src/main/resources/QD655.tif");
        System.out.println(readerESI.getPixelIntensity(0, 0, 0, 10)); //prints the intensity value of the first image at pos 0,0. The movie length is arbitrarily set to 10 and has no effect yet.

    }
}
