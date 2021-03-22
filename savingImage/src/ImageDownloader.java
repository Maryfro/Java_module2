import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class ImageDownloader {
    public static void main(String[] args) throws IOException {
        downloadImage("https://upload.wikimedia.org/wikipedia/commons/4/4c/Push_van_cat.jpg");
        // GrayScale.grayScale(new ImageIcon("\\bird.jpg").getImage());
    }

    public static void downloadImage(String sourceURL)
            throws MalformedURLException, IOException, FileNotFoundException {
        URL imageURL = new URL(sourceURL);
        InputStream in = imageURL.openStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream("cat.jpg"));
        for (int i; (i = in.read()) != -1; ) {
            out.write(i);
        }
        in.close();
        out.close();
    }
       /*

        try(InputStream imageReader = new BufferedInputStream(imageURL.openStream())){
            OutputStream imageWriter = new BufferedOutputStream(new FileOutputStream(targetDirectory + File.separator
            + FilenameUtils.getName(sourceURL))
        }*/


}

