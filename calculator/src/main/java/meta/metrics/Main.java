package meta.metrics;

import meta.metrics.aggregatemetrics.SummaryDto;
import meta.metrics.classmetrics.ClassMetricsCalculator;
import meta.metrics.classmetrics.ClassMetricsCalculatorImpl;
import meta.metrics.classpathmanageradapter.ClassPathManagerAdapter;
import meta.metrics.classpathmanageradapter.ClassPathManagerAdapterImpl;
import meta.metrics.fileloader.FileLoader;
import meta.metrics.fileloader.FileLoaderImpl;
import meta.metrics.filemetrics.FileMetricsCalculator;
import meta.metrics.filemetrics.FileMetricsCalculatorImpl;
import meta.metrics.filemetrics.FileMetricsDto;
import meta.metrics.menu.MenuDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import meta.metrics.dto.MetricsResultsDto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String DEFAULT_RESULT_FILE_PATH = "../results.json";

    private static ClassPathManagerAdapter classPathManagerAdapter;
    private static ClassMetricsCalculator classMetricsCalculator;
    private static FileMetricsCalculator fileMetricsCalculator;
    private static FileLoader fileLoader;
    private static GsonBuilder gsonBuilder;
    private static Gson gson;
    private static String pathToBin;
    private static String pathToSrc;
    private static MenuDialog menuDialog;
    private static String resultsSaveFilePath;

    static {
        classPathManagerAdapter = new ClassPathManagerAdapterImpl();
        classMetricsCalculator = new ClassMetricsCalculatorImpl();
        fileMetricsCalculator = new FileMetricsCalculatorImpl();
        fileLoader = new FileLoaderImpl();
        gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gson = gsonBuilder.create();
        menuDialog = new MenuDialog(System.in, System.out);
    }

    public static void main(String[] args) {
        try {
            resultsSaveFilePath = getResultsSaveFilePath(args);

            menuDialog.startMenuDialog();
            pathToSrc = menuDialog.waitForResponse("Path to src");
            pathToBin = menuDialog.waitForResponse("Path to bin");

            FileMetricsDto fileMetricsDto = calculateFileMetricsResults(pathToSrc);
            MetricsResultsDto metricsResultsDto = calculateClassMetricsResults(pathToBin);
            MetricsResultsDto finalResults = combineMetrics(metricsResultsDto, fileMetricsDto,
                    pathToSrc,pathToBin);

            saveResultsToFile(finalResults, resultsSaveFilePath);

            menuDialog.endMenuDialog(new File(resultsSaveFilePath).getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Sorry! Something went wrong :(");
        }
    }

    private static String getResultsSaveFilePath(String[] args) {
        if (args.length > 0) {
            return args[0];
        }

        return DEFAULT_RESULT_FILE_PATH;
    }

    private static FileMetricsDto calculateFileMetricsResults(String pathToSrc) {
        fileLoader.loadFiles(pathToSrc);
        List<File> javaSrcFiles = fileLoader.getFiles();
        FileMetricsDto fileMetricsDto = fileMetricsCalculator.calculate(javaSrcFiles);
        return fileMetricsDto;
    }

    private static MetricsResultsDto calculateClassMetricsResults(String pathToBin) {
        classPathManagerAdapter.loadClasses(pathToBin);
        List<Class<?>> loadedClasses = classPathManagerAdapter.getClasses();
        MetricsResultsDto metricsResultsDto = classMetricsCalculator.calculate(loadedClasses);

        return metricsResultsDto;
    }

    private static MetricsResultsDto combineMetrics(MetricsResultsDto classMetrics,
                    FileMetricsDto fileMetricsDto, String pathToSrc, String pathToBin) {
        SummaryDto updatedSummary = classMetrics.getSummary();
        updatedSummary.setLoc(fileMetricsDto.getLoc());
        updatedSummary.setNumberOfFiles(fileMetricsDto.getNumberOfFiles());
        classMetrics.setSummary(updatedSummary);

        updatedSummary.setPathToBin(new File(pathToBin).getAbsolutePath());
        updatedSummary.setPathToSrc(new File(pathToSrc).getAbsolutePath());

        return classMetrics;
    }

    private static void saveResultsToFile(MetricsResultsDto metricsResultsDto, String targetSaveLocation) {
        File resultsFile = new File(targetSaveLocation);
        try {
            resultsFile.createNewFile();
            try (FileWriter fileWriter = new FileWriter(resultsFile)) {
                String results = gson.toJson(metricsResultsDto, MetricsResultsDto.class);

                fileWriter.write(results);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
