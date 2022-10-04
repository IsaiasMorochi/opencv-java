package imorochi.signature;

import org.opencv.core.Core;

public class Main {

    public static void main(String[] args) {

        // Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        System.out.println("SO: "+ System.getProperty("os.name"));
        System.out.println("Architecture: "+ System.getProperty("os.arch"));
        System.out.println("Java Path: {}"+ System.getProperty("java.library.path"));
        System.out.println("OPENCV VERSION: " + Core.VERSION);

        System.out.println("successfully");
    }
}
