package esiCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EsiApp {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir"));
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/Test.png");
        BufferedImage image = ImageIO.read(file);
    }
}
