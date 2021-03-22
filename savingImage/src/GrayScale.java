import javax.swing.*;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;

public class GrayScale {
    public static Image grayScale(Image colorImage) {
        ImageFilter filter = new GrayFilter(true, 50);
        //Image colorImage = Toolkit.getDefaultToolkit().getImage("cat.jpg");
        ImageProducer producer = new FilteredImageSource(colorImage.getSource(), filter);
        Image image = Toolkit.getDefaultToolkit().createImage(producer);
        return image;
    }
}
