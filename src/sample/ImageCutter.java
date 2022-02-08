package sample;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class ImageCutter {
    public static Image[][] cut(Image image, int width, int height){
        PixelReader reader = image.getPixelReader();
        Image tab[][] = new Image[width][height];
        for (int i = 0; i <tab.length ; i++) {
            for (int j = 0; j <tab[i].length; j++) {
                WritableImage newImage = new WritableImage(reader, (int)(i*(image.getWidth()/width)),(int)(j*(image.getHeight()/height)) , (int)image.getWidth()/width, (int)image.getHeight()/height);
                tab[i][j]=newImage;
            }
        }
        return tab;
    }
}
