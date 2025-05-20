package creational.abstractfactory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 21/05/25
 */

/**
 * Document Editor Plugin Architecture
 * Original (Factory): Creating a parser for one document type.
 * Abstract Factory Use Case:
 * You now want to support families of document components: each document type (PDF, Word, Excel) might have its
 * own parser, renderer, and metadata extractor. These components must be used together consistently per document format.
 *
 * Abstract Factory:
 *
 * DocumentFactory → createParser(), createRenderer(), createMetadataReader()
 *
 * PdfDocumentFactory, WordDocumentFactory, ExcelDocumentFactory
 *
 * Document type: PDF, WORD, EXCEL
 * Tools: parser, renderer, metadata extractor
 */

// interface
interface Document {
    void load();
}

interface Tools {
    void process();
}

// implementations
class PDF implements Document {
    @Override
    public void load() {
        System.out.print("Loading PDF document");
    }
}

class WORD implements Document {
    @Override
    public void load() {
        System.out.print("Loading WORD document");
    }
}

class EXCEL implements Document {
    @Override
    public void load() {
        System.out.print("Loading EXCEL document");
    }
}

class Parser implements Tools {
    @Override
    public void process() {
        System.out.println(" and parsing the file");
    }
}

class Renderer implements Tools {
    @Override
    public void process() {
        System.out.println(" and rendering the file");
    }
}

class MetadataExtractor implements Tools {
    @Override
    public void process() {
        System.out.println(" and extracting the metadata from the file");
    }
}

interface DocumentProcessor {
    Document loadDocument();
    Tools processDocument(String type);
}

class ToolsFactory {

    public static Tools getTool(String type) {
        if (type.equalsIgnoreCase("Parser")) {
            return new Parser();
        } else if (type.equalsIgnoreCase("Renderer")) {
            return new Renderer();
        } else if (type.equalsIgnoreCase("MetadataExtractor")) {
            return new MetadataExtractor();
        }
        throw new IllegalArgumentException("Unsupported tool: " + type);
    }
}

class PdfDocumentFactory implements DocumentProcessor {
    @Override
    public Document loadDocument() {
        return new PDF();
    }

    @Override
    public Tools processDocument(String type) {
        return ToolsFactory.getTool(type);
    }
}

class ExcelDocumentFactory implements DocumentProcessor {
    @Override
    public Document loadDocument() {
        return new EXCEL();
    }

    @Override
    public Tools processDocument(String type) {
        return ToolsFactory.getTool(type);
    }
}

class WordDocumentFactory implements DocumentProcessor {
    @Override
    public Document loadDocument() {
        return new WORD();
    }

    @Override
    public Tools processDocument(String type) {
        return ToolsFactory.getTool(type);
    }
}

class DocumentEditorService {

    private final Document document;
    private final Tools tool;

    public DocumentEditorService(DocumentProcessor processor, String tool) {
        this.document = processor.loadDocument();
        this.tool = processor.processDocument(tool);
    }

    public void process() {
        this.document.load();
        this.tool.process();;
    }
}

public class DocumentEditorPlugin {

    public static void main(String[] args) {
        DocumentEditorService pdf = new DocumentEditorService(new PdfDocumentFactory(), "parser");
        DocumentEditorService word = new DocumentEditorService(new WordDocumentFactory(), "parser");
        DocumentEditorService excel = new DocumentEditorService(new ExcelDocumentFactory(), "parser");
        DocumentEditorService excel1 = new DocumentEditorService(new ExcelDocumentFactory(), "Renderer");
        pdf.process();
        word.process();
        excel.process();
        excel1.process();
    }
}
