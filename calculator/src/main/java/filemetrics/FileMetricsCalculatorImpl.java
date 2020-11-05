package filemetrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class FileMetricsCalculatorImpl implements FileMetricsCalculator {
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
                if (scanner.nextLine().trim().length() > 0) {
                    // May want to do checks for comments
                    loc++;
                }
            }

            return loc;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

    }
}
