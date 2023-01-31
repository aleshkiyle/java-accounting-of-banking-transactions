package com.rodin.chapter04;

import java.io.File;
import java.io.IOException;

@FunctionalInterface
public interface Importer {

    Document importFile(File file) throws IOException;
}
