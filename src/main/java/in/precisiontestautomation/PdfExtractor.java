package in.precisiontestautomation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author PTA-dev
 */
public class PdfExtractor {
    public static void extractTextFromPdfs(String directoryPath, String outputFilePath) throws IOException {
        Path dirPath = Paths.get(directoryPath);
        StringBuilder stringBuilder = new StringBuilder();

        if (Files.isDirectory(dirPath)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath)) {
                for (Path entry : stream) {
                    if (entry.toString().endsWith(".pdf")) {
                        try (PDDocument document = PDDocument.load(new File(entry.toAbsolutePath().toString()))) {
                            PDFTextStripper pdfStripper = new PDFTextStripper();
                            stringBuilder.append("\n--- Start of PDF ---\n"+pdfStripper.getText(document));

                            for (PDPage page : document.getPages()) {
                                List<PDAnnotation> annotations = page.getAnnotations();

                                for (PDAnnotation annotation : annotations) {
                                    if (annotation instanceof PDAnnotationLink) {
                                        PDAnnotationLink link = (PDAnnotationLink) annotation;
                                        if (link.getAction() instanceof PDActionURI) {
                                            PDActionURI uri = (PDActionURI) link.getAction();
                                            stringBuilder.append("Link: " + uri.getURI()+"\n");
                                        }
                                    }
                                }
                            }

                            stringBuilder.append("\n--- End of PDF ---\n");
                        }
                    }
                }
            }
        }

        FileHandler.saveTextToFile(stringBuilder.toString(), outputFilePath);
    }
}
