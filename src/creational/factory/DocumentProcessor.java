package creational.factory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

/**
 * Document Processing System
 * Problem Statement:
 * You're building a document processing system that supports various formats like PDF, Word, and Excel. Each document type has different parsing and rendering behavior. You need a scalable solution to instantiate the correct parser depending on the input file type.
 *
 * Solution via Factory Pattern:
 * Create a document parser factory that returns the appropriate parser object based on the file extension or content type.
 */

interface Parser {
    void parse();
}

class PDFProcessor implements Parser {
    @Override
    public void parse() {
        System.out.println("Parsing the PDF file");
    }
}

class WordProcessor implements Parser {
    @Override
    public void parse() {
        System.out.println("Parsing the word file");
    }
}

class ExcelProcessor implements Parser {
    @Override
    public void parse() {
        System.out.println("Parsing the excel file");
    }
}

class ParserFactory {

    public static Parser getParser(String documentType) {
        if (documentType.equalsIgnoreCase("word")) {
            return new WordProcessor();
        } else if (documentType.equalsIgnoreCase("excel")) {
            return new ExcelProcessor();
        } else if (documentType.equalsIgnoreCase("pdf")) {
            return new PDFProcessor();
        }

        throw new IllegalArgumentException("Unknown file type: " + documentType);
    }
}

class DocumentProcessorService {
    public void process(String documentType) {
        Parser parser = ParserFactory.getParser(documentType);
        parser.parse();
    }
}

public class DocumentProcessor {
    public static void main(String[] args) {
        DocumentProcessorService service = new DocumentProcessorService();
        service.process("PDF");
        service.process("excel");
        service.process("word");
        service.process("jpeg");
    }
}
