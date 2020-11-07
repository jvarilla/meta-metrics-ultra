package fileloader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.FileSystem;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("File Loader")
class FileLoaderImplTest {
    private FileLoader fileLoader;

    @BeforeEach
    void setUp() {
        this.fileLoader = new FileLoaderImpl();
    }

    @Test
    @DisplayName("Should only load java files")
    void loadOnlyJavaFiles() {
        ClassLoader classLoader = getClass().getClassLoader();
        String pathToTestFiles = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "fileloader/testclasses/"))
                        .getFile()).getPath();

        boolean statusOfLoadingFiles = fileLoader.loadFiles(pathToTestFiles);
        List<File> loadedFiles = fileLoader.getFiles();
        List<String> loadedFileNames = loadedFiles.stream().map(File::getName).collect(Collectors.toList());

        assertTrue(statusOfLoadingFiles);
        assertEquals(5, loadedFiles.size());

        assertTrue(loadedFileNames.contains("TestClass1.java"));
        assertTrue(loadedFileNames.contains("TestClass2.java"));
        assertTrue(loadedFileNames.contains("TestClass3.java"));
        assertTrue(loadedFileNames.contains("Interface1.java"));
        assertTrue(loadedFileNames.contains("Enum1.java"));

        assertFalse(loadedFileNames.contains("JavaScriptFile.js"));
        assertFalse(loadedFileNames.contains("HtmlFile.html"));

    }

    @Test
    @DisplayName("Should load no files if directory is empty")
    void loadNoFilesIfDirectoryIsEmpty() {
        ClassLoader classLoader = getClass().getClassLoader();
        String pathToTestFiles = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "fileloader/testclasses/emptydirectory"))
                        .getFile()).getPath();

        boolean statusOfLoadingFiles = fileLoader.loadFiles(pathToTestFiles);
        List<File> loadedFiles = fileLoader.getFiles();
        List<String> loadedFileNames = loadedFiles.stream().map(File::getName).collect(Collectors.toList());

        assertTrue(statusOfLoadingFiles);
        assertEquals(0, loadedFiles.size());
    }

    @Test
    @DisplayName("Should return status of 0 if there is an error loading the files")
    void loadFilesError() {
        ClassLoader classLoader = getClass().getClassLoader();
        String pathToTestFiles = "d:/$InvalidFile_  323 Name ---!!!";

        boolean statusOfLoadingFiles = fileLoader.loadFiles(pathToTestFiles);
        List<File> loadedFiles = fileLoader.getFiles();
        List<String> loadedFileNames = loadedFiles.stream().map(File::getName).collect(Collectors.toList());

        assertFalse(statusOfLoadingFiles);
        assertEquals(0, loadedFiles.size());
    }
}