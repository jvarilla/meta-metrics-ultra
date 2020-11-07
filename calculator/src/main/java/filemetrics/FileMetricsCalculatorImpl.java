package filemetrics;

import filemetrics.tokens.CommentTokens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FileMetricsCalculatorImpl implements FileMetricsCalculator {
    Stack<CommentTokens> commentTokens;

    public FileMetricsCalculatorImpl() {
        commentTokens = new Stack<>();
    }

    @Override
    public FileMetricsDto calculate(List<File> files) {
        FileMetricsDto fileMetricsDto = new FileMetricsDto();
        fileMetricsDto.setNumberOfFiles(files.size());

        int loc = 0;
        for (File file: files) {
            loc += this.calculateLoc(file);
        }

        fileMetricsDto.setLoc(loc);

        return fileMetricsDto;
    }

    @Override
    public int calculateLoc(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int loc = 0;

            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine().trim();

                if (!isEmptyLine(currentLine)
                        && !isSingleLineComment(currentLine)
                        && !isInMultiLineComment(currentLine)) {
                    loc++;
                }
            }

            return loc;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

    }

    private boolean isEmptyLine(String line) {
        return line.length() == 0;
    }

    private boolean isSingleLineComment(String line) {
        return line.indexOf(CommentTokens.LINE_START.toString()) == 0;
    }

    private boolean isInMultiLineComment(String currentLine) {
        if (isStartOfBlockComment(currentLine)) {
            commentTokens.push(CommentTokens.BLOCK_START);
        } else if (isEndOfBlockComment(currentLine)) {
            if (commentTokens.peek().equals(CommentTokens.BLOCK_START)) {
                commentTokens.pop();
                return true;
            } else {
                commentTokens.push(CommentTokens.BLOCK_END);
            }
        } else if (isStartOfJavadocComment(currentLine)) {
            commentTokens.push(CommentTokens.JAVADOC_START);
        } else if (isEndOfJavadocComment(currentLine)) {
            if (commentTokens.peek().equals(CommentTokens.JAVADOC_START)) {
                commentTokens.pop();
                return true;
            } else {
                commentTokens.push(CommentTokens.JAVADOC_END);
            }
        }

        return !(commentTokens.isEmpty());
    }

    private boolean isStartOfBlockComment(String line) {
        return line.indexOf(CommentTokens.BLOCK_START.toString()) == 0;
    }

    private boolean isEndOfBlockComment(String line) {
        return line.indexOf(CommentTokens.BLOCK_END.toString()) == 0;
    }

    private boolean isStartOfJavadocComment(String line) {
        return line.indexOf(CommentTokens.JAVADOC_START.toString()) == 0;
    }

    private boolean isEndOfJavadocComment(String line) {
        return line.indexOf(CommentTokens.JAVADOC_END.toString()) == 0;
    }

}
