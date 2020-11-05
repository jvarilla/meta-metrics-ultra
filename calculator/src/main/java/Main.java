import classloading.ClassManager;
import classmetrics.ClassMetricsCalculator;
import classmetrics.ClassMetricsCalculatorImpl;
import classpathmanageradapter.ClassPathManagerAdapter;
import classpathmanageradapter.ClassPathManagerAdapterImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.MetricsResultsDto;
import dto.classsummary.ClassSummaryDto;
import filemetrics.FileMetricsCalculator;
import filemetrics.FileMetricsCalculatorImpl;
import filemetrics.FileMetricsDto;

import java.io.IOException;
import java.util.List;

public class Main {
    private static ClassPathManagerAdapter classPathManagerAdapter;
    private static ClassMetricsCalculator classMetricsCalculator;
    private static FileMetricsCalculator fileMetricsCalculator;

    private static ClassManager classManager;

    static {
        classPathManagerAdapter = new ClassPathManagerAdapterImpl();
        classMetricsCalculator = new ClassMetricsCalculatorImpl();
        fileMetricsCalculator = new FileMetricsCalculatorImpl();
    }

    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String pathToBin = "C:\\Users\\jvari\\ProjectsJ\\SE433\\poc\\build\\classes\\java\\main";
        classPathManagerAdapter.loadClasses(pathToBin);
        List<Class<?>> loadedClasses = classPathManagerAdapter.getClasses();

        MetricsResultsDto metricsResultsDto = classMetricsCalculator.calculate(loadedClasses);
        String results = gson.toJson(metricsResultsDto, MetricsResultsDto.class);

        System.out.println(results);
    }

    public MetricsResultsDto combineMetrics(MetricsResultsDto classMetrics, FileMetricsDto fileMetricsDto) {
        MetricsResultsDto metricsResultsDto = new MetricsResultsDto();
        return metricsResultsDto;
    }

    public boolean saveResultsToFile(MetricsResultsDto metricsResults, String targetSaveLocation) {
        return true;
    }

}
