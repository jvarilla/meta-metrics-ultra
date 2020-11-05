package fileloader;

import java.io.File;
import java.util.List;

public interface FileLoader {
    boolean loadFiles(String path);
    List<File> getFiles();
}
