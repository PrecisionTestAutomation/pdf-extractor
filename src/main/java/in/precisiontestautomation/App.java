package in.precisiontestautomation;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author PTA-dev
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path containing PDFs: ");
        String pdfDirectory = scanner.nextLine();

        System.out.print("Enter the output file path: ");
        String outputFilePath = scanner.nextLine();

        try {
            PdfExtractor.extractTextFromPdfs(pdfDirectory, outputFilePath);
            System.out.println("Text extraction complete. Output saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error extracting text from PDFs: " + e.getMessage());
        }

        scanner.close();
    }
}
