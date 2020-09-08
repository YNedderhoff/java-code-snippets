package xyz.nedderhoff.javacodesnippets.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

import com.google.common.io.CharStreams;

public class JsonReader {
    public String read(String pathToFile) {
        return asString(pathToFile)
                .replaceAll("\\n", "")
                .replaceAll(" {4}| {2}", "")
                .replaceAll(": ", ":");
    }

    private String asString(String pathToFile) {
        try (Reader input = new InputStreamReader(new FileInputStream(readFileFromPath(pathToFile)))) {
            return CharStreams.toString(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File readFileFromPath(String pathToFile) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(pathToFile)).getFile());
    }
}
