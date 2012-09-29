package ru.main;

import ru.api.interfaces.IImageDownload;
import ru.downloader.ImageDownloader;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IImageDownload imageDownloader = new ImageDownloader();
//        IImageStore imageStore = new StoreFileDbFS();
//
//        byte[] image = imageDownloader
//                .getImageFromSite("http://liberaldead.com/blog/wp-content/uploads/marveluniverse.jpg");
        List<String> images = imageDownloader.getImagesList("http://showusyourass.tumblr.com/");

        BufferedOutputStream bufferedWriter = null;
        int i = 0;
        try {
            for (String image : images) {
                System.out.println("Downloading "+image);
                bufferedWriter = new BufferedOutputStream(new FileOutputStream(
                        "/Users/admin/Downloads/zjava/" + i + "_" + image.substring(image.length() - 4, image.length())));
                bufferedWriter.write(imageDownloader.getImageFromSite(image));
                bufferedWriter.close();
                i++;
                System.out.println("Downloading "+image+" complete");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("That's it");
    }

}
