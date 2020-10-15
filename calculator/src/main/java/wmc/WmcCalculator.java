package wmc;

import dto.classsummary.wmc.WmcMetricsDto;

public interface WmcCalculator {
   WmcMetricsDto calculate(Class classToAnalyze);
}
