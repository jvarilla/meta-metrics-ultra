package meta.metrics.wmc;

public interface WmcCalculator {
   WmcMetricsDto calculate(Class classToAnalyze);
}
