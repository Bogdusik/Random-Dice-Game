import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImgService {
    public static JLabel loadImage(String filePath) {
        try (InputStream inputStream = ImgService.class.getResourceAsStream(filePath)) {
            BufferedImage image = ImageIO.read(inputStream);
            return new JLabel(new ImageIcon(image));
        } catch (IOException | NullPointerException e) {
            System.err.println("Error loading image: " + e.getMessage());
            return new JLabel();
        }
    }

    public static void updateImage(JLabel imageContainer, String filePath) {
        try (InputStream inputStream = ImgService.class.getResourceAsStream(filePath)) {
            BufferedImage image = ImageIO.read(inputStream);
            imageContainer.setIcon(new ImageIcon(image));
        } catch (IOException | NullPointerException e) {
            System.err.println("Error updating image: " + e.getMessage());
        }
    }
}
