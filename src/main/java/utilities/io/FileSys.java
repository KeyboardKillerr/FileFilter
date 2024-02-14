package utilities.io;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import utilities.errorhandler.ErrorHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileSys {
    private final Collection<String> inputFiles;
    private final String integersOutputFile;
    private final String stringsOutputFile;
    private final String doublesOutputFile;
    private final ErrorHandler errorHandler;


    public FileSys(
            @NotNull Collection<String> inputFiles,
            @NotNull String outputDir,
            @NotNull String filenamePrefix,
            @NotNull ErrorHandler errorHandler
    ) {
        this.errorHandler = errorHandler;
        this.inputFiles = new ArrayList<>(inputFiles);
        if (!outputDir.endsWith("\\")) outputDir += '\\';
        integersOutputFile = outputDir + filenamePrefix + "integers.txt";
        stringsOutputFile = outputDir + filenamePrefix + "strings.txt";
        doublesOutputFile = outputDir + filenamePrefix + "floats.txt";
    }

    public void writeOverStrings(@NotNull Collection<String> content) {
        writeOver(content, stringsOutputFile);
    }

    public void appendToStrings(@NotNull Collection<String> content) {
        append(content, stringsOutputFile);
    }

    public void writeOverIntegers(@NotNull Collection<Integer> content) {
        writeOver(content, integersOutputFile);
    }

    public void appendToIntegers(@NotNull Collection<Integer> content) {
        append(content, integersOutputFile);
    }

    public void writeOverDoubles(@NotNull Collection<Double> content) {
        writeOver(content, doublesOutputFile);
    }

    public void appendToDoubles(@NotNull Collection<Double> content) {
        append(content, doublesOutputFile);
    }

    private void writeOver(@NotNull Collection<?> content, @NotNull String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (var line : content) {
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            errorHandler.Handle(e);
        }
    }

    private void append(@NotNull Collection<?> content, @NotNull String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (var line : content) {
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            errorHandler.Handle(e);
        }
    }

    @NotNull
    public Collection<String> readAll() {
        Collection<String> result = new ArrayList<>();
        for (var file : inputFiles) result.addAll(readFile(file));
        return result;
    }

    @NotNull
    private Collection<String> readFile(String file) {
        Collection<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) result.add(line);
        } catch (IOException e) {
            errorHandler.Handle(e);
        }
        return result;
    }
}
