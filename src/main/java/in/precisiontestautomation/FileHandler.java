package in.precisiontestautomation;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author PTA-dev
 */
public class FileHandler {
    public static void saveTextToFile(String text, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
