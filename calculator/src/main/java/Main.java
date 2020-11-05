import classmetrics.ClassMetricsCalculator;
import classmetrics.ClassMetricsCalculatorImpl;
import classpathmanageradapter.ClassPathManagerAdapter;
import classpathmanageradapter.ClassPathManagerAdapterImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.MetricsResultsDto;
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

    static {
        classPathManagerAdapter = new ClassPathManagerAdapterImpl();
        classMetricsCalculator = new ClassMetricsCalculatorImpl();
        fileMetricsCalculator = new FileMetricsCalculatorImpl();
    }

    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String pathToBin = "../shopping/bin";

//                "C:\\Users\\jvari\\ProjectsJ\\SE433\\poc\\build\\classes\\java\\main";
        classPathManagerAdapter.loadClasses(pathToBin);
        List<Class<?>> loadedClasses = classPathManagerAdapter.getClasses();

        MetricsResultsDto metricsResultsDto = classMetricsCalculator.calculate(loadedClasses);
        String results = gson.toJson(metricsResultsDto, MetricsResultsDto.class);

        saveResultsToFile(metricsResultsDto, "../results.json");

        System.out.println(results);
    }

    public static MetricsResultsDto combineMetrics(MetricsResultsDto classMetrics, FileMetricsDto fileMetricsDto) {
        MetricsResultsDto metricsResultsDto = new MetricsResultsDto();
        return metricsResultsDto;
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
