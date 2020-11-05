import aggregatemetrics.SummaryDto;
import classmetrics.ClassMetricsCalculator;
import classmetrics.ClassMetricsCalculatorImpl;
import classpathmanageradapter.ClassPathManagerAdapter;
import classpathmanageradapter.ClassPathManagerAdapterImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.MetricsResultsDto;
import fileloader.FileLoader;
import fileloader.FileLoaderImpl;
import filemetrics.FileMetricsCalculator;
import filemetrics.FileMetricsCalculatorImpl;
import filemetrics.FileMetricsDto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Main {
    private static ClassPathManagerAdapter classPathManagerAdapter;
    private static ClassMetricsCalculator classMetricsCalculator;
    private static FileMetricsCalculator fileMetricsCalculator;
    private static FileLoader fileLoader;
    static {
        classPathManagerAdapter = new ClassPathManagerAdapterImpl();
        classMetricsCalculator = new ClassMetricsCalculatorImpl();
        fileMetricsCalculator = new FileMetricsCalculatorImpl();
        fileLoader = new FileLoaderImpl();
    }

    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String pathToBin = "../shopping/bin";
        String pathToSrc = "../shopping/src";

//                "C:\\Users\\jvari\\ProjectsJ\\SE433\\poc\\build\\classes\\java\\main";
        classPathManagerAdapter.loadClasses(pathToBin);
        List<Class<?>> loadedClasses = classPathManagerAdapter.getClasses();

        fileLoader.loadFiles(pathToSrc);
        List<File> javaSrcFiles = fileLoader.getFiles();

        FileMetricsDto fileMetricsDto = fileMetricsCalculator.calculate(javaSrcFiles);
        MetricsResultsDto metricsResultsDto = classMetricsCalculator.calculate(loadedClasses);

        MetricsResultsDto totalMetrics = combineMetrics(metricsResultsDto, fileMetricsDto);
        totalMetrics.getSummary().setPathToBin(pathToBin);
        totalMetrics.getSummary().setPathToSrc(pathToSrc);


        String results = gson.toJson(totalMetrics, MetricsResultsDto.class);

        saveResultsToFile(metricsResultsDto, "../results.json");

        System.out.println(results);
    }

    public static MetricsResultsDto combineMetrics(MetricsResultsDto classMetrics, FileMetricsDto fileMetricsDto) {
        SummaryDto updatedSummary = classMetrics.getSummary();
        updatedSummary.setLoc(fileMetricsDto.getLoc());
        updatedSummary.setNumberOfFiles(fileMetricsDto.getNumberOfFiles());
        classMetrics.setSummary(updatedSummary);
        return classMetrics;
    }

    public static boolean saveResultsToFile(MetricsResultsDto metricsResultsDto, String targetSaveLocation) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        File resultsFile = new File(targetSaveLocation);
        try {
            resultsFile.createNewFile();
            FileWriter fileWriter = new FileWriter(resultsFile);
            String results = gson.toJson(metricsResultsDto, MetricsResultsDto.class);

            fileWriter.write(results);
            fileWriter.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
