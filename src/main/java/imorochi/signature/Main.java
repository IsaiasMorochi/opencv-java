package imorochi.signature;

import org.opencv.core.Core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static imorochi.signature.AdaptiveThreshold.adaptiveThreshold;

public class Main {

    public static void main(String[] args) throws IOException {

        // Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        System.out.println("SO: "+ System.getProperty("os.name"));
        System.out.println("Architecture: "+ System.getProperty("os.arch"));
        System.out.println("Java Path: {}"+ System.getProperty("java.library.path"));
        System.out.println("OPENCV VERSION: " + Core.VERSION);

        ClassLoader loader = Main.class.getClassLoader();
        File file = new File(loader.getResource("img/FIRMA11.jpg").getFile());
        System.out.println(file.getPath());

        adaptiveThreshold(Path.of(file.getPath()));

        System.out.println("successfully");
    }
}
