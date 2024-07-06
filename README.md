# PDF Extractor
![Java CI with Maven](https://img.shields.io/badge/Java%20CI%20with%20Maven-blue.svg)
![Maven Central](https://img.shields.io/maven-central/v/in.precisiontestautomation.scriptlessautomation/pdf-extractor.svg)
![Version](https://img.shields.io/badge/version-4.4.0-blue.svg)
![Javadoc](https://img.shields.io/badge/javadoc-4.4.0-brightgreen.svg)
![PRs welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)

PDF Extractor is a simple Java application designed to extract text and hyperlinks from PDF files using Apache PDFBox.

## Table of Contents
- [Prerequisites](#Prerequisites)
- [Command-Line Interface (CLI) Usage](#Command-Line-Interface-(CLI)-Usage)
- [Programmatic Usage](#Programmatic-Usage)

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.6.0 or higher

## Command-Line Interface (CLI) Usage
### Build the Project

```
mvn clean package
```
### Run the Application
Use the following command to run the application from the command line:
```
java -cp target/pdf-extractor-1.0.0.jar com.yourpackage.Main
```
### Provide the PDF Path
When prompted, enter the path to the PDF file:
```
Enter the path to the PDF file: /path/to/your/file.pdf
```
### View the Output
The application will output the extracted text and links to the terminal.

## Programmatic Usage
Add Dependency
Add the following dependency to your pom.xml:
```
<dependency>
    <groupId>com.example.pdf</groupId>
    <artifactId>pdf-extractor</artifactId>
    <version>1.0.0</version>
</dependency>
```
**Use PdfTextExtractor and PdfLinkExtractor Classes**
```
import com.yourpackage.PdfTextExtractor;
import com.yourpackage.PdfLinkExtractor;

public class Example {
    public static void main(String[] args) {
        String pdfFilePath = "/path/to/your/file.pdf";
        PdfTextExtractor textExtractor = new PdfTextExtractor();
        PdfLinkExtractor linkExtractor = new PdfLinkExtractor();

        try {
            String text = textExtractor.extractText(pdfFilePath);
            List<String> links = linkExtractor.extractLinks(pdfFilePath);

            System.out.println("Text in the PDF:");
            System.out.println(text);

            System.out.println("Links in the PDF:");
            for (String link : links) {
                System.out.println(link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
