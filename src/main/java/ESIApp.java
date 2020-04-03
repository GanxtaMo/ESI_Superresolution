import model.ImageOperation;
import model.ImageReaderESI;

import java.io.IOException;

final class ESIApp {

    private static final int PAGENUM = 5000;

    private ESIApp() {

    }


    public static void main(final String... args) throws IOException {
        final ImageReaderESI readerESI = new ImageReaderESI("/src/main/resources/QD655.tif");
        final ImageOperation ops = new ImageOperation();

        //prints the intensity value of the first image at pos 0,0.
        System.out.format(Double.toString(readerESI.getPixelIntensity(0, 0, 0)));

        //prints the calculated average brightness of a pixel at pos 0,0 starting at frame 0 endig at frame 4999.
        System.out.format("AVG: " + ops.calculateAvg(
                readerESI.getFullPixelArray(0, 0, 0, PAGENUM)));

        //prints the calculated standard deviation of a pixel at pos 0,0 starting at frame 0 endig at frame 4999.
        System.out.format("Std: " + ops.calculateStd(
                readerESI.getFullPixelArray(0, 0, 0, PAGENUM)));


    }
}
