import model.ImageOperation;
import model.ImageReaderESI;

import java.io.IOException;

public class ESIApp {

    public static void main(String[] args) throws IOException {
        ImageReaderESI readerESI = new ImageReaderESI("/src/main/resources/QD655.tif");
        ImageOperation ops = new ImageOperation();
        System.out.println(readerESI.getPixelIntensity(0, 0, 0)); //prints the intensity value of the first image at pos 0,0.
        System.out.println("AVG: " + ops.calculateAvg(readerESI.getFullPixelArray(0, 0, 0, 4999))); //prints the calculated average brightness of a pixel at pos 0,0 starting at frame 0 endig at frame 4999.
        System.out.println("Std: " + ops.calculateStd(readerESI.getFullPixelArray(0, 0, 0, 4999))); //prints the calculated standard deviation of a pixel at pos 0,0 starting at frame 0 endig at frame 4999.


    }
}
