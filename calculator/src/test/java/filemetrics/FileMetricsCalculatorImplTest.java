package filemetrics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("File Metrics Calculator")
class FileMetricsCalculatorImplTest {
    private FileMetricsCalculator fileMetricsCalculator;

    @BeforeEach
    void setUp() {
        this.fileMetricsCalculator = new FileMetricsCalculatorImpl();
    }

    @Test
    @DisplayName("Should calculate file metrics for file with one line of non-blank line and no comments")
    void calculateFileWithOneFullLineNoComments() {
        ClassLoader classLoader = getClass().getClassLoader();
        File classWithOneFullLineAndNoComments = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithOneFullLineAndNoComments.java"))
                        .getFile());
        List<File> files = Arrays.asList(classWithOneFullLineAndNoComments);

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(1, fileMetricsDto.getNumberOfFiles());
        assertEquals(1, fileMetricsDto.getLoc());
    }

    @Test
    @DisplayName("Should not count blank lines as part of loc")
    void calculateFileWithTwoFullLinesAndOneEmptyLine() {
        ClassLoader classLoader = getClass().getClassLoader();
        File classWithTwoFullLinesAndOneEmptyLine = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneEmptyLine.java"))
                        .getFile());
        List<File> files = Arrays.asList(classWithTwoFullLinesAndOneEmptyLine);

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(1, fileMetricsDto.getNumberOfFiles());
        assertEquals(2, fileMetricsDto.getLoc());
    }

    @Test
    @DisplayName("Should not count inline comments as part of loc")
    void calculateFileWithTwoFullLinesAndOneInlineComment() {
        ClassLoader classLoader = getClass().getClassLoader();
        File classWithTwoFullLinesAndOneInlineComment = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneInlineComment.java"))
                        .getFile());
        List<File> files = Arrays.asList(classWithTwoFullLinesAndOneInlineComment);

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(1, fileMetricsDto.getNumberOfFiles());
        assertEquals(2, fileMetricsDto.getLoc());
    }

    @Test
    @DisplayName("Should not count block comments as part of loc")
    void calculateFileWithTwoFullLinesAndOneBlockComment() {
        ClassLoader classLoader = getClass().getClassLoader();
        File classWithTwoFullLinesAndOneBlockComment = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneBlockComment.java"))
                        .getFile());
        List<File> files = Arrays.asList(classWithTwoFullLinesAndOneBlockComment);

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(1, fileMetricsDto.getNumberOfFiles());
        assertEquals(2, fileMetricsDto.getLoc());
    }

    @Test
    @DisplayName("Should not count javadoc comments as part of loc")
    void calculateFileWithTwoFullLinesAndOneJavadocComment() {
        ClassLoader classLoader = getClass().getClassLoader();
        File classWithTwoFullLinesAndOneJavadocComment = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneJavadocComment.java"))
                        .getFile());
        List<File> files = Arrays.asList(classWithTwoFullLinesAndOneJavadocComment);

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(1, fileMetricsDto.getNumberOfFiles());
        assertEquals(2, fileMetricsDto.getLoc());
    }

    @Test
    @DisplayName("Should calculate loc for a list of files")
    void calculateForListOfFiles() {
        ClassLoader classLoader = getClass().getClassLoader();
        File classWithTwoFullLinesAndOneInlineComment = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneInlineComment.java"))
                        .getFile());
        File classWithTwoFullLinesAndOneBlockComment = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneBlockComment.java"))
                        .getFile());
        File classWithTwoFullLinesAndOneJavadocComment = new File(
                Objects.requireNonNull(classLoader.getResource(
                        "filemetrics/testclasses/ClassWithTwoFullLinesAndOneJavadocComment.java"))
                        .getFile());

        List<File> files = Arrays.asList(classWithTwoFullLinesAndOneInlineComment,
                                         classWithTwoFullLinesAndOneBlockComment,
                                         classWithTwoFullLinesAndOneJavadocComment);

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(3, fileMetricsDto.getNumberOfFiles());
        assertEquals(6, fileMetricsDto.getLoc());
    }


    @Test
    @DisplayName("Should calculate loc for empty list of files")
    void calculateForEmptyListOfFiles() {
        ClassLoader classLoader = getClass().getClassLoader();

        List<File> files = Collections.emptyList();

        FileMetricsDto fileMetricsDto = this.fileMetricsCalculator.calculate(files);

        assertEquals(0, fileMetricsDto.getNumberOfFiles());
        assertEquals(0, fileMetricsDto.getLoc());
    }

}