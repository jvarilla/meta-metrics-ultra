package meta.metrics.fileloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileLoaderImpl implements FileLoader {
    private List<File> files;

    public FileLoaderImpl() {
        files = new ArrayList<File>();
    }

    @Override
    public boolean loadFiles(String path) {
        try {
            this.files = Files.walk(Paths.get(path)).filter(Files::isRegularFile).map(Path::toFile).filter(file -> {
                return file.getName().contains(".java");
            }).collect(Collectors.toList());

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<File> getFiles() {
        return files;
    }
}
