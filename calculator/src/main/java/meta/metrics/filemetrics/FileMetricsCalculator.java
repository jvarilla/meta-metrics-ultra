package meta.metrics.filemetrics;

import java.io.File;
import java.util.List;

public interface FileMetricsCalculator {
    FileMetricsDto calculate(List<File> files);
    int calculateLoc(File file);
}
