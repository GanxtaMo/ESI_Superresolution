import model.ImageOperation;
import model.ImageReaderESI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ESIApp {

    public static void main(String[] args) throws IOException {
        List<BufferedImage> ImgList = new ArrayList<>();
        ImageReaderESI readerESI = new ImageReaderESI("/src/main/resources/QD655.tif");
        ImgList=readerESI.read();
        ImageOperation imageOperation= new ImageOperation(ImgList);
    }
}
