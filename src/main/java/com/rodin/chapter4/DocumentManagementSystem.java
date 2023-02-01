package com.rodin.chapter4;

import java.util.*;

public class DocumentManagementSystem {

    private final List<Document> documents = new ArrayList<>();

    private final List<Document> documentsView = Collections.unmodifiableList(documents);

    private final Map<String, Importer> extensionImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionImporter.put("letter", new LetterImporter());
        extensionImporter.put("reporter", new ReportImporter());
        extensionImporter.put("jpg", new ImageImporter());
    }

}
