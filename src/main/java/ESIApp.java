import model.ImageReaderESI;

import java.io.IOException;

public class ESIApp {

    public static void main(String[] args) throws IOException {
        ImageReaderESI readerESI = new ImageReaderESI("/src/main/resources/QD655.tif");
        readerESI.read();
    }
}
