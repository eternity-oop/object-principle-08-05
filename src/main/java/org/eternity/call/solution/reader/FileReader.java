package org.eternity.call.solution.reader;

import org.eternity.call.solution.calls.AbstractReader;
import org.eternity.call.solution.calls.Parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader extends AbstractReader {
    public FileReader(String path, Parser parser) {
        super(path, parser);
    }

    @Override
    protected List<String> readLines(String path) {
        try {
            return Files.readAllLines(Path.of(ClassLoader.getSystemResource(path).toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
