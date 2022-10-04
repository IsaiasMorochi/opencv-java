package imorochi.signature;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public final class AdaptiveThreshold {

    public static BufferedImage adaptiveThreshold(Path inputFile) throws IOException {
        try {
            Mat src = Imgcodecs.imread(inputFile.toString(), Imgcodecs.IMREAD_GRAYSCALE);

            // Creating destination matrix
            Mat dst = new Mat(src.rows(), src.cols(), src.type());

            // Applying MedianBlur on the Image
            Imgproc.medianBlur(src, dst, 5);

            // Applying Adaptive threshold
            Imgproc.adaptiveThreshold(src, dst, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 11, 7);

            // Converting matrix to Bufferd Image
            Image img = HighGui.toBufferedImage(dst);

            Path pathInputImageTemp = Files.createTempFile("Firma_input_DEMO_" + System.currentTimeMillis(), ".png");
            saveImage((BufferedImage) img, "png", pathInputImageTemp.toString());

            return (BufferedImage) img;
        } catch (Exception e) {
            throw new IOException("[adaptiveThreshold] Error: " + e.getMessage());
        }
    }

    public static void saveImage(BufferedImage bufferedImage, String formatName, String fileOutput) {
        try {
            ImageIO.write(bufferedImage, formatName, new File(fileOutput));
        } catch (IOException e) {
            System.out.println("[CompressImage][saveImage] Failed to write image: "+ e.getMessage());
        }
    }


}
